package com.piscenco.tasks;
public class Task01 {

    /**
     * Возвращает минимальное значение из массива.
     * Не использовать стандартную библиотеку!
     */
    public static int min(int[] ints) {
        int min_ = ints[0];
        for(int i = 0; i< ints.length;i++){
            if(min_>ints[i])
                min_=ints[i];
        }

        return min_;
    }

    public static float average(int[] ints) {
        float sum_ = 0;
        for(int i:ints){
            sum_+=i;
        }

        return sum_/ints.length;
    }

}
