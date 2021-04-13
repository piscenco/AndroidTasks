package com.example.fragmentsample.db

class Flower {
    var id: Long = 0
    var name: String? = null
    // var count:Int
    override fun toString(): String {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'
        //"There are "+ count + " flowers"
    }
}