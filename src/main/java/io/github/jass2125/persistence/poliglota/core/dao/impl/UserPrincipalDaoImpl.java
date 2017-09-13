/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.dao.impl;

import io.github.jass2125.persistence.poliglota.core.dao.client.UserPrincipalDao;
import io.github.jass2125.persistence.poliglota.core.entity.UserPrincipal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:20:04
 */
public class UserPrincipalDaoImpl implements UserPrincipalDao{

    @PersistenceContext
    private EntityManager em;

    public void persist(UserPrincipal userPrincipal) {
        em.persist(userPrincipal);
    }

}
