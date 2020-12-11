package com.piscenco.tasks;

public class Task03 {

    /**
     * Реализовать сериализацию boolean.
     * Главное требование, чтобы {@link Task03#booleanDeserialize(int)}
     * возвращал тот же boolean по значению int.
     * Tip: в Java есть тернарный оператор:
     * int x = condition ? trueValue : falseValue;
     */
    public static int booleanSerialize(boolean b) {
        return b? 1:0;
        //throw new IllegalArgumentException();
    }

    public static boolean booleanDeserialize(int i) {
        return i != 0;
       // throw new IllegalArgumentException();
    }

}
