package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.VacationType;
import com.poi.hr.dto.vacation.VacationTypeResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationTypeRepository extends JpaRepository<VacationType, Integer> {

}
