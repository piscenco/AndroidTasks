package com.piscenco;
/*
*   Pro-02
*   Реализовать интерфейс List на массиве самостоятельно, чтобы он работал аналогично ArrayList.
* */

import java.util.*;

public class MyList implements List {
    private Object[] data;
    private int size;

    // конструкторы
    public MyList() {
        this.data = null;
        this.size = 0;
    }

    public MyList(int init_size) {
        if (init_size < 0)
            throw new IllegalArgumentException();
        this.data = new Object[init_size];
        this.size = init_size;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return data == null;
    }

    @Override
    public boolean contains(Object o) {
        for (Object obj : this.data)
            if (o.equals(obj))
                return true;
        return false;
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(this.data).iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.data, this.size);
    }

    @Override
    public boolean add(Object o) {
        Object[] new_data = new Object[this.size + 1];
        if (this.size >= 0)
            System.arraycopy(this.data, 0, new_data, 0, this.size);
        new_data[this.size] = o;
        this.data = new_data;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!this.contains(o))
            return false;
        int obj_index = indexOf(o);
        Object[] new_data = new Object[this.size - 1];
        for (int i = 0; i < obj_index; i++) {
            new_data[i] = this.data[i];
        }
        for (int i = obj_index; i < this.size; i++) {
            new_data[i] = this.data[i];
        }
        this.data = new_data;
        this.size--;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Boolean changed = false;
        for (Object obj : c) {
            if (!this.contains(obj)) {
                changed = true;
                this.add(obj);
            }
        }
        return changed;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        // скорее, всего можно как-то написать оптимальнее, какая-то длинная функция получилась
        if (c.isEmpty())
            return false;
        if (index >= this.size) {
            while (index >= this.size)
                this.add(null);
            for (Object obj : c) {
                this.add(obj);
            }
        } else {
            Object[] c_array = c.toArray();
            Object[] new_data = new Object[this.size + index];
            for (int i = 0; i < index; i++) {
                new_data[i] = this.data[i];
            }
            Object[] old_tail_el = new Object[this.size - index];
            int j = 0;
            for (int i = index; i < this.size; i++) {
                new_data[i] = c_array[j];
                old_tail_el[j] = this.data[i];
                j++;
            }
            int old_size = this.size();
            for (int i = 0; i < c.size() - old_size + index; i++)
                this.add(c_array[old_size - index + i]);
            for (Object obj : old_tail_el)
                this.add(obj);
        }
        return true;
    }

    @Override
    public void clear() {
        this.data = null;
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < this.size)
            return this.data[index];
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Object set(int index, Object element) {
        if (index < this.size)
            this.data[index] = element;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(int index, Object element) {
        // должен ли масив растягиваться или ввыбрасывать ошибку?
        if (index >= this.size) {
            while (index >= this.size)
                this.add(null);
            this.add(element);
            return;
        }
        Object old_el = this.get(index);
        this.data[index] = element;
        this.add(old_el);
    }

    @Override
    public Object remove(int index) {
        Object[] new_data = new Object[this.size - 1];
        Object oldValue = this.get(index);
        for (int i = 0; i < index; i++)
            new_data[i] = this.data[i];
        for (int i = index + 1; i < this.size; i++)
            new_data[i - 1] = this.data[i];
        this.data = new_data;
        this.size--;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++)
                if (o.equals(this.data[i]))
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (this.data[i] == null)
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o != null) {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(this.data[i]))
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (this.data[i] == null)
                    return i;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        // ???
        return (ListIterator) Arrays.stream(this.data).iterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        //???
        return (ListIterator) Arrays.stream(this.data).iterator();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        MyList sub_list = new MyList(toIndex - fromIndex);
        int j = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            sub_list.set(j, this.data[i]);
            j++;
        }
        return sub_list;
    }

    @Override
    public boolean retainAll(Collection c) {
        // оставляет элементы, только если есть в коллекции
        Object[] old_data = this.data;
        int r = 0, w = 0;
        boolean modified = false;
        for (; r < size; r++)
            if (c.contains(old_data[r]))
                old_data[w++] = old_data[r];
        if (r != size) {
            System.arraycopy(old_data, r, old_data, w, size - r);
            w += size - r;
        }
        if (w != size) {
            for (int i = w; i < size; i++)
                old_data[i] = null;
            size = w;
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection c) {
        // тут дублирование кода предыдущего метода, разница только в if (!c.contains(old_data[r]))
        Object[] old_data = this.data;
        int r = 0, w = 0;
        boolean modified = false;
        for (; r < size; r++)
            if (!c.contains(old_data[r]))
                old_data[w++] = old_data[r];
        if (r != size) {
            System.arraycopy(old_data, r, old_data, w, size - r);
            w += size - r;
        }
        if (w != size) {
            for (int i = w; i < size; i++)
                old_data[i] = null;
            size = w;
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean contains = true;
        for (Object obj:c) {
            if (!this.contains(obj))
                contains=false;
        }
        return contains;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return Arrays.copyOf(this.data, this.size);
    }
}
