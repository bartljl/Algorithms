
void serializeBT(TreeNode root,BufferedWriter out)
{
  if(root == null)
	{
	   out.write("# ");
	}
	else
	{
	  out.write(root.val + " ");
	  serializeBT(root.left,out);
	  serializeBT(root.right,out);
	}
}

TreeNode deserializeBT(StringTokenizer stoken)
{
	String nextstr = stoken.nextToken(" ");
	if(!nextstr.equals("#"))
	{
	  TreeNode root = new TreeNode(Integer.parseInt(nextstr));
	  root.left = deserializeBT(stoken);
	  root.right = deserializeBT(stoken);
		 
	  return root;
	}
	return null;
}
