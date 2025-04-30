package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.RetireReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetireReqRepository extends JpaRepository<RetireReq, Integer> {
}
