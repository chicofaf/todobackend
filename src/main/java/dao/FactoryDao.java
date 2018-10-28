package dao;

public class FactoryDao {
	
	
	public static ITodoDao getTododao(){
		return new TodoDaoImpl();
	}
}
