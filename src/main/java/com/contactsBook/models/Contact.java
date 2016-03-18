package com.contactsBook.models;


import com.contactsBook.entity.MappedContact;


public class Contact{



    private String firstName, lastName, tel;

    private Long id;

    public Contact() {
    }

    public Contact(MappedContact mp) {

        this.setFirstName(mp.getFirstName());
        this.setLastName(mp.getLastName());
        this.setTel(mp.getTel());
        this.setId(mp.getContact_id());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        Contact contact = (Contact) o;

        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
        if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;
        if (tel != null ? !tel.equals(contact.tel) : contact.tel != null) return false;
        return id != null ? id.equals(contact.id) : contact.id == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "tel='" + tel + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}