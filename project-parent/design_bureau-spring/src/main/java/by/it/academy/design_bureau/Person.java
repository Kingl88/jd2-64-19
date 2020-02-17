package by.it.academy.design_bureau;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String surname;
    private PersonInfo personInfo;
    private Department department;
    private List<Meeting> meetings;
}
