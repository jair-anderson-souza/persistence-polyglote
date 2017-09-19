/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import io.github.jass2125.persistence.polyglote.core.dao.client.DocumentService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 18/09/2017 20:40:01
 */
@RequestScoped
@Named
public class DocumentController implements Serializable {

    @Inject
    private Document document;
    @Inject
    private DocumentService documentService;

    public DocumentController() {
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String regisrerDocument() {
        System.out.println(document);
        documentService.save(document);
        return "register?faces-redirect=true";
    }

}
