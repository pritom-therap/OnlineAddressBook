package net.therap.dao;

import net.therap.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * user: pritom
 * Date: 6/4/12
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    protected final Logger logger = Logger.getLogger(this.getClass());

    public User getUserbyId(int id) {
        return getHibernateTemplate().load(User.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }


    public void saveUser(User user) {


        Session session = getSession();
        session.saveOrUpdate(user);

        session.flush();
    }


    public List<User> getUsers() {
        String queryString = "from User";

        List<User> users = getHibernateTemplate().find(queryString);
        return users;
    }




}
