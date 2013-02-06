
public class Trie
{
  boolean isWord;
  Trie[] edges;
  
  public Trie()
  {
     isWord = false; 
     edges = new Trie[26];
  }
  
  void addWord(String word)
  {
    Trie t = this;
    for(int i = 0; i < word.length(); i++)
	  {
	   int index = word.charAt(i) - 'a';
	   if(t.edges[index] == null)
	   t.edges[index] = new Trie();
	   t = t.edges[index];
	  }
	  t.isWord = true;
  }
  
  void printAllCommonPrefix(String s)
  {	
     Trie t = this;
	   for(int i = 0; i < s.length(); i++)
	   {
	    int index = s.charAt(i) - 'a';
		  if(t.edges[index] == null)
		  return;
	 	  t = t.edges[index];
	   }
	   doPrint(s,t);
  }
  
  void doPrint(String s,Trie t)
  {
     if(t == null) return;
	 
	   if(t.isWord)
	   {
	     System.out.println(s);
	   }
	 
	   for(int i = 0; i < 26; i++)
	   {
		    if(t.edges[i] != null)
		   {
		    doPrint(s + (char)(i + 'a'),t.edges[i]); 
		   }
	   }
  }
 
}
