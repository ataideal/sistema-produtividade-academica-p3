package Sistema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	public int totalProjetos(){
		return projetos.size();
	}
	public int totalProjetosAndamento(){
		int total=0;
		for(Projeto proj:projetos){
			if(proj.getStatus().equalsIgnoreCase("Em andamento"))
				total++;
		}
		return total;
	}
	public int totalProjetosConcluido(){
		int total=0;
		for(Projeto proj:projetos){
			if(proj.getStatus().equalsIgnoreCase("Concluido"))
				total++;
		}
		return total;
	}
	
	public int	totalProjetosElaboracao(){
		int total=0;
		for(Projeto proj:projetos){
			if(proj.getStatus().equalsIgnoreCase("Em elaboracao"))
				total++;
		}
		return total;
	}
	public void listarProjetos() {
		int i=0;
		for (Projeto pro : projetos) {
			System.out.println("\tProjeto "+(i++)+"- "+pro.getTitulo());
		}
	}
	
	public void adicionarProjeto(ArrayList<Laboratorio> laboratorios, ArrayList<Professor> professores){
		System.out.println("\tCadastro de projeto ");
		System.out.println("\tSelecione o laboratorio do projeto:");
		int i=0;
		for(Laboratorio lab:laboratorios){
			System.out.println("Laboratorio " +(i++)+" - "+lab.toString());
		}
		boolean done=false;
		int m=0;
		try{
			scan = new Scanner(System.in);
			m = scan.nextInt();
			laboratorios.get(m);
		}
		catch (Exception e) {
			System.out.println("\tERRO - laboratorio nao existe");
			return ;
		}
		
		Projeto novoProjeto = new Projeto(id++);
		i=0;
		System.out.println("\tSelecione um professor para o projeto:");
		for(Professor prof:professores){
			System.out.println("Professor " +(i++)+" - "+prof.toString());
		}
		int m1=0;
		try{
			scan = new Scanner(System.in);
			 m1= scan.nextInt();
			 novoProjeto.idProfessores.add(professores.get(m1).getId());
		}
		catch (Exception e) {
			System.out.println("\tERRO - Professor nao existe");
			return ;
		}
		
	
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
		
		done=false;
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
				novoProjeto.setTermino(data);
				done = true;
			}catch (Exception e) {
				System.out.println("\tERRO - data invalida!\n");
			}
		}
		
		System.out.println("\tValor de financiamento do projeto: ");
		double valorFinanciado = scan.nextDouble();
		novoProjeto.setValorFinanciado(valorFinanciado);;
		laboratorios.get(m).idProjetos.add(novoProjeto.getId());
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
	
	public void gerenciarProjeto(Projeto projeto, ArrayList<Aluno> alunos, ArrayList<Pesquisador> pesquisadores, ArrayList<Professor> professores, Laboratorio lab) {
		projeto.imprimirInfo(lab);
		System.out.println("\tColaboradores:");
		System.out.println("\t Alunos");
		for (Aluno alu : alunos) {
			if(projeto.verificarAlunoProj(alu.getId()) && lab.idAlunos.contains(alu.getId()))
				System.out.println(alu.toString());
		}
		System.out.println("\t Pesquisadores");
		for (Pesquisador pesq : pesquisadores) {
			if(projeto.verificarPesquisadorProj(pesq.getId()) && lab.idPesquisadores.contains(pesq.getId()))
				System.out.println(pesq.toString());
		}
		System.out.println("\t Professores");
		for (Professor prof : professores) {
			if(projeto.verificarProfessorProj(prof.getId()) && lab.idProfessores.contains(prof.getId()))
				System.out.println(prof.toString());
		}
		System.out.println("\t Publicacoes");
		for(Publicacao pub : projeto.publicacoes){
			System.out.println(pub.toString());
			System.out.print("\t  Orientador: ");
			for(Professor prof:professores){
				if(prof.getId() == pub.getIdOrientador())
					System.out.println(prof.getNome());
			}
			
			System.out.println("\t  Colaboradores: ");
			for(Aluno alu:alunos){
				if(pub.idAlunos.contains(alu.getId()))
					System.out.println("   "+alu.toString());
			}
		}
		
		System.out.println("\n");

		System.out.println("\t1-Alocar novo aluno");
		System.out.println("\t2-Alocar novo pesquisador");
		System.out.println("\t3-Alocar novo professor");
		System.out.println("\t4-Mudar Status");
		System.out.println("\t5-Criar Publicacao");
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		int i=0;
		if(a==1){
			if(projeto.getStatus().equalsIgnoreCase("Em elaboracao")){
				for (Aluno alu : alunos) {
					if(!projeto.verificarAlunoProj(alu.getId()) && lab.idAlunos.contains(alu.getId()) && !alu.isTemProjeto()){
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
						if(!projeto.verificarAlunoProj(alu.getId()) && lab.idAlunos.contains(alu.getId())&& !alu.isTemProjeto()){
							if(j==m){
								projeto.idAlunos.add(alu.getId());
								alu.setTemProjeto(true);
								ok=true;
								break;
							}
							j++;
						}
					}
					if(ok){
						System.out.println("\tAluno associado!");
					}
					else
						System.out.println("\tNao foi possivel associar aluno!");
				}
			}else{
				System.out.println("O Projeto nao está em elaboração");
			}
		}
		else if(a==2){
			if(projeto.getStatus().equalsIgnoreCase("Em elaboracao")){
				for (Pesquisador pesq : pesquisadores) {
					if(!projeto.verificarPesquisadorProj(pesq.getId())&& lab.idPesquisadores.contains(pesq.getId())){
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
						if(!projeto.verificarPesquisadorProj(pesq.getId())&& lab.idPesquisadores.contains(pesq.getId())){
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
			}else{
				System.out.println("O Projeto nao está em elaboração");
			}
		}
		else if(a==3){
			if(projeto.getStatus().equalsIgnoreCase("Em elaboracao")){
				for (Professor prof : professores) {
					if(!projeto.verificarProfessorProj(prof.getId())&&lab.idProfessores.contains(prof.getId())){
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
						if(!projeto.verificarProfessorProj(prof.getId()) && lab.idProfessores.contains(prof.getId())){
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
			}else{
				System.out.println("O Projeto nao está em elaboração");
			}
		}
		else if(a==4){
			System.out.println("Selecione o status\n1-Em elaboração\n2-Em andamento\n3-Concluido");
			scan = new Scanner(System.in);
			int x = scan.nextInt();
			if(x==1)
				projeto.setStatus("Em elaboracao");
			else if(x==2)
				projeto.setStatus("Em andamento");
			else if(x==3){
				if(projeto.publicacoes.size()>0)
					projeto.setStatus("Concluido");
				else
					System.out.println("\tNao existem publicacoes no projeto");
			}
				
		}
		else if(a==5){
			if(projeto.getStatus().equalsIgnoreCase("Em andamento")){
				Publicacao novaPublicacao = new Publicacao();
				scan = new Scanner(System.in);
				System.out.println("\tTitulo da publicacao: ");
				String titulo = scan.nextLine();
				novaPublicacao.setTitulo(titulo);
				System.out.println("\tNome da conferencia: ");
				String conferencia = scan.nextLine();
				novaPublicacao.setNomeDaConferencia(conferencia);
				
				scan = new Scanner(System.in);
				boolean done = false;
				while(!done){
					System.out.println("\tAno da publicacao(aaaa): ");
					String ano = scan.nextLine();
					try{
						SimpleDateFormat format = new SimpleDateFormat("yyyy");
						java.sql.Date data = new java.sql.Date(format.parse(ano).getTime());
						novaPublicacao.setAnoPublicacao(data);
						done = true;
					}catch (Exception e) {
						System.out.println("\tERRO - data invalida!\n");
					}
				}
				
				i=0;
				System.out.println("\tSelecione um aluno (-1 para parar): ");
				for(Aluno alu:alunos){
					if(projeto.idAlunos.contains(alu.getId())){
						System.out.println("\tAluno "+(i++)+" Nome: "+alu.getNome());
					}
				}
				int c=0;
				scan = new Scanner(System.in);
				while(c!=-1){
					try {
						c = scan.nextInt();
						if(c!=-1){
							int j=0;
							for(Aluno alu:alunos){
								if(projeto.idAlunos.contains(alu.getId())){
									if(j==c){
										novaPublicacao.idAlunos.add(alu.getId());
										break;
									}
								}
							}

						}
					} catch (Exception e) {
						System.out.println("\tERRO - nao foi possivel adicionar aluno");
					}
				}
				i=0;
				System.out.println("\tSelecione um professor orientador: ");
				for(Professor prof:professores){
					if(projeto.idProfessores.contains(prof.getId())){
						System.out.println("\tProfessor "+(i++)+" Nome: "+prof.getNome());
					}
				}
				c=0;
				try{
					c = scan.nextInt();
					int j=0;
					for(Professor prof:professores){
						if(projeto.idProfessores.contains(prof.getId())){
							if(j==c){
								novaPublicacao.setIdOrientador(prof.getId());
								break;
							}
						}
					}
				}catch(Exception e){
					System.out.println("\tERRO - nao foi possivel adicionar orientador");
				}
				
				projeto.publicacoes.add(novaPublicacao);
				
				try {
					Collections.sort(projeto.publicacoes, new Comparator<Publicacao>() {
						  public int compare(Publicacao o1, Publicacao o2) {
						      return o2.getAnoPublicacao().compareTo(o1.getAnoPublicacao());
						  }
						});
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("\tPublicacao adicionada\n");
			}else{
				System.out.println("\tProjeto nao está em andamento!");
			}
		}
	}
	public int totalPublicacoes() {
		int total=0;
		for(Projeto proj:projetos){
			total += proj.publicacoes.size();
		}
		return total;
	}
	public int totalAlunosPublicacoes() {
		int total=0;
		for(Projeto proj:projetos){
			for(Publicacao pub:proj.publicacoes){
				total += pub.idAlunos.size();
			}
		}
		return total;
	}
	
	public int totalProfessoresPublicacoes() {
		int total=0;
		for(Projeto proj:projetos){
			for(Publicacao pub:proj.publicacoes){
				total++;
				total += pub.idProfessores.size();
			}
		}
		return total;
	}
}
