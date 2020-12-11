package com.piscenco.tasks;



import java.util.concurrent.ThreadLocalRandom;

/**
 * Напишите класс, конструктор которого принимает два массива:
 * массив значений и массив весов значений.
 * Класс должен содержать метод, который будет возвращать элемент
 * из первого массива случайным образом, с учётом его веса.
 * Пример:
 * Дан массив [1, 2, 3], и массив весов [1, 2, 10].
 * В среднем, значение «1» должно возвращаться в 2 раза реже,
 * чем значение «2» и в десять раз реже, чем значение «3».
 */
class RandomFromArray {
    public RandomFromArray(int[] values, int[] weights){
        this.values = values;
        this.weights = weights;
    }
    private int[] values;
    private int[] weights;

    public int length(){
        return this.values.length;
    }
    public int weightsSum() {
        int sum = 0;
        for(int w : weights)
            sum += w;
        return sum;
    }

    public int getElement(){
        int rand_el_index = ThreadLocalRandom.current().
                nextInt(0, this.weightsSum()+ 1);
        int sum = 0;
        for( int i = 0; i < weights.length;i++) {
            sum += weights[i];
            if(sum > rand_el_index)
                return this.values[i];
        }
        return 0;
    }

}

public class Task05 {

}
