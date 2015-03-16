package assignment3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

/**
 * Main class for the calculator: creates the GUI for the calculator 
 * and responds to presses of the "Enter" key in the text field 
 * and clicking on the button. You do not need to understand or modify 
 * the GUI code to complete this assignment. See instructions below the line
 * BEGIN ASSIGNMENT CODE
 * 
 * @author Martin P. Robillard 26 February 2015
 *
 */
@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener
{
	private static final Color LIGHT_RED = new Color(214,163,182);
	
	private final JTextField aText = new JTextField(40);
	
	public Calculator()
	{
		setTitle("COMP 250 Calculator");
		setLayout(new GridLayout(2, 1));
		setResizable(false);
		add(aText);
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				aText.setText("");		
				aText.requestFocusInWindow();
			}
		});
		add(clear);
		
		aText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		aText.addActionListener(this);

		aText.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void removeUpdate(DocumentEvent e)
			{
				aText.getHighlighter().removeAllHighlights();	
			}
			
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				aText.getHighlighter().removeAllHighlights();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e)
			{
				aText.getHighlighter().removeAllHighlights();
			}
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/**
	 * Run this main method to start the calculator
	 * @param args Not used.
	 */
	public static void main(String[] args)
	{
		new Calculator();
	}
	
	/* 
	 * Responds to events by the user. Do not modify this method.
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if( aText.getText().contains("="))
		{
			aText.setText("");		
		}
		else
		{
			Queue<Token> expression = processExpression(aText.getText());
			if( expression != null )
			{
				String result = evaluateExpression(expression);
				if( result != null )
				{
					aText.setText(aText.getText() + " = " + result);
				}
			}
		}
	}
	
	/**
	 * Highlights a section of the text field with a color indicating an error.
	 * Any change to the text field erase the highlights.
	 * Call this method in your own code to highlight part of the equation to 
	 * indicate an error.
	 * @param pBegin The index of the first character to highlight.
	 * @param pEnd The index of the first character not to highlight.
	 */
	public void flagError( int pBegin, int pEnd )
	{
		assert pEnd > pBegin;
		try
		{
			aText.getHighlighter().addHighlight(pBegin, pEnd, new DefaultHighlighter.DefaultHighlightPainter(LIGHT_RED));
		}
		catch(BadLocationException e)
		{
			
		}
	}
	
	/******************** BEGIN ASSIGNMENT CODE ********************/
	
	/**
	 * Tokenizes pExpression (see Tokenizer, below), and 
	 * returns a Queue of Tokens that describe the original 
	 * mathematical expression in reverse Polish notation (RPN).
	 * Flags errors and returns null if the expression
	 * a) contains any symbol except spaces, digits, round parentheses, or operators (+,-,*,/)
	 * b) contains unbalanced parentheses
	 * c) contains invalid combinations of parentheses and numbers, e.g., 2(3)(4)
	 * 
	 * @param pExpression A string.
	 * @return The tokenized expression transformed in RPN
	 */
	private Queue<Token> processExpression(String pExpression)
	{
		
		return new LinkedList<Token>(); // TODO
	}
	
	/**
	 * Assumes pExpression is a Queue of tokens produced as the output of processExpression.
	 * Evaluates the answer to the expression. The division operator performs a floating-point 
	 * division. 
	 * Flags errors and returns null if the expression is an invalid RPN expression e.g., 1+-
	 * @param pExpression The expression in RPN
	 * @return A string representation of the answer)
	 */
	private String evaluateExpression(Queue<Token> pExpression)
	{
		// Hint return String.format("%s", <YOUR ANSWER>);
		return "Your answer"; // TODO
	}
}

/**
 * Use this class as the root class of a hierarchy of token classes
 * that can represent the following types of tokens:
 * a) Integers (e.g., "123" "4", or "345") Negative numbers are not allowed as inputs
 * b) Parentheses '(' or ')'
 * c) Operators '+', '-', '/', '*' Hint: consider using the Comparable interface to support
 * comparing operators for precedence
 */

class Token
{
	private int aStart;
	private int aEnd;
	
	/**
	 * @param pStart The index of the first character of this token
	 * in the original expression.
	 * @param pEnd The index of the last character of this token in
	 * the original expression
	 */
	public Token( int pStart, int pEnd )
	{
		aStart = pStart;
		aEnd = pEnd;
	}
	
	public int getStart()
	{
		return aStart;
	}
	
	public int getEnd()
	{
		return aEnd;
	}
	
	public String toString()
	{
		return "{" + aStart + "," + aEnd + "}";
	}
}

