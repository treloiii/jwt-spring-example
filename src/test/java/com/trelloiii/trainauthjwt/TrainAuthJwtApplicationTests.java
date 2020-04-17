package com.trelloiii.trainauthjwt;

import com.trelloiii.trainauthjwt.entities.Users;
import com.trelloiii.trainauthjwt.repository.UserRepository;
import org.junit.gen5.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class TrainAuthJwtApplicationTests {
	@Autowired
	UserRepository repository;
	@Test
	void getUserByLogin() {
		Users users=repository.findByLogin("admin");
		Assertions.assertEquals(users.getPassword(),"$2y$12$1W3yC0oArhUUT4NZXc7pcedi/vMYR57nT6/p/ZRckwYbZ7k.QNQLu");
	}


}
