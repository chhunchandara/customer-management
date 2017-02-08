package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;

public class C_CUSTOMER extends CLS_MYSQLDB {
private int	cus_id  ;
private String	cus_first_name;
private String	cus_last_name ;
private String	cus_gender ;
private String	cus_email_address ;
private Date cus_DOB = new Date();
private String	cus_address; 
private String	cus_phoneNumber;
private Date	date_created;
private Date	date_updated;

public String get_onecus(){
  String str = "a=" + this.cus_id  
  				+ "&b=" + this.cus_first_name
  				+ "&c=" + this.cus_last_name 
  				+ "&d=" + this.cus_gender
  				+ "&e=" + this.cus_email_address 
  				+ "&f=" + this.cus_DOB 
  				+ "&g=%27" + this.cus_address 
  				+ "%27&h=" + this.cus_phoneNumber
  				+ "&i=" + this.date_created
  				+ "&j=" + this.date_updated;
  return str;
}

public void set_cus_id(int id1){
	this.cus_id = id1;
}
public int get_cus_id(){
	return this.cus_id;
}
public void set_cus_first_name(String fname){
	this.cus_first_name = fname;
}
public String get_cus_first_name(){
	return this.cus_first_name;
}
public void set_cus_last_name(String lname){
	this.cus_last_name = lname;
}
public String get_cus_last_name(){
	return this.cus_last_name;
}
public void set_cus_gender(String gender1){
	this.cus_gender = gender1;
}
public String get_cus_gender(){
	return this.cus_gender;
}

public void set_cus_email_address(String email){
	this.cus_email_address = email;
}
public String get_cus_email_address(){
	return this.cus_email_address;
}

public void set_cus_phoneNumber(String phone){
	this.cus_phoneNumber = phone;
}
public String get_cus_phoneNumber(){
	return this.cus_phoneNumber;
}

public void set_date_updated(Date date1){
         this.date_updated = date1;
}
public Date get_date_updated(){
	return this.date_updated;
}

public void set_date_created(Date date1){
         this.date_created = date1;
}
public Date get_date_created(){
	return this.date_created;
}
public void set_cus_DOB(Date cus_DOB1 ){
         this.cus_DOB = cus_DOB1;
}
public Date get_cus_DOB(){
	return this.cus_DOB;
}
public void set_cus_address(String address){
	this.cus_address = address;
}
public String get_cus_address(){
	return this.cus_address;
}
//-----------------------------constructor------------------------
public C_CUSTOMER(){}

public C_CUSTOMER(
					String cus_first_name,
					String cus_last_name ,
					String cus_gender ,
					String cus_email_address,
					Date cus_DOB,
					String cus_address,
					String cus_phoneNumber
				)
{
	this.set_cus_first_name(cus_first_name);
	this.set_cus_last_name(cus_last_name);
	this.set_cus_gender(cus_gender);
	this.set_cus_email_address(cus_email_address);
	this.set_cus_DOB(cus_DOB);
	this.set_cus_address(cus_address);
	this.set_cus_phoneNumber(cus_phoneNumber);
	
	Date date_created1 = new java.util.Date();  
	this.set_date_created(date_created1);
	
	try
	{
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date_updated1 = formatter.parse("1970-01-01 00:00:00"); 
	this.set_date_updated(date_updated1);
	}
	catch(Exception e)
	{}
	
}
//-----------------------------method insert------------------------

public void insert_customer(){
try{
	Connection conn = get_connection();
String sql = "INSERT INTO td_customer ("
		+ "cus_first_name,"
		+ "cus_last_name ,"
		+ "cus_gender ,"
		+ "cus_email_address,"
		+ "cus_DOB,"
		+ "cus_address,"
		+ "cus_phoneNumber,"
		+ "date_created,"
		+ "date_updated"
		+ ") "
		+ "VALUES (?,?,?,?,?,?,?,?,?)";

	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setString(1, this.cus_first_name);
	statement.setString(2,  this.cus_last_name);
	statement.setString(3, this.cus_gender );
	statement.setString(4, this.cus_email_address );
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	statement.setDate(5, java.sql.Date.valueOf( formatter.format(cus_DOB)));
	statement.setString(6, this.cus_address);
	statement.setString(7, this.cus_phoneNumber );
	formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	statement.setTimestamp(8, java.sql.Timestamp.valueOf(formatter.format(this.date_created)));
	statement.setTimestamp(9, java.sql.Timestamp.valueOf(formatter.format(this.date_updated)));

	int rowsInserted = statement.executeUpdate();
	if (rowsInserted > 0) {
		System.out.println("A new customer was inserted successfully!");
	}
conn.close();
}
catch(Exception e){
	e.printStackTrace();
}
}

//-----------------------------method update------------------------

//public void update_customer(int c_id){
public void update_customer(){
try{
	Connection conn = get_connection();
String sql = "UPDATE td_customer "
		+ "set cus_first_name=?,"
		+ "cus_last_name=?,"
		+ "cus_gender=?,"
		+ "cus_email_address=?,"
		+ "cus_DOB=?,"
		+ "cus_address=?,"
		+ "cus_phoneNumber=?,"
		+ "date_updated=?"
		+ " where cus_id=?";

	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setString(1, this.cus_first_name);
	statement.setString(2,  this.cus_last_name);
	statement.setString(3, this.cus_gender );
	statement.setString(4, this.cus_email_address );
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	statement.setDate(5, java.sql.Date.valueOf(formatter.format(cus_DOB)));
	statement.setString(6, this.cus_address);
	statement.setString(7, this.cus_phoneNumber );
	Date dateU = new Date();
	this.set_date_updated(dateU);
	formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	statement.setTimestamp(8, java.sql.Timestamp.valueOf(formatter.format(this.date_updated)));
	//statement.setInt(9, c_id);
	statement.setInt(9, this.cus_id);

	int rowsInserted = statement.executeUpdate();
	if (rowsInserted > 0) {
		System.out.println("A existing customer was updated successfully!");
	}
conn.close();
}
catch(Exception e){
	e.printStackTrace();
}
}

//-----------------------------method delete------------------------

public void delete_customer(){
try{
	Connection conn = get_connection();
String sql = "DELETE from td_customer where cus_id=?";

	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setInt(1, this.cus_id);

	int rowsInserted = statement.executeUpdate();
	if (rowsInserted > 0) {
		System.out.println("A existing customer was deleted successfully!");
	}
conn.close();
}
catch(Exception e){
	e.printStackTrace();
}
}

//-----------------------------method select------------------------

public void select_customer(int c_id){
try{
	Connection conn = get_connection();
	String sql="" ;
	if (c_id != 0){
		sql= "SELECT * from td_customer where cus_id = ?";
	}
	else
	{
		sql= "SELECT * from td_customer where cus_id <> ?";
	}
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setInt(1, c_id);
	ResultSet result = statement.executeQuery();
	

 
int count = 0;
 
while (result.next()){
	int cus_id1 = result.getInt(1);
    String cus_first_name1 = result.getString(2);
    String cus_last_name1 = result.getString(3);
    System.out.println(cus_id1 + "," + cus_first_name1 + "," + cus_last_name1);
	}
conn.close();
}
catch(Exception e){
	e.printStackTrace();
}
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	
}

}



