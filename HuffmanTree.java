import java.util.Iterator;
/**
 * This class will create a Huffman tree, and will extend the LinkedBinaryTree<T> class. The class will also
 * implement the Comparable interface.
 * @author gaoge
 */
public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree>{
	
	/**
	 * Constructor. Create an empty Huffman tree.
	 */
	public HuffmanTree()
	{
		super();  // Inherit from the super class LinkedBinaryTree.
	}
	
	/**
	 * Constructor. Create a Huffman tree with one Huffman pair at the root.
	 * @param element
	 */
	public HuffmanTree(HuffmanPair element)
	{
		super(element);  // Inherit from the super class LinkedBinaryTree.
	}
	
	/**
	 * Constructor. Create a Huffman tree rooted at a node containing element, where the roots of the left 
	 * subtree and right subtree are its left child and right child respectively.
	 * @param element
	 * @param leftSubtree
	 * @param rightSubtree
	 */
	public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree)
	{
		super(element);  // Inherit from the super class LinkedBinaryTree.
		this.getRoot().setLeft(leftSubtree.getRoot());
		this.getRoot().setRight(rightSubtree.getRoot());
	}
	
	/**
	 * Constructor. Build a Huffman tree from the ordered list pairsList.
	 * @param pairsList
	 */
	public HuffmanTree(ArrayOrderedList<HuffmanPair> pairsList)
	{
		if (pairsList.size() == 1)
		{
			HuffmanTree leftsub = new HuffmanTree(pairsList.first());
			HuffmanTree rightsub = new HuffmanTree();  // Create an empty tree.
			// Build a Huffman tree where the root is HuffmanPair with symbol 0 and addition of left subtree's 
			// frequency and right subtree's frequency. The left child is the only element in the list and the
			// right child is the empty tree created.
			HuffmanTree tree = new HuffmanTree(new HuffmanPair(leftsub.getRoot().getElement().getFrequency()), leftsub, rightsub);
			this.setRoot(tree.getRoot());
		}
		
		ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<HuffmanTree>();
		for (HuffmanPair pair : pairsList)  // Traverse the pairList.
		{
			buildList.add(new HuffmanTree(pair));
		}
		
		while (buildList.size() > 1)
		{
			HuffmanTree leftsub = buildList.removeFirst();
			HuffmanTree rightsub = buildList.removeFirst();
			HuffmanTree tree = new HuffmanTree(new HuffmanPair(leftsub.getRoot().getElement().getFrequency() + rightsub.getRoot().getElement().getFrequency()), leftsub, rightsub);
			buildList.add(tree);
		}
		this.setRoot(buildList.removeFirst().getRoot());  // Set the root to the root of the only element in the list.
	}
	
	/**
	 * compareTo method is specified in the Comparable interface. The method compare the frequencies 
	 * in the root node of the trees.
	 * @return positive integer if this presents a higher frequency, negative integer if other tree presents
	 * a higher frequency, zero if they have the same frequency.
	 */
	public int compareTo(HuffmanTree otherTree)
	{
		int result = this.getRoot().getElement().getFrequency() - otherTree.getRoot().getElement().getFrequency();
		return result;
	}
	
	/**
	 * This method will return a string representation of a Huffman tree by doing a preorder traversal of the tree.
	 * @return String representation. 
	 */
	public String toString()
	{
		String result = "";
		Iterator<HuffmanPair> list = this.iteratorPreOrder();
		while (list.hasNext())
		{
			result = result + list.next().toString();
		}
		return result;
	}
	
}
