package servlets;

import java.io.IOException;
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
		String nome = request.getParameter("nomeDog");
		String raca = request.getParameter("racaDog");
		float peso = Float.parseFloat(request.getParameter("pesoDog"));
		float altura = Float.parseFloat(request.getParameter("alturaDog"));
		String cor = request.getParameter("corDog");

		Cachorro dog = new Cachorro(nome, raca, peso, altura, cor);

		CachorroDAO.removeDog(dog);
		
		request.getRequestDispatcher("listaDogs").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
