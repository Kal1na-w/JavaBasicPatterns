package ua.od.atomspace.v6.сервіс;

import ua.od.atomspace.v6.конфігурація.анотація.ЗчитатиПараметр;
import ua.od.atomspace.v6.модель.ВідповідьМитніці;

public class МіграційнаСлужбаУкраїни implements МіграційнаСлужба {

    @ЗчитатиПараметр
    private String часиРоботи;

    @Override
    public void мігрувати(ВідповідьМитніці відповідьМитніці) {
        System.out.println(" ---> Ми працюємо " + this.часиРоботи);
        if (відповідьМитніці.isПідтвердженний()) {
            System.out.println(" ---> Тримайте квиток до Києва");
            return;
        }
        System.out.println(" ---> Наздогоняйте руській корабль");
    }

}
