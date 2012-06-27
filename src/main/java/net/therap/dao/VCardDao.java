package net.therap.dao;

import net.therap.domain.VCard;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VCardDao {

    public void saveVCard(VCard vCard);

    public List<VCard> searchVCard(String searchString,int userId);

    public VCard getVCardById(int vCardId);

    public void updateVCard(VCard vCard);

    public void deleteVCard(VCard vCard);

}
