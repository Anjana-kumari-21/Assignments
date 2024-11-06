package week2.day4.Interface;

public class JavaConnection implements DatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaConnection con=new JavaConnection ();
		con.connect();
		con.executeUpdate();
		con.disconnect();
	}

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
		System.out.println("Update query is executed");
		
	}

}