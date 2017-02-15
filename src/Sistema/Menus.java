package Sistema;

import java.util.Scanner;

import Classes.Laboratorio;
import Classes.Projeto;


public class Menus {
	public GerenciadorDeAlunos gerenciadorAlunos = new GerenciadorDeAlunos();
	public GerenciadorDePesquisadores gerenciadorPesquisadores = new GerenciadorDePesquisadores();
	public GerenciadorDeLaboratorio gerenciadorLaboratorios = new GerenciadorDeLaboratorio();
	public GerenciadorDeProfessor gerenciadorProfessor = new GerenciadorDeProfessor();
	public GerenciadorDeProjetos gerenciadorProjeto = new GerenciadorDeProjetos();
	private Scanner scan;

	public int menuPrincipal(){

		System.out.println("\tSistema de Produtividade Academica");
		System.out.println("\t1-Gerenciar Laboratorios");
		System.out.println("\t2-Gerenciar Alunos");
		System.out.println("\t3-Gerenciar Professores");
		System.out.println("\t4-Gerenciar Projetos");
		System.out.println("\t5-Gerenciar Pesquisadores");
		System.out.println("\t6-Relatorio");
		System.out.println("\t9-Sair\n");

		scan = new Scanner(System.in);
		int a = scan.nextInt();
		if((a<1 && a>5) && a!=9)
			return 0;
		return a;
	}

