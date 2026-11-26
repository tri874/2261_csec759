// Generated from org/evomaster/core/parser/RegexJavaParser.g4 by ANTLR 4.9.2
package org.evomaster.core.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RegexJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAMED_CAPTURE_GROUP_OPEN=1, FLAG_GROUP_OPEN=2, FLAG_SCOPE_OPEN=3, CharacterEscape=4, 
		DecimalDigit=5, CharacterClassEscape=6, StartOfInputAssertion=7, EndOfInputAssertion=8, 
		WordBoundaryAssertion=9, NonWordBoundaryAssertion=10, EQUAL=11, LESS_THAN=12, 
		CARET=13, DOLLAR=14, SLASH=15, DOT=16, STAR=17, PLUS=18, QUESTION=19, 
		PAREN_open=20, PAREN_close=21, BRACKET_close=22, BRACE_open=23, BRACE_close=24, 
		OR=25, MINUS=26, COMMA=27, COLON=28, BaseChar=29, BackReference=30, NamedBackReference=31, 
		QUOTE_OPEN=32, BRACKET_open=33, QUOTE_CLOSE=34, QUOTE_CONTENT=35, CC_DOUBLE_AMPERSAND=36;
	public static final int
		RULE_pattern = 0, RULE_disjunction = 1, RULE_alternative = 2, RULE_term = 3, 
		RULE_assertion = 4, RULE_quantifier = 5, RULE_quantifierPrefix = 6, RULE_bracketQuantifier = 7, 
		RULE_bracketQuantifierSingle = 8, RULE_bracketQuantifierOnlyMin = 9, RULE_bracketQuantifierRange = 10, 
		RULE_atom = 11, RULE_quote = 12, RULE_patternCharacter = 13, RULE_characterClass = 14, 
		RULE_classContents = 15, RULE_classRanges = 16, RULE_nonemptyClassRanges = 17, 
		RULE_nonemptyClassRangesNoDash = 18, RULE_classAtom = 19, RULE_classAtomNoDash = 20, 
		RULE_decimalDigits = 21, RULE_classEscape = 22, RULE_atomEscape = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"pattern", "disjunction", "alternative", "term", "assertion", "quantifier", 
			"quantifierPrefix", "bracketQuantifier", "bracketQuantifierSingle", "bracketQuantifierOnlyMin", 
			"bracketQuantifierRange", "atom", "quote", "patternCharacter", "characterClass", 
			"classContents", "classRanges", "nonemptyClassRanges", "nonemptyClassRangesNoDash", 
			"classAtom", "classAtomNoDash", "decimalDigits", "classEscape", "atomEscape"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "'='", 
			"'<'", null, "'$'", "'\\'", "'.'", "'*'", "'+'", "'?'", "'('", "')'", 
			null, "'{'", "'}'", "'|'", null, "','", "':'", null, null, null, null, 
			"'['", null, null, "'&&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAMED_CAPTURE_GROUP_OPEN", "FLAG_GROUP_OPEN", "FLAG_SCOPE_OPEN", 
			"CharacterEscape", "DecimalDigit", "CharacterClassEscape", "StartOfInputAssertion", 
			"EndOfInputAssertion", "WordBoundaryAssertion", "NonWordBoundaryAssertion", 
			"EQUAL", "LESS_THAN", "CARET", "DOLLAR", "SLASH", "DOT", "STAR", "PLUS", 
			"QUESTION", "PAREN_open", "PAREN_close", "BRACKET_close", "BRACE_open", 
			"BRACE_close", "OR", "MINUS", "COMMA", "COLON", "BaseChar", "BackReference", 
			"NamedBackReference", "QUOTE_OPEN", "BRACKET_open", "QUOTE_CLOSE", "QUOTE_CONTENT", 
			"CC_DOUBLE_AMPERSAND"
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
	public String getGrammarFileName() { return "RegexJavaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RegexJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PatternContext extends ParserRuleContext {
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RegexJavaParser.EOF, 0); }
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			disjunction();
			setState(49);
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

	public static class DisjunctionContext extends ParserRuleContext {
		public AlternativeContext alternative() {
			return getRuleContext(AlternativeContext.class,0);
		}
		public TerminalNode OR() { return getToken(RegexJavaParser.OR, 0); }
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_disjunction);
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				alternative();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				alternative();
				setState(53);
				match(OR);
				setState(54);
				disjunction();
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

	public static class AlternativeContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternative; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitAlternative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternativeContext alternative() throws RecognitionException {
		AlternativeContext _localctx = new AlternativeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAMED_CAPTURE_GROUP_OPEN) | (1L << FLAG_GROUP_OPEN) | (1L << FLAG_SCOPE_OPEN) | (1L << CharacterEscape) | (1L << DecimalDigit) | (1L << CharacterClassEscape) | (1L << StartOfInputAssertion) | (1L << EndOfInputAssertion) | (1L << WordBoundaryAssertion) | (1L << NonWordBoundaryAssertion) | (1L << EQUAL) | (1L << LESS_THAN) | (1L << CARET) | (1L << DOLLAR) | (1L << DOT) | (1L << PAREN_open) | (1L << BRACKET_close) | (1L << BRACE_close) | (1L << MINUS) | (1L << COMMA) | (1L << COLON) | (1L << BaseChar) | (1L << BackReference) | (1L << NamedBackReference) | (1L << QUOTE_OPEN) | (1L << BRACKET_open))) != 0)) {
				{
				{
				setState(58);
				term();
				}
				}
				setState(63);
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

	public static class TermContext extends ParserRuleContext {
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
		}
		public TerminalNode FLAG_SCOPE_OPEN() { return getToken(RegexJavaParser.FLAG_SCOPE_OPEN, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				assertion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(FLAG_SCOPE_OPEN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				atom();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				atom();
				setState(68);
				quantifier();
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

	public static class AssertionContext extends ParserRuleContext {
		public TerminalNode CARET() { return getToken(RegexJavaParser.CARET, 0); }
		public TerminalNode DOLLAR() { return getToken(RegexJavaParser.DOLLAR, 0); }
		public TerminalNode PAREN_open() { return getToken(RegexJavaParser.PAREN_open, 0); }
		public TerminalNode QUESTION() { return getToken(RegexJavaParser.QUESTION, 0); }
		public TerminalNode EQUAL() { return getToken(RegexJavaParser.EQUAL, 0); }
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public TerminalNode PAREN_close() { return getToken(RegexJavaParser.PAREN_close, 0); }
		public TerminalNode LESS_THAN() { return getToken(RegexJavaParser.LESS_THAN, 0); }
		public TerminalNode StartOfInputAssertion() { return getToken(RegexJavaParser.StartOfInputAssertion, 0); }
		public TerminalNode EndOfInputAssertion() { return getToken(RegexJavaParser.EndOfInputAssertion, 0); }
		public TerminalNode WordBoundaryAssertion() { return getToken(RegexJavaParser.WordBoundaryAssertion, 0); }
		public TerminalNode NonWordBoundaryAssertion() { return getToken(RegexJavaParser.NonWordBoundaryAssertion, 0); }
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitAssertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assertion);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(CARET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(DOLLAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(PAREN_open);
				setState(75);
				match(QUESTION);
				setState(76);
				match(EQUAL);
				setState(77);
				disjunction();
				setState(78);
				match(PAREN_close);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(PAREN_open);
				setState(81);
				match(QUESTION);
				setState(82);
				match(LESS_THAN);
				setState(83);
				match(EQUAL);
				setState(84);
				disjunction();
				setState(85);
				match(PAREN_close);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				match(StartOfInputAssertion);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				match(EndOfInputAssertion);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(89);
				match(WordBoundaryAssertion);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(90);
				match(NonWordBoundaryAssertion);
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

	public static class QuantifierContext extends ParserRuleContext {
		public QuantifierPrefixContext quantifierPrefix() {
			return getRuleContext(QuantifierPrefixContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(RegexJavaParser.QUESTION, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_quantifier);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				quantifierPrefix();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				quantifierPrefix();
				setState(95);
				match(QUESTION);
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

	public static class QuantifierPrefixContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(RegexJavaParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(RegexJavaParser.PLUS, 0); }
		public TerminalNode QUESTION() { return getToken(RegexJavaParser.QUESTION, 0); }
		public BracketQuantifierContext bracketQuantifier() {
			return getRuleContext(BracketQuantifierContext.class,0);
		}
		public QuantifierPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifierPrefix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitQuantifierPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierPrefixContext quantifierPrefix() throws RecognitionException {
		QuantifierPrefixContext _localctx = new QuantifierPrefixContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_quantifierPrefix);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(STAR);
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(PLUS);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(QUESTION);
				}
				break;
			case BRACE_open:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				bracketQuantifier();
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

	public static class BracketQuantifierContext extends ParserRuleContext {
		public BracketQuantifierSingleContext bracketQuantifierSingle() {
			return getRuleContext(BracketQuantifierSingleContext.class,0);
		}
		public BracketQuantifierOnlyMinContext bracketQuantifierOnlyMin() {
			return getRuleContext(BracketQuantifierOnlyMinContext.class,0);
		}
		public BracketQuantifierRangeContext bracketQuantifierRange() {
			return getRuleContext(BracketQuantifierRangeContext.class,0);
		}
		public BracketQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitBracketQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierContext bracketQuantifier() throws RecognitionException {
		BracketQuantifierContext _localctx = new BracketQuantifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bracketQuantifier);
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				bracketQuantifierSingle();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				bracketQuantifierOnlyMin();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				bracketQuantifierRange();
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

	public static class BracketQuantifierSingleContext extends ParserRuleContext {
		public TerminalNode BRACE_open() { return getToken(RegexJavaParser.BRACE_open, 0); }
		public DecimalDigitsContext decimalDigits() {
			return getRuleContext(DecimalDigitsContext.class,0);
		}
		public TerminalNode BRACE_close() { return getToken(RegexJavaParser.BRACE_close, 0); }
		public BracketQuantifierSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierSingle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitBracketQuantifierSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierSingleContext bracketQuantifierSingle() throws RecognitionException {
		BracketQuantifierSingleContext _localctx = new BracketQuantifierSingleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bracketQuantifierSingle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(BRACE_open);
			setState(111);
			decimalDigits();
			setState(112);
			match(BRACE_close);
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

	public static class BracketQuantifierOnlyMinContext extends ParserRuleContext {
		public TerminalNode BRACE_open() { return getToken(RegexJavaParser.BRACE_open, 0); }
		public DecimalDigitsContext decimalDigits() {
			return getRuleContext(DecimalDigitsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(RegexJavaParser.COMMA, 0); }
		public TerminalNode BRACE_close() { return getToken(RegexJavaParser.BRACE_close, 0); }
		public BracketQuantifierOnlyMinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierOnlyMin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitBracketQuantifierOnlyMin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierOnlyMinContext bracketQuantifierOnlyMin() throws RecognitionException {
		BracketQuantifierOnlyMinContext _localctx = new BracketQuantifierOnlyMinContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bracketQuantifierOnlyMin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(BRACE_open);
			setState(115);
			decimalDigits();
			setState(116);
			match(COMMA);
			setState(117);
			match(BRACE_close);
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

	public static class BracketQuantifierRangeContext extends ParserRuleContext {
		public TerminalNode BRACE_open() { return getToken(RegexJavaParser.BRACE_open, 0); }
		public List<DecimalDigitsContext> decimalDigits() {
			return getRuleContexts(DecimalDigitsContext.class);
		}
		public DecimalDigitsContext decimalDigits(int i) {
			return getRuleContext(DecimalDigitsContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(RegexJavaParser.COMMA, 0); }
		public TerminalNode BRACE_close() { return getToken(RegexJavaParser.BRACE_close, 0); }
		public BracketQuantifierRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierRange; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitBracketQuantifierRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierRangeContext bracketQuantifierRange() throws RecognitionException {
		BracketQuantifierRangeContext _localctx = new BracketQuantifierRangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bracketQuantifierRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(BRACE_open);
			setState(120);
			decimalDigits();
			setState(121);
			match(COMMA);
			setState(122);
			decimalDigits();
			setState(123);
			match(BRACE_close);
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

	public static class AtomContext extends ParserRuleContext {
		public QuoteContext quote() {
			return getRuleContext(QuoteContext.class,0);
		}
		public List<PatternCharacterContext> patternCharacter() {
			return getRuleContexts(PatternCharacterContext.class);
		}
		public PatternCharacterContext patternCharacter(int i) {
			return getRuleContext(PatternCharacterContext.class,i);
		}
		public TerminalNode DOT() { return getToken(RegexJavaParser.DOT, 0); }
		public AtomEscapeContext atomEscape() {
			return getRuleContext(AtomEscapeContext.class,0);
		}
		public CharacterClassContext characterClass() {
			return getRuleContext(CharacterClassContext.class,0);
		}
		public TerminalNode FLAG_GROUP_OPEN() { return getToken(RegexJavaParser.FLAG_GROUP_OPEN, 0); }
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public TerminalNode PAREN_close() { return getToken(RegexJavaParser.PAREN_close, 0); }
		public TerminalNode PAREN_open() { return getToken(RegexJavaParser.PAREN_open, 0); }
		public TerminalNode QUESTION() { return getToken(RegexJavaParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(RegexJavaParser.COLON, 0); }
		public TerminalNode NAMED_CAPTURE_GROUP_OPEN() { return getToken(RegexJavaParser.NAMED_CAPTURE_GROUP_OPEN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atom);
		try {
			int _alt;
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				quote();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(126);
						patternCharacter();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(129); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(DOT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				atomEscape();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				characterClass();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(134);
				match(FLAG_GROUP_OPEN);
				setState(135);
				disjunction();
				setState(136);
				match(PAREN_close);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(138);
				match(PAREN_open);
				setState(139);
				disjunction();
				setState(140);
				match(PAREN_close);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(142);
				match(PAREN_open);
				setState(143);
				match(QUESTION);
				setState(144);
				match(COLON);
				setState(145);
				disjunction();
				setState(146);
				match(PAREN_close);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(148);
				match(NAMED_CAPTURE_GROUP_OPEN);
				setState(149);
				disjunction();
				setState(150);
				match(PAREN_close);
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

	public static class QuoteContext extends ParserRuleContext {
		public TerminalNode QUOTE_OPEN() { return getToken(RegexJavaParser.QUOTE_OPEN, 0); }
		public TerminalNode QUOTE_CONTENT() { return getToken(RegexJavaParser.QUOTE_CONTENT, 0); }
		public TerminalNode QUOTE_CLOSE() { return getToken(RegexJavaParser.QUOTE_CLOSE, 0); }
		public QuoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quote; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitQuote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuoteContext quote() throws RecognitionException {
		QuoteContext _localctx = new QuoteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_quote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(QUOTE_OPEN);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUOTE_CONTENT) {
				{
				setState(155);
				match(QUOTE_CONTENT);
				}
			}

			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUOTE_CLOSE) {
				{
				setState(158);
				match(QUOTE_CLOSE);
				}
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

	public static class PatternCharacterContext extends ParserRuleContext {
		public TerminalNode BaseChar() { return getToken(RegexJavaParser.BaseChar, 0); }
		public TerminalNode COMMA() { return getToken(RegexJavaParser.COMMA, 0); }
		public TerminalNode MINUS() { return getToken(RegexJavaParser.MINUS, 0); }
		public TerminalNode DecimalDigit() { return getToken(RegexJavaParser.DecimalDigit, 0); }
		public TerminalNode BRACE_close() { return getToken(RegexJavaParser.BRACE_close, 0); }
		public TerminalNode BRACKET_close() { return getToken(RegexJavaParser.BRACKET_close, 0); }
		public TerminalNode COLON() { return getToken(RegexJavaParser.COLON, 0); }
		public TerminalNode EQUAL() { return getToken(RegexJavaParser.EQUAL, 0); }
		public TerminalNode LESS_THAN() { return getToken(RegexJavaParser.LESS_THAN, 0); }
		public PatternCharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternCharacter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitPatternCharacter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternCharacterContext patternCharacter() throws RecognitionException {
		PatternCharacterContext _localctx = new PatternCharacterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_patternCharacter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DecimalDigit) | (1L << EQUAL) | (1L << LESS_THAN) | (1L << BRACKET_close) | (1L << BRACE_close) | (1L << MINUS) | (1L << COMMA) | (1L << COLON) | (1L << BaseChar))) != 0)) ) {
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

	public static class CharacterClassContext extends ParserRuleContext {
		public TerminalNode BRACKET_open() { return getToken(RegexJavaParser.BRACKET_open, 0); }
		public TerminalNode CARET() { return getToken(RegexJavaParser.CARET, 0); }
		public ClassContentsContext classContents() {
			return getRuleContext(ClassContentsContext.class,0);
		}
		public TerminalNode BRACKET_close() { return getToken(RegexJavaParser.BRACKET_close, 0); }
		public CharacterClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitCharacterClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharacterClassContext characterClass() throws RecognitionException {
		CharacterClassContext _localctx = new CharacterClassContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_characterClass);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(BRACKET_open);
				setState(164);
				match(CARET);
				setState(165);
				classContents();
				setState(166);
				match(BRACKET_close);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(BRACKET_open);
				setState(169);
				classContents();
				setState(170);
				match(BRACKET_close);
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

	public static class ClassContentsContext extends ParserRuleContext {
		public List<ClassRangesContext> classRanges() {
			return getRuleContexts(ClassRangesContext.class);
		}
		public ClassRangesContext classRanges(int i) {
			return getRuleContext(ClassRangesContext.class,i);
		}
		public List<TerminalNode> CC_DOUBLE_AMPERSAND() { return getTokens(RegexJavaParser.CC_DOUBLE_AMPERSAND); }
		public TerminalNode CC_DOUBLE_AMPERSAND(int i) {
			return getToken(RegexJavaParser.CC_DOUBLE_AMPERSAND, i);
		}
		public ClassContentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classContents; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitClassContents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContentsContext classContents() throws RecognitionException {
		ClassContentsContext _localctx = new ClassContentsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_classContents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			classRanges();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CC_DOUBLE_AMPERSAND) {
				{
				{
				setState(175);
				match(CC_DOUBLE_AMPERSAND);
				setState(176);
				classRanges();
				}
				}
				setState(181);
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

	public static class ClassRangesContext extends ParserRuleContext {
		public NonemptyClassRangesContext nonemptyClassRanges() {
			return getRuleContext(NonemptyClassRangesContext.class,0);
		}
		public CharacterClassContext characterClass() {
			return getRuleContext(CharacterClassContext.class,0);
		}
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public ClassRangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classRanges; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitClassRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassRangesContext classRanges() throws RecognitionException {
		ClassRangesContext _localctx = new ClassRangesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_classRanges);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_close:
			case CC_DOUBLE_AMPERSAND:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case CharacterEscape:
			case CharacterClassEscape:
			case CARET:
			case MINUS:
			case BaseChar:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				nonemptyClassRanges();
				}
				break;
			case BRACKET_open:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				characterClass();
				setState(185);
				classRanges();
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

	public static class NonemptyClassRangesContext extends ParserRuleContext {
		public List<ClassAtomContext> classAtom() {
			return getRuleContexts(ClassAtomContext.class);
		}
		public ClassAtomContext classAtom(int i) {
			return getRuleContext(ClassAtomContext.class,i);
		}
		public NonemptyClassRangesNoDashContext nonemptyClassRangesNoDash() {
			return getRuleContext(NonemptyClassRangesNoDashContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(RegexJavaParser.MINUS, 0); }
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public NonemptyClassRangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonemptyClassRanges; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitNonemptyClassRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonemptyClassRangesContext nonemptyClassRanges() throws RecognitionException {
		NonemptyClassRangesContext _localctx = new NonemptyClassRangesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_nonemptyClassRanges);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				classAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				classAtom();
				setState(191);
				nonemptyClassRangesNoDash();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				classAtom();
				setState(194);
				match(MINUS);
				setState(195);
				classAtom();
				setState(196);
				classRanges();
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

	public static class NonemptyClassRangesNoDashContext extends ParserRuleContext {
		public ClassAtomContext classAtom() {
			return getRuleContext(ClassAtomContext.class,0);
		}
		public ClassAtomNoDashContext classAtomNoDash() {
			return getRuleContext(ClassAtomNoDashContext.class,0);
		}
		public NonemptyClassRangesNoDashContext nonemptyClassRangesNoDash() {
			return getRuleContext(NonemptyClassRangesNoDashContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(RegexJavaParser.MINUS, 0); }
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public CharacterClassContext characterClass() {
			return getRuleContext(CharacterClassContext.class,0);
		}
		public NonemptyClassRangesNoDashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonemptyClassRangesNoDash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitNonemptyClassRangesNoDash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonemptyClassRangesNoDashContext nonemptyClassRangesNoDash() throws RecognitionException {
		NonemptyClassRangesNoDashContext _localctx = new NonemptyClassRangesNoDashContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_nonemptyClassRangesNoDash);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				classAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				classAtomNoDash();
				setState(202);
				nonemptyClassRangesNoDash();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				classAtomNoDash();
				setState(205);
				match(MINUS);
				setState(206);
				classAtom();
				setState(207);
				classRanges();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				characterClass();
				setState(210);
				classRanges();
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

	public static class ClassAtomContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(RegexJavaParser.MINUS, 0); }
		public ClassAtomNoDashContext classAtomNoDash() {
			return getRuleContext(ClassAtomNoDashContext.class,0);
		}
		public ClassAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitClassAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassAtomContext classAtom() throws RecognitionException {
		ClassAtomContext _localctx = new ClassAtomContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_classAtom);
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(MINUS);
				}
				break;
			case CharacterEscape:
			case CharacterClassEscape:
			case CARET:
			case BaseChar:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				classAtomNoDash();
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

	public static class ClassAtomNoDashContext extends ParserRuleContext {
		public ClassEscapeContext classEscape() {
			return getRuleContext(ClassEscapeContext.class,0);
		}
		public TerminalNode CARET() { return getToken(RegexJavaParser.CARET, 0); }
		public TerminalNode BaseChar() { return getToken(RegexJavaParser.BaseChar, 0); }
		public ClassAtomNoDashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classAtomNoDash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitClassAtomNoDash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassAtomNoDashContext classAtomNoDash() throws RecognitionException {
		ClassAtomNoDashContext _localctx = new ClassAtomNoDashContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classAtomNoDash);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CharacterEscape:
			case CharacterClassEscape:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				classEscape();
				}
				break;
			case CARET:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(CARET);
				}
				break;
			case BaseChar:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				match(BaseChar);
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

	public static class DecimalDigitsContext extends ParserRuleContext {
		public List<TerminalNode> DecimalDigit() { return getTokens(RegexJavaParser.DecimalDigit); }
		public TerminalNode DecimalDigit(int i) {
			return getToken(RegexJavaParser.DecimalDigit, i);
		}
		public DecimalDigitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalDigits; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitDecimalDigits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalDigitsContext decimalDigits() throws RecognitionException {
		DecimalDigitsContext _localctx = new DecimalDigitsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_decimalDigits);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(223);
				match(DecimalDigit);
				}
				}
				setState(226); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DecimalDigit );
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

	public static class ClassEscapeContext extends ParserRuleContext {
		public TerminalNode CharacterClassEscape() { return getToken(RegexJavaParser.CharacterClassEscape, 0); }
		public TerminalNode CharacterEscape() { return getToken(RegexJavaParser.CharacterEscape, 0); }
		public ClassEscapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classEscape; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitClassEscape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassEscapeContext classEscape() throws RecognitionException {
		ClassEscapeContext _localctx = new ClassEscapeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_classEscape);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_la = _input.LA(1);
			if ( !(_la==CharacterEscape || _la==CharacterClassEscape) ) {
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

	public static class AtomEscapeContext extends ParserRuleContext {
		public TerminalNode CharacterClassEscape() { return getToken(RegexJavaParser.CharacterClassEscape, 0); }
		public TerminalNode CharacterEscape() { return getToken(RegexJavaParser.CharacterEscape, 0); }
		public TerminalNode BackReference() { return getToken(RegexJavaParser.BackReference, 0); }
		public TerminalNode NamedBackReference() { return getToken(RegexJavaParser.NamedBackReference, 0); }
		public AtomEscapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomEscape; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexJavaParserVisitor ) return ((RegexJavaParserVisitor<? extends T>)visitor).visitAtomEscape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomEscapeContext atomEscape() throws RecognitionException {
		AtomEscapeContext _localctx = new AtomEscapeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_atomEscape);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CharacterEscape) | (1L << CharacterClassEscape) | (1L << BackReference) | (1L << NamedBackReference))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3;\n\3\3\4\7\4>\n\4\f\4\16\4A\13\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5I\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6^\n\6\3\7\3\7\3\7\3\7\5\7"+
		"d\n\7\3\b\3\b\3\b\3\b\5\bj\n\b\3\t\3\t\3\t\5\to\n\t\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\6\r\u0082\n\r"+
		"\r\r\16\r\u0083\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009b\n\r\3\16\3\16\5\16\u009f\n\16"+
		"\3\16\5\16\u00a2\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00af\n\20\3\21\3\21\3\21\7\21\u00b4\n\21\f\21\16\21\u00b7"+
		"\13\21\3\22\3\22\3\22\3\22\3\22\5\22\u00be\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u00c9\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d7\n\24\3\25\3\25\5\25\u00db\n"+
		"\25\3\26\3\26\3\26\5\26\u00e0\n\26\3\27\6\27\u00e3\n\27\r\27\16\27\u00e4"+
		"\3\30\3\30\3\31\3\31\3\31\2\2\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\2\5\7\2\7\7\r\16\30\30\32\32\34\37\4\2\6\6\b\b\5\2\6\6\b"+
		"\b !\2\u00fc\2\62\3\2\2\2\4:\3\2\2\2\6?\3\2\2\2\bH\3\2\2\2\n]\3\2\2\2"+
		"\fc\3\2\2\2\16i\3\2\2\2\20n\3\2\2\2\22p\3\2\2\2\24t\3\2\2\2\26y\3\2\2"+
		"\2\30\u009a\3\2\2\2\32\u009c\3\2\2\2\34\u00a3\3\2\2\2\36\u00ae\3\2\2\2"+
		" \u00b0\3\2\2\2\"\u00bd\3\2\2\2$\u00c8\3\2\2\2&\u00d6\3\2\2\2(\u00da\3"+
		"\2\2\2*\u00df\3\2\2\2,\u00e2\3\2\2\2.\u00e6\3\2\2\2\60\u00e8\3\2\2\2\62"+
		"\63\5\4\3\2\63\64\7\2\2\3\64\3\3\2\2\2\65;\5\6\4\2\66\67\5\6\4\2\678\7"+
		"\33\2\289\5\4\3\29;\3\2\2\2:\65\3\2\2\2:\66\3\2\2\2;\5\3\2\2\2<>\5\b\5"+
		"\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\7\3\2\2\2A?\3\2\2\2BI\5\n"+
		"\6\2CI\7\5\2\2DI\5\30\r\2EF\5\30\r\2FG\5\f\7\2GI\3\2\2\2HB\3\2\2\2HC\3"+
		"\2\2\2HD\3\2\2\2HE\3\2\2\2I\t\3\2\2\2J^\7\17\2\2K^\7\20\2\2LM\7\26\2\2"+
		"MN\7\25\2\2NO\7\r\2\2OP\5\4\3\2PQ\7\27\2\2Q^\3\2\2\2RS\7\26\2\2ST\7\25"+
		"\2\2TU\7\16\2\2UV\7\r\2\2VW\5\4\3\2WX\7\27\2\2X^\3\2\2\2Y^\7\t\2\2Z^\7"+
		"\n\2\2[^\7\13\2\2\\^\7\f\2\2]J\3\2\2\2]K\3\2\2\2]L\3\2\2\2]R\3\2\2\2]"+
		"Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\13\3\2\2\2_d\5\16\b\2`a\5\16"+
		"\b\2ab\7\25\2\2bd\3\2\2\2c_\3\2\2\2c`\3\2\2\2d\r\3\2\2\2ej\7\23\2\2fj"+
		"\7\24\2\2gj\7\25\2\2hj\5\20\t\2ie\3\2\2\2if\3\2\2\2ig\3\2\2\2ih\3\2\2"+
		"\2j\17\3\2\2\2ko\5\22\n\2lo\5\24\13\2mo\5\26\f\2nk\3\2\2\2nl\3\2\2\2n"+
		"m\3\2\2\2o\21\3\2\2\2pq\7\31\2\2qr\5,\27\2rs\7\32\2\2s\23\3\2\2\2tu\7"+
		"\31\2\2uv\5,\27\2vw\7\35\2\2wx\7\32\2\2x\25\3\2\2\2yz\7\31\2\2z{\5,\27"+
		"\2{|\7\35\2\2|}\5,\27\2}~\7\32\2\2~\27\3\2\2\2\177\u009b\5\32\16\2\u0080"+
		"\u0082\5\34\17\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u009b\3\2\2\2\u0085\u009b\7\22\2\2\u0086"+
		"\u009b\5\60\31\2\u0087\u009b\5\36\20\2\u0088\u0089\7\4\2\2\u0089\u008a"+
		"\5\4\3\2\u008a\u008b\7\27\2\2\u008b\u009b\3\2\2\2\u008c\u008d\7\26\2\2"+
		"\u008d\u008e\5\4\3\2\u008e\u008f\7\27\2\2\u008f\u009b\3\2\2\2\u0090\u0091"+
		"\7\26\2\2\u0091\u0092\7\25\2\2\u0092\u0093\7\36\2\2\u0093\u0094\5\4\3"+
		"\2\u0094\u0095\7\27\2\2\u0095\u009b\3\2\2\2\u0096\u0097\7\3\2\2\u0097"+
		"\u0098\5\4\3\2\u0098\u0099\7\27\2\2\u0099\u009b\3\2\2\2\u009a\177\3\2"+
		"\2\2\u009a\u0081\3\2\2\2\u009a\u0085\3\2\2\2\u009a\u0086\3\2\2\2\u009a"+
		"\u0087\3\2\2\2\u009a\u0088\3\2\2\2\u009a\u008c\3\2\2\2\u009a\u0090\3\2"+
		"\2\2\u009a\u0096\3\2\2\2\u009b\31\3\2\2\2\u009c\u009e\7\"\2\2\u009d\u009f"+
		"\7%\2\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0"+
		"\u00a2\7$\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\33\3\2\2\2"+
		"\u00a3\u00a4\t\2\2\2\u00a4\35\3\2\2\2\u00a5\u00a6\7#\2\2\u00a6\u00a7\7"+
		"\17\2\2\u00a7\u00a8\5 \21\2\u00a8\u00a9\7\30\2\2\u00a9\u00af\3\2\2\2\u00aa"+
		"\u00ab\7#\2\2\u00ab\u00ac\5 \21\2\u00ac\u00ad\7\30\2\2\u00ad\u00af\3\2"+
		"\2\2\u00ae\u00a5\3\2\2\2\u00ae\u00aa\3\2\2\2\u00af\37\3\2\2\2\u00b0\u00b5"+
		"\5\"\22\2\u00b1\u00b2\7&\2\2\u00b2\u00b4\5\"\22\2\u00b3\u00b1\3\2\2\2"+
		"\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6!\3"+
		"\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00be\3\2\2\2\u00b9\u00be\5$\23\2\u00ba"+
		"\u00bb\5\36\20\2\u00bb\u00bc\5\"\22\2\u00bc\u00be\3\2\2\2\u00bd\u00b8"+
		"\3\2\2\2\u00bd\u00b9\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be#\3\2\2\2\u00bf"+
		"\u00c9\5(\25\2\u00c0\u00c1\5(\25\2\u00c1\u00c2\5&\24\2\u00c2\u00c9\3\2"+
		"\2\2\u00c3\u00c4\5(\25\2\u00c4\u00c5\7\34\2\2\u00c5\u00c6\5(\25\2\u00c6"+
		"\u00c7\5\"\22\2\u00c7\u00c9\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c8\u00c0\3"+
		"\2\2\2\u00c8\u00c3\3\2\2\2\u00c9%\3\2\2\2\u00ca\u00d7\5(\25\2\u00cb\u00cc"+
		"\5*\26\2\u00cc\u00cd\5&\24\2\u00cd\u00d7\3\2\2\2\u00ce\u00cf\5*\26\2\u00cf"+
		"\u00d0\7\34\2\2\u00d0\u00d1\5(\25\2\u00d1\u00d2\5\"\22\2\u00d2\u00d7\3"+
		"\2\2\2\u00d3\u00d4\5\36\20\2\u00d4\u00d5\5\"\22\2\u00d5\u00d7\3\2\2\2"+
		"\u00d6\u00ca\3\2\2\2\u00d6\u00cb\3\2\2\2\u00d6\u00ce\3\2\2\2\u00d6\u00d3"+
		"\3\2\2\2\u00d7\'\3\2\2\2\u00d8\u00db\7\34\2\2\u00d9\u00db\5*\26\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db)\3\2\2\2\u00dc\u00e0\5.\30\2"+
		"\u00dd\u00e0\7\17\2\2\u00de\u00e0\7\37\2\2\u00df\u00dc\3\2\2\2\u00df\u00dd"+
		"\3\2\2\2\u00df\u00de\3\2\2\2\u00e0+\3\2\2\2\u00e1\u00e3\7\7\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5-\3\2\2\2\u00e6\u00e7\t\3\2\2\u00e7/\3\2\2\2\u00e8\u00e9\t\4"+
		"\2\2\u00e9\61\3\2\2\2\25:?H]cin\u0083\u009a\u009e\u00a1\u00ae\u00b5\u00bd"+
		"\u00c8\u00d6\u00da\u00df\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}