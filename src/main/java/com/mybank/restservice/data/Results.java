package com.mybank.restservice.data;

import java.util.List;

import com.mybank.restservice.dto.AuthResponseDTO;

public class Results {

	List<AuthResponseDTO> results;

	
	public Results(List<AuthResponseDTO> results) {
		super();
		this.results = results;
	}

	public List<AuthResponseDTO> getResults() {
		return results;
	}

	@Override
	public String toString() {
		return "Results [results=" + results + "]";
	}
	
}
