package ua.od.atomspace.v3.конфігурація;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ФабрикаЕкземплярів {


    private ФабрикаЕкземплярів() {
    }

    @SneakyThrows
    public <T> T взятиЕкземпляр(Class<T> type) {
        Class<?> одинак = Arrays.stream(type.getDeclaredClasses())
                .filter(clazz -> clazz.getSimpleName().equals("Одинак"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не має одинака"));

        Method взятиЕкзкмпляр = одинак.getMethod("взятиЕкзкмпляр");
        return (T) взятиЕкзкмпляр.invoke(одинак);
    }

    public static class Одинак {
        private static ФабрикаЕкземплярів фабрикаЕкземплярів;

        public static ФабрикаЕкземплярів взятиЕкзкмпляр() {
            if (фабрикаЕкземплярів != null) {
                return фабрикаЕкземплярів;
            }
            фабрикаЕкземплярів = new ФабрикаЕкземплярів();
            return фабрикаЕкземплярів;
        }
    }
}
