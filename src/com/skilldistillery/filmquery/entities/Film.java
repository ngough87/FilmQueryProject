package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {

// follow the actor as an example
	private String title;
	private int rentalDuration;
	private String rating;
	private String specialFeatures;
	private int languageId;
	private List<Actor> actors;
	private String description;
	private int releaseYear;
	private String language;

	public Film() {

	}

	public Film(int rentalDuration, String rating, String specialFeatures, int languageId, String description, int releaseYear, String language) {
		super();
		this.rentalDuration = rentalDuration;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.languageId = languageId;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language = language;
	}

	public Film(int rentalDuration, String rating, String specialFeatures, int languageId, int releaseYear, String language, List<Actor> actors) {
		this(rentalDuration, rating, specialFeatures, languageId, specialFeatures, releaseYear, language);
		this.setActors(actors);
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "\n Film title: " + title + "\n Release Year: " + releaseYear + "\n Rating:" + rating
				+ "\n Description: " + description + "\n Language: " + language ;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYyear() {
		return releaseYear;
	}

	public void setReleaseYear(int release_year) {
		this.releaseYear = release_year;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, description, language, languageId, rating, releaseYear, rentalDuration,
				specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
				&& Objects.equals(language, other.language) && languageId == other.languageId
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration && Objects.equals(specialFeatures, other.specialFeatures)
				&& Objects.equals(title, other.title);
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
