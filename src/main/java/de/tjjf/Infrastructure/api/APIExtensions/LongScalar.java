package de.tjjf.Infrastructure.api.APIExtensions;

import graphql.language.IntValue;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

public class LongScalar {
    public static final GraphQLScalarType LONG = GraphQLScalarType.newScalar()
            .name("Long")
            .description("Custom Long Scalar Date Type for handling 64Bit integers")
            .coercing(new Coercing<Long, Long>() {
                @Override
                public Long serialize(Object dataFetcherResult){
                    if(dataFetcherResult instanceof Long){
                        return (Long) dataFetcherResult;
                    }
                    throw new CoercingSerializeException("Expected a Long Object");
                }

                @Override
                public Long parseValue(Object input){
                    if(input instanceof Number){
                        return ((Number) input).longValue();
                    }
                    if(input instanceof String) {
                        try {
                            return Long.parseLong((String) input);
                        }
                        catch (NumberFormatException e) {
                            throw new CoercingSerializeException("Invalid Long Value");
                        }
                    }
                    throw new CoercingSerializeException("Expected a Numeric Object");
                }

                @Override
                public Long parseLiteral(Object input){
                    if(input instanceof IntValue){
                        return ((IntValue) input).getValue().longValue();
                    }
                    if(input instanceof StringValue){
                        try{
                            return Long.parseLong(((StringValue) input).getValue());
                        }
                        catch (NumberFormatException e){
                            throw new CoercingSerializeException("Invalid Long Value");
                        }
                    }
                    throw new CoercingSerializeException("Expected an Int Value or String Value");
                }
            })
            .build();

}
