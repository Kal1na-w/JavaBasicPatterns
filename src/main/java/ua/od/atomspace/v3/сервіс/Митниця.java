package ua.od.atomspace.v3.сервіс;

import ua.od.atomspace.v3.модель.ВідповідьМитніці;
import ua.od.atomspace.v3.модель.Людина;

public interface Митниця {
    ВідповідьМитніці обробитиЛюдину(Людина людина);
}
