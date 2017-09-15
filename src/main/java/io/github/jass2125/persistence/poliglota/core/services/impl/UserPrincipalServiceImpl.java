/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.services.impl;

import io.github.jass2125.persistence.poliglota.core.dao.client.UserPrincipalDao;
import io.github.jass2125.persistence.poliglota.core.entity.UserPrincipal;
import io.github.jass2125.persistence.poliglota.core.services.client.UserPrincipalService;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:22:29
 */
public class UserPrincipalServiceImpl implements UserPrincipalService {

    @Inject
    private UserPrincipalDao userDao;

    @Override
    public UserPrincipal searchUserByEmailAndPassword(UserPrincipal userPrincipal) {
        return userDao.searchUserPrincipalByEmailAndPassword(userPrincipal);
    }

}
