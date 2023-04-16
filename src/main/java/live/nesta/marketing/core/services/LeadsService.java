package live.nesta.marketing.core.services;

import live.nesta.marketing.core.domain.Lead;

public interface LeadsService {

	Lead get(String id);
	
	Lead create(Lead lead) throws ServiceException;
	
	Lead update(Lead lead);
	
	void delete(String id);
}
