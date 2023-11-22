//Complete this code or write your own from scratch
import java.util.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
        Map <String, Integer> m = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            m.put(name, phone);
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
            Integer num = m.get(s);
            if (num != null) System.out.println(s + "=" + num);
            else System.out.println("Not found");
            
		}
	}
}