package Classes;
public class Aluno extends Colaborador{
	private String matricula;
	private String tipo; //Graducao, mestrado, doutorado;
	
	public Aluno(int id) {
		super(id);
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
	
	
}
