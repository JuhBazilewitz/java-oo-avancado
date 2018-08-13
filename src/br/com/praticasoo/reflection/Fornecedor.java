package br.com.praticasoo.reflection;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class Fornecedor extends Pessoa{

    private String endereco;
    private String cnpj;
    
    public Fornecedor() {
        this.endereco = "Rubem Berta";
    }
    
    public Fornecedor(String endereco, String cnpj) {
        this.endereco = endereco;
        this.cnpj = cnpj;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
