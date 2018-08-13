package br.com.praticasoo.reflection;

import java.lang.reflect.Method;

/**
 * 
 * @author juliane.bazilewitz
 *
 * @param <T>
 */
public class Logger<T> {

    private T t;
    
    public Logger(T item) {
        this.t = item;
    }
    
    public void logar() {
        Class<?> classeParaLog = this.t.getClass();
        
        System.out.println(classeParaLog.getSimpleName());
        System.out.println("------------------------------");
        
        if(classeParaLog.isAnnotationPresent(LogUnicred.class)) {
            
            LogUnicred logAnnotation = classeParaLog.getAnnotation(LogUnicred.class);
            String nivel = logAnnotation.nivelLog();
            boolean imprime = logAnnotation.imprimeData();
            String log = "";
            
            if(nivel.equals("ERROR")) {
                log += "++++++++++++++++++++++++++++++++ ERROR ++++++++++++++++++++++++++++++++\n";
                log += "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
                log += "Ocorreu alguma coisa critica\n";
            } else {
                log += "Foi mais suave.\n";
            }
            
            if(imprime) {
                log += "Data correte: hoje, agora.";
            }
            
            System.out.println(log);
        }
        
        if(classeParaLog.isAnnotationPresent(Desenvolvedor.class)) {
            Desenvolvedor devAnnotation = classeParaLog.getAnnotation(Desenvolvedor.class);
            System.out.println("Dev.: " + devAnnotation.nome());
            System.out.println("Liga pra ele...");
        }
        
        for(Method metodo : classeParaLog.getDeclaredMethods()) {
            if(metodo.isAnnotationPresent(Critico.class)) {
                System.out.println("O método " + metodo.getName() + " é critico.");
                System.out.println("Critico por que?");
                Critico criticoAnnotation = metodo.getAnnotation(Critico.class);
                System.out.println(criticoAnnotation.value());
            }
        }
    }
}
