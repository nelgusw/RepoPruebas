package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.User;

@Repository
public interface IUserRepository<T,ID> extends JpaRepository<User,Long> {

}
