package manuAerea;

import java.util.List;
import java.util.ArrayList;
import bancoDados.MecanicoDao;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;


public class Manutencao
{
	private int codigo;
	private String dataRealizacao;
	private Aeronave aeronave;
	private Mecanico mecanicoResp;
	private int horasPrevistas;
	
	// código
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int c) {
		this.codigo = c;
	}
	
	// dataRealizacao
	public String getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(String data) {
		this.dataRealizacao = data;
	}
	
	// aeronave
	public Aeronave getAeronave() {
		return aeronave;
	}
	public void setAeronave(Aeronave a) {
		this.aeronave = a;
	}
	
	// mecanicoResp
	public Mecanico getMecanicoResp() {
		return mecanicoResp;
	}
	public void setMecanicoResp(Mecanico m) {
		this.mecanicoResp = m;
	}
	
	// horasPrevistas
	public int getHorasPrevistas() {
		return horasPrevistas;
	}
	public void setHorasPrevistas(int hp) {
		this.horasPrevistas = hp;
	}
	
	// inserir uma nova manutenção
	public void registrarManutencao(int num_serie)
	{	
		this.aeronave = Aeronave.validarAeronave(num_serie);
		
		MecanicoDao mecDao = new MecanicoDao(null);
		
		List<Object[]> tabelaMecanicos = mecDao.selecionar(null, null, "cpf");
		
		List<String> cpfMecanicos = new ArrayList<String>();
		
		for(Object[] row : tabelaMecanicos)
		{
			cpfMecanicos.add((String) row[0]);
		}
		
		Random random = new Random();
		
		int index = random.nextInt(0, cpfMecanicos.size());
		
		String mecResponsavel = cpfMecanicos.get(index);
		
		this.dataRealizacao = this.getDataAtual();
		
		this.defHoras(mecResponsavel);
		
		//continuar (show())
	}
	
	public String getDataAtual()
	{
		return LocalDate.now().toString();
	}
	
	public void defHoras(String cpf)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Mecânico: ".concat(cpf));
		System.out.println("Defina a quantidade de horas previstas: " );
		int hp = scanner.nextInt();
		scanner.close();
		
		this.setHorasPrevistas(hp);
	}
	
	
}
