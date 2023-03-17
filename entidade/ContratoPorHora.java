package entidade;

import java.util.Date;

public class ContratoPorHora {
	
	private Date data;
	private Double valorPorHora;
	private Integer valor;
	
	public ContratoPorHora() {
	}

	public ContratoPorHora(Date data, Double valorPorHora, Integer valor) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public Double totalValor() {
		return valorPorHora * valor;
	}
	
}
