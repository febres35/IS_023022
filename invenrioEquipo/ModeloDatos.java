import javax.swing.*;
import javax.swing.table.*;

// El Modelo de la Tabla es el que controla todos los datos que se colocan en ella
class ModeloDatos extends AbstractTableModel {
    Object datos[][] = {
        {"uno", "dos", "tres", "cuatro"},
        {"cinco", "seis", "siete", "ocho"},
        {"nueve", "diez", "once", "doce"},
    };

    // Devuelve el número de columnas de la tabla
    public int getColumnCount() { return datos[0].length; }

    // Devuelve el número de filas de la tabla
    public int getRowCount() { return datos.length; }

    // Devuelve el valor de una determinada casilla de la tabla identificada mediante fila y columna
    public Object getValueAt(int fila, int col) { return datos[fila][col]; }

    // Indica si la casilla identificada por fila y columna es editable
    public boolean isCellEditable(int fila, int col) { return true; }
}

class TablaContenido {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Tabla de Contenido");
        JTable tabla = new JTable(new ModeloDatos());
        JScrollPane panel = new JScrollPane(tabla);
        frame.getContentPane().add(panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
