package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.repository.ClienteRespository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRespository clienteResposity;
		
		
	//CRIAR UM CLIENTE
		public Cliente cadastrar(Cliente cliente) {
			return clienteResposity.save(cliente);
		}
		
		//LISTAR CLIENTE
		public Collection<Cliente>buscarTodos(){
			return clienteResposity.findAll();
		}
		
		//REMOVER CLIENTE
		public void excluir(Cliente cliente) {
			clienteResposity.delete(cliente);
		}
		
		//BUSCA POR ID
		public Object buscaPorId(Integer id) {
			return clienteResposity.findById(id);
		}
		
		//ALTERAR
		public Cliente alterar(Cliente cliente) {
			return clienteResposity.save(cliente);
		}

}
