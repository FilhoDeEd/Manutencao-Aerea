package manutencaoAerea;

public class Servico {
	private int codigo;
	private String dataRealizacao;
	private int horasConsumidas;
	private String observacoes;
	
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
		
	// horasPrevistas
	public int getHorasConsumidas() {
		return horasConsumidas;
	}
	public void setHorasConsumidas(int hc) {
			this.horasConsumidas = hc;
	}
	
	// modelo
	public String getObservacoes() {
		return observacoes;
	}
	public void setModelo(String ob) {
			this.observacoes = ob;
	}
}
