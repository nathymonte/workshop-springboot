package com.projetosnath.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosnath.workshopmongo.domain.User;
import com.projetosnath.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	//instancia automaticamente o objeto - mecanismo de injeção de dependência do spring
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
}
