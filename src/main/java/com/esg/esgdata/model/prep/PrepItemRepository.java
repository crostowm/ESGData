package com.esg.esgdata.model.prep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepItemRepository extends CrudRepository<PrepItem, String> {
}
