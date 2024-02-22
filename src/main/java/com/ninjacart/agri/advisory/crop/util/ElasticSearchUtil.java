package com.ninjacart.agri.advisory.crop.util;

import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.ExistsQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.ninjacart.agri.advisory.crop.annotation.UDI;
import lombok.val;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ElasticSearchUtil {

    public static Supplier<Query> supplierExistsQuery(Class<?> clazz) {
        return () -> Query.of(q -> q.bool(boolExistsQuery(clazz)));
    }

    public static BoolQuery boolExistsQuery(Class<?> clazz) {
        BoolQuery.Builder boolQuery = new BoolQuery.Builder();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(UDI.class)) {
                boolQuery.should(existsQuery(field.getName()));
            }
        }
        return boolQuery.minimumShouldMatch(String.valueOf(1)).build();
    }

    public static List<Query> existsQuery(String fieldName) {
        List<Query> existsQueries = new ArrayList<>();
        existsQueries.add(Query.of(q -> q.exists(new ExistsQuery.Builder().field(fieldName).build())));
        return existsQueries;
    }
}
