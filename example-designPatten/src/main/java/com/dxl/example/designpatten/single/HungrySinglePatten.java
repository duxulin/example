package com.dxl.example.designpatten.single;

import jdk.nashorn.internal.ir.CallNode;

public class HungrySinglePatten {
    static HungrySinglePatten hungrySinglePatten = new HungrySinglePatten();

    private HungrySinglePatten() {
    }

    ;

    public static HungrySinglePatten getInstance() {
        return hungrySinglePatten;
    }
}
