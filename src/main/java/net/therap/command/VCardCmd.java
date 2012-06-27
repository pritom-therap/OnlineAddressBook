package net.therap.command;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardCmd {

    private String name;
    private String fullName;
    private String org;
    private String title;
    private String photoUrl;
    private String telephoneWork;
    private String telephoneHome;
    private String addressWork;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTelephoneWork() {
        return telephoneWork;
    }

    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    public String getTelephoneHome() {
        return telephoneHome;
    }

    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    public String getAddressWork() {
        return addressWork;
    }

    public void setAddressWork(String addressWork) {
        this.addressWork = addressWork;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
