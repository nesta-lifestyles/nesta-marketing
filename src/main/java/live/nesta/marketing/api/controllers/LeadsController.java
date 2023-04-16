package live.nesta.marketing.api.controllers;


import static live.nesta.marketing.api.mapper.LeadsMapper.LeadsMapper;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import live.nesta.marketing.api.resources.Error;
import live.nesta.marketing.api.resources.Lead;
import live.nesta.marketing.core.services.LeadsService;
import live.nesta.marketing.core.services.ServiceException;

@RestController
@RequestMapping("/api/v1")
public class LeadsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LeadsController.class);
	
	@Inject
	private LeadsService leadsService;

	@PostMapping("/leads")
	public ResponseEntity<?> create(@RequestHeader("request-id") String requestId, @RequestBody Lead lead) {
		try {
			LOGGER.info("Registering the lead from source={}", lead.getSource());
			Lead resource = LeadsMapper.toResource(leadsService.create(LeadsMapper.toDomain(lead)));
			return new ResponseEntity<Lead>(resource, HttpStatus.CREATED);
		} catch(ServiceException e) {
			LOGGER.error("Failed to register customer with email={}", lead.getEmail());
			return new ResponseEntity<Error>(new Error(e.getCode(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
