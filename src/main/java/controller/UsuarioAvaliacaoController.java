package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Avaliacao;
import model.Disciplina;
import model.UsuarioAvaliacao;
import persistencia.AvaliacaoDAO;
import persistencia.DisciplinaDAO;
import persistencia.UsuarioAvaliacaoDAO;


@Controller    
@RequestMapping(path="/usuario_avaliacao/") 
public class UsuarioAvaliacaoController {


	private UsuarioAvaliacaoDAO uaDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<UsuarioAvaliacao> cadastrar(@RequestBody UsuarioAvaliacao usuarioAvaliacao) {
		uaDAO = new UsuarioAvaliacaoDAO();
		usuarioAvaliacao = (UsuarioAvaliacao) uaDAO.cadastrar(usuarioAvaliacao);
		return new ResponseEntity<UsuarioAvaliacao>(usuarioAvaliacao, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody UsuarioAvaliacao usuarioAvaliacao){
		uaDAO = new UsuarioAvaliacaoDAO();
		uaDAO.editar(usuarioAvaliacao);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		uaDAO = new UsuarioAvaliacaoDAO();
		uaDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioAvaliacao>> listaUsuarioAvaliacao() {

		uaDAO = new UsuarioAvaliacaoDAO();
		List<UsuarioAvaliacao> listaUsuarioAvaliacao = uaDAO.buscarTodos(); //criar metodo
		return new ResponseEntity<List<UsuarioAvaliacao>>(listaUsuarioAvaliacao, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioAvaliacao> buscarPorId(@PathVariable long id){

		uaDAO = new UsuarioAvaliacaoDAO();

		UsuarioAvaliacao usuarioAvaliacao = (UsuarioAvaliacao) uaDAO.buscarPorId(id); 

		if(usuarioAvaliacao != null){
			return new ResponseEntity<UsuarioAvaliacao>(usuarioAvaliacao, HttpStatus.OK);
		} else{
			return new ResponseEntity<UsuarioAvaliacao>( HttpStatus.NOT_FOUND);

		}

	}
	
	@RequestMapping(value = "id_usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>> buscarPorUsuario (@PathVariable long id){

		uaDAO = new UsuarioAvaliacaoDAO();

		List<Avaliacao> listaAvaliacao = uaDAO.buscarPorUsuario(id);
		
		if(!listaAvaliacao.isEmpty()){
			return new ResponseEntity<List<Avaliacao>>(listaAvaliacao, HttpStatus.OK);

		}else{
			return new ResponseEntity<List<Avaliacao>>(HttpStatus.NOT_FOUND);

		}

	}
	
	@RequestMapping(value = "id_data/{id}/{data}", method = RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>> buscarPorIdData (@PathVariable long id,@PathVariable String data){

		uaDAO = new UsuarioAvaliacaoDAO();


		List<Avaliacao> listaAvaliacao = uaDAO.buscarPorIdData(id, data);
		
		if(!listaAvaliacao.isEmpty()){
			return new ResponseEntity<List<Avaliacao>>(listaAvaliacao, HttpStatus.OK);

		}else{
			return new ResponseEntity<List<Avaliacao>>(HttpStatus.NOT_FOUND);

		}

	}

}