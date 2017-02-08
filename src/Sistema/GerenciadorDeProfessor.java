package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Professor;

public class GerenciadorDeProfessor {
	public ArrayList<Professor> professores;
	private int id;
	Scanner scan;
	public GerenciadorDeProfessor(){
		professores = new ArrayList<>();
		id = 0;
	}
	
	public void listarProfessores() {
		int i=0;
		for (Professor prof : professores) {
			System.out.println("\tProfessor "+(i++)+"- "+prof.getNome());
		}
	}
	
	public void adicionarProfessor(){
		System.out.println("\tCadastro de professor ");		
		Professor novoProfessor = new Professor(id++);
		scan = new Scanner(System.in);
		System.out.println("\tNome do professor: ");
		String nome = scan.nextLine();
		novoProfessor.setNome(nome);
		System.out.println("\tEmail do professor: ");
		String email = scan.nextLine();
		novoProfessor.setEmail(email);
		
		professores.add(novoProfessor);
		System.out.println("\tProfessor cadastrado!\n");
	}
	public void removerProfessor(){
		listarProfessores();
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		try{
			professores.remove(a);
			System.out.println("\tProfessor removido!");
		}catch (Exception e) {
			System.out.println("\tERRO - não foi possível remover esse Professor!");
		}
	}
	
}
