package by.it.academy.design_bureau.model;

import java.util.Objects;

public class Drawing {
    private Long id;
    private String name; //название чертежа.
    private String designation; //обозначение чертежа.
    private Employee developed; //разработал.
    private Employee checked; //проверил.
    private Employee approved; //утвердил.
    private boolean isAssembly; //является сборкой или частью.

    public Drawing(Long id, String name, String designation, Employee developed, Employee checked, Employee approved, boolean isAssembly) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.developed = developed;
        this.checked = checked;
        this.approved = approved;
        this.isAssembly = isAssembly;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Employee getDeveloped() {
        return developed;
    }

    public void setDeveloped(Employee developed) {
        this.developed = developed;
    }

    public Employee getChecked() {
        return checked;
    }

    public void setChecked(Employee checked) {
        this.checked = checked;
    }

    public Employee getApproved() {
        return approved;
    }

    public void setApproved(Employee approved) {
        this.approved = approved;
    }

    public boolean isAssembly() {
        return isAssembly;
    }

    public void setAssembly(boolean assembly) {
        isAssembly = assembly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drawing drawing = (Drawing) o;
        return isAssembly == drawing.isAssembly &&
                Objects.equals(id, drawing.id) &&
                Objects.equals(name, drawing.name) &&
                Objects.equals(designation, drawing.designation) &&
                Objects.equals(developed, drawing.developed) &&
                Objects.equals(checked, drawing.checked) &&
                Objects.equals(approved, drawing.approved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, designation, developed, checked, approved, isAssembly);
    }

    @Override
    public String toString() {
        return "Drawing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", developed=" + developed +
                ", checked=" + checked +
                ", approved=" + approved +
                ", isAssembly=" + isAssembly +
                '}';
    }
}
