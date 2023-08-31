package com.transactional.config;

import org.springframework.context.ApplicationEvent;

public class MyTransactionEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyTransactionEvent(Object source) {
        super(source);
    }
}
