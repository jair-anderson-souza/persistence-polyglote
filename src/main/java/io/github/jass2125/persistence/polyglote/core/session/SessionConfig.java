/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.session;

import io.github.jass2125.persistence.polyglote.core.annotations.Session;
import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 16/09/2017 16:31:10
 */
public class SessionConfig {

    @Inject
    @Session
    private UserPrincipal user;
    @Inject
    private Map<String, Object> session;

    public SessionConfig() {
    }

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public void initializeSession(UserPrincipal user) {
        this.user = user;
        session.put("user", user);
    }
}
