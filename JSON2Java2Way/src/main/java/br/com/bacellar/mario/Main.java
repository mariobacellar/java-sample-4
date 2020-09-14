package br.com.bacellar.mario;

import br.com.bacellar.mario.model.User;
import br.com.bacellar.mario.parser.JSON2Java;
import br.com.bacellar.mario.parser.Java2JSON;

public class Main {

	public static void main(String[] args) {
		try {
			
			String json =  "{ \"firstName\" : \"Shane\", \"lastName\" : \"James\", \"age\" : 30}";
			
			System.out.println("JSON User as Object...:" +JSON2Java.parser2User(json));

			
			User 
			user = new User();
			user.setFirstName("Mario");
			user.setLastName("Bacellar");
			user.setAge(45);
			System.out.println("Object User as JSON...:" + Java2JSON.parser2User(user).toString());

			System.out.println("Object as JSON...:" + Java2JSON.parser2User(user).toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
