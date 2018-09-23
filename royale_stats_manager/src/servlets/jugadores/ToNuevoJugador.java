package servlets.jugadores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipo;
import model.GestionEquipos;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/ToNuevoJugador")
public class ToNuevoJugador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionEquipos ge = new GestionEquipos();
		List<Equipo> equipos = ge.recuperarEquipos();
		request.setAttribute("equipos", equipos);
		request.getRequestDispatcher("jugadores/nuevo_jugador.jsp").forward(request, response);
	}

}