	public int menuGerenciarLaboratorio(){

		System.out.println("\tGerenciador de laboratorios");
		System.out.println("\t1-Listar laboratorios");
		System.out.println("\t2-Adicionar laboratorios");
		System.out.println("\t3-Remover laboratorios");
		System.out.println("\t9-Sair\n");

		scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a<1 && a>3 && a!=9)
			return 0;
		return a;
	}		

	public void menuEscolherLaboratorio(){
		gerenciadorLaboratorios.listarLaboratorios();
		System.out.println("\tSelecione um laboratorio");
		scan = new Scanner(System.in);
		int m3 = scan.nextInt();
		try{
			gerenciadorLaboratorios.gerenciarLab(gerenciadorLaboratorios.laboratorios.get(m3),gerenciadorAlunos.alunos,gerenciadorPesquisadores.pesquisadores,gerenciadorProfessor.professores,gerenciadorProjeto.projetos);
		}
		catch (Exception e) {
			System.out.println("ERRO - esse laboratorio nao existe!");
		}

	}

	public int menuGerenciarAlunos(){

		System.out.println("\tGerenciador de alunos");
		System.out.println("\t1-Listar alunos");
		System.out.println("\t2-Adicionar alunos");
		System.out.println("\t3-Remover alunos");
		System.out.println("\t9-Sair\n");

		scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a<1 && a>3 && a!=9)
			return 0;
		return a;
	}

	public void menuEscolherAluno(){
		gerenciadorAlunos.listarAlunos();
		System.out.println("\tSelecione um aluno");
		scan = new Scanner(System.in);
		int m3 = scan.nextInt();
		try{
			gerenciadorAlunos.gerenciarAluno(gerenciadorLaboratorios.laboratorios,gerenciadorProjeto.projetos,gerenciadorAlunos.alunos.get(m3));
		}
		catch (Exception e) {
			System.out.println("\tERRO - esse aluno nao existe!");
		}

	}

	public int menuGerenciarPesquisadores(){

		System.out.println("\tGerenciador de pesquisadores");
		System.out.println("\t1-Listar pesquisadores");
		System.out.println("\t2-Adicionar pesquisadores");
		System.out.println("\t3-Remover pesquisadores");
		System.out.println("\t9-Sair\n");

		scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a<1 && a>3 && a!=9)
			return 0;
		return a;
	}

	public void menuEscolherPesquisador(){
		gerenciadorPesquisadores.listarPesquisadores();
		System.out.println("\tSelecione um pesquisador");
		scan = new Scanner(System.in);
		int m3 = scan.nextInt();
		try{
			gerenciadorPesquisadores.gerenciarPesquisador(gerenciadorLaboratorios.laboratorios,gerenciadorProjeto.projetos,gerenciadorPesquisadores.pesquisadores.get(m3));
		}
		catch (Exception e) {
			System.out.println("\tERRO - esse pesquisador nao existe!");
		}

	}

	public int menuGerenciarProfessores(){

		System.out.println("\tGerenciador de professores");
		System.out.println("\t1-Listar professores");
		System.out.println("\t2-Adicionar professor");
		System.out.println("\t3-Remover professor");
		System.out.println("\t9-Sair\n");

		scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a<1 && a>3 && a!=9)
			return 0;
		return a;
	}

	public void menuEscolherProfessor(){
		gerenciadorProfessor.listarProfessores();
		System.out.println("\tSelecione um professor");
		scan = new Scanner(System.in);
		int m3 = scan.nextInt();
		try{
			gerenciadorProfessor.gerenciarProfessor(gerenciadorLaboratorios.laboratorios,gerenciadorProjeto.projetos,gerenciadorProfessor.professores.get(m3));
		}
		catch (Exception e) {
			System.out.println("\tERRO - esse professor nao existe!");
		}

	}
	public int menuGerenciarProjetos(){
		
		System.out.println("\tGerenciador de projetos");
		System.out.println("\t1-Listar projetos");
		System.out.println("\t2-Adicionar projeto");
		System.out.println("\t3-Remover projeto");
		System.out.println("\t9-Sair\n");
		
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a<1 && a>3 && a!=9)
			return 0;
		return a;
	}
	
	public void menuEscolherProjeto(){
		gerenciadorProjeto.listarProjetos();
		System.out.println("\tSelecione um projeto");
		scan = new Scanner(System.in);
		int m3 = scan.nextInt();
		try{
			for(Laboratorio lab:gerenciadorLaboratorios.laboratorios){
				if(lab.idProjetos.contains(gerenciadorProjeto.projetos.get(m3).getId()))
					gerenciadorProjeto.gerenciarProjeto(gerenciadorProjeto.projetos.get(m3), gerenciadorAlunos.alunos, gerenciadorPesquisadores.pesquisadores, gerenciadorProfessor.professores,lab);
			}
		}
		catch (Exception e) {
			System.out.println("\tERRO - esse projeto nao existe!");
		}
	
	}
	
	public void menuRelatorio(){
		System.out.println("\n\tLaboratorios:"+gerenciadorLaboratorios.totalLaboratorios());
		System.out.println("\tProjetos:"+gerenciadorProjeto.totalProjetos());
		System.out.println("\t	Projetos em elaboracao:"+gerenciadorProjeto.totalProjetosElaboracao());
		System.out.println("\t	Projetos em andamento:"+gerenciadorProjeto.totalProjetosAndamento());
		System.out.println("\t	Projetos concluidos:"+gerenciadorProjeto.totalProjetosConcluido());
		System.out.println("\tColaboradores:"+(gerenciadorAlunos.totalAlunos()+gerenciadorProfessor.totalProfessores()+gerenciadorPesquisadores.totalPesquisadores()));
		System.out.println("\t	Alunos:"+gerenciadorAlunos.totalAlunos());
		System.out.println("\t	Professores:"+gerenciadorProfessor.totalProfessores());
		System.out.println("\t	Pesquisadores:"+gerenciadorPesquisadores.totalPesquisadores());
		System.out.println("\tPublicacoes:"+gerenciadorProjeto.totalPublicacoes());
		System.out.println("\t	Alunos envolvidos em producoes:"+gerenciadorProjeto.totalAlunosPublicacoes());
		System.out.println("\t	Professores envolvidos em producoes:"+gerenciadorProjeto.totalProfessoresPublicacoes());
		System.out.println("\n");
	}
}
