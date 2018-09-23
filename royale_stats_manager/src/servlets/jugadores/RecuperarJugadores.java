package servlets.jugadores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Jugador;
import model.GestionJugadores;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarJugadores")
public class RecuperarJugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionJugadores gj = new GestionJugadores();
		List<Jugador> jugadores = gj.recuperarJugadores();
		request.setAttribute("jugadores", jugadores);
		request.getRequestDispatcher("jugadores/ver_jugadores.jsp").forward(request, response);
	}
}