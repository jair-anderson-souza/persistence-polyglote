/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.interceptors;

import io.github.jass2125.persistence.polyglote.core.annotations.SecurityAnnotation;
import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import io.github.jass2125.persistence.polyglote.core.exceptions.LoginInvalidException;
import io.github.jass2125.persistence.polyglote.core.produces.UserOn;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 14/09/2017 15:07:18
 */
@Priority(Interceptor.Priority.APPLICATION)
@Interceptor
@SecurityAnnotation
public class SecurityInterceptor {

    @Inject @UserOn
    private UserPrincipal userOn;

    @AroundInvoke
    public Object verifyUser(InvocationContext context) throws Exception {
        if (userOn == null) {
            throw new LoginInvalidException("Erro no login!!!");
        }
        return context.proceed();
    }

}
