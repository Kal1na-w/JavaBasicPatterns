package ua.od.atomspace.v6.конфігурація.налаштовувач;

import ua.od.atomspace.v6.конфігурація.Контекст;

public interface Налаштовувач {
    <T> void налаштувати(T t, Контекст контекст);
}
