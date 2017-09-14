/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.controllers;

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
    private UserPrincipalService userService;

    public String teste() {
        System.out.println("dklfsd");
        userService.v();
        return "index";
    }
}
