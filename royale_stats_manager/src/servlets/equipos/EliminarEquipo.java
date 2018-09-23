package servlets.equipos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GestionEquipos;

/**
 * Servlet implementation class EliminaContacto
 */
@WebServlet("/EliminarEquipo")
public class EliminarEquipo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idEquipo = Integer.parseInt(request.getParameter("idEquipo"));
		GestionEquipos ge = new GestionEquipos();
		ge.eliminarEquipo(idEquipo);
		request.getRequestDispatcher("RecuperarEquipos").forward(request, response);
	}
}
