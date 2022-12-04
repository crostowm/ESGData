package com.esg.esgdata.model.daysales;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DaySalesRepository extends CrudRepository<DaySales, LocalDate> {
}
