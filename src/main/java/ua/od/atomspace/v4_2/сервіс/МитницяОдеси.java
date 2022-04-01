package ua.od.atomspace.v4_2.сервіс;

import ua.od.atomspace.v4_2.конфігурація.анотація.ЗчитатиПараметр;
import ua.od.atomspace.v4_2.модель.ВідповідьМитніці;
import ua.od.atomspace.v4_2.модель.Людина;

import java.util.Random;

public class МитницяОдеси implements Митниця {

    @ЗчитатиПараметр
    private String кодовеСлово;

    @Override
    public ВідповідьМитніці обробитиЛюдину(Людина людина) {
        // зробити перевірку
        System.out.println(" ---> Що таке паляниця!!!");
        if(new Random().nextInt(2) % 2 == 0) {
            System.out.println("Клубника! <----");
            System.out.println(" ---> Яка клубніка, то бублік бл***");
            return new ВідповідьМитніці(людина, false);
        }
        System.out.println("Хліб <----");
        // винести вирок
        System.out.println(" ---> Ласкаво просимо до України, кодове слово " + кодовеСлово);
        return new ВідповідьМитніці(людина, true);
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
