package com.jcohy.provider.repository;

import com.jcohy.provider.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long>{
    Course getByCname(String name);
}
