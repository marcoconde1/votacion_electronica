import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FlatIntelliJLaf.setup();

        Map<Integer, candidato> m_c = new HashMap<>();
        map_candidato mc = new map_candidato(m_c);

        Map<Integer, votante> m_v = new HashMap<>();
        map_votante mv = new map_votante(m_v);

        persistencia.crearArchivos();

        Boolean sc = persistencia.verificar_candidatos();
        System.out.println(sc);
        Boolean sv = persistencia.verificar_votantes();
        System.out.println(sv);

        if(sc==true){
            mc = persistencia.leerMapCandidatos("candidatos.dat");
        }

        if(sv==true){
            mv = persistencia.leerMapVotantes("votantes.dat");
        }

        votacion_gui(mc, mv);
        agregar_candidato_gui(mc);
        votos_gui(mc, mv);
        votantes_gui(mv);
    }

    private static void votantes_gui(map_votante mv) {
        JFrame votantes = new votantes_gui(mv);
        votantes.setSize(400,400);
        votantes.setVisible(true);
        votantes.setLocationRelativeTo((Component) null);
    }

    private static void votos_gui(map_candidato mc, map_votante mv) {
        JFrame votos = new voto_gui(mc, mv);
        votos.setSize(400,400);
        votos.setVisible(true);
        votos.setLocationRelativeTo((Component)null);
    }

    private static void agregar_candidato_gui(map_candidato mc) {
        JFrame agregar_candidato= new agregar_candidato_gui(mc);
        agregar_candidato.setSize(400,400);
        agregar_candidato.setVisible(true);
        agregar_candidato.setLocationRelativeTo((Component)null);
    }

    private static void votacion_gui(map_candidato mc, map_votante mv) {
        JFrame votacion = new votacion_gui(mc, mv);
        votacion.setSize(400,400);
        votacion.setVisible(true);
        votacion.setLocationRelativeTo((Component)null);
    }
}