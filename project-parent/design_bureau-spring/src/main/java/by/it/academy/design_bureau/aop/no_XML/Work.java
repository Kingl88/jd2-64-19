package by.it.academy.design_bureau.aop.no_XML;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
@Slf4j
public class Work {
    @Pointcut("execution(* by.it.academy.design_bureau.aop.no_XML.TaskService.performJob())")
    public void performance (){}

    @Pointcut(value = "execution(* by.it.academy.design_bureau.aop.no_XML.TaskService.performJob(String) && args(name))")
    public void intercept (String name){}
    @Before("performance()")
    public void beforeWork() {
        log.info("Execute before work");
    }

    @AfterReturning("performance()")
    public void afterWork() {
        log.info("Execute after work");
    }

    @AfterThrowing("performance()")
    public void afterWorkProblem() {
        log.info("Execute after work problem");
    }

    @Around("performance()")
    public Object aroundWork(ProceedingJoinPoint point) {
        try {
            log.info("Start");
            long start = System.currentTimeMillis();
            log.info("Begin time: " + start);
            String result = (String) point.proceed();
            long finish = System.currentTimeMillis();
            log.info("Finish time: " + finish);
            log.info("Total time: " + (finish - start) + " millis");
            log.info("Status: " + result);
        } catch (Throwable throwable) {
            log.error("error", throwable);
        }
        return point;
    }

    @Before("intercept(name)")
    public void interceptWorkName(String name){
        log.info("intercepted work is: " + name);
    }

}
