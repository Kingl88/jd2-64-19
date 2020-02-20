package by.it.academy.design_bureau;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "by.it.academy.design_bureau")
public class NoXmlConfiguration {

    @Bean(name = "person", initMethod = "init", destroyMethod = "destroy")
    public Person getPerson() {
        Person person = new Person();
        person.setId(1L);
        person.setName("NAME FORM CONFIG");
        return person;
    }
}
