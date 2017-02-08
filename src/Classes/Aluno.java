package Classes;
public class Aluno extends Colaborador{
	private String matricula;
	private String tipo; //Graducao, mestrado, doutorado;
	private boolean pertenceProjeto;
	
	public Aluno(int id) {
		super(id);
		pertenceProjeto=false;
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
	
	public boolean isPertenceProjeto() {
		return pertenceProjeto;
	}
	public void setPertenceProjeto(boolean pertenceProjeto) {
		this.pertenceProjeto = pertenceProjeto;
	}
}
