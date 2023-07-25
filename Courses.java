import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;

public class Courses extends JFrame implements ActionListener{
private ArrayList<Course> Courses;
//GUI PART !!
private JLabel name_l; 
private JTextField name_tf; 
private JLabel credits_l; 
private JTextField credits_tf; 
private JLabel slider_grade_l; 
private JSlider slider_grade; 
private JLabel box_grade_l; 
private JComboBox<Integer []> box_grade; 
private JLabel ap_l; 
private JCheckBox ap_check; 
private JButton b_previous; 
private JButton b_next; 
private JButton b_add; 
private JButton b_update; 
private JButton b_clear; 
private JLabel page_l; 
private JLabel page_number_l;
private int index = -1;

// set the page to all the values 
public void setPage(int index){ 
    name_tf.setText(Courses.get(index).getName()); 
    credits_tf.setText(Double.toString(Courses.get(index).getCredits()));
    slider_grade.setValue(Courses.get(index).getGrade());
    box_grade.setSelectedItem(Courses.get(index).getYear());
    ap_check.setSelected(Courses.get(index).getAp());
   // credits_tf.setText(this.get
}

  public Course getCourses(int index){
    return Courses.get(index);
  }

  public void addCourse(Course Course){
    Courses.add(Course);
  }

  public void updateCourse(int index, Course name){
    Courses.set(index, name); //replace course name at the index with this new name.
  }

 

public Courses(ArrayList<Course> Courses) { //GUI 
super("Courses GUI");
this.Courses = Courses;
this.setSize(300,350);
this.setDefaultCloseOperation(EXIT_ON_CLOSE);
this.setLayout(null);


name_l = new JLabel("Course: ");
name_tf = new JTextField();
credits_l = new JLabel("Credits: ");
credits_tf = new JTextField();
slider_grade_l = new JLabel("Grade: ");
slider_grade = new JSlider();

box_grade_l = new JLabel("Grade lvl: ");
Integer [] grade_levels = {9,10,11,12};
box_grade = new JComboBox(grade_levels); 

ap_l = new JLabel("isAP:"); 
ap_check = new JCheckBox(); 

b_previous = new JButton("previous");
b_next = new JButton("next");
b_add = new JButton("add");
b_update = new JButton("update");
b_clear = new JButton("clear");

b_previous.addActionListener(this);
b_next.addActionListener(this);
b_add.addActionListener(this);
b_update.addActionListener(this);
b_clear.addActionListener(this);

page_l = new JLabel("Page:");
page_number_l = new JLabel(" ");

this.getContentPane().add(name_tf);
this.getContentPane().add(credits_tf);
this.getContentPane().add(name_l);
this.getContentPane().add(credits_l);
this.getContentPane().add(slider_grade_l);
this.getContentPane().add(slider_grade);
this.getContentPane().add(box_grade_l);
this.getContentPane().add(ap_l);
this.getContentPane().add(box_grade);
this.getContentPane().add(ap_check);
this.getContentPane().add(b_previous);
this.getContentPane().add(b_add);
this.getContentPane().add(b_next);
this.getContentPane().add(b_update);
this.getContentPane().add(b_clear);
this.getContentPane().add(page_l);
this.getContentPane().add(page_number_l);

box_grade.setEditable(true);
name_tf.setBounds(100, 50, 100, 20);
name_l.setBounds(25,50, 100, 20);
credits_tf.setBounds(100, 75, 50, 20);
credits_l.setBounds(25, 75, 100, 20);
slider_grade_l.setBounds(25, 110, 50, 20);
slider_grade.setBounds(95, 110, 110, 20);
box_grade_l.setBounds(25, 145, 75, 20); 
box_grade.setBounds(100, 145, 75, 20);
ap_l.setBounds(25, 170, 50, 20);
ap_check.setBounds(98, 170, 50, 20);

b_next.setBounds(175, 15, 100, 30);
b_previous.setBounds(45, 15, 100, 30);
b_update.setBounds(45, 220, 100, 30);
b_add.setBounds(175, 220, 100, 30);
b_clear.setBounds(200, 280, 100, 30);

page_l.setBounds(25, 265, 100, 30);
page_number_l.setBounds(75, 265, 100, 30);




if(Courses.size() <= 1) b_add.setEnabled(false);
b_previous.setEnabled(false);
this.setVisible(true); 
}

public void actionPerformed(ActionEvent e){
  if(e.getSource() == b_next){
    index++;
    if(index + 1 == Courses.size()){ // if there is no next course
      b_next.setEnabled(false);
      b_previous.setEnabled(true);
      this.setPage(index);
      
    }
    if(index == 0){ // if there is no previous course (only used after pressing clear)
      b_previous.setEnabled(false);
      this.setPage(index);
    } 

    // sets the page number label
    else{
      this.setPage(index);
      b_previous.setEnabled(true);
    }
    page_number_l.setText(Integer.toString(index));  // 
  }

  if(e.getSource() == b_previous){
    index--; 
    if(index - 1 < 0){ //if the previous index doesn't exist (index can't be < 0)
      b_previous.setEnabled(false);
      this.setPage(index);
    }
    else{
      this.setPage(index);
    }
    b_next.setEnabled(true);

    page_number_l.setText(Integer.toString(index));    

  }

  if(e.getSource() == b_update){ // ask mr.matt why I can't check if something  is blank (its cos im stupid use getSelectedItem not getValue)
    //index is the value of the current class
    if(name_tf.getText() == null){}
    else{
    Courses.get(index).setName(name_tf.getText());
    }

    if(credits_tf.getText() != null){
      Courses.get(index).setCredits(Double.parseDouble(credits_tf.getText()));
    }
    else{ }
    Courses.get(index).setGrade(slider_grade.getValue());

    if(box_grade.getSelectedItem() == null){}
    else{
      Courses.get(index).setYear((Integer)box_grade.getSelectedItem());
    }

    Courses.get(index).setAp(ap_check.isSelected());  
  }

  if(e.getSource() == b_add){
    Double temp_credits = 0.0;
    if(!credits_tf.getText().isEmpty())// if not empty 
    {
      temp_credits = Double.parseDouble(credits_tf.getText());
    }
    else{}
    
    Courses.add(new Course(
      name_tf.getText(),
      temp_credits,
      slider_grade.getValue(), 
      (Integer)box_grade.getSelectedItem(), 
      ap_check.isSelected()
    ));
    if(index < 0) // to offset the index = -1 used when clear and to make sure if they didnt use clear to keep index the same
    index++; 
    this.setPage(0);
  }

  if(e.getSource() == b_clear){
    index = -1;
    b_previous.setEnabled(false);
    b_next.setEnabled(true);
    name_tf.setText("");
    credits_tf.setText("");
    slider_grade.setValue(0);
    box_grade.setSelectedItem("");
    ap_check.setSelected(false);
    page_number_l.setText("");    
  }
}
public static void main(String[] args) {
  
ArrayList <Course> Courses = new ArrayList<>();
Courses.add(new Course("math",10.0, 90, 9, true));
Courses.add(new Course("ELA", 2.5, 50, 12, false));
Courses.add(new Course("History", 25.0, 0, 11, false));

new Courses(Courses); 
  
  }

  

  
}