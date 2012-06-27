package net.therap.dao;

import net.therap.domain.VCard;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardDaoImpl extends HibernateDaoSupport implements VCardDao {

    public void saveVCard(VCard vCard) {

        Session session = getSession();
        session.saveOrUpdate(vCard);
        session.flush();
    }

    public List<VCard> searchVCard(String searchString, int userId) {

        Session session = getSession();
        Query query = session.createQuery("from VCard where lower(fullName) like '%" + searchString + "%' and user.userId=" + userId + "");
        List<VCard> vCardList = (List<VCard>) query.list();

        return vCardList;
    }

    public VCard getVCardById(int vCardId) {
        return getHibernateTemplate().load(VCard.class, vCardId);
    }

    public void updateVCard(VCard vCard) {
        Session session = getSession();
        session.merge(vCard);
    }

    public void deleteVCard(VCard vCard) {
        Session session = getSession();
        session.delete(vCard);
        session.flush();
    }
}
