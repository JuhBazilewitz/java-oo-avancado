package br.com.praticasoo.reflection;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class ProgramaAnnotation {

    public static void main(String[] args) {
        Logger credito = new Logger(new Credito());
        Logger investimento = new Logger(new Investimento());
        
        credito.logar();
        investimento.logar();
    }
}
