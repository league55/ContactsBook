package com.contactsBook.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

@Entity
@Table(name = "CONTACT2")
public class Contact implements Serializable {

    private long contact_id;

    private String firstName, lastName, tel;
    private HashSet<Integer> idSet = new HashSet<Integer>();
    private HashSet<String> telSet = new HashSet<String>();

    public Contact(long contact_id, String firstName, String lastName, String tel) {
        this.firstName = firstName;
        this.lastName = lastName;
        setTel(tel);
        setContact_id(contact_id);

    }

    public Contact(String firstName, String lastName, String tel) {
        this.firstName = firstName;
        this.lastName = lastName;
        setTel(tel);


    }

    public Contact() {


    }


    @Id
    @GeneratedValue
    @Column(name = "CONTACT_ID")
    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long id) {
        this.contact_id = id;
    }

    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        if (telSet.contains(tel)) {
            System.out.println("NOT UNIQUE TEL NUM");
        } else {
            this.tel = tel;
            telSet.add(tel);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contact_id != contact.contact_id) return false;
        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
        if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (contact_id ^ (contact_id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + tel.hashCode();
        result = 31 * result + (idSet != null ? idSet.hashCode() : 0);
        result = 31 * result + (telSet != null ? telSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "\n MappedContact[id=%d, firstName='%s', lastName='%s'] ",
                contact_id, firstName, lastName);
    }
}