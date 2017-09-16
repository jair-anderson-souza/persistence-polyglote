/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import io.github.jass2125.persistence.polyglote.core.produces.UserOn;
import io.github.jass2125.persistence.polyglote.core.services.client.UserPrincipalService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:21:59
 */
@RequestScoped
@Named
public class UserPrincipalController implements Serializable {

    @Inject
    private UserPrincipal user;
    @Inject
    @UserOn
    private UserPrincipal userOn;
    @Inject
    private UserPrincipalService userService;
    private String pageToRedirect;

    public UserPrincipalController() {
    }

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public UserPrincipal getUserOn() {
        return userOn;
    }

    public void setUserOn(UserPrincipal userOn) {
        this.userOn = userOn;
    }

    public String login() {
        tryFindUser();
        this.pageToRedirect = setPageToRedirect();
        return pageToRedirect;
    }

    private void tryFindUser() {
        try {
            userOn = userService.searchUserByEmailAndPassword(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private String setPageToRedirect() {
        if (isNull(userOn)) {
            return "index?faces-redirect=true";
        }
        initializeSession();
        return "home?faces-redirect=true";
    }

    private boolean isNull(UserPrincipal userOn) {
        return userOn == null;
    }

    private void initializeSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userOn);
    }
}
