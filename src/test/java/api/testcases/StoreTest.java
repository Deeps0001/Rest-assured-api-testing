package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.StoreEndPoints;
import api.payloads.Store;
import io.restassured.response.Response;


public class StoreTest {
	
	Faker faker;
	Store storepayload;
	
	@BeforeClass
	public void storeTestData() {
		
		faker = new Faker();
		storepayload = new Store();
		
		storepayload.setId(faker.number().numberBetween(100000, 999999));
		storepayload.setPetId(faker.number().numberBetween(1, 999));
		storepayload.setQuantity(faker.number().numberBetween(1, 10));
		storepayload.setShipDate(faker.date().future(7, java.util.concurrent.TimeUnit.DAYS).toString());
		storepayload.setStatus(faker.options().option("placed", "approved", "delivered"));
		storepayload.setComplete(faker.bool().bool());
		
		
		
	}
	
	@Test
	public void  TestPlaceOrder() {
		Response response =StoreEndPoints.PlaceOrder(storepayload);
		
		System.out.println("Place ordered");
		
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