/**
 * Partial implementation of a tokenizer that can convert any valid string
 * into a stream of tokens, or detect invalid strings. Do not change the signature
 * of the public methods, but you can add private helper methods. The signature of the
 * private methods is there to help you out with basic ideas for a design (it is strongly 
 * recommended to use them). Hint: consider making your Tokenizer an Iterable<Token>
 */
class Tokenizer
{
	static ArrayList<Token> tokens;
	/**
	 * Converts pExpression into a sequence of Tokens that are retained in
	 * a data structure in this class that can be made available to other objects.
	 * Every call to tokenize should clear the structure and start fresh.
	 * White spaces are tolerated but should be ignored (not converted into tokens).
	 * The presence of any illegal character should raise an exception.
	 * 
	 * @param pExpression An expression to tokenize. Can contain invalid characters.
	 * @throws InvalidExpressionException If any invalid character is detected or if parentheses
	 * are misused as operators.
	 */
	public static void tokenize(String pExpression) throws InvalidExpressionException
	{
		tokens = new ArrayList<>();
		int length = pExpression.length();
		int index = 0;
		
		while (index < length) {
			int pStart = index;
			int pEnd;
			if (!(pExpression.charAt(index) >= 40 && pExpression.charAt(index) <= 57 && pExpression.charAt(index) != 44
					 && pExpression.charAt(index) != 46)) {
				consume(pExpression.charAt(index), index);
			}
			else {
				if (pExpression.charAt(index) >= 40 && pExpression.charAt(index) <= 47) {
					pEnd = index + 1;
				}
				else {
					while (index < (pExpression.length() - 1) && pExpression.charAt(index + 1) >= 48 && pExpression.charAt(index + 1) <= 57) {
						index++;
					}
					pEnd = index + 1;
				}
				tokens.add(new Token(pStart, pEnd));
			}
			index++;
		}
		
		int previousIndex = 0;
		
		ListIterator<Token> listIterator = tokens.listIterator();
		while (listIterator.hasNext()) {
			Token t = listIterator.next();
			if (pExpression.charAt(t.getStart()) == '(' || pExpression.charAt(t.getStart()) == ')') {
				if (listIterator.hasPrevious())
					previousIndex = listIterator.previousIndex() - 1;
				if (previousIndex < 0)
					previousIndex++;
				validate(pExpression.charAt(t.getStart()), pExpression.substring(tokens.get(previousIndex).getStart(),
						tokens.get(previousIndex).getEnd()), true, tokens.get(previousIndex).getStart());
				if(listIterator.hasNext()) {
					validate(pExpression.charAt(t.getStart()), pExpression.substring(tokens.get(listIterator.nextIndex()).getStart(),
							tokens.get(listIterator.nextIndex()).getEnd()), false, tokens.get(listIterator.nextIndex()).getStart());
				}
			}
		}
	}
	
	private static void consume(char pChar, int index) throws InvalidExpressionException
	{
		if (pChar != ' ')
			throw new InvalidExpressionException(index);
	}
	
	/**
	 * Detects if parentheses are misused
	 * @throws InvalidExpressionException
	 */
	
	// (5+6)
	public static void validate(char bracket, String other, boolean isBefore, int position) throws InvalidExpressionException
	{
		assert bracket == '(' || bracket == ')';
		assert other.charAt(0) >= 40 && other.charAt(0) <= 57 && other.charAt(0) != 44 && other.charAt(0) != 46;
		
		switch (bracket) {
		case '(':
			if (isBefore) {
				if (other.length() > 1)
					throw new InvalidExpressionException(position);
				if (other.charAt(0) != '+' && other.charAt(0) != '-' && other.charAt(0) != '*' && other.charAt(0) != '/' && other.charAt(0) != '(')
					throw new InvalidExpressionException(position);
			}
			else {
				if (!(other.charAt(0) >= 48 && other.charAt(0) <= 57) && other.charAt(0) != '(')
					throw new InvalidExpressionException(position);
			}
			break;
		case ')':
			if (isBefore) {
				if (!(other.charAt(0) >= 48 && other.charAt(0) <= 57) && other.charAt(0) != ')') {
					throw new InvalidExpressionException(position);
				}
			}
			else {
				if (other.length() > 1)
					throw new InvalidExpressionException(position);
				if (other.charAt(0) != '+' && other.charAt(0) != '-' && other.charAt(0) != '*' && other.charAt(0) != '/' && other.charAt(0) != ')')
					throw new InvalidExpressionException(position);
			}
			break;
		}
	}
}

/**
 * Thrown by the Tokenizer if an expression is detected to be invalid.
 * You don't need to modify this class.
 */
@SuppressWarnings("serial")
class InvalidExpressionException extends Exception
{
	private int aPosition;
	
	public InvalidExpressionException( int pPosition )
	{
		aPosition = pPosition;
	}
	
	public int getPosition()
	{
		return aPosition;
	}
}
