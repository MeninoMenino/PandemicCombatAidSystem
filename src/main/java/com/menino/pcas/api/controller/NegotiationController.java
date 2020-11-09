package com.menino.pcas.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menino.pcas.domain.model.Negotiation;
import com.menino.pcas.domain.repository.NegotiationRepository;

@RestController
@RequestMapping("/negotiation")
public class NegotiationController {
	
	@Autowired
	NegotiationRepository negotiationRepository;
	
	@GetMapping
	public List<Negotiation> getNegotiationList(){
		return negotiationRepository.findAll();
	}
	
	@PostMapping
	public Negotiation postNegotiation(@Valid @RequestBody Negotiation negotiation) {
		negotiation.setNegotiation_date_time(LocalDateTime.now());
		return negotiationRepository.save(negotiation);
	}
}
