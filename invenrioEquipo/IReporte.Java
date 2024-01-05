import javax.swing.*;
import java.awt.event.*;

public class IReporte{

    private JFrame iReport;
    private JLabel  typeReportLabel, ciLabel, totalLabel, AmountsLabel, totalPriceLabel;
    Private JButton totalizarBotton, cotinuarBotton;
    Private JRadioButton individaulButton, generalButton;
    Private JTextField ciTextField;
    
    public IReporte(){
        iReport = new JFrame();

        iReport.setLayout(null);
        iReport.setTitle("Reporte del Invetario del centro de Investigación");

        //tipo de Reporte

        typeReportLabel = new JLabel("Tipo Reporte");
        typeReportLabel.setBounds(10, 10, 60, 30);
        iReport.add(typeReportLabel);
    }


    public static void main(String[] args) {
        IReporte startInterface = new IReporte();
        startInterface.setBounds(0, 0, 700, 400);
        startInterface.setVisible(true);
        startInterface.setResizable(false);
        startInterface.setLocationRelativeTo(null);
    }

}