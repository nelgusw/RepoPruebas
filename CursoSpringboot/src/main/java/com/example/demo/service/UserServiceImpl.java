package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.User;
import com.example.demo.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository<User, Long> userRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(Pageable pagenable) {
		
		return userRepository.findAll(pagenable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<User> findById(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		
		return (User) userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		userRepository.deleteById(id);
	}

	
}
