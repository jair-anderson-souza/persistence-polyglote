/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import io.github.jass2125.persistence.polyglote.core.services.client.UserPrincipalService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 16/09/2017 17:12:13
 */
@Named
@RequestScoped
public class LogController implements Serializable {

    @Inject
    private UserPrincipal user;
    @Inject
    private Session session;
    @Inject
    private UserPrincipalService userService;
    private String pageToRedirect;

    public LogController() {
    }

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public String login() {
        UserPrincipal userTemp = tryFindUser();
        this.pageToRedirect = setPageToRedirect(userTemp);
        return pageToRedirect;
    }

    private UserPrincipal tryFindUser() {
        try {
            return userService.searchUserByEmailAndPassword(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String setPageToRedirect(UserPrincipal userTemp) {
        if (isNull(userTemp)) {
            return "index?faces-redirect=true";
        }
        initializeSession(userTemp);
        return "home?faces-redirect=true";
    }

    private boolean isNull(UserPrincipal userTemp) {
        return userTemp == null;
    }

    private void initializeSession(UserPrincipal user) {
        session.initializeSession(user);

    }
}