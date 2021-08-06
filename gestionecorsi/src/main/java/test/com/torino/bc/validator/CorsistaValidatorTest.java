package test.com.torino.bc.validator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.torino.bc.model.Corsisti;
import com.torino.bc.validator.CorsistaValidator;

class CorsistaValidatorTest {
	private static Corsisti corsista1;
	private static Corsisti corsista2;
	private static Corsisti corsista3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsista1=new Corsisti(); 
		corsista1.setCodCorsista(1);
		corsista1.setNomeCorsista("Mario");
		corsista1.setCognomeCorsista("Rossi");
		corsista1.setPrecedentiFormativi("si");
		
		corsista2=new Corsisti(); 
		corsista2.setCodCorsista(2);
		corsista2.setNomeCorsista("Mario123");
		corsista2.setCognomeCorsista("Rossi");
		corsista2.setPrecedentiFormativi("si");
		
		corsista3=new Corsisti(); 
		corsista3.setCodCorsista(3);
		corsista3.setNomeCorsista("Mario");
		corsista3.setCognomeCorsista("Roissssssssssssssssssssssssssssssssadsadasfajsnfdjansfjas");
		corsista3.setPrecedentiFormativi("si");
		
		
		}
	
	@Test
	void testValidate() {
		System.out.println(
		CorsistaValidator.validate(corsista1.getNomeCorsista(),corsista1.getCognomeCorsista()) +" "
		+ CorsistaValidator.validate(corsista2.getNomeCorsista(),corsista2.getCognomeCorsista())+" "
		+ CorsistaValidator.validate(corsista3.getNomeCorsista(),corsista3.getCognomeCorsista()));
			
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corsista1=null;
		corsista2=null;
		corsista3=null;
		
	}

}
