package cz.haffner.BNPParibasTask;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

@SpringBootApplication
public class BnpParibasTaskApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {

		SpringApplication.run(BnpParibasTaskApplication.class, args);
	}

	@PostConstruct
	private void initDb() {
		String sqlStatements[] = {
				"drop table customer if exists",
				"drop table quotation if exists",
				"drop table subscription if exists",
				"create table customer(customer_id serial,first_name varchar(255),last_name varchar(255),middle_name varchar(255),email varchar(255),phone_number varchar(255), birth_date date)",
				"create table quotation(quotation_id serial,beginning_of_insurance date,insured_amount int,date_of_signing_mortgage date,customer_id varchar(255))",
				"create table subscription(subscription_id serial,start_date date,valid_until date,quotation_id varchar(255))",
				"insert into customer(first_name, last_name) values('Paul','Newman')",
				"insert into customer(first_name, last_name) values('Robert','Redford')"
		};

		Arrays.asList(sqlStatements).stream().forEach(sql -> {
			System.out.println(sql);
			jdbcTemplate.execute(sql);
		});
	}
}
