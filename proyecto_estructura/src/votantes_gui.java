import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class votantes_gui extends JFrame{
    Map<Integer, votante> m_v = new HashMap<>();
    map_votante mvgui = new map_votante(m_v);
    private JList lstVotantes;
    private JPanel panel;
    private JButton btnRefrescar;

    public votantes_gui(map_votante mv){
        super("Votantes");
        mvgui=mv;
        setContentPane(panel);
        llenarListas(mvgui);
        btnRefrescar();
    }
    private void llenarListas(map_votante mv) {
        ArrayList<String> votantes = voto.votantes(mv);
        llenarLst(votantes);
    }
    public void llenarLst( ArrayList<String> v){
        DefaultListModel model_v = new DefaultListModel<>();
        for(String i : v){
            model_v.addElement(i);
        }
        lstVotantes.setModel(model_v);
    }
    private void btnRefrescar() {
        btnRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarLst(voto.votantes(mvgui));
            }
        });
    }
}
