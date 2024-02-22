package com.ninjacart.agri.advisory.crop.rsql;

import com.ninjacart.agri.advisory.crop.context.TableContext;
import com.ninjacart.agri.advisory.crop.rsql.generator.ConditionGenerator;
import com.ninjacart.agri.advisory.crop.rsql.generator.ConditionGeneratorContext;
import cz.jirutka.rsql.parser.ast.*;
import org.jooq.Condition;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static org.jooq.impl.DSL.noCondition;

@Component
public class JooqRSQLVisitor implements RSQLVisitor<Condition, TableContext> {

    private static final Condition NO_CONDITION = noCondition();

    private final ConditionGeneratorContext conditionGeneratorContext;

    @Autowired
    public JooqRSQLVisitor(ConditionGeneratorContext conditionGeneratorContext) {
        this.conditionGeneratorContext = conditionGeneratorContext;
    }

    @Override
    public Condition visit(AndNode node, TableContext tableContext) {
        List<Condition> sqlConditions = getSQLConditions(node.getChildren(), tableContext);
        return joinSQLConditions(sqlConditions, Condition::and);
    }

    @Override
    public Condition visit(OrNode node, TableContext tableContext) {
        List<Condition> sqlConditions = getSQLConditions(node.getChildren(), tableContext);
        return joinSQLConditions(sqlConditions, Condition::or);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Condition visit(ComparisonNode node, TableContext tableContext) {
        Map<String, Field> filters = tableContext.getFilters();
        Field field = filters.get(node.getSelector());
        if (field != null) {
            ConditionGenerator conditionGenerator = conditionGeneratorContext.getConditionGenerator(field);
            return conditionGenerator.generate(field, node);
        }
        return NO_CONDITION;
    }

    public Condition joinSQLConditions(
            List<Condition> conditions, BinaryOperator<Condition> conditionalOperator) {
        if (conditions.stream().allMatch(NO_CONDITION::equals)) {
            return NO_CONDITION;
        }
        return conditions
                .stream()
                .reduce(NO_CONDITION, conditionalOperator);
    }

    private List<Condition> getSQLConditions(List<Node> children, TableContext tableContext) {
        return children
                .stream()
                .map(node -> node.accept(this, tableContext))
                .collect(Collectors.toList());
    }
}
