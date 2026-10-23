package api.endPoints;
import api.payloads.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {
	
	// we need to create methods here
		// Place Order
		public static Response PlaceOrder(Store payload)
		{
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.store_post_url); 
		
		return response;

	}
		//Get Purchase Order
		public static Response GetPurchaseOrder(int orderId)
		{
			Response response = given()
					.accept(ContentType.JSON)
					.pathParam("orderid", orderId)
					
					.when()
					.get(Routes.store_Get_url); 
					
					return response;	
		}
		//Delete purchase order
		public static Response DeletePurchaseOrder(int orderId)
		{
			Response response = given()
					.accept(ContentType.JSON)
					.pathParam("orderid", orderId)
					
					.when()
					.delete(Routes.store_Delete_url); 
					
					return response;
 }
}
