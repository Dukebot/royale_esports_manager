package servlets.jugadores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipo;
import entities.Jugador;
import model.GestionEquipos;
import model.GestionJugadores;

/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/AltaJugador")
public class AltaJugador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Estoy dentro de la accion AltaJugador");
		
		String nombre = request.getParameter("nombre");
		String idEquipo = request.getParameter("seleccionEquipo");
		
		System.out.println("El valor del parámetro nombre es " + nombre);
		System.out.println("El valor del parámetro seleccionEquipo es " + idEquipo);
		
		GestionEquipos ge = new GestionEquipos();
		GestionJugadores gj = new GestionJugadores();
		
		Equipo e = ge.recuperarEquipo(idEquipo);
		
		Jugador j = new Jugador();
		j.setNombre(nombre);
		j.setEquipo(e);
		
		gj.altaJugador(j);
		System.out.println("El jugador ha sido guardado en Base de Datos");
		
		String url = "jugadores/ver_jugadores.jsp";
		System.out.println("La URL es " + url);
		
		request.setAttribute("jugadores", gj.recuperarJugadores());
		request.getRequestDispatcher(url).forward(request, response);
	}
}
