package persistencia;
import java.util.List;

public interface DAO <T extends Object> {
	
	T cadastrar(T o);
	void editar (T o);
	void excluir (long o);
	T buscarPorId (long o);
	List <Object> buscarTodos();
	
}