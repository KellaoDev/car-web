package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifgoiano.entidade.Carros;
import br.edu.ifgoiano.repositorio.CarrosRepositorio;

@WebServlet("/excluirCarros")
public class ExcluirCarrosServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		Carros carros = new Carros();
		
		carros.setId(id);
		
		CarrosRepositorio repositorio = new CarrosRepositorio();
		repositorio.excluirCarros(carros);
		
		resp.sendRedirect("cadastrarCarros");
	}
}
