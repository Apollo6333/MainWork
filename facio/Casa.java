package facio;

public class Casa {
    private double area;
    private String rua;
    
    public Casa(double area, String rua) {
        this.area = area;
        this.rua = rua;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

}
