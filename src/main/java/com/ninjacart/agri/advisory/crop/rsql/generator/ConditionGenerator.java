package com.ninjacart.agri.advisory.crop.rsql.generator;

import cz.jirutka.rsql.parser.ast.ComparisonNode;
import org.jooq.Condition;

public interface ConditionGenerator<T> {

    Condition generate(T field, ComparisonNode node);
}
