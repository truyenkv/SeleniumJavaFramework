package common;

import java.util.Locale;

import com.github.javafaker.Faker;
public class DataUntil {
	
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);
	
	public static DataUntil getData() {
		return new DataUntil();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	public String getLastName() {
		return faker.address().lastName();
	}
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	public String getPassword() {
		return faker.internet().password(8, 10);
	}
	
	
	
	

}
