package com.transactional.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class MyTransactionListener {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, classes = MyTransactionEvent.class)
    public void listener(){
        System.out.println("事务执行之后2");
    }

}
