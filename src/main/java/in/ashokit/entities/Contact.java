package in.ashokit.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="CONTACT_DETAILS")
@Data
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name="ContactId")
	private Integer contactId;
	
	@Column(name="ContactName")
	private String contactName;
	
	@Column(name="ContactEmail")
	private String contactEmail;
	
	@Column(name="ContactNumber")
	
	private Long contactNumber;
	
	@Column(name="ContactActiveSw")
	private String activeSwitch;
	
	@Column(name="ContactCreationDate")
	@CreationTimestamp
	private Date createDate;
	
	@Column(name="ContactUpdateDate")
	@UpdateTimestamp
	private Date updateDate;

}
