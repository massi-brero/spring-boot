package de.massisoft.trainingsadmin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="training")
public class Training {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title", nullable = false)
	private String title;
	
	private String description;
	
	@Column(name="points_needed")
	private int pointsNeeded;
	
	protected Training() {}

	public Training(String title, String description, int pointsNeeded) {
		super();
		this.title = title;
		this.description = description;
		this.pointsNeeded = pointsNeeded;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPointsNeeded() {
		return pointsNeeded;
	}

	public void setPointsNeeded(int pointsNeeded) {
		this.pointsNeeded = pointsNeeded;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", title=" + title + ", description=" + description + ", pointsNeeded="
				+ pointsNeeded + "]";
	}
	
}
