package ua.od.atomspace.v2;

public class ЧергаНаКордоніМолдови implements ЧергаНаКордоні {
    @Override
    public Людина забратиКрайнього() {
        System.out.println(" ---> Степан біжи сюда");
        return new Людина("Шевченко Степан Юрійовіч", Держава.УКРАЇНА);
    }

    private ЧергаНаКордоніМолдови() {
    }

    static class Одинак {
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
