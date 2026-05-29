package com.gavea.repositorio;

import com.gavea.dominio.ProcessoSeletivo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Integer> {
    Optional<ProcessoSeletivo> findByNomeProcesso(String nomeProcesso);
}