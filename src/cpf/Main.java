package cpf;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String cpf;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite um CPF no formato XXX.XXX.XXX-XX: ");
		cpf = input.nextLine();
		
		input.close();
		
		//cpf = "83837884791";
		
		Cpf cpf_instancia = new Cpf(cpf);
		
		if(cpf_instancia.formatoErrado()) {
			System.out.println("Formato incorreto.");
		} else {
			System.out.print("CPF digitado: ");
			cpf_instancia.limpaCpf();
			cpf_instancia.identificaEstado();
			if(cpf_instancia.eValido()) {
				System.out.println("E � um cpf v�lido.");
			} else {
				System.out.println("Por�m, n�o um CPF v�lido.");
			}
		}
	}
}
