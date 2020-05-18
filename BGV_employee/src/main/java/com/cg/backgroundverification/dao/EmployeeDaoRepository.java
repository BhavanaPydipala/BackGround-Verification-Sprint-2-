package com.cg.backgroundverification.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.backgroundverification.entity.EmployeeDocumentDto;

public interface EmployeeDaoRepository extends JpaRepository<EmployeeDocumentDto,Integer>{

}
