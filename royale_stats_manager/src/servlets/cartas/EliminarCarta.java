package servlets.cartas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GestionCartas;

/**
 * Servlet implementation class EliminaContacto
 */
@WebServlet("/EliminarCarta")
public class EliminarCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idCarta = Integer.parseInt(request.getParameter("idCarta"));
		GestionCartas gc = new GestionCartas();
		gc.eliminarCarta(idCarta);
		request.getRequestDispatcher("RecuperarCartas").forward(request, response);
	}
}
