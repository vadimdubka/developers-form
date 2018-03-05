package com.vadimdubka.form.dao;

import com.vadimdubka.form.entity.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {

}
