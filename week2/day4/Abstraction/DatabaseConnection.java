package week2.day4.Abstraction;

public interface DatabaseConnection 
{
	void connect();
	void disconnect();
	void executeUpdate();

}