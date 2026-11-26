// Generated from org/evomaster/core/parser/PostgresSimilarTo.g4 by ANTLR 4.9.2
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
public class PostgresSimilarToParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DecimalDigit=1, CARET=2, SLASH=3, STAR=4, PLUS=5, QUESTION=6, PAREN_open=7, 
		PAREN_close=8, BRACKET_open=9, BRACKET_close=10, BRACE_open=11, BRACE_close=12, 
		OR=13, MINUS=14, COMMA=15, UNDERSCORE=16, PERCENT=17, BaseChar=18;
	public static final int
		RULE_pattern = 0, RULE_disjunction = 1, RULE_alternative = 2, RULE_term = 3, 
		RULE_quantifier = 4, RULE_bracketQuantifier = 5, RULE_bracketQuantifierSingle = 6, 
		RULE_bracketQuantifierOnlyMin = 7, RULE_bracketQuantifierRange = 8, RULE_atom = 9, 
		RULE_patternCharacter = 10, RULE_characterClass = 11, RULE_classRanges = 12, 
		RULE_nonemptyClassRanges = 13, RULE_nonemptyClassRangesNoDash = 14, RULE_classAtom = 15, 
		RULE_classAtomNoDash = 16, RULE_decimalDigits = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"pattern", "disjunction", "alternative", "term", "quantifier", "bracketQuantifier", 
			"bracketQuantifierSingle", "bracketQuantifierOnlyMin", "bracketQuantifierRange", 
			"atom", "patternCharacter", "characterClass", "classRanges", "nonemptyClassRanges", 
			"nonemptyClassRangesNoDash", "classAtom", "classAtomNoDash", "decimalDigits"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'^'", "'\\'", "'*'", "'+'", "'?'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'|'", "'-'", "','", "'_'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DecimalDigit", "CARET", "SLASH", "STAR", "PLUS", "QUESTION", "PAREN_open", 
			"PAREN_close", "BRACKET_open", "BRACKET_close", "BRACE_open", "BRACE_close", 
			"OR", "MINUS", "COMMA", "UNDERSCORE", "PERCENT", "BaseChar"
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
	public String getGrammarFileName() { return "PostgresSimilarTo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PostgresSimilarToParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PatternContext extends ParserRuleContext {
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			disjunction();
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
		public TerminalNode OR() { return getToken(PostgresSimilarToParser.OR, 0); }
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_disjunction);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				alternative();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				alternative();
				setState(40);
				match(OR);
				setState(41);
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
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitAlternative(this);
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
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DecimalDigit) | (1L << PAREN_open) | (1L << BRACKET_open) | (1L << MINUS) | (1L << UNDERSCORE) | (1L << PERCENT) | (1L << BaseChar))) != 0)) {
				{
				{
				setState(45);
				term();
				}
				}
				setState(50);
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
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				atom();
				setState(53);
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

	public static class QuantifierContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PostgresSimilarToParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(PostgresSimilarToParser.PLUS, 0); }
		public TerminalNode QUESTION() { return getToken(PostgresSimilarToParser.QUESTION, 0); }
		public BracketQuantifierContext bracketQuantifier() {
			return getRuleContext(BracketQuantifierContext.class,0);
		}
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quantifier);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(STAR);
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(PLUS);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(QUESTION);
				}
				break;
			case BRACE_open:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
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
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitBracketQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierContext bracketQuantifier() throws RecognitionException {
		BracketQuantifierContext _localctx = new BracketQuantifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bracketQuantifier);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				bracketQuantifierSingle();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				bracketQuantifierOnlyMin();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
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
		public TerminalNode BRACE_open() { return getToken(PostgresSimilarToParser.BRACE_open, 0); }
		public DecimalDigitsContext decimalDigits() {
			return getRuleContext(DecimalDigitsContext.class,0);
		}
		public TerminalNode BRACE_close() { return getToken(PostgresSimilarToParser.BRACE_close, 0); }
		public BracketQuantifierSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierSingle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitBracketQuantifierSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierSingleContext bracketQuantifierSingle() throws RecognitionException {
		BracketQuantifierSingleContext _localctx = new BracketQuantifierSingleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bracketQuantifierSingle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(BRACE_open);
			setState(69);
			decimalDigits();
			setState(70);
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
		public TerminalNode BRACE_open() { return getToken(PostgresSimilarToParser.BRACE_open, 0); }
		public DecimalDigitsContext decimalDigits() {
			return getRuleContext(DecimalDigitsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PostgresSimilarToParser.COMMA, 0); }
		public TerminalNode BRACE_close() { return getToken(PostgresSimilarToParser.BRACE_close, 0); }
		public BracketQuantifierOnlyMinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierOnlyMin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitBracketQuantifierOnlyMin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierOnlyMinContext bracketQuantifierOnlyMin() throws RecognitionException {
		BracketQuantifierOnlyMinContext _localctx = new BracketQuantifierOnlyMinContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bracketQuantifierOnlyMin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(BRACE_open);
			setState(73);
			decimalDigits();
			setState(74);
			match(COMMA);
			setState(75);
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
		public TerminalNode BRACE_open() { return getToken(PostgresSimilarToParser.BRACE_open, 0); }
		public List<DecimalDigitsContext> decimalDigits() {
			return getRuleContexts(DecimalDigitsContext.class);
		}
		public DecimalDigitsContext decimalDigits(int i) {
			return getRuleContext(DecimalDigitsContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PostgresSimilarToParser.COMMA, 0); }
		public TerminalNode BRACE_close() { return getToken(PostgresSimilarToParser.BRACE_close, 0); }
		public BracketQuantifierRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketQuantifierRange; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitBracketQuantifierRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketQuantifierRangeContext bracketQuantifierRange() throws RecognitionException {
		BracketQuantifierRangeContext _localctx = new BracketQuantifierRangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bracketQuantifierRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(BRACE_open);
			setState(78);
			decimalDigits();
			setState(79);
			match(COMMA);
			setState(80);
			decimalDigits();
			setState(81);
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
		public TerminalNode UNDERSCORE() { return getToken(PostgresSimilarToParser.UNDERSCORE, 0); }
		public TerminalNode PERCENT() { return getToken(PostgresSimilarToParser.PERCENT, 0); }
		public CharacterClassContext characterClass() {
			return getRuleContext(CharacterClassContext.class,0);
		}
		public TerminalNode PAREN_open() { return getToken(PostgresSimilarToParser.PAREN_open, 0); }
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public TerminalNode PAREN_close() { return getToken(PostgresSimilarToParser.PAREN_close, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atom);
		try {
			int _alt;
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DecimalDigit:
			case MINUS:
			case BaseChar:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(83);
						patternCharacter();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(86); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case UNDERSCORE:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(UNDERSCORE);
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				match(PERCENT);
				}
				break;
			case BRACKET_open:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				characterClass();
				}
				break;
			case PAREN_open:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				match(PAREN_open);
				setState(92);
				disjunction();
				setState(93);
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
		public TerminalNode BaseChar() { return getToken(PostgresSimilarToParser.BaseChar, 0); }
		public TerminalNode MINUS() { return getToken(PostgresSimilarToParser.MINUS, 0); }
		public TerminalNode DecimalDigit() { return getToken(PostgresSimilarToParser.DecimalDigit, 0); }
		public PatternCharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternCharacter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitPatternCharacter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternCharacterContext patternCharacter() throws RecognitionException {
		PatternCharacterContext _localctx = new PatternCharacterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_patternCharacter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DecimalDigit) | (1L << MINUS) | (1L << BaseChar))) != 0)) ) {
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
		public TerminalNode BRACKET_open() { return getToken(PostgresSimilarToParser.BRACKET_open, 0); }
		public TerminalNode CARET() { return getToken(PostgresSimilarToParser.CARET, 0); }
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public TerminalNode BRACKET_close() { return getToken(PostgresSimilarToParser.BRACKET_close, 0); }
		public CharacterClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitCharacterClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharacterClassContext characterClass() throws RecognitionException {
		CharacterClassContext _localctx = new CharacterClassContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_characterClass);
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(BRACKET_open);
				setState(100);
				match(CARET);
				setState(101);
				classRanges();
				setState(102);
				match(BRACKET_close);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(BRACKET_open);
				setState(105);
				classRanges();
				setState(106);
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
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitClassRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassRangesContext classRanges() throws RecognitionException {
		ClassRangesContext _localctx = new ClassRangesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classRanges);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_close:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case DecimalDigit:
			case CARET:
			case SLASH:
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
				setState(111);
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
		public TerminalNode MINUS() { return getToken(PostgresSimilarToParser.MINUS, 0); }
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public NonemptyClassRangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonemptyClassRanges; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitNonemptyClassRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonemptyClassRangesContext nonemptyClassRanges() throws RecognitionException {
		NonemptyClassRangesContext _localctx = new NonemptyClassRangesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_nonemptyClassRanges);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				classAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				classAtom();
				setState(116);
				nonemptyClassRangesNoDash();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				classAtom();
				setState(119);
				match(MINUS);
				setState(120);
				classAtom();
				setState(121);
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
		public TerminalNode MINUS() { return getToken(PostgresSimilarToParser.MINUS, 0); }
		public ClassRangesContext classRanges() {
			return getRuleContext(ClassRangesContext.class,0);
		}
		public NonemptyClassRangesNoDashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonemptyClassRangesNoDash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitNonemptyClassRangesNoDash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonemptyClassRangesNoDashContext nonemptyClassRangesNoDash() throws RecognitionException {
		NonemptyClassRangesNoDashContext _localctx = new NonemptyClassRangesNoDashContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_nonemptyClassRangesNoDash);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				classAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				classAtomNoDash();
				setState(127);
				nonemptyClassRangesNoDash();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				classAtomNoDash();
				setState(130);
				match(MINUS);
				setState(131);
				classAtom();
				setState(132);
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
		public TerminalNode MINUS() { return getToken(PostgresSimilarToParser.MINUS, 0); }
		public ClassAtomNoDashContext classAtomNoDash() {
			return getRuleContext(ClassAtomNoDashContext.class,0);
		}
		public ClassAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitClassAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassAtomContext classAtom() throws RecognitionException {
		ClassAtomContext _localctx = new ClassAtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_classAtom);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(MINUS);
				}
				break;
			case DecimalDigit:
			case CARET:
			case SLASH:
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
				setState(137);
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
		public TerminalNode BaseChar() { return getToken(PostgresSimilarToParser.BaseChar, 0); }
		public TerminalNode DecimalDigit() { return getToken(PostgresSimilarToParser.DecimalDigit, 0); }
		public TerminalNode COMMA() { return getToken(PostgresSimilarToParser.COMMA, 0); }
		public TerminalNode CARET() { return getToken(PostgresSimilarToParser.CARET, 0); }
		public TerminalNode SLASH() { return getToken(PostgresSimilarToParser.SLASH, 0); }
		public TerminalNode STAR() { return getToken(PostgresSimilarToParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(PostgresSimilarToParser.PLUS, 0); }
		public TerminalNode QUESTION() { return getToken(PostgresSimilarToParser.QUESTION, 0); }
		public TerminalNode PAREN_open() { return getToken(PostgresSimilarToParser.PAREN_open, 0); }
		public TerminalNode PAREN_close() { return getToken(PostgresSimilarToParser.PAREN_close, 0); }
		public TerminalNode BRACKET_open() { return getToken(PostgresSimilarToParser.BRACKET_open, 0); }
		public TerminalNode BRACE_open() { return getToken(PostgresSimilarToParser.BRACE_open, 0); }
		public TerminalNode BRACE_close() { return getToken(PostgresSimilarToParser.BRACE_close, 0); }
		public TerminalNode OR() { return getToken(PostgresSimilarToParser.OR, 0); }
		public ClassAtomNoDashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classAtomNoDash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitClassAtomNoDash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassAtomNoDashContext classAtomNoDash() throws RecognitionException {
		ClassAtomNoDashContext _localctx = new ClassAtomNoDashContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_classAtomNoDash);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DecimalDigit) | (1L << CARET) | (1L << SLASH) | (1L << STAR) | (1L << PLUS) | (1L << QUESTION) | (1L << PAREN_open) | (1L << PAREN_close) | (1L << BRACKET_open) | (1L << BRACE_open) | (1L << BRACE_close) | (1L << OR) | (1L << COMMA) | (1L << BaseChar))) != 0)) ) {
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

	public static class DecimalDigitsContext extends ParserRuleContext {
		public List<TerminalNode> DecimalDigit() { return getTokens(PostgresSimilarToParser.DecimalDigit); }
		public TerminalNode DecimalDigit(int i) {
			return getToken(PostgresSimilarToParser.DecimalDigit, i);
		}
		public DecimalDigitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalDigits; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresSimilarToVisitor ) return ((PostgresSimilarToVisitor<? extends T>)visitor).visitDecimalDigits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalDigitsContext decimalDigits() throws RecognitionException {
		DecimalDigitsContext _localctx = new DecimalDigitsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_decimalDigits);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				match(DecimalDigit);
				}
				}
				setState(145); 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u0096\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\7\4\61\n\4\f\4\16"+
		"\4\64\13\4\3\5\3\5\3\5\3\5\5\5:\n\5\3\6\3\6\3\6\3\6\5\6@\n\6\3\7\3\7\3"+
		"\7\5\7E\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\6\13W\n\13\r\13\16\13X\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"b\n\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\ro\n\r\3\16\3\16"+
		"\5\16s\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17~\n\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0089\n\20\3\21\3\21"+
		"\5\21\u008d\n\21\3\22\3\22\3\23\6\23\u0092\n\23\r\23\16\23\u0093\3\23"+
		"\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\5\2\3\3\20\20\24"+
		"\24\6\2\3\13\r\17\21\21\24\24\2\u0098\2&\3\2\2\2\4-\3\2\2\2\6\62\3\2\2"+
		"\2\b9\3\2\2\2\n?\3\2\2\2\fD\3\2\2\2\16F\3\2\2\2\20J\3\2\2\2\22O\3\2\2"+
		"\2\24a\3\2\2\2\26c\3\2\2\2\30n\3\2\2\2\32r\3\2\2\2\34}\3\2\2\2\36\u0088"+
		"\3\2\2\2 \u008c\3\2\2\2\"\u008e\3\2\2\2$\u0091\3\2\2\2&\'\5\4\3\2\'\3"+
		"\3\2\2\2(.\5\6\4\2)*\5\6\4\2*+\7\17\2\2+,\5\4\3\2,.\3\2\2\2-(\3\2\2\2"+
		"-)\3\2\2\2.\5\3\2\2\2/\61\5\b\5\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2"+
		"\2\2\62\63\3\2\2\2\63\7\3\2\2\2\64\62\3\2\2\2\65:\5\24\13\2\66\67\5\24"+
		"\13\2\678\5\n\6\28:\3\2\2\29\65\3\2\2\29\66\3\2\2\2:\t\3\2\2\2;@\7\6\2"+
		"\2<@\7\7\2\2=@\7\b\2\2>@\5\f\7\2?;\3\2\2\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2"+
		"\2@\13\3\2\2\2AE\5\16\b\2BE\5\20\t\2CE\5\22\n\2DA\3\2\2\2DB\3\2\2\2DC"+
		"\3\2\2\2E\r\3\2\2\2FG\7\r\2\2GH\5$\23\2HI\7\16\2\2I\17\3\2\2\2JK\7\r\2"+
		"\2KL\5$\23\2LM\7\21\2\2MN\7\16\2\2N\21\3\2\2\2OP\7\r\2\2PQ\5$\23\2QR\7"+
		"\21\2\2RS\5$\23\2ST\7\16\2\2T\23\3\2\2\2UW\5\26\f\2VU\3\2\2\2WX\3\2\2"+
		"\2XV\3\2\2\2XY\3\2\2\2Yb\3\2\2\2Zb\7\22\2\2[b\7\23\2\2\\b\5\30\r\2]^\7"+
		"\t\2\2^_\5\4\3\2_`\7\n\2\2`b\3\2\2\2aV\3\2\2\2aZ\3\2\2\2a[\3\2\2\2a\\"+
		"\3\2\2\2a]\3\2\2\2b\25\3\2\2\2cd\t\2\2\2d\27\3\2\2\2ef\7\13\2\2fg\7\4"+
		"\2\2gh\5\32\16\2hi\7\f\2\2io\3\2\2\2jk\7\13\2\2kl\5\32\16\2lm\7\f\2\2"+
		"mo\3\2\2\2ne\3\2\2\2nj\3\2\2\2o\31\3\2\2\2ps\3\2\2\2qs\5\34\17\2rp\3\2"+
		"\2\2rq\3\2\2\2s\33\3\2\2\2t~\5 \21\2uv\5 \21\2vw\5\36\20\2w~\3\2\2\2x"+
		"y\5 \21\2yz\7\20\2\2z{\5 \21\2{|\5\32\16\2|~\3\2\2\2}t\3\2\2\2}u\3\2\2"+
		"\2}x\3\2\2\2~\35\3\2\2\2\177\u0089\5 \21\2\u0080\u0081\5\"\22\2\u0081"+
		"\u0082\5\36\20\2\u0082\u0089\3\2\2\2\u0083\u0084\5\"\22\2\u0084\u0085"+
		"\7\20\2\2\u0085\u0086\5 \21\2\u0086\u0087\5\32\16\2\u0087\u0089\3\2\2"+
		"\2\u0088\177\3\2\2\2\u0088\u0080\3\2\2\2\u0088\u0083\3\2\2\2\u0089\37"+
		"\3\2\2\2\u008a\u008d\7\20\2\2\u008b\u008d\5\"\22\2\u008c\u008a\3\2\2\2"+
		"\u008c\u008b\3\2\2\2\u008d!\3\2\2\2\u008e\u008f\t\3\2\2\u008f#\3\2\2\2"+
		"\u0090\u0092\7\3\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094%\3\2\2\2\17-\629?DXanr}\u0088\u008c"+
		"\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}