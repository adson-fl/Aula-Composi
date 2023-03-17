package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidade.Enums.WorkerLevel;

public class Worker {

	private String nome;
	private WorkerLevel nievel;
	private Double BaseSalarial;
	
	private Departamento departamento;
	// composição > um trabalhador pode ter mais de um contrto |não se cria construtores para para listas ,pois posso estanci no arraylist<>
	private List<ContratoPorHora> contratos = new ArrayList<>();
	
	public Worker(){
	}

	public Worker(String nome, WorkerLevel nievel, Double baseSalarial, Departamento departamento) {
		this.nome = nome;
		this.nievel = nievel;
		this.BaseSalarial = baseSalarial;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public WorkerLevel getNievel() {
		return nievel;
	}

	public void setNievel(WorkerLevel nievel) {
		this.nievel = nievel;
	}

	public Double getBaseSalarial() {
		return BaseSalarial;
	}

	public void setBaseSalarial(Double baseSalarial) {
		BaseSalarial = baseSalarial;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoPorHora> getContrato() {
		return contratos;
	}

	// percorre lista de contratos 
	public void addContrato(ContratoPorHora contrato) { // deve ser diferente do referenciado 
		contratos.add(contrato);
	}
	// remover contrato
	public void removeContrato(ContratoPorHora contrato) {
		contratos.remove(contrato);
	}
	public double pagamento(int ano, int mes) {
		double sum = BaseSalarial;
		Calendar cal = Calendar.getInstance();
		for (ContratoPorHora c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			// a declaração de mes e ano já esta incluso int c_ano e no int c_mes
			if(ano == c_ano && mes == c_mes) {
				sum += c.totalValor();
			}
		}
		return sum;
	}
}
