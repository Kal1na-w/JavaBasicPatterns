package ua.od.atomspace.v5.конфігурація;

import lombok.SneakyThrows;
import ua.od.atomspace.v5.сервіс.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ФабрикаЕкземплярів {

    private final КонфігураціяЗалежностей конфігураціяЗалежностей;
    private final НалаштовувачЕкземплярів налаштовувачЕкземплярів;


    private ФабрикаЕкземплярів() {
        this.налаштовувачЕкземплярів = new НалаштовувачЕкземплярів("ua.od.atomspace.v5");
        this.конфігураціяЗалежностей = new КонфігураціяЗалежностей("ua.od.atomspace.v5", new HashMap<>(Map.of(
                Митниця.class, МитницяОдеси.class,
                МіграційнаСлужба.class, МіграційнаСлужбаУкраїни.class,
                ЧергаНаКордоні.class, ЧергаНаКордоніМолдови.class,
                МитнаПеревірка.class, ПаляничнаМитнаПеревірка.class
        )));
    }

    @SneakyThrows
    public <T> T взятиЕкземпляр(Class<T> type) {
        Class<? extends T> реалізація = type;
        if (type.isInterface()) {
            реалізація = конфігураціяЗалежностей.взятиЗалежність(type);
        }
        T одинак = взятиОдинака(реалізація);

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
