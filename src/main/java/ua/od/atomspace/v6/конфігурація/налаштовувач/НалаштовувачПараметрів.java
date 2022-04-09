package ua.od.atomspace.v6.конфігурація.налаштовувач;

import ua.od.atomspace.v6.конфігурація.Контекст;
import ua.od.atomspace.v6.конфігурація.анотація.ЗчитатиПараметр;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class НалаштовувачПараметрів implements Налаштовувач {

    public static final String APPLICATION_PROPERTIES = "application.properties";
    private final Map<String, String> картаПараметрів = new HashMap<>();

    public НалаштовувачПараметрів() {
        зчитатиВсіПараметри();
    }

    @Override
    public <T> void налаштувати(T t, Контекст контекст) {
        Arrays.stream(t.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotation(ЗчитатиПараметр.class) != null)
                .forEach(field -> {
                    String значення = картаПараметрів.get(field.getName());
                    try {
                        field.setAccessible(true);
                        field.set(t, значення);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } finally {
                        field.setAccessible(false);
                    }
                });
    }

    private void зчитатиВсіПараметри() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(APPLICATION_PROPERTIES))) {
            while (bufferedReader.ready()) {
                String[] ключТаЗначення = bufferedReader.readLine().split(": ");
                картаПараметрів.put(ключТаЗначення[0], ключТаЗначення[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
