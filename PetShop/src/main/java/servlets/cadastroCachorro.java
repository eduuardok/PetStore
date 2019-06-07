package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CachorroDAO;
import model.CachorroGrande;
import model.CachorroMedio;
import model.CachorroPequeno;

@WebServlet(name = "cadastroCachorro", urlPatterns = "/cadastroCachorro")
public class cadastroCachorro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("".equalsIgnoreCase(request.getParameter("nomeDog")) || request.getParameter("nomeDog") != null) {
			String nome = request.getParameter("nomeDog");
			String raca = request.getParameter("racaDog");
			String peso = request.getParameter("pesoDog");
			String altura = request.getParameter("alturaDog");
			String cor = request.getParameter("corDog");

			System.out.println("Nome:" + nome);
			System.out.println("Ra�a:" + raca);
			System.out.println("Peso:" + peso);
			System.out.println("Altura:" + altura);
			System.out.println("Cor:" + cor);

			request.setAttribute("nomeDog", nome);
			request.setAttribute("racaDog", raca);
			request.setAttribute("pesoDog", peso);
			request.setAttribute("alturaDog", altura);
			request.setAttribute("corDog", cor);
		}
		request.getRequestDispatcher("CadastroCachorros.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("".equalsIgnoreCase(request.getParameter("nomeDog")) || request.getParameter("nomeDog") != null) {
			String nome = request.getParameter("nomeCachorro");
			String raca = request.getParameter("racaCachorro");
			float peso = Float.parseFloat(request.getParameter("pesoCachorro"));
			float altura = Float.parseFloat(request.getParameter("alturaCachorro"));
			String cor = request.getParameter("corCachorro");
			String porte = request.getParameter("porteCachorro");

			System.out.println("Nome:" + nome);
			System.out.println("Ra�a:" + raca);
			System.out.println("Peso:" + peso);
			System.out.println("Altura:" + altura);
			System.out.println("Cor:" + cor);

			switch (porte) {
			case "pequeno":
				CachorroDAO.addDog(new CachorroPequeno(nome, raca, peso, altura, cor));
				break;
			case "medio":
				CachorroDAO.addDog(new CachorroMedio(nome, raca, peso, altura, cor));
				break;
			case "grande":
				CachorroDAO.addDog(new CachorroGrande(nome, raca, peso, altura, cor));
				break;
			}

		}
		request.getRequestDispatcher("listaDogs").forward(request, response);
	}

}
