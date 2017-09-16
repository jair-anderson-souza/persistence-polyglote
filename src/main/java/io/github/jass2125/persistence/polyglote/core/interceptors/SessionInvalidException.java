/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.persistence.polyglote.core.interceptors;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 16/09/2017 19:35:10
 */
public class SessionInvalidException extends RuntimeException {

    public SessionInvalidException(Exception e, String msg) {
        super(msg, e);
    }

}
