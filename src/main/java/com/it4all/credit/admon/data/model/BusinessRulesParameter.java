package com.it4all.credit.admon.data.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="business_rules_parameters")
public class BusinessRulesParameter{

	@Id
	@SequenceGenerator(
		name="sec_business_rules_parameters",
		sequenceName="sec_business_rules_parameters",
		allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="sec_business_rules_parameters")
	@Column(name="id")
	private Long id;

	@Column(name="name", length = 50)
	private String  name;

	@Column(name="is_value_in_field")
	private Boolean  isValueInField;

	@Column(name="business_rules_id")
	private Long  businessRulesId;

	//Aca traer BusinessRules como tipo lazy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "business_rules_id", insertable = false, updatable = false)
	private BusinessRules businessRulesIdEntity;

}
