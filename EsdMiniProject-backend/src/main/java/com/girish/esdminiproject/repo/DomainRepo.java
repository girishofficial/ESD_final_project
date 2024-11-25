package com.girish.esdminiproject.repo;
import com.girish.esdminiproject.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepo extends JpaRepository<Domain, Long>{
}
