package Classes;

import java.util.ArrayList;

public class Publicacao {
	private String titulo, nomeDaConferencia, anoDePublicacao;
	public ArrayList<Colaborador> participantes;
	private Professor orientador;
	
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
	public String getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setAnoDePublicacao(String anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	public Professor getOrientador() {
		return orientador;
	}
	public void setOrientador(Professor orientador) {
		this.orientador = orientador;
	}
	
}
