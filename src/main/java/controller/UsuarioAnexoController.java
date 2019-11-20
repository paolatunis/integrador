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

import model.UsuarioAnexo;
import persistencia.UsuarioAnexoDAO;


@Controller    
@RequestMapping(path="/usuario_anexo/") 
public class UsuarioAnexoController {


	private UsuarioAnexoDAO uaDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<UsuarioAnexo> cadastrar(@RequestBody UsuarioAnexo usuarioAnexo) {
		uaDAO = new UsuarioAnexoDAO();
		usuarioAnexo = (UsuarioAnexo) uaDAO.cadastrar(usuarioAnexo);
		return new ResponseEntity<UsuarioAnexo>(usuarioAnexo, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody UsuarioAnexo usuarioAnexo){
		uaDAO = new UsuarioAnexoDAO();
		uaDAO.editar(usuarioAnexo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		uaDAO = new UsuarioAnexoDAO();
		uaDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioAnexo>> listaUsuarioAnexos() {


		uaDAO = new UsuarioAnexoDAO();
		List<UsuarioAnexo> listaUsuarioAnexo = uaDAO.buscarTodos(); 

		return new ResponseEntity<List<UsuarioAnexo>>(listaUsuarioAnexo, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioAnexo> buscarPorId(@PathVariable long id){

		uaDAO = new UsuarioAnexoDAO();

		UsuarioAnexo usuarioAnexo = (UsuarioAnexo) uaDAO.buscarPorId(id);

		if(usuarioAnexo != null){
			return new ResponseEntity<UsuarioAnexo>(usuarioAnexo, HttpStatus.OK);
		} else{
			return new ResponseEntity<UsuarioAnexo>( HttpStatus.NOT_FOUND);

		}

	}

}