package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Conecta
{
	private static Connection conexao_unica = null;
	static protected String dsn="manutencao-aerea?useSSL=false", user="root", pwd="";
	private Conecta() {}

	public static Connection getConnection()
	{
		try
		{
			String servidor1 = "localhost:3306";
			if((conexao_unica == null) || (conexao_unica.isClosed()))
			{
				Class.forName("org.gjt.mm.mysql.Driver");
				conexao_unica = DriverManager.getConnection("jdbc:mysql://"+servidor1+"/"+dsn,user,pwd);
			}
			
			return conexao_unica;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}


