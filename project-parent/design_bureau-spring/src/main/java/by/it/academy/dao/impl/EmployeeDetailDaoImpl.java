package by.it.academy.dao.impl;

import by.it.academy.dao.BaseDao;
import by.it.academy.dao.EmployeeDetailDao;
import by.it.academy.entity.EmployeeDetail;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDetailDaoImpl extends BaseDao<EmployeeDetail> implements EmployeeDetailDao {
    protected EmployeeDetailDaoImpl() {
        super(EmployeeDetail.class);
    }
}
