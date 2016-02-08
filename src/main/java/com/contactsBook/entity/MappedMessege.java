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

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "SENDERID")
    private Long senderId;

    @Column(name = "RECIEVERID")
    private Long recieverId;

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

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Long recieverId) {
        this.recieverId = recieverId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappedMessege that = (MappedMessege) o;

        if (id != that.id) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (senderId != null ? !senderId.equals(that.senderId) : that.senderId != null) return false;
        return recieverId != null ? recieverId.equals(that.recieverId) : that.recieverId == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recieverId != null ? recieverId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MappedMessege{" +
                "id=" + id +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", senderId=" + senderId +
                ", recieverId=" + recieverId +
                '}';
    }

    public int compareTo(MappedMessege o) {
        return getTime().compareTo(o.getTime());
    }
}
