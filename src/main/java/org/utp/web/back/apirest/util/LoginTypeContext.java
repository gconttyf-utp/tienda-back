package org.utp.web.back.apirest.util;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class LoginTypeContext {

    private boolean isUsuarioLogin;

    public boolean isUsuarioLogin() {
        return isUsuarioLogin;
    }

    public void setUsuarioLogin(boolean usuarioLogin) {
        this.isUsuarioLogin = usuarioLogin;
    }

}
