package com.yey.site0913.repository;

import com.yey.site0913.domain.TblMaterialGroup;
import com.yey.site0913.domain.TblMaterialItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblMaterialItemRepository extends JpaRepository<TblMaterialItem, String> {
}
