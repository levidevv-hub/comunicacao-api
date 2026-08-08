## Endpoints da Aplicação
- **POST /comunicacao/agendar**: Agenda uma nova tarefa.
- O dto deve ser preenchido com os seguintes dados: {“dataHoraEnvio”: “ “ , “nomeDestinatario”: “”, "emailDestinatario" : "", "telefoneDestinatario": "",
- "mensagem": "", "modeDeEnvio" : ""}
- **GET /comunicacao?emailDestinatario=email@email.com: Lista status de email.
- **PATCH /comunicacao/cancelar?emailDestinatario=email@email.com: Cancela email
