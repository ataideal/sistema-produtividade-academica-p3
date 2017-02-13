package Classes;

import java.util.ArrayList;
import java.util.Date;

public class Publicacao {
	private String titulo, nomeDaConferencia;
	private Date anoPublicacao;
	public ArrayList<Integer> idAlunos;
	public ArrayList<Integer> idProfessores;
	public ArrayList<Integer> idPesquisadores;
	private Integer idOrientador;
	
	public Publicacao() {
		idAlunos = new ArrayList<>();
		idProfessores = new ArrayList<>();
		idPesquisadores = new ArrayList<>();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNomeDaConferencia() {
		return nomeDaConferencia;
	}
	public void setNomeDaConferencia(String nomeDaConferencia) {
		this.nomeDaConferencia = nomeDaConferencia;
	}
	
	@Override
	public String toString() {
		return "\t  Publicacao: "+getTitulo()+" Ano:"+getAnoPublicacao().toString();
	}
	public Integer getIdOrientador() {
		return idOrientador;
	}
	public void setIdOrientador(Integer idOrientador) {
		this.idOrientador = idOrientador;
	}
	
	public boolean verificarAlunoPub(int id) {
		if(idAlunos.contains(id))
			return true;
		return false;
	}
	public boolean verificarPesquisadorPub(int id) {
		if(idPesquisadores.contains(id))
			return true;
		return false;
	}
	public boolean verificarProfessorPub(int id) {
		if(idProfessores.contains(id))
			return true;
		if(idOrientador.intValue() == id)
			return true;
		return false;
	}
	public Date getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(Date anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
}
