package com.cg.rawmaterialordermgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.rawmaterialordermgt.entities.RawMaterialOrderEntity;

@Repository
public interface IRawMaterialOrderDao  extends JpaRepository<RawMaterialOrderEntity, String>{

	
}
