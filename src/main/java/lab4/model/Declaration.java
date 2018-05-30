package lab4.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "declarations")
public class Declaration {
    @Id
    @Column(name = "id")
    String id;
    @Column(name= "date")
    Date date;
    @Column(name="origin_country")
    String origin_country;
    @Column(name="arrival_country")
    String arrival_country;
    @Column(name="amount")
    String amount;
    @Column(name="currency_code")
    String currency_code;
    @Column(name="luggage_info")
    String luggage_info;
    @Column(name="name")
    String name;
    @Column(name="midname")
    String midname;
    @Column(name="lastname")
    String lastname;
    @Column(name="nationality")
    String nationality;

    @Column(name="country")
    String country;
    @Column(name="passport_number")
    String passport_number;
    @Column(name="passport_code")
    String passport_code;

    public String getPassport_code() {
        return passport_code;
    }

    public void setPassport_code(String passport_code) {
        this.passport_code = passport_code;
    }

    public String getPassport_number() {

        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getNationality() {

        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLastname() {

        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMidname() {

        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Declaration() {
    }

    public Declaration(String id, Date date, String origin_country, String arrival_country,
                       String amount, String currency_code, String luggage_info, String name, String midname,
                       String lastname, String passport_code, String passport_number, String country) {
        this.id = id;

        this.date = date;
        this.origin_country = origin_country;
        this.arrival_country = arrival_country;
        this.amount = amount;
        this.currency_code = currency_code;
        this.luggage_info = luggage_info;
        this.name = name;
        this.midname = midname;
        this.lastname = lastname;
        this.passport_code = passport_code;
        this.passport_number = passport_number;
        this.country = country;
    }

    public Declaration(Date date, String origin_country, String arrival_country,
                       String amount, String currency_code, String luggage_info, String name, String midname,
                       String lastname, String passport_code, String passport_number, String country) {
        this.date = date;
        this.origin_country = origin_country;
        this.arrival_country = arrival_country;
        this.amount = amount;
        this.currency_code = currency_code;
        this.luggage_info = luggage_info;
        this.name = name;
        this.midname = midname;
        this.lastname = lastname;
        this.passport_code = passport_code;
        this.passport_number = passport_number;
        this.country = country;
    }

    public String getLuggage_info() {
        return luggage_info;
    }

    public void setLuggage_info(String luggage_info) {
        this.luggage_info = luggage_info;
    }

    public String getCurrency_code() {

        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getAmount() {

        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getArrival_country() {

        return arrival_country;
    }

    public void setArrival_country(String arrival_country) {
        this.arrival_country = arrival_country;
    }

    public String getOrigin_country() {

        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Declaration [id=" + id + ", date=" + date + ", origin_country="
                + origin_country + ", arrival_country=" + arrival_country
                + ", amount=" + amount + ", currency_code" + currency_code
                + ", luggage_info=" + luggage_info + "]";
    }
}