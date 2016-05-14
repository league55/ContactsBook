package com.contactsBook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MappedMessege")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MappedMessege implements Serializable, Comparable<MappedMessege> {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "TIME")
    private Date time;

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne
    private MappedContact sender;

    @ManyToOne
    private MappedContact reciever;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MappedContact getSender() {
        return sender;
    }

    public void setSender(MappedContact sender) {
        this.sender = sender;
    }

    public MappedContact getReciever() {
        return reciever;
    }

    public void setReciever(MappedContact reciever) {
        this.reciever = reciever;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MappedMessege{" +
                "id=" + id +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", sender=" + sender +
                ", reciever=" + reciever +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappedMessege that = (MappedMessege) o;

        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (sender != null ? !sender.equals(that.sender) : that.sender != null) return false;
        return reciever != null ? reciever.equals(that.reciever) : that.reciever == null;

    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (reciever != null ? reciever.hashCode() : 0);
        return result;
    }

    public int compareTo(MappedMessege o) {
        return getTime().compareTo(o.getTime());
    }

}
