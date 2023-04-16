package live.nesta.marketing.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import live.nesta.marketing.api.resources.Lead;

@Mapper
public interface LeadsMapper {
	
	LeadsMapper LeadsMapper = Mappers.getMapper(LeadsMapper.class);

	live.nesta.marketing.core.domain.Lead toDomain(Lead lead);
	
	Lead toResource(live.nesta.marketing.core.domain.Lead lead);
}
