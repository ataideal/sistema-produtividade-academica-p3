package Classes;

import java.util.ArrayList;

public class Laboratorio {
	private final int id;
	private String nome;
	public ArrayList<Integer> idAlunos;
	public ArrayList<Integer> idProfessores;
	public ArrayList<Integer> idPesquisadores;
	public ArrayList<Integer> idProjetos;
	
	public Laboratorio(int id){
		idAlunos = new ArrayList<>();
		idProfessores = new ArrayList<>();
		idPesquisadores = new ArrayList<>();
		idProjetos = new ArrayList<>();
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}	
}
