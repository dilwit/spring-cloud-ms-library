package net.dilwit.spring.ms.library.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class SharedMetaData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Getter @Setter protected Long id;
	
	@Version
	@Column
	@Getter @Setter protected int version;	

	@CreatedBy
	@Column(name = "CREATED_BY", updatable = false)
	@Getter @Setter private Long createdById;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "CREATED_ON", updatable = false)
	@CreatedDate
	@Getter @Setter private DateTime createdOn;

	@LastModifiedBy
	@Column(name = "LAST_UPDATED_BY", updatable = false)
	@Getter @Setter private Long lastUpdatedById;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "LAST_UPDATED_ON")
	@LastModifiedDate
	@Getter @Setter private DateTime lastUpdatedOn;

	@Column
	@Getter @Setter private Boolean deleted = false;
	
}
