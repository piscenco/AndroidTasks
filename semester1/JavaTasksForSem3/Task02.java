package com.piscenco;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать итератор над массивом.
 * Массив принимается в конструктор.
 * Итерация должна начинаться с первого элемента.
 * hasNext возвращает true, если итератор может вернуть следующее значение.
 * next должен возвращать следующее значение.(с переходом на следующий элемент)
 */
class ArrayIterator<T> implements Iterator<T> {

    private int cur_pos;
    private int len;
    private T[] data;

    public ArrayIterator(T[] array) {
        cur_pos = -1;
        data = array;
        len = array.length;

    }

    @Override
    public boolean hasNext() {
        if(cur_pos<len-1){
            return true;
        }
        return false;

    }

    @Override
    public T next() {
        // Если следующего значения нет, то надо бросить NoSuchElementException
        if(!this.hasNext())
            throw new NoSuchElementException();
        cur_pos++;
        return data[cur_pos];
    }
}
