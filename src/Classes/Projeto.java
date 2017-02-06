package Classes;
import java.util.ArrayList;
import java.util.Date;

public class Projeto {
	private String titulo,agenciaFinanciadora,objetivo,descricao,status;
	private Date inicio,termino;
	private double valorFinanciado;
	public ArrayList<Colaborador> colaboradores;
	public ArrayList<Publicacao> publicacoes;
	public ArrayList<Professor> professores;
	
	public Projeto (){
		colaboradores = new ArrayList<>();
		publicacoes = new ArrayList<>();
		professores = new ArrayList<>();
		setStatus("Em elaboracao");
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAgenciaFinanciadora() {
		return agenciaFinanciadora;
	}

	public void setAgenciaFinanciadora(String agenciaFinanciadora) {
		this.agenciaFinanciadora = agenciaFinanciadora;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public double getValorFinanciado() {
		return valorFinanciado;
	}

	public void setValorFinanciado(double valorFinanciado) {
		this.valorFinanciado = valorFinanciado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
