package by.it.academy.design_bureau.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "EMPLOYEE_ID", unique = true)
    @Access(AccessType.PROPERTY)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDateTime date;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee"
            , cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    private EmployeeDetail employeeDetail;
}
