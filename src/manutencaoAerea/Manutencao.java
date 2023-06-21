package manutencaoAerea;

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
	public void setNome(int hp) {
		this.horasPrevistas = hp;
	}
	
	// inserir uma nova manutenção
	public static void inserirManutencao(int num_serie) {
		
	}
}
