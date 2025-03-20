package com.projetosnath.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetosnath.workshopmongo.domain.Post;
import com.projetosnath.workshopmongo.domain.User;
import com.projetosnath.workshopmongo.dto.UserDTO;
import com.projetosnath.workshopmongo.services.PostService;

@RestController //recurso rest
@RequestMapping(value="/posts") //indica caminho do endpoint
public class PostResource {
	
	@Autowired
	private PostService service;	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //opção alternativa @GetMapping	
	public ResponseEntity<Post> findById(@PathVariable String id) {		
		Post obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET) //opção alternativa @GetMapping	
	public ResponseEntity<List<Post>> findAll() {		
		List<Post> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	

}
