package com.dxl.example.designpatten.single;

public class LazySinglePatten {


    volatile static LazySinglePatten lazySinglePatten;

    private LazySinglePatten() {
    }

    public static LazySinglePatten getInstance() {
        if (lazySinglePatten == null) {
            synchronized (LazySinglePatten.class) {
                if (lazySinglePatten == null) {
                    lazySinglePatten = new LazySinglePatten();
                }
            }
        }
        return lazySinglePatten;
    }
}
