package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Todo;

public class TodoDaoImpl implements ITodoDao{

	public void create(Todo todo) {
		Connection conn = ConexaoBanco.conexao();
		try {
			try {
				String sql = "insert into todo(titulo, descricao) values (?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, todo.getTitulo());
				ps.setString(2, todo.getDescricao());
				ps.execute();
			} finally {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro : " + e.getMessage());
		}

	}

	public void update(Todo todo) {
		Connection conn = ConexaoBanco.conexao();
		try {
			try {
				String sql = "update todo set titulo = ?, descricao = ?, status = ? where id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, todo.getTitulo());
				ps.setString(2, todo.getDescricao());
				ps.setInt(3,todo.getStatus());
				ps.setInt(4, todo.getId());
				ps.executeUpdate();
			} finally {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}
	

	public ArrayList<Todo> retrieve() {
		ArrayList<Todo> todoList = new ArrayList<Todo>();
		Connection conn = ConexaoBanco.conexao();
		try {
			try {
				String sql = "select * from todo";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					Todo todo = new Todo();
					todo.setId(rs.getInt("id"));
					todo.setTitulo(rs.getString("titulo"));
					todo.setDescricao(rs.getString("descricao"));
					todo.setStatus(rs.getInt("status"));
					todoList.add(todo);
				}
				return todoList;
			} finally {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro : " + e.getMessage());
		}
		return todoList;
	}

	public void delete(Integer id) {
		Connection conn = ConexaoBanco.conexao();
		try {
			try {
				String sql = "delete from todo where id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			} finally {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}
}
