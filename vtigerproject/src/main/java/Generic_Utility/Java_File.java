package Generic_Utility;

import java.util.Random;

public class Java_File {
public int getRandomnum()
{
	Random ran= new Random();
	int ranum= ran.nextInt(1000);
	return ranum;
	}
}
