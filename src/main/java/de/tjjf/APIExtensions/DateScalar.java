package de.tjjf.APIExtensions;
import graphql.language.StringValue;
import graphql.schema.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateScalar  {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static final GraphQLScalarType DATE = GraphQLScalarType.newScalar()
            .name("Date")
            .description("Custom Date scalar")
            .coercing(new Coercing<Date, String>() {
                @Override
                public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                    if (dataFetcherResult instanceof Date) {
                        return dateFormat.format((Date) dataFetcherResult);
                    }
                    throw new CoercingSerializeException("Expected a Date Object");
                }

                @Override
                public Date parseValue(Object input) throws CoercingParseValueException {
                    try {
                        if (input instanceof String) {
                            return dateFormat.parse((String) input);
                        }
                        throw new CoercingParseValueException("Expected a String");
                    } catch (ParseException e) {
                        throw new CoercingParseValueException("Invalid Date Format");
                    }
                }

                @Override
                public Date parseLiteral(Object input) throws CoercingParseLiteralException {
                    if (input instanceof StringValue) {
                        try {
                            return dateFormat.parse(((StringValue) input).getValue());
                        } catch (ParseException e) {
                            throw new CoercingParseLiteralException("Invalid Date Format");
                        }
                    }
                    throw new CoercingParseLiteralException("Expected a String Value");
                }
            })
            .build();
}
