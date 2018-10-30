/**
 * This class is to represent a single pair of data to encode a text message into its binary Huffman code, 
 * consisting of a symbol and its corresponding binary Huffman code.
 * @author gaoge
 */
public class EncodingData {
	/**
	 * Instance variable symbol, a symbol that is to be encoded.
	 * Instance variable encoding, the binary Huffman code of the symbol.
	 */
	private char symbol;
	private String encoding;
	
	/**
	 * Constructor, create a new pair of data with specific symbol and encoding message.
	 * @param symbol
	 * @param encoding
	 */
	public EncodingData(char symbol, String encoding)
	{
		this.symbol = symbol;
		this.encoding = encoding;
	}
	
	/**
	 * Getter method, get the symbol.
	 * @return symbol
	 */
	public char getSymbol()
	{
		return this.symbol;
	}
	
	/**
	 * Getter method, get the corresponding code you want.
	 * @return encoding
	 */
	public String getEncoding()
	{
		return this.encoding;
	}
	
	/**
	 * Setter method, set the encoding message to parameter code.
	 * @param code
	 */
	public void setEncoding(String code)
	{
		this.encoding = code;
	}
	
	/**
	 * Determine if two EncodingData objects are equal based on the symbol attribute.
	 * @return true if equal, false if not equal.
	 */
	public boolean equals(Object obj)
	{
		EncodingData other = (EncodingData) obj;  // Casting.
		if (this.symbol != other.symbol)  // Compare if two symbols are equal.
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Method that gives a representation of the symbol and its Huffman code.
	 * @return String representation
	 */
	public String toString()
	{
		String result = "";
		result = Character.toString(symbol) + ", " + encoding + "\n";
		return result;
	}
	
}
