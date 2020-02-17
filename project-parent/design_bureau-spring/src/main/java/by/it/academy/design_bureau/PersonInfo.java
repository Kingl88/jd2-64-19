package by.it.academy.design_bureau;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo {
    private Integer age;
    private String street;
    private String city;
    private Integer houseNumber;

}
