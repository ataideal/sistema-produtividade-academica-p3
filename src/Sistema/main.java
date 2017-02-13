package Sistema;

import java.util.Collections;
import java.util.Comparator;

import Classes.Projeto;

public class main {

	public static void main(String[] args) {

		Menus menu = new Menus();

		while(true){
			int m1 = menu.menuPrincipal();
			if (m1==9){
				break;
			}else if(m1==1){
				while(true){
					int m2 = menu.menuGerenciarLaboratorio();
					if(m2==9){
						break;
					}else if(m2==1){
						menu.menuEscolherLaboratorio();
					}
					else if(m2==2){
						menu.gerenciadorLaboratorios.adicionarLaboratorio();
					}
					else if(m2==3){
						menu.gerenciadorLaboratorios.removerLaboratorio();
					}
				}
			}else if(m1==2){
				while(true){
					int m2 = menu.menuGerenciarAlunos();
					if(m2==9){
						break;
					}else if(m2==1){
						menu.menuEscolherAluno();
					}
					else if(m2==2){
						menu.gerenciadorAlunos.adicionarAluno();
					}
					else if(m2==3){
						menu.gerenciadorAlunos.removerAluno();
					}
				}
			}else if(m1==3){
				while(true){
					int m2 = menu.menuGerenciarProfessores();
					if(m2==9){
						break;
					}else if(m2==1){
						menu.menuEscolherProfessor();
					}
					else if(m2==2){
						menu.gerenciadorProfessor.adicionarProfessor();
					}
					else if(m2==3){
						menu.gerenciadorProfessor.removerProfessor();
					}
				}
			}else if(m1==4){
				while(true){
					int m2 = menu.menuGerenciarProjetos();
					if(m2==9){
						break;
					}else if(m2==1){
						menu.menuEscolherProjeto();
					}
					else if(m2==2){
						menu.gerenciadorProjeto.adicionarProjeto(menu.gerenciadorLaboratorios.laboratorios,menu.gerenciadorProfessor.professores);
						try {
							Collections.sort(menu.gerenciadorProjeto.projetos, new Comparator<Projeto>() {
								  public int compare(Projeto o1, Projeto o2) {
								      return o1.getTermino().compareTo(o2.getTermino());
								  }
								});
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					else if(m2==3){
						menu.gerenciadorProjeto.removerProjeto();
					}
				}
			}else if(m1==5){
				while(true){
					int m2 = menu.menuGerenciarPesquisadores();
					if(m2==9){
						break;
					}else if(m2==1){
						menu.menuEscolherPesquisador();
					}
					else if(m2==2){
						menu.gerenciadorPesquisadores.adicionarPesquisador();
					}
					else if(m2==3){
						menu.gerenciadorPesquisadores.removerPesquisador();
					}
				}
			}

		}
	}

}
