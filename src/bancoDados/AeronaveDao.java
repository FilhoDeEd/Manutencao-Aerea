package bancoDados;

import java.sql.SQLException;
import java.util.List;

import manutencaoAerea.Aeronave;

public class AeronaveDao extends GenericDao
{
	private Aeronave m;
	
	public AeronaveDao(Aeronave m)
	{
		this.m = m;
	}
	
	public boolean inserir()
	{
		try
		{
			String comando = "INSERT INTO aeronave VALUES (?,?,?,?,?)";
			super.inserir(comando, m.getPrefixo(), m.getModelo(), m.getFabricante(), m.getNumeroSerie(), m.getDataFabricacao());
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Object[]> selecionar(String campoFiltro, String valorFiltro, String... camposSelect)
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
        	comando = comando.concat(" FROM aeronave");
        	
        	if(campoFiltro != null)
        	{
        		comando = comando.concat(" WHERE " + campoFiltro + " = (?)");
        	}
        	
            return super.selecionar(comando, valorFiltro);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
