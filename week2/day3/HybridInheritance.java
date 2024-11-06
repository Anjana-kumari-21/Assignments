package week2.day3;

class WebElement {
//base class
	
	void click()
	{
		System.out.println("click the web element");
	}
	void setText(String text)
	{
		System.out.println("send the value "+text);
	}
}
class TextField extends WebElement
{
//sub class level 1
	void getText()
	{
		System.out.println("Get text of the element");
	}
}
class Button extends WebElement
{
	//sub class level 1
	 void submit()
	 {
		 System.out.println("click the submit button");
	 }

}


class RadioButton extends Button
{
	//sub class level 2
	void selectRadioButton()
	{
		System.out.println("select the radio button");
	}

}
class CheckBoxButton extends Button
{
	//sub class level 2
	void clickCheckButton()
	{
		System.out.println("Click the checkbox button");
	}

}

public class HybridInheritance extends Button{

	//Execution class
	public static void main(String[] args) {
		
		//object creation for the subclass and call the methods 
		HybridInheritance ele=new HybridInheritance();
		ele.click(); //from base class
		ele.setText(null); //from base class
		ele.submit();//from subclass level 1
		
		//object creation for the subclass and call the methods 
		RadioButton rb=new RadioButton();
		rb.click(); //from base class
		rb.setText("from radio class");//from base class
		rb.submit();//from subclass level 1
		rb.selectRadioButton();//from sub class level 2
		
		
		
		//object creation for the sub class and call the methods
		CheckBoxButton cb=new CheckBoxButton();
		cb.click(); // from base class
		cb.setText("from checkbox class");//from base class
		cb.submit();// from subclass level 1
		cb.clickCheckButton();//from subclass level2
		
		//object creation for the sub class and call the methods
		TextField tf=new TextField();
		tf.click();
		tf.setText("from text field");
		tf.getText();
		

	}

}