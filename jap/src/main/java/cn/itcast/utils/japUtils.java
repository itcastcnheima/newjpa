package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class japUtils {
    private static  EntityManagerFactory factory=null;
    static {
        //创建实体类管理工厂
         factory = Persistence.createEntityManagerFactory("jap");
        //创建实体管理类
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
