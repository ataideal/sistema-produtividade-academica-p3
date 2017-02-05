package Sistema;

public class main {
	
	public static void main(String[] args) {
			
		GerenciadorDeAlunos gerenciadorAlunos = new GerenciadorDeAlunos();
		GerenciadorDeColaboradores gerenciadorColaboradores = new GerenciadorDeColaboradores();
		GerenciadorDeLaboratorio gerenciadorLaboratorios = new GerenciadorDeLaboratorio();
		GerenciadorDeProfessor gerenciadorProfessor = new GerenciadorDeProfessor();
		GerenciadorDeProjetos gerenciadorProjeto = new GerenciadorDeProjetos();
		Menus menu = new Menus();
		
		while(true){
			int m1 = menu.menuPrincipal();
			if (m1==9){
				break;
			}else if(m1==1){
				int m2 = menu.menuGerenciarLaboratorio();
				if(m2==9){
					break;
				}else if(m2==1){
					gerenciadorLaboratorios.listarLaboratorios();
					int m3;
				}
			}else if(m1==2){
				int m2;
			}
			
		}
	}

}
