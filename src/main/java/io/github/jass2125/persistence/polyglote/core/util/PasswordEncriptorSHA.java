package io.github.jass2125.persistence.polyglote.core.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Jul 4, 2017 1:10:41 PM
 */
public class PasswordEncriptorSHA implements PasswordEncriptor {

    @Inject
    private GeneratorAlgorithmCryptography cryptographer;
    private String passwordToCryptography;
    private String passwordEncrypted;

    public PasswordEncriptorSHA() {
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    @Override
    public String encryptPassword(String password) {
        this.setPasswordToCryptography(this.cryptographer.digest(password));
        return this.passwordToCryptography;
    }

    public void setPasswordToCryptography(String passwordToCryptography) {
        this.passwordToCryptography = passwordToCryptography;
    }

    @Override
    public boolean comparatePassword(String passwordUser, String passwordForm) {
        setPasswordEncrypted(passwordUser);
        String passwordInHash = cryptographer.digest(passwordForm);
        setPasswordToCryptography(passwordInHash);
        return this.verifyIfPasswordIsEquals();
    }

    private boolean verifyIfPasswordIsEquals() {
        return passwordToCryptography.equals(passwordEncrypted);
    }
}
