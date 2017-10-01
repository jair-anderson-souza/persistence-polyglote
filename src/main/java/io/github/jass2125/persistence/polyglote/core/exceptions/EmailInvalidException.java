/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.exceptions;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 14/09/2017 17:12:26
 */
public class EmailInvalidException extends RuntimeException {

    public EmailInvalidException(String msg) {
        super(msg);
    }

    public EmailInvalidException(RuntimeException e, String msg) {
        super(msg, e);
    }

}
