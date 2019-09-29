package com.dxl.example.designpatten;

public abstract class Parent implements Human {

    protected int age;
    protected String name;

    public Parent(int age, String name) {
        this.age = age;
        this.name = name;
    }

    Parent(String name) {
        this.name = name;
        this.age = 10;
    }


    abstract void eat();

    void show() {
        System.out.println(this.name);
    }


}
