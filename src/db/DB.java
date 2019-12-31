package db;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    
    private static Connection conn = null;
    //Método responsável pela conexão com o banco de dados
    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = (Connection) DriverManager.getConnection(url, props);
            }catch(SQLException e){
                throw new DbExcepetion(e.getMessage());
            }
        }
        return conn;
    }
    // Método responsável por encerrar a conexão com o banco de dados.
    public static void closeConnection(){
        if (conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                throw new DbExcepetion(e.getMessage());
            }
        }
    }
    // Método para carregar as informações do arquivo db.properties
    // Esse método vai ser reponsável por carregar / executar (LOAD) as informações do arquivo no MySQL
    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch(IOException e){
            throw new DbExcepetion(e.getMessage());
        }
    }
//Método auxiliar para fechar o objeto statement
    public static void closeStatement(Statement st){
        if (st != null){
            try {
                st.close();
            } catch (SQLException ex) {
                throw new DbExcepetion(ex.getMessage());
            }
        }
    }
//Método auxiliar para fechar o objeto result    
    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new DbExcepetion(ex.getMessage());
            }
        }
    }
}
