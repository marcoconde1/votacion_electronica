import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.io.*;

public class map_candidato implements Serializable{
    Map<Integer,candidato> candidato;

    public map_candidato(Map<Integer, candidato> candidato) {
        this.candidato = candidato;
    }

    public Map<Integer, candidato> getCandidato() {
        return candidato;
    }

    public void setCandidato(Map<Integer, candidato> candidato) {
        this.candidato = candidato;
    }

    @Override
    public String toString() {
        return "map_candidato{" +
                "candidato=" + candidato +
                '}';
    }

    public int size(){
        int i = candidato.size();
        return i;
    }

    public void put(Integer i,candidato c){
        try {
            String a = candidato.get(i).nombre;
            JOptionPane.showMessageDialog((Component) null,"Candidato ya registrado");
        }catch(Exception e){
            candidato.put(i,c);
        }
    }

}
