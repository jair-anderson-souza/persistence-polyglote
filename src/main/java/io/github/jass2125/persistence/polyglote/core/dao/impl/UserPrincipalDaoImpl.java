/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.dao.impl;

import io.github.jass2125.persistence.polyglote.core.annotations.TransactionalPersistence;
import io.github.jass2125.persistence.polyglote.core.exceptions.LoginInvalidException;
import io.github.jass2125.persistence.polyglote.core.exceptions.QuerySyntaxException;
import io.github.jass2125.persistence.polyglote.core.dao.client.UserPrincipalDao;
import io.github.jass2125.persistence.polyglote.core.entity.UserPrincipal;
import io.github.jass2125.persistence.polyglote.core.exceptions.DuplicateCredentialException;
import io.github.jass2125.persistence.polyglote.core.exceptions.EmailException;
import io.github.jass2125.persistence.polyglote.core.exceptions.NoUserException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:20:04
 */
public class UserPrincipalDaoImpl implements UserPrincipalDao {

    @Inject
    private EntityManager em;

    @Override
    public UserPrincipal searchUserPrincipalByEmailAndPassword(UserPrincipal userPrincipal) {
        checkQuantity(userPrincipal.getEmail());
        UserPrincipal user = checkUser(userPrincipal);
        return user;
    }

    @Override
    @TransactionalPersistence
    public UserPrincipal updateUserPrincipal(UserPrincipal userPrincipal) {
        return em.merge(userPrincipal);
    }

    private void checkQuantity(String email) {
        int countEmails = countEmails(email);
        if (countEmails > 1) {
            throw new EmailException("Já existe um usuário com esse e-mail cadastrado.");
        }
    }

    public int countEmails(String email) {
        Query query = createQuery("SELECT COUNT(U.id) FROM UserPrincipal U WHERE U.email = :email").setParameter("email", email);
        List<UserPrincipal> retrieveResultList = retrieveResultList(query);
        return retrieveResultList.size();
    }

    private Query createQuery(String query) {
        try {
            Query q = em.createQuery(query);
            return q;
        } catch (IllegalArgumentException e) {
            throw new QuerySyntaxException(e, "Não foi possível criar a consulta!!");
        }
    }

    private List<UserPrincipal> retrieveResultList(Query query) {
        List<UserPrincipal> listUserPrincipal = query.getResultList();
        return listUserPrincipal;
    }

    public UserPrincipal checkUser(UserPrincipal user) {
        Query query = createQuery("SELECT U FROM UserPrincipal U WHERE U.email = :email AND U.password = :password").setParameter("email", user.getEmail()).setParameter("password", user.getPassword());
        UserPrincipal userFind = retrieveSingleResult(query);
        if (isNil(userFind)) {
            throw new LoginInvalidException("Os dados estão inválidos, tente novamente.");
        }
        return userFind;
    }

    private boolean isNil(UserPrincipal user) {
        return user == null;
    }

    private UserPrincipal retrieveSingleResult(Query query) {
        try {
            return (UserPrincipal) query.getSingleResult();
        } catch (NoResultException e) {
            throw new NoUserException(e, "Objeto não foi encontrado");
        } catch (NonUniqueResultException e) {
            throw new DuplicateCredentialException(e, "Existe mais um usuário com essas credenciais!");
        }
    }

}
