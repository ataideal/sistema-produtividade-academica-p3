package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Aluno;
import Classes.Colaborador;
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
		System.out.println("\t Alunos:");
		for (Aluno alu : alunos) {
			if(verificarVinculoLab(alu.getId(),laboratorio.idAlunos))
				System.out.println("\t  Nome:"+alu.getNome());
		}
		System.out.println("\t Pesquisadores");
		for (Pesquisador pesq : pesquisadores) {
			if(verificarVinculoLab(pesq.getId(), laboratorio.idPesquisadores))
				System.out.println("\t  Nome:"+pesq.getNome());
		}
		System.out.println("\t Professores");
		for (Professor prof : professores) {
			if(verificarVinculoLab(prof.getId(), laboratorio.idProfessores))
				System.out.println("\t  Nome:"+prof.getNome());
		}
		System.out.println("\tProjetos");
		for (Projeto pro : projetos) {
			if(verificarVinculoLab(pro.getId(), laboratorio.idProjetos)){
				System.out.println("\t Titulo:"+pro.getTitulo()+" Status:"+pro.getStatus());
				for(Publicacao pub : pro.publicacoes){
					System.out.println("\t  Publicacao: "+pub.getTitulo()+" Ano:"+pub.getAnoDePublicacao());
				}
			}
		}
		System.out.println("\n");
		
	}
	private boolean verificarVinculoLab(int id, ArrayList<Integer> listaIds) {
		if(listaIds.contains(id))
			return true;
		return false;
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
