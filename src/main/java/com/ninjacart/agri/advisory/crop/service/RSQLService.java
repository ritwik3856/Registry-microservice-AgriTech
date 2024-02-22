package com.ninjacart.agri.advisory.crop.service;

import com.ninjacart.agri.advisory.crop.context.TableContext;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RSQLService {

    private final RSQLVisitor<Condition, TableContext> jooqRSQLVisitor;
    private final RSQLParser rsqlParser;

    @Autowired
    public RSQLService(RSQLVisitor<Condition, TableContext> jooqRSQLVisitor, RSQLParser rsqlParser) {
        this.jooqRSQLVisitor = jooqRSQLVisitor;
        this.rsqlParser = rsqlParser;}

    public Condition getSqlCondition(String filter, TableContext authorTableContext) {
        Node parsedFilter = rsqlParser.parse(filter);
        return parsedFilter.accept(jooqRSQLVisitor, authorTableContext);
    }
}
