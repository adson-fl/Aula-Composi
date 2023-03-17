package apliacação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.ContratoPorHora;
import entidade.Departamento;
import entidade.Worker;
import entidade.Enums.WorkerLevel;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat std = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("entre com o departamento: ");
		String departamentoNome = sc.nextLine();
		System.out.println("entre com os dados do trabalhador: ");
		System.out.print("nome: ");
		String workerNome = sc.nextLine();
		System.out.print("nivel: ");
		String workeNivel = sc.nextLine();
		System.out.print("base salarial: ");
		double baseSalario = sc.nextDouble();
		
		Worker trabalhador = new Worker(workerNome, WorkerLevel.valueOf(workeNivel), baseSalario, new Departamento(departamentoNome));
		
		System.out.print("quantos contratos o trabalhador tem: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("entre com o contrato #" + i + " data: ");
			System.out.print("DD/MM/YYYY");
			Date contratoData = std.parse(sc.next());
			System.out.print("valor por hora do contrto: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("duração do contrato (HORAS): ");
			int horas = sc.nextInt();
			ContratoPorHora contrato = new ContratoPorHora(contratoData, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}
		System.out.println();
		System.out.print("entre com mes e ano para calcular o salario (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2)); // converte string para int
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("nome: " + trabalhador.getNome());
		System.out.println("departamento: " + trabalhador.getDepartamento().getNome()); // composição de objetos
		System.out.println("o trabalhador ganhol no perioldo " + mesAno + ": " + String.format("%.2f", trabalhador.pagamento(ano, mes)));
		
		sc.close();
		
	}

}
