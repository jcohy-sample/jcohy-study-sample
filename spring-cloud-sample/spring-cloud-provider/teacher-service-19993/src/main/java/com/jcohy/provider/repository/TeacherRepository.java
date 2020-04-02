package com.jcohy.provider.repository;

import com.jcohy.provider.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{
    Teacher getByTname(String name);
}
