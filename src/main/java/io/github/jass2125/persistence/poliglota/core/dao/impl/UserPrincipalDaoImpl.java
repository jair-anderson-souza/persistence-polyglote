/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.dao.impl;

import io.github.jass2125.persistence.poliglota.core.annotations.Transactional;
import io.github.jass2125.persistence.poliglota.core.dao.client.UserPrincipalDao;
import io.github.jass2125.persistence.poliglota.core.entity.UserPrincipal;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:20:04
 */
public class UserPrincipalDaoImpl implements UserPrincipalDao {

    @Inject
    private EntityManager em;

    @Override

    @Transactional
    public void persist(UserPrincipal userPrincipal) {
        try {
            boolean open = em.isOpen();
            System.out.println(open);
            em.persist(userPrincipal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
