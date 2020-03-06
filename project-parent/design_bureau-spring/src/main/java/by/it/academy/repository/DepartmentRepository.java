package by.it.academy.repository;

import by.it.academy.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentNameIsStartingWith(String starting);
    Long countAllBy();
}
