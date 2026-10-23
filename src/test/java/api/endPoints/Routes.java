package api.endPoints;

public class Routes {
	
	/* Create User	POST	https://petstore.swagger.io/v2/user
		Get User 	GET	https://petstore.swagger.io/v2/user/{username}
		Update User	PUT	https://petstore.swagger.io/v2/user/{username}
		Delete User	DELETE	https://petstore.swagger.io/v2/user/{username}
			*/
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User model urls
	
	public static String post_url = base_url + "/user";
	public static String Get_url = base_url + "/user/{username}";
	public static String Put_url = base_url + "/user/{username}";
	public static String Delete_url = base_url + "/user/{username}";
	
	
	
	//Pet module urls
	
	
	
	//Store module urls
	
	/* Place Order	POST	https://petstore.swagger.io/v2/store/order
Get Purchase Order	GET	https://petstore.swagger.io/v2/store/order/{orderId}
Delete Purchase order	DELETE	https://petstore.swagger.io/v2/store/order/{orderId}
*/
	public static String store_post_url = base_url + "/store/order";
	public static String store_Get_url = base_url + "/store/order/{orderId}";
	public static String store_Delete_url = base_url + "/store/order/{orderId}";
	
	
}
