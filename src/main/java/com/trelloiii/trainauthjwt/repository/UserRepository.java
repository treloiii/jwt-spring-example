package com.trelloiii.trainauthjwt.repository;

import com.trelloiii.trainauthjwt.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {
    Users findByLogin(String login);
}
