package com.gavea.controlador;

import com.gavea.servico.RastreamentoService;
import com.gavea.dominio.VagaAplicada;
import com.gavea.repositorio.VagaAplicadaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagasController {

    private final VagaAplicadaRepository vagaAplicadaRepository;
    private final RastreamentoService rastreamentoService;

    public VagasController(VagaAplicadaRepository vagaAplicadaRepository, RastreamentoService rastreamentoService) {
        this.vagaAplicadaRepository = vagaAplicadaRepository;
        this.rastreamentoService = rastreamentoService;
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<VagaAplicada>> listarVagasPorUsuario(@PathVariable Integer idUsuario) {
        List<VagaAplicada> vagas = vagaAplicadaRepository.findByUsuarioIdUsuario(idUsuario);
        return ResponseEntity.ok(vagas);
    }

    @PostMapping("/sincronizar/{idUsuario}")
    public ResponseEntity<Void> dispararSincronizacao(@PathVariable Integer idUsuario) {
        rastreamentoService.sincronizarVagas(idUsuario);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/manual")
    public ResponseEntity<VagaAplicada> registrarVagaManual(@RequestBody VagaAplicada novaVaga) {
        VagaAplicada salva = rastreamentoService.registrarVagaManual(novaVaga);
        return ResponseEntity.ok(salva);
    }

    
}
