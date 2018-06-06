package lab4.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lengths")
public class Length {
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    Integer id;
    @Column(name= "original")
    Double original;
    @Column(name="converted")
    Double converted;
    @Column(name="original_type")
    String original_type;
    @Column(name="converted_type")
    String converted_type;
    @Column(name="user")
    String user;
    @Column(name="date")
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getConverted_type() {
        return converted_type;
    }

    public void setConverted_type(String converted_type) {
        this.converted_type = converted_type;
    }

    public String getOriginal_type() {

        return original_type;
    }

    public void setOriginal_type(String original_type) {
        this.original_type = original_type;
    }

    public Double getConverted() {

        return converted;
    }

    public void setConverted(Double converted) {
        this.converted = converted;
    }

    public Double getOriginal() {

        return original;
    }

    public void setOriginal(Double original) {
        this.original = original;
    }

    public Length(Integer id, Double original, Double converted, String original_type, String converted_type, String user, Date date) {
        this.id = id;

        this.original = original;
        this.converted = converted;
        this.original_type = original_type;
        this.converted_type = converted_type;
        this.user = user;
        this.date = date;

    }

    public Length() {

    }


    @Override
    public String toString() {
        return "Length [id = " + id + ", original = " + original  + ", original_type = "
                + original_type + ", converted = " + converted + ", converted_type = " + converted_type
                + ", date = " + date + ", username = " + user + "]";
    }
}