package com.example.demo.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.demo.models.CepResponse;
import com.example.demo.services.WeatherService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/search")
public class WeatherController {
	
	Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService service;
	
	@PostMapping
	public ResponseEntity<CepResponse> getWeather (@RequestBody String cep)  {
		CepResponse response = service.getWeather(cep);
		return ResponseEntity.ok().body(response);
	}
}
