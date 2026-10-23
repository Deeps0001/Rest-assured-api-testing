package api.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints;
import api.payloads.user;
import io.restassured.response.Response;

public class UserTest {
	
	
	Faker faker;
	user userPayload;
	
	@BeforeClass
	public void generateTestData()
	{
		faker = new Faker();
		userPayload = new user();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	@Test(priority=1)
	public void TestCreateUser()
	{
		Response response = UserEndPoints.createUser(userPayload);
	
		System.out.println("Create user");
		//log response
		response.then().log().all();
		
		//validation
		// if you want do any other validation work u will do here only.
		Assert.assertEquals(response.getStatusCode(),200);
	
	}
	@Test(priority=2)
	public void TestGetUserData()
	{
		Response response = UserEndPoints.GetUser(this.userPayload.getUsername());
	
		System.out.println("GET user");
		//log response
		response.then().log().all();
		
		//validation
		// if you want do any other validation work u will do here only.
		Assert.assertEquals(response.getStatusCode(),200);
	
}
	@Test(priority=3)
	public void TestPutUserData()
	{
		userPayload.setFirstName(faker.name().firstName());
		Response response = UserEndPoints.PutUser(this.userPayload.getUsername(),userPayload);
	
		System.out.println("update user");
		//log response
		response.then().log().all();
		
		//validation
		// if you want do any other validation work u will do here only.
		Assert.assertEquals(response.getStatusCode(),200);
		
		//Read user data to check if first name is updated or not?
		Response responsePostUpdate = UserEndPoints.GetUser(this.userPayload.getUsername());
		System.out.println("After update user Data");
		responsePostUpdate.then().log().all();
}
	
	@Test(priority=4)
	public void TestDeleteUserData()
	{
		Response response = UserEndPoints.DeleteUser(this.userPayload.getUsername());
	
		System.out.println("delete user");
		//log response
		response.then().log().all();
		
		//validation
		// if you want do any other validation work u will do here only.
		Assert.assertEquals(response.getStatusCode(),200);
}
	
}


