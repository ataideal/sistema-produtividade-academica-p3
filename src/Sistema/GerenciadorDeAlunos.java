package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Aluno;
import Classes.Laboratorio;
import Classes.Projeto;

public class GerenciadorDeAlunos {
	private int id;
	public ArrayList<Aluno> alunos;
	Scanner scan;
	public GerenciadorDeAlunos(){
		alunos = new ArrayList<>();
		id=0;
	}
	
	public void listarAlunos() {
		int i=0;
		for (Aluno alu : alunos) {
			System.out.println("\tAluno "+(i++)+"- "+alu.getNome());
		}
	}
	
	public void adicionarAluno(){
		System.out.println("\tCadastro de aluno ");		
		Aluno novoAluno = new Aluno(id++);
		scan = new Scanner(System.in);
		System.out.println("\tNome do aluno: ");
		String nome = scan.nextLine();
		novoAluno.setNome(nome);
		System.out.println("\tMatricula do aluno: ");
		String matricula = scan.nextLine();
		novoAluno.setMatricula(matricula);
		System.out.println("\tTipo do aluno(graduacao,mestrado,doutorado): ");
		String tipo = scan.nextLine();
		novoAluno.setTipo(tipo);
		System.out.println("\tEmail do aluno: ");
		String email = scan.nextLine();
		novoAluno.setEmail(email);
		
		alunos.add(novoAluno);
		System.out.println("\tAluno cadastrado!\n");
	}
	public void removerAluno(){
		listarAlunos();
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		try{
			alunos.remove(a);
			System.out.println("\tAluno removido!");
		}catch (Exception e) {
			System.out.println("\tERRO - não foi possível remover esse Aluno!");
		}
	}

	public void gerenciarAluno(ArrayList<Laboratorio> laboratorios, ArrayList<Projeto> projetos, Aluno aluno) {
		// TODO Auto-generated method stub
		
	}
}
