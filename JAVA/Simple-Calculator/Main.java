package application;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Stack;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {

	/*The keyboard key values*/
	private static final String[][] key_values = {
			{ "7", "8", "9", "/" },
			{ "4", "5", "6", "*" },
			{ "1", "2", "3", "-" },
			{ "0", "c", "=", "+" }
	};
	private Button btn[][] = new Button[4][4]; //all the keys
	TextField calculator_screen;  //the calculator screen

	DecimalFormat dec_format = new DecimalFormat("#.####");
	boolean needReset;
	int flag=0;//,repeat=0;
	String exp;
	String temp;
	String sample = "0";
	String sample2 = "0";
	Double num1=0.0,num2=0.0;
	Double temp_sum=0.0;
	Stack <String>stack = new Stack<>();
	Stack <String>stack_new = new Stack<>();
	public static void main(String[] args) 
	{ 
		launch(args);
	}


	@Override public void start(Stage stage) {

		/*The outside layout*/
		final VBox layout = new VBox(30); //the size vertically

		/*The inside layout for keys or buttons*/
		TilePane keypad = new TilePane(); //even it is called keypad, it is a layout
		keypad.setVgap(7);
		keypad.setHgap(7); //set the gap between keys


		/*Create Calculator Screen */
		calculator_screen =  new TextField();
		calculator_screen.setStyle("-fx-background-color: #FFFFFF;"); //set the style of the screen
		calculator_screen.setAlignment(Pos.CENTER_RIGHT); //make the screen in the center of the calculator
		calculator_screen.setEditable(false); //make sure the screen cannot be typed in manually
		

		/*Create Calculator keyboard*/
		keypad.setPrefColumns(key_values[0].length); //set the preferred number of columns

		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 4; j++) 
			{
				btn[i][j] = new Button(key_values[i][j]);
				final int a = i;
				final int b = j;

				/*Add button event*/
				btn[i][j].setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {

						if(needReset==true)
						{	
							calculator_screen.setText("");
							needReset=false;
						}
						calculator_screen.setStyle("-fx-text-fill: black;");
						calculator_screen.appendText(key_values[a][b]);
						exp = calculator_screen.getText().toString();
					}
					
			}
						);
				
				keypad.getChildren().add(btn[i][j]);
			}
		}
		
		
		//-----------------WHEN CLEAR BUTTON IS CLICKED-----------------------
				
		btn[3][1].setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						calculator_screen.setText("");
					}
			
				});
		
		
		//---------------------WHEN "=" IS CLICKED----------------------
		
		btn[3][2].setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				flag =0;
				temp_sum=0.0;
				needReset=true;
				exp = exp+"\n";
				char [] ch = exp.toCharArray();
				int len = ch.length;
				int i=0;
				
				while(!stack_new.isEmpty())
					stack_new.pop();
				
				for(int j=0;j<len;j++)
				{
					if(ch[j]>='0' && ch[j]<='9')
					{
						i=j;
						sample = "0";
						while(ch[i]>='0' && ch[i]<='9' && i < len)//To check if there is a more than 1 digit nummber.
						{
							if(ch[i]>='0' && ch[i]<='9')
							{
								sample = sample+exp.charAt(i);
								i++;
							}
						}
						stack.push(sample);
						j=i-1;
					}
					else
					{
						stack.push(Character.toString(ch[i]));
					}
				}
				temp=stack.pop();
				int size= stack.size();
				
				//-----------Reversing the order of the stack-------------
				
				while(!stack.isEmpty())
				{
					sample2=stack.pop();
					stack_new.push(sample2);
				}
					
				//-----------Evaluating the expression--------------------
				
				while(!stack_new.isEmpty())
				{
					
					calculator_screen.setStyle("-fx-text-fill: black;");
					temp=stack_new.peek();
					int type =checkString(temp) ;
					
					if(size==1)
					{
						flag=1;
						break;
					}
					if(type == 0)
					{
						num1 = Double.parseDouble(temp);
						stack_new.pop();
					}
					else if(type ==5)
					{
						flag=1;
						break;
					}
					else
					{
						int op=checkString(temp);
						stack_new.pop();
						try
						{
							temp=stack_new.peek();
						}
						catch(EmptyStackException e)
						{
							
						}
						type =checkString(temp) ;
						if(type!=0)
						{
							flag=1;
							break;
						}
						else
						{
							
							num2=Double.parseDouble(temp);
							if(op==1)
							{
								temp_sum=num1+num2;
								}
							else if(op==2)
							{
								temp_sum=num1-num2;
								}
							else if(op==3)
							{
								temp_sum=num1*num2;
							}
							else
							{
								if(num2!=0)
								{
									temp_sum=num1/num2;
								}
								else
								{
									flag=1;
									break;
								}
							}
							num1=temp_sum;
						}
						if(size!=0)
							stack_new.pop();
					}

				}
				
				if(flag==0)
					calculator_screen.setText(dec_format.format(temp_sum).toString());// Display upto 4 decimal places
				else if(flag==1)
				{
					calculator_screen.setText("Error");
					calculator_screen.setStyle("-fx-text-fill: red;");
					
				}
				
			}
			
			public int checkString(String temp) {
				// TODO Auto-generated method stub
				
			if(temp.length()==1)
			{
				char ch=temp.charAt(0);
				if(ch=='+')
					return 1;
				else if(ch=='-')
					return 2;
				else if(ch=='*')
					return 3;
				else if(ch=='/')
					return 4;
				else 
					return 5;
			}
			else
				return 0;
			}

		});



		/*Put the calculator screen and keypad into a VBox layout*/
		layout.setAlignment(Pos.CENTER);
		//layout.setStyle("-fx-background-color: #797983; -fx-padding: 20; -fx-font-size: 20;");
		layout.getChildren().addAll(calculator_screen, keypad);
		calculator_screen.prefWidthProperty().bind(keypad.widthProperty());


		/*Show the window*/
		stage.setTitle("Calculator");
		stage.initStyle(StageStyle.UTILITY);
		stage.setResizable(false);
		Scene scene = new Scene(layout);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

}
