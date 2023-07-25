public class Course{
  private String name; 
  private double credits; 
  private int grade; 
  private int year; 
  private boolean ap; 

  public Course(String name){
    this.name = name; 
  }

  public Course(String name, double credits, int grade, int year, boolean ap){
    this.name = name; 
    this.credits = credits; 
    this.grade = grade; 
    this.year = year; 
    this.ap = ap; 
  }

  //setters
  public void setName(String new_name){
    this.name = new_name;}
  
  public void setCredits(double new_credits){
    this.credits = new_credits;}
  
  public void setGrade(int new_grade){
    this.grade = new_grade;} 
  
  public void setYear(int new_year){
    this.year = new_year;}
  
  public void setAp(boolean new_ap){
    this.ap= new_ap;}
  

  //getters 
  public String getName(){ return this.name;}
  
  public double getCredits(){ return this.credits;}
  
  public int getGrade(){ return this.grade;}
  
  public int getYear(){ return this.year;}
  
  public boolean getAp(){ return this.ap;}
  

  
}