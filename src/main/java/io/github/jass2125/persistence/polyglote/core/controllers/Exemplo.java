/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import io.github.jass2125.persistence.polyglote.core.annotations.SecurityAnnotation;
import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import io.github.jass2125.persistence.polyglote.core.produces.UserOn;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 15/09/2017 20:31:06
 */
@Named
@RequestScoped
@SecurityAnnotation
public class Exemplo implements Serializable {

    @Inject
    @UserOn
    private UserPrincipal user;

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public String get() {
        return "home";
    }

}
