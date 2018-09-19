package servlets.mazos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Carta;
import model.GestionCartas;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/ToNuevoMazo")
public class ToNuevoMazo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionCartas gCartas = new GestionCartas();
		List<Carta> cartas = gCartas.recuperarCartas();
		request.setAttribute("cartas", cartas);
		request.getRequestDispatcher("mazos/nuevo_mazo.jsp").forward(request, response);
	}

}