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

import model.Disciplina;
import model.Usuario;
import persistencia.DisciplinaDAO;
import persistencia.UsuarioDAO;


@Controller    
@RequestMapping(path="/disciplina/") 
public class DisciplinaController {


	private DisciplinaDAO dDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Disciplina> cadastrar(@RequestBody Disciplina disciplina) {
		dDAO = new DisciplinaDAO();
		disciplina = (Disciplina) dDAO.cadastrar(disciplina);
		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.CREATED);
	}
	
	

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Disciplina disciplina){
		dDAO = new DisciplinaDAO();
		dDAO.editar(disciplina);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		dDAO = new DisciplinaDAO();
		dDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> listaDisciplina() {

		dDAO = new DisciplinaDAO();
		List<Disciplina> listaDisciplina = dDAO.buscarTodos();

		return new ResponseEntity<List<Disciplina>>(listaDisciplina, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Disciplina> buscarPorId(@PathVariable long id){

		dDAO = new DisciplinaDAO();

		Disciplina disciplina = (Disciplina) dDAO.buscarPorId(id); 

		if(disciplina != null){
			return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		} else{
			return new ResponseEntity<Disciplina>( HttpStatus.NOT_FOUND);

		}

	}
	
	
	
	@RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> buscarPorNome(@PathVariable String nome){

		dDAO = new DisciplinaDAO();

		List<Disciplina> listaDisciplina = dDAO.buscarPorNome(nome);
		
		if(!listaDisciplina.isEmpty()){
			return new ResponseEntity<List<Disciplina>>(listaDisciplina, HttpStatus.OK);

		}else{
			return new ResponseEntity<List<Disciplina>>(HttpStatus.NOT_FOUND);

		}


	}

}