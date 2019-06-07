package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cachorro;

public class CachorroDAO {
	

	/**
	 * Este método cria um novo cachorro no banco de dados, com o status 'Pendente adoção'
	 * @param cachorro - Objeto do tipo cachorro
	 * @return boolean = true se sucesso, false se falha
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean inserirCachorro(Cachorro cachorro) throws SQLException, ClassNotFoundException {
		
		boolean retorno = false;
		
		String sql = "INSERT INTO cachorro (nome, raca, peso, porte, altura, cor, status_adocao) values (?, ?, ?, ?, ?, ?, 'Disponível adoção');";

        try (Connection conn = InterfaceConexao.obterConexao();
                PreparedStatement insert = conn.prepareStatement(sql);) {
            insert.setString(1, cachorro.getNome());
            insert.setString(2, cachorro.getRaca());
            insert.setFloat(3, cachorro.getPeso());            
            insert.setString(4, cachorro.getPorte());
            insert.setFloat(5, cachorro.getAltura());
            insert.setString(6, cachorro.getCor());

            int linhasAfetadas = insert.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
            conn.close();
        }
		
		return retorno;
	}
	
	/**
	 * Este método lista todos os cachorros cadastrados no banco de dados
	 * 
	 * @return ArrayList do tipo Cachorro
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Cachorro> listarCachorros() throws SQLException, ClassNotFoundException {
		
		ArrayList<Cachorro> listaCachorros = new ArrayList<Cachorro>();
		
		String sql = "select * from cachorro";

        try (Connection conn = InterfaceConexao.obterConexao();
                PreparedStatement select = conn.prepareStatement(sql);
                ResultSet retorno = select.executeQuery()) {

        	//String nome, String raca, float peso, float altura, String cor, String porte
            while (retorno.next()) {
                Cachorro c = new Cachorro(
                        retorno.getInt("id"),
                        retorno.getString("nome"),
                        retorno.getString("raca"),
                        retorno.getFloat("peso"),
                        retorno.getFloat("altura"),
                        retorno.getString("cor"),
                        retorno.getString("porte"),
                        retorno.getString("status_adocao"));
                listaCachorros.add(c);
            }
            conn.close();
        }

        return listaCachorros;
	}
	
	
	/**
	 * Este método faz a adoção do cachorro no banco de dados, mudando o status de 'Pendente adoção' para 'Adotado'
	 * @param c = Objeto do tipo cachorro
	 * @return boolean = true se correto, false se falha
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean adotarCachorro(Cachorro c) throws SQLException, ClassNotFoundException {
		
		boolean retorno = false;
		
		String sql = "UPDATE cachorro set status_adocao = 'Adotado' where id = ?";

        try (Connection conn = InterfaceConexao.obterConexao();
                PreparedStatement update = conn.prepareStatement(sql);
        		
        		) {
        	
        	update.setInt(1, c.getId());
            
        	int linhasAfetadas = update.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
            conn.close();
        }
		
		return retorno;
		
	}
	
/**
 * Este método lista os cachorros por porte
 * 
 * @param porte = String ('Pequeno', 'Médio' ou 'Grande') conforme cadastro
 * @return ArrayList do tipo Cachorro
 * @throws SQLException
 * @throws ClassNotFoundException
 */
public static ArrayList<Cachorro> listarCachorrosPorPorte(String porte) throws SQLException, ClassNotFoundException {
		
		ArrayList<Cachorro> listaCachorros = new ArrayList<Cachorro>();
		
		String sql = "select * from cachorro where porte = ?";

        try (Connection conn = InterfaceConexao.obterConexao();
                PreparedStatement select = conn.prepareStatement(sql);){
        		
        		select.setString(1, porte);
        		
                ResultSet retorno = select.executeQuery(); 

        	//String nome, String raca, float peso, float altura, String cor, String porte
            while (retorno.next()) {
                Cachorro c = new Cachorro(
                        retorno.getInt("id"),
                        retorno.getString("nome"),
                        retorno.getString("raca"),
                        retorno.getFloat("peso"),
                        retorno.getFloat("altura"),
                        retorno.getString("cor"),
                        retorno.getString("porte"),
                        retorno.getString("status_adocao"));
                listaCachorros.add(c);
            }
            conn.close();
        }

        return listaCachorros;
	}
	
/**
 * Método utilizado para listar cachorros por status de adoção
 * 
 * @param status = String ('Adotado' ou 'Pendente adoção')
 * @return ArrayList do tipo Cachorro
 * @throws SQLException
 * @throws ClassNotFoundException
 */
public static ArrayList<Cachorro> listarCachorrosPorStatus(String status) throws SQLException, ClassNotFoundException {
	
	ArrayList<Cachorro> listaCachorros = new ArrayList<Cachorro>();
	
	String sql = "select * from cachorro where status_adocao = ?";

    try (Connection conn = InterfaceConexao.obterConexao();
            PreparedStatement select = conn.prepareStatement(sql);){
    		
    		select.setString(1, status);
    		
            ResultSet retorno = select.executeQuery(); 

    	//String nome, String raca, float peso, float altura, String cor, String porte
        while (retorno.next()) {
            Cachorro c = new Cachorro(
                    retorno.getInt("id"),
                    retorno.getString("nome"),
                    retorno.getString("raca"),
                    retorno.getFloat("peso"),
                    retorno.getFloat("altura"),
                    retorno.getString("cor"),
                    retorno.getString("porte"),
                    retorno.getString("status_adocao"));
            listaCachorros.add(c);
        }
        conn.close();
    }

    return listaCachorros;
}

/**
 * **É necessário um objeto com ID**
 * Este método edita um cachorro cadastrado no banco de dados 
 *
 * @param c = Objeto do tipo cachorro
 * @return boolean = true se sucesso, false se falha
 * @throws SQLException
 * @throws ClassNotFoundException
 */
public static boolean atualizarCachorro(Cachorro c) throws SQLException, ClassNotFoundException {
	
	boolean retorno = false;
	
	String sql = "UPDATE cachorro set nome = ?, raca = ?, peso = ?, porte = ?, altura = ?, cor = ? where id = ?";

    try (Connection conn = InterfaceConexao.obterConexao();
            PreparedStatement update = conn.prepareStatement(sql);
    		
    		) {
    	update.setString(1, c.getNome());
    	update.setString(2, c.getRaca());
    	update.setFloat(3, c.getPeso());
    	update.setString(4, c.getPorte());
    	update.setFloat(5, c.getAltura());
    	update.setString(6, c.getCor());
    	update.setInt(7, c.getId());
        
    	int linhasAfetadas = update.executeUpdate();

        if (linhasAfetadas > 0) {
            retorno = true;
        }
        conn.close();
    }
	
	return retorno;
	
}

/**
 * Este método encontra um cachorro por id no banco de dados
 * 
 * @param id = id do cachorro no banco de dados
 * @return ArrayList do tipo cachorro com um objeto
 * @throws SQLException
 * @throws ClassNotFoundException
 */
public static ArrayList<Cachorro> listarCachorroPorId(int id) throws SQLException, ClassNotFoundException {
	
	ArrayList<Cachorro> listaCachorros = new ArrayList<Cachorro>();
	
	String sql = "select * from cachorro where id = ?";

    try (Connection conn = InterfaceConexao.obterConexao();
            PreparedStatement select = conn.prepareStatement(sql);){
    		
    		select.setInt(1, id);
    		
            ResultSet retorno = select.executeQuery(); 

    	//String nome, String raca, float peso, float altura, String cor, String porte
        while (retorno.next()) {
            Cachorro c = new Cachorro(
                    retorno.getInt("id"),
                    retorno.getString("nome"),
                    retorno.getString("raca"),
                    retorno.getFloat("peso"),
                    retorno.getFloat("altura"),
                    retorno.getString("cor"),
                    retorno.getString("porte"),
                    retorno.getString("status_adocao"));
            listaCachorros.add(c);
        }
        conn.close();
    }

    return listaCachorros;
}
	
}
