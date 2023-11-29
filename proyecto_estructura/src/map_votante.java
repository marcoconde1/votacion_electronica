import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.io.*;

public class map_votante implements Serializable{
    Map<Integer,votante> votante;

    public map_votante(Map<Integer, votante> votante) {
        this.votante = votante;
    }

    public Map<Integer, votante> getVotante() {
        return votante;
    }

    public void setVotante(Map<Integer, votante> votante) {
        this.votante = votante;
    }

    @Override
    public String toString() {
        return "map_votante{" +
                "votante=" + votante +
                '}';
    }

    public void put(Integer i,votante c){
        try {
            String a = votante.get(i).nombre;
            JOptionPane.showMessageDialog((Component) null,"Voto ya registrado");
        }catch(Exception e){
            votante.put(i,c);
        }
    }

}
