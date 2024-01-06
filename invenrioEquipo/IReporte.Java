import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.*;

import java.util.ArrayList;

public class IReporte extends JFrame implements ActionListener{

    public JFrame iReport;
    private JLabel  typeReportLabel, ciLabel, totalLabel, AmountsLabel, totalPriceLabel;
    private JButton totalizarBotton, cotinuarBotton;
    private JRadioButton individaulButton, generalButton;
    private JTextField ciTextField;
    private JTable generalTable;
    private JScrollPane scroll;
    private ButtonGroup groupButton;
    
    public IReporte() {
        iReport = new JFrame();

        iReport.setLayout(null);
        iReport.setTitle("Reporte del Invetario del centro de Investigación");

        //tipo de Reporte

        typeReportLabel = new JLabel("Tipo Reporte: ");
        typeReportLabel.setBounds(10, 10, 80, 30);
        iReport.add(typeReportLabel);

        individaulButton = new JRadioButton(" Individual ");
        individaulButton.setBounds(150, 10, 85, 30);
        iReport.add(individaulButton);
        
        generalButton = new JRadioButton(" General ");
        generalButton.setBounds(290, 10, 80, 30);
        iReport.add(generalButton);
        
        groupButton = new ButtonGroup();
        groupButton.add(individaulButton);
        groupButton.add(generalButton);





        // Reporte individual
        ciLabel = new JLabel("C.I. del Responsable de Equipos");
        ciLabel.setBounds(10, 50, 180, 30 );
        iReport.add(ciLabel);

        ciTextField = new JTextField();
        ciTextField.setBounds(200, 50, 110, 30);
        iReport.add(ciTextField);


        totalizarBotton = new JButton(" Totalizar ");
        totalizarBotton.setBounds(320, 50, 110, 30);
        iReport.add(totalizarBotton);
        
        //Resultados
        totalLabel = new JLabel("<html><h4> Totalizacion: </h4></html>");
        totalLabel.setBounds(50, 150, 110, 20);
        iReport.add(totalLabel);

        AmountsLabel = new JLabel(" _____ Equipos " );
        AmountsLabel.setBounds(50, 170, 110, 20);
        iReport.add(AmountsLabel);

        totalPriceLabel = new JLabel(" _________ Bs. " );
        totalPriceLabel.setBounds(50, 190, 110, 20);
        iReport.add(totalPriceLabel);

        cotinuarBotton = new JButton(" Continuar ");
        cotinuarBotton.setBounds(320, 250, 110,30);
        iReport.add(cotinuarBotton);
        cotinuarBotton.addActionListener(this);
        totalizarBotton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cotinuarBotton){
            System.out.println("Continuar");
            if (generalButton.isSelected() == true){
                String[] encabezadoColumnas = {" C.I. Responsable", "Cantidad Equipo", "Monto total (Bs.)"};
                Equipment inv = new Equipment();
                ArrayList<Equipment> lista = new ArrayList<>();
                lista = inv.getListOfEquipment();
                final int FILA = lista.size();
                Object[][] datos = new Object[FILA][3];
                int totalAmount = 0;
                float totalPrice = 0.0F;
                for (int i = 0; i < FILA; i++){
                    inv = lista.get(i);
                    datos[i][0] = inv.getCi();
                    datos[i][1] = inv.getTotalAmount();
                    datos[i][2] = inv.getTotalUnitPrice();
                    totalAmount += inv.getTotalAmount();
                    totalPrice += inv.getTotalUnitPrice();

                }
                DefaultTableModel modelo = new DefaultTableModel(datos, encabezadoColumnas);
                generalTable = new JTable(modelo);
                //generalTable.setBounds(10, 100, 440, 280);
                scroll = new JScrollPane(generalTable);
                
                ciTextField.setVisible(false);
                totalizarBotton.setVisible(false);
                ciLabel.setVisible(false);
                totalLabel.setBounds(20, 230, 110, 20);
                AmountsLabel.setBounds(20, 250, 110, 20);            
                totalPriceLabel.setBounds(20, 270, 110, 20);
                
                scroll.setBounds(10, 70, 440, 130);
                AmountsLabel.setText("_ " + totalAmount + " _ Equipos" );
                totalPriceLabel.setText("__ " + totalPrice +" __ Bs.");
                iReport.add(scroll);



            }else{
                if(individaulButton.isSelected() == true){
                    System.out.println("individaulButton");
                    //generalTable.setVisible(false);
                    scroll.setVisible(false);
                    setTitle("Presiono TotalizarButton");
                    ciTextField.setVisible(true);
                    ciTextField.setText("");
                    totalizarBotton.setVisible(true);
                    ciLabel.setVisible(true);

                    totalLabel.setBounds(50, 150, 110, 20);
                    AmountsLabel.setBounds(50, 170, 110, 20);            
                    totalPriceLabel.setBounds(50, 190, 110, 20);
                    AmountsLabel.setText(" _____ Equipos " );
                    totalPriceLabel.setText(" _________ Bs. " );
                }
                
            }
            
        } else{
            if ( e.getSource() == totalizarBotton){
                Equipment inv = new Equipment();
                ArrayList<Equipment> lista = new ArrayList<>();
                lista = inv.getListOfEquipment();
                String ci = "";
                for(Equipment l:lista){
                    ci = l.getCi();
                    if (ci.equals(ciTextField.getText())){
                        inv = l;
                        break;
                    }
                }
                AmountsLabel.setText("_ " + inv.getTotalAmount() + " _ Equipos" );
                totalPriceLabel.setText("__ " + inv.getTotalUnitPrice()+" __ Bs.");



            }
        }
    }

    public static void main(String[] args) {
        IReporte startInterface = new IReporte();
        startInterface.iReport.setBounds(0, 0, 470, 350);
        startInterface.iReport.setVisible(true);
        startInterface.iReport.setResizable(false);
        startInterface.iReport.setLocationRelativeTo(null);
    }

}