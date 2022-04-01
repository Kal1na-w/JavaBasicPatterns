package ua.od.atomspace.v5.сервіс;

import ua.od.atomspace.v5.модель.Держава;
import ua.od.atomspace.v5.модель.Людина;

public class ЧергаНаКордоніМолдови implements ЧергаНаКордоні {
    @Override
    public Людина забратиКрайнього() {
        System.out.println(" ---> Степан біжи сюда");
        return new Людина("Шевченко Степан Юрійовіч", Держава.УКРАЇНА);
    }

    private ЧергаНаКордоніМолдови() {
    }

    public static class Одинак {
        private static ЧергаНаКордоніМолдови чергаНаКордоніМолдови;

        public static ЧергаНаКордоніМолдови взятиЕкзкмпляр() {
            if (чергаНаКордоніМолдови != null) {
                return чергаНаКордоніМолдови;
            }
            чергаНаКордоніМолдови = new ЧергаНаКордоніМолдови();
            return чергаНаКордоніМолдови;
        }
    }
}
