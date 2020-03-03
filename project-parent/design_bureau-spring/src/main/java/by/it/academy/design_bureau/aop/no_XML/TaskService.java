package by.it.academy.design_bureau.aop.no_XML;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("taskService")
public class TaskService {
    public void performJob() {
        log.info("Perform Job");
    }
    public void performExceptionJob()
            throws Exception {
        log.info("Throws exception in Job");
        throw new Exception("Exception JOB");
    }
    public String performJobAround(){
        log.info("Perform Around Job");
        return "SUCCESS";
    }
    public void performJob(String name){
        log.info("Job name: " + name);
    }
}
