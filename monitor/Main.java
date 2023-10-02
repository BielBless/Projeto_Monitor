package projeto.monitor;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("1 - Novo aluno\n2 - Listar todos os alunos\n3 - Exibir informações de um aluno espicífico\nS - sair.");
			String opcao = sc.nextLine().toLowerCase();
			
			if(opcao.equals("1")) {
				
				for(int i = 0; i < central.getTodosOsAlunos().size();i++) {
					int erro = 0;
					System.out.print("Nome do aluno: ");
					String nome = sc.nextLine();
					System.out.print("Sexo do aluno: ");
					Sexo sexo = Sexo.valueOf(sc.nextLine().toUpperCase());
					System.out.print("Matrícula do aluno: ");
					String matricula = sc.nextLine();
					System.out.print("E-mail do aluno: ");
					String email = sc.nextLine();
					System.out.print("Senha do aluno: ");
					String senha = sc.nextLine();
					Aluno aluno = new Aluno(nome, sexo, matricula, email, senha);
					for(Aluno a:central.getTodosOsAlunos()) {
						if(a.equals(aluno)) {
							System.out.println("Aluno já consta no sistema. Cadastre outro.");
							erro++;
							i--;
						}
					}
					if(erro == 0) {
						central.adicionarAluno(aluno);
						persistencia.salvarCentral(central);
						break;
					}
				}
			}
			
			if(opcao.equals("2")) {
				for(Aluno a:central.getTodosOsAlunos()) {
					System.out.println(a);
				}
			}
			
			if(opcao.equals("3")) {
				System.out.print("Digite a matrícula do aluno desejado: ");
				String buscarAluno = sc.nextLine();
				System.out.println(central.recuperarAlunoPorMatricula(buscarAluno)); 
				
			}
			
			if(opcao.equals("s")) {
				System.out.println("Saindo do programa...");
				flag = false;
			}
		}
	}
	
  }
