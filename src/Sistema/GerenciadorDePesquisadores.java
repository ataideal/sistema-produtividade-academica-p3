package Sistema;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Pesquisador;

public class GerenciadorDePesquisadores {
	public ArrayList<Pesquisador> pesquisadores;
	private Scanner scan;
	private int id;

	
	public GerenciadorDePesquisadores (){
		pesquisadores = new ArrayList<>();
		id =0;
	}
	
	public void listarPesquisadores() {
		int i=0;
		for (Pesquisador pesq : pesquisadores) {
			System.out.println("\tPesquisador "+(i++)+"- "+pesq.getNome());
		}
	}
	
	public void adicionarPesquisador(){
		System.out.println("\tCadastro de pesquisador ");		
		Pesquisador novoPesquisador = new Pesquisador(id++);
		scan = new Scanner(System.in);
		System.out.println("\tNome do pesquisador: ");
		String nome = scan.nextLine();
		novoPesquisador.setNome(nome);
		System.out.println("\tEmail do pesquisador: ");
		String email = scan.nextLine();
		novoPesquisador.setEmail(email);
		
		pesquisadores.add(novoPesquisador);
		System.out.println("\tPesquisador cadastrado!\n");
	}
	public void removerPesquisador(){
		listarPesquisadores();
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		try{
			pesquisadores.remove(a);
			System.out.println("\tPesquisador removido!");
		}catch (Exception e) {
			System.out.println("\tERRO - não foi possível remover esse Pesquisador!");
		}
	}
	
	
	
}
