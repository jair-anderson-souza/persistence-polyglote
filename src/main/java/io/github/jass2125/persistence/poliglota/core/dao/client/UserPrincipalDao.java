/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.dao.client;

import io.github.jass2125.persistence.poliglota.core.entity.UserPrincipal;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:23:06
 */
public interface UserPrincipalDao {

    public UserPrincipal searchUserPrincipalByEmailAndPassword(UserPrincipal userPrincipal);

}
