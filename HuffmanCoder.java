/**
 * This class uses a Huffman tree for encoding a character and decoding a code string. 
 * @author gaoge
 */
public class HuffmanCoder {
	/**
	 * Instance variable huffTree, the Huffman tree.
	 * Instance variable encodingList, an unordered list of encoding data that will be used for encoding a text file.
	 */
	private HuffmanTree huffTree;
	private ArrayUnorderedList<EncodingData> encodingList;
	
	/**
	 * Constructor. Create the huffTree.
	 * @param pairsList
	 */
	public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairsList)
	{
		this.huffTree = new HuffmanTree(pairsList);
		this.encodingList = new ArrayUnorderedList<EncodingData>();
		this.buildEncodingList(this.huffTree.getRoot(), "");  // Call the helping method.
	}
	
	/**
	 * This method takes the specified string of binary digits and returns the original coded character. 
	 * @param code
	 * @return coded character
	 */
	public char decode(String code)
	{
		BinaryTreeNode<HuffmanPair> current = this.huffTree.getRoot();  // A current reference.
		char[] chararray = code.toCharArray();  // To put every single character of the code into an array.
		for (int i = 0; i < chararray.length; i++)
		{
			if (current.isLeaf())
			{
				return (char)0;
			}
			if (chararray[i] == '0')
			{
				current = current.getLeft();  // If the character is 0, go left.
			} else {
				current = current.getRight();  // If the character is 1, go right.
			}
		}
		if (current.isLeaf())  // Find the leaf node.
		{
			return current.getElement().getCharacter();  // Return the character contained in the leaf child.
		} else {
			return (char)0;  // Return character 0 if cannot find a leaf node.
		}
	}
	
	/**
	 * This method takes the specified character and return the string representation of the binary encoding.
	 * @param c
	 * @return String representation of the binary encoding.
	 * @throws ElementNotFoundException
	 */
	public String encode(char c)throws ElementNotFoundException
	{
		for (EncodingData data : this.encodingList)  // Traverse the encodingList.
		{
			if (data.getSymbol() == c)  //Founded.
			{
				return data.getEncoding();
			}
		}
		throw new ElementNotFoundException("Element Not Found!");
	}
	
	/**
	 * This method return a string representation of the encodingList.
	 * @return String representation
	 */
	public String toString()
	{
		String result = "";
		for (EncodingData data : this.encodingList)
		{
			result = result + data.toString();
		}
		return result;
	}
	
	/**
	 * Helping method. This method will build the unordered list encodingList from the huffTree.
	 * @param node
	 * @param encoding
	 */
	private void buildEncodingList (BinaryTreeNode<HuffmanPair> node, String encoding)
	{
		if (node.isLeaf())
		{
			this.encodingList.addToRear(new EncodingData(node.getElement().getCharacter(), encoding));
		} else {
			this.buildEncodingList(node.getLeft(), encoding + "0");
			this.buildEncodingList(node.getRight(), encoding + "1");
		}
	}
}
