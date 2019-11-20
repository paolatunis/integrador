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
import model.Usuario;
import persistencia.AvaliacaoDAO;
import persistencia.DisciplinaDAO;
import persistencia.UsuarioDAO;


@Controller    
@RequestMapping(path="/avaliacao/") 
public class AvaliacaoController {

	private AvaliacaoDAO avDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Avaliacao> cadastrar(@RequestBody Avaliacao avaliacao) {
		avDAO = new AvaliacaoDAO();
		avaliacao = (Avaliacao) avDAO.cadastrar(avaliacao);
		return new ResponseEntity<Avaliacao>(avaliacao, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Avaliacao avaliacao){
		avDAO = new AvaliacaoDAO();
		avDAO.editar(avaliacao);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id){
		avDAO = new AvaliacaoDAO();
		avDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>> listaAvaliacao() {


		avDAO = new AvaliacaoDAO();
		List<Avaliacao> listaAvaliacao = avDAO.buscarTodos(); //criar metodo

		return new ResponseEntity<List<Avaliacao>>(listaAvaliacao, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Avaliacao> buscarPorId(@PathVariable long id){

		avDAO = new AvaliacaoDAO();

		Avaliacao avaliacao = (Avaliacao) avDAO.buscarPorId(id); //criar metodo

		if(avaliacao != null){
			return new ResponseEntity<Avaliacao>(avaliacao, HttpStatus.OK);
		} else{
			return new ResponseEntity<Avaliacao>( HttpStatus.NOT_FOUND);

		}

	}

	@RequestMapping(value = "tipo/{tipo}", method = RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>> buscarPorNome(@PathVariable String tipo){

		avDAO = new AvaliacaoDAO();

		List<Avaliacao> listaAvaliacao = avDAO.buscarPorTipo(tipo);

		if(!listaAvaliacao.isEmpty()){
			return new ResponseEntity<List<Avaliacao>>(listaAvaliacao, HttpStatus.OK);

		}else{
			return new ResponseEntity<List<Avaliacao>>(HttpStatus.NOT_FOUND);

		}
	}



	
	
}