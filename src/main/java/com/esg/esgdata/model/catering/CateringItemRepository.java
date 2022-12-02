package com.esg.esgdata.model.catering;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateringItemRepository extends CrudRepository<CateringItem, Integer> {
}
