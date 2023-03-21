import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Natacion extends JFrame implements ActionListener {
    
    private JLabel nombreLabel, edadLabel, nivelLabel, horarioLabel, saludLabel;
    private JTextField nombreField, edadField;
    private JComboBox<String> nivelComboBox, horarioComboBox, saludComboBox;
    private JButton agregarButton, limpiarButton;
    private JTable tabla;
    private DefaultTableModel modelo;
    
    public Natacion() {
        super("Natacion Bellaka");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        
        nombreLabel = new JLabel("Nombre:");
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nombreLabel.setBackground(Color.white);
        nombreLabel.setOpaque(true);
        nombreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        constraints.gridy++;
        panelFormulario.add(nombreLabel, constraints);
        
        nombreField = new JTextField(20);
        constraints.gridx = 1;
        panelFormulario.add(nombreField, constraints);
        
        edadLabel = new JLabel("Edad:");
        edadLabel.setFont(new Font("Arial", Font.BOLD, 16));
        edadLabel.setBackground(Color.white);
        edadLabel.setOpaque(true);
        edadLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        constraints.gridx = 0;
        constraints.gridy++;
        panelFormulario.add(edadLabel, constraints);
        
        edadField = new JTextField(5);
        constraints.gridx = 1;
        panelFormulario.add(edadField, constraints);
        
        nivelLabel = new JLabel("Nivel:");
        nivelLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nivelLabel.setBackground(Color.white);
        nivelLabel.setOpaque(true);
        nivelLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        constraints.gridx = 0;
        constraints.gridy++;
        panelFormulario.add(nivelLabel, constraints);
        

        nivelComboBox = new JComboBox<String>(new String[] {"Basico", "Intermedio", "Avanzado"});
        nivelComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        nivelComboBox.setOpaque(true);
        constraints.gridx = 1;
        panelFormulario.add(nivelComboBox, constraints);

        saludLabel = new JLabel("Enfermedad:");
        saludLabel.setFont(new Font("Arial", Font.BOLD, 16));
        saludLabel.setBackground(Color.white);
        saludLabel.setOpaque(true);
        saludLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        constraints.gridx = 0;
        constraints.gridy++;
        panelFormulario.add(saludLabel, constraints);

        saludComboBox = new JComboBox<String>(new String[]{"No", "Si"});
        saludComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        saludComboBox.setOpaque(true);
        constraints.gridx = 1;
        panelFormulario.add(saludComboBox, constraints);

        horarioLabel=new JLabel("Horario:");
        horarioLabel.setFont(new Font("Arial", Font.BOLD, 16));
        horarioLabel.setBackground(Color.white);
        horarioLabel.setOpaque(true);
        horarioLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        constraints.gridx=0;
        constraints.gridy++;
        panelFormulario.add(horarioLabel, constraints);

        horarioComboBox = new JComboBox<String>(new String[] {"7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "13:00-15:00"});
        horarioComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        horarioComboBox.setOpaque(true);
        constraints.gridx = 1;
        panelFormulario.add(horarioComboBox, constraints);
        
        agregarButton = new JButton("Agregar");
        agregarButton.setFont(new Font("Arial", Font.BOLD, 16));
        agregarButton.setBackground(new Color(0, 122, 255));
        agregarButton.setForeground(Color.white);
        agregarButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy++;
        panelFormulario.add(agregarButton, constraints);
        
        limpiarButton = new JButton("Limpiar");
        limpiarButton.setFont(new Font("Arial", Font.BOLD, 16));
        limpiarButton.setBackground(new Color(0, 122, 255));
        limpiarButton.setForeground(Color.white);
        limpiarButton.addActionListener(this);
        constraints.gridx = 1;
        panelFormulario.add(limpiarButton, constraints);
        
        this.add(panelFormulario, BorderLayout.NORTH);
        
        
        JPanel panelTabla = new JPanel(new BorderLayout());
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Nivel");
        modelo.addColumn("Enfermedad");
        modelo.addColumn("Horario");
        tabla = new JTable(modelo);
        panelTabla.add(new JScrollPane(tabla), BorderLayout.CENTER);
        this.add(panelTabla, BorderLayout.CENTER);
        
        this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarButton) {
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            String nivel = nivelComboBox.getSelectedItem().toString();
            String salud = saludComboBox.getSelectedItem().toString();
            String horario = horarioComboBox.getSelectedItem().toString();
            modelo.addRow(new Object[] {nombre, edad, nivel, salud, horario});

            tabla.setFont(new Font("Arial", Font.BOLD, 14));
            tabla.setBackground(Color.white);
            tabla.setForeground(Color.black);
            tabla.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            //metodo para mostrar rutina
            mostrarDatos(salud, nivel);
            

        } else if (e.getSource() == limpiarButton) {
            nombreField.setText("");
            edadField.setText("");
            nivelComboBox.setSelectedIndex(0);
            saludComboBox.setSelectedIndex(0);
            horarioComboBox.setSelectedIndex(0);
        }
    }
    
    public static void main(String[] args) {
        Natacion formulario = new Natacion();
    }
    
    public void mostrarDatos(String salud, String nivel){
        if(salud.equals("No")){
            if(nivel.equals("Basico")){
                JOptionPane.showMessageDialog(null, "Calentamiento:\n" + 
                "2 min Nado Continuo.\n" + 
                "Alternar nado fuerte y suave.\n" +
                "Nado Principal:\n" +
                "Fartlek 15 min con 1 min de descanso.\n" + 
                "5 min de nado suave enfocado en la tecnica.");
            }else if(nivel.equals("Intermedio")){
                JOptionPane.showMessageDialog(null, "Calentamiento: \n" + 
                "3 min Nado Continuo.\n" + 
                "Nado Principal:\n" + 
                "100 metros suave crol. \n" + 
                "50 metros de afloje.\n" + 
                "75 metros de espalda con 30 seg de descanso.\n" + 
                "100 metros nado muy suave para descansar.");
            }else{
                JOptionPane.showMessageDialog(null, "Calentamiento:\n" +
                "150 metros de nado suave.\n"+
                "Nado Principal:\n"+
                "900 metros de nado intercalado.\n"+
                "400 metros nado de crol. \n"+
                "Intercalar ritmo, primero suave luego fuerte.\n"+
                "100 metros libre para descansar.");
            }
        }else{
            JOptionPane.showInputDialog(null, "INDIQUE SU ENFERMEDAD: ");
        }
    }
}
