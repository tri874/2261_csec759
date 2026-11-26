// Generated from org/evomaster/core/parser/PostgresLike.g4 by ANTLR 4.9.2
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
public class PostgresLikeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ESCAPED_PERCENT=1, ESCAPED_UNDERSCORE=2, PERCENT=3, UNDERSCORE=4, CHAR=5;
	public static final int
		RULE_pattern = 0, RULE_term = 1, RULE_specialSymbol = 2, RULE_baseSymbol = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"pattern", "term", "specialSymbol", "baseSymbol"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'%'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ESCAPED_PERCENT", "ESCAPED_UNDERSCORE", "PERCENT", "UNDERSCORE", 
			"CHAR"
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
	public String getGrammarFileName() { return "PostgresLike.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PostgresLikeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PatternContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresLikeVisitor ) return ((PostgresLikeVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ESCAPED_PERCENT) | (1L << ESCAPED_UNDERSCORE) | (1L << PERCENT) | (1L << UNDERSCORE) | (1L << CHAR))) != 0)) {
				{
				{
				setState(8);
				term();
				}
				}
				setState(13);
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
		public SpecialSymbolContext specialSymbol() {
			return getRuleContext(SpecialSymbolContext.class,0);
		}
		public List<BaseSymbolContext> baseSymbol() {
			return getRuleContexts(BaseSymbolContext.class);
		}
		public BaseSymbolContext baseSymbol(int i) {
			return getRuleContext(BaseSymbolContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresLikeVisitor ) return ((PostgresLikeVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_term);
		try {
			int _alt;
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERCENT:
			case UNDERSCORE:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				specialSymbol();
				}
				break;
			case ESCAPED_PERCENT:
			case ESCAPED_UNDERSCORE:
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(16); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(15);
						baseSymbol();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(18); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class SpecialSymbolContext extends ParserRuleContext {
		public TerminalNode PERCENT() { return getToken(PostgresLikeParser.PERCENT, 0); }
		public TerminalNode UNDERSCORE() { return getToken(PostgresLikeParser.UNDERSCORE, 0); }
		public SpecialSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialSymbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresLikeVisitor ) return ((PostgresLikeVisitor<? extends T>)visitor).visitSpecialSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialSymbolContext specialSymbol() throws RecognitionException {
		SpecialSymbolContext _localctx = new SpecialSymbolContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_specialSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_la = _input.LA(1);
			if ( !(_la==PERCENT || _la==UNDERSCORE) ) {
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

	public static class BaseSymbolContext extends ParserRuleContext {
		public TerminalNode ESCAPED_UNDERSCORE() { return getToken(PostgresLikeParser.ESCAPED_UNDERSCORE, 0); }
		public TerminalNode ESCAPED_PERCENT() { return getToken(PostgresLikeParser.ESCAPED_PERCENT, 0); }
		public TerminalNode CHAR() { return getToken(PostgresLikeParser.CHAR, 0); }
		public BaseSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseSymbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PostgresLikeVisitor ) return ((PostgresLikeVisitor<? extends T>)visitor).visitBaseSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseSymbolContext baseSymbol() throws RecognitionException {
		BaseSymbolContext _localctx = new BaseSymbolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_baseSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ESCAPED_PERCENT) | (1L << ESCAPED_UNDERSCORE) | (1L << CHAR))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7\35\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\3\3\3\6\3\23\n\3"+
		"\r\3\16\3\24\5\3\27\n\3\3\4\3\4\3\5\3\5\3\5\2\2\6\2\4\6\b\2\4\3\2\5\6"+
		"\4\2\3\4\7\7\2\33\2\r\3\2\2\2\4\26\3\2\2\2\6\30\3\2\2\2\b\32\3\2\2\2\n"+
		"\f\5\4\3\2\13\n\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3"+
		"\2\2\2\17\r\3\2\2\2\20\27\5\6\4\2\21\23\5\b\5\2\22\21\3\2\2\2\23\24\3"+
		"\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\27\3\2\2\2\26\20\3\2\2\2\26\22\3"+
		"\2\2\2\27\5\3\2\2\2\30\31\t\2\2\2\31\7\3\2\2\2\32\33\t\3\2\2\33\t\3\2"+
		"\2\2\5\r\24\26";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}