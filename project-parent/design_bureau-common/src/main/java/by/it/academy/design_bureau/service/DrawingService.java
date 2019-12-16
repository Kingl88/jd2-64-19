package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model.Drawing;
import by.it.academy.design_bureau.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DrawingService implements Service <Drawing> {

    private static final Service<Drawing> INSTANCE = new DrawingService();

    private final List<Drawing> drawings;

    public DrawingService() {
        drawings = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>(EmployeeServiceImp.getService().getAll());
        drawings.add(new Drawing(1L,"Редуктор", "АБВГ.00.00.000СБ",
                employees.get(1), employees.get(2), employees.get(0), true));
        drawings.add(new Drawing(2L,"Корпус", "АБВГ.00.00.001", employees.get(1), employees.get(2),
                employees.get(0), false));
        drawings.add(new Drawing(3L,"Вал", "АБВГ.00.00.002", employees.get(1), employees.get(2),
                employees.get(0), false));
    }

    public static Service<Drawing> getService() {
        return INSTANCE;
    }

    @Override
    public List<Drawing> getAll() {
        return drawings;
    }

    @Override
    public void addNew(Drawing drawing) {
        AtomicLong idSeq = new AtomicLong(10);
        drawing.setId(idSeq.incrementAndGet());
        drawings.add(drawing);
    }

    @Override
    public void delete(Long id) {
        for (Drawing drawing: drawings) {
            if(drawing.getId().equals(id)) {
                drawings.remove(drawing);
                return;
            }
        }
    }

    @Override
    public void update(Long id, Drawing drawing) {
        drawings.set(Math.toIntExact(id), drawing);
    }
}
