package br.edu.ifgoiano.entidade;

public class Carros {

	private static Integer incremento = 0;
	
	private Integer id;
	private String cor;
	private String placa;
	private String marca;
	
	public Carros() {
		this.id = incremento++;
	}

	public static Integer getIncremento() {
		return incremento;
	}

	public static void setIncremento(Integer incremento) {
		Carros.incremento = incremento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
}
