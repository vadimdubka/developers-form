package com.vadimdubka.form.dao;

import com.vadimdubka.form.entity.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, Long> {
    /*Functionality for the the additional method “findByLabel “declared here
    will be provided automatically by JPA*/
    List<Skill> findByLabel(String label);
}