/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import io.github.jass2125.persistence.polyglote.core.services.client.UserPrincipalService;
import io.github.jass2125.persistence.polyglote.core.annotations.Session;
import io.github.jass2125.persistence.polyglote.core.util.PasswordEncriptor;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:21:59
 */
@RequestScoped
@Named
//@SecurityAnnotation
public class UserPrincipalController implements Serializable {

    @Inject
    @Session
    private UserPrincipal user;
    @Inject
    private UserPrincipal newUser;
    @Inject
    private UserPrincipalService userService;
    @Inject
    private PasswordEncriptor enc;

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public UserPrincipal getNewUser() {
        return newUser;
    }

    public void setNewUser(UserPrincipal newUser) {
        this.newUser = newUser;
    }

    public String editUserPrincipal() {
        UserPrincipal update = userService.update(user);
        System.out.println(update);
        return "edit.xhtml";
    }

    public void registerUserPrincipal() {
        String encryptPassword = encryptPassword(newUser.getPassword());
        setPassword(encryptPassword);
        this.userService.save(newUser);
    }

    public void setPassword(String password) {
        this.newUser.setPassword(password);
    }

    public String encryptPassword(String password) {
        return enc.encryptPassword(password);
    }
}
