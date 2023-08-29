package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Carros;
import br.edu.ifgoiano.repositorio.CarrosRepositorio;


@WebServlet("/cadastrarCarros")
public class CadastrarCarrosServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Carros carros = new Carros();
		
		carros.setCor(req.getParameter("cor"));
		carros.setPlaca(req.getParameter("placa"));
		carros.setMarca(req.getParameter("marca"));
		
		CarrosRepositorio repositorio = new CarrosRepositorio();
		repositorio.inserirCarros(carros);
		
		resp.sendRedirect("index.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarrosRepositorio repositorio = new CarrosRepositorio();
		
		req.setAttribute("carros", repositorio.listarCarros());
		
		req.getRequestDispatcher("listarCarros.jsp").forward(req, resp);
	}
}
