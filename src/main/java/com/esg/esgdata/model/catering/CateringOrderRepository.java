package com.esg.esgdata.model.catering;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateringOrderRepository extends CrudRepository<CateringOrder, Integer> {
}
