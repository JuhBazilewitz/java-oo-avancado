package br.com.praticasoo.generics;

/**
 * 
 * @author juliane.bazilewitz
 *
 * @param <T>
 */
public class Aparelho<T extends AparelhoEletronico> {

    private T objeto;
    
    public Aparelho(T objeto) {
        this.objeto = objeto;
    }
    
    public T getObjeto() {
        return this.objeto;
    }
    
    public String getTipoObjeto() {
        return String.valueOf(this.objeto.getClass().getSimpleName());
    }
    
    public String getSerialDoObjeto() {
        return this.objeto.getSerial();
    }
}

abstract class AparelhoEletronico {
    
    private String numeroSerial;
    
    public AparelhoEletronico(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }
    
    public String getSerial() {
        return this.numeroSerial;
    }
}

class TV extends AparelhoEletronico{
    
    public TV(String numeroSerial) {
        super(numeroSerial);
    }

}

class Radio extends AparelhoEletronico {

    public Radio(String numeroSerial) {
        super(numeroSerial);
    }
    
}

class Videocassete extends AparelhoEletronico {

    public Videocassete(String numeroSerial) {
        super(numeroSerial);
    }
    
}

// Exemplo de restrição por interface - inicio
interface AparelhoDigital {
    void operacaoA();
    void operacaoB();
}

class RadioRelogio<T extends AparelhoDigital> {
    private T objeto;
    
    public void executarOperacaoA() {
        this.objeto.operacaoA();
    }
}
//Exemplo de restrição por interface - fim

//Exemplo de multiplos tipos Generics
class Celular<T1 extends String, T2 extends String> {
    
    private T1 modelo;
    private T2 operadora;
    
    public Celular(T1 modelo, T2 operadora) {
        this.modelo = modelo;
        this.operadora = operadora;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getOperadora() {
        return this.operadora;
    }

}