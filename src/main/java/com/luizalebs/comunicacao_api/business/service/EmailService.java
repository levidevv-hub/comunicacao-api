package com.luizalebs.comunicacao_api.business.service;

import com.luizalebs.comunicacao_api.api.dto.ComunicacaoOutDTO;
import com.luizalebs.comunicacao_api.infraestructure.client.INotificacaoClient;
import com.luizalebs.comunicacao_api.infraestructure.enums.StatusEnvioEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private final INotificacaoClient client;

    public void enviarNotificacao(ComunicacaoOutDTO dto) {
        if (dto.getStatusEnvio().equals(StatusEnvioEnum.PENDENTE)) {
            client.enviarEmail(dto);
        }
    }

}
