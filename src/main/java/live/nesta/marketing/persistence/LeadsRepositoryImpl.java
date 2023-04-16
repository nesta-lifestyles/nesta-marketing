package live.nesta.marketing.persistence;

import static live.nesta.marketing.core.repository.mapper.LeadsEntityMapper.LeadsEntityMapper;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceException;
import live.nesta.marketing.core.domain.Lead;
import live.nesta.marketing.core.repository.LeadsRepository;
import live.nesta.marketing.persistence.repository.jpa.LeadsEntityRepository;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class LeadsRepositoryImpl implements LeadsRepository {

	@Inject
	private LeadsEntityRepository repo;

	private static final Logger LOGGER = LoggerFactory.getLogger(LeadsRepositoryImpl.class);

	@Override
	public Lead add(Lead lead) {
		try {
			LOGGER.error("Storing lead to database");
			Lead ld = LeadsEntityMapper.toDomain(repo.save(LeadsEntityMapper.toEntity(lead)));
			return ld;
		} catch (Throwable t) {
			LOGGER.error("Error occured while storing lead to database");
			throw new PersistenceException(t);
		}
	}

	@Override
	public Lead get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lead getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lead> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lead update(Lead domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}
}
