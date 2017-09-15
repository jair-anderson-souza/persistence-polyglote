/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.interceptors;

import io.github.jass2125.persistence.poliglota.core.annotations.Transactional;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 14/09/2017 00:49:29
 */
@Interceptor
@Transactional
@Priority(Interceptor.Priority.APPLICATION)
public class TransactionInterceptor {

    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object managerTransaction(InvocationContext ctx) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        try {
            openTransaction(transaction);
            Object proceed = ctx.proceed();
            commitTransaction(transaction);
            return proceed;
        } catch (TransactionalException e) {
            rollbackTransaction(transaction);
            e.printStackTrace();
            throw new TransactionalException(e, "Impossível abrir transação");
        }
    }

    private void openTransaction(EntityTransaction transaction) {
        try {
            transaction.begin();
        } catch (IllegalStateException e) {
            throw new TransactionalException(e, "Erro ao abrur a transação");
        }
    }

    private void commitTransaction(EntityTransaction transaction) {
        try {
            transaction.commit();
        } catch (IllegalStateException | RollbackException e) {
            throw new TransactionalException(e, "Erro ao fechar a transação");
        }
    }

    private void rollbackTransaction(EntityTransaction transaction) {
        try {
            transaction.rollback();
        } catch (IllegalStateException | RollbackException e) {
            throw new TransactionalException(e, "Erro ao fechar a transação");
        }
    }
}
