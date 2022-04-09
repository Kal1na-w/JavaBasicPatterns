package ua.od.atomspace.v6;

import lombok.SneakyThrows;
import ua.od.atomspace.v6.конфігурація.Контекст;
import ua.od.atomspace.v6.конфігурація.КонтекстДодатку;
import ua.od.atomspace.v6.сервіс.*;

import java.util.HashMap;
import java.util.Map;

public class НаціональнийМитнийДодаток {

    @SneakyThrows
    public static void main(String[] args) {
        Контекст контекст = КонтекстДодатку.зформувати("ua.od.atomspace", new HashMap<>(
                Map.of(
                        Митниця.class, МитницяОдеси.class,
                        МіграційнаСлужба.class, МіграційнаСлужбаУкраїни.class,
                        ЧергаНаКордоні.class, ЧергаНаКордоніМолдови.class,
                        МитнаПеревірка.class, ПаляничнаМитнаПеревірка.class
                )
        ));
        МитнеМіністерствоУкраїни митнеМіністерствоУкраїни = контекст.взятиЕкземпляр(МитнеМіністерствоУкраїни.class);
        митнеМіністерствоУкраїни.початиЗміну();
    }

}
