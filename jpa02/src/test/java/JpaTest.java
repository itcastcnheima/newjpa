import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/persistence.xml")
public class JpaTest {
    @Autowired
    private CustomerDao customerDao;
    @Test
    public void test01(){
        Customer c = new Customer();
        c.setCustName("金淦");
        c.setCustAddress("日沟湾");
        customerDao.save(c);
    }
    @Test
    public void updatetest(){
        Customer c = customerDao.findOne(8l);
        c.setCustName("金淦");
        c.setCustAddress("咸阳");
        customerDao.save(c);
    }
    @Test
    public void deltest(){
        customerDao.delete(8l);
    }
    @Test
    public void findAlltest(){
        List<Customer> all = customerDao.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }
    @Test
    public void test02(){
       // List<Customer> list = customerDao.findAllCustomer();
        Customer list = customerDao.findOne(9l);
        System.out.println(list);
    }
    @Test
    public void test03(){
        // List<Customer> list = customerDao.findAllCustomer();
        List<Customer> list = customerDao.findAllcustomer();
        System.out.println(list);
    }
    @Test
    public void test04(){
        // List<Customer> list = customerDao.findAllCustomer();
//        List<Customer> list = customerDao.findCustomerByCustName("金淦");
        Customer customer = customerDao.findCustomerByCustNameAndCustPhone("豹子头", "18220577844");
        System.out.println(customer);
    }
    @Test
    public void test05(){
        // List<Customer> list = customerDao.findAllCustomer();
//        List<Customer> list = customerDao.findCustomerByCustName("金淦");
        List<Customer> list = customerDao.findCustomerByCustNameLike("%豹%");
        System.out.println(list);
    }
    @Test
    public void testspec(){
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                //精准匹配
                Predicate predicate = cb.equal(custName, "传智播客");
                return predicate;
            }
        };
        List<Customer> list = customerDao.findAll(spec);
        System.out.println(list);
    }
    @Test
    public void testadd(){
        Specification<Customer> spec = null;
        Pageable page = new PageRequest(0, 2);
        Page<Customer> all = customerDao.findAll(spec, page);
        int totalPages = all.getTotalPages();//总页数
        System.out.println(totalPages);
        long totalElements = all.getTotalElements();//总记录
        System.out.println(totalElements);
        List<Customer> contentList = all.getContent();
        for (Customer customer : contentList) {
            System.out.println(customer);

        }

    }
    @Test
    public void testlike(){
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                Predicate like = cb.like(custName.as(String.class), "%教育%");
                return like;
            }
        };
        List<Customer> list = customerDao.findAll(spec);
        System.out.println(list);
    }

}
