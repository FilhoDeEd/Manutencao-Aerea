package bancoDados;
import java.sql.SQLException;
import manutencaoAerea.Manutencao;

public class ManutencaoDao extends GenericDao {
	private Manutencao m;
	public ManutencaoDao(Manutencao m) {
		this.m = m;
	}
	
	public boolean inserir() {
		try {
			String comando = "insert into cliente values (?,?)";
			inserir(comando, m.getCodigo(), m.getDataRealizacao());
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
