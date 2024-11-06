package week2.day4.Abstraction;

public abstract class MySqlConnection implements DatabaseConnection
{
	
	abstract void executeQuery();
}