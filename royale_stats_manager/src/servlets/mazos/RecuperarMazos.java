package servlets.mazos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Mazo;
import model.GestionMazos;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarMazos")
public class RecuperarMazos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionMazos gm = new GestionMazos();
		List<Mazo> mazos = gm.recuperarMazos();
		request.setAttribute("mazos", mazos);
		request.getRequestDispatcher("mazos/ver_mazos.jsp").forward(request, response);
	}

}
