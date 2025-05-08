package javautility;

import java.util.Random;

public class Randomnumbergeneration {

	public int generaterandomnumber() {
		
		Random random= new Random();
		int num=random.nextInt(999);
		return num;
	}
	
}
