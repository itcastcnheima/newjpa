package cn.itcast.dao;

import cn.itcast.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleDao extends JpaRepository<SysRole,Long> , JpaSpecificationExecutor<SysRole> {
}
