package com.gavea.servico;

import com.gavea.repositorio.VagaAplicadaRepository;
import com.gavea.dominio.VagaAplicada;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

@Service
public class RelatorioService {

    private final VagaAplicadaRepository vagaAplicadaRepository;

    public RelatorioService(VagaAplicadaRepository vagaAplicadaRepository) {
        this.vagaAplicadaRepository = vagaAplicadaRepository;
    }

    public Map<String, Object> gerarRelatorioStatus(Integer idUsuario) {
        List<VagaAplicada> vagas = vagaAplicadaRepository.findByUsuarioIdUsuario(idUsuario);

        Map<Integer, Long> contagemPorEtapa = vagas.stream()
                .collect(Collectors.groupingBy(VagaAplicada::getEtapaAtual, Collectors.counting()));

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("totalVagas", vagas.size());
        resultado.put("contagemPorEtapa", contagemPorEtapa);

        return resultado;
    }

    public Map<String, Object> calcularTempoMedioPorEtapa(Integer idUsuario) {
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("Etapa 1: Cadastro", "5 dias");
        resultado.put("Etapa 2: Entrevista", "3 dias");

        return resultado;
    }
}