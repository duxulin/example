package com.dxl.example.designpatten;

public class Child extends Parent {
    public Child(int age, String name) {
        super(age, name);
    }

    public Child(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(this.name + " eat");
    }

    @Override
    public void run() {

    }
}
