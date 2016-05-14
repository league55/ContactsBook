package com.contactsBook.models;

import com.contactsBook.entity.MappedMessege;

import java.util.Date;

/**
 * Created by mixmax on 06.02.16.
 */
public class Messege {

    private Long id;
    private Date time = new Date();
    private String content;
    private Contact sender, reciever;

    public Messege() {
    }

    public Messege(MappedMessege mappedMessege) {
        this.time = mappedMessege.getTime();
        this.content = mappedMessege.getContent();
        this.sender = new Contact(mappedMessege.getSender());
        this.reciever = new Contact(mappedMessege.getReciever());
        this.id = mappedMessege.getId();
    }

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

    public Contact getSender() {
        return sender;
    }

    public void setSender(Contact sender) {
        this.sender = sender;
    }

    public Contact getReciever() {
        return reciever;
    }

    public void setReciever(Contact reciever) {
        this.reciever = reciever;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messege messege = (Messege) o;

        if (time != null ? !time.equals(messege.time) : messege.time != null) return false;
        if (content != null ? !content.equals(messege.content) : messege.content != null) return false;
        if (sender != null ? !sender.equals(messege.sender) : messege.sender != null) return false;
        return reciever != null ? reciever.equals(messege.reciever) : messege.reciever == null;

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (reciever != null ? reciever.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Messege{" +
                "id=" + id +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", sender=" + sender +
                ", reciever=" + reciever +
                '}';
    }
}
