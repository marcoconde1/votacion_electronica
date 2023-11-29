import java.io.Serializable;
import java.util.ArrayList;

public class votante implements Serializable {
    String nombre;
    String apellido_p;
    String apellido_m;
    int ci_candidato;

    public votante(String nombre, String apellido_p, String apellido_m, int ci_candidato) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.ci_candidato = ci_candidato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public int getCi_candidato() {
        return ci_candidato;
    }

    public void setCi_candidato(int ci_candidato) {
        this.ci_candidato = ci_candidato;
    }

    @Override
    public String toString() {
        return "votante{" +
                "nombre='" + nombre + '\'' +
                ", apellido_p='" + apellido_p + '\'' +
                ", apellido_m='" + apellido_m + '\'' +
                ", ci_candidato=" + ci_candidato +
                '}';
    }
}
