package br.com.annotation.exercicio;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author juliane.bazilewitz
 *
 * @param <T>
 */
public class DBPersistence<T> {

    private T item;
    
    public DBPersistence(T item) {
        this.item = item;
    }
    
    
    public String getChave() {
        Class<?> classe = item.getClass();
        for(Method metodo : classe.getMethods()) {
            if(metodo.isAnnotationPresent(Chave.class)) {
                String nomeColuna = metodo.getDeclaredAnnotation(Coluna.class).nome();
                return nomeColuna;
            }
        }
        return null;
    }
    
    public int getValorChave() {
        Class<?> classe = item.getClass();
        int codigo = 0;
        try {
            String nomeMetodo = "getCodigo";
            Method metodo = classe.getMethod(nomeMetodo);
            
            if(metodo.isAnnotationPresent(Chave.class)) {
                
                classe.getMethod(nomeMetodo);
                
                codigo = (int) metodo.invoke(item);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return codigo;
    }
    
    public List<String> getColunas() {
        List<String> colunas = new ArrayList<>();
        Class<?> classe = item.getClass();
        for(Method metodo : classe.getMethods()) {
            if(metodo.isAnnotationPresent(Coluna.class)) {
                String nomeColuna = metodo.getDeclaredAnnotation(Coluna.class).nome();
                colunas.add(nomeColuna);
            }
        }
        
        return colunas;
    }
    
    public String getTabela() {
        Class<?> classe = item.getClass();
        String tabela = "";
        if(classe.isAnnotationPresent(Tabela.class)) {
            tabela = classe.getDeclaredAnnotation(Tabela.class).nome();
        }
        return tabela;
    }
    
    public String getAllQuery() {
        String sql = "select ";
        
        for(String str : getColunas()) {
            sql += str + ",";
        }
        
        sql = sql.substring(0, sql.length() -1);
        sql += " from " + getTabela();
        
        return sql;
    }
    
    public String getById(Object id) {
        String sql = getAllQuery() + " where " + getChave() + " = " + id;
        return sql;
    }
    
    public String insert(Object... objects) {
        String sql = "insert into " + getTabela() + " (";
        for(String str : getColunas()) {
            sql += str + ",";
        }
        sql = sql.substring(0, sql.length() -1);
        sql += ") values (";
        for(Object str : objects) {
            sql += str.toString() + ",";
        }
        sql = sql.substring(0, sql.length() -1);
        sql += ")";
        
        return sql;
    }
}
