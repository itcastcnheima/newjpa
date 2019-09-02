import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;


import cn.itcast.domain.SysRole;
import cn.itcast.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToMAny {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;
    @Test
    @Transactional
    @Rollback(false)
    public void testadd(){
        SysRole role = new SysRole();
        role.setRoleName("部长");
        role.setRoleMemo("66666");
        SysUser user = new SysUser();
        user.setUserCode("123456");
        user.setUserName("小宝");
        user.getRoleSet().add(role);
        role.getUserSet().add(user);
        userDao.save(user);
        roleDao.save(role);
    }
}
