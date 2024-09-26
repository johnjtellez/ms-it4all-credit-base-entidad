package com.it4all.credit.admon.data.model;

import java.time.LocalDateTime;
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
@Table(name="custom")
public class Custom{

	@Id 
	@SequenceGenerator(
		name="sec_custom",
		sequenceName="sec_custom",
		allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="sec_custom")
	@Column(name="id")
	private Long  id;

	@Column(name="name", length = 50)
	private String  name;

}