package com.jcohy.provider.repository;

import com.jcohy.provider.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
