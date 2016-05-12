package com.contactsBook.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "MappedContact")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MappedContact implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Size(max = 15, message = "Name must be shorter then 15 symbols")
    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "FIRSTNAME")
    private String firstName;

    @Size(max = 15, message = "Lastname must be shorter then 15 symbols")
    @NotEmpty(message = "Lastname cannot be empty")
    @Column(name = "LASTNAME")
    private String lastName;

    @Size(min = 9, max = 12, message = "Phone must be from 9 to 11 characters")
    @NotNull(message = "Phone cannot be empty")
    @Column(name = "TEL")
    private String tel;


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

        MappedContact that = (MappedContact) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return tel.equals(that.tel);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + tel.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MappedContact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}