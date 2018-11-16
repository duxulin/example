package com.dxl.example.observer;

import java.util.Observable;

/**
 * @Program OctalObserver
 * @Description
 * @Author duxl
 * @Create 2018/11/14 13:20
 */
public class OctalObserver extends BaseObserver {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attah(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getStatus()));
    }
}
