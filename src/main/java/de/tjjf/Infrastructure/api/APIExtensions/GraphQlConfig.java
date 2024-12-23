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
        return ExtendedScalars.Date; // Nur Datum
    }
    @Bean
    public GraphQLScalarType dateTimeScalar() {
        return ExtendedScalars.DateTime; // Datum und Zeit
    }

    @Bean
    public GraphQLScalarType timeScalar() {
        return ExtendedScalars.Time; // Nur Zeit
    }

    @Bean
    public GraphQLScalarType voidScalar() {
        return GraphQLScalarType.newScalar()
                .name("Void")
                .description("A custom scalar that represents no value")
                .coercing(new Coercing<Object, Object>() {
                    @Override
                    public Object serialize(Object dataFetcherResult) {
                        return null; // Immer `null` als Ausgabe
                    }

                    @Override
                    public Object parseValue(Object input) {
                        return null; // Keine Eingabewerte erforderlich
                    }

                    @Override
                    public Object parseLiteral(Object input) {
                        return null; // Keine Literalverarbeitung erforderlich
                    }
                })
                .build();
    }
}
