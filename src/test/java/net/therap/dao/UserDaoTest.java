package net.therap.dao;

import org.testng.annotations.Test;
import org.unitils.core.Unitils;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.hibernate.HibernateUnitils;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/27/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */

@DataSet
@SpringApplicationContext(value = {"classpath:test-applicationContext.xml"})
public class UserDaoTest extends Unitils {

    @SpringBean("userDao")
    UserDao userDao;

    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }


}
