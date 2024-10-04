
package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Enrollment;
import com.entity.EnrollmentKey;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentKey>{

}
