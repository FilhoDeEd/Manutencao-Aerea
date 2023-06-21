package bancoDados;

import java.sql.SQLException;
import java.util.List;

import manutencaoAerea.Mecanico;

public class MecanicoDao extends GenericDao
{
private Mecanico m;
	
	public MecanicoDao(Mecanico m)
	{
		this.m = m;
	}
	
	public boolean inserir()
	{
		try
		{
			String comando = "INSERT INTO mecanico VALUES (?,?,?,?)";
			super.inserir(comando, m.getCpf(), m.getNome(), m.getDataNasc(), m.getRegistro());
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Object[]> selecionar(String... camposSelect)
	{
        try
        {
        	String comando = "SELECT ";
        	
        	for(String campo : camposSelect)
        	{
        		comando = comando.concat(campo);
        		comando = comando.concat(", ");
        	}
        	
        	comando = comando.substring(0, comando.length() - 2);
        	comando = comando.concat(" FROM mecanico");

            return super.selecionar(comando);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
