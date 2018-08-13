package br.com.praticasoo.exercicio;

import java.util.List;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class Repositorio<T extends Entidade> {
    
    private List<T> itens;

    private Boolean existeItem(int codigo) {
        for(T item : itens) {
            if(item.getIdentificador() == codigo) {
               return true;
            }
        }
        return false;
    }
    
    public void adicionarItem(T item){
        if(existeItem(item.getIdentificador())) {
            //TODO não adiciona
        } else {
            itens.add(item);
        }
    }
    
    public void removeItem(String codigo) {
        for(T item : itens) {
            if(item.getIdentificador() == Integer.parseInt(codigo)) {
                itens.remove(item);
            }
        }
    }
    
    public List<T> getItens(){
        return this.itens;
    }
    
    public void salvarTodos() {
        for (T item : itens) {
            item.salvar();
        }
        itens.clear();
    }
}
