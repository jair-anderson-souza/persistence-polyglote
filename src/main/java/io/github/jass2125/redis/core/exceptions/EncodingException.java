/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.exceptions;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Jul 4, 2017 1:35:52 PM
 */
public class EncodingException extends RuntimeException {

    public EncodingException() {
    }

    public EncodingException(UnsupportedEncodingException e, String msg) {
    }

}
