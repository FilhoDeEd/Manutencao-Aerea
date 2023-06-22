package bancoDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GenericDao
{
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
	
	public List<Object[]> selecionar(String selectSql, Object valorFiltro) throws SQLException
	{
        List<Object[]> resultados = new ArrayList<>();
        
        try
        {
            PreparedStatement ps = Conecta.getConnection().prepareStatement(selectSql);
            
            if(valorFiltro != null)
            {
            	ps.setObject(1, valorFiltro);
            }
            
            ResultSet rs = ps.executeQuery();
            int columnCount = rs.getMetaData().getColumnCount();

            while(rs.next())
            {
                Object[] row = new Object[columnCount];
                
                for(int i = 0; i < columnCount; i++)
                {
                    row[i] = rs.getObject(i + 1);
                }
                
                resultados.add(row);
            }

            rs.close();
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
        
        return resultados;
    }
}
