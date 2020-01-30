package by.it.academy.design_bureau.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MEETING")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID")
    private Long meetingId;
    private String subject;
    private LocalDateTime startDate;
    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees = new HashSet<>();
    public Meeting(String subject) {
        this.subject = subject;
        this.startDate = LocalDateTime.now();
    }
}
