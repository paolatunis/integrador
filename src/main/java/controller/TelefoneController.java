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

import model.Telefone;
import persistencia.TelefoneDAO;


@Controller    
@RequestMapping(path="/telefone/") 
public class TelefoneController {


	private TelefoneDAO tDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Telefone> cadastrar(@RequestBody Telefone telefone) {
		tDAO = new TelefoneDAO();
		telefone = (Telefone) tDAO.cadastrar(telefone);
		return new ResponseEntity<Telefone>(telefone, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Telefone telefone){
		tDAO = new TelefoneDAO();
		tDAO.editar(telefone);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		tDAO = new TelefoneDAO();
		tDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Telefone>> listaTelefone() {


		tDAO = new TelefoneDAO();
		List<Telefone> listaTelefone = tDAO.buscarTodos(); 

		return new ResponseEntity<List<Telefone>>(listaTelefone, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Telefone> buscarPorId(@PathVariable long id){

		tDAO = new TelefoneDAO();

		Telefone telefone = (Telefone) tDAO.buscarPorId(id);

		if(telefone != null){
			return new ResponseEntity<Telefone>(telefone, HttpStatus.OK);
		} else{
			return new ResponseEntity<Telefone>( HttpStatus.NOT_FOUND);

		}

	}
}