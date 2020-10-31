package com.liveguru.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EndUserJson {
	public static EndUserJson getDataJson(String fileData) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper.readValue(new File(fileData), EndUserJson.class);
	}
	
	@JsonProperty("firstName")
	String firstName;
	
	@JsonProperty("lastName")
	String lastName;
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("password")
	String password;
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
}
