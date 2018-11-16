package com.dxl.example.observer;

/**
 * @Program ObserverTest
 * @Description
 * @Author duxl
 * @Create 2018/11/14 13:22
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject(1);
        new HexObserver(subject);
        new OctalObserver(subject);
        subject.setStatus(15);

        subject.setStatus(100);
    }
}
