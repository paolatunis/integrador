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
import model.DisciplinaUsuario;
import persistencia.DisciplinaUsuarioDAO;
import persistencia.UsuarioAvaliacaoDAO;


@Controller    
@RequestMapping(path="/disciplina_usuario/") 
public class DisciplinaUsuarioController {


	private DisciplinaUsuarioDAO dsDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<DisciplinaUsuario> cadastrar(@RequestBody DisciplinaUsuario disciplinaUsuario) {
		dsDAO = new DisciplinaUsuarioDAO();
		disciplinaUsuario = (DisciplinaUsuario) dsDAO.cadastrar(disciplinaUsuario);
		return new ResponseEntity<DisciplinaUsuario>(disciplinaUsuario, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody DisciplinaUsuario disciplinaUsuario){
		dsDAO = new DisciplinaUsuarioDAO();
		dsDAO.editar(disciplinaUsuario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		dsDAO = new DisciplinaUsuarioDAO();
		dsDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<DisciplinaUsuario>> listaDisciplinaUsuario() {


		dsDAO = new DisciplinaUsuarioDAO();
		List<DisciplinaUsuario> listaDisciplinaUsuario = dsDAO.buscarTodos(); 

		return new ResponseEntity<List<DisciplinaUsuario>>(listaDisciplinaUsuario, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<DisciplinaUsuario> buscarPorId(@PathVariable long id){

		dsDAO = new DisciplinaUsuarioDAO();

		DisciplinaUsuario disciplinaUsuario = (DisciplinaUsuario) dsDAO.buscarPorId(id);

		if(disciplinaUsuario != null){
			return new ResponseEntity<DisciplinaUsuario>(disciplinaUsuario, HttpStatus.OK);
		} else{
			return new ResponseEntity<DisciplinaUsuario>( HttpStatus.NOT_FOUND);

		}

	}
	
	@RequestMapping(value = "id_usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> buscarPorUsuario (@PathVariable long id){

		dsDAO = new DisciplinaUsuarioDAO();

		List<Disciplina> listaAvaliacao = dsDAO.buscarPorUsuario(id);
		
		if(!listaAvaliacao.isEmpty()){
			return new ResponseEntity<List<Disciplina>>(listaAvaliacao, HttpStatus.OK);

		}else{
			return new ResponseEntity<List<Disciplina>>(HttpStatus.NOT_FOUND);

		}

	}
	
	
	

}