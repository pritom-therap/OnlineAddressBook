package net.therap.service.vcard;

import net.therap.domain.VCard;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/27/12
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public interface VCardExport {

    public String startVCard();

    public String version(float version);

    public String name(String name) ;

    public String fullName(String fullName);

    public String organization(String org);

    public String title(String title);

    public String photo(String photo);

    public String telWork(String telWork);

    public String telHome(String telHome);

    public String addresss(String address);

    public String email(String email);

    public String rev(Date rev);

    public String endVCard();

    public String exportVCard(VCard vCard);


    public VCard importVCard(String importedVCard);

}
