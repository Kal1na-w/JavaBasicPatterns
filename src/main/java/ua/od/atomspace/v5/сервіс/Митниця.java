package ua.od.atomspace.v5.сервіс;

import ua.od.atomspace.v5.модель.ВідповідьМитніці;
import ua.od.atomspace.v5.модель.Людина;

public interface Митниця {
    ВідповідьМитніці обробитиЛюдину(Людина людина);
}
