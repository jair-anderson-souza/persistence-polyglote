/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.exceptions;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 25/09/2017 20:59:38
 */
public class EncodingException extends RuntimeException {
    
    public EncodingException(UnsupportedEncodingException e, String msg) {
        super(msg, e);
    }
    
}
