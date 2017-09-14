/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.poliglota.core.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 13/09/2017 20:02:52
 */
@Entity
public class UserPrincipal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;

    public UserPrincipal() {
    }

    public UserPrincipal(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) throws RuntimeException {
//        if (id == null) {
//            throw new RuntimeException("O Id está null!!");
//        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new RuntimeException("O nome está null!!");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new RuntimeException("O email está null!!");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new RuntimeException("A senha está null!!");
        }
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserPrincipal other = (UserPrincipal) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "UserPrincipal{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + '}';
    }

}
