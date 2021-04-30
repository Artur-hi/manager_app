package com.zemch.zemuniversityapplication.repository;

import com.zemch.zemuniversityapplication.model.UniversityGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<UniversityGroup, Long> {

    List<UniversityGroup> findAll();

}
