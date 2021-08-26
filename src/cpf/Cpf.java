package cpf;

public class Cpf {
	String cpf_teste;
	String cpf_num = "";
	String cpf_format = "";
	int quant_digi=0;
	
	String siglas[][] = {
			{"RS"},
			{"DF","GO","MT","MS","TO"},
			{"AC", "AP", "AM", "PA", "RO", "RR"},
			{"CE", "MA", "PI"},
			{"AL", "PB", "PE", "RN"},
			{"BA", "SE"},
			{"MG"},
			{"ES", "RJ"},
			{"SP"},
			{"PR", "SC"}			
	};
	
	public Cpf(String new_cpf) {
		cpf_teste = new_cpf;
	}
	
	
	public boolean formatoErrado() {
		for(int c=0;c<cpf_teste.length();c++) {
			if(Character.isDigit(cpf_teste.charAt(c))) {
				quant_digi += 1;
			}
		}
		
		if(quant_digi == 11) {
			return false;
		}
		
		return true;
	}

	public void limpaCpf() {
		for(int c=0;c<cpf_teste.length();c++) {
			if(c == 3 || c == 6) {
				cpf_format += ".";
			}
			if(c == 9) {
				cpf_format += "-";
			}
			if(Character.isDigit(cpf_teste.charAt(c))) {
				cpf_format += Character.toString(cpf_teste.charAt(c));
				cpf_num += Character.toString(cpf_teste.charAt(c));
			}
		}
		System.out.println(cpf_format);
	}
	
	public void identificaEstado() {
		for(int c=0;c<siglas.length;c++) {
			if(c == Integer.parseInt(Character.toString(cpf_num.charAt(8)))) {
				System.out.println("O CPF digitado pode ser de um dos seguintes estados: ");
				for(int j=0;j<siglas[c].length;j++) {
					System.out.print(siglas[c][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	public boolean eValido() {
		int digis[] = new int[2];
		int fator = 10;
		int soma = 0;
		int resto;
		int digi;
		
		for(int c=0;c<9;c++) {
			soma += Integer.parseInt(Character.toString(cpf_num.charAt(c))) * fator;
			fator--;
		}
		
		resto = soma % 11;
		digi = 11 - resto;
		digi = (digi == 0 || digi == 1? 0:digi);
		digis[0] = digi;
		
		
		fator = 10;
		soma = 0;
		
		for(int c=1;c<=9;c++) {
			if(c != cpf_num.length()) {
				soma += Integer.parseInt(Character.toString(cpf_num.charAt(c))) * fator;
				
			} else {
				soma += fator * digis[0]; 
			}
			fator--;
		}
		
		resto = soma % 11;
		digi = 11 - resto;
		digis[1] = digi;
		
		
		if(digis[0] == Integer.parseInt(Character.toString(cpf_num.charAt(9)))) {
			if(digis[1] == Integer.parseInt(Character.toString(cpf_num.charAt(10)))) {
				return true;
			}
		}
		
		return false;
	}
	
}
