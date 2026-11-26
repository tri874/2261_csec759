// Generated from org/evomaster/core/parser/RegexEcma262.g4 by ANTLR 4.9.2
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
public class RegexEcma262Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CharacterEscape=1, ControlLetterExtendedEscape=2, DecimalDigit=3, CharacterClassEscape=4, 
		LowerCaseBEscape=5, CARET=6, DOLLAR=7, SLASH=8, DOT=9, STAR=10, PLUS=11, 
		QUESTION=12, PAREN_open=13, PAREN_close=14, BRACKET_open=15, BRACKET_close=16, 
		BRACE_open=17, BRACE_close=18, OR=19, MINUS=20, COMMA=21, BaseChar=22;
	public static final int
		RULE_pattern = 0, RULE_disjunction = 1, RULE_alternative = 2, RULE_term = 3, 
		RULE_assertion = 4, RULE_quantifier = 5, RULE_quantifierPrefix = 6, RULE_bracketQuantifier = 7, 
		RULE_bracketQuantifierSingle = 8, RULE_bracketQuantifierOnlyMin = 9, RULE_bracketQuantifierRange = 10, 
		RULE_atom = 11, RULE_patternCharacter = 12, RULE_characterClass = 13, 
		RULE_classRanges = 14, RULE_nonemptyClassRanges = 15, RULE_nonemptyClassRangesNoDash = 16, 
		RULE_classAtom = 17, RULE_classAtomNoDash = 18, RULE_classEscape = 19, 
		RULE_atomEscape = 20, RULE_decimalDigits = 21, RULE_controlLetterExtendedEscape = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"pattern", "disjunction", "alternative", "term", "assertion", "quantifier", 
			"quantifierPrefix", "bracketQuantifier", "bracketQuantifierSingle", "bracketQuantifierOnlyMin", 
			"bracketQuantifierRange", "atom", "patternCharacter", "characterClass", 
			"classRanges", "nonemptyClassRanges", "nonemptyClassRangesNoDash", "classAtom", 
			"classAtomNoDash", "classEscape", "atomEscape", "decimalDigits", "controlLetterExtendedEscape"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'^'", "'$'", "'\\'", "'.'", "'*'", 
			"'+'", "'?'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'|'", "'-'", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CharacterEscape", "ControlLetterExtendedEscape", "DecimalDigit", 
			"CharacterClassEscape", "LowerCaseBEscape", "CARET", "DOLLAR", "SLASH", 
			"DOT", "STAR", "PLUS", "QUESTION", "PAREN_open", "PAREN_close", "BRACKET_open", 
			"BRACKET_close", "BRACE_open", "BRACE_close", "OR", "MINUS", "COMMA", 
			"BaseChar"
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
	public String getGrammarFileName() { return "RegexEcma262.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RegexEcma262Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PatternContext extends ParserRuleContext {
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RegexEcma262Parser.EOF, 0); }
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			disjunction();
			setState(47);
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
		public TerminalNode OR() { return getToken(RegexEcma262Parser.OR, 0); }
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_disjunction);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				alternative();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				alternative();
				setState(51);
				match(OR);
				setState(52);
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
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitAlternative(this);
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CharacterEscape) | (1L << ControlLetterExtendedEscape) | (1L << DecimalDigit) | (1L << CharacterClassEscape) | (1L << CARET) | (1L << DOLLAR) | (1L << DOT) | (1L << PAREN_open) | (1L << BRACKET_open) | (1L << BRACKET_close) | (1L << BRACE_close) | (1L << MINUS) | (1L << COMMA) | (1L << BaseChar))) != 0)) {
				{
				{
				setState(56);
				term();
				}
				}
				setState(61);
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
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				assertion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				atom();
				setState(65);
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
		public TerminalNode CARET() { return getToken(RegexEcma262Parser.CARET, 0); }
		public TerminalNode DOLLAR() { return getToken(RegexEcma262Parser.DOLLAR, 0); }
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitAssertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assertion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==CARET || _la==DOLLAR) ) {
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

	public static class QuantifierContext extends ParserRuleContext {
		public QuantifierPrefixContext quantifierPrefix() {
			return getRuleContext(QuantifierPrefixContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(RegexEcma262Parser.QUESTION, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_quantifier);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				quantifierPrefix();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				quantifierPrefix();
				setState(73);
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
		public TerminalNode STAR() { return getToken(RegexEcma262Parser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(RegexEcma262Parser.PLUS, 0); }
		public TerminalNode QUESTION() { return getToken(RegexEcma262Parser.QUESTION, 0); }
		public BracketQuantifierContext bracketQuantifier() {
			return getRuleContext(BracketQuantifierContext.class,0);
		}
		public QuantifierPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifierPrefix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitQuantifierPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierPrefixContext quantifierPrefix() throws RecognitionException {
		QuantifierPrefixContext _localctx = new QuantifierPrefixContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_quantifierPrefix);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(STAR);
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(PLUS);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(QUESTION);
				}
				break;
			case BRACE_open:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
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
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitBracketQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierContext bracketQuantifier() throws RecognitionException {
		BracketQuantifierContext _localctx = new BracketQuantifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bracketQuantifier);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				bracketQuantifierSingle();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				bracketQuantifierOnlyMin();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
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
		public TerminalNode BRACE_open() { return getToken(RegexEcma262Parser.BRACE_open, 0); }
		public DecimalDigitsContext decimalDigits() {
			return getRuleContext(DecimalDigitsContext.class,0);
		}
		public TerminalNode BRACE_close() { return getToken(RegexEcma262Parser.BRACE_close, 0); }
		public BracketQuantifierSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierSingle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitBracketQuantifierSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierSingleContext bracketQuantifierSingle() throws RecognitionException {
		BracketQuantifierSingleContext _localctx = new BracketQuantifierSingleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bracketQuantifierSingle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(BRACE_open);
			setState(89);
			decimalDigits();
			setState(90);
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
		public TerminalNode BRACE_open() { return getToken(RegexEcma262Parser.BRACE_open, 0); }
		public DecimalDigitsContext decimalDigits() {
			return getRuleContext(DecimalDigitsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(RegexEcma262Parser.COMMA, 0); }
		public TerminalNode BRACE_close() { return getToken(RegexEcma262Parser.BRACE_close, 0); }
		public BracketQuantifierOnlyMinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierOnlyMin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitBracketQuantifierOnlyMin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierOnlyMinContext bracketQuantifierOnlyMin() throws RecognitionException {
		BracketQuantifierOnlyMinContext _localctx = new BracketQuantifierOnlyMinContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bracketQuantifierOnlyMin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(BRACE_open);
			setState(93);
			decimalDigits();
			setState(94);
			match(COMMA);
			setState(95);
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
		public TerminalNode BRACE_open() { return getToken(RegexEcma262Parser.BRACE_open, 0); }
		public List<DecimalDigitsContext> decimalDigits() {
			return getRuleContexts(DecimalDigitsContext.class);
		}
		public DecimalDigitsContext decimalDigits(int i) {
			return getRuleContext(DecimalDigitsContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(RegexEcma262Parser.COMMA, 0); }
		public TerminalNode BRACE_close() { return getToken(RegexEcma262Parser.BRACE_close, 0); }
		public BracketQuantifierRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierRange; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitBracketQuantifierRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierRangeContext bracketQuantifierRange() throws RecognitionException {
		BracketQuantifierRangeContext _localctx = new BracketQuantifierRangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bracketQuantifierRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(BRACE_open);
			setState(98);
			decimalDigits();
			setState(99);
			match(COMMA);
			setState(100);
			decimalDigits();
			setState(101);
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
		public List<PatternCharacterContext> patternCharacter() {
			return getRuleContexts(PatternCharacterContext.class);
		}
		public PatternCharacterContext patternCharacter(int i) {
			return getRuleContext(PatternCharacterContext.class,i);
		}
		public TerminalNode DOT() { return getToken(RegexEcma262Parser.DOT, 0); }
		public AtomEscapeContext atomEscape() {
			return getRuleContext(AtomEscapeContext.class,0);
		}
		public CharacterClassContext characterClass() {
			return getRuleContext(CharacterClassContext.class,0);
		}
		public TerminalNode PAREN_open() { return getToken(RegexEcma262Parser.PAREN_open, 0); }
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public TerminalNode PAREN_close() { return getToken(RegexEcma262Parser.PAREN_close, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atom);
		try {
			int _alt;
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DecimalDigit:
			case BRACKET_close:
			case BRACE_close:
			case MINUS:
			case COMMA:
			case BaseChar:
				enterOuterAlt(_localctx, 1);
				{
				setState(104); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(103);
						patternCharacter();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(106); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(DOT);
				}
				break;
			case CharacterEscape:
			case ControlLetterExtendedEscape:
			case CharacterClassEscape:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				atomEscape();
				}
				break;
			case BRACKET_open:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				characterClass();
				}
				break;
			case PAREN_open:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				match(PAREN_open);
				setState(112);
				disjunction();
				setState(113);
				match(PAREN_close);
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

	public static class PatternCharacterContext extends ParserRuleContext {
		public TerminalNode BaseChar() { return getToken(RegexEcma262Parser.BaseChar, 0); }
		public TerminalNode COMMA() { return getToken(RegexEcma262Parser.COMMA, 0); }
		public TerminalNode MINUS() { return getToken(RegexEcma262Parser.MINUS, 0); }
		public TerminalNode DecimalDigit() { return getToken(RegexEcma262Parser.DecimalDigit, 0); }
		public TerminalNode BRACE_close() { return getToken(RegexEcma262Parser.BRACE_close, 0); }
		public TerminalNode BRACKET_close() { return getToken(RegexEcma262Parser.BRACKET_close, 0); }
		public PatternCharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternCharacter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitPatternCharacter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternCharacterContext patternCharacter() throws RecognitionException {
		PatternCharacterContext _localctx = new PatternCharacterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_patternCharacter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DecimalDigit) | (1L << BRACKET_close) | (1L << BRACE_close) | (1L << MINUS) | (1L << COMMA) | (1L << BaseChar))) != 0)) ) {
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
		public TerminalNode BRACKET_open() { return getToken(RegexEcma262Parser.BRACKET_open, 0); }
		public TerminalNode CARET() { return getToken(RegexEcma262Parser.CARET, 0); }
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public TerminalNode BRACKET_close() { return getToken(RegexEcma262Parser.BRACKET_close, 0); }
		public CharacterClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitCharacterClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharacterClassContext characterClass() throws RecognitionException {
		CharacterClassContext _localctx = new CharacterClassContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_characterClass);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(BRACKET_open);
				setState(120);
				match(CARET);
				setState(121);
				classRanges();
				setState(122);
				match(BRACKET_close);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(BRACKET_open);
				setState(125);
				classRanges();
				setState(126);
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

	public static class ClassRangesContext extends ParserRuleContext {
		public NonemptyClassRangesContext nonemptyClassRanges() {
			return getRuleContext(NonemptyClassRangesContext.class,0);
		}
		public ClassRangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classRanges; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitClassRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassRangesContext classRanges() throws RecognitionException {
		ClassRangesContext _localctx = new ClassRangesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_classRanges);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_close:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case CharacterEscape:
			case ControlLetterExtendedEscape:
			case DecimalDigit:
			case CharacterClassEscape:
			case LowerCaseBEscape:
			case CARET:
			case DOLLAR:
			case DOT:
			case STAR:
			case PLUS:
			case QUESTION:
			case PAREN_open:
			case PAREN_close:
			case BRACKET_open:
			case BRACE_open:
			case BRACE_close:
			case OR:
			case MINUS:
			case COMMA:
			case BaseChar:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				nonemptyClassRanges();
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
		public TerminalNode MINUS() { return getToken(RegexEcma262Parser.MINUS, 0); }
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public NonemptyClassRangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonemptyClassRanges; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitNonemptyClassRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonemptyClassRangesContext nonemptyClassRanges() throws RecognitionException {
		NonemptyClassRangesContext _localctx = new NonemptyClassRangesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_nonemptyClassRanges);
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				classAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				classAtom();
				setState(136);
				nonemptyClassRangesNoDash();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				classAtom();
				setState(139);
				match(MINUS);
				setState(140);
				classAtom();
				setState(141);
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
		public TerminalNode MINUS() { return getToken(RegexEcma262Parser.MINUS, 0); }
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public NonemptyClassRangesNoDashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonemptyClassRangesNoDash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitNonemptyClassRangesNoDash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonemptyClassRangesNoDashContext nonemptyClassRangesNoDash() throws RecognitionException {
		NonemptyClassRangesNoDashContext _localctx = new NonemptyClassRangesNoDashContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nonemptyClassRangesNoDash);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				classAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				classAtomNoDash();
				setState(147);
				nonemptyClassRangesNoDash();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				classAtomNoDash();
				setState(150);
				match(MINUS);
				setState(151);
				classAtom();
				setState(152);
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
		public TerminalNode MINUS() { return getToken(RegexEcma262Parser.MINUS, 0); }
		public ClassAtomNoDashContext classAtomNoDash() {
			return getRuleContext(ClassAtomNoDashContext.class,0);
		}
		public ClassAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitClassAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassAtomContext classAtom() throws RecognitionException {
		ClassAtomContext _localctx = new ClassAtomContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_classAtom);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(MINUS);
				}
				break;
			case CharacterEscape:
			case ControlLetterExtendedEscape:
			case DecimalDigit:
			case CharacterClassEscape:
			case LowerCaseBEscape:
			case CARET:
			case DOLLAR:
			case DOT:
			case STAR:
			case PLUS:
			case QUESTION:
			case PAREN_open:
			case PAREN_close:
			case BRACKET_open:
			case BRACE_open:
			case BRACE_close:
			case OR:
			case COMMA:
			case BaseChar:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
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
		public TerminalNode BaseChar() { return getToken(RegexEcma262Parser.BaseChar, 0); }
		public TerminalNode DecimalDigit() { return getToken(RegexEcma262Parser.DecimalDigit, 0); }
		public TerminalNode COMMA() { return getToken(RegexEcma262Parser.COMMA, 0); }
		public TerminalNode CARET() { return getToken(RegexEcma262Parser.CARET, 0); }
		public TerminalNode DOLLAR() { return getToken(RegexEcma262Parser.DOLLAR, 0); }
		public TerminalNode DOT() { return getToken(RegexEcma262Parser.DOT, 0); }
		public TerminalNode STAR() { return getToken(RegexEcma262Parser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(RegexEcma262Parser.PLUS, 0); }
		public TerminalNode QUESTION() { return getToken(RegexEcma262Parser.QUESTION, 0); }
		public TerminalNode PAREN_open() { return getToken(RegexEcma262Parser.PAREN_open, 0); }
		public TerminalNode PAREN_close() { return getToken(RegexEcma262Parser.PAREN_close, 0); }
		public TerminalNode BRACKET_open() { return getToken(RegexEcma262Parser.BRACKET_open, 0); }
		public TerminalNode BRACE_open() { return getToken(RegexEcma262Parser.BRACE_open, 0); }
		public TerminalNode BRACE_close() { return getToken(RegexEcma262Parser.BRACE_close, 0); }
		public TerminalNode OR() { return getToken(RegexEcma262Parser.OR, 0); }
		public ClassAtomNoDashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classAtomNoDash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitClassAtomNoDash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassAtomNoDashContext classAtomNoDash() throws RecognitionException {
		ClassAtomNoDashContext _localctx = new ClassAtomNoDashContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_classAtomNoDash);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CharacterEscape:
			case ControlLetterExtendedEscape:
			case CharacterClassEscape:
			case LowerCaseBEscape:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				classEscape();
				}
				break;
			case BaseChar:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(BaseChar);
				}
				break;
			case DecimalDigit:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(DecimalDigit);
				}
				break;
			case COMMA:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				match(COMMA);
				}
				break;
			case CARET:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				match(CARET);
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(165);
				match(DOLLAR);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(166);
				match(DOT);
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(167);
				match(STAR);
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 9);
				{
				setState(168);
				match(PLUS);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 10);
				{
				setState(169);
				match(QUESTION);
				}
				break;
			case PAREN_open:
				enterOuterAlt(_localctx, 11);
				{
				setState(170);
				match(PAREN_open);
				}
				break;
			case PAREN_close:
				enterOuterAlt(_localctx, 12);
				{
				setState(171);
				match(PAREN_close);
				}
				break;
			case BRACKET_open:
				enterOuterAlt(_localctx, 13);
				{
				setState(172);
				match(BRACKET_open);
				}
				break;
			case BRACE_open:
				enterOuterAlt(_localctx, 14);
				{
				setState(173);
				match(BRACE_open);
				}
				break;
			case BRACE_close:
				enterOuterAlt(_localctx, 15);
				{
				setState(174);
				match(BRACE_close);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 16);
				{
				setState(175);
				match(OR);
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

	public static class ClassEscapeContext extends ParserRuleContext {
		public ControlLetterExtendedEscapeContext controlLetterExtendedEscape() {
			return getRuleContext(ControlLetterExtendedEscapeContext.class,0);
		}
		public AtomEscapeContext atomEscape() {
			return getRuleContext(AtomEscapeContext.class,0);
		}
		public TerminalNode LowerCaseBEscape() { return getToken(RegexEcma262Parser.LowerCaseBEscape, 0); }
		public ClassEscapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classEscape; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitClassEscape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassEscapeContext classEscape() throws RecognitionException {
		ClassEscapeContext _localctx = new ClassEscapeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_classEscape);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				controlLetterExtendedEscape();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				atomEscape();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				match(LowerCaseBEscape);
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

	public static class AtomEscapeContext extends ParserRuleContext {
		public TerminalNode CharacterClassEscape() { return getToken(RegexEcma262Parser.CharacterClassEscape, 0); }
		public TerminalNode CharacterEscape() { return getToken(RegexEcma262Parser.CharacterEscape, 0); }
		public ControlLetterExtendedEscapeContext controlLetterExtendedEscape() {
			return getRuleContext(ControlLetterExtendedEscapeContext.class,0);
		}
		public AtomEscapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomEscape; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitAtomEscape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomEscapeContext atomEscape() throws RecognitionException {
		AtomEscapeContext _localctx = new AtomEscapeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_atomEscape);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CharacterClassEscape:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(CharacterClassEscape);
				}
				break;
			case CharacterEscape:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(CharacterEscape);
				}
				break;
			case ControlLetterExtendedEscape:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				controlLetterExtendedEscape();
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
		public List<TerminalNode> DecimalDigit() { return getTokens(RegexEcma262Parser.DecimalDigit); }
		public TerminalNode DecimalDigit(int i) {
			return getToken(RegexEcma262Parser.DecimalDigit, i);
		}
		public DecimalDigitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalDigits; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitDecimalDigits(this);
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
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				match(DecimalDigit);
				}
				}
				setState(191); 
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

	public static class ControlLetterExtendedEscapeContext extends ParserRuleContext {
		public TerminalNode ControlLetterExtendedEscape() { return getToken(RegexEcma262Parser.ControlLetterExtendedEscape, 0); }
		public ControlLetterExtendedEscapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlLetterExtendedEscape; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexEcma262Visitor ) return ((RegexEcma262Visitor<? extends T>)visitor).visitControlLetterExtendedEscape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlLetterExtendedEscapeContext controlLetterExtendedEscape() throws RecognitionException {
		ControlLetterExtendedEscapeContext _localctx = new ControlLetterExtendedEscapeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_controlLetterExtendedEscape);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(ControlLetterExtendedEscape);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00c6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\5\39\n\3\3\4\7\4<\n\4\f\4\16\4?\13\4\3\5\3\5\3"+
		"\5\3\5\3\5\5\5F\n\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7N\n\7\3\b\3\b\3\b\3\b\5"+
		"\bT\n\b\3\t\3\t\3\t\5\tY\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\6\rk\n\r\r\r\16\rl\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\rv\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0083\n\17\3\20\3\20\5\20\u0087\n\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u0092\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u009d\n\22\3\23\3\23\5\23\u00a1\n\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b3"+
		"\n\24\3\25\3\25\3\25\5\25\u00b8\n\25\3\26\3\26\3\26\5\26\u00bd\n\26\3"+
		"\27\6\27\u00c0\n\27\r\27\16\27\u00c1\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\4\3\2\b\t\6\2\5\5\22\22\24\24\26"+
		"\30\2\u00d8\2\60\3\2\2\2\48\3\2\2\2\6=\3\2\2\2\bE\3\2\2\2\nG\3\2\2\2\f"+
		"M\3\2\2\2\16S\3\2\2\2\20X\3\2\2\2\22Z\3\2\2\2\24^\3\2\2\2\26c\3\2\2\2"+
		"\30u\3\2\2\2\32w\3\2\2\2\34\u0082\3\2\2\2\36\u0086\3\2\2\2 \u0091\3\2"+
		"\2\2\"\u009c\3\2\2\2$\u00a0\3\2\2\2&\u00b2\3\2\2\2(\u00b7\3\2\2\2*\u00bc"+
		"\3\2\2\2,\u00bf\3\2\2\2.\u00c3\3\2\2\2\60\61\5\4\3\2\61\62\7\2\2\3\62"+
		"\3\3\2\2\2\639\5\6\4\2\64\65\5\6\4\2\65\66\7\25\2\2\66\67\5\4\3\2\679"+
		"\3\2\2\28\63\3\2\2\28\64\3\2\2\29\5\3\2\2\2:<\5\b\5\2;:\3\2\2\2<?\3\2"+
		"\2\2=;\3\2\2\2=>\3\2\2\2>\7\3\2\2\2?=\3\2\2\2@F\5\n\6\2AF\5\30\r\2BC\5"+
		"\30\r\2CD\5\f\7\2DF\3\2\2\2E@\3\2\2\2EA\3\2\2\2EB\3\2\2\2F\t\3\2\2\2G"+
		"H\t\2\2\2H\13\3\2\2\2IN\5\16\b\2JK\5\16\b\2KL\7\16\2\2LN\3\2\2\2MI\3\2"+
		"\2\2MJ\3\2\2\2N\r\3\2\2\2OT\7\f\2\2PT\7\r\2\2QT\7\16\2\2RT\5\20\t\2SO"+
		"\3\2\2\2SP\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T\17\3\2\2\2UY\5\22\n\2VY\5\24\13"+
		"\2WY\5\26\f\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\21\3\2\2\2Z[\7\23\2\2[\\"+
		"\5,\27\2\\]\7\24\2\2]\23\3\2\2\2^_\7\23\2\2_`\5,\27\2`a\7\27\2\2ab\7\24"+
		"\2\2b\25\3\2\2\2cd\7\23\2\2de\5,\27\2ef\7\27\2\2fg\5,\27\2gh\7\24\2\2"+
		"h\27\3\2\2\2ik\5\32\16\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mv\3\2"+
		"\2\2nv\7\13\2\2ov\5*\26\2pv\5\34\17\2qr\7\17\2\2rs\5\4\3\2st\7\20\2\2"+
		"tv\3\2\2\2uj\3\2\2\2un\3\2\2\2uo\3\2\2\2up\3\2\2\2uq\3\2\2\2v\31\3\2\2"+
		"\2wx\t\3\2\2x\33\3\2\2\2yz\7\21\2\2z{\7\b\2\2{|\5\36\20\2|}\7\22\2\2}"+
		"\u0083\3\2\2\2~\177\7\21\2\2\177\u0080\5\36\20\2\u0080\u0081\7\22\2\2"+
		"\u0081\u0083\3\2\2\2\u0082y\3\2\2\2\u0082~\3\2\2\2\u0083\35\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0087\5 \21\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2"+
		"\2\2\u0087\37\3\2\2\2\u0088\u0092\5$\23\2\u0089\u008a\5$\23\2\u008a\u008b"+
		"\5\"\22\2\u008b\u0092\3\2\2\2\u008c\u008d\5$\23\2\u008d\u008e\7\26\2\2"+
		"\u008e\u008f\5$\23\2\u008f\u0090\5\36\20\2\u0090\u0092\3\2\2\2\u0091\u0088"+
		"\3\2\2\2\u0091\u0089\3\2\2\2\u0091\u008c\3\2\2\2\u0092!\3\2\2\2\u0093"+
		"\u009d\5$\23\2\u0094\u0095\5&\24\2\u0095\u0096\5\"\22\2\u0096\u009d\3"+
		"\2\2\2\u0097\u0098\5&\24\2\u0098\u0099\7\26\2\2\u0099\u009a\5$\23\2\u009a"+
		"\u009b\5\36\20\2\u009b\u009d\3\2\2\2\u009c\u0093\3\2\2\2\u009c\u0094\3"+
		"\2\2\2\u009c\u0097\3\2\2\2\u009d#\3\2\2\2\u009e\u00a1\7\26\2\2\u009f\u00a1"+
		"\5&\24\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1%\3\2\2\2\u00a2"+
		"\u00b3\5(\25\2\u00a3\u00b3\7\30\2\2\u00a4\u00b3\7\5\2\2\u00a5\u00b3\7"+
		"\27\2\2\u00a6\u00b3\7\b\2\2\u00a7\u00b3\7\t\2\2\u00a8\u00b3\7\13\2\2\u00a9"+
		"\u00b3\7\f\2\2\u00aa\u00b3\7\r\2\2\u00ab\u00b3\7\16\2\2\u00ac\u00b3\7"+
		"\17\2\2\u00ad\u00b3\7\20\2\2\u00ae\u00b3\7\21\2\2\u00af\u00b3\7\23\2\2"+
		"\u00b0\u00b3\7\24\2\2\u00b1\u00b3\7\25\2\2\u00b2\u00a2\3\2\2\2\u00b2\u00a3"+
		"\3\2\2\2\u00b2\u00a4\3\2\2\2\u00b2\u00a5\3\2\2\2\u00b2\u00a6\3\2\2\2\u00b2"+
		"\u00a7\3\2\2\2\u00b2\u00a8\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00aa\3\2"+
		"\2\2\u00b2\u00ab\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2"+
		"\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2"+
		"\2\2\u00b3\'\3\2\2\2\u00b4\u00b8\5.\30\2\u00b5\u00b8\5*\26\2\u00b6\u00b8"+
		"\7\7\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		")\3\2\2\2\u00b9\u00bd\7\6\2\2\u00ba\u00bd\7\3\2\2\u00bb\u00bd\5.\30\2"+
		"\u00bc\u00b9\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd+\3"+
		"\2\2\2\u00be\u00c0\7\5\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2-\3\2\2\2\u00c3\u00c4\7\4\2\2"+
		"\u00c4/\3\2\2\2\238=EMSXlu\u0082\u0086\u0091\u009c\u00a0\u00b2\u00b7\u00bc"+
		"\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}