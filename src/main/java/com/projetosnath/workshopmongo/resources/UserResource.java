package com.projetosnath.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetosnath.workshopmongo.domain.User;
import com.projetosnath.workshopmongo.dto.UserDTO;
import com.projetosnath.workshopmongo.services.UserService;

@RestController //recurso rest
@RequestMapping(value="/users") //indica caminho do endpoint
public class UserResource {
	
	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET) //opção alternativa @GetMapping	
	public ResponseEntity<List<UserDTO>> findAll() {		
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map( x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //opção alternativa @GetMapping	
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {		
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	

}
