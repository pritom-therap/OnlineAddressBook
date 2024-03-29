package net.therap.service.user;

import net.therap.command.LoginCmd;
import net.therap.command.UserCmd;
import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * user: pritom
 * Date: 6/7/12
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {
    protected final Logger logger = Logger.getLogger(this.getClass());

    private UserDao userDao;

    public void saveUser(UserCmd userCmd) {
        User user = new User();

        logger.info("Confirm Password : " + userCmd.getPassword());

        user.setUserName(userCmd.getUserName());
        user.setEmail(userCmd.getEmail());
        user.setPassword(userCmd.getPassword());

        userDao.saveUser(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User authenticate(LoginCmd loginCmd) {

        List<User> users = userDao.getUsers();
        for (User user : users) {
            logger.info("LoginCmd email: " + loginCmd.getEmail() + " user email: " + user.getEmail() + " LoginCmd password: " + loginCmd.getPassword() + " user password: " + user.getPassword());
            if (user.getEmail().equals(loginCmd.getEmail()) && user.getPassword().equals(loginCmd.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(int id) {
        return userDao.getUserbyId(id);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
