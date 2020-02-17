package by.it.academy.design_bureau;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        SenderService senderService = context.getBean("senderService", SenderService.class);
        senderService.sendMessage("Hello world!!!");
    }
}
