package in.ashokit.bindings;

import java.util.Date;

import lombok.Data;

@Data
public class ContactForm {

	private Integer contactId;

	private String contactName;

	private String contactEmail;

	private Long contactNumber;

	private String activeSwitch;

	private Date createDate;

	private Date updateDate;

}
