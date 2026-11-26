// Generated from org/evomaster/core/parser/PostgresSimilarTo.g4 by ANTLR 4.9.2
package org.evomaster.core.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PostgresSimilarToLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DecimalDigit=1, CARET=2, SLASH=3, STAR=4, PLUS=5, QUESTION=6, PAREN_open=7, 
		PAREN_close=8, BRACKET_open=9, BRACKET_close=10, BRACE_open=11, BRACE_close=12, 
		OR=13, MINUS=14, COMMA=15, UNDERSCORE=16, PERCENT=17, BaseChar=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DecimalDigit", "CARET", "SLASH", "STAR", "PLUS", "QUESTION", "PAREN_open", 
			"PAREN_close", "BRACKET_open", "BRACKET_close", "BRACE_open", "BRACE_close", 
			"OR", "MINUS", "COMMA", "UNDERSCORE", "PERCENT", "BaseChar"
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


	public PostgresSimilarToLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PostgresSimilarTo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24K\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\4\3\2\62;\t\2"+
		"\'\'*/\62;AA]]_a}\177\2J\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2"+
		"\2\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2\23"+
		"\67\3\2\2\2\259\3\2\2\2\27;\3\2\2\2\31=\3\2\2\2\33?\3\2\2\2\35A\3\2\2"+
		"\2\37C\3\2\2\2!E\3\2\2\2#G\3\2\2\2%I\3\2\2\2\'(\t\2\2\2(\4\3\2\2\2)*\7"+
		"`\2\2*\6\3\2\2\2+,\7^\2\2,\b\3\2\2\2-.\7,\2\2.\n\3\2\2\2/\60\7-\2\2\60"+
		"\f\3\2\2\2\61\62\7A\2\2\62\16\3\2\2\2\63\64\7*\2\2\64\20\3\2\2\2\65\66"+
		"\7+\2\2\66\22\3\2\2\2\678\7]\2\28\24\3\2\2\29:\7_\2\2:\26\3\2\2\2;<\7"+
		"}\2\2<\30\3\2\2\2=>\7\177\2\2>\32\3\2\2\2?@\7~\2\2@\34\3\2\2\2AB\7/\2"+
		"\2B\36\3\2\2\2CD\7.\2\2D \3\2\2\2EF\7a\2\2F\"\3\2\2\2GH\7\'\2\2H$\3\2"+
		"\2\2IJ\n\3\2\2J&\3\2\2\2\3\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}