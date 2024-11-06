package week2.day3.polymorphism;

public class APIClientClass 
{
	void sendRequest(String endpoint)
	{
		System.out.println("API EndPoint is : "+endpoint);
	}
	void sendRequest(String endpoint,String requestBody,boolean requestStatus)
	{
		System.out.println("API End Point is : "+endpoint+"Action is : "+requestBody+"Status is : "+requestStatus);																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
	}
	public static void main(String[] args) {
		 APIClientClass api=new APIClientClass();
		 api.sendRequest("https://mail.google.com/");
		 api.sendRequest("https://mail.google.com/", "Compose",true);
	}

}