package lab4.model;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "girls")
public class Girl {
    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "age")
    Integer age;
    @Column(name="name")
    String name;


    public Girl(){}

    public Girl(Integer id, Integer age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    public Integer getAge() {

        return age;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "Declaration [id=" + id + ", age=" + age + ", name="
                + name + "]";
    }
}
