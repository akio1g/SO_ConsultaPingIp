package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController op = new RedesController();
		Scanner sc = new Scanner(System.in);
		String os = System.getProperty("os.name");
		int opc = 0;
		do {
		System.out.println("Escolha: 1 - IP ||| 2 - PING ||| 3 - SAIR");
		opc = sc.nextInt();
		if(opc == 1) {
			op.ip(os);
		}
		else if(opc == 2) {
			op.ping(os);
		}
		} while(opc != 3);
		sc.close();
	}

}
