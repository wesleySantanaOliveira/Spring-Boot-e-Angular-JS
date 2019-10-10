package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.repository.ClienteRespository;
import br.com.fabricadeprogramador.ws.service.ClienteService;

@RestController
public class ClienteController {

	
	//CAMADA DE NEGOCIO	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClienteRespository clienteResposity;
		
	//EndPoint
	//CRIAR CLIENTE
	@RequestMapping(method = RequestMethod.POST, value = "/clientes",
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE , 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {		
		
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);		
		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.OK);
	}
	
	//CONSULTA CLIENTE
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {		
		
		Collection<Cliente> clientesBuscado = clienteService.buscarTodos();		
		return new ResponseEntity<>(clientesBuscado, HttpStatus.OK);
	}
	
	//CONSULTA EXCLUIR
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {		
		
		Cliente clienteEncontrado = clienteService.buscaPorId(id);
		
		if(clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}	
		clienteService.excluir(clienteEncontrado);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//ALTERAR CLIENTE
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes",
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE , 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {		
		Cliente clienteAlterado = clienteService.alterar(cliente);		
		return new ResponseEntity<Cliente>(clienteAlterado, HttpStatus.OK);
	}
	
	
}
