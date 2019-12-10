package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model_bureau.Drawing;
import by.it.academy.design_bureau.model_bureau.Employee;

import java.util.ArrayList;
import java.util.List;

public class ServiceDrawing implements Service <Drawing> {

    private static final Service<Drawing> INSTANCE = new ServiceDrawing();

    private final List<Drawing> drawings;

    public ServiceDrawing() {
        drawings = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>(ServiceEmployeeImp.getService().getAll());
        drawings.add(new Drawing(1L,"Редуктор", "АБВГ.00.00.000СБ",
                employees.get(1), employees.get(2), employees.get(0), true));
        drawings.add(new Drawing(2L,"Корпус", "АБВГ.00.00.001", employees.get(1), employees.get(2),
                employees.get(0), false));
        drawings.add(new Drawing(3L,"Вал", "АБВГ.00.00.002", employees.get(1), employees.get(2),
                employees.get(0), false));
    }

    public static Service getService() {
        return INSTANCE;
    }

    @Override
    public List<Drawing> getAll() {
        return drawings;
    }

    @Override
    public void addNew(Drawing drawing) {
        drawing.setId((long) drawings.size()+1);
        drawings.add(drawing);
    }

    @Override
    public void delete(Long id) {
        drawings.remove(Math.toIntExact(id));
    }

    @Override
    public void update(Long id, Drawing drawing) {
        drawings.set(Math.toIntExact(id), drawing);
    }
}
