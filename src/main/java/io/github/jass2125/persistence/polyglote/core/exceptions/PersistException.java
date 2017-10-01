/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.exceptions;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 30/09/2017 18:06:37
 */
public class PersistException extends RuntimeException {

    public PersistException(Exception e, String msg) {
        super(msg, e);
    }

}
