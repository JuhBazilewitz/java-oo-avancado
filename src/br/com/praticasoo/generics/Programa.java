package br.com.praticasoo.generics;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class Programa {

    public static void main(String[] args) {
        Aparelho<TV> tv = new Aparelho<TV>(new TV("12345"));
        Aparelho<Radio> radio = new Aparelho<Radio>(new Radio("67890"));
        
        System.out.println(tv.getTipoObjeto());
        System.out.println(radio.getTipoObjeto());
        
        Celular<String, String> celular = new Celular<String, String>("S9", "Vivo");
        System.out.println(celular.getModelo());
        System.out.println(celular.getOperadora());
    }
}
