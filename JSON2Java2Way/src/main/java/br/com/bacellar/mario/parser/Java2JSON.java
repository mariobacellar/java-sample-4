package br.com.bacellar.mario.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bacellar.mario.model.User;

public class Java2JSON {

	
	public static String parser2User(User user) throws Exception {
		return new ObjectMapper().writeValueAsString(user);
    }


	public static String parser(Object obj) throws Exception {
		return new ObjectMapper().writeValueAsString(obj);
    }


}
