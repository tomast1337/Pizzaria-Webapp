package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class ConnectionDB {
    private static ConnectionDB instancia = null;
    private Connection conn;
    private ConnectionDB() {
        String url = "jdbc:postgresql://localhost/pizzaria";
        Properties param = new Properties();
        param.setProperty("user","pizzadb");
        param.setProperty("password","SenhaPizzariaDB");
        //param.setProperty("ssl","true");
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection(url,param);
            String createDB = "CREATE DATABASE pizzaria" +
                              "    WITH" +
                              "    OWNER = postgres" +
                              "    ENCODING = 'UTF8'" +
                              "    LC_COLLATE = 'Portuguese_Brazil.1252'" +
                              "    LC_CTYPE = 'Portuguese_Brazil.1252'" +
                              "    TABLESPACE = pg_default" +
                              "    CONNECTION LIMIT = -1;" ;
            String COMMENT = "COMMENT ON DATABASE pizzaria" +
                              "    IS 'Banco de dados da pizzaria';";
            PreparedStatement ST1, ST2;
            ST1= conn.prepareStatement(createDB);
            ST2= conn.prepareStatement(COMMENT);
            ST1.execute();
            ST2.execute();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public synchronized static ConnectionDB getInstancia() {
        if (instancia == null) instancia = new ConnectionDB();
        return instancia;
    }
    public static void setInstancia(ConnectionDB instancia){
        ConnectionDB.instancia = instancia;
    }
    public Connection getConn(){
        if(conn == null) getInstancia();
        return  conn;
    }
    public void setConn(Connection Conn){
        this.conn = Conn;
    }

}
