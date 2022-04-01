package ua.od.atomspace.v4_2.конфігурація;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ФабрикаЕкземплярів {


    private ФабрикаЕкземплярів() {
    }

    @SneakyThrows
    public <T> T взятиЕкземпляр(Class<T> type) {
        T одинак = взятиОдинака(type);

        НалаштовувачЕкземплярів налаштовувачЕкземплярів = new НалаштовувачЕкземплярів("ua.od.atomspace.v4_2");
        налаштовувачЕкземплярів.зробитиВсіНалаштовування(одинак);

        return одинак;
    }

    private <T> T взятиОдинака(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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
