package manutencaoAerea;

public class Mecanico {
	private String cpf;
	private String nome;
	private String dataNasc;
	private int registro;
	
	//cpf
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String c) {
		this.cpf = c;
	}
	
	// nome
	public String getNome() {
		return nome;
	}
	public void setNome(String n) {
		this.nome = n;
	}
	
	// dataNasc
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String d) {
		this.dataNasc = d;
	}
	
	// registro
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int r) {
		this.registro = r;
	}
}
