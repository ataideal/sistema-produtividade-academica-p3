package Sistema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Projeto;

public class GerenciadorDeProjetos {
	public ArrayList<Projeto> projetos;
	private int id;
	Scanner scan;
	public GerenciadorDeProjetos(){
		projetos = new ArrayList<>();
		id = 0;
	}
	
	
	public void listarProjetos() {
		int i=0;
		for (Projeto pro : projetos) {
			System.out.println("\tProjeto "+(i++)+"- "+pro.getTitulo()+" | Laboratorio-"+getLabNome(pro.getId()));
		}
	}
	
	private String getLabNome(int id) {
		return "";
	}


	public void adicionarProjeto(){
		System.out.println("\tCadastro de projeto ");		
		Projeto novoProjeto = new Projeto(id++);
		scan = new Scanner(System.in);
		System.out.println("\tTitulo do projeto: ");
		String titulo = scan.nextLine();
		novoProjeto.setTitulo(titulo);
		System.out.println("\tDescricao do projeto: ");
		String descricao = scan.nextLine();
		novoProjeto.setDescricao(descricao);
		System.out.println("\tAgencia Financiadora do projeto: ");
		String agenciaFinanciadora = scan.nextLine();
		novoProjeto.setAgenciaFinanciadora(agenciaFinanciadora);
		System.out.println("\tObjetivo do projeto: ");
		String objetivo = scan.nextLine();
		novoProjeto.setObjetivo(objetivo);
		
		boolean done=false;
		while(!done){
			System.out.println("\tInicio do projeto(dd/mm/aaaa): ");
			String inicio = scan.nextLine();
			try{
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.sql.Date data = new java.sql.Date(format.parse(inicio).getTime());
				novoProjeto.setInicio(data);
				done = true;
			}catch (Exception e) {
				System.out.println("\tERRO - data invalida!\n");
			}
		}

		done=false;
		while(!done){
			System.out.println("\tTermino do projeto(dd/mm/aaaa): ");
			String termino = scan.nextLine();
			try{
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.sql.Date data = new java.sql.Date(format.parse(termino).getTime());
				novoProjeto.setInicio(data);
				done = true;
			}catch (Exception e) {
				System.out.println("\tERRO - data invalida!\n");
			}
		}
		
		System.out.println("\tValor de financiamento do projeto: ");
		double valorFinanciado = scan.nextDouble();
		novoProjeto.setValorFinanciado(valorFinanciado);;
		
		projetos.add(novoProjeto);
		System.out.println("\tProjeto cadastrado!\n");
	}
	public void removerProjeto(){
		listarProjetos();
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		try{
			projetos.remove(a);
			System.out.println("\tProjeto removido!");
		}catch (Exception e) {
			System.out.println("\tERRO - não foi possível remover esse Projeto!");
		}
	}
}
