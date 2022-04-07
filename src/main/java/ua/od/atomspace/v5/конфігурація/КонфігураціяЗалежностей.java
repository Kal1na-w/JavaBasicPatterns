package ua.od.atomspace.v5.конфігурація;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class КонфігураціяЗалежностей {
    private final Reflections reflections;

    private final Map<Class, Class> картаЗалежностей;

    public КонфігураціяЗалежностей(String path, Map<Class, Class> картаЗалежностей) {
        this.reflections = new Reflections(path);
        this.картаЗалежностей = картаЗалежностей;
    }

    public <T> Class<? extends T> взятиЗалежність(Class<T> type) {
        return картаЗалежностей.computeIfAbsent(type, clazz -> {
            Set<Class<? extends T>> імплементації = reflections.getSubTypesOf(type);
            if (імплементації.size() != 1) {
                throw new RuntimeException("Кількість імплементацій не дорівнює 1");
            }
            return імплементації.stream()
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Не має жодної імплементації"));
        });
    }

//    public static class Одинак {
//        private static КонфігураціяЗалежностей конфігураціяЗалежностей;
//
//        public static КонфігураціяЗалежностей взятиЕкзкмпляр() {
//            if (конфігураціяЗалежностей != null) {
//                return конфігураціяЗалежностей;
//            }
//            конфігураціяЗалежностей = new КонфігураціяЗалежностей(new HashMap<>(Map.of(
//                    Митниця.class, МитницяОдеси.class,
//                    МіграційнаСлужба.class, МіграційнаСлужбаУкраїни.class,
//                    ЧергаНаКордоні.class, ЧергаНаКордоніМолдови.class
//            )));
//            return конфігураціяЗалежностей;
//        }
//    }
}
