package dao;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	/**
	 *
	 * @author ELuna
	 */
	public class InterfaceConexao {
	    
	    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	    private final static String URL = "jdbc:mysql://localhost:3306/petshop?useTimezone=true&serverTimezone=UTC";
	    private final static String USUARIO = "root";
	    private final static String SENHA = "victor123"; //<-- lembrar de trocar 
	    
	    
	    protected static Connection obterConexao() throws ClassNotFoundException, SQLException{
	        
	        Class.forName(DRIVER);
	        
	        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
	        
	        return conn;
	    }
	    
	    
	}

