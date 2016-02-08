package com.contactsBook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mixmax on 06.02.16.
 */
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


    @Column(name = "SENDER")
    private MappedContact sender;

    @Column(name = "ACCEPTOR")
    private MappedContact acceptor;

    @Column(name = "CONTENT")
    private String content;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public MappedContact getSender() {
        return sender;
    }

    public void setSender(MappedContact sender) {
        this.sender = sender;
    }

    public MappedContact getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(MappedContact acceptor) {
        this.acceptor = acceptor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappedMessege that = (MappedMessege) o;

        if (id != that.id) return false;
        if (!time.equals(that.time)) return false;
        if (sender != null ? !sender.equals(that.sender) : that.sender != null) return false;
        if (acceptor != null ? !acceptor.equals(that.acceptor) : that.acceptor != null) return false;
        return content.equals(that.content);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + time.hashCode();
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (acceptor != null ? acceptor.hashCode() : 0);
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String
    toString() {
        return "MappedMessege{" +
                "id=" + id +
                ", time=" + time +
                ", sender=" + sender +
                ", acceptor=" + acceptor +
                ", content='" + content + '\'' +
                '}';
    }


    public int compareTo(MappedMessege o) {
        return getTime().compareTo(o.getTime());
    }
}
