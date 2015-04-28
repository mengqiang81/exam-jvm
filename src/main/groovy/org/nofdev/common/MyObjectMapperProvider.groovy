package org.nofdev.common

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

import javax.ws.rs.ext.ContextResolver
import javax.ws.rs.ext.Provider
/**
 * Created by Qiang on 3/9/15.
 */
@Provider
class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {
    final ObjectMapper defaultObjectMapper;

    public MyObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
    }

    @Override
    ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
//        result.enable(SerializationFeature.INDENT_OUTPUT);
        result.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        result.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)//忽略未知属性
        return result;
    }
}
