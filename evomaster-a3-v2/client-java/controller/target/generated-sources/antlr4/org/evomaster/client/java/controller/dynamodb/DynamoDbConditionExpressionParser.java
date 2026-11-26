// Generated from org/evomaster/client/java/controller/dynamodb/DynamoDbConditionExpression.g4 by ANTLR 4.9.2
package org.evomaster.client.java.controller.dynamodb;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DynamoDbConditionExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, COMMA=3, EQ=4, NE=5, LTE=6, GTE=7, LT=8, GT=9, AND=10, 
		OR=11, NOT=12, BETWEEN=13, IN=14, ATTRIBUTE_EXISTS=15, ATTRIBUTE_NOT_EXISTS=16, 
		ATTRIBUTE_TYPE=17, BEGINS_WITH=18, CONTAINS=19, SIZE=20, BOOLEAN_LITERAL=21, 
		NULL_LITERAL=22, PLACEHOLDER=23, NUMBER_LITERAL=24, STRING_LITERAL=25, 
		IDENTIFIER=26, WS=27;
	public static final int
		RULE_expression = 0, RULE_orExpr = 1, RULE_andExpr = 2, RULE_notExpr = 3, 
		RULE_primary = 4, RULE_predicate = 5, RULE_comparator = 6, RULE_path = 7, 
		RULE_value = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "orExpr", "andExpr", "notExpr", "primary", "predicate", 
			"comparator", "path", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'='", "'<>'", "'<='", "'>='", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "COMMA", "EQ", "NE", "LTE", "GTE", "LT", "GT", 
			"AND", "OR", "NOT", "BETWEEN", "IN", "ATTRIBUTE_EXISTS", "ATTRIBUTE_NOT_EXISTS", 
			"ATTRIBUTE_TYPE", "BEGINS_WITH", "CONTAINS", "SIZE", "BOOLEAN_LITERAL", 
			"NULL_LITERAL", "PLACEHOLDER", "NUMBER_LITERAL", "STRING_LITERAL", "IDENTIFIER", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DynamoDbConditionExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DynamoDbConditionExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpressionContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DynamoDbConditionExpressionParser.EOF, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			orExpr();
			setState(19);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExprContext extends ParserRuleContext {
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(DynamoDbConditionExpressionParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(DynamoDbConditionExpressionParser.OR, i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			andExpr();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(22);
				match(OR);
				setState(23);
				andExpr();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExprContext extends ParserRuleContext {
		public List<NotExprContext> notExpr() {
			return getRuleContexts(NotExprContext.class);
		}
		public NotExprContext notExpr(int i) {
			return getRuleContext(NotExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(DynamoDbConditionExpressionParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(DynamoDbConditionExpressionParser.AND, i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			notExpr();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(30);
				match(AND);
				setState(31);
				notExpr();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotExprContext extends ParserRuleContext {
		public NotExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpr; }
	 
		public NotExprContext() { }
		public void copyFrom(NotExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegatedExprContext extends NotExprContext {
		public TerminalNode NOT() { return getToken(DynamoDbConditionExpressionParser.NOT, 0); }
		public NotExprContext notExpr() {
			return getRuleContext(NotExprContext.class,0);
		}
		public NegatedExprContext(NotExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitNegatedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryExprContext extends NotExprContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExprContext(NotExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExprContext notExpr() throws RecognitionException {
		NotExprContext _localctx = new NotExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_notExpr);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new NegatedExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(NOT);
				setState(38);
				notExpr();
				}
				break;
			case LPAREN:
			case ATTRIBUTE_EXISTS:
			case ATTRIBUTE_NOT_EXISTS:
			case ATTRIBUTE_TYPE:
			case BEGINS_WITH:
			case CONTAINS:
			case SIZE:
			case IDENTIFIER:
				_localctx = new PrimaryExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenthesizedPrimaryContext extends PrimaryContext {
		public TerminalNode LPAREN() { return getToken(DynamoDbConditionExpressionParser.LPAREN, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DynamoDbConditionExpressionParser.RPAREN, 0); }
		public ParenthesizedPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitParenthesizedPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PredicatePrimaryContext extends PrimaryContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicatePrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitPredicatePrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primary);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new ParenthesizedPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(LPAREN);
				setState(43);
				orExpr();
				setState(44);
				match(RPAREN);
				}
				break;
			case ATTRIBUTE_EXISTS:
			case ATTRIBUTE_NOT_EXISTS:
			case ATTRIBUTE_TYPE:
			case BEGINS_WITH:
			case CONTAINS:
			case SIZE:
			case IDENTIFIER:
				_localctx = new PredicatePrimaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				predicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributeNotExistsPredicateContext extends PredicateContext {
		public TerminalNode ATTRIBUTE_NOT_EXISTS() { return getToken(DynamoDbConditionExpressionParser.ATTRIBUTE_NOT_EXISTS, 0); }
		public TerminalNode LPAREN() { return getToken(DynamoDbConditionExpressionParser.LPAREN, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DynamoDbConditionExpressionParser.RPAREN, 0); }
		public AttributeNotExistsPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitAttributeNotExistsPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeExistsPredicateContext extends PredicateContext {
		public TerminalNode ATTRIBUTE_EXISTS() { return getToken(DynamoDbConditionExpressionParser.ATTRIBUTE_EXISTS, 0); }
		public TerminalNode LPAREN() { return getToken(DynamoDbConditionExpressionParser.LPAREN, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DynamoDbConditionExpressionParser.RPAREN, 0); }
		public AttributeExistsPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitAttributeExistsPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonPredicateContext extends PredicateContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ComparisonPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitComparisonPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InPredicateContext extends PredicateContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode IN() { return getToken(DynamoDbConditionExpressionParser.IN, 0); }
		public TerminalNode LPAREN() { return getToken(DynamoDbConditionExpressionParser.LPAREN, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(DynamoDbConditionExpressionParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DynamoDbConditionExpressionParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DynamoDbConditionExpressionParser.COMMA, i);
		}
		public InPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitInPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BeginsWithPredicateContext extends PredicateContext {
		public TerminalNode BEGINS_WITH() { return getToken(DynamoDbConditionExpressionParser.BEGINS_WITH, 0); }
		public TerminalNode LPAREN() { return getToken(DynamoDbConditionExpressionParser.LPAREN, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DynamoDbConditionExpressionParser.COMMA, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DynamoDbConditionExpressionParser.RPAREN, 0); }
		public BeginsWithPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitBeginsWithPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeTypePredicateContext extends PredicateContext {
		public TerminalNode ATTRIBUTE_TYPE() { return getToken(DynamoDbConditionExpressionParser.ATTRIBUTE_TYPE, 0); }
		public TerminalNode LPAREN() { return getToken(DynamoDbConditionExpressionParser.LPAREN, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DynamoDbConditionExpressionParser.COMMA, 0); }
		public TerminalNode PLACEHOLDER() { return getToken(DynamoDbConditionExpressionParser.PLACEHOLDER, 0); }
		public TerminalNode RPAREN() { return getToken(DynamoDbConditionExpressionParser.RPAREN, 0); }
		public AttributeTypePredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitAttributeTypePredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenPredicateContext extends PredicateContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(DynamoDbConditionExpressionParser.BETWEEN, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode AND() { return getToken(DynamoDbConditionExpressionParser.AND, 0); }
		public BetweenPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitBetweenPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContainsPredicateContext extends PredicateContext {
		public TerminalNode CONTAINS() { return getToken(DynamoDbConditionExpressionParser.CONTAINS, 0); }
		public TerminalNode LPAREN() { return getToken(DynamoDbConditionExpressionParser.LPAREN, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DynamoDbConditionExpressionParser.COMMA, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DynamoDbConditionExpressionParser.RPAREN, 0); }
		public ContainsPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitContainsPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SizePredicateContext extends PredicateContext {
		public TerminalNode SIZE() { return getToken(DynamoDbConditionExpressionParser.SIZE, 0); }
		public TerminalNode LPAREN() { return getToken(DynamoDbConditionExpressionParser.LPAREN, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DynamoDbConditionExpressionParser.RPAREN, 0); }
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SizePredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitSizePredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predicate);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AttributeExistsPredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(ATTRIBUTE_EXISTS);
				setState(50);
				match(LPAREN);
				setState(51);
				path();
				setState(52);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new AttributeNotExistsPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(ATTRIBUTE_NOT_EXISTS);
				setState(55);
				match(LPAREN);
				setState(56);
				path();
				setState(57);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new AttributeTypePredicateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(ATTRIBUTE_TYPE);
				setState(60);
				match(LPAREN);
				setState(61);
				path();
				setState(62);
				match(COMMA);
				setState(63);
				match(PLACEHOLDER);
				setState(64);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new BeginsWithPredicateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				match(BEGINS_WITH);
				setState(67);
				match(LPAREN);
				setState(68);
				path();
				setState(69);
				match(COMMA);
				setState(70);
				value();
				setState(71);
				match(RPAREN);
				}
				break;
			case 5:
				_localctx = new ContainsPredicateContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				match(CONTAINS);
				setState(74);
				match(LPAREN);
				setState(75);
				path();
				setState(76);
				match(COMMA);
				setState(77);
				value();
				setState(78);
				match(RPAREN);
				}
				break;
			case 6:
				_localctx = new SizePredicateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				match(SIZE);
				setState(81);
				match(LPAREN);
				setState(82);
				path();
				setState(83);
				match(RPAREN);
				setState(84);
				comparator();
				setState(85);
				value();
				}
				break;
			case 7:
				_localctx = new BetweenPredicateContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(87);
				path();
				setState(88);
				match(BETWEEN);
				setState(89);
				value();
				setState(90);
				match(AND);
				setState(91);
				value();
				}
				break;
			case 8:
				_localctx = new InPredicateContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				path();
				setState(94);
				match(IN);
				setState(95);
				match(LPAREN);
				setState(96);
				value();
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(97);
					match(COMMA);
					setState(98);
					value();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(104);
				match(RPAREN);
				}
				break;
			case 9:
				_localctx = new ComparisonPredicateContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(106);
				path();
				setState(107);
				comparator();
				setState(108);
				value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(DynamoDbConditionExpressionParser.EQ, 0); }
		public TerminalNode NE() { return getToken(DynamoDbConditionExpressionParser.NE, 0); }
		public TerminalNode LT() { return getToken(DynamoDbConditionExpressionParser.LT, 0); }
		public TerminalNode LTE() { return getToken(DynamoDbConditionExpressionParser.LTE, 0); }
		public TerminalNode GT() { return getToken(DynamoDbConditionExpressionParser.GT, 0); }
		public TerminalNode GTE() { return getToken(DynamoDbConditionExpressionParser.GTE, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NE) | (1L << LTE) | (1L << GTE) | (1L << LT) | (1L << GT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DynamoDbConditionExpressionParser.IDENTIFIER, 0); }
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringValueContext extends ValueContext {
		public TerminalNode STRING_LITERAL() { return getToken(DynamoDbConditionExpressionParser.STRING_LITERAL, 0); }
		public StringValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlaceholderValueContext extends ValueContext {
		public TerminalNode PLACEHOLDER() { return getToken(DynamoDbConditionExpressionParser.PLACEHOLDER, 0); }
		public PlaceholderValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitPlaceholderValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierValueContext extends ValueContext {
		public TerminalNode IDENTIFIER() { return getToken(DynamoDbConditionExpressionParser.IDENTIFIER, 0); }
		public IdentifierValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitIdentifierValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanValueContext extends ValueContext {
		public TerminalNode BOOLEAN_LITERAL() { return getToken(DynamoDbConditionExpressionParser.BOOLEAN_LITERAL, 0); }
		public BooleanValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberValueContext extends ValueContext {
		public TerminalNode NUMBER_LITERAL() { return getToken(DynamoDbConditionExpressionParser.NUMBER_LITERAL, 0); }
		public NumberValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitNumberValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullValueContext extends ValueContext {
		public TerminalNode NULL_LITERAL() { return getToken(DynamoDbConditionExpressionParser.NULL_LITERAL, 0); }
		public NullValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DynamoDbConditionExpressionVisitor ) return ((DynamoDbConditionExpressionVisitor<? extends T>)visitor).visitNullValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLACEHOLDER:
				_localctx = new PlaceholderValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(PLACEHOLDER);
				}
				break;
			case STRING_LITERAL:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(STRING_LITERAL);
				}
				break;
			case NUMBER_LITERAL:
				_localctx = new NumberValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(NUMBER_LITERAL);
				}
				break;
			case BOOLEAN_LITERAL:
				_localctx = new BooleanValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				match(BOOLEAN_LITERAL);
				}
				break;
			case NULL_LITERAL:
				_localctx = new NullValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				match(NULL_LITERAL);
				}
				break;
			case IDENTIFIER:
				_localctx = new IdentifierValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(121);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\4\3\4\3\4\7\4#\n\4\f\4"+
		"\16\4&\13\4\3\5\3\5\3\5\5\5+\n\5\3\6\3\6\3\6\3\6\3\6\5\6\62\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7f\n\7\f\7\16"+
		"\7i\13\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7q\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n}\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\3\3\2\6\13\2\u0087"+
		"\2\24\3\2\2\2\4\27\3\2\2\2\6\37\3\2\2\2\b*\3\2\2\2\n\61\3\2\2\2\fp\3\2"+
		"\2\2\16r\3\2\2\2\20t\3\2\2\2\22|\3\2\2\2\24\25\5\4\3\2\25\26\7\2\2\3\26"+
		"\3\3\2\2\2\27\34\5\6\4\2\30\31\7\r\2\2\31\33\5\6\4\2\32\30\3\2\2\2\33"+
		"\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\5\3\2\2\2\36\34\3\2\2\2\37"+
		"$\5\b\5\2 !\7\f\2\2!#\5\b\5\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2"+
		"\2%\7\3\2\2\2&$\3\2\2\2\'(\7\16\2\2(+\5\b\5\2)+\5\n\6\2*\'\3\2\2\2*)\3"+
		"\2\2\2+\t\3\2\2\2,-\7\3\2\2-.\5\4\3\2./\7\4\2\2/\62\3\2\2\2\60\62\5\f"+
		"\7\2\61,\3\2\2\2\61\60\3\2\2\2\62\13\3\2\2\2\63\64\7\21\2\2\64\65\7\3"+
		"\2\2\65\66\5\20\t\2\66\67\7\4\2\2\67q\3\2\2\289\7\22\2\29:\7\3\2\2:;\5"+
		"\20\t\2;<\7\4\2\2<q\3\2\2\2=>\7\23\2\2>?\7\3\2\2?@\5\20\t\2@A\7\5\2\2"+
		"AB\7\31\2\2BC\7\4\2\2Cq\3\2\2\2DE\7\24\2\2EF\7\3\2\2FG\5\20\t\2GH\7\5"+
		"\2\2HI\5\22\n\2IJ\7\4\2\2Jq\3\2\2\2KL\7\25\2\2LM\7\3\2\2MN\5\20\t\2NO"+
		"\7\5\2\2OP\5\22\n\2PQ\7\4\2\2Qq\3\2\2\2RS\7\26\2\2ST\7\3\2\2TU\5\20\t"+
		"\2UV\7\4\2\2VW\5\16\b\2WX\5\22\n\2Xq\3\2\2\2YZ\5\20\t\2Z[\7\17\2\2[\\"+
		"\5\22\n\2\\]\7\f\2\2]^\5\22\n\2^q\3\2\2\2_`\5\20\t\2`a\7\20\2\2ab\7\3"+
		"\2\2bg\5\22\n\2cd\7\5\2\2df\5\22\n\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3"+
		"\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7\4\2\2kq\3\2\2\2lm\5\20\t\2mn\5\16\b\2n"+
		"o\5\22\n\2oq\3\2\2\2p\63\3\2\2\2p8\3\2\2\2p=\3\2\2\2pD\3\2\2\2pK\3\2\2"+
		"\2pR\3\2\2\2pY\3\2\2\2p_\3\2\2\2pl\3\2\2\2q\r\3\2\2\2rs\t\2\2\2s\17\3"+
		"\2\2\2tu\7\34\2\2u\21\3\2\2\2v}\7\31\2\2w}\7\33\2\2x}\7\32\2\2y}\7\27"+
		"\2\2z}\7\30\2\2{}\7\34\2\2|v\3\2\2\2|w\3\2\2\2|x\3\2\2\2|y\3\2\2\2|z\3"+
		"\2\2\2|{\3\2\2\2}\23\3\2\2\2\t\34$*\61gp|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}