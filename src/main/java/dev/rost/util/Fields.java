package dev.rost.util;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.reflect.FieldUtils;

@UtilityClass
@SuppressWarnings("unchecked")
public class Fields {

    @SneakyThrows
    public static <T> T get(Object target, String name) {
        return ((Class<T>) Object.class).cast(
                FieldUtils.readDeclaredField(target, name, true));
    }

    @SneakyThrows
    public static <T> T get(Object target, FieldDescription<T> fieldDesc) {
        return fieldDesc.type.cast(
                FieldUtils.readDeclaredField(target, fieldDesc.name, true));
    }


    @Value(staticConstructor = "of")
    public static class FieldDescription<T> {
        Class<T> type = (Class<T>) Object.class;
        String name;
    }
}
