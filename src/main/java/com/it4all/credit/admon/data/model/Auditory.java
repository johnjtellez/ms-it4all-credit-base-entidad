package com.it4all.credit.admon.data.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="auditory")
@Data
public class Auditory {
	@Id
	@SequenceGenerator(name="auditoryseq", sequenceName="auditoryseq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column(name = "entity_id")
    private Long entityId;

    @Column(name = "entity_name", length = 50)
    private String entityName;

    @Column(name = "action")
    private String action;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "previous_value", columnDefinition = "TEXT")
    private String previousValue;

    @Column(name = "new_value", columnDefinition = "TEXT")
    private String newValue;
}
