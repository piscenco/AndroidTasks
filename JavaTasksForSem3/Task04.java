package com.piscenco;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task04 {

    /**
     * Написать программу, которая играет с вами в угадай число.
     * Сначала программа печатает: "Введи нижную и верхнюю границы"
     * Пользователь вводит.
     * Программа проверяет, что нижняя граница меньше верхней.
     * Иначе выводит в консоль сообщение об ошибке и завершается.
     * <p>
     * Далее программа пытается угадать какое число загадал пользователь
     * в введенном отрезке.
     * Тактика может быть любая: random, перебор, бин поиск.
     * Программа выводит своё предположение.
     * Пользователь должен ввести "yes", если программа угадал.
     * Программа завершается.
     * Иначе любое другое сообщение. Тогда программа продолжает угадывать.
     * <p>
     * Пример:
     * Введи границы
     * 0 10
     * Это 1?
     * no
     * Это 3?
     * no
     * Это 5?
     * yes
     * Отличная игра(завершение)
     */
    public static void main(String[] args) {
        System.out.println("Введи границы");
        int lower_bound, upper_bound;
        Scanner myInput = new Scanner(System.in);
        lower_bound = myInput.nextInt();
        upper_bound = myInput.nextInt();
        if (upper_bound < lower_bound)
            throw new IllegalArgumentException();
        //System.out.printf("Это %s?", randomNum);
        myInput.nextLine();
        String ans = "no"; //= myInput.nextLine();
        while(!ans.equals("yes")){
            int randomNum = ThreadLocalRandom.current().nextInt(lower_bound, upper_bound + 1);
            System.out.printf("Это %s?\n", randomNum);
            ans = myInput.nextLine();
        }
        System.out.println("Отличная игра(завершение)");


    }

}
/* пример результата:
Введи границы
34 56
Это 42?
no
Это 43?
no
Это 39?
no
Это 50?
no
Это 44?
yes
Отличная игра(завершение)
* */
