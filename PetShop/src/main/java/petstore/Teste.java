package petstore;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CachorroDAO;
import model.Cachorro;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Cachorro dog  = new Cachorro(2, "Cleber", "Pit Bull", 10f, 10f, "Verde", "Pequeno", "");
		
		//System.out.println(CachorroDAO.atualizarCachorro(dog));
		System.out.println(CachorroDAO.adotarCachorro(dog));
		
		ArrayList<Cachorro> cachorros = CachorroDAO.listarCachorros();
		
		for(Cachorro c : cachorros) {
			System.out.println(c.getNome());
		}
		
	}

}
