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
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Member extends SharedMetaData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4706629442650062926L;
	
	@Column
	@Getter @Setter private String firstName;

	@Column
	@Getter @Setter private String lastName;
	
	@Column
	@Getter @Setter private String emailAddress;

}
