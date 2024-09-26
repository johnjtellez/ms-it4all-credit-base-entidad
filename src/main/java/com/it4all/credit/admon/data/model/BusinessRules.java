package com.it4all.credit.admon.data.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="business_rules")
public class BusinessRules{

	@Id
	@SequenceGenerator(
		name="sec_business_rules",
		sequenceName="sec_business_rules",
		allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="sec_business_rules")
	@Column(name="id")
	private Long  id;

	@Column(name="name", length = 50)
	private String  name;

	@Column(name="code")
	private String  code;

	@Column(name="nameField")
	private String  nameField;

	@Column(name="is_enabled")
	private Boolean  isEnabled;

	@Column(name="description", length = 1000)
	private String  description;

	@Column(name="message_error", length = 200)
	private String  messageError;

	@Column(name="query", length = 2000)
	private String  query;

}
