package by.it.academy.service.Impl;

import by.it.academy.entity.Department;
import by.it.academy.repository.DepartmentRepository;
import by.it.academy.service.BaseService;
import by.it.academy.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department) {
        if (department.getDepartmentId() != null && departmentRepository.existsById(department.getDepartmentId())) {
            return departmentRepository.saveAndFlush(department);
        }
        return null;
    }

    @Override
    public Department read(Serializable id) {

        return departmentRepository.findById((Long) id).orElse(null);
    }

    @Override
    public void delete(Serializable id) {
        if (departmentRepository.existsById((Long) id))
            departmentRepository.deleteById((Long) id);
    }
}