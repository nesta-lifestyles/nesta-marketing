package live.nesta.marketing.core.repository;

import java.util.List;

public interface CrudRepository<T> {
	
	T add(T domain);
	
	T get(String id);
	
	List<T> getAll();
	
	T update(T domain);
	
	void delete(String id);

}