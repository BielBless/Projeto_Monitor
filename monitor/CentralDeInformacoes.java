package projeto.monitor;

import java.util.ArrayList;



public class CentralDeInformacoes {
	
	private ArrayList<Aluno> todosOsAlunos = new ArrayList<Aluno>();
	Aluno aluno = new Aluno();
	
	public ArrayList<Aluno> getTodosOsAlunos() {
		return todosOsAlunos;
	}

	public void setTodosOsAlunos(ArrayList<Aluno> todosOsAlunos) {
		this.todosOsAlunos = todosOsAlunos;
	}
	
	public boolean adicionarAluno(Aluno aluno) {
		for(Aluno a:todosOsAlunos) {
			if(aluno.getMatricula().equals(a.getMatricula())) {
				System.out.println("Matrícula já presente no banco de dados.");
				return false;
			}
		}
		todosOsAlunos.add(aluno);
		System.out.println("Aluno cadastrado.");
		return true;
	}
	
	public Aluno recuperarAlunoPorMatricula(String matricula) {
		for(Aluno aluno:todosOsAlunos) {
			if(aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}
	

}