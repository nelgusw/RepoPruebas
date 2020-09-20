package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/Api/users")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long userId ){
		
		Optional<User> oUser = userService.findById(userId);
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();			
		}
		
		return ResponseEntity.ok(oUser);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> Update(@RequestBody User userDatails, @PathVariable(value="id") Long userId)
	{
		Optional<User> oUser = userService.findById(userId);
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();	
		}
		
		//BeanUtils.copyProperties(userDatails, oUser.get());
		oUser.get().setName(userDatails.getName());
		oUser.get().setSurname(userDatails.getSurname());
		oUser.get().setEmail(userDatails.getEmail());
		oUser.get().setEnabled(userDatails.getEnabled());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(oUser.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long userId){
		if(!userService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		
		userService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	/*@GetMapping
	public List<User> readAll(){
		
		List<User> users = StreamSupport.stream( userService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return users;
	}*/
	
	
	@GetMapping
	public ResponseEntity<?> readAll(){
		
		List<User> users = StreamSupport.stream( userService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return  ResponseEntity.ok(users);
	}
	
	
}