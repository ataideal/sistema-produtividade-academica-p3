package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Aluno;
import Classes.Laboratorio;
import Classes.Pesquisador;
import Classes.Professor;
import Classes.Projeto;
import Classes.Publicacao;

public class GerenciadorDeLaboratorio {
	public ArrayList<Laboratorio> laboratorios;
	private int id;
	private Scanner scan;
	public GerenciadorDeLaboratorio(){
		laboratorios = new ArrayList<>();
		id=0;
	}
	public void listarLaboratorios() {
		int i=0;
		for (Laboratorio lab : laboratorios) {
			System.out.println("\tLaboratorio "+(i++)+"- "+lab.getNome());
		}
	}

	public void gerenciarLab(Laboratorio laboratorio, ArrayList<Aluno> alunos, ArrayList<Pesquisador> pesquisadores, ArrayList<Professor> professores, ArrayList<Projeto> projetos) {
		System.out.println("\n\t\tLaboratorio "+laboratorio.getNome());
		System.out.println("\tColaboradores:");
		System.out.println("\t Alunos");
		for (Aluno alu : alunos) {
			if(laboratorio.verificarAlunoLab(alu.getId()))
				System.out.println(alu.toString());
		}
		System.out.println("\t Pesquisadores");
		for (Pesquisador pesq : pesquisadores) {
			if(laboratorio.verificarPesquisadorLab(pesq.getId()))
				System.out.println(pesq.toString());
		}
		System.out.println("\t Professores");
		for (Professor prof : professores) {
			if(laboratorio.verificarProfessorLab(prof.getId()))
				System.out.println(prof.toString());
		}
		System.out.println("\tProjetos:");
		for (Projeto pro : projetos) {
			if(laboratorio.verificarProjetoLab(pro.getId())){
				System.out.println(pro.toString());
				for(Publicacao pub : pro.publicacoes){
					System.out.println(pub.toString());
				}
			}
		}
		System.out.println("\n");

		System.out.println("\t1-Alocar novo aluno");
		System.out.println("\t2-Alocar novo pesquisador");
		System.out.println("\t3-Alocar novo professor");
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		int i=0;
		if(a==1){
			for (Aluno alu : alunos) {
				if(!laboratorio.verificarAlunoLab(alu.getId())){
					System.out.println("\tAluno-"+(i++)+alu.toString());
				}
			}
			if(i==0)
				System.out.println("Nao existem alunos para associar");
			else{
				System.out.println("Digite o numero de um aluno:");

				int m = scan.nextInt();
				int j=0;
				boolean ok=false;
				for (Aluno alu : alunos) {
					if(!laboratorio.verificarAlunoLab(alu.getId())){
						if(j==m){
							laboratorio.idAlunos.add(alu.getId());
							ok=true;
							break;
						}
						j++;
					}
				}
				if(ok)
					System.out.println("\tAluno associado!");
				else
					System.out.println("\tNao foi possivel associar aluno!");
			}
		}
		else if(a==2){
			for (Pesquisador pesq : pesquisadores) {
				if(!laboratorio.verificarPesquisadorLab(pesq.getId())){
					System.out.println("\tPesquisador-"+(i++)+pesq.toString());
				}
			}

			if(i==0)
				System.out.println("Nao existem pesquisadores para associar");
			else{
				System.out.println("Digite o numero de um pesquisador:");

				int m = scan.nextInt();
				int j=0;
				boolean ok=false;
				for (Pesquisador pesq : pesquisadores) {
					if(!laboratorio.verificarPesquisadorLab(pesq.getId())){
						if(j==m){
							laboratorio.idPesquisadores.add(pesq.getId());
							ok=true;
							break;
						}
						j++;
					}
				}
				if(ok)
					System.out.println("\tPesquisador associado!");
				else
					System.out.println("\tNao foi possivel associar pesquisador!");
			}
		}
		else if(a==3){
			for (Professor prof : professores) {
				if(!laboratorio.verificarProfessorLab(prof.getId())){
					System.out.println("\tProfessor-"+(i++)+prof.toString());
				}
			}
			if(i==0)
				System.out.println("Nao existem professores para associar");
			else{
				System.out.println("Digite o numero de um professor:");
				int m = scan.nextInt();
				int j=0;
				boolean ok=false;
				for (Professor prof : professores) {
					if(!laboratorio.verificarProfessorLab(prof.getId())){
						if(j==m){
							laboratorio.idProfessores.add(prof.getId());
							ok=true;
							break;
						}
						j++;
					}
				}
				if(ok)
					System.out.println("\tProfessor associado!");
				else
					System.out.println("\tNao foi possivel associar professor!");
			}
		}
	}

	public void adicionarLaboratorio() {
		System.out.println("\tCadastro de laboratorio ");		
		Laboratorio novoLab = new Laboratorio(id++);
		System.out.println("\tNome do laboratorio: ");
		scan = new Scanner(System.in);
		String nome = scan.nextLine();
		novoLab.setNome(nome);
		laboratorios.add(novoLab);
		System.out.println("\tLaboratorio cadastrado!\n");
	}
	public void removerLaboratorio() {
		listarLaboratorios();
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		try{
			laboratorios.remove(a);
			System.out.println("\tLaboratorio removido!");
		}catch (Exception e) {
			System.out.println("\tERRO - não foi possível remover esse laboratorio!");
		}
	}



}
