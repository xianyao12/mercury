package com.galaxy.mercury.common.config.redis;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * TODO
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/6/14 19:21
 */
public class JodaDateTimeJsonDeSerializer extends JsonDeserializer<DateTime> {
    @Override
    public DateTime deserialize(@NotNull JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String s = p.readValueAs(String.class);
        return DateTime.of(s, "yyyy-MM-dd HH:mm:ss");
    }
}

