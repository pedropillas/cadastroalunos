import javax.swing.JTextField;

public class Aluno {

	private JTextField nome;
	private JTextField idade;
	private JTextField curso;
	
	Aluno(){
	}
	 Aluno(JTextField nome, JTextField idade, JTextField curso) {
		this.nome = nome;
		this.idade = idade;
		this.curso = curso;
		
	}
	 
	public JTextField getNome() {
		return nome;
	}
	public JTextField setNome(JTextField nmAluno) {
		return this.nome = nmAluno;
	}
	public JTextField getIdade() {
		return idade;
	}
	public JTextField setIdade(JTextField idade) {
		return this.idade = idade;
	}
	public JTextField getCurso() {
		return curso;
	}
	public JTextField setCurso(JTextField curso) {
		return this.curso = curso;
	}
	
	
	
}
