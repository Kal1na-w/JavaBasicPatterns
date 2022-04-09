package ua.od.atomspace.v4.конфігурація.налаштовувач;

import lombok.SneakyThrows;
import ua.od.atomspace.v4.конфігурація.анотація.ЗчитатиПараметр;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class НалаштовувачПараметрів implements Налаштовувач {

    private final Map<String, String> параметри = new HashMap<>();

    @Override
    @SneakyThrows
    public <T> void налаштувати(T t) {
        Arrays.stream(t.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotation(ЗчитатиПараметр.class) != null)
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        field.set(t, параметри.get(field.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } finally {
                        field.setAccessible(false);
                    }
                });
    }

    public НалаштовувачПараметрів() {
        зчитатиПараметри();
    }

    private void зчитатиПараметри() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("application.properties"))) {
            String лініяПараметра = bufferedReader.readLine();
            String[] ключТаЗначення = лініяПараметра.split(": ");
            параметри.put(ключТаЗначення[0], ключТаЗначення[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
