package com.example.demo.services;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.CepResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {

	public CepResponse getWeather(String cep) {

		try {
			String cepUrl = "https://cep.awesomeapi.com.br/json/";
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(cep);
			String cepFormatted = jsonNode.get("cep").asText();

			URI url = new URI(cepUrl.concat(cepFormatted));
			
			RestTemplate restTemplate = new RestTemplate();
			CepResponse cepResponse = restTemplate.getForObject(url, CepResponse.class);
			
			return cepResponse;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
