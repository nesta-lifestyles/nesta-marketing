package live.nesta.marketing.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import live.nesta.marketing.persistence.repository.entity.LeadEntity;

public interface LeadsEntityRepository extends JpaRepository<LeadEntity, String> {
	
}

