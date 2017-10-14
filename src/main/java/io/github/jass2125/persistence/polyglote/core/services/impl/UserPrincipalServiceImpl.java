/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.services.impl;

import io.github.jass2125.persistence.polyglote.core.dao.client.UserPrincipalDao;
import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import io.github.jass2125.persistence.polyglote.core.exceptions.EmailInvalidException;
import io.github.jass2125.persistence.polyglote.core.exceptions.NoUserException;
import io.github.jass2125.persistence.polyglote.core.services.client.UserPrincipalService;
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
        try {
            UserPrincipal user = userDao.searchUserPrincipalByEmailAndPassword(userPrincipal);
            return user;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserPrincipal update(UserPrincipal userPrincipal) {
        UserPrincipal user = userDao.searchUserByEmail(userPrincipal.getEmail());
        if (!isNil(user)) {
            throw new EmailInvalidException("Email inválido");
        }
        return userDao.updateUserPrincipal(userPrincipal);
    }

    @Override
    public UserPrincipal save(UserPrincipal newUser) {
        try {
            UserPrincipal user = userDao.searchUserByEmail(newUser.getEmail());
            if (!isNil(user)) {
                throw new EmailInvalidException("Email inválido.");
            }
            this.userDao.persiste(newUser);
        } catch (NoUserException e) {
        }
        return null;
    }

    private boolean isNil(UserPrincipal user) {
        return user == null;
    }

}
