package sql.DB.emp.Bean;


public class Emp {

  private long id;
  private String ename;
  private long jobId;
  private long mgr;
  private java.sql.Date joindate;
  private double salary;
  private double bonus;
  private long deptId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }


  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }


  public long getMgr() {
    return mgr;
  }

  public void setMgr(long mgr) {
    this.mgr = mgr;
  }


  public java.sql.Date getJoindate() {
    return joindate;
  }

  public void setJoindate(java.sql.Date joindate) {
    this.joindate = joindate;
  }


  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }


  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }

  @Override
  public String toString () {
    final StringBuilder sb = new StringBuilder("Emp").append('[')
            .append("id=")
            .append(id)
            .append(",ename=")
            .append(ename)
            .append(",jobId=")
            .append(jobId)
            .append(",mgr=")
            .append(mgr)
            .append(",joindate=")
            .append(joindate)
            .append(",salary=")
            .append(salary)
            .append(",bonus=")
            .append(bonus)
            .append(",deptId=")
            .append(deptId)
            .append(']');
    return sb.toString();
  }
}
