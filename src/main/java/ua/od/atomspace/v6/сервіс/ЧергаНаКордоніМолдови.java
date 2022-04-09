package ua.od.atomspace.v6.сервіс;

import ua.od.atomspace.v6.модель.Держава;
import ua.od.atomspace.v6.модель.Людина;

import java.util.LinkedList;
import java.util.List;

public class ЧергаНаКордоніМолдови implements ЧергаНаКордоні {

    private List<String> strings = new LinkedList<>();

    @Override
    public Людина забратиКрайнього() {
        System.out.println(" ---> Степан біжи сюда");
        return new Людина("Шевченко Степан Юрійовіч", Держава.УКРАЇНА);
    }
}
