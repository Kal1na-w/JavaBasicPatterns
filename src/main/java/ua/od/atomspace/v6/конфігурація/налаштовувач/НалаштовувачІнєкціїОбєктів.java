package ua.od.atomspace.v6.конфігурація.налаштовувач;

import ua.od.atomspace.v6.конфігурація.Контекст;
import ua.od.atomspace.v6.конфігурація.анотація.Інєкція;

import java.util.Arrays;

public class НалаштовувачІнєкціїОбєктів implements Налаштовувач {
    @Override
    public <T> void налаштувати(T t, Контекст контекст) {
        Arrays.stream(t.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotation(Інєкція.class) != null)
                .forEach(field -> {
                    field.setAccessible(true);
                    Object o = контекст.взятиЕкземпляр(field.getType());
                    try {
                        field.set(t, o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
