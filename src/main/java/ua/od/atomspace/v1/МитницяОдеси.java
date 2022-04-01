package ua.od.atomspace.v1;

import java.util.Random;

public class МитницяОдеси implements Митниця {
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
        System.out.println(" ---> Ласкаво просимо до України");
        return new ВідповідьМитніці(людина, true);
    }
}
