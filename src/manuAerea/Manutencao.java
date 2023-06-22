package manuAerea;

import java.util.Scanner;
import bancoDados.ManutencaoDao;
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
		
		if(this.aeronave == null)
		{
			System.out.println("Aeronave não encontrada.");
			System.out.println("Inserção cancelada.");
			return;
		}
		
		this.mecanicoResp = Mecanico.getRandomMec();
		
		this.dataRealizacao = this.getDataAtual();
		
		this.defHoras(mecanicoResp.getCpf());
		
		this.showRegistrarManutencao();
		
		System.out.println("Confirmar manutenção? (sim/nao): ");
		Scanner scanner = new Scanner(System.in);
		String resposta = scanner.next();
		scanner.close();
		
		resposta = resposta.trim().toLowerCase();
		
		if(resposta.equals("sim"))
		{
			ManutencaoDao manDao = new ManutencaoDao(this);
			
			if(manDao.inserir())
			{
				System.out.println("Manutenção inserida");
			}
		}
		else if(resposta.equals("nao"))
		{
			System.out.println("Inserção cancelada");
			return;
		}
	}
	
	public String getDataAtual()
	{
		return LocalDate.now().toString();
	}
	
	public void defHoras(String cpf)
	{	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mecânico: ".concat(cpf));
		System.out.println("Defina a quantidade de horas previstas: ");
		int hp = scanner.nextInt();
		
		this.setHorasPrevistas(hp);
	}
	
	public void showRegistrarManutencao()
	{
		System.out.println("-------------------------------------");
	    System.out.println("Data de Realização: " + dataRealizacao);
	    
	    System.out.println("-------------------------------------");
	    System.out.println("Aeronave: ");
	    if(aeronave != null)
	    {
	        aeronave.show();
	    }
	    
	    System.out.println("-------------------------------------");
	    System.out.println("Mecânico Responsável: ");
	    if(mecanicoResp != null)
	    {
	        mecanicoResp.show();
	    }
	    
	    System.out.println("Horas Previstas: " + horasPrevistas);
	    System.out.println("-------------------------------------");
	}
	
}
