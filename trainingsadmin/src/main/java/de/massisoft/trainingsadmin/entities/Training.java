package de.massisoft.trainingsadmin.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(
        value = {
                @NamedQuery(name="query_get_all_trainings", query="select t from Training t"),
                @NamedQuery(name="query_get_first_training", query="select t from Training t where id = 10002")
        }
        
)
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
	
	@OneToMany(mappedBy = "training")
	private List<Review> reviews = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime updated;
	
	@CreationTimestamp
	private LocalDateTime created;
	
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
	

	public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    
    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
    
    public void removeReviews(Review review) {
        this.reviews.remove(review);
    }

    @Override
	public String toString() {
		return "Training [id=" + id + ", title=" + title + ", description=" + description + ", pointsNeeded="
				+ pointsNeeded + "]";
	}
	
}
