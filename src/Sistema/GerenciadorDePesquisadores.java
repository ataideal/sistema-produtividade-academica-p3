package Sistema;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Laboratorio;
import Classes.Pesquisador;
import Classes.Professor;
import Classes.Projeto;
import Classes.Publicacao;

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
	
	
	public void gerenciarPesquisador(ArrayList<Laboratorio> laboratorios, ArrayList<Projeto> projetos, Pesquisador pesquisador) {
		pesquisador.imprimirInfo();
		System.out.println("\tLaboratorios:");
		for (Laboratorio lab : laboratorios) {
			if(lab.verificarPesquisadorLab(pesquisador.getId())){
				System.out.println(lab.toString());
				System.out.println("\tProjetos:");
				for(Projeto pro : projetos){
					
					if(pro.verificarPesquisadorProj(pesquisador.getId())){
						System.out.println(pro.toString());
						System.out.println("\tPublicacoes:");
						for(Publicacao pub : pro.publicacoes){
							if(pub.verificarPesquisadorPub(pesquisador.getId())){
								System.out.println(pub.toString());
							}
						}
					}
				}
			}
			System.out.println("\n");
		}
	}

	public int totalPesquisadores() {
		return pesquisadores.size();
	}
	
	
}
