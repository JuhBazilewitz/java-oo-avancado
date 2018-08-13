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
        
        fornecedor.setEndereco("Centro Hist�rico");
        
        System.out.println("Imprimindo coisas do Fornecedor");
        System.out.println("Endere�o (antes de mudar):" + fornecedor.getEndereco());

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
        
        System.out.println("Endere�o (depois de mudar): " + fornecedor.getEndereco());
        
        // Obter os m�todos de uma classe
        for(Method metodo : outroClassFornecedor.getMethods()) {
            System.out.println("Nome do m�todo: " + metodo.getName());
            System.out.println("-- Tipo de retorno: " + metodo.getReturnType());
            System.out.println("-- Quatidade de par�metros: " + metodo.getParameterCount());
            
            for(Parameter param : metodo.getParameters()) {
                System.out.println("-- -- Param�tro: " + param.getName());
                System.out.println("-- -- Tipo: " + param.getType());
            }
        }
        
        /* Metodo getSuperClass() retorna a superclasse de uma classe, se houver*/
        
        Class<?> classeMaeFornecedor = Fornecedor.class.getSuperclass();
        
        System.out.println("A superclasse de fornecedor �:" + classeMaeFornecedor.getSimpleName());
        
        /*A classe modifier permite averiguar qual ou quais modificadores foram informados em uma classe ou m�todo.
          O m�todo getModifiers() retorna uma lista de modificadores informados na cria��o da classe.
          Como por exemplo abstract, public, static, final etc...
          O m�todo getModifiers() tamb�m pode ser consumido atraves do objeto Method.
          O m�todo getModifiers() tamb�m pode ser consumido atraves do objeto Field.*/
        
        Boolean fornecedorEhAbstrato = Modifier.isAbstract(Fornecedor.class.getModifiers());
        Boolean pessoaEhAbstrato = Modifier.isAbstract(Pessoa.class.getModifiers());
        
        System.out.println("Fornecedor � abstrato? " + fornecedorEhAbstrato);
        System.out.println("Pessoa � abstrato? " + pessoaEhAbstrato);
        
        /*O m�todo getConstructor() retorna os construtores definidos em uma classe.
          */
        
        try {
            /*Identificamos os dois construtores da classe fornecedor*/
            Constructor<?> construtorA = classeFornecedor.getConstructor();
            Constructor<?> construtorB = classeFornecedor.getConstructor(String.class, String.class);
            
            /*Instanciamos dois objetos, atraves dos dois construtores identificados*/
            Fornecedor fornecedorLoko = (Fornecedor) construtorA.newInstance();
            Fornecedor fornecedorNormal = (Fornecedor) construtorB.newInstance("Floresta", "11.111");
            
            /*Imprime o endere�o de cada umdos fornecedores instaciados*/
            System.out.println("Endere�o do loko: " + fornecedorLoko.getEndereco());
            System.out.println("Endere�o do normal: " + fornecedorNormal.getEndereco());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                
    }
}
