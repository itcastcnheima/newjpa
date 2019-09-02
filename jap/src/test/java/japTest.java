import cn.itcast.domain.Customer;
import cn.itcast.utils.japUtils;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class japTest {
    @Test
    public void test01(){
        //创建实体类管理工厂
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jap");
        //创建实体管理类
        EntityManager em = factory.createEntityManager();
        //创建事物管理
        EntityTransaction tx = em.getTransaction();
        //开启事物
        tx.begin();
        //创建实体类
        Customer customer = new Customer();
        customer.setCustAddress("西安");
        customer.setCustName("豹子头");
        //保存操作
        em.persist(customer);
        //提交事物
        tx.commit();
        //释放资源
        em.close();
        factory.close();
    }
    @Test
    public void test02(){
        //创建实体类管理工厂
        //创建实体管理类
        EntityManager em = japUtils.getEntityManager();
        //创建事物管理
        EntityTransaction tx = em.getTransaction();
        //开启事物
        tx.begin();
        //创建实体类
        Customer customer = new Customer();
        //添加数据
        customer.setCustAddress("西安");
        customer.setCustName("豹子头");
        //保存操作
        em.persist(customer);
        //提交事物
        tx.commit();
        //释放资源
        em.close();

    }
    @Test
    public void test03(){
        //创建实体类管理工厂
        //创建实体管理类
        EntityManager em = japUtils.getEntityManager();
        //创建事物管理
        EntityTransaction tx = em.getTransaction();
        //开启事物
        tx.begin();
        try {

            //查询
            Customer customer = em.find(Customer.class, 1l);
            System.out.println(customer);
            //保存操作
            em.persist(customer);
            //提交事物
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //释放资源
        em.close();

    }
    @Test
    public void test04(){
        //创建实体类管理工厂
        //创建实体管理类
        EntityManager em = japUtils.getEntityManager();
        //创建事物管理
        EntityTransaction tx = em.getTransaction();
        //开启事物
        tx.begin();
        try {

            //查询
            Customer customer = em.getReference(Customer.class, 1l);
            System.out.println(customer);
            //保存操作
            em.persist(customer);
            //提交事物
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //释放资源
        em.close();

    }
    @Test
    public void test05(){
        //创建实体类管理工厂
        //创建实体管理类
        EntityManager em = japUtils.getEntityManager();
        //创建事物管理
        EntityTransaction tx = em.getTransaction();
        //开启事物
        tx.begin();
        try {

            //查询
            Customer customer = em.find(Customer.class, 6l);
            //删除
            em.remove(customer);

            //提交事物
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //释放资源
        em.close();

    }
    @Test
    public void test06(){
        //创建实体类管理工厂
        //创建实体管理类
        EntityManager em = japUtils.getEntityManager();
        //创建事物管理
        EntityTransaction tx = em.getTransaction();
        //开启事物
        tx.begin();
        try {

            //查询
            Customer customer = em.find(Customer.class, 5l);
            //更新
            customer.setCustPhone("18220577844");
            //更新
            em.merge(customer);

            //提交事物
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //释放资源
        em.close();

    }
    @Test
    public void test07(){
        //创建实体类管理工厂
        //创建实体管理类
        EntityManager em = japUtils.getEntityManager();
        //创建事物管理
        EntityTransaction tx = em.getTransaction();
        //开启事物
        tx.begin();
        try {

            //全部查询
            String jap = "from Customer where custPhone like ?";
            Query query = em.createQuery(jap);
            query.setParameter(1,"182%");
            //分页
            query.setFirstResult(0);//起始条数
            query.setMaxResults(6);//每页条数
            //得到结果
            List list = query.getResultList();
            for (Object o : list) {
                System.out.println(o);
            }


            //提交事物
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //释放资源
        em.close();

    }
    @Test
    public void test08(){
        //创建实体类管理工厂
        //创建实体管理类
        EntityManager em = japUtils.getEntityManager();
        //创建事物管理
        EntityTransaction tx = em.getTransaction();
        //开启事物
        tx.begin();
        try {

            //全部查询
            String jap = "select count(custId)  from Customer";
            Query query = em.createQuery(jap);

            //得到结果
            Object singleResult = query.getSingleResult();
            System.out.println(singleResult);
          /*  List list = query.getResultList();
            for (Object o : list) {
                System.out.println(o);
            }*/


            //提交事物
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //释放资源
        em.close();

    }
}
