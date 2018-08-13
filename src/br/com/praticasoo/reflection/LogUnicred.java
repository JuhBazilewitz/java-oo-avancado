package br.com.praticasoo.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LogUnicred {
    String nivelLog() default "ERROR";
    boolean imprimeData() default true;
    
}
