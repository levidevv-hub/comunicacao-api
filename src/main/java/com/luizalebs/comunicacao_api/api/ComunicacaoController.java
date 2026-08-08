package com.luizalebs.comunicacao_api.api;

import com.luizalebs.comunicacao_api.api.dto.ComunicacaoInDTO;
import com.luizalebs.comunicacao_api.api.dto.ComunicacaoOutDTO;
import com.luizalebs.comunicacao_api.business.service.ComunicacaoService;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comunicacao")
@Tag(name = "comunicacao", description = "Agendamento e cancelamento de email")
public class ComunicacaoController {

    private final ComunicacaoService service;

    public ComunicacaoController(ComunicacaoService service) {
        this.service = service;
    }

    @PostMapping("/agendar")
    @Operation(summary = "Agendar um email", description = "Cria um novo email")
    @ApiResponse(responseCode = "400", description = "Dados do corpo inválidos")
    @ApiResponse(responseCode = "200", description = "Email enviado com sucesso")
    @ApiResponse(responseCode = "500", description = "Error de servidor")
    public ResponseEntity<ComunicacaoOutDTO> agendar(@RequestBody ComunicacaoInDTO dto)  {
        return ResponseEntity.ok(service.agendarComunicacao(dto));
    }

    @GetMapping()
    @Operation(summary = "Buscar email", description = "buscar email enviado")
    @ApiResponse(responseCode = "400", description = "Dados do corpo inválidos")
    @ApiResponse(responseCode = "200", description = "Email buscado com sucesso")
    @ApiResponse(responseCode = "500", description = "Error de servidor")
    public ResponseEntity<ComunicacaoOutDTO> buscarStatus(@RequestParam String emailDestinatario) {
        return ResponseEntity.ok(service.buscarStatusComunicacao(emailDestinatario));
    }

    @PatchMapping("/cancelar")
    @Operation(summary = "Cancelar email", description = "cancelar email enviado")
    @ApiResponse(responseCode = "400", description = "Dados do corpo inválidos")
    @ApiResponse(responseCode = "200", description = "Email cancelado com sucesso")
    @ApiResponse(responseCode = "500", description = "Error de servidor")
    public ResponseEntity<ComunicacaoOutDTO> cancelarStatus(@RequestParam String emailDestinatario) {
        return ResponseEntity.ok(service.alterarStatusComunicacao(emailDestinatario));
    }
}
