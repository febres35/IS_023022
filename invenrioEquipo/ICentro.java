/**
 * ICentro
 */

import javax.swing.*;
import java.awt.event.*;
public class ICentro extends JFrame implements ActionListener {
    private JTextField descTextField, ctTextField,  muTextField, dataTextField, nfTextField, ciTextField;
    private JLabel titleLabel, descLabel, ctLabel, muLabel, dateLabel, nfLabel, ciLabel;
    private JButton registerButton, reportButton, exitButton;
    

    public ICentro(){
        setLayout(null);
        setTitle("Registro y Control de Equipos en Centro de Investigación");
        
        
        titleLabel = new JLabel("<html><h3>Enter equipment data</h3></html>");
        titleLabel.setBounds(30, 10, 720, 30);
        add(titleLabel);
        
        //componen desc
        descLabel = new JLabel("Description: ");
        descLabel.setBounds(60, 50, 80, 30 );
        add(descLabel);

        descTextField = new JTextField("");
        descTextField.setBounds(140,50, 520,30);
        add(descTextField);

        //componen ct
        ctLabel = new JLabel("Amount: ");
        ctLabel.setBounds(80, 110, 80, 30 );
        add(ctLabel);

        ctTextField = new JTextField("");
        ctTextField.setBounds(140,110, 50,30);
        add(ctTextField);

        //componen mu
        muLabel = new JLabel("Unit Price (Bs.): ");
        muLabel.setBounds(300, 110, 200, 30 );
        add(muLabel);

        muTextField = new JTextField("");
        muTextField.setBounds(400,110, 260,30);
        add(muTextField);
        
        //componen date
        dateLabel = new JLabel("<html>Acquisition date:<br/>dd/mm/yyyy</html>");
        dateLabel.setBounds(130, 160, 100, 50 );
        add(dateLabel);

        dataTextField = new JTextField("");
        dataTextField.setBounds(230,170, 90,30);
        add(dataTextField);

        //componen numero de factura
        nfLabel = new JLabel("<html>Invoice N°: </html>");
        nfLabel.setBounds(340, 170, 80, 30 );
        add(nfLabel);

        nfTextField = new JTextField("");
        nfTextField.setBounds(420,170, 240,30);
        add(nfTextField);

        //componen Cedula
        ciLabel = new JLabel("<html>C.I. del Responsable del Equipo: </html>");
        ciLabel.setBounds(80, 230, 180, 30 );
        add(ciLabel);

        ciTextField = new JTextField("");
        ciTextField.setBounds(270,230, 190,30);
        add(ciTextField);


        
        //Registro de data 
        registerButton = new JButton("Register data");
        registerButton.setBounds(200, 320 , 150, 30);
        add(registerButton);
        registerButton.addActionListener(this);

        reportButton = new JButton("Generate Report");
        reportButton.setBounds(360, 320 , 150, 30);
        add(reportButton);
        reportButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBounds(520, 320 , 150, 30);
        add(exitButton);
        exitButton.addActionListener(this);


    }


    public void actionPerformed(ActionEvent e){
        if (e.getSource() == registerButton){
            String desc = descTextField.getText();
            String ci  = ciTextField.getText();
            String nf = nfTextField.getText();
            //String dt = dataTextField.getText();
            try{
                int ct = Integer.parseInt(ctTextField.getText());
                float mu = Float.parseFloat(muTextField.getText());
            
                Equipment.setEquipmentFile(desc, ct, mu, nf, ci);
            }catch (Exception error){
                error.printStackTrace();                
            }           
        }else{
            if (e.getSource() == exitButton){
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        ICentro startInterface = new ICentro();
        startInterface.setBounds(0, 0, 700, 400);
        startInterface.setVisible(true);
        startInterface.setResizable(false);
        startInterface.setLocationRelativeTo(null);
    }


    
}