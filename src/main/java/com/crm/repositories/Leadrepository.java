package com.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entities.Lead;

public interface Leadrepository extends JpaRepository<Lead, Long> {

}
