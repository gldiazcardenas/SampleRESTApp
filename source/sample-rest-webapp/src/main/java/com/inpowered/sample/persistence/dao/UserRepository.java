package com.inpowered.sample.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inpowered.sample.domain.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
