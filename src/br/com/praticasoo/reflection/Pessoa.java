package br.com.praticasoo.reflection;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public abstract class Pessoa {

    protected int codigo;
    protected String nome;
    
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}
