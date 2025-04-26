package com.example.studentgrades;

import com.example.studentgrades.controller.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Smoketest {
	
	@Autowired
	 private StudentController sc;
	
	@Test
	void contextLoads() throws Exception{
		assertThat(sc).isNotNull();
	}

}
