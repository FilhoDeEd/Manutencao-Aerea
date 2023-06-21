package manutencaoAerea;

public class Aeronave {
	private String prefixo;
	private String modelo;
	private String fabricante;
	private String dataFabricacao;
	private int numeroSerie;
	
	
	// prefixo
	public String getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(String p) {
		this.prefixo = p;
	}
	
	// modelo
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String m) {
		this.modelo = m;
	}
	
	// faricante
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String f) {
		this.fabricante = f;
	}
	
	// dataFaricacao
		public String getDataFabricacao() {
			return dataFabricacao;
		}
		public void setDataNasc(String d) {
			this.dataFabricacao = d;
		}
		
	// registro
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public void setRegistro(int n) {
		this.numeroSerie = n;
	}

}
