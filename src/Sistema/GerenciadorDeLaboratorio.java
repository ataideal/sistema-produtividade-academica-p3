package Sistema;

import java.util.ArrayList;

import Classes.Colaborador;
import Classes.Laboratorio;
import Classes.Projeto;
import Classes.Publicacao;

public class GerenciadorDeLaboratorio {
	ArrayList<Laboratorio> laboratorios;

	public GerenciadorDeLaboratorio(){
		laboratorios = new ArrayList<>();
	}
	public void listarLaboratorios() {
		int i=1;
		for (Laboratorio lab : laboratorios) {
			System.out.println((i++)+"- Nome:"+lab.getNome());
		}
	}

	public void gerenciarLab(Laboratorio laboratorio) {
		System.out.println("\tLaboratorio "+laboratorio.getNome());
		System.out.println("Colaboradores-");
		for (Colaborador col : laboratorio.colaboradores) {
			System.out.println("-Nome:"+col.getNome());
		}
		System.out.println("Projetos-");
		for (Projeto pro : laboratorio.projetos) {
			System.out.println("-Titulo:"+pro.getTitulo()+" Status:"+pro.getStatus());
			for(Publicacao pub : pro.publicacoes){
				System.out.println("--Publicacao: "+pub.getTitulo()+" Ano:"+pub.getAnoDePublicacao());
			}
		}
		System.out.println("\n");
	}



}
