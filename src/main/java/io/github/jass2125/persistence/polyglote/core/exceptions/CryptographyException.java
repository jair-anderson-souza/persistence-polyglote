package io.github.jass2125.persistence.polyglote.core.exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 25/09/2017 20:59:57
 */
public class CryptographyException extends RuntimeException {

    public CryptographyException(Exception e, String msg) {
        super(msg, e);
    }

}
