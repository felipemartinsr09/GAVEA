package com.gavea.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ETAPA")
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtapa;

    @Column(name = "NomeEtapa", length = 100)
    private String nomeEtapa;

    @Column(name = "Ordem")
    private Integer ordem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdProcessoSeletivo", nullable = false)
    private ProcessoSeletivo processoSeletivo;

    public Etapa() {
    }
    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }
}