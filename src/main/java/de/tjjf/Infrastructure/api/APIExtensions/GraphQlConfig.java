package de.tjjf.Infrastructure.api.APIExtensions;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
