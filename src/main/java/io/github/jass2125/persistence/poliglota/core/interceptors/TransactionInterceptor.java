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
    public Object get(InvocationContext ctx) throws Exception {
        em.getTransaction().begin();
        Object proceed = ctx.proceed();
        em.getTransaction().commit();
        return proceed;
    }

}
