package ua.od.atomspace.v1;

public class ЧергаНаКордоніМолдови implements ЧергаНаКордоні {
    @Override
    public Людина забратиКрайнього() {
        System.out.println(" ---> Степан біжи сюда");
        return new Людина("Шевченко Степан Юрійовіч", Держава.УКРАЇНА);
    }
}
