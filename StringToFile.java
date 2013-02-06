/*Given a string,output a file,each line of the file is the character in the string,following its appearing time.
In descending order.*/

static void stringToFile(String s) throws IOException
{
     Hashtable<Character,Integer> t = new Hashtable<Character,Integer>();
	   for(int i = 0; i < s.length(); i++)
	   {
	      if(t.containsKey(s.charAt(i)))
	      {
	         t.put(s.charAt(i),t.get(s.charAt(i)) + 1);  
	      }
	      else
	      {
	         t.put(s.charAt(i),1);
	      }
	   }
	   
	   ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(t.entrySet()); 
	   Collections.sort(list,new MyComparator());
	    
	   FileWriter fstream = new FileWriter("output.txt");
	   BufferedWriter out = new BufferedWriter(fstream);

	   Iterator<Entry<Character, Integer>> it = list.iterator();
	   while(it.hasNext())
	   {
	     Entry<Character, Integer> e = it.next();
	     out.write(e.getKey() + " " + e.getValue() + "\r\n");
	   }  
	   out.close();
}

public class MyComparator implements Comparator<Map.Entry<Character, Integer>>
{
   public int compare(Map.Entry<Character, Integer> e1,Map.Entry<Character, Integer> e2)
   {
       /*Descending order*/
       if((Integer)e1.getValue() < (Integer)e2.getValue()) return 1;
       else if((Integer)e1.getValue() == (Integer)e2.getValue()) return 0;
       else return -1;
   }
}
