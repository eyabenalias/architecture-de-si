package tn.esprit.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    // TP 01 : Exécuté avant chaque méthode de la couche service
    @Before("execution(* tn.esprit.spring.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Debut methode : " + name + " : ");

        // Afficher les valeurs de tous les paramètres passés à la méthode
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                log.info("Paramètre : " + arg);
            }
        }
    }

    // TP 01 : Exécuté après chaque méthode de la couche service
    @After("execution(* tn.esprit.spring.service.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method : " + name + " (fin de l'exécution)");
    }
}
