package com.ninjacart.agri.advisory.crop.rsql.generator;

import com.ninjacart.agri.advisory.crop.rsql.evaluator.ConditionEvaluator;
import com.ninjacart.agri.advisory.crop.rsql.evaluator.NumericConditionEvaluator;
import cz.jirutka.rsql.parser.ast.ComparisonNode;
import org.jooq.Condition;
import org.jooq.Field;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerConditionGenerator implements ConditionGenerator<Field<Integer>>{

    private final ConditionEvaluator<Integer> numericConditionEvaluator = new NumericConditionEvaluator<>();

    @Override
    public Condition generate(Field<Integer> field, ComparisonNode node) {
        List<String> arguments = node.getArguments();
        try {
            List<Integer> numbers = arguments
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numericConditionEvaluator.evaluate(field, numbers, node.getOperator());
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "Cannot parse the numbers: " + arguments.toString());
        }
    }
}
