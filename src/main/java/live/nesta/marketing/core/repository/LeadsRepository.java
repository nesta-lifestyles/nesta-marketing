package live.nesta.marketing.core.repository;

import live.nesta.marketing.core.domain.Lead;

public interface LeadsRepository extends CrudRepository<Lead> {
	
	Lead getByEmail(String email);
}
