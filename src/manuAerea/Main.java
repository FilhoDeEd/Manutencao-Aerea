package manuAerea;

import java.util.Scanner;
import bancoDados.AeronaveDao;

public class Main
{
	public static void main(String[] args)
	{
		// Aeronaves para teste:
		Aeronave aero1 = new Aeronave();
		aero1.setPrefixo("FAB");
		aero1.setRegistro(1234);
		aero1.setModelo("Modelo X");
		aero1.setFabricante("Embraer");
		aero1.setDataFabricacao("2010-01-05");
		
		Aeronave aero2 = new Aeronave();
		aero2.setPrefixo("FAB");
		aero2.setRegistro(5678);
		aero2.setModelo("Modelo Y");
		aero2.setFabricante("Neiva");
		aero2.setDataFabricacao("2015-12-09");
		
		AeronaveDao aeroDao = new AeronaveDao(aero1);
		aeroDao.inserir();
		aeroDao = new AeronaveDao(aero2);
		aeroDao.inserir();
		
		//Inserindo uma manutenção:
		Manutencao m = new Manutencao();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe o número de série da aeronave: ");
		int num_serie = scanner.nextInt();
		scanner.close();
		
		//m.registrarManutencao(num_serie);
	}
}
