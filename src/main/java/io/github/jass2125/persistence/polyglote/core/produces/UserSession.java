/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.produces;

import io.github.jass2125.persistence.polyglote.core.annotations.Session;
import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 15/09/2017 20:17:50
 */
public class UserSession implements Serializable {

    @Produces
    @Session
    private UserPrincipal user = (UserPrincipal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

}
