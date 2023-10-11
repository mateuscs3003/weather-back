package com.example.demo.models;

public class CepResponse {
	
	private String lat;
	private String lng;
	
	public CepResponse() {
	}

	public CepResponse(String lat, String lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public String getLng() {
		return lng;
	}
	
}
