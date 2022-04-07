package ua.od.atomspace.v5.сервіс;

import ua.od.atomspace.v5.конфігурація.анотація.ЗчитатиПараметр;
import ua.od.atomspace.v5.модель.Людина;

import java.util.Random;

public class ПаляничнаМитнаПеревірка implements МитнаПеревірка {

    @ЗчитатиПараметр
    private String кодовеСлово;

    @Override
    public boolean перевірити(Людина людина) {
        System.out.println(" ---> Що таке паляниця!!!");
        if(new Random().nextInt(2) % 2 == 0) {
            System.out.println("Клубника! <----");
            System.out.println(" ---> Яка клубніка, то бублік бл***");
            return false;
        }
        System.out.println("Хліб <----");
        System.out.println(" ---> Ласкаво просимо до України (кодове слово: " + this.кодовеСлово + ")");
        return true;
    }

    public static class Одинак {
        private static ПаляничнаМитнаПеревірка паляничнаМитнаПеревірка;

        public static ПаляничнаМитнаПеревірка взятиЕкзкмпляр() {
            if (паляничнаМитнаПеревірка != null) {
                return паляничнаМитнаПеревірка;
            }
            паляничнаМитнаПеревірка = new ПаляничнаМитнаПеревірка();
            return паляничнаМитнаПеревірка;
        }
    }
}
