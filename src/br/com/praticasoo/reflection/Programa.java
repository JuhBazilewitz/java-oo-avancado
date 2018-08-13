package br.com.praticasoo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class Programa {

    public static void main(String[] args) {
        Fornecedor fornecedor = new Fornecedor();
        Class<?> classeFornecedor = fornecedor.getClass();
        
        // Obter nome da da classe
        System.out.println(classeFornecedor.getName());
        
        // Obter atributos da classe
        for(Field atributo : classeFornecedor.getFields()) {
            System.out.println("Atributo: " + atributo.getName());
        }
        
        // Obter atributos da classe
        for(Field atributo : classeFornecedor.getDeclaredFields()) {
            System.out.println("Atributo: " + atributo.getName());
        }
        
        Class<Fornecedor> outroClassFornecedor = Fornecedor.class;
        
        fornecedor.setEndereco("Centro Histórico");
        
        System.out.println("Imprimindo coisas do Fornecedor");
        System.out.println("Endereço (antes de mudar):" + fornecedor.getEndereco());

        /*for(Field atributo : outroClassFornecedor.getDeclaredFields()) {
            System.out.println("Atributo de Fornecedor: " + atributo.getName());
            if(atributo.getName() == "endereco") {
                try {
                    atributo.set(fornecedor, "Moinhos");
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        }*/
        
        System.out.println("Endereço (depois de mudar): " + fornecedor.getEndereco());
        
        // Obter os métodos de uma classe
        for(Method metodo : outroClassFornecedor.getMethods()) {
            System.out.println("Nome do método: " + metodo.getName());
            System.out.println("-- Tipo de retorno: " + metodo.getReturnType());
            System.out.println("-- Quatidade de parâmetros: " + metodo.getParameterCount());
            
            for(Parameter param : metodo.getParameters()) {
                System.out.println("-- -- Paramêtro: " + param.getName());
                System.out.println("-- -- Tipo: " + param.getType());
            }
        }
        
        /* Metodo getSuperClass() retorna a superclasse de uma classe, se houver*/
        
        Class<?> classeMaeFornecedor = Fornecedor.class.getSuperclass();
        
        System.out.println("A superclasse de fornecedor é:" + classeMaeFornecedor.getSimpleName());
        
        /*A classe modifier permite averiguar qual ou quais modificadores foram informados em uma classe ou método.
          O método getModifiers() retorna uma lista de modificadores informados na criação da classe.
          Como por exemplo abstract, public, static, final etc...
          O método getModifiers() também pode ser consumido atraves do objeto Method.
          O método getModifiers() também pode ser consumido atraves do objeto Field.*/
        
        Boolean fornecedorEhAbstrato = Modifier.isAbstract(Fornecedor.class.getModifiers());
        Boolean pessoaEhAbstrato = Modifier.isAbstract(Pessoa.class.getModifiers());
        
        System.out.println("Fornecedor é abstrato? " + fornecedorEhAbstrato);
        System.out.println("Pessoa é abstrato? " + pessoaEhAbstrato);
        
        /*O método getConstructor() retorna os construtores definidos em uma classe.
          */
        
        try {
            /*Identificamos os dois construtores da classe fornecedor*/
            Constructor<?> construtorA = classeFornecedor.getConstructor();
            Constructor<?> construtorB = classeFornecedor.getConstructor(String.class, String.class);
            
            /*Instanciamos dois objetos, atraves dos dois construtores identificados*/
            Fornecedor fornecedorLoko = (Fornecedor) construtorA.newInstance();
            Fornecedor fornecedorNormal = (Fornecedor) construtorB.newInstance("Floresta", "11.111");
            
            /*Imprime o endereço de cada umdos fornecedores instaciados*/
            System.out.println("Endereço do loko: " + fornecedorLoko.getEndereco());
            System.out.println("Endereço do normal: " + fornecedorNormal.getEndereco());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                
    }
}
