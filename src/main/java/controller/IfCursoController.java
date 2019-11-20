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

import model.IfCurso;
import persistencia.IfCursoDAO;


@Controller    
@RequestMapping(path="/if_curso/") 
public class IfCursoController {


	private IfCursoDAO ifDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<IfCurso> cadastrar(@RequestBody IfCurso ifCurso) {
		ifDAO = new IfCursoDAO();
		ifCurso = (IfCurso) ifDAO.cadastrar(ifCurso);
		return new ResponseEntity<IfCurso>(ifCurso, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody IfCurso ifCurso){
		ifDAO = new IfCursoDAO();
		ifDAO.editar(ifCurso);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		ifDAO = new IfCursoDAO();
		ifDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<IfCurso>> listaIfCurso() {


		ifDAO = new IfCursoDAO();
		List<IfCurso> listaIfCurso = ifDAO.buscarTodos();

		return new ResponseEntity<List<IfCurso>>(listaIfCurso, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<IfCurso> buscarPorId(@PathVariable long id){

		ifDAO = new IfCursoDAO();

		IfCurso ifCurso = (IfCurso) ifDAO.buscarPorId(id);

		if(ifCurso != null){
			return new ResponseEntity<IfCurso>(ifCurso, HttpStatus.OK);
		} else{
			return new ResponseEntity<IfCurso>( HttpStatus.NOT_FOUND);

		}

	}

}