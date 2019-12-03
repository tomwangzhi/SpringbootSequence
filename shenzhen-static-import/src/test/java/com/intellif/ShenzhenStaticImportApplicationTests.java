package com.intellif;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShenzhenStaticImportApplicationTests {

	@Autowired
	@Qualifier(value = "primaryJdbcTemplate")
	JdbcTemplate primaryJdbcTemplate;

	@Autowired
	@Qualifier(value = "secondaryJdbcTemplate")
	JdbcTemplate secondaryJdbcTemplate;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testPrimary() {
		Long aLong = primaryJdbcTemplate.queryForObject("SELECT count(*) FROM t_other_info", Long.class);
		System.out.println(aLong);
	}

	@Test
	public void testSecondary() {
		Long aLong = secondaryJdbcTemplate.queryForObject("SELECT count(*) FROM t_other_info", Long.class);
		System.out.println(aLong);
	}

}
