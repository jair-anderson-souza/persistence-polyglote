/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.util;

import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 24/09/2017 19:30:47
 */
public class DocumentConvetrer {

    public String converterToText(InputStream stream) {
        try {
            ContentHandler contenthandler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            PDFParser parser = new PDFParser();
            parser.parse(stream, contenthandler, metadata, new ParseContext());
            return contenthandler.toString();
        } catch (Exception e) {

        }
        return null;
    }
}
