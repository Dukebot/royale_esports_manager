package servlets.equipos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipo;
import model.GestionEquipos;

/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/AltaEquipo")
public class AltaEquipo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		
		Equipo e = new Equipo();
		e.setNombre(nombre);
		
		GestionEquipos ge = new GestionEquipos();
		ge.altaEquipo(e);
		
		request.setAttribute("equipos", ge.recuperarEquipos());
		request.getRequestDispatcher("equipos/ver_equipos.jsp").forward(request, response);
	}
}
