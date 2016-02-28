package com.solveast.muleteer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

@Entity
public class Muletrack {

	@Id
	@Expose
	private int id;

	@Expose
	private String name;

	@Expose
	private double lat;

	@Expose
	private double lng;

	@Expose
	private Date date;

	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(final double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(final double lng) {
		this.lng = lng;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Muletrack [id=" + id + ", name=" + name + ", lat=" + lat + ", lng=" + lng + ", date=" + date + "]";
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}
}
