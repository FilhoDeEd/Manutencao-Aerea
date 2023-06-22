package bancoDados;

import java.sql.SQLException;
import java.util.List;

import manuAerea.Manutencao;


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
			String comando = "INSERT INTO manutencao VALUES (?,?,?,?,?)";
			super.inserir(comando, m.getCodigo(), m.getDataRealizacao(), m.getAeronave().getNumeroSerie(), m.getMecanicoResp().getCpf(), m.getHorasPrevistas());
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Object[]> selecionar(String campoFiltro, Object valorFiltro, String... camposSelect)
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
