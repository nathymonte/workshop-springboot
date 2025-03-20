package com.projetosnath.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosnath.workshopmongo.domain.Post;
import com.projetosnath.workshopmongo.domain.User;
import com.projetosnath.workshopmongo.repository.PostRepository;
import com.projetosnath.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	//instancia automaticamente o objeto - mecanismo de injeção de dependência do spring
	@Autowired
	private PostRepository repo;	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));		
				
	}
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
}
