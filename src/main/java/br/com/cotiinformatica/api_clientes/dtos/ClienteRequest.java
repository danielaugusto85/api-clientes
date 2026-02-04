package br.com.cotiinformatica.api_clientes.dtos;

/*
    Registro para definir os dados que a API irá
    receber para cadastrar ou atualizar um cliente
 */

public record ClienteRequest(
        String nome,
        String email,
        String telefone
) {
}
