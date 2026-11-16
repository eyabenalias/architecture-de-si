package tn.esprit.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExceptionHandlingAspect {

    // TP 03 : Gestion centralisée des exceptions
    @AfterThrowing(pointcut = "execution(* tn.esprit.spring.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        log.error("Erreur dans la méthode [{}] - Exception : {}", methodName, ex.getMessage());
    }
}
