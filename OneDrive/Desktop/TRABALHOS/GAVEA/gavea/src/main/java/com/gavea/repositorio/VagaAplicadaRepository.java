package com.gavea.repositorio;

import com.gavea.dominio.VagaAplicada;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VagaAplicadaRepository extends JpaRepository<VagaAplicada, Integer> {
    List<VagaAplicada> findByUsuarioIdUsuario(Integer idUsuario);
    List<VagaAplicada> findByUsuarioIdUsuarioAndEtapaAtual(Integer idUsuario, Integer etapaAtual);
}
