import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class agregar_candidato_gui extends JFrame{
    Map<Integer, candidato> m_c = new HashMap<>();
    map_candidato mcgui = new map_candidato(m_c);
    private JButton btnAgregar_candidato;
    private JTextField txtCi;
    private JTextField txtNombre;
    private JTextField txtApellido_p;
    private JTextField txtApellido_m;
    private JTextField txtOrganizacion;
    private JPanel panel;
    public agregar_candidato_gui(map_candidato mc) {
        super("Agregar candidato");
        mcgui=mc;
        setContentPane(panel);
        btnAgregar_candidato();
    }

    private void btnAgregar_candidato() {
        btnAgregar_candidato.addActionListener(actionListener);
    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String ci = txtCi.getText();
            String nombre = txtNombre.getText();
            String apellido_p = txtApellido_p.getText();
            String apellido_m = txtApellido_m.getText();
            String organizacion = txtOrganizacion.getText();

            mcgui.put(Integer.parseInt(ci),new candidato(nombre,apellido_p,apellido_m,organizacion));
            try {
                persistencia.guardarMapCandidatos(mcgui,"candidatos.dat");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(mcgui.toString());

            txtCi.setText("");
            txtNombre.setText("");
            txtApellido_p.setText("");
            txtApellido_m.setText("");
            txtOrganizacion.setText("");
        }
    };

}
