package br.com.annotation.exercicio;


/**
 * 
 * @author juliane.bazilewitz
 *
 */
@Tabela(nome = "cliente")
public class Cliente {

    private int codigo;
    private String nome;
    private String cpf;
    
    @Chave(chave=true)
    @Coluna(nome="cd_cliente")
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Coluna(nome="nm_cliente")
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Coluna(nome="cpf")
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
