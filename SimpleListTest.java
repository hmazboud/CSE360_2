//Name: Hadi Mazboudi
//Date: 2/10/20
//Class: CSE360 Calliss Monday 3:00pm
//Assignmnet: SimpleListTester
//Description: JUnit tester class that is used to test SimpleList class
//	by using assert statements and testing all use cases and edge cases of the
//	SimpleList program

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	@Test
	public void emptyAddTest()
	{
		//test for when add is called and the array has no values
		//	stored in it
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 1;
		test.add(1);
		assertArrayEquals(testList, test.list);
	}
	
	@Test
	public void midsizeAddTest() 
	{
		//test for when add is called and the array has stored values
		//	but not completely full
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 10;
		testList[1] = 9;
		testList[2] = 5;
		testList[3] = 3;
		test.add(3);
		test.add(5);
		test.add(9);
		test.add(10);
		assertArrayEquals(testList, test.list);
	}
	
	@Test
	public void fullAddTest()
	{
		//test for when add is called and the array is completely full and
		//	the last elements "falls off" the list
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 2;
		testList[1] = 3;
		testList[2] = 4;
		testList[3] = 5;
		testList[4] = 6;
		testList[5] = 7;
		testList[6] = 8;
		testList[7] = 9;
		testList[8] = 10;
		testList[9] = 11;
		test.add(13);
		test.add(12);
		test.add(11);
		test.add(10);
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		assertArrayEquals(testList, test.list);
	}

	@Test
	public void numFoundRemove()
	{
		//test for when remove method is called and the num that is passed as
		//	a parameter is in the array
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 2;
		testList[1] = 3;
		testList[2] = 4;
		testList[3] = 5;
		testList[4] = 6;
		testList[5] = 7;
		testList[6] = 8;
		testList[7] = 9;
		testList[8] = 11;
		test.add(11);
		test.add(10);
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		
		test.remove(10);
		
		assertArrayEquals(testList, test.list);
	}
	
	@Test
	public void numNotFoundRemove() 
	{
		//test for when remove method is called and the num that is passed as
		//	a parameter is not in the array
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 2;
		testList[1] = 3;
		testList[2] = 4;
		testList[3] = 5;
		testList[4] = 6;
		testList[5] = 7;
		testList[6] = 8;
		testList[7] = 9;
		testList[8] = 10;
		testList[9] = 11;
		test.add(11);
		test.add(10);
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		
		test.remove(20);
		
		assertArrayEquals(testList, test.list);
	}
	
	@Test
	public void countTest()
	{
		//test to ensure the count method is working, with remove and add 
		//	methods call to make sure both are working correctly
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 2;
		testList[1] = 3;
		testList[2] = 5;
		testList[3] = 6;
		testList[4] = 8;
		testList[5] = 9;
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		
		test.remove(4);
		test.remove(6);
		
		assertEquals(6, test.count());
	}
	
	@Test
	public void toStringTest()
	{
		//test to ensure toString is functioning properly
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 2;
		testList[1] = 3;
		testList[2] = 4;
		testList[3] = 5;
		testList[4] = 6;
		testList[5] = 7;
		testList[6] = 8;
		testList[7] = 9;
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		
		String testString = "2 3 4 5 6 7 8 9";
		
		assertEquals(testString, test.toString());
	}
	
	@Test
	public void searchFoundTest()
	{
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 2;
		testList[1] = 3;
		testList[2] = 4;
		testList[3] = 5;
		testList[4] = 6;
		testList[5] = 7;
		testList[6] = 8;
		testList[7] = 9;
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		
		int searchTestOutput = 2;
		
		assertEquals(searchTestOutput, test.search(4));
	}
	
	@Test
	public void searchNotFoundTest()
	{
		SimpleList test = new SimpleList();
		int[] testList = new int[10];
		testList[0] = 2;
		testList[1] = 3;
		testList[2] = 4;
		testList[3] = 5;
		testList[4] = 6;
		testList[5] = 7;
		testList[6] = 8;
		testList[7] = 9;
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		
		int searchTestOutput = -1;
		
		assertEquals(searchTestOutput, test.search(40));
	}
}
