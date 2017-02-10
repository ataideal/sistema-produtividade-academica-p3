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
	
	@Override
	public String toString() {
		return "\tNome:"+nome;
	}
	
	public boolean verificarAlunoLab(int id) {
		if(idAlunos.contains(id))
			return true;
		return false;
	}
	public boolean verificarPesquisadorLab(int id) {
		if(idPesquisadores.contains(id))
			return true;
		return false;
	}
	public boolean verificarProfessorLab(int id) {
		if(idProfessores.contains(id))
			return true;
		return false;
	}
	public boolean verificarProjetoLab(int id) {
		if(idProjetos.contains(id))
			return true;
		return false;
	}
}
