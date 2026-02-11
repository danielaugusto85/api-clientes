package br.com.cotiinformatica.api_clientes.controllers;


import br.com.cotiinformatica.api_clientes.dtos.ClienteRequest;
import br.com.cotiinformatica.api_clientes.entities.Cliente;
import br.com.cotiinformatica.api_clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    /*
        Método para criar um serviço
        de cadastro de cliente
     */
    @PostMapping
    public String post(@RequestBody ClienteRequest request) {
        try {

            var cliente = new Cliente(); //Criando um objeto da entidade

            cliente.setNome(request.nome()); //capturando o nome do cliente
            cliente.setEmail(request.email()); //capturando o email do cliente
            cliente.setTelefone(request.telefone()); //capturando o telefone do cliente

            clienteRepository.inserir(cliente);

            return "Cliente cadastrado com sucesso";

        }
        catch (Exception e) {
            return "Falha ao inserir cliente:  " + e.getMessage();
        }
    }

@GetMapping("{nome}")
public List<Cliente> getClientes(@PathVariable String nome) {

        try{
            //Consultar os clientes pelo nome e retornar a lista obtida do banco
            return clienteRepository.obterPorNome(nome);
        }
        catch (Exception e){
            e.printStackTrace(); //Exibir o log do erro no terminal do IntelliJ
            return null;
        }

    }

}
