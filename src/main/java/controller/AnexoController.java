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

import model.Anexo;
import persistencia.AnexoDAO;


@Controller    
@RequestMapping(path="/anexo/") 
public class AnexoController {


	private AnexoDAO aDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Anexo> cadastrar(@RequestBody Anexo anexo) {
		aDAO = new AnexoDAO();
		anexo = (Anexo) aDAO.cadastrar(anexo);
		return new ResponseEntity<Anexo>(anexo, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Anexo anexo){
		aDAO = new AnexoDAO();
		aDAO.editar(anexo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		aDAO = new AnexoDAO();
		aDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Anexo>> listaAnexo() {


		aDAO = new AnexoDAO();
		List<Anexo> listaAnexo = aDAO.buscarTodos(); 

		return new ResponseEntity<List<Anexo>>(listaAnexo, HttpStatus.OK);
	}

	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Anexo> buscarPorId(@PathVariable long id){

		aDAO = new AnexoDAO();

		Anexo anexo = (Anexo) aDAO.buscarPorId(id); 

		if(anexo != null){
			return new ResponseEntity<Anexo>(anexo, HttpStatus.OK);
		} else{
			return new ResponseEntity<Anexo>( HttpStatus.NOT_FOUND);

		}

	}

}
