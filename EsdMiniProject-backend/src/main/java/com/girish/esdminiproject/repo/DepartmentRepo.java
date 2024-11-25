package com.girish.esdminiproject.repo;
import com.girish.esdminiproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface DepartmentRepo extends JpaRepository<Department, Long> {
   Optional<Department>  findByDepartmentId(int id);

}
