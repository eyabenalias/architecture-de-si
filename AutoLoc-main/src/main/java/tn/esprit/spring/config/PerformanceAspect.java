package tn.esprit.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {

    // TP 02 : Mesure du temps d'exécution et alerte si > 1000 ms
    @Around("execution(* tn.esprit.spring.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object output = pjp.proceed();

        long elapsedTime = System.currentTimeMillis() - start;
        String methodName = pjp.getSignature().getName();

        log.info("Temps d'exécution de [{}] : {} ms", methodName, elapsedTime);

        if (elapsedTime > 1000) {
            log.warn("ALERTE PERFORMANCE : La méthode [{}] a dépassé 1000 ms (durée : {} ms)", methodName, elapsedTime);
        }

        return output;
    }
}
