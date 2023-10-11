package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TemperatureInfo {
	@JsonIgnore
	private double temp;
	@JsonIgnore
	private double temp_min;
	@JsonIgnore
	private double temp_max;
	
	public TemperatureInfo() {
		
	}

	public TemperatureInfo(double temp, double temp_min, double temp_max) {
		this.temp = temp;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}

	public double getTemp() {
		return temp;
	}

	public double getTemp_Min() {
		return temp_min;
	}

	public double getTemp_Max() {
		return temp_max;
	}
	
}
