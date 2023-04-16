package live.nesta.marketing.core.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import live.nesta.marketing.persistence.repository.entity.LeadEntity;

@Mapper
public interface LeadsEntityMapper {
	
	LeadsEntityMapper LeadsEntityMapper = Mappers.getMapper(LeadsEntityMapper.class);

	live.nesta.marketing.core.domain.Lead toDomain(LeadEntity lead);
	
	LeadEntity toEntity(live.nesta.marketing.core.domain.Lead lead);
}
