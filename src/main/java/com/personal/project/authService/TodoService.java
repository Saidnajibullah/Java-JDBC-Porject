package com.personal.project.authService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.personal.project.model.Todo;
import com.personal.project.util.ConnectionFactory;

public class TodoService {
	
	//using this instead of normal arrayList to support concurrency
	// https://www.programcreek.com/2014/01/java-util-concurrentmodificationexception/
	//private static List<Todo> toDoList = new CopyOnWriteArrayList<Todo>();
	
//	{
//		toDoList.add(new Todo("Programing", "Develope a Java web application"));
//		toDoList.add(new Todo("Testing", "Test a Java web application"));
//		toDoList.add(new Todo("Deploying", "Deploy a Java web application"));
//		toDoList.add(new Todo("Maintaining", "Maintain a Java web application"));
//
//	}
//	
	public List<Todo> getTodos(){
		Connection conn = ConnectionFactory.getConnection();
		List<Todo> toDoList = new CopyOnWriteArrayList<Todo>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from todo_list");
			while(rs.next()) {
				toDoList.add(new Todo(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("task")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toDoList;   
	}
	
	public void addTodo(Todo newTodo) {
		Connection conn = ConnectionFactory.getConnection();
		String query = "insert into todo_list (name, task) values(?, ?)";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, newTodo.getName());
			st.setString(2, newTodo.getTask());
			st.execute();  
			System.out.println(newTodo.getName());
		} catch (SQLException e) {
			e.printStackTrace();  
		}
	}
	public void deleteTodo(int id) {
		Connection conn = ConnectionFactory.getConnection();
		try {
			String query = "delete from todo_list where id = " + id;
			Statement st;
			st = conn.createStatement();
			st.executeUpdate(query);   
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
