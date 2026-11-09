import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Ventana;
    private JTabbedPane tabbedPane1;
    private JTextField txtIsbn;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JComboBox cboCategoria;
    private JSpinner spiAnio;
    private JButton btnRegistrar;
    private JComboBox cboBuscar;
    private JButton btnBuscar;
    private JList lstListar;
    private JTextField txtBuscar;
    Lista biblioteca=new Lista();
    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int isbn=Integer.parseInt(txtIsbn.getText());
                String titulo=txtTitulo.getText();
                String autor=txtAutor.getText();
                String cat=cboCategoria.getSelectedItem().toString();
                int anio=Integer.parseInt(spiAnio.getValue().toString());

                try {
                    biblioteca.agregar(new Libro(isbn,titulo,autor,cat,anio));
                    JOptionPane.showMessageDialog(null,"Agregado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm=new DefaultListModel<>();
                int indice=cboBuscar.getSelectedIndex();
                switch (indice){
                    case 0:dlm=new DefaultListModel<>();
                        dlm.addAll(biblioteca.obtener());
                        break;
                    case 1:dlm=new DefaultListModel<>();
                        int isbn=Integer.parseInt(txtBuscar.getText());
                        biblioteca.binario(isbn);
                        int indice1=biblioteca.binario(isbn);
                        if(indice1!=-1){
                            dlm.addElement(biblioteca.obtener().get(indice1));
                        }
                        break;
                    case 2: dlm=new DefaultListModel<>();
                        String t2=txtBuscar.getText();
                        dlm.addAll(biblioteca.buscar(t2));
                        break;
                }
                lstListar.setModel(dlm);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

