package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
    @Query(value = "from Customer ")
    public List<Customer> findAllCustomer();
    @Query(value = "from Customer where custId=?1")
    public Customer findByOne(Long id);
    @Query(value = "update Customer set custName= ?1 where custId=?2")
    public Customer update(String name,Long  id);
    @Query(value = "select * from cst_customer ",nativeQuery = true)
    public List<Customer> findAllcustomer();
    public List<Customer> findCustomerByCustName(String name);
    public Customer findCustomerByCustNameAndCustPhone(String name,String phone);
    public List<Customer> findCustomerByCustNameLike(String name);
}
