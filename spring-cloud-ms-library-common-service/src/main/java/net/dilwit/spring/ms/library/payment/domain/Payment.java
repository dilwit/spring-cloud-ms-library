package net.dilwit.spring.ms.library.payment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.dilwit.spring.ms.library.domain.SharedMetaData;

@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Payment extends SharedMetaData implements Serializable {
	
	public enum Status {
	    SUCESS,
	    FAILED
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3889708112643772978L;
	
	@Column
	@Getter @Setter private String cardNumber;

	@Column
	@Getter @Setter private String amount;
	
	@Column
	@Enumerated(EnumType.STRING)
	@Getter @Setter private Status status;

}
