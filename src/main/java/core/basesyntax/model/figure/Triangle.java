package core.basesyntax.model.figure;

import javax.persistence.Entity;

@Entity(name = "triangle_figure")
public class Triangle extends Figure {
    private double area;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
