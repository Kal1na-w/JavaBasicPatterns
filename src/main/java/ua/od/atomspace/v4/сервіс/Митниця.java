package ua.od.atomspace.v4.сервіс;

import ua.od.atomspace.v4.модель.ВідповідьМитніці;
import ua.od.atomspace.v4.модель.Людина;

public interface Митниця {
    ВідповідьМитніці обробитиЛюдину(Людина людина);
}
