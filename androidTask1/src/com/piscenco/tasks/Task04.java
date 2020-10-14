package com.piscenco.tasks;

/**
 * Реализовать трехмерный вектор.
 * Условие: https://habr.com/ru/post/440436/#20
 * Там есть решение. Сначала попробуйте самостоятельно.
 *
 * Создайте класс, который описывает вектор (в трёхмерном пространстве).
 *
 * У него должны быть:
 * конструктор с параметрами в виде списка координат x, y, z
 * метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt():
 * метод, вычисляющий скалярное произведение:
 * метод, вычисляющий векторное произведение с другим вектором:
 * метод, вычисляющий угол между векторами (или косинус угла): косинус угла между векторами равен скалярному произведению векторов, деленному на произведение модулей (длин) векторов:
 * методы для суммы и разности:
 * статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N.
 */
class Vector {

    // constructors
    Vector(){
        this.x1 = this.x2 = this.x3 = 0;
    }
    Vector(double a, double b, double c){
        this.x1 = a;
        this.x2 = b;
        this.x3 = c;
    }

    // coordinates of vector
    private double x1;
    private double x2;
    private double x3;

    public double scalarProduct(Vector other) {
        return this.x1 * other.x1 + this.x2 *
                other.x2 + this.x3 * other.x3;
    }

    public double length() {
        return Math.sqrt(this.scalarProduct(this));
    }

    public Vector crossProduct(Vector other) {
        return new Vector(
                this.x2 * other.x3 - x3 * other.x2,
                this.x3 * other.x1 - this.x1 * other.x3,
                this.x1 * other.x2 - this.x2 * other.x1);
    }

    public double cos(Vector other) {
        // ||x||*||y||*cos(x,y) = <x, y>
        return this.scalarProduct(other) /
                (other.length() * this.length());
    }

    public double angle(Vector other) {
        return Math.acos(this.cos(other));
    }

    public Vector plus(Vector other) {
        return new Vector(
                x1 + other.x1,
                x2 + other.x2,
                x3 + other.x3
        );
    }

    public Vector minus(Vector other) {
        return new Vector(
                x1 - other.x1,
                x2 - other.x2,
                x3 - other.x3
        );
    }

    public static Vector[] makeArrayOfVectors(int n) throws IllegalArgumentException{
        if(n < 0)
            throw new IllegalArgumentException();

        Vector[] arr = new Vector[n];
        int i = 0;
        while(i < n){
            arr[i] = new Vector(
                    Math.random(),
                    Math.random(),
                    Math.random()
            );
            i++;
        }
        return arr;
    }

}

public class Task04 {

}
