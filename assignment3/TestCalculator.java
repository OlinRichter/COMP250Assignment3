package assignment3;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class TestCalculator {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	// before '('
	
	@Test
	public void testValidateOpenBracketBefore1() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "321", true, 0);

	}
	
	@Test
	public void testValidateOpenBracketBefore2() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "3", true, 0);
	}
	
	@Test
	public void testValidateOpenBracketBefore3() throws InvalidExpressionException {
		Tokenizer.validate('(', "+", true, 0);
	}
	
	@Test
	public void testValidateOpenBracketBefore4() throws InvalidExpressionException {
		Tokenizer.validate('(', "-", true, 0);
	}
	
	@Test
	public void testValidateOpenBracketBefore5() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', ")", true, 0);

	}
	
	@Test
	public void testValidateOpenBracketBefore6() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "++", true, 0);
	}
	
	@Test
	public void testValidateOpenBracketBefore7() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "a", true, 0);
	}
	
	@Test
	public void testValidateOpenBracketBefore8() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "bh7", true, 0);
	}
	
	@Test
	public void testValidateOpenBracketBefore9() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "6asdf", true, 0);
	}
	
	@Test
	public void testValidateOpenBracketBefore10() throws InvalidExpressionException {
		Tokenizer.validate('(', "(", true, 0);
	}
	
	
	// after '('
	
	
	@Test
	public void testValidateOpenBracketAfter1() throws InvalidExpressionException {
		Tokenizer.validate('(', "321", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter2() throws InvalidExpressionException {
		Tokenizer.validate('(', "3", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter4() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "+", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter5() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "-", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter6() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', ")", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter7() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "++", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter8() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "*", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter9() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "/", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter10() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "adsf", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter11() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "i", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter12() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "asd", false, 0);
	}
	
	@Test
	public void testValidateOpenBracketAfter13() throws InvalidExpressionException {
		Tokenizer.validate('(', "(", false, 0);
	}
	
	// before ')'
	
	@Test
	public void testValidateOClosedBracketBefore1() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "+", true, 0);
	}
	
	@Test
	public void testValidateOClosedBracketBefore2() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "-", true, 0);
	}
	
	@Test
	public void testValidateOClosedBracketBefore3() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "*", true, 0);
	}
	
	@Test
	public void testValidateOClosedBracketBefore4() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "/", true, 0);
	}
	
	@Test
	public void testValidateOClosedBracketBefore5() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "(", true, 0);
	}
	
	@Test
	public void testValidateOClosedBracketBefore6() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "a", true, 0);
	}
	
	@Test
	public void testValidateOClosedBracketBefore7() throws InvalidExpressionException {
		Tokenizer.validate(')', "23", true, 0);
	}
	
	@Test
	public void testValidateOClosedBracketBefore8() throws InvalidExpressionException {
		Tokenizer.validate(')', "4", true, 0);
	}

	@Test
	public void testValidateOClosedBracketBefore9() throws InvalidExpressionException {
		Tokenizer.validate(')', "867876", true, 0);
	}
	
	@Test
	public void testValidateOClosedBracketBefore10() throws InvalidExpressionException {
		Tokenizer.validate(')', ")", true, 0);
	}
	
	
	// after ')'
	
	@Test
	public void testValidateOClosedBracketAfter1() throws InvalidExpressionException {
		Tokenizer.validate(')', "+", false, 0);
	}
	
	@Test
	public void testValidateOClosedBracketAfter2() throws InvalidExpressionException {
		Tokenizer.validate(')', "-", false, 0);
	}
	
	@Test
	public void testValidateOClosedBracketAfter3() throws InvalidExpressionException {
		Tokenizer.validate(')', "*", false, 0);
	}
	
	@Test
	public void testValidateOClosedBracketAfter4() throws InvalidExpressionException {
		Tokenizer.validate(')', "/", false, 0);
	}
	
	@Test
	public void testValidateOClosedBracketAfter5() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "(", false, 0);
	}
	
	@Test
	public void testValidateOClosedBracketAfter6() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "a", false, 0);
	}
	
	@Test
	public void testValidateOClosedBracketAfter7() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "23", false, 0);
	}
	
	@Test
	public void testValidateOClosedBracketAfter8() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "4", false, 0);
	}

	@Test
	public void testValidateOClosedBracketAfter9() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate(')', "867876", false, 0);
	}
	
	@Test
	public void testValidateOClosedBracketAfter10() throws InvalidExpressionException {
		Tokenizer.validate(')', ")", false, 0);
	}
	
	// diagnose: ((5+6)*5(6))
	
	@Test
	public void diagnose1() throws InvalidExpressionException {
		Tokenizer.validate('(', "(", true, 0);
	}
	
	@Test
	public void diagnose2() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "5", true, 0);
	}
	
	@Test
	public void diagnose3() throws InvalidExpressionException {
		Tokenizer.validate('+', "5", true, 0);
	}
	
	@Test
	public void diagnose4() throws InvalidExpressionException {
		Tokenizer.validate('6', "+", true, 0);
	}
	
	@Test
	public void diagnose5() throws InvalidExpressionException {
		Tokenizer.validate(')', "6", true, 0);
	}
	
	@Test
	public void diagnose6() throws InvalidExpressionException {
		Tokenizer.validate('*', ")", true, 0);
	}
	
	@Test
	public void diagnose7() throws InvalidExpressionException {
		Tokenizer.validate('5', "*", true, 0);
	}
	
	@Test
	public void diagnose8() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "5", true, 0);
	}
	
	@Test
	public void diagnose9() throws InvalidExpressionException {
		Tokenizer.validate('6', "(", true, 0);
	}
	
	@Test
	public void diagnose10() throws InvalidExpressionException {
		Tokenizer.validate(')', "6", true, 0);
	}
	
	@Test
	public void diagnose11() throws InvalidExpressionException {
		Tokenizer.validate(')', ")", true, 0);
	}
	
	// diagnose: ((5+6)*5(6))
	
	@Test
	public void diagnose21() throws InvalidExpressionException {
		Tokenizer.validate('(', "(", false, 0);
	}
	
	@Test
	public void diagnose22() throws InvalidExpressionException {
		Tokenizer.validate('(', "5", false, 0);
	}
	
	@Test
	public void diagnose23() throws InvalidExpressionException {
		Tokenizer.validate('5', "+", false, 0);
	}
	
	@Test
	public void diagnose24() throws InvalidExpressionException {
		Tokenizer.validate('+', "6", false, 0);
	}
	
	@Test
	public void diagnose25() throws InvalidExpressionException {
		Tokenizer.validate('6', ")", false, 0);
	}
	
	@Test
	public void diagnose26() throws InvalidExpressionException {
		Tokenizer.validate(')', "*", false, 0);
	}
	
	@Test
	public void diagnose27() throws InvalidExpressionException {
		Tokenizer.validate('*', "5", false, 0);
	}
	
	
	@Test
	public void diagnose29() throws InvalidExpressionException {
		Tokenizer.validate('(', "6", false, 0);
	}
	
	@Test
	public void diagnose210() throws InvalidExpressionException {
		Tokenizer.validate('6', ")", false, 0);
	}
	
	@Test
	public void diagnose211() throws InvalidExpressionException {
		Tokenizer.validate(')', ")", false, 0);
	}
	
	/*
	@Test
	public void diagnose8() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.validate('(', "(", true, 0);
		Tokenizer.validate('5', "(", true, 0);
		Tokenizer.validate('+', "5", true, 0);
		Tokenizer.validate('6', "+", true, 0);
		Tokenizer.validate(')', "6", true, 0);
		Tokenizer.validate('*', ")", true, 0);
		Tokenizer.validate('5', "*", true, 0);
		Tokenizer.validate('(', "5", true, 0);
		Tokenizer.validate('6', "(", true, 0);
		Tokenizer.validate(')', "6", true, 0);
		Tokenizer.validate(')', ")", true, 0);
	}
	*/
	
	// Tokenizer
	
	String pExpression1 = "5+6";
	
	@Test
	public void testTokenizer1() throws InvalidExpressionException {
		Tokenizer.tokenize(pExpression1);
		assertEquals(pExpression1.substring(Tokenizer.tokens.get(0).getStart(), Tokenizer.tokens.get(0).getEnd()), "5");
		assertEquals(pExpression1.substring(Tokenizer.tokens.get(1).getStart(), Tokenizer.tokens.get(1).getEnd()), "+");
		assertEquals(pExpression1.substring(Tokenizer.tokens.get(2).getStart(), Tokenizer.tokens.get(2).getEnd()), "6");
	}
	
	String pExpression2 = "(5+6)";
	
	@Test
	public void testTokenizer2() throws InvalidExpressionException {
		Tokenizer.tokenize(pExpression2);
		assertEquals(pExpression2.substring(Tokenizer.tokens.get(0).getStart(), Tokenizer.tokens.get(0).getEnd()), "(");
		assertEquals(pExpression2.substring(Tokenizer.tokens.get(1).getStart(), Tokenizer.tokens.get(1).getEnd()), "5");
		assertEquals(pExpression2.substring(Tokenizer.tokens.get(2).getStart(), Tokenizer.tokens.get(2).getEnd()), "+");
		assertEquals(pExpression2.substring(Tokenizer.tokens.get(3).getStart(), Tokenizer.tokens.get(3).getEnd()), "6");
		assertEquals(pExpression2.substring(Tokenizer.tokens.get(4).getStart(), Tokenizer.tokens.get(4).getEnd()), ")");
	}
	
	String pExpression3 = "(5)+6";
	
	@Test
	public void testTokenizer3() throws InvalidExpressionException {
		Tokenizer.tokenize(pExpression3);
		assertEquals(pExpression3.substring(Tokenizer.tokens.get(0).getStart(), Tokenizer.tokens.get(0).getEnd()), "(");
		assertEquals(pExpression3.substring(Tokenizer.tokens.get(1).getStart(), Tokenizer.tokens.get(1).getEnd()), "5");
		assertEquals(pExpression3.substring(Tokenizer.tokens.get(2).getStart(), Tokenizer.tokens.get(2).getEnd()), ")");
		assertEquals(pExpression3.substring(Tokenizer.tokens.get(3).getStart(), Tokenizer.tokens.get(3).getEnd()), "+");
		assertEquals(pExpression3.substring(Tokenizer.tokens.get(4).getStart(), Tokenizer.tokens.get(4).getEnd()), "6");
	}
	
	String pExpression4 = "(5+6/(5*9))";
	
	@Test
	public void testTokenizer4() throws InvalidExpressionException {
		Tokenizer.tokenize(pExpression4);
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(0).getStart(), Tokenizer.tokens.get(0).getEnd()), "(");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(1).getStart(), Tokenizer.tokens.get(1).getEnd()), "5");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(2).getStart(), Tokenizer.tokens.get(2).getEnd()), "+");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(3).getStart(), Tokenizer.tokens.get(3).getEnd()), "6");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(4).getStart(), Tokenizer.tokens.get(4).getEnd()), "/");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(5).getStart(), Tokenizer.tokens.get(5).getEnd()), "(");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(6).getStart(), Tokenizer.tokens.get(6).getEnd()), "5");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(7).getStart(), Tokenizer.tokens.get(7).getEnd()), "*");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(8).getStart(), Tokenizer.tokens.get(8).getEnd()), "9");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(9).getStart(), Tokenizer.tokens.get(9).getEnd()), ")");
		assertEquals(pExpression4.substring(Tokenizer.tokens.get(9).getStart(), Tokenizer.tokens.get(9).getEnd()), ")");
	}
	
	String pExpression5 = "(+5+6)";
	
	@Test
	public void testTokenizer5() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.tokenize(pExpression5);
	}
	
	String pExpression6 = "((5+6)*5(6))";
	
	@Test
	public void testTokenizer6() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.tokenize(pExpression6);
	}
	
	String pExpression7 = "5+6*6(+)";
	
	@Test
	public void testTokenizer7() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.tokenize(pExpression7);
	}
	
	String pExpression8 = "5+6)(";
	
	@Test
	public void testTokenizer8() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.tokenize(pExpression8);
	}
	
	String pExpression9 = "5+6+)";
	
	@Test
	public void testTokenizer9() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.tokenize(pExpression9);
	}
	
	String pExpression10 = "5+6(6/4)";
	
	@Test
	public void testTokenizer10() throws InvalidExpressionException {
		thrown.expect(InvalidExpressionException.class);
		Tokenizer.tokenize(pExpression10);
	}
}

