package com.bookstore.config;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.boot.model.FunctionContributor;

public class SqlFunctionsMetadataBuilderContributor implements FunctionContributor {

    @Override
    public void contributeFunctions(FunctionContributions functionContributions) {
        var registry = functionContributions.getFunctionRegistry();
        var type = functionContributions
                .getTypeConfiguration()
                .standardBasicTypeForJavaType(String.class);

        // Supports variadic args (from 2 to N)
        registry.registerPattern("concat_ws", "concat_ws(?1, ?2, ?3, ?4)", type);
    }
}
