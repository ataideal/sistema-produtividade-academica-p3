package Classes;
import java.util.ArrayList;
import java.util.Date;

public class Projeto {
	private final int id;
	private String titulo,agenciaFinanciadora,objetivo,descricao,status;
	private Date inicio,termino;
	private double valorFinanciado;
	public ArrayList<Publicacao> publicacoes;
	public ArrayList<Integer> idAlunos;
	public ArrayList<Integer> idProfessores;
	public ArrayList<Integer> idPesquisadores;
	
	public Projeto (int id){
		publicacoes = new ArrayList<>();
		idAlunos = new ArrayList<>();
		idProfessores = new ArrayList<>();
		idPesquisadores = new ArrayList<>();
		setStatus("Em elaboracao");
		this.id = id;
	}
	
	public void imprimirInfo(Laboratorio lab){
		System.out.println("\t\tProjeto "+titulo+ "\tLaboratorio: "+lab.getNome());
		System.out.println("\tInicio "+inicio.toString());
		System.out.println("\tTermino"+termino.toString());
		System.out.println("\tStatus:"+status);
		System.out.println("\tAgencia Financiadora:"+agenciaFinanciadora);
		System.out.println("\tValor Financiado:"+valorFinanciado);
		System.out.println("\tObjetivo:"+objetivo);
		System.out.println("\tDescricao:"+descricao);
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

	public int getId() {
		return id;
	}
	
	public boolean verificarAlunoProj(int id) {
		if(idAlunos.contains(id))
			return true;
		return false;
	}
	public boolean verificarPesquisadorProj(int id) {
		if(idPesquisadores.contains(id))
			return true;
		return false;
	}
	public boolean verificarProfessorProj(int id) {
		if(idProfessores.contains(id))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "\t Titulo:"+getTitulo()+" Status:"+getStatus();
	}

}
