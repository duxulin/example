package com.dxl.example.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @Program Subject
 * @Description
 * @Author duxl
 * @Create 2018/11/14 13:12
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int status;

    public Subject() {
    }

    public Subject(int status) {
        this.status = status;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        notifyAllObserver();
    }

    public void attah(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(null, null);
        }
    }
}
