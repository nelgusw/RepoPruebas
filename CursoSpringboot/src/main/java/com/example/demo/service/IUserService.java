package com.example.demo.service;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.demo.entities.User;

public interface IUserService {
 public Iterable<User> findAll();
 public Page<User> findAll(Pageable pagenable);
 public Optional<User> findById(Long id);
 public User save(User user);
 public void deleteById(Long id);
}
