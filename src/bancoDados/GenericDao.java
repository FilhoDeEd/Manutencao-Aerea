package bancoDados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenericDao {
	
	public void inserir(String insertsql, Object... parametros) throws SQLException
	{
	    try
	    {
	    	PreparedStatement ps = Conecta.getConnection().prepareStatement(insertsql);
	    	
	    	for(int i = 0; i < parametros.length; i++)
	    	{
	    		ps.setObject(i + 1, parametros[i]);
	    	}
	    	
	    	ps.execute();
	    	ps.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    finally
	    {
	    	Conecta.getConnection().close();
	    }
	}
}
