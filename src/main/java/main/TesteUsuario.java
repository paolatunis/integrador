package main;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import model.Anexo;
import model.Avaliacao;
import model.Curso;
import model.Disciplina;
import model.DisciplinaUsuario;
import model.IfCurso;
import model.InstitutoFederal;
import model.Telefone;
import model.Usuario;
import model.UsuarioAnexo;
import model.UsuarioAvaliacao;
import persistencia.AnexoDAO;
import persistencia.AvaliacaoDAO;
import persistencia.CursoDAO;
import persistencia.DisciplinaDAO;
import persistencia.DisciplinaUsuarioDAO;
import persistencia.IfCursoDAO;
import persistencia.InstitutoFederalDAO;
import persistencia.TelefoneDAO;
import persistencia.UsuarioAnexoDAO;
import persistencia.UsuarioAvaliacaoDAO;
import persistencia.UsuarioDAO;


public class TesteUsuario {
	public static void main(String args[]) {


		//////////////////////////////////////////////  USUARIO  ///////////////////////////////////////////////////
		//	PARA CADASTRAR UM Usuario:
		//				//cria um usuario DAO pra chamar o metodo
		//				UsuarioDAO uDAO = new UsuarioDAO(); 
		//				//cria um usuario normal e instancia com valores que tu quer testar/cadastrar no banco
		//				Object usuario = new Usuario(0, "nome", "senha", "info", "foto", "email@gmail.com", null, null, null);
		//				usuario = uDAO.cadastrar(usuario); //faz o metodo

		//		Usuario usuario=new Usuario();
		//		UsuarioDAO uDAO = new UsuarioDAO();
		//		usuario=uDAO.buscarPorEmailESenha("paola@gmail.com", "minhasenha");

		// id - nome - senha - info - fto - email - listaUsuarioAnexo - listaUsuarioAvaiacao
//		UsuarioDAO uDAO2 = new UsuarioDAO(); 
//		Object usuario2 = new Usuario(3, "Júlia Luz", "senhadajulia", "Ela tbm cursa informática", "fotojulia", "luz@gmail.com", null, null, null);
//		usuario2 = uDAO2.cadastrar(usuario2);

		//------------------------------------------------
		//		PARA EDITAR UM Usuario:

		//		cria um usuario DAO pra chamar o metodo
		//UsuarioDAO uDAO1 = new UsuarioDAO(); 

		//		cria um usuario normal e instancia com valores que tu quer testar/cadastrar no banco
		// id - nome - senha - info - fto - email - listaUsuarioAnexo - listaUsuarioAvaiacao

		//uDAO1.editar(usuario1); //chama o metodo

		//				UsuarioDAO uDAO4 = new UsuarioDAO(); 
		//				Object usuario4 = new Usuario(7, "Allan", "senha allan", "Artista cult", "foto all", "ALLAN@gmail.com", null, null, null);
		//				usuario4 = uDAO4.cadastrar(usuario4);
		//		uDAO4.editar(usuario4);



		//		PARA EXCLUIR UM Usuario:

		//		cria um DAO pra chamar o metodo
		//	UsuarioDAO uDAO2 = new UsuarioDAO();
		//	uDAO2.excluir(1); //chama o metodo com o id de parametro p excluir ele

		//		UsuarioDAO uDAO5 = new UsuarioDAO(); 
		//		Object usuario5 = new Usuario(7, "Getúlio", "senhagg", "ens fundamental", "foto g", "pvp@gmail.com", null, null, null);
		//		//usuario5 = uDAO5.cadastrar(usuario5);
		//		uDAO5.exlcuir(8);

		//		PRA BUSCAR VC FAZ O MESMO Q PRA EXCLUIR

		//		UsuarioDAO uDAO5 = new UsuarioDAO(); 
		//		Object usuario5 = new Usuario(7, "Getúlio", "senhagg", "ens fundamental", "foto g", "pvp@gmail.com", null, null, null);
		//		//usuario5 = uDAO5.cadastrar(usuario5);
		//		System.out.println(uDAO5.buscarPorId(10));


		//		UsuarioDAO uDAO5 = new UsuarioDAO(); 
		//		uDAO5.buscarPorNome("Allan");



		//		List<Usuario> listaUsuarios = uDAO5.buscarTodos();
		//
		//		for(Usuario u: listaUsuarios) {
		//			System.out.println(u.getNomeUsuario());
		//		}


		//System.out.println(uDAO5.buscarTodos());

		//////////////////////////////////////////////////////// CURSO  //////////////////////////////////////////////////////////////////////////////

		///Cadastrar Curso --------------------------------------------------
		// CADASTRAR id - nome - turmas -infoCurso

		//		CursoDAO cDAO2 = new CursoDAO(); 
		//		Object curso2 = new Curso(0, "Plásticos", "1P, 2P, 3P, 4P", "Coordenador Random", null, null, null);
		//		curso2 = cDAO2.cadastrar(curso2);


		//		///EDITAR CURSO ------
		//		
		//				CursoDAO cDAO4 = new CursoDAO(); 
		//				Object curso4 = new Curso(5, "Plásticos", "P, T", "Coordenadora: Ana Polgatti", null, null, null);
		//				//curso4 = cDAO4.cadastrar(curso4);
		//				cDAO4.editar(curso4);
		//
		//       //EXCLUIR CURSO
		//		CursoDAO cDAO4 = new CursoDAO(); 
		//		Object curso4 = new Curso(5, "Administração", "F, H", "Coordenador: Fábio Lemes", null, null, null);
		//		//curso4 = cDAO4.cadastrar(curso4);
		//		cDAO4.exlcuir(6); //chama o metodo com o id de parametro p excluir ele

		//BUSCAR POR ID  OOOokkkkkkkkkkk
		//						CursoDAO cDAO5 = new CursoDAO(); 
		//						cDAO5.buscarPorId(1);

		///BUSCARR TODOS
		//		CursoDAO cDAO5 = new CursoDAO();
		//		List<Curso> listaCursos = cDAO5.buscarTodos();
		//		for(Curso c: listaCursos) {
		//			System.out.println(c.getNomeCurso());
		//		}

		/// Buscar curso por nome
		//		CursoDAO cDAO5 = new CursoDAO(); 
		//		cDAO5.buscarPorNome("Informática");

		//////////////////////////////////////  AVALIAÇÃO   ///////////////////////////////////////////////
		//id - tipo_avaliacao - nota_avaliacao - peso_avaliacao - data_ avaliacao - material - conteudo / disciplina / listaUsuarioAvaliacao

		//cadastrar 
//				Disciplina disciplina = new Disciplina();
//				disciplina.setIdDisciplina(5);
//		
//				Avaliacao avaliacao = new Avaliacao();
//				avaliacao.setTipoAvaliacao("Trabalho");
//				avaliacao.setNotaAvaliacao((float) 10.90);
//				avaliacao.setPesoAvaliacao((float) 5);
//				avaliacao.setDataAvaliacao("28-11-2018");
//				avaliacao.setMaterial("Calculadora");
//				avaliacao.setConteudo("Coisas estranhas");
//				AvaliacaoDAO aDAO = new AvaliacaoDAO();
//		
//				avaliacao.setDisciplina(disciplina);
//				aDAO.cadastrar(avaliacao);

		//editar
//				Disciplina disciplina = new Disciplina();
//				disciplina.setIdDisciplina(4);
//		
//				Avaliacao avaliacao = new Avaliacao();
//				avaliacao.setTipoAvaliacao("Prova");
//				avaliacao.setNotaAvaliacao((float) 0);
//				avaliacao.setPesoAvaliacao((float) 10);
//				avaliacao.setDataAvaliacao("29-11-2018");
//				avaliacao.setMaterial("Sem material");
//				avaliacao.setConteudo("Leis de Newton");
//				avaliacao.setIdAvaliacao(6);
//		
//				AvaliacaoDAO aDAO = new AvaliacaoDAO();
//				avaliacao.setDisciplina(disciplina);
//				aDAO.editar(avaliacao);

		//excluir
		//		AvaliacaoDAO aDAO4 = new AvaliacaoDAO(); 
		//		aDAO4.excluir(2);

		//buscar por id
		//		AvaliacaoDAO dDAO5 = new AvaliacaoDAO(); 
		//		dDAO5.buscarPorId(1);

		//		AvaliacaoDAO aDAO5 = new AvaliacaoDAO();
		//		List<Avaliacao> listaAvaliacoes = aDAO5.buscarTodos();
		//		for(Avaliacao a: listaAvaliacoes) {
		//			System.out.println(a.getConteudo());
		//		}

//		AvaliacaoDAO aDAO5 = new AvaliacaoDAO();
//		List<Avaliacao> listaAvaliacoes = aDAO5.buscarPorTipo("Trabalho");
//		for(Avaliacao a: listaAvaliacoes) {
//			System.out.println(a.getConteudo());
//		}
//		
//		AvaliacaoDAO aDAO5 = new AvaliacaoDAO();
//		List<Avaliacao> listaAvaliacoes = aDAO5.buscarPorData("2018-10-10");
//		for(Avaliacao a: listaAvaliacoes) {
//			System.out.println(a.getTipoAvaliacao());
//		}


		//////////////////////////////////////////////////////  IF   /////////////////////////////////////////////////////////
		//		InstitutoFederalDAO iDAO = new InstitutoFederalDAO(); 
		//		Object instituto = new InstitutoFederal(0, "Sapucaia do Sul", null, null);
		//		instituto = iDAO.cadastrar(instituto); //faz o metodo

		//		InstitutoFederalDAO iDAO = new InstitutoFederalDAO(); 
		//		Object instituto = new InstitutoFederal(1, "Sapucaia do Sul", null, null);
		//		iDAO.editar(instituto); //faz o metodo

		//		InstitutoFederalDAO iDAO = new InstitutoFederalDAO();  
		//		Object instituto = new InstitutoFederal(0, "Charqueadas", null, null);
		//		instituto = iDAO.cadastrar(instituto);
		//		iDAO.exlcuir(2); //chama o metodo com o id de parametro p excluir ele

		//		InstitutoFederalDAO iDAO = new InstitutoFederalDAO(); 
		//		System.out.println(iDAO.buscarPorId(1));
		//		
		//		InstitutoFederalDAO iDAO = new InstitutoFederalDAO();  
		//		List<InstitutoFederal> listaInstitutoFederal = iDAO.buscarTodos();
		//		for (InstitutoFederal i: listaInstitutoFederal) {
		//			System.out.println(i.getCampus());
		//		}

		//		InstitutoFederalDAO  iDAO5 = new InstitutoFederalDAO(); 
		//		iDAO5.buscarPorCampus("Charqueadas");

		///////////////////////////////////////////  DISCIPLINA   /////////////////////////////////////////////////////////
		//		Curso curso = new Curso();
		//		curso.setIdCurso(1);
		//		
		//		Disciplina disciplina = new Disciplina();
		//		disciplina.setNomeDisciplina("COMO SER T.I.");
		//		disciplina.setTurmaDisciplina("KK");
		//		disciplina.setAno(2002);
		//		disciplina.setMediaNota(20.8);
		//		disciplina.setProfessor("Indiano");
		//		disciplina.setNotaExtra(0);
		//		
		//		DisciplinaDAO dDAO = new DisciplinaDAO();
		//		
		//		disciplina.setCurso(curso);
		//		dDAO.cadastrar(disciplina);		

		///editar
		//		Curso curso = new Curso();
		//		curso.setIdCurso(1);
		//		
		//		Disciplina disciplina = new Disciplina();
		//		disciplina.setNomeDisciplina("TESTEEEE EDITANDO");
		//		disciplina.setTurmaDisciplina("BB");
		//		disciplina.setAno(1800);
		//		disciplina.setMediaNota(20);
		//		disciplina.setProfessor("Random");
		//		disciplina.setNotaExtra(0);
		//		disciplina.setIdDisciplina(165);
		//		
		//		DisciplinaDAO dDAO = new DisciplinaDAO();
		//		disciplina.setCurso(curso);
		//		dDAO.editar(disciplina);
		//
		//excluir

		//		DisciplinaDAO dDAO4 = new DisciplinaDAO(); 
		//		dDAO4.excluir(165); //chama o metodo com o id de parametro p excluir ele




		//		DisciplinaDAO dDAO4 = new DisciplinaDAO(); 
		//		Object disciplina4 = new Disciplina(83,"TESTE EDITAR", "AI", 2020, 0, "Remorozco", 10, null, null, null, null);
		//		//curso4 = cDAO4.cadastrar(curso4);
		//		dDAO4.editar(disciplina4);

		//		DisciplinaDAO dDAO2 = new DisciplinaDAO();
		//		dDAO2.excluir(84); 

		//		DisciplinaDAO dDAO5 = new DisciplinaDAO(); 
		//		dDAO5.buscarPorId(83);

		//				DisciplinaDAO dDAO5 = new DisciplinaDAO();
		//				List<Disciplina> listaDisciplinas = dDAO5.buscarTodos();
		//				for(Disciplina d: listaDisciplinas) {
		//					System.out.println(d.getProfessor());
		//				}

		//		DisciplinaDAO dDAO5 = new DisciplinaDAO(); 
		//		dDAO5.buscarPorNome("TESTE EDITAR");

		//		DisciplinaDAO dDAO5 = new DisciplinaDAO();
		//		List<Disciplina> listaDisciplinas = dDAO5.buscarPorNome("Historia I");
		//		for(Disciplina d: listaDisciplinas) {
		//			System.out.println(d.getTurmaDisciplina());
		//		}


		///////////////////////////////////////////////////// TELEFONE /////////////////////////////////////////////////////////////////////////

		//		TelefoneDAO telefoneDAO = new TelefoneDAO(); 
		//		Object telefone = new Telefone(1, "Cordenação", "(51) 1212-1212", null);
		//		telefone = telefoneDAO.cadastrar(telefone); //faz o metodos
		//GRRRRRRRRRRRRRRRRRRRRRR
		//		telefoneDAO.editar(telefone);
		//telefoneDAO.excluir(2);
		//------------------------------------------------------------------//
		//		InstitutoFederal institutoFederal = new InstitutoFederal();
		//		institutoFederal.setIdIf(1);
		//		
		//		Telefone telefone = new Telefone();
		//		telefone.setDescricaoDep("Cordenação");
		//		telefone.setNumero("000000");
		//		
		//		TelefoneDAO tDAO = new TelefoneDAO();
		//		
		//		telefone.setInstitutoFederal(institutoFederal);
		//		tDAO.cadastrar(telefone);

		//editar
		//		InstitutoFederal institutoFederal = new InstitutoFederal();
		//		institutoFederal.setIdIf(1);
		//		Telefone telefone = new Telefone();
		//		telefone.setDescricaoDep("TESTE EDITAR");
		//		telefone.setNumero("000000");
		//		telefone.setIdTelefone(3);
		//

		//		TelefoneDAO tDAO = new TelefoneDAO();
		//
		//		telefone.setInstitutoFederal(institutoFederal);
		//		tDAO.editar(telefone);


		//		TelefoneDAO tDAO5 = new TelefoneDAO();
		//		List<Telefone> listaTelefones = tDAO5.buscarTodos();
		//		for(Telefone t: listaTelefones) {
		//			System.out.println(t.getDescricaoDep());
		//		}

		//		TelefoneDAO tDAO5 = new TelefoneDAO(); 
		//		tDAO5.buscarPorId(1);


		/////////////////////////////////////////////////////  ANEXO  /////////////////////////////////////////////////////////////////////////

		// id - status - link - titulo - tipoAnexo - id disciplina
		//	/*			Disciplina disciplina = new Disciplina();
		//				disciplina.setIdDisciplina(105);
		//				Anexo anexo = new Anexo();
		//				anexo.setStatusAnexo(true);
		//				anexo.setLink("pipipopopo");
		//				anexo.setTitulo("Estequiometria");
		//				anexo.setTipoAnexo("Resumo & Perguntas");
		//				AnexoDAO aDAO = new AnexoDAO();
		//				anexo.setDisciplina(disciplina);
		//				aDAO.cadastrar(anexo);*/

		///editar
		//		Disciplina disciplina = new Disciplina();
		//		disciplina.setIdDisciplina(83);
		//
		//		Anexo anexo = new Anexo();
		//		anexo.setStatusAnexo(true);
		//		anexo.setLink("METODO");
		//		anexo.setTitulo("EDITAR");
		//		anexo.setTipoAnexo("FUNFA");
		//		anexo.setIdAnexo(2);
		//		AnexoDAO aDAO = new AnexoDAO();
		//		anexo.setDisciplia(disciplina);
		//		aDAO.editar(anexo);

		//excluir
		//		AnexoDAO aDAO4 = new AnexoDAO(); 
		//		aDAO4.excluir(2);

		//buscar por id

		//		AnexoDAO aDAO5 = new AnexoDAO(); 
		//		aDAO5.buscarPorId(1);

		//buscar todos

		//		AnexoDAO aDAO5 = new AnexoDAO();
		//		List<Anexo> listaAnexos = aDAO5.buscarTodos();
		//		for(Anexo a: listaAnexos) {
		//			System.out.println(a.getTitulo());
		//		}



		/////////////////////////////////////////////////////  if curso /////////////////////////////////////////////////////////////////////////

		//cadastrar
		//				InstitutoFederal institutoFederal = new InstitutoFederal();
		//				institutoFederal.setIdIf(3);
		//		
		//				Curso curso = new Curso();
		//				curso.setIdCurso(1);
		//		
		//				IfCurso ifCurso = new IfCurso();
		//				IfCursoDAO icDAO = new IfCursoDAO();
		//				ifCurso.setCurso(curso);
		//				ifCurso.setInstitutoFederal(institutoFederal);
		//				icDAO.cadastrar(ifCurso);

		//editar
		//		InstitutoFederal institutoFederal = new InstitutoFederal();
		//		institutoFederal.setIdIf(3);
		
		
		//		Curso curso = new Curso();
		//		curso.setIdCurso(2);
		//		IfCurso ifCurso = new IfCurso();
		//		IfCursoDAO icDAO = new IfCursoDAO();
		//		ifCurso.setCurso(curso);
		//		ifCurso.setInstitutoFederal(institutoFederal);
		//		ifCurso.setIdIfCurso(1);
		//		icDAO.editar(ifCurso);

		//excluir
		//		IfCursoDAO ifcDAO4 = new IfCursoDAO(); 
		//		ifcDAO4.excluir(1);

		//buscar por id
		//		IfCursoDAO ifcDAO4 = new IfCursoDAO(); 
		//		ifcDAO4.buscarPorId(3);	

		//buscar todos

		//		IfCursoDAO aDAO5 = new IfCursoDAO();
		//		List<IfCurso> listaIfCurso = aDAO5.buscarTodos();
		//		for(IfCurso a: listaIfCurso ) {
		//			System.out.println(a.getIdIfCurso());
		//		}

		////////////////////////////////////////////////////// USUARIO AVALIAÇÃO /////////////////////////////////////////////////////////

		//usuario - avaliação
		//		Usuario usuario = new Usuario();
		//		usuario.setIdUsuario(1);
		//
		//		Avaliacao avaliacao = new Avaliacao();
		//		avaliacao.setIdAvaliacao(3);
		//
		//		UsuarioAvaliacao usuarioAvaliacao = new UsuarioAvaliacao();
		//		UsuarioAvaliacaoDAO uaDAO = new UsuarioAvaliacaoDAO();
		//		usuarioAvaliacao.setUsuario(usuario);
		//		usuarioAvaliacao.setAvaliacao(avaliacao);
		//		
		//		uaDAO.cadastrar(usuarioAvaliacao);


		//		UsuarioAvaliacaoDAO ifcDAO4 = new UsuarioAvaliacaoDAO(); 
		//		ifcDAO4.excluir(1);

		//				Usuario usuario = new Usuario();
		//				usuario.setIdUsuario(1);
		//		
		//				Avaliacao avaliacao = new Avaliacao();
		//				avaliacao.setIdAvaliacao(1);
		//		
		//				UsuarioAvaliacao usuarioAvaliacao = new UsuarioAvaliacao();
		//				UsuarioAvaliacaoDAO uaDAO = new UsuarioAvaliacaoDAO();
		//				usuarioAvaliacao.setIdUsuarioAvaliacao(4);
		//				usuarioAvaliacao.setUsuario(usuario);
		//				usuarioAvaliacao.setAvaliacao(avaliacao);
		//				
		//				uaDAO.editar(usuarioAvaliacao);

		//		UsuarioAvaliacaoDAO ifcDAO4 = new UsuarioAvaliacaoDAO(); 
		//		ifcDAO4.buscarPorId(4);	

		//		UsuarioAvaliacaoDAO aDAO5 = new UsuarioAvaliacaoDAO(); 
		//		List<UsuarioAvaliacao> listaUsuarioAvaliacao = aDAO5.buscarTodos();
		//		for(UsuarioAvaliacao a: listaUsuarioAvaliacao ) {
		//			System.out.println(a.getIdUsuarioAvaliacao());
		//		}
		
//				UsuarioAvaliacaoDAO aDAO5 = new UsuarioAvaliacaoDAO(); 
//				List<Avaliacao> Avaliacao = aDAO5.buscarPorUsuario(19);
//				for(Avaliacao a: Avaliacao ) {
//					System.out.println(a.getAvaliacao());
//				}
//		UsuarioAvaliacaoDAO aDAO5 = new UsuarioAvaliacaoDAO(); 
//		List<Avaliacao> Avaliacao = aDAO5.buscarPorIdData(19, "12/12/2019");
//		for(Avaliacao a: Avaliacao ) {
//			System.out.println(a.getConteudo());
//		}


		//////////////////////////////////////////////////////// USUARIO ANEXO ////////////////////////////////////////////////////////////////

		//				Anexo anexo = new Anexo();
		//				anexo.setIdAnexo(3);
		//				Usuario usuario = new Usuario();
		//				usuario.setIdUsuario(1);
		//		
		//				UsuarioAnexo usuarioAnexo = new UsuarioAnexo();
		//				UsuarioAnexoDAO uaDAO = new UsuarioAnexoDAO();
		//				usuarioAnexo.setAnexo(anexo);
		//				usuarioAnexo.setUsuario(usuario);
		//				uaDAO.cadastrar(usuarioAnexo);

		//		Anexo anexo = new Anexo();
		//		anexo.setIdAnexo(3);
		//		Usuario usuario = new Usuario();
		//		usuario.setIdUsuario(1);
		//
		//		UsuarioAnexo usuarioAnexo = new UsuarioAnexo();
		//		UsuarioAnexoDAO uaDAO = new UsuarioAnexoDAO();
		//		usuarioAnexo.setAnexo(anexo);
		//		usuarioAnexo.setUsuario(usuario);
		//		usuarioAnexo.setIdUsuarioAnexo(1);
		//		uaDAO.editar(usuarioAnexo);

		//		UsuarioAnexoDAO ifcDAO4 = new UsuarioAnexoDAO(); 
		//		ifcDAO4.excluir(1);

		//		UsuarioAnexoDAO ifcDAO4 = new UsuarioAnexoDAO(); 
		//		ifcDAO4.buscarPorId(2);	

		//		UsuarioAnexoDAO aDAO5 = new UsuarioAnexoDAO(); 
		//		List<UsuarioAnexo> listaUsuarioAnexo = aDAO5.buscarTodos();
		//		for(UsuarioAnexo a: listaUsuarioAnexo) {
		//			System.out.println(a.getUsuario().getIdUsuario());
		//		}

		////////////////////////////////////////////////////// DISCIPLINA USUARIO ////////////////////////////////////////////////////////////////

		//				Disciplina disciplina = new Disciplina();
		//				disciplina.setIdDisciplina(83);
		//				Usuario usuario = new Usuario();
		//				usuario.setIdUsuario(2);
		//		
		//				DisciplinaUsuario disciplinaUsuario = new DisciplinaUsuario();
		//				DisciplinaUsuarioDAO uaDAO = new DisciplinaUsuarioDAO();
		//				disciplinaUsuario.setDisciplina(disciplina);
		//				disciplinaUsuario.setUsuario(usuario);
		//				uaDAO.cadastrar(disciplinaUsuario);

		//		Disciplina disciplina = new Disciplina();
		//		disciplina.setIdDisciplina(83);
		//		Usuario usuario = new Usuario();
		//		usuario.setIdUsuario(1);
		//
		//		DisciplinaUsuario disciplinaUsuario = new DisciplinaUsuario();
		//		DisciplinaUsuarioDAO uaDAO = new DisciplinaUsuarioDAO();
		//		disciplinaUsuario.setDisciplina(disciplina);
		//		disciplinaUsuario.setUsuario(usuario);
		//
		//		disciplinaUsuario.setIdDiscipinaUsuario(2);
		//		uaDAO.editar(disciplinaUsuario);

		//		DisciplinaUsuarioDAO ifcDAO4 = new DisciplinaUsuarioDAO(); 
		//		ifcDAO4.excluir(2);

		//				DisciplinaUsuarioDAO ifcDAO4 = new DisciplinaUsuarioDAO(); 
		//				ifcDAO4.buscarPorId(3);	

		//		DisciplinaUsuarioDAO aDAO5 = new DisciplinaUsuarioDAO(); 
		//		List<DisciplinaUsuario> listaDisciplinaUsuario = aDAO5.buscarTodos();
		//		for(DisciplinaUsuario a: listaDisciplinaUsuario) {
		//			System.out.println(a.getUsuario().getNomeUsuario());
		//		}






	}
}

