package net.dilwit.spring.ms.library.member.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.dilwit.spring.ms.library.domain.SharedMetaData;

@Entity
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Login extends SharedMetaData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8401925194781143774L;
	
	@Column
	@Getter @Setter private String username;

	@Column
	@Getter @Setter private String password;
}
