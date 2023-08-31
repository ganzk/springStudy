package com.transactional.config;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TransactionUtils {

    public static void doAfterCommit(Runnable runnable){
        if(TransactionSynchronizationManager.isActualTransactionActive()){
            TransactionSynchronizationManager.registerSynchronization(new DoTransaction(runnable));
        }
    }

}

class DoTransaction implements TransactionSynchronization{

    private Runnable runnable;

    public DoTransaction(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void afterCompletion(int status) {
        if(status == TransactionSynchronization.STATUS_COMMITTED){
            this.runnable.run();
        }
    }
}
