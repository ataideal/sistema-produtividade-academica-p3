package Sistema;

public class main {
	
	public static void main(String[] args) {

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
					menu.menuEscolherLaboratorio();
					
				}
			}else if(m1==2){
				int m2;
			}
			
		}
	}

}
