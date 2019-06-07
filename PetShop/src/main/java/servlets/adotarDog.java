package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CachorroDAO;
import model.Cachorro;

@WebServlet(name = "adotarDog", urlPatterns = "/adotarDog")
public class adotarDog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("idDog"));

		try {
			List<Cachorro> cachorro = CachorroDAO.listarCachorroPorId(id);

			String nome = cachorro.get(0).getNome();
			String raca = cachorro.get(0).getRaca();
			float peso = cachorro.get(0).getPeso();
			float altura = cachorro.get(0).getAltura();
			String cor = cachorro.get(0).getCor();
			String porte = cachorro.get(0).getPorte();
			String status = cachorro.get(0).getStatusAdocao();

			System.out.println("nome" + nome);
			System.out.println("raca" + raca);
			System.out.println("peso" + peso);
			System.out.println("altura" + altura);
			System.out.println("cor" + cor);
			System.out.println("porte" + porte);
			System.out.println("status" + status);

			Cachorro dog = new Cachorro(cachorro.get(0).getId(), nome, raca, peso, altura, cor, porte, status);

			CachorroDAO.adotarCachorro(dog);

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

		request.getRequestDispatcher("listaDogs").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
