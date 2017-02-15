package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Aluno;
import Classes.Laboratorio;
import Classes.Professor;
import Classes.Projeto;
import Classes.Publicacao;

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
	
	public void gerenciarProfessor(ArrayList<Laboratorio> laboratorios, ArrayList<Projeto> projetos, Professor professor) {
		professor.imprimirInfo();
		System.out.println("\tLaboratorios:");
		for (Laboratorio lab : laboratorios) {
			if(lab.verificarProfessorLab(professor.getId())){
				System.out.println(lab.toString());
				System.out.println("\tProjetos:");
				for(Projeto pro : projetos){
					
					if(pro.verificarProfessorProj(professor.getId())){
						System.out.println(pro.toString());
						System.out.println("\tPublicacoes:");
						for(Publicacao pub : pro.publicacoes){
							if(pub.verificarProfessorPub(professor.getId())){
								System.out.println(pub.toString());
							}
						}
					}
				}
			}
			System.out.println("\n");
		}
	}

	public int totalProfessores() {
		return professores.size();
	}
	
}
