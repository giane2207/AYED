package Practica1.Ejercicio5;

public class Resultado {
    private double min, max, promedio;

    public Resultado() {
    }

    @Override
    public String toString() {
        return "Resultado" +
                " min=" + min +
                ", max=" + max +
                ", promedio=" + promedio;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
}
