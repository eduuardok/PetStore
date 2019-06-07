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
import model.CachorroGrande;
import model.CachorroMedio;
import model.CachorroPequeno;

@WebServlet(name = "cadastroCachorro", urlPatterns = "/cadastroCachorro")
public class cadastroCachorro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("tipo:"+request.getParameter("tipo"));
		request.setAttribute("tipoMetodo", "POST");
		request.setAttribute("tipo", request.getParameter("tipo"));

		if ("atualizacao".equalsIgnoreCase(request.getParameter("tipo"))) {
			int id = Integer.parseInt(request.getParameter("idDog"));
			try {
				System.out.println("ID NO GET:" + id);
				List<Cachorro> cachorro = CachorroDAO.listarCachorroPorId(id);
				request.setAttribute("idCachorro", cachorro.get(0).getId());
				request.setAttribute("nomeCachorro", cachorro.get(0).getNome());
				request.setAttribute("racaCachorro", cachorro.get(0).getRaca());
				request.setAttribute("pesoCachorro", cachorro.get(0).getPeso());
				request.setAttribute("porteCachorro", cachorro.get(0).getPorte());
				request.setAttribute("statusCachorro", cachorro.get(0).getStatusAdocao());
				request.setAttribute("corCachorro", cachorro.get(0).getCor());
				request.setAttribute("alturaCachorro", cachorro.get(0).getAltura());

			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher("CadastroCachorros.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nomeCachorro");
		String raca = request.getParameter("racaCachorro");
		float peso = Float.parseFloat(request.getParameter("pesoCachorro"));
		float altura = Float.parseFloat(request.getParameter("alturaCachorro"));
		String cor = request.getParameter("corCachorro");
		String porte = request.getParameter("porteCachorro");
		
		System.out.println("tipo:"+request.getParameter("tipo"));

		
		
		switch (porte) {
		case "pequeno":
			try {
				
				if ("cadastro".equalsIgnoreCase(request.getParameter("tipo"))) {
					CachorroDAO
							.inserirCachorro(new CachorroPequeno(nome, raca, peso, altura, cor, porte, "Disponivel"));
				} else if (request.getParameter("idCachorro") != null) {

					CachorroDAO
							.atualizarCachorro(new CachorroPequeno(Integer.parseInt(request.getParameter("idCachorro")),
									nome, raca, peso, altura, cor, porte, "Disponivel"));
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "medio":
			try {
				if ("cadastro".equalsIgnoreCase(request.getParameter("tipo"))) {
					CachorroDAO.inserirCachorro(new CachorroMedio(nome, raca, peso, altura, cor, porte, "Disponivel"));
				} else if (request.getParameter("idCachorro") != null) {
					CachorroDAO
							.atualizarCachorro(new CachorroMedio(Integer.parseInt(request.getParameter("idCachorro")),
									nome, raca, peso, altura, cor, porte, "Disponivel"));
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "grande":
			try {
				if ("cadastro".equalsIgnoreCase(request.getParameter("tipo"))) {
					CachorroDAO.inserirCachorro(new CachorroGrande(nome, raca, peso, altura, cor, porte, "Disponivel"));
				} else if (request.getParameter("idCachorro") != null) {
					CachorroDAO
							.atualizarCachorro(new CachorroGrande(Integer.parseInt(request.getParameter("idCachorro")),
									nome, raca, peso, altura, cor, porte, "Disponivel"));
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}

		request.getRequestDispatcher("listaDogs").forward(request, response);
	}

}
