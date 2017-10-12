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
import io.github.jass2125.persistence.polyglote.core.exceptions.EmailInvalidException;
import io.github.jass2125.persistence.polyglote.core.exceptions.PersistException;
import io.github.jass2125.persistence.polyglote.core.session.SessionConfig;
import io.github.jass2125.persistence.polyglote.core.util.PasswordEncriptor;
import java.nio.file.attribute.UserPrincipalLookupService;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
    private SessionConfig sessionConfig;
    @Inject
    private UserPrincipal newUser;
    @Inject
    private UserPrincipal updateUser;
    @Inject
    private UserPrincipalService userService;
    @Inject
    private PasswordEncriptor enc;
    @Inject
    private FaceMessages messages;

    public UserPrincipalController() {
    }

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public UserPrincipal getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(UserPrincipal updateUser) {
        this.updateUser = updateUser;
    }

    public UserPrincipal getNewUser() {
        return newUser;
    }

    public void setNewUser(UserPrincipal newUser) {
        this.newUser = newUser;
    }

    public void registerUserPrincipal() {
        String encryptPassword = encryptPassword(newUser.getPassword());
        setPassword(encryptPassword);
        tryToPersist();
    }

    public void tryToPersist() {
        try {
            this.userService.save(newUser);
            messages.addMessage("registerInfo", "Seu cadastro foi efetuado com sucesso!!!");
        } catch (PersistException e) {
        } catch (EmailInvalidException e) {
            messages.addMessage("registerInfo", e.getMessage());
        }
    }

    public void setPassword(String password) {
        this.newUser.setPassword(password);
    }

    public String encryptPassword(String password) {
        return enc.encryptPassword(password);
    }

    public boolean isNil(UserPrincipal user) {
        return user == null;
    }

    public String editUserPrincipal() {
        String encryptPassword = encryptPassword(updateUser.getPassword());
        this.updateUser.setId(user.getId());
        this.updateUser.setPassword(encryptPassword);
        tryToUpdate();
        return "edit.xhtml";
    }

    private void tryToUpdate() {
        try {
            userService.update(updateUser);
            sessionConfig.setUser(updateUser);
            messages.addMessage("updateInfo", "Seu cadastro foi atualizado com sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            messages.addMessage("updateInfo", e.getMessage());
        }
    }
}
