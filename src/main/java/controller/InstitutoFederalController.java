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

import model.InstitutoFederal;
import model.Usuario;
import persistencia.InstitutoFederalDAO;
import persistencia.UsuarioDAO;


@Controller    
@RequestMapping(path="/instituto_federal/") 
public class InstitutoFederalController {

	private InstitutoFederalDAO ifDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<InstitutoFederal> cadastrar(@RequestBody InstitutoFederal institutoFederal) {
		ifDAO = new InstitutoFederalDAO();
		institutoFederal = (InstitutoFederal) ifDAO.cadastrar(institutoFederal);
		return new ResponseEntity<InstitutoFederal>(institutoFederal, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody InstitutoFederal institutoFederal){
		ifDAO = new InstitutoFederalDAO();
		ifDAO.editar(institutoFederal);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		ifDAO = new InstitutoFederalDAO();
		ifDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<InstitutoFederal>> listaInstitutoFederal() {


		ifDAO = new InstitutoFederalDAO();
		List<InstitutoFederal> listaInstitutoFederal = ifDAO.buscarTodos(); 

		return new ResponseEntity<List<InstitutoFederal>>(listaInstitutoFederal, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<InstitutoFederal> buscarPorId(@PathVariable long id){

		ifDAO = new InstitutoFederalDAO();

		InstitutoFederal institutoFederal = (InstitutoFederal) ifDAO.buscarPorId(id); 

		if(institutoFederal != null){
			return new ResponseEntity<InstitutoFederal>(institutoFederal, HttpStatus.OK);
		} else{
			return new ResponseEntity<InstitutoFederal>( HttpStatus.NOT_FOUND);

		}

	}
	
	
	@RequestMapping(value = "campus/{campus}", method = RequestMethod.GET)
	public ResponseEntity<InstitutoFederal> buscarCampus(@PathVariable String campus){

		ifDAO = new InstitutoFederalDAO();

		InstitutoFederal institutoFederal = ifDAO.buscarPorCampus(campus);

		if(institutoFederal != null){
			return new ResponseEntity<InstitutoFederal>(institutoFederal, HttpStatus.OK);

		}else{
			return new ResponseEntity<InstitutoFederal>(HttpStatus.NOT_FOUND);

		}

	}

}