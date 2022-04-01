package ua.od.atomspace.v4_2.сервіс;

import ua.od.atomspace.v4_2.модель.ВідповідьМитніці;
import ua.od.atomspace.v4_2.модель.Людина;

public interface Митниця {
    ВідповідьМитніці обробитиЛюдину(Людина людина);
}
