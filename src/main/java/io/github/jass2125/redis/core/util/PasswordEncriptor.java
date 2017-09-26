package io.github.jass2125.redis.core.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 20:52:55
 */
public interface PasswordEncriptor {

    public String encryptPassword(String password);

    public boolean comparatePassword(String passwordUser, String passwordForm);

}
