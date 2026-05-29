package com.gavea.dominio;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_PROCESSO_SELETIVO")
public class ProcessoSeletivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcessoSeletivo;

    @Column(name = "NomeProcesso", length = 100)
    private String nomeProcesso;

    @OneToMany(mappedBy = "processoSeletivo", cascade = CascadeType.ALL)
    private List<Etapa> etapas;

    public ProcessoSeletivo() {
    }

    public Integer getIdProcessoSeletivo() {
        return idProcessoSeletivo;
    }

    public void setIdProcessoSeletivo(Integer idProcessoSeletivo) {
        this.idProcessoSeletivo = idProcessoSeletivo;
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }
}