/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.exceptions;

import javax.persistence.NonUniqueResultException;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 15/09/2017 19:44:06
 */
public class DuplicateCredentialException extends RuntimeException {

    public DuplicateCredentialException(NonUniqueResultException e, String msg) {
        super(msg, e);
    }

}
