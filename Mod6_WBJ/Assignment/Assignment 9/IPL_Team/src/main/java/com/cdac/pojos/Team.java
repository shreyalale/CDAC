package com.cdac.pojos;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private String abbreviation;
	
	@Column(nullable = false)
	private String owner;
	
	@Column(name = "max_age")
	private Integer maxAge;
	
	@Column(name = "batting_avg")
	private Double battingAvg;
	
	@Column(name = "wickets_taken")
	private Integer wicketsTaken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(Double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public Integer getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(Integer wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	
	

}
