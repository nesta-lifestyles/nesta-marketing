package live.nesta.marketing.core.services;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.persistence.PersistenceException;
import live.nesta.marketing.core.domain.Lead;
import live.nesta.marketing.core.repository.LeadsRepository;

@Service
public class LeadsServiceImpl implements LeadsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LeadsServiceImpl.class);

	@Inject
	private LeadsRepository leadsRepository; 
	
	@Override
	public Lead get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lead create(Lead lead) throws ServiceException {
		try {
			validate(lead);
			lead.setCreatedDate(LocalDateTime.now());
			lead.setModifiedDate(LocalDateTime.now());
			Lead ld = leadsRepository.add(lead);
			return ld;
		} catch (PersistenceException e) {
			LOGGER.error("Exception while persisting the lead");
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Lead update(Lead customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	
	private void validate(Lead customer) throws ValidationException {
		customer.setName(Jsoup.clean(customer.getName(), Safelist.basic()));
		if (!isValidEmail(customer.getEmail())) {
			LOGGER.error("Email is not valid. email={}", customer.getEmail());
			throw new ValidationException("10010", "Invalid email address");
		}
	}
	
	private Boolean isValidEmail(String email ) {
		String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		return Pattern.compile(regexPattern)
	      .matcher(email)
	      .matches();
	}
}
