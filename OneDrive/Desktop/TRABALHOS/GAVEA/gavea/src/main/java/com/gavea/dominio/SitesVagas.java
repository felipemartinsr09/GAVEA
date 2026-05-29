package com.gavea.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_SITE_VAGA")
public class SitesVagas {

    @Id
    @Column(name = "URLSite")
    private String urlSite;

    @Column(name = "NomeSite", nullable = false, length = 100)
    private String nomeSite;

    @Column(name = "EmailUsuarioSite", length = 100)
    private String emailUsuarioSite;

    @Column(name = "SenhaCriptografada", length = 255)
    private String senhaCriptografada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", nullable = false)
    private Usuario usuario;

    public SitesVagas() {
    }

    public String getUrlSite() {
        return urlSite;
    }

    public void setUrlSite(String urlSite) {
        this.urlSite = urlSite;
    }

    public String getNomeSite() {
        return nomeSite;
    }

    public void setNomeSite(String nomeSite) {
        this.nomeSite = nomeSite;
    }

    public String getEmailUsuarioSite() {
        return emailUsuarioSite;
    }

    public void setEmailUsuarioSite(String emailUsuarioSite) {
        this.emailUsuarioSite = emailUsuarioSite;
    }

    public String getSenhaCriptografada() {
        return senhaCriptografada;
    }

    public void setSenhaCriptografada(String senhaCriptografada) {
        this.senhaCriptografada = senhaCriptografada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}