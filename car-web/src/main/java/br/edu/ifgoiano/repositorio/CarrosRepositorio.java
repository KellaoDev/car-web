package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.entidade.Carros;

public class CarrosRepositorio {

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:~/usuariodb", "sa", "sa");
	}

	public List<Carros> listarCarros() {
		List<Carros> listaCarros = new ArrayList<Carros>();

		String sql = "select id, cor, placa, marca from carros";

		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				Carros carros = new Carros();
				carros.setId(resultSet.getInt("id"));
				carros.setCor(resultSet.getString("cor"));
				carros.setPlaca(resultSet.getString("placa"));
				carros.setMarca(resultSet.getString("marca"));

				listaCarros.add(carros);
			}
		} catch (Exception e) {
			System.out.println("ERRO NA CONSULTA DE CARROS");
			e.printStackTrace();
		}
		return listaCarros;
	}

	public Carros obterCarros(Integer id) {

		String sql = "select id, cor, placa, marca from carros where id = ?";

		try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, id);

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				Carros carros = new Carros();
				carros.setId(id);
				carros.setCor(resultSet.getString("cor"));
				carros.setPlaca(resultSet.getString("placa"));
				carros.setMarca(resultSet.getString("marca"));

				return carros;
			}
		} catch (Exception e) {
			System.out.println("ERRO NA CONSULTA DE CARROS");
			e.printStackTrace();
		}
		throw new RuntimeException("CARROS NÃO ENCONTRADO!");
	}

	public void inserirCarros(Carros carros) {

		String sql = "insert into carros (cor, placa, marca) values (?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, carros.getCor());
			pst.setString(2, carros.getPlaca());
			pst.setString(3, carros.getMarca());

			pst.execute();

			conn.commit();

		} catch (Exception e) {
			System.out.println("ERRO NA CONSULTA DE CARROS");
			e.printStackTrace();
		}
	}

	public void alterarCarros(Carros carros) {

		String sql = "update carros set cor = ?, placa = ?, marca = ? where id = ?";

		try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, carros.getCor());
			pst.setString(2, carros.getPlaca());
			pst.setString(3, carros.getMarca());
			pst.setInt(4, carros.getId());

			pst.execute();

			conn.commit();

		} catch (Exception e) {
			System.out.println("ERRO NA ALTERAÇÃO DE CARROS");
			e.printStackTrace();
		}
	}
	
	public void excluirCarros(Carros carros) {

		String sql = "delete from carros where id = ?";

		try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, carros.getId());
			
			pst.execute();

			conn.commit();

		} catch (Exception e) {
			System.out.println("ERRO NA EXCLUSÃO DE CARROS");
			e.printStackTrace();
		}
	}
}
