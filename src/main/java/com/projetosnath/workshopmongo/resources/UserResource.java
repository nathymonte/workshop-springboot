package com.projetosnath.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetosnath.workshopmongo.domain.User;
import com.projetosnath.workshopmongo.services.UserService;

@RestController //recurso rest
@RequestMapping(value="/users") //indica caminho do endpoint
public class UserResource {
	
	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET)
	//opção alternativa @GetMapping
	public ResponseEntity<List<User>> findAll() {		
		List<User> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}

}
