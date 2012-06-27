package net.therap.service.vcard;

import net.therap.domain.VCard;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/27/12
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class VCardExportImpl implements VCardExport {

    protected final Logger logger = Logger.getLogger(this.getClass());

    public String startVCard() {
        return "BEGIN:VCARD\n";
    }

    public String version(float version) {
        return "VERSION:" + version + "\n";
    }

    public String name(String name) {


        return (name == null) ? "" : "N:" + name + ";\n";
    }

    public String fullName(String fullName) {
        return (fullName == null) ? "" : "FN:" + fullName + "\n";
    }

    public String organization(String org) {
        return (org == null) ? "" : "ORG:" + org + ".\n";
    }

    public String title(String title) {
        return (title == null) ? "" : "TITLE:" + title + "\n";
    }

    public String photo(String photo) {
        return (photo == null) ? "" : "PHOTO:" + photo + "\n";
    }

    public String telWork(String telWork) {
        return (telWork == null) ? "" : "TEL;TYPE=\"work,voice\";VALUE=uri:tel;+" + telWork + "\n";
    }

    public String telHome(String telHome) {
        return (telHome == null) ? "" : "TEL;TYPE=\"home,voice\";VALUE=uri:tel;+" + telHome + "\n";
    }

    public String addresss(String address) {
        return (address == null) ? "" : "ADR;TYPE=work;LABEL=\"" + address + "\"\n";
    }

    public String email(String email) {
        return (email == null) ? "" : "EMAIL:" + email + "\n";
    }

    public String rev(Date rev) {
        return (rev == null) ? "" : "REV:" + rev.toString().replace(" ", "T").replace(":", "").replace("-", "").replace(".", "").concat("Z") + "\n";
    }

    public String endVCard() {
        return "END:VCARD" + "\n\n";
    }

    public String exportVCard(VCard vCard) {
        return startVCard() + version(4.0f) + name(vCard.getName()) + fullName(vCard.getFullName())
                + organization(vCard.getOrg()) + title(vCard.getTitle()) + photo(vCard.getPhotoUrl())
                + telWork(vCard.getTelephoneWork()) + telHome(vCard.getTelephoneHome())
                + addresss(vCard.getAddressWork()) + email(vCard.getEmail()) + rev(vCard.getRev()) + endVCard();
    }


    public VCard importVCard(String importedVCard) {

        VCard vCard = new VCard();
        String[] vCardLines = importedVCard.split("\n");

        int i = 2;

        vCard.setName(vCardLines[i++].substring(2).replace(";", ""));
        vCard.setFullName(vCardLines[i++].substring(3));
        vCard.setOrg(vCardLines[i++].substring(4).replace(".", ""));
        vCard.setTitle(vCardLines[i++].substring(6));
        vCard.setPhotoUrl(vCardLines[i++].substring(6));

        if (vCardLines[i].substring(10).contains("work")) {
            vCard.setTelephoneWork(vCardLines[i++].substring(vCardLines[7].indexOf("+") + 1));
        }

        if (vCardLines[i].substring(10).contains("home")) {
            vCard.setTelephoneHome(vCardLines[i++].substring(vCardLines[8].indexOf("+") + 1));
        }

        vCard.setAddressWork(vCardLines[i++].substring(21).replace("\"", ""));
        while (i < vCardLines.length) {
            if (vCardLines[i].contains("EMAIL")) {
                vCard.setEmail(vCardLines[i].substring(6));
            }
            i++;
        }

        vCard.setRev(new Date());

        return vCard;
    }
}
