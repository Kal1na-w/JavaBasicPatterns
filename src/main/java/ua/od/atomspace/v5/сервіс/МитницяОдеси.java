package ua.od.atomspace.v5.сервіс;

import ua.od.atomspace.v5.конфігурація.ФабрикаЕкземплярів;
import ua.od.atomspace.v5.модель.ВідповідьМитніці;
import ua.od.atomspace.v5.модель.Людина;

public class МитницяОдеси implements Митниця {
    @Override
    public ВідповідьМитніці обробитиЛюдину(Людина людина) {
        МитнаПеревірка митнаПеревірка = ФабрикаЕкземплярів.Одинак.взятиЕкзкмпляр().взятиЕкземпляр(МитнаПеревірка.class);
        return new ВідповідьМитніці(людина, митнаПеревірка.перевірити(людина));
    }

    private МитницяОдеси() {
    }

    public static class Одинак {
        private static МитницяОдеси митницяОдеси;

        public static МитницяОдеси взятиЕкзкмпляр() {
            if (митницяОдеси != null) {
                return митницяОдеси;
            }
            митницяОдеси = new МитницяОдеси();
            return митницяОдеси;
        }
    }

}
