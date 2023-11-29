import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class votacion_gui extends JFrame{
    Map<Integer, votante> m_v = new HashMap<>();
    map_votante mvgui = new map_votante(m_v);
    Map<Integer, candidato> m_c = new HashMap<>();
    map_candidato mcgui = new map_candidato(m_c);
    private JButton btnVotar;
    private JTextField txtCi;
    private JTextField txtNombre;
    private JTextField txtApellido_p;
    private JTextField txtApellido_m;
    private JPanel panel;
    public JComboBox cbVoto;
    private JButton btnRefrescar;

    public votacion_gui(map_candidato mc,map_votante mv){
        super("Votacion");
        mvgui=mv;
        mcgui=mc;
        llenarCb(mc);
        setContentPane(panel);
        btnVotar();
        btnRefrescar();
    }

    private void btnVotar() {
        btnVotar.addActionListener(actionListener);
    }

    private void btnRefrescar() {
        btnRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Refresh the combobox by calling llenarCb()
                llenarCb(mcgui);
            }
        });
    }

    public void llenarCb(map_candidato mc){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Integer i : mc.candidato.keySet() ){
            String candidato = mc.candidato.get(i).getNombre()+" "+mc.candidato.get(i).getApellido_p();
            model.addElement(candidato);
        }
        cbVoto.setModel(model);
    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            ArrayList<Integer> ci_candidatos = new ArrayList<>();
            ci_candidatos.addAll(mcgui.getCandidato().keySet());

            System.out.println(ci_candidatos.toString());

            String ci = txtCi.getText();
            String nombre = txtNombre.getText();
            String apellido_p = txtApellido_p.getText();
            String apellido_m = txtApellido_m.getText();

            int num_voto =cbVoto.getSelectedIndex();
            System.out.println(num_voto);
            int voto = ci_candidatos.get(num_voto);
            System.out.println(voto);

            mvgui.put(Integer.parseInt(ci),new votante(nombre,apellido_p,apellido_m,voto));
            try {
                persistencia.guardarMapVotantes(mvgui,"votantes.dat");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            txtCi.setText("");
            txtNombre.setText("");
            txtApellido_p.setText("");
            txtApellido_m.setText("");
            cbVoto.setSelectedIndex(0);

            System.out.println(mvgui.toString());
        }
    };




}
