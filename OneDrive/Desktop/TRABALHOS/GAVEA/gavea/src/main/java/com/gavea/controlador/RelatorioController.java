package com.gavea.controlador;

import com.gavea.servico.RelatorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/status/{idUsuario}")
    public ResponseEntity<Map<String, Object>> getRelatorioStatus(@PathVariable Integer idUsuario) {
        Map<String, Object> dadosRelatorio = relatorioService.gerarRelatorioStatus(idUsuario);
        return ResponseEntity.ok(dadosRelatorio);
    }

    @GetMapping("/tempo-medio/{idUsuario}")
    public ResponseEntity<Map<String, Object>> getTempoMedio(@PathVariable Integer idUsuario) {
        Map<String, Object> dadosTempo = relatorioService.calcularTempoMedioPorEtapa(idUsuario);
        return ResponseEntity.ok(dadosTempo);
    }
}