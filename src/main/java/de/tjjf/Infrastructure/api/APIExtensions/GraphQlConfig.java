package de.tjjf.Infrastructure.api.APIExtensions;

import graphql.scalars.ExtendedScalars;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GraphQlConfig {

    @Bean
    public GraphQLScalarType longScalar() {
           return ExtendedScalars.GraphQLLong;
    }
    @Bean
    public GraphQLScalarType dateScalar() {
        return ExtendedScalars.Date;
    }
    @Bean
    public GraphQLScalarType dateTimeScalar() {
        return ExtendedScalars.DateTime;
    }

    @Bean
    public GraphQLScalarType timeScalar() {
        return ExtendedScalars.Time;
    }

    @Bean
    public GraphQLScalarType voidScalar() {
        return GraphQLScalarType.newScalar()
                .name("Void")
                .description("A custom scalar that represents no value")
                .coercing(new Coercing<Object, Object>() {
                    @Override
                    public Object serialize(Object dataFetcherResult) {
                        return null;
                    }

                    @Override
                    public Object parseValue(Object input) {
                        return null;
                    }

                    @Override
                    public Object parseLiteral(Object input) {
                        return null;
                    }
                })
                .build();
    }
}
