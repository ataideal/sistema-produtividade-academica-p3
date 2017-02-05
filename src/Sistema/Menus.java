package Sistema;

import java.util.Scanner;

public class Menus {
	
	private Scanner scan;

	public int menuPrincipal(){
		
		System.out.println("\tSistema de Produtividade Academica");
		System.out.println("\t1-Gerenciar laboratorios");
		System.out.println("\t2-Gerenciar Alunos");
		System.out.println("\t3-Gerenciar Professores");
		System.out.println("\t4-Gerenciar Colaboradores");
		System.out.println("\t9-Sair\n");
		
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a<1 && a>4 || a!=9)
			return 0;
		return a;
	}
	
	public int menuGerenciarLaboratorio(){
		
		System.out.println("\tGerenciador de laboratorios");
		System.out.println("\t1-Listar laboratorios");
		System.out.println("\t2-Adicionar laboratorios");
		System.out.println("\t3-Remover Laboratorios");
		System.out.println("\t9-Sair\n");
		
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a<1 && a>3 || a!=9)
			return 0;
		return a;
	}
		
}
