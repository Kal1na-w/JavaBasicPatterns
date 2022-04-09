package ua.od.atomspace.v4.конфігурація;

import org.reflections.Reflections;
import ua.od.atomspace.v4.конфігурація.налаштовувач.Налаштовувач;

import java.lang.reflect.InvocationTargetException;

public class НалаштовувачЕкземплярів {

    private final Reflections reflections;

    public НалаштовувачЕкземплярів(String path) {
        this.reflections = new Reflections(path);
    }

    public <T> void зробитиВсіНалаштовування(T t) {
        reflections.getSubTypesOf(Налаштовувач.class)
                .forEach(налаштовувач -> {
                    try {
                        налаштовувач.getDeclaredConstructor().newInstance().налаштувати(t);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                });
    }
}
