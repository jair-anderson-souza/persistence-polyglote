/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import io.github.jass2125.persistence.polyglote.core.annotations.SecurityAnnotation;
import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import io.github.jass2125.persistence.polyglote.core.services.client.UserPrincipalService;
import io.github.jass2125.persistence.polyglote.core.annotations.Session;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:21:59
 */
@RequestScoped
@Named
@SecurityAnnotation
public class UserPrincipalController implements Serializable {

    @Inject
    @Session
    private UserPrincipal user;
    @Inject
    private UserPrincipalService userService;

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public String editUserPrincipal() {
        
        UserPrincipal update = userService.update(user);
        System.out.println(update);
        return "edit.xhtml";
    }

}
