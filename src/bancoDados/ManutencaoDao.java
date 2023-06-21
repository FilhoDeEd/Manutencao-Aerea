package bancoDados;

import java.sql.SQLException;
import manutencaoAerea.Manutencao;
import java.util.List;


public class ManutencaoDao extends GenericDao
{
	private Manutencao m;
	
	public ManutencaoDao(Manutencao m)
	{
		this.m = m;
	}
	
	public boolean inserir()
	{
		try
		{
			String comando = "INSERT INTO manutencao VALUES (?,?)";
			super.inserir(comando, m.getCodigo(), m.getDataRealizacao());
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
        	comando = comando.concat(" FROM manutencao");
        	
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
