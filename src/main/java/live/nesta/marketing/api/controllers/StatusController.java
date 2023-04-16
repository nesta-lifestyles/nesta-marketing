package live.nesta.marketing.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StatusController.class);
	
	@RequestMapping("/status")
	public ResponseEntity<String> getStatus(@RequestHeader("request-id") String requestId) {
		LOGGER.info("status check. UP!");
		return new ResponseEntity<String>("I'm alive!", HttpStatus.OK);
	}
}
