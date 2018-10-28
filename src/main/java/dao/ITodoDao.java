package dao;

import java.util.ArrayList;

import model.Todo;

public interface ITodoDao {
	public void create (Todo todo);
	public void update(Todo todo);
	public ArrayList<Todo> retrieve();
	public void delete(Integer id);
}
