package manuAerea;

import java.util.Scanner;
import bancoDados.AeronaveDao;
import bancoDados.MecanicoDao;

public class Main
{
	public static void main(String[] args)
	{
		// Dados para teste:
		boolean isInserted = true;
		
		if(!isInserted)
		{
			//Mecânicos:
			Mecanico mec1 = new Mecanico();
			mec1.setCpf("123.456.789-10");
			mec1.setNome("José");
			mec1.setDataNasc("1970-03-12");
			mec1.setRegistro(1);
			
			Mecanico mec2 = new Mecanico();
			mec2.setCpf("477.486.289-11");
			mec2.setNome("Mateus");
			mec2.setDataNasc("2000-12-31");
			mec2.setRegistro(2);
			
			Mecanico mec3 = new Mecanico();
			mec3.setCpf("400.682.291-41");
			mec3.setNome("Rodrigo");
			mec3.setDataNasc("1988-06-03");
			mec3.setRegistro(3);
			
			MecanicoDao mecDao1 = new MecanicoDao(mec1);
			mecDao1.inserir();
			
			MecanicoDao mecDao2 = new MecanicoDao(mec2);
			mecDao2.inserir();
			
			MecanicoDao mecDao3 = new MecanicoDao(mec3);
			mecDao3.inserir();
			
			//Aeronaves:
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
			
			AeronaveDao aeroDao1 = new AeronaveDao(aero1);
			aeroDao1.inserir();
			
			AeronaveDao aeroDao2 = new AeronaveDao(aero2);
			aeroDao2.inserir();
		}
		
		//Inserindo uma manutenção:
		Manutencao m = new Manutencao();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe o número de série da aeronave: ");
		int num_serie = scanner.nextInt();
		
		m.registrarManutencao(num_serie);
		scanner.close();
	}
}
