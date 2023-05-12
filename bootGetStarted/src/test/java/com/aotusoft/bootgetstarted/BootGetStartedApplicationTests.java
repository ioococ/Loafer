package com.aotusoft.bootgetstarted;

import com.aotusoft.bootgetstarted.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootGetStartedApplicationTests {
	@Autowired
	private Person person;
	@Test
	void contextLoads() {
		System.out.println(person);
		person.toString();
	}

}
