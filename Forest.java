import java.io.Serializable;

public class Forest implements Serializable
{	//-------Array in which the trees will be stored
	Tree[] trees;
	//-------The name of the forest
	String name;
	//-------Constructor for Forest
	public Forest(String name)
	{
		this.name = name;
		trees = new Tree[10];
		for(int x = 0; x<trees.length; x++)
		{
			trees[x] = new Tree();
		}
	}
	//-------A reaping method that will reap every treee in the array with a height greater than
	//-------"reap" and replace them with new trees
	public void reap(double reap)
	{
		for(int x = 0; x<trees.length; x++)
		{
			if(trees[x].getHeight()>reap)
			{
				System.out.print("Cut  " + (x+1) + " :  " + trees[x].toString() + "\n");
				trees[x] = new Tree();
				System.out.print("New  " + (x+1) + " :  " + trees[x].toString() + "\n");
			}
		}
	}
	//------Converts 10 trees into a string with proper format
	public String toString()
	{
		String temp = name + "\n";
		for(int x = 0; x<trees.length; x++)
		{
			temp = temp + "\n" + (x+1) + " :" + trees[x].toString() + "   ";
		}
		return temp;
	}
	//------Increases the height of the whole forest depending on each trees 
	//------growthRate
	public void growth()
	{
		for(int x = 0; x<trees.length; x++)
		{
			trees[x].growth();
			
		}
	}
}
