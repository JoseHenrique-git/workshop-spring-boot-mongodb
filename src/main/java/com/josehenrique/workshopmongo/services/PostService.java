package com.josehenrique.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josehenrique.workshopmongo.domain.Post;
import com.josehenrique.workshopmongo.repository.PostRepository;
import com.josehenrique.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
		
	public Post findById(String id) {
		Post user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}	
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
