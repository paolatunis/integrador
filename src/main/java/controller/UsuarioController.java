package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Disciplina;
import model.Usuario;
import persistencia.UsuarioDAO;


@Controller    
@RequestMapping(path="/usuario/") 
public class UsuarioController {

	private UsuarioDAO uDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		uDAO = new UsuarioDAO();
		usuario = (Usuario) uDAO.cadastrar(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Usuario usuario){
		uDAO = new UsuarioDAO();
		uDAO.editar(usuario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		uDAO = new UsuarioDAO();
		uDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listaUsuarios() {

		uDAO = new UsuarioDAO();
		List<Usuario> listaUsuario = uDAO.buscarTodos();

		return new ResponseEntity<List<Usuario>>(listaUsuario, HttpStatus.OK);
	}

	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscarPorId(@PathVariable long id){
		
		uDAO = new UsuarioDAO();

		Usuario usuario = (Usuario) uDAO.buscarPorId(id);

		if(usuario != null){
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else{
			return new ResponseEntity<Usuario>( HttpStatus.NOT_FOUND);

		}

	}


	@RequestMapping(value = "{email}/{senha}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscarPorLoginESenha(@PathVariable String email,@PathVariable String senha){

		uDAO = new UsuarioDAO();

		Usuario usuario = uDAO.buscarPorEmailESenha(email, senha); 

		if(usuario != null){
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

		}else{
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);

		}

	}


	@RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> buscarPorNome(@PathVariable String nome){

		uDAO = new UsuarioDAO();

		List<Usuario> listaUsuario = uDAO.buscarPorNome(nome);
		
		if(!listaUsuario.isEmpty()){
			return new ResponseEntity<List<Usuario>>(listaUsuario, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Usuario>>(HttpStatus.NOT_FOUND);

		}
	}
	
	
}
