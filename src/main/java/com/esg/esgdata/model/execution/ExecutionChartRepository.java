package com.esg.esgdata.model.execution;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionChartRepository extends CrudRepository<ExecutionChart, ExecutionId> {
}
