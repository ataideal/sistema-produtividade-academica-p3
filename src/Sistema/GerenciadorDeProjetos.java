package Sistema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Aluno;
import Classes.Laboratorio;
import Classes.Pesquisador;
import Classes.Professor;
import Classes.Projeto;
import Classes.Publicacao;

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
	
	public void gerenciarProjeto(Projeto projeto, ArrayList<Aluno> alunos, ArrayList<Pesquisador> pesquisadores, ArrayList<Professor> professores) {
		projeto.imprimirInfo();
		System.out.println("\tColaboradores:");
		System.out.println("\t Alunos");
		for (Aluno alu : alunos) {
			if(projeto.verificarAlunoProj(alu.getId()))
				System.out.println(alu.toString());
		}
		System.out.println("\t Pesquisadores");
		for (Pesquisador pesq : pesquisadores) {
			if(projeto.verificarPesquisadorProj(pesq.getId()))
				System.out.println(pesq.toString());
		}
		System.out.println("\t Professores");
		for (Professor prof : professores) {
			if(projeto.verificarProfessorProj(prof.getId()))
				System.out.println(prof.toString());
		}
		System.out.println("\t Publicacoes");
		for(Publicacao pub : projeto.publicacoes){
			System.out.println(pub.toString());
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
				if(!projeto.verificarAlunoProj(alu.getId())){
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
					if(!projeto.verificarAlunoProj(alu.getId())){
						if(j==m){
							projeto.idAlunos.add(alu.getId());
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
				if(!projeto.verificarPesquisadorProj(pesq.getId())){
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
					if(!projeto.verificarPesquisadorProj(pesq.getId())){
						if(j==m){
							projeto.idPesquisadores.add(pesq.getId());
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
				if(!projeto.verificarProfessorProj(prof.getId())){
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
					if(!projeto.verificarProfessorProj(prof.getId())){
						if(j==m){
							projeto.idProfessores.add(prof.getId());
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
}
