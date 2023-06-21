package manutencaoAerea;

import bancoDados.ManutencaoDao;

public class Main
{
	public static void main(String[] args)
	{
		Manutencao m = new Manutencao();
		m.setCodigo(100);
		m.setDataRealizacao("xx-xx-xx");
		
		ManutencaoDao md = new ManutencaoDao(m);
		if (md.inserir())
		{
			System.out.printf("Certo");
		}else {
			System.out.printf("Errado");
		}
				
	}
}
