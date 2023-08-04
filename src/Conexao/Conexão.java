package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {public  static Connection getConnection(){
    try {
        Connection connection = DriverManager.getConnection("Nao finciona :(");
        return connection;
    }catch (SQLException e){
        e.printStackTrace();
        return null;

    }
}
}
