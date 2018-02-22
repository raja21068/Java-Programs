class Employee{
  // Variables declaration - do not modify
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee() {}
    public Employee(String firstName, String lastName, int salary){
this.firstName = firstName;
this.lastName = lastName;
this.salary = salary;}



//Setter Methods Generated
    public void setId(int id){
        this.id = id ;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName ;
    }
    public void setLastName(String lastName){
        this.lastName = lastName ;
    }
    public void setSalary(int salary){
        this.salary = salary ;
    }




//Getter Methods Generated
    public int getId(){
        return this.id ;
    }
    public String getFirstName(){
        return this.firstName ;
    }
    public String getLastName(){
        return this.lastName ;
    }
    public int getSalary(){
        return this.salary ;
    }

    public String toString(){
        return firstName;
       }
}
