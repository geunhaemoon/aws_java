package ch19_제네릭;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class AccountUser<String> {
	private String username;
	private String password;

}//class
