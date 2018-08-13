package br.com.praticasoo.reflection;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
@Desenvolvedor(nome="Fabio", perfil="Sênior")
@LogUnicred
public class Credito {

    private double valor;
    private double limte;
    
    @Critico
    public void calcularTaxa() {
        
    }
    
    @Critico("É crítico porque é grana!!!")
    public void calcularPrazo() {
        
    }
    
    public void calcularResidual() {
        
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getLimte() {
        return limte;
    }
    
    public void setLimte(double limte) {
        this.limte = limte;
    }
}
