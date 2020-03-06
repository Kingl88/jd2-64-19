package by.it.academy.service.Impl;

import by.it.academy.entity.EmployeeDetail;
import by.it.academy.service.BaseService;
import by.it.academy.service.EmployeeDetailService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailServiceImpl extends BaseService<EmployeeDetail> implements EmployeeDetailService {
    protected EmployeeDetailServiceImpl() {
        super(EmployeeDetail.class);
    }
}
