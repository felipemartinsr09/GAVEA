package com.gavea.servico;

import com.gavea.dominio.SitesVagas;
import com.gavea.dominio.VagaAplicada;
import com.gavea.repositorio.SitesVagasRepository;
import com.gavea.repositorio.VagaAplicadaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RastreamentoService {

    private final SitesVagasRepository sitesVagasRepository;
    private final VagaAplicadaRepository vagaAplicadaRepository;

    public RastreamentoService(
            SitesVagasRepository sitesVagasRepository,
            VagaAplicadaRepository vagaAplicadaRepository) {
        this.sitesVagasRepository = sitesVagasRepository;
        this.vagaAplicadaRepository = vagaAplicadaRepository;
    }

    @Transactional
    public SitesVagas cadastrarCredenciais(SitesVagas credencial) {
        return sitesVagasRepository.save(credencial);
    }

    @Transactional
    public VagaAplicada registrarVagaManual(VagaAplicada novaVaga) {
        return vagaAplicadaRepository.save(novaVaga);
    }

    @Transactional
    public VagaAplicada atualizarStatusManual(Integer idVaga, Integer novaEtapa) {
        VagaAplicada vaga = vagaAplicadaRepository.findById(idVaga)
                .orElseThrow(() -> new IllegalArgumentException("Vaga não encontrada."));
        vaga.setEtapaAtual(novaEtapa);
        return vagaAplicadaRepository.save(vaga);
    }

    public void sincronizarVagas(Integer idUsuario) {
        List<SitesVagas> credenciais = sitesVagasRepository.findByUsuarioIdUsuario(idUsuario);
        System.out.println("Sincronização iniciada para " + credenciais.size() + " sites.");
    }
}