package by.it.academy.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"employees"})
@ToString(exclude = {"employees"})
@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;
    private String subject;
    @CreationTimestamp
    private LocalDateTime startDate;
    @ManyToMany(mappedBy = "meetings", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
    public Meeting(String subject) {
        this.subject = subject;
    }
}