/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 24/09/2017 18:01:47
 */
@FacesValidator(value = "documentValidator")
public class DocumentValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part part = (Part) value;
        System.out.println(value);
        if (!part.getContentType().equalsIgnoreCase("application/pdf")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_INFO, null, "O formato do arquivo não é permitido!!"));
        }
    }

}
