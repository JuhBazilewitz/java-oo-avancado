package br.com.annotation.exercicio;

import java.util.List;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class Programa {

    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.setCodigo(1);
        c.setCpf("12334456789");
        c.setNome("Ana");
        
        DBPersistence<Cliente> cliente = new DBPersistence<Cliente>(c);
        int valor = cliente.getValorChave();
        System.out.println(valor);
       
        String atributo = cliente.getChave();
        System.out.println(atributo);

        List<String> colunas = cliente.getColunas();
        System.out.println("-------------");
        for(String coluna : colunas) {
            System.out.println(coluna);
        }
        System.out.println("-------------");
        
        String allQuery = cliente.getAllQuery();
        System.out.println(allQuery);
        
        String byId = cliente.getById(c.getCodigo());
        System.out.println(byId);
        
        String insert = cliente.insert(c.getCodigo(), c.getNome(), c.getCpf());
        System.out.println(insert);
    }
}



/*
 br.com.annotatoin.exercicio

Criar uma anotação para Tabela (type) => nome da tabela
Criar uma anotação para Coluna (field) => nome do campo na tabela
Criar uma anotação para Chave (field) => true/false

Criar uma classe Cliente com alguns atributos

Criar classes adicionais para mapear

Criar uma classe Gerenciador de DB (Generic)
    getCampoChave(); => cd_cliente 
    getValorCampoChave(); => 222
    getColunas(); => cd_cliente, nm_cliente, dt_cadastro etc...
    getAllQuery(); => select (campos da tabela) from tb_cliente
    getByIdQuery(); => select (campos da tabela) from tb_cliente where cd_cliente = 222
    getInsertQuery(); => insert into tb_cliente (todos os campos) values()
    */
