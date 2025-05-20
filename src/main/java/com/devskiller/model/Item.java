package com.devskiller.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 100)
  @NotEmpty
  private String title;

  @Column(length = 200)
  private String description;

  @OneToMany(mappedBy = "item", orphanRemoval = true, fetch = FetchType.EAGER)
  Set<Review> reviews = new HashSet<>();

  public Item() {
  }

  public Item(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public Set<Review> getReviews() {
    return reviews;
  }

  public void addReview(Review review) {
    reviews.add(review);
    review.setItem(this);
  }

  @Override
  public String toString() {
    return "\nItem{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", reviews=" + reviews +
        '}';
  }
}
