package org.utp.web.back.ejb.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ubigeo")
public class Ubigeo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_ubigeo")
    private String codUbigeo;

    @Column(name = "txt_ubigeo")
    private String txtUbigeo;

    @Column(name = "cod_ubigeo_padre")
    private String codUbigeoPadre;

    public String getCodUbigeo() {
        return codUbigeo;
    }

    public void setCodUbigeo(String codUbigeo) {
        this.codUbigeo = codUbigeo;
    }

    public String getTxtUbigeo() {
        return txtUbigeo;
    }

    public void setTxtUbigeo(String txtUbigeo) {
        this.txtUbigeo = txtUbigeo;
    }

    public String getCodUbigeoPadre() {
        return codUbigeoPadre;
    }

    public void setCodUbigeoPadre(String codUbigeoPadre) {
        this.codUbigeoPadre = codUbigeoPadre;
    }

    @Override
    public String toString() {
        return "Ubigeo {codUbigeo=" + codUbigeo + ", txtUbigeo=" + txtUbigeo + ", codUbigeoPadre=" + codUbigeoPadre
                + "}";
    }
    
}
