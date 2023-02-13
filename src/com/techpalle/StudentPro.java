package com.techpalle;

import java.sql.*;


public class StudentPro 
{
	public static Connection con=null;
	public static Statement s=null;
	public static PreparedStatement ps=null;
	
	public static final String classname="com.mysql.cj.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/palle";
	public static final String username="root";            
	public static final String password="admin";
	
	 
   public void creating() 
   {
	       
				try 
				{
					Class.forName(classname);
					con=DriverManager.getConnection(url,username,password);
				    
					s=con.createStatement();
					
					s.executeUpdate("create table student(sno int primary key  auto_increment,"
							+ "sname varchar(40) ,sub varchar(40),email varchar(80) )");
						              
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (SQLException e) 
				{
				    e.printStackTrace();
				}
				finally
				{
			        try 
			        {
			        	if(s!=null)
			        	{
			        		s.close();
			        	}
			        	if(con!=null)
			        	{
			        		con.close();
			        	}
			        	
			        }
				    catch (SQLException e) 
			        {
					  e.printStackTrace();
					}
				}
   }
   public void inserting(String name,String subject,String mailid) 
  	{
  		   try 
            {
				Class.forName(classname);
				con=DriverManager.getConnection(url,username,password);
	  			
	  			ps=con.prepareStatement("insert into student(sname,sub,email) values (?,?,?)");
	  			ps.setString(1,name);
	  			ps.setString(2,subject);
	  			ps.setString(3, mailid);
	  			
	  			ps.executeUpdate();
			} 
            catch (ClassNotFoundException e) 
            {
				e.printStackTrace();
			} 
            catch (SQLException e) 
            {
				e.printStackTrace();
			}
  		   finally
			{
		        try 
		        {
		        	if(ps!=null)
		        	{
		        		ps.close();
		        	}
		        	if(con!=null)
		        	{
		        		con.close();
		        	}
		        	
		        }
			    catch (SQLException e) 
		        {
				  e.printStackTrace();
				}
			}
   }
   public void updating(int no,String subject,String mailid)
   {
	   try 
	   {
		Class.forName(classname);
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("update student set sub=? ,email=?  where sno=?");
	    ps.setString(1,subject );
		ps.setString(2, mailid);
	    ps.setInt(3,no );
	    ps.executeUpdate();
	   } 
	   catch (ClassNotFoundException e) 
	   {
	     e.printStackTrace();
	   } 
	   catch (SQLException e) 
	   {
		e.printStackTrace();
	   }
	   finally
	   {
           try 
	       {
	    	   if(ps!=null)
	    	   {
	    		   ps.close();  
	    	   }
	    	   if(con!=null)
	    	   {
	    		  con.close();
	    	   }
	       }
		  catch (SQLException e) 
	       {
	        e.printStackTrace();
	       }
	   }
	   
   }
   public void delete(int no)
   {
	   try 
	   {
		Class.forName(classname);
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("delete from student where sno=?");
		ps.setInt(1, no);
		ps.executeUpdate();
      } 
	  catch (ClassNotFoundException e) 
	  {
		e.printStackTrace();
	  } 
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally
	  {
	     try 
	     {
		  if(ps!=null)
		  {
			  ps.close(); 
		  }
		  if(con!=null)
		  {
			  con.close();
		  }
         }
	     catch (SQLException e) 
	     {
		   e.printStackTrace();
	     }
	  }
  }
   public void read()
   {
	   try 
	   {
		Class.forName(classname);
		con=DriverManager.getConnection(url,username,password);
		s=con.createStatement();
		String qry="select * from student";
		ResultSet rs=s.executeQuery(qry);
		while(rs.next()==true)
		{
			System.out.println(rs.getInt("sno"));
			System.out.println(rs.getString("sname"));
			System.out.println(rs.getString("sub"));
			System.out.println(rs.getString("email"));
		}
	  }
	  catch (ClassNotFoundException e) 
	  {
		e.printStackTrace();
	  } 
	  catch (SQLException e) 
	  {
	    e.printStackTrace();
	  }
	  finally
	  {
	     try
	     {
	     	 if(s!=null)
	    	 {
	    		 s.close(); 
	    	 }
	    	 if(con!=null)
	    	 {
	    		 con.close();
	    	 }
	      }
	     catch (SQLException e) 
	     {
		   e.printStackTrace();
	     }
	  }
	   
   }
  /* public static ArrayList<StudentCon> reading()
   {
	   ArrayList<StudentCon> alStud=new ArrayList<StudentCon>();
	   try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		    s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from Student");
			while(rs.next()==true)
		     {
		          int no=rs.getInt("sno");
		          String name=rs.getString("sname");
		          String subject=rs.getString("sub");
		          String emailid=rs.getString("email");
		          //how many rows that many department obj so inside loop
		          StudentCon s=new StudentCon(no,name,subject,emailid);
		         //constructor obj created thn it ll added into A.L
		          alStud.add(s);
		       }
        } 
		catch (ClassNotFoundException e) 
		{
		 e.printStackTrace();
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		finally
		{
		   try 
		     {
			    if(s!=null)
			    {
			     s.close();
			    }
			    if(con!=null)
			    {
			     con.close();
			    }
		      } 
		   catch (SQLException e) 
		      {
			   e.printStackTrace();
		      }
		 }
		return  alStud;
	  
    }*/
 }
   

