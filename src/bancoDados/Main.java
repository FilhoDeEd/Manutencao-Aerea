package bancoDados;

public class Main
{
	public static void main(String[] args)
	{
		Cliente c = new Cliente();
		c.setCpf("100");
		c.setNome("x");
		
		ClienteDao cd = new ClienteDao(c);
		if (cd.inserir())
		{
			System.out.printf("Teste");
		}else {
			
		}
				
	}
}
