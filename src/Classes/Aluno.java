package Classes;
public class Aluno extends Colaborador{
	private String matricula;
	private String tipo; //Graducao, mestrado, doutorado;
	private boolean temProjeto;
	
	public Aluno(int id) {
		super(id);
		temProjeto = false;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public void imprimirInfo() {
		super.imprimirInfo();
		System.out.println("\tMatricula:"+matricula);
		System.out.println("\tTipo:"+tipo);
	}

	public boolean isTemProjeto() {
		return temProjeto;
	}

	public void setTemProjeto(boolean temProjeto) {
		this.temProjeto = temProjeto;
	}
	
	
}
