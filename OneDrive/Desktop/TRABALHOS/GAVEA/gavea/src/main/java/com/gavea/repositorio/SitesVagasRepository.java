package com.gavea.repositorio;

import com.gavea.dominio.SitesVagas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SitesVagasRepository extends JpaRepository<SitesVagas, String> {
    List<SitesVagas> findByUsuarioIdUsuario(Integer idUsuario);
    Optional<SitesVagas> findByUrlSiteAndUsuarioIdUsuario(String urlSite, Integer idUsuario);
}