package Practica1;

public class Profesor extends Persona {
    private String catedra, facultad;

    public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
        super(nombre, apellido, email);
        this.catedra = catedra;
        this.facultad = facultad;
    }

    @Override
    public String tusDatos() {
        String s = super.tusDatos() +
                " catedra: " + this.getCatedra() +
                " facultad: " + this.getFacultad();
        return s;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
}
