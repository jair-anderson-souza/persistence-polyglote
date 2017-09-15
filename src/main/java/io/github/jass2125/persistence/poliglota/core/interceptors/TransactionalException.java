/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.interceptors;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 14/09/2017 12:47:22
 */
public class TransactionalException extends RuntimeException {

    public TransactionalException(Exception e, String msg) {
        super(msg, e);
    }

}
