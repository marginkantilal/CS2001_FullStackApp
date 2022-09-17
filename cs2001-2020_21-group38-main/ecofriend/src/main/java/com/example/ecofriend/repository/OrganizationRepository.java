package com.example.ecofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecofriend.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
