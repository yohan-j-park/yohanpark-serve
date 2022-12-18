package dynamicSql;

public class DynamicVo {
    int employeeNumber=0;
    String lastName="";
    String firstName="";
    String extension="";
    String email="";
    int officeCode=0;
    int reportsTo=0;
    String jobTitle="";
    
    
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getOfficeCode() {
        return officeCode;
    }
    public void setOfficeCode(int officeCode) {
        this.officeCode = officeCode;
    }
    public int getReportsTo() {
        return reportsTo;
    }
    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    
}
