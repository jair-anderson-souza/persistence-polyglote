/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import io.github.jass2125.persistence.polyglote.core.services.client.UserPrincipalService;
import io.github.jass2125.persistence.polyglote.core.session.SessionConfig;
import io.github.jass2125.persistence.polyglote.core.util.PasswordEncriptor;
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
    private SessionConfig session;
    @Inject
    private UserPrincipalService userService;
    @Inject
    private PasswordEncriptor encriptManager;
    private String pageToRedirect;
    @Inject
    private FaceMessages message;

    public LogController() {
    }

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public String login() {
        String encryptUserPassword = encryptUserPassword();
        setEncryptedPassword(encryptUserPassword);
        UserPrincipal userTemp = tryFindUser();
        this.pageToRedirect = setPageToRedirect(userTemp);
        return pageToRedirect;
    }

    private String encryptUserPassword() {
        String encryptPassword = this.encriptManager.encryptPassword(user.getPassword());
        return encryptPassword;
    }

    public void setEncryptedPassword(String encryptUserPassword) {
        this.user.setPassword(encryptUserPassword);
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
            message.teste();
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

    public String redirectToRegisterPage() {
        return "cadastro?faces-redirect=true";
    }

    public String redirectToIndex() {
        return "index?faces-redirect=true";
    }
}
