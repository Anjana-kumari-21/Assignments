package week2.day4.Abstraction;

public class JavaConnection extends MySqlConnection{

	
	@Override
	public void connect() {
		System.out.println("Connecting database");
		
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnecting database");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Executing update query");
		
	}

	@Override
	void executeQuery() {
		System.out.println("Executing select query");
		
	}
	public static void main(String[] args) {
		JavaConnection jc=new JavaConnection();
		jc.connect();
		jc.executeUpdate();
		jc.executeQuery();
		jc.disconnect();

	}

}