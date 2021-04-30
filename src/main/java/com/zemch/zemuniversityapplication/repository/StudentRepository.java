package com.zemch.zemuniversityapplication.repository;

import com.zemch.zemuniversityapplication.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAllByUniversityGroupId(Long id);
}
