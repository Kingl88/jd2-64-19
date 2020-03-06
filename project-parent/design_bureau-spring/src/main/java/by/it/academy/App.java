package by.it.academy;

import by.it.academy.entity.Department;
import by.it.academy.entity.Employee;
import by.it.academy.entity.EmployeeDetail;
import by.it.academy.entity.Meeting;
import by.it.academy.repository.MeetingRepository;
import by.it.academy.service.DepartmentService;
import by.it.academy.service.EmployeeDetailService;
import by.it.academy.service.EmployeeService;
import by.it.academy.service.MeetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

@Slf4j
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        EmployeeService bean = context.getBean(EmployeeService.class);
        Employee employee = new Employee(null, "name", "surname", null, null, null, null);
        bean.create(employee);
        log.info(String.valueOf(bean.read(1L)));
        EmployeeDetail employeeDetail = new EmployeeDetail(null, "street", "city","state", "country", employee);
        EmployeeDetailService bean1 = context.getBean(EmployeeDetailService.class);
        bean1.create(employeeDetail);
        DepartmentService bean2 = context.getBean(DepartmentService.class);
        Department department = new Department(null, "dev", null);
        bean2.create(department);
        bean2.update(new Department(null, "dhg", null));
        MeetingRepository bean3 = context.getBean(MeetingRepository.class);
        Meeting meeting = new Meeting(null, "qwerty", null, null);
        bean3.save(meeting);
        log.info(String.valueOf(bean3.getAllByStartDateAfter(LocalDateTime.now().minusHours(1L))));
    }
}
