import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ForestMain {
	private static Scanner keyboard = new Scanner(System.in);
	private static Forest forest;
	public static void main(String args[])
	{
		//--------Input from the user
		char input;
		do
		{
			//Displaying the options
			System.out.print("(D)isplay, (N)ew, (Y)ear, (R)eap, (S)ave, (L)oad, e(X)it :");
			//Getting the input from the user
			input = keyboard.next().charAt(0);
			switch(input)
			{
				//Displays forest
				case 'd':
				case 'D':
				{
					if(forest == null)
					{
						System.out.println("No forest");
						System.out.println("");
					}
					else
					{
						System.out.println(forest.toString());
					}
					break;
				}
				//Creates a new forest
				case 'N':
				case 'n':
				{
					System.out.print("What is the forest name : ");
					keyboard.nextLine();
					String temp = keyboard.nextLine();
					forest = new Forest(temp);
					break;
				}
				//Grows the trees for 1 year
				case 'Y':
				case 'y':
				{
					forest.growth();
					break;
				}
				//Reaps the forest
				case 'R':
				case 'r':
				{
					double reap;
					System.out.println("What height to reap at  : ");
					reap = keyboard.nextDouble();
					forest.reap(reap);
					break;
				}
				//Saves the forest
				case 'S':
				case 's':
				{
					if (forest != null)
					{
						try
						{
							FileOutputStream fout = new FileOutputStream(forest.name + ".txt");
							ObjectOutputStream forestout = new ObjectOutputStream(fout);
							forestout.writeObject(forest);
							forestout.close();
						}catch(Exception e)
								{
									System.out.println("ERROR: Did not save.");
								}
					}
					break;
				}
				//Loads the forest
				case 'L':
				case 'l':
				{
					try
					{
					String temp;
					System.out.println("What is the forest name : ");
					keyboard.nextLine();
					temp = keyboard.nextLine();
					FileInputStream fin = new FileInputStream(temp + ".txt");
					ObjectInputStream forestin = new ObjectInputStream(fin);
					forest = (Forest)forestin.readObject();
					}catch(Exception e)
					{
						System.out.println("ERROR: Could not load.");
					}
					break;
				}
				//Exits the program
				case 'X':
				case 'x':
				{
					System.out.println("Goodbye");
					System.exit(0);
				}
				//For invalid inputs
				default:
				{
					System.out.println("ERROR: Invalid option");
					System.out.println("");
					break;
				}
			}
		}while(true);
		}
	}
