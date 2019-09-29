package com.dxl.example.designpatten.spring.observer;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


public class OrderCreateEvent extends ApplicationEvent {


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderCreateEvent(Object source) {
        super(source);
    }

//	@Override
//	public boolean equals(Object obj) {
//		return super.equals(obj);
//	}
}
