package com.fsd.assign.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd.assign.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
	
	Subject findByDurationInHours(int durationInHours);

}
