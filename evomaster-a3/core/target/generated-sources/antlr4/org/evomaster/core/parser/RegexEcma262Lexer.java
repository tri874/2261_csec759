// Generated from org/evomaster/core/parser/RegexEcma262.g4 by ANTLR 4.9.2
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
public class RegexEcma262Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CharacterEscape=1, ControlLetterExtendedEscape=2, DecimalDigit=3, CharacterClassEscape=4, 
		LowerCaseBEscape=5, CARET=6, DOLLAR=7, SLASH=8, DOT=9, STAR=10, PLUS=11, 
		QUESTION=12, PAREN_open=13, PAREN_close=14, BRACKET_open=15, BRACKET_close=16, 
		BRACE_open=17, BRACE_close=18, OR=19, MINUS=20, COMMA=21, BaseChar=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CharacterEscape", "ControlLetterExtendedEscape", "ControlEscape", "IdentityEscape", 
			"DecimalDigit", "CharacterClassEscape", "LowerCaseBEscape", "CARET", 
			"DOLLAR", "SLASH", "DOT", "STAR", "PLUS", "QUESTION", "PAREN_open", "PAREN_close", 
			"BRACKET_open", "BRACKET_close", "BRACE_open", "BRACE_close", "OR", "MINUS", 
			"COMMA", "BaseChar", "OctalEscapeSequence", "UnicodeEscapeSequence", 
			"HexEscapeSequence", "HexDigit", "OctalDigit"
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


	public RegexEcma262Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RegexEcma262.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0099\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2M\n\2\3\3\3\3\3\3\5"+
		"\3R\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u008a\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\2\2"+
		"\37\3\3\5\4\7\2\t\2\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16"+
		"\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\2\65\2\67\29\2;\2\3\2"+
		"\n\7\2hhppttvvxx\13\2\62;DDFFUUYYdfhhpptz\3\2\62;\b\2FFUUYYffuuyy\b\2"+
		"&&*\60\62;AA]`}\177\3\2\62\65\5\2\62;CHch\3\2\629\2\u0098\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3L\3\2\2\2\5N\3\2\2\2"+
		"\7S\3\2\2\2\tU\3\2\2\2\13W\3\2\2\2\rY\3\2\2\2\17\\\3\2\2\2\21_\3\2\2\2"+
		"\23a\3\2\2\2\25c\3\2\2\2\27e\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35k\3\2\2"+
		"\2\37m\3\2\2\2!o\3\2\2\2#q\3\2\2\2%s\3\2\2\2\'u\3\2\2\2)w\3\2\2\2+y\3"+
		"\2\2\2-{\3\2\2\2/}\3\2\2\2\61\177\3\2\2\2\63\u0089\3\2\2\2\65\u008b\3"+
		"\2\2\2\67\u0091\3\2\2\29\u0095\3\2\2\2;\u0097\3\2\2\2=>\5\25\13\2>?\5"+
		"\7\4\2?M\3\2\2\2@A\5\25\13\2AB\5\67\34\2BM\3\2\2\2CD\5\25\13\2DE\5\65"+
		"\33\2EM\3\2\2\2FG\5\25\13\2GH\5\63\32\2HM\3\2\2\2IJ\5\25\13\2JK\5\t\5"+
		"\2KM\3\2\2\2L=\3\2\2\2L@\3\2\2\2LC\3\2\2\2LF\3\2\2\2LI\3\2\2\2M\4\3\2"+
		"\2\2NO\5\25\13\2OQ\7e\2\2PR\13\2\2\2QP\3\2\2\2QR\3\2\2\2R\6\3\2\2\2ST"+
		"\t\2\2\2T\b\3\2\2\2UV\n\3\2\2V\n\3\2\2\2WX\t\4\2\2X\f\3\2\2\2YZ\5\25\13"+
		"\2Z[\t\5\2\2[\16\3\2\2\2\\]\5\25\13\2]^\7d\2\2^\20\3\2\2\2_`\7`\2\2`\22"+
		"\3\2\2\2ab\7&\2\2b\24\3\2\2\2cd\7^\2\2d\26\3\2\2\2ef\7\60\2\2f\30\3\2"+
		"\2\2gh\7,\2\2h\32\3\2\2\2ij\7-\2\2j\34\3\2\2\2kl\7A\2\2l\36\3\2\2\2mn"+
		"\7*\2\2n \3\2\2\2op\7+\2\2p\"\3\2\2\2qr\7]\2\2r$\3\2\2\2st\7_\2\2t&\3"+
		"\2\2\2uv\7}\2\2v(\3\2\2\2wx\7\177\2\2x*\3\2\2\2yz\7~\2\2z,\3\2\2\2{|\7"+
		"/\2\2|.\3\2\2\2}~\7.\2\2~\60\3\2\2\2\177\u0080\n\6\2\2\u0080\62\3\2\2"+
		"\2\u0081\u008a\5;\36\2\u0082\u0083\5;\36\2\u0083\u0084\5;\36\2\u0084\u008a"+
		"\3\2\2\2\u0085\u0086\t\7\2\2\u0086\u0087\5;\36\2\u0087\u0088\5;\36\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0085\3\2"+
		"\2\2\u008a\64\3\2\2\2\u008b\u008c\7w\2\2\u008c\u008d\59\35\2\u008d\u008e"+
		"\59\35\2\u008e\u008f\59\35\2\u008f\u0090\59\35\2\u0090\66\3\2\2\2\u0091"+
		"\u0092\7z\2\2\u0092\u0093\59\35\2\u0093\u0094\59\35\2\u00948\3\2\2\2\u0095"+
		"\u0096\t\b\2\2\u0096:\3\2\2\2\u0097\u0098\t\t\2\2\u0098<\3\2\2\2\6\2L"+
		"Q\u0089\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}