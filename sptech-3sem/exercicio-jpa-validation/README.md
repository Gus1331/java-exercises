# Prática de JPA e Bean Validation
Exercício para práticar o conteúdo visto em aula.

## Endpoints

---

### POST /eventos
Cria um novo evento.

### GET /eventos
Retorna todos os eventos.

### GET /eventos/{id}
Retorna um evento específico.

### GET /eventos/gratuitos
Retorna todos os eventos gratuitos.

### GET /eventos/data?ocorrencia={ocorrencia}
Retorna todos os eventos que **ocorrem/ocorreram ou foram publicados** na data informada. Utilize RequestParam para receber a data.
- Pode ser data do evento ou data de publicação.

### GET /eventos/periodo?inicio={inicio}&fim={fim}
Retorna todos os eventos que **ocorrem/ocorreram** no período informado. Utilize RequestParam para receber as datas.
- Validação: A data de início não pode ser maior que a data de fim.

### DELETE /eventos/{id}
Deleta um evento.

### PUT /eventos/{id}
Atualiza um evento. Você deve considerar:
- Nome e local são obrigatórios. 
- Se o evento estiver cancelado ou já tiver ocorrido, o pedido nao pode ser processado (422).

### PATCH /eventos/{id}/cancelamento
Cancela um evento. Você deve considerar:
- Se o evento já estiver cancelado ou já tiver ocorrido, o pedido nao pode ser processado (422).

## Modelos

---

### Entidade: Evento
```json
{
  "id": 1,
  "nome": "Evento 1",
  "local": "Local 1",
  "dataEvento": "2025-04-01",
  "dataPublicacao": "2024-16-09",
  "gratuito": true,
  "cancelado": false
}
```

Validações:
- nome
  - Não pode ser nulo, vazio ou conter somente espaço em branco.
  - Deve ter no mínimo 5 caracteres e no máximo 100.
- local
    - Não pode ser nulo, vazio ou conter somente espaço em branco.
    - Deve ter no mínimo 5 caracteres e no máximo 150.
- dataEvento
  - Não pode ser nula.
  - Deve ser uma data futura ou presente.

OBS: NÃO ALTERAR MENSAGEM DE ERRO DAS VALIDAÇÕES.

---
### Json de resposta:
```json
{
  "id": 2,
  "nome": "Teste evento 1",
  "local": "Teste Local 1",
  "dataEvento": "2025-04-01",
  "dataPublicacao": "2024-16-09",
  "gratuito": false,
  "cancelado": false,
  "status": "ABERTO" // Campo calculado
}
```

Os status possíveis são:
- CANCELADO (Evento que foi cancelado)
- FINALIZADO (Evento que já ocorreu - data no passado ao dia de hoje)
- ABERTO

---
- ## As entidades não devem ser expostas diretamente pelos endpoints;