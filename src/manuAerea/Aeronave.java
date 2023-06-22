package manuAerea;

import java.util.List;

import bancoDados.AeronaveDao;

public class Aeronave
{
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
		public void setDataFabricacao(String d) {
			this.dataFabricacao = d;
		}
		
	// registro
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public void setRegistro(int n) {
		this.numeroSerie = n;
	}
	
	public static Aeronave validarAeronave(int num_serie)
	{
		AeronaveDao aeroDao = new AeronaveDao(null);
		
		List<Object[]> dadosAeronave = aeroDao.selecionar("numeroSerie", num_serie, "*");
		
		if(dadosAeronave.isEmpty()) return null;
		
		Object[] row = dadosAeronave.get(0);
		
		Aeronave aero = new Aeronave();
		aero.setPrefixo((String) row[0]);
		aero.setModelo((String) row[1]);
		aero.setFabricante((String) row[2]);
		aero.setRegistro(num_serie);
		aero.setDataFabricacao(row[4].toString());
		
		return aero;
	}
	
	public void show()
	{
	    System.out.println("Prefixo: " + prefixo);
	    System.out.println("Modelo: " + modelo);
	    System.out.println("Fabricante: " + fabricante);
	    System.out.println("Data de Fabricação: " + dataFabricacao);
	    System.out.println("Número de Série: " + numeroSerie);
	}
}
