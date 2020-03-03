package by.it.academy.design_bureau.aop.withXML;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("work")
public class Work {
    public void beforeWork() {
        log.info("Execute before work");
    }
    public void afterWork() {
        log.info("Execution after work");
    }
    public void afterWorkProblems() {
        log.info("Execution problems");
    }
}
