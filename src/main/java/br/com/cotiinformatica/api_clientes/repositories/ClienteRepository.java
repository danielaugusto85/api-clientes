package br.com.cotiinformatica.api_clientes.repositories;

import br.com.cotiinformatica.api_clientes.entities.Cliente;
import br.com.cotiinformatica.api_clientes.factories.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

    @Autowired
    private ConnectionFactory connectionFactory;

    /*
        Método para inserir um cliente no banco de dados
     */
    public void inserir(Cliente cliente) throws Exception {

        //Escrever o comando SQL que será executado no banco de dados
        var sql = """
                    INSERT INTO clientes(nome, email, telefone)
                    VALUES (?, ?, ?)
                """;

        //Abrir conexão com o banco de dados
        var connection = connectionFactory.getConnection();

        //Preparando o comando para ser executado no banco de dados
        var statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getTelefone());
        statement.execute(); //Executando o comando SQL

        connection.close(); //Fechar a conexão

    }
}