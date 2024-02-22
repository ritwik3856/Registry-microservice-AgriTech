package com.ninjacart.agri.advisory.crop.rsql.generator;

import com.ninjacart.agri.advisory.crop.rsql.evaluator.ConditionEvaluator;
import com.ninjacart.agri.advisory.crop.rsql.evaluator.StringConditionEvaluator;
import cz.jirutka.rsql.parser.ast.ComparisonNode;
import org.jooq.Condition;
import org.jooq.Field;

public class StringConditionGenerator implements ConditionGenerator<Field<String>>{

    private final ConditionEvaluator<String> stringConditionEvaluator = new StringConditionEvaluator<>();

    @Override
    public Condition generate(Field<String> field, ComparisonNode node) {
        return stringConditionEvaluator.evaluate(field, node.getArguments(), node.getOperator());
    }
}
