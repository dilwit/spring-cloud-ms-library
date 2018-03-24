package net.dilwit.spring.ms.library.member.controller.vm;

import lombok.Getter;
import lombok.Setter;

public class RegistrationVM {

	@Getter @Setter private String firstName;

	@Getter @Setter private String lastName;
	
	@Getter @Setter private String emailAddress;
	
	@Getter @Setter private String cardNumber;
	
	@Getter @Setter private String amount;
}
