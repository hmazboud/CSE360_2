import java.util.Arrays;

//Name: Hadi Mazboudi
//Date: 2/10/20
//Class: CSE360 Monday 3:00pm 
//Assignment: SimpleList
//Description: Create a SimpleList object class with add, remove, 
//	search, and toString methods
public class SimpleList{
	
	int[] list;
	int count;
	
	//constructor method to initialize SimpleList object
	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	public void append(int num)
	{
		System.out.println("HAHA");
		if(count == list.length)
		{
			int newSize = (int) (list.length * 1.5);
			int[] newList = Arrays.copyOf(list, newSize);
			list = newList;
		}
		list[count] = num;
		count++;
	}
	
	public int first()
	{
		if(count == 0)
			return -1;
		else
			return list[0];
	}
	
	public int last()
	{
		if(count == 0)
			return -1;
		else
			return list[count - 1];
	}
	
	public int size()
	{
		return list.length;
	}
	
	public void add(int num)
	{

		if(count == list.length - 1)
		{
			int newSize = (int) (list.length * 1.5);
			int[] newList = Arrays.copyOf(list, newSize);
			
			for(int iterator = count; iterator > 0; iterator--)
			{
				newList[iterator] = newList[iterator - 1];
			}		
			//the first index of the array will always be the new number passed
			//	by the parameter, so this can be hard coded
			newList[0] = num;
			count++;
			list = newList;
			
		}
		else
		{
		//logic for this method:
		//make iterator point to the last index of the array at the beginning
		//	for every iteration, make the index iterator refers to equal to the
		//	array value at the index before it. Decrement the iterator until it 
		//	reaches 0
			for(int iterator = count; iterator > 0; iterator--)
			{
				list[iterator] = list[iterator - 1];
			}		
			//the first index of the array will always be the new number passed
			//	by the parameter, so this can be hard coded
			list[0] = num;
			count++;
		}
	}
	
	public void remove(int num)
	{
		//logic for this method:
		//a temp list is created and every value that is not the num value
		//	being search for is put at the end of the temp list
		//	if a number that is equal to the num parameter, the loop decrements
		//	the newCount variable (because count is part of the parameter
		//	in the for loop and changing it would ruin the logic of the for
		//	loop. After the entire list has been looped through and the 
		//	values are stored in the tempList array, the list array is replaced
		//	by the tempList array, since it didn't store the num parameter
		//	values, it essentially removes them from the array. And count is
		//	updated to newCount for further use in the program
		count = count();
		int[] tempList = new int[10];
		int tempListCount = 0;
		int newCount = count;
		for(int iterator =  0; iterator <= count; iterator++)
		{
			if(list[iterator] == num) 
				newCount--;
			else
			{
				tempList[tempListCount] = list[iterator];
				tempListCount++;
			}
		}
		count = newCount;
		list = tempList;
		
		int reduceCond = (int) (list.length * 0.25);
		if(count < reduceCond)
		{
			int[] newList = Arrays.copyOf(list, reduceCond);
			list = newList;
		}
	}
	
	public int count()
	{
		//count is tracked in remove and add methods, unnecessary to
		//	do more logic
		return count;
	}
	
	public String toString()
	{
		//iterates through the array and appends the values of the array
		//	to the output string
		String output = "";
		for (int iterator = 0; iterator < count; iterator++)
		{
			int temp = list[iterator];
			output = output + "" + Integer.toString(temp) + " ";
		}
		
		//deletes unnecessary space at the end of output string
		output = output.substring(0, output.length() - 1);
		return output;
	}
	
	public int search(int num)
	{
		//binary search
		for(int iterator = 0; iterator < count; iterator++)
		{
			if(list[iterator] == num)
				return iterator;
		}
		return -1;
	}
}
