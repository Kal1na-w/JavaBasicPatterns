package ua.od.atomspace.v6.сервіс;


import ua.od.atomspace.v6.конфігурація.анотація.Інєкція;
import ua.od.atomspace.v6.конфігурація.анотація.ЗчитатиПараметр;
import ua.od.atomspace.v6.модель.ВідповідьМитніці;
import ua.od.atomspace.v6.модель.Людина;

public class МитницяОдеси implements Митниця {

    @ЗчитатиПараметр
    private String кодовеСлово;

    @Інєкція
    private МитнаПеревірка митнаПеревірка;

    public ВідповідьМитніці обробитиЛюдину(Людина людина) {
        // винести вирок
        return new ВідповідьМитніці(людина, митнаПеревірка.перевірити(людина));
    }

}
