package Classes;

import java.util.ArrayList;

public class Laboratorio {
	private String nome;
	public ArrayList<Colaborador> colaboradores;
	public ArrayList<Pesquisador> pesquisadores;
	public ArrayList<Projeto> projetos;
	
	public Laboratorio(){
		colaboradores = new ArrayList<>();
		projetos = new ArrayList<>();
		pesquisadores = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
