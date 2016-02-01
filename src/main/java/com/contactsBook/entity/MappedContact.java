package com.contactsBook.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MappedContact")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MappedContact implements Serializable {
    @Id
    @Column(name = "CONTACT_ID")
    private long contact_id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "TEL")
    private String tel;

    public MappedContact(long contact_id, String firstName, String lastName, String tel) {
        this.contact_id = contact_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel=tel;


    }

    public MappedContact(String firstName, String lastName, String tel) {
        this.firstName = firstName;
        this.lastName = lastName;
        setTel(tel);


    }

    public MappedContact() {
    }



    public long getContact_id() {
        return contact_id;
    }



    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }



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
  this.tel = tel;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappedContact mappedContact = (MappedContact) o;

        if (contact_id != mappedContact.contact_id) return false;
        if (firstName != null ? !firstName.equals(mappedContact.firstName) : mappedContact.firstName != null) return false;
        if (lastName != null ? !lastName.equals(mappedContact.lastName) : mappedContact.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = contact_id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return (int) result;
    }

    @Override
    public String toString() {
        return "MappedContact{" +
                "id='" + getContact_id() +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", tel=" + getTel() +
                '}';
    }
}