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
public @interface Desenvolvedor {
    //String value() default "Z�";
    String nome() default "Z�";
    String perfil() default "Pleno";
}
