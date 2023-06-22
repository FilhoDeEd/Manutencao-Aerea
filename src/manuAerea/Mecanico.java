package manuAerea;

import java.util.List;
import java.util.Random;

import bancoDados.MecanicoDao;

public class Mecanico
{
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
	
	public static Mecanico getRandomMec()
	{
		MecanicoDao mecDao = new MecanicoDao(null);
		
		List<Object[]> tabelaMecanicos = mecDao.selecionar(null, null, "*");
		
		Random random = new Random();
		int index = random.nextInt(0, tabelaMecanicos.size());
		
		Object[] row = tabelaMecanicos.get(index);
		
		Mecanico mec = new Mecanico();
		
		mec.setCpf((String) row[0]);
		mec.setNome((String) row[1]);
		mec.setDataNasc(row[2].toString());
		mec.setRegistro( Math.toIntExact((long) row[3]));
		
		return mec;
	}
	
	public void show()
	{
	    System.out.println("CPF: " + cpf);
	    System.out.println("Nome: " + nome);
	    System.out.println("Data de Nascimento: " + dataNasc);
	    System.out.println("Registro: " + registro);
	}
}
