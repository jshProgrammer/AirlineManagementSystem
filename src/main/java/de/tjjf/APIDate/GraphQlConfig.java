package de.tjjf.APIDate;

import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQlConfig {

    @Bean
    public GraphQLScalarType dateScalar(){
        return DateScalar.DATE;
    }

    @Bean
    public GraphQLScalarType longScalar(){
        return LongScalar.LONG;
    }
}
