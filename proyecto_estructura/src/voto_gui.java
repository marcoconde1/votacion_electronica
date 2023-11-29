import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class voto_gui extends JFrame {
    Map<Integer, votante> m_v = new HashMap<>();
    map_votante mvgui = new map_votante(m_v);
    Map<Integer, candidato> m_c = new HashMap<>();
    map_candidato mcgui = new map_candidato(m_c);
    private JList lstVotos;
    private JList lstCandidatos;
    private JPanel panel;
    private JButton btnRefrescar;

    public voto_gui(map_candidato mc,map_votante mv){
        super("Votos");
        mvgui=mv;
        mcgui=mc;
        llenarListas(mc, mv);
        setContentPane(panel);
        btnRefrescar();
    }

    private void llenarListas(map_candidato mc, map_votante mv) {
        ArrayList<Integer> votos =voto.votos(mc, mv);
        ArrayList<String> candidatos = voto.candidatos(mc);
        llenarLst(candidatos,votos);
    }

    private void btnRefrescar() {
        btnRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarLst(voto.candidatos(mcgui), voto.votos(mcgui, mvgui));
            }
        });
    }

    public void llenarLst(ArrayList<String> c, ArrayList<Integer> v){
        DefaultListModel model_c = new DefaultListModel<>();
        DefaultListModel model_v = new DefaultListModel<>();
        for (String i : c){
            model_c.addElement(i);
        }
        for(int i : v){
            model_v.addElement(i);
        }
        lstVotos.setModel(model_v);
        lstCandidatos.setModel(model_c);
    }
}
