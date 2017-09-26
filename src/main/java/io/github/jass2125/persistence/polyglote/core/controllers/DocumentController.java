/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.controllers;

import io.github.jass2125.persistence.polyglote.core.entity.Document;
import io.github.jass2125.persistence.polyglote.core.services.client.DocumentService;
import io.github.jass2125.persistence.polyglote.core.util.DocumentConvetrer;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

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

    private Part part;

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public DocumentController() {
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void processFile() throws IOException {
        this.part.getInputStream();
    }

    public String regisrerDocument() throws IOException {
        DocumentConvetrer c = new DocumentConvetrer();
        String d = c.converterToText(part.getInputStream());
        System.out.println("D: " + d);
//        documentService.save(document);
        return "register?faces-redirect=true";
    }

}
