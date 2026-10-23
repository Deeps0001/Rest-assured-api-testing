package api.endPoints;

import static io.restassured.RestAssured.given;

import api.payloads.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response; 

public class UserEndPoints {
	
	// we need to create methods here
	// create user 
	public static Response createUser(user payload)
	{
	Response response = given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.body(payload) 
	
	.when()
	.post(Routes.post_url); 
	
	return response;

}
	
	// Get User
	public static Response GetUser(String userName)
	{
	Response response = given()
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	
	.when()
	.get(Routes.Get_url); 
	
	return response;
}
	
	//Update user
	public static Response PutUser(String userName, user payload)
	{
	Response response = given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.pathParam("username", userName)
	.body(payload)
	
	.when()
	.put(Routes.Put_url); 
	
	return response;
}
	// Delete User
	public static Response DeleteUser(String userName)
	{
	Response response = given()
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	
	.when()
	.delete(Routes.Delete_url); 
	
	return response;
}
}
