package br.com.praticasoo.exercicio;

import br.com.praticasoo.exercicio.Entidade;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class Cliente implements Entidade{

    private String codigo;
    private String nome;
    private String rg;
    
    public Cliente(String codigo, String nome, String rg) {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
    }
    
    public void salvar() {
        System.out.println("Salvando cliente " + this.nome);
    }
    
    public void remover(String codigo) {
    
    }

    @Override
    public int getIdentificador() {
        return Integer.parseInt(this.codigo);
    }
}
