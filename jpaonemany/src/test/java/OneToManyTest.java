import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;
    @Test
    @Transactional
    @Rollback(false)
    public void testadd(){
        Customer customer = new Customer();
        customer.setCustName("传智");
        customer.setCustAddress("西安");
        LinkMan link = new LinkMan();
        link.setLkm_name("小宝");
        link.setLkm_position("部长");

      //customer.getLinkManSet().add(link);
        link.setCustomer(customer);
        customerDao.save(customer);
        linkManDao.save(link);
    }
    @Test
    @Transactional
    @Rollback(false)
    public void testdel(){
        customerDao.delete(96l);
       // linkManDao.delete(1l);
    }
}
