package org.ifellow.gaidukov.IF_HW5;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class Mapper {

    @SneakyThrows
    public static <T> T readJsonFile(String path, Class<T> t) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), t);
    }
}
