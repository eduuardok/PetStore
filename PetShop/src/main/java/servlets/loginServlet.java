package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("emailUsuario");
		String senha = request.getParameter("senhaUsuario");

		HttpSession sessao = request.getSession();

		if ("adm@adm.com".equalsIgnoreCase(email) && "admin".equalsIgnoreCase(senha)) {
			sessao.setAttribute("isLogado", true);
			request.getRequestDispatcher("home").forward(request, response);
		} else {
			request.setAttribute("login", false);
			sessao.setAttribute("isLogado", false);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
