/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.controllers;

import io.github.jass2125.persistence.poliglota.core.entity.UserPrincipal;
import io.github.jass2125.persistence.poliglota.core.services.client.UserPrincipalService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
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
    private UserPrincipalService userService;
    private String pageToRedirect;

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public String login() {
        tryFindUser();
        return pageToRedirect;
    }

    private void tryFindUser() {
        UserPrincipal userTemp = userService.searchUserByEmailAndPassword(user);
        this.pageToRedirect = pageToRedirect(userTemp);
    }

    private String pageToRedirect(UserPrincipal userTemp) {
        if (isNull(userTemp)) {
            return "index?faces-redirect=true";
        }
        return "home?faces-redirect=true";
    }

    private boolean isNull(UserPrincipal userTemp) {
        return userTemp == null;
    }
}
