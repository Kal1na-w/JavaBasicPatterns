package ua.od.atomspace.v1;

public class МіграційнаСлужбаУкраїни implements МіграційнаСлужба {
    @Override
    public void мігрувати(ВідповідьМитніці відповідьМитніці) {
        if (відповідьМитніці.isПідтвердженний()) {
            System.out.println(" ---> Тримайте квиток до Києва");
            return;
        }
        System.out.println(" ---> Наздогоняйте руській корабль");
    }
}
