package com.it4all.credit.admon.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="task_progress")
@Data
public class TaskProgress {

	@Id
	@SequenceGenerator(name="taskprogressseq", sequenceName="taskprogressseq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String taskId;

    private int progress;

    public TaskProgress() {}

    public TaskProgress(String taskId, int progress) {
        this.taskId = taskId;
        this.progress = progress;
    }
}
