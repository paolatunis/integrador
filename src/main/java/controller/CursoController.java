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

import model.Curso;
import model.Usuario;
import persistencia.CursoDAO;
import persistencia.UsuarioDAO;


@Controller    
@RequestMapping(path="/curso/") 
public class CursoController {


	private CursoDAO cDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Curso> cadastrar(@RequestBody Curso curso) {
		cDAO = new CursoDAO();
		curso = (Curso) cDAO.cadastrar(curso);
		return new ResponseEntity<Curso>(curso, HttpStatus.CREATED);
	}

	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Curso curso){
		cDAO = new CursoDAO();
		cDAO.editar(curso);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		cDAO = new CursoDAO();
		cDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listaCurso() {


		cDAO = new CursoDAO();
		List<Curso> listaCurso = cDAO.buscarTodos();

		return new ResponseEntity<List<Curso>>(listaCurso, HttpStatus.OK);
	}

	
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> buscarPorId(@PathVariable long id){

		cDAO = new CursoDAO();

		Curso curso = (Curso) cDAO.buscarPorId(id); 

		if(curso != null){
			return new ResponseEntity<Curso>(curso, HttpStatus.OK);
		} else{
			return new ResponseEntity<Curso>( HttpStatus.NOT_FOUND);

		}

	}
	
	@RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Curso> buscarPorNome(@PathVariable String nome){

		cDAO = new CursoDAO();

		Curso curso = cDAO.buscarPorNome(nome); 

		if(curso != null){
			return new ResponseEntity<Curso>(HttpStatus.OK);

		}else{
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);

		}


	}




}

