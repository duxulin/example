package com.dxl.example.observer;

import java.util.Observable;

/**
 * @Program HexObserver
 * @Description
 * @Author duxl
 * @Create 2018/11/14 13:14
 */
public class HexObserver extends BaseObserver {
    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.attah(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hex String: " + Integer.toHexString(subject.getStatus()));
    }
}
