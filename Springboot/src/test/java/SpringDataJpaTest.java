import cn.itcast.SpringDataJpaApplication;
import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataJpaApplication.class)
public class SpringDataJpaTest {
    @Autowired
    private CustomerDao customerDao;
    @Test
    public void test(){
        Customer customer = new Customer();
        customer.setCustName("传智播客");
        customer.setCustLevel("VIP");
        customer.setCustIndustry("IT教育");
        customerDao.save(customer) ;
    }
    public void test01(){
        System.out.println(66666);
    }
}
