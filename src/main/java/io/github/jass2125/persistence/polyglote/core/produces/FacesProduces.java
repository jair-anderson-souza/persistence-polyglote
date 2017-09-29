/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.produces;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Sep 29, 2017 5:10:19 PM
 */
public class FacesProduces implements Serializable {

    @Produces
    private FacesContext context = FacesContext.getCurrentInstance();
    @Produces
    private ExternalContext externalContext = context.getExternalContext();
//    @Produces
//    private Flash flash = externalContext.getFlash();

}
