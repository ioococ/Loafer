package sql.DB.student.Bean;


public class Student {

  private long id;
  private String name;
  private long age;
  private String sex;
  private String address;
  private long math;
  private long english;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public long getMath() {
    return math;
  }

  public void setMath(long math) {
    this.math = math;
  }


  public long getEnglish() {
    return english;
  }

  public void setEnglish(long english) {
    this.english = english;
  }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("Student").append('[').append("id=").append(id).append(",name=").append(name).append(",age=").append(age).append(",sex=").append(sex).append(",address=").append(address).append(",math=").append(math).append(",english=").append(english).append(']');
        return sb.toString();
    }
}
