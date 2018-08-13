package br.com.praticasoo.exercicio;

import java.util.Date;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class Conta implements Entidade{

    private String codigo;
    private Date dataAbertura;
    private double valor;
    
    public Conta(String codigo, Date dataAbertura) {
        this.codigo = codigo;
        this.dataAbertura = dataAbertura;
        this.valor = 0;
    }
    
    public void salvar() {
        System.out.println("Salvando conta...");
    }

    @Override
    public int getIdentificador() {
        return Integer.parseInt(this.codigo);
    }
}
