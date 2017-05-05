package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	private static PersonDomainModel person1 = new PersonDomainModel();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		person1.setFirstName("Suzie");
		person1.setLastName("Zites");
		person1.setCity("Newark");
		person1.setBirthday(new Date(0));
		person1.setPostalCode(19711);
		person1.setStreet("66 Rect Ave");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(person1.getPersonID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void TestGetAllPerson()
	{
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
	}
	
	@Test
	public void TestUpdateDeletePerson() {
		PersonDomainModel per2 = PersonDAL.getPerson(person1.getPersonID());
		assertEquals(person1.getPersonID(), per2.getPersonID());
		
		per2.setLastName("Setiz");
		PersonDAL.updatePerson(per2);
		
		PersonDomainModel per3 = PersonDAL.getPerson(per2.getPersonID());
		assertEquals(per2.getLastName(), per3.getLastName());
		assertNotEquals(person1.getLastName(),per3.getLastName());
		
		PersonDAL.deletePerson(person1.getPersonID());
		PersonDomainModel per4 = PersonDAL.getPerson(per3.getPersonID());
		assertNull(per4);
	}
	
	@Test
	public void AddPerson() {
		PersonDomainModel person1 = new PersonDomainModel();
		person1.setBirthday(new Date(0));
		person1.setCity("Newark");
		person1.setFirstName("Suzie");
		person1.setLastName("Zites"); 
		person1.setPostalCode(19711);
		person1.setStreet("66 Rect Ave");
		
		PersonDAL.addPerson(person1);
		
		
	}
}
