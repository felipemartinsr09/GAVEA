package com.gavea.repositorio;

import com.gavea.dominio.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EtapaRepository extends JpaRepository<Etapa, Integer> {
    List<Etapa> findByProcessoSeletivoIdProcessoSeletivo(Integer idProcessoSeletivo);
}