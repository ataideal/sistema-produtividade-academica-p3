package Classes;

public class Colaborador {
	private String nome;
	private String email;
	private int idade;
	private final int id;
	
	public Colaborador(int id){
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void imprimirInfo(){
		System.out.println("\tNome: "+nome);
		System.out.println("\tEmail: "+email);
	}
	
	@Override
	public String toString() {
		return"\t  Nome:"+nome;
	}
}
