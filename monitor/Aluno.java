package projeto.monitor;

public class Aluno {
	
	private String nome;
	private Sexo sexo;
	private String matricula;
	private String email;
	private String senha;
	
	
	public Aluno(String nome, Sexo sexo, String matricula, String email, String senha) {
		this.nome = nome;
		this.sexo = sexo;
		this.matricula = matricula;
		this.email = email;
		this.senha = senha;
	}
	
	public Aluno() {
		
	}
	
	public boolean equals(Aluno aluno) {
		if(matricula.equals(aluno.getMatricula())) {
			return true;
		}
	 	return false;
	}
	
	public String toString() {
		return "Aluno: " + getNome() + ". Matricula: " + getMatricula();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	
	
	
}
