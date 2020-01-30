package by.it.academy.design_bureau.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID", unique = true)
    private Long departmentId;
    @Column(name = "NAME")
    private String departmentName;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();
    public Department(String name) {this.departmentName = name;}
}