package com.crm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.crm.entities.Lead;
import com.crm.repositories.Leadrepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class LeadRepositoryTest {
	
	@Autowired
	private Leadrepository leadrepo;
	
	@Test
	public void saveOneLead() {
		Lead l = new Lead("stallin","s","stallin@gmail.com","radio","9731763925");
		leadrepo.save(l);
		
	}

}
