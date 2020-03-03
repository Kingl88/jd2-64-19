package by.it.academy.design_bureau.aop.no_XML;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Slf4j
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-annotation.xml");
        TaskService bean = (TaskService) context.getBean("taskService");
        bean.performJob("Spring");
        bean.performJob();
        bean.performJobAround();
        try {
            bean.performExceptionJob();
        } catch (Exception e){
            log.error(String.valueOf(e));
        }
        ((ClassPathXmlApplicationContext) context).close();
    }
}
