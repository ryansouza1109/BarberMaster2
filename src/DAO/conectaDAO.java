
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class conectaDAO {
    
    
    public Connection getConexao() {
                try {
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost/barberMaster ", 
                            "root", 
                            "1109"
                    );
                    return conn;
            
                }catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e.getMessage());
                        return null;
                }
            
        
        
    }
    
}
