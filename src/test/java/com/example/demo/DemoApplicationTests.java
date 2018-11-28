package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() {

				List<Table> tables = new ArrayList<Table>();
				tables .add(new Table(2));
				tables .add(new Table(2));
				tables .add(new Table(2));
				tables .add(new Table(4));
				tables.add(new Table(6));
				tables.add(new Table(6));
				RestManager rm = new RestManager(tables);
				assertEquals(3, rm.map.get(2).size());
				assertEquals(1, rm.map.get(4).size());
				assertEquals(2, rm.map.get(6).size());
				
				rm.onArrive(new ClientsGroup(6));
				assertEquals(1, rm.map.get(6).size()); 
				
				ClientsGroup cg212 = new ClientsGroup(212);
				rm.onArrive(cg212);
				assertEquals(null, rm.seatings.get(cg212));
	}
}
