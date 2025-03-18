package com.projetosnath.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosnath.workshopmongo.domain.User;
import com.projetosnath.workshopmongo.dto.UserDTO;
import com.projetosnath.workshopmongo.repository.UserRepository;
import com.projetosnath.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	//instancia automaticamente o objeto - mecanismo de injeção de dependência do spring
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("User não encontrado"));		
				
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}	
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		Optional<User> optionalUser = repo.findById(obj.getId());		
		User newObj = optionalUser.orElseThrow(() -> new ObjectNotFoundException("User não encontrado"));
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
