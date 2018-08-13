package br.com.praticasoo.exercicio;

public class Programa {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("12345", "Ana", "5235233523");
        Repositorio<Cliente> repoCliente = new Repositorio<Cliente>();
        
        repoCliente.adicionarItem(cliente);
        
        repoCliente.salvarTodos();
    }
}
