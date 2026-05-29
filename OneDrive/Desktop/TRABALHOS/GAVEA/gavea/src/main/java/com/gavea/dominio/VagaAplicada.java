package com.gavea.dominio;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_VAGA_APLICADA")
public class VagaAplicada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVagaAplicada;

    @Column(name = "NomeVaga", nullable = false, length = 255)
    private String nomeVaga;

    @Column(name = "DataAplicacao", nullable = false)
    private LocalDate dataAplicacao;

    @Column(name = "LinkVaga", length = 500)
    private String linkVaga;

    @Column(name = "EtapaAtual", nullable = false)
    private Integer etapaAtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "URLSite", nullable = false)
    private SitesVagas siteVaga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdProcessoSeletivo")
    private ProcessoSeletivo processoSeletivo;

    public VagaAplicada() {
    }
    public Integer getIdVagaAplicada() {
        return idVagaAplicada;
    }

    public void setIdVagaAplicada(Integer idVagaAplicada) {
        this.idVagaAplicada = idVagaAplicada;
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getLinkVaga() {
        return linkVaga;
    }

    public void setLinkVaga(String linkVaga) {
        this.linkVaga = linkVaga;
    }

    public Integer getEtapaAtual() {
        return etapaAtual;
    }

    public void setEtapaAtual(Integer etapaAtual) {
        this.etapaAtual = etapaAtual;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public SitesVagas getSiteVaga() {
        return siteVaga;
    }

    public void setSiteVaga(SitesVagas siteVaga) {
        this.siteVaga = siteVaga;
    }

    public ProcessoSeletivo getProcessoSeletivo() {
        return processoSeletivo;
    }

    public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
        this.processoSeletivo = processoSeletivo;
    }
}