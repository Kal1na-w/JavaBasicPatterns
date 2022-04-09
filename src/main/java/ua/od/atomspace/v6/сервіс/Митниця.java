package ua.od.atomspace.v6.сервіс;

import ua.od.atomspace.v6.модель.ВідповідьМитніці;
import ua.od.atomspace.v6.модель.Людина;

public interface Митниця {
    ВідповідьМитніці обробитиЛюдину(Людина людина);
}
