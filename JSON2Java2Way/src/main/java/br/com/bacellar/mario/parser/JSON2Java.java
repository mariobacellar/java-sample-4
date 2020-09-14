package br.com.bacellar.mario.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bacellar.mario.model.User;

public class JSON2Java {

	public static User parser2User(String json) throws Exception {
		return new ObjectMapper().readValue(json, User.class);
    }
	

}
