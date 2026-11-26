// Generated from org/evomaster/core/parser/RegexJavaLexer.g4 by ANTLR 4.9.2
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
public class RegexJavaLexer extends Lexer {
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
		QUOTE_MODE=1, CHAR_CLASS_MODE=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "QUOTE_MODE", "CHAR_CLASS_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NAMED_CAPTURE_GROUP_OPEN", "FLAG_GROUP_OPEN", "FLAG_SCOPE_OPEN", "CharacterEscape", 
			"PCharacterClassEscapeLabel", "ControlEscape", "ControlLetter", "DecimalDigit", 
			"CharacterClassEscape", "StartOfInputAssertion", "EndOfInputAssertion", 
			"WordBoundaryAssertion", "NonWordBoundaryAssertion", "EQUAL", "LESS_THAN", 
			"CARET", "DOLLAR", "SLASH", "DOT", "STAR", "PLUS", "QUESTION", "PAREN_open", 
			"PAREN_close", "BRACKET_close", "BRACE_open", "BRACE_close", "OR", "MINUS", 
			"COMMA", "COLON", "BaseChar", "OctalEscapeSequence", "UnicodeEscapeSequence", 
			"HexEscapeSequence", "HexDigit", "OctalDigit", "BackReference", "NamedBackReference", 
			"QUOTE_OPEN", "BRACKET_open", "QUOTE_CLOSE", "QUOTE_CONTENT", "CC_BRACKET_CLOSE", 
			"CC_BRACKET_OPEN", "CC_CARET", "CC_MINUS", "CC_DOUBLE_AMPERSAND", "CC_CharacterClassEscape", 
			"CC_CharacterEscape", "CC_BaseChar"
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


	public RegexJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RegexJavaLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u0180\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\3\2\3\2\3\2\3\2\3\2\3\2\7\2r\n\2\f\2\16\2u\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\6\3|\n\3\r\3\16\3}\3\3\3\3\6\3\u0082\n\3\r\3\16\3\u0083\5\3\u0086"+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\u008e\n\3\r\3\16\3\u008f\3\3\3\3\5\3"+
		"\u0094\n\3\3\4\3\4\3\4\6\4\u0099\n\4\r\4\16\4\u009a\3\4\3\4\6\4\u009f"+
		"\n\4\r\4\16\4\u00a0\5\4\u00a3\n\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u00ab\n"+
		"\4\r\4\16\4\u00ac\3\4\3\4\5\4\u00b1\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00c6\n\5\3\6\6\6\u00c9"+
		"\n\6\r\6\16\6\u00ca\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u00dc\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u011b\n\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3"+
		"$\3$\3$\6$\u012a\n$\r$\16$\u012b\3$\3$\5$\u0130\n$\3%\3%\3&\3&\3\'\3\'"+
		"\3\'\7\'\u0139\n\'\f\'\16\'\u013c\13\'\3(\3(\3(\3(\3(\3(\7(\u0144\n(\f"+
		"(\16(\u0147\13(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,"+
		"\3,\6,\u015c\n,\r,\16,\u015d\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3"+
		"/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\64\2\2\65\5\3\7\4\t\5\13\6\r\2\17\2\21\2\23\7\25"+
		"\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\25\61\26\63"+
		"\27\65\30\67\319\32;\33=\34?\35A\36C\37E\2G\2I\2K\2M\2O Q!S\"U#W$Y%[\2"+
		"]\2_\2a\2c&e\2g\2i\2\5\2\3\4\24\4\2C\\c|\5\2\62;C\\c|\t\2WWffkkoouuww"+
		"zz\b\2ffkkoouuwwzz\7\2\62;??C\\aac|\7\2ccghppttvv\4\2Aac|\3\2\62;\n\2"+
		"FFJJUUXYffjjuuxy\4\2RRrr\t\2&&*\60\62<>?AA]`}\177\3\2\62\65\5\2\62;CH"+
		"ch\3\2\629\3\2\63;\3\2GG\3\2^^\4\2//]`\2\u018f\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\3Y\3\2\2\2\4[\3\2\2\2\4]\3\2\2\2\4_\3"+
		"\2\2\2\4a\3\2\2\2\4c\3\2\2\2\4e\3\2\2\2\4g\3\2\2\2\4i\3\2\2\2\5k\3\2\2"+
		"\2\7\u0093\3\2\2\2\t\u00b0\3\2\2\2\13\u00c5\3\2\2\2\r\u00c8\3\2\2\2\17"+
		"\u00cc\3\2\2\2\21\u00ce\3\2\2\2\23\u00d0\3\2\2\2\25\u00db\3\2\2\2\27\u00dd"+
		"\3\2\2\2\31\u00e0\3\2\2\2\33\u00e3\3\2\2\2\35\u00e6\3\2\2\2\37\u00e9\3"+
		"\2\2\2!\u00eb\3\2\2\2#\u00ed\3\2\2\2%\u00ef\3\2\2\2\'\u00f1\3\2\2\2)\u00f3"+
		"\3\2\2\2+\u00f5\3\2\2\2-\u00f7\3\2\2\2/\u00f9\3\2\2\2\61\u00fb\3\2\2\2"+
		"\63\u00fd\3\2\2\2\65\u00ff\3\2\2\2\67\u0101\3\2\2\29\u0103\3\2\2\2;\u0105"+
		"\3\2\2\2=\u0107\3\2\2\2?\u0109\3\2\2\2A\u010b\3\2\2\2C\u010d\3\2\2\2E"+
		"\u011a\3\2\2\2G\u011c\3\2\2\2I\u012f\3\2\2\2K\u0131\3\2\2\2M\u0133\3\2"+
		"\2\2O\u0135\3\2\2\2Q\u013d\3\2\2\2S\u014a\3\2\2\2U\u014f\3\2\2\2W\u0153"+
		"\3\2\2\2Y\u015b\3\2\2\2[\u015f\3\2\2\2]\u0164\3\2\2\2_\u0169\3\2\2\2a"+
		"\u016d\3\2\2\2c\u0171\3\2\2\2e\u0174\3\2\2\2g\u0178\3\2\2\2i\u017c\3\2"+
		"\2\2kl\7*\2\2lm\7A\2\2mn\7>\2\2no\3\2\2\2os\t\2\2\2pr\t\3\2\2qp\3\2\2"+
		"\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7@\2\2w\6\3\2\2"+
		"\2xy\5\61\30\2y{\5/\27\2z|\t\4\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2"+
		"\2\2~\u0085\3\2\2\2\177\u0081\5=\36\2\u0080\u0082\t\4\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\3\2\2\2\u0085\177\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2"+
		"\2\u0087\u0088\5A \2\u0088\u0094\3\2\2\2\u0089\u008a\5\61\30\2\u008a\u008b"+
		"\5/\27\2\u008b\u008d\5=\36\2\u008c\u008e\t\4\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0092\5A \2\u0092\u0094\3\2\2\2\u0093x\3\2\2\2\u0093\u0089"+
		"\3\2\2\2\u0094\b\3\2\2\2\u0095\u0096\5\61\30\2\u0096\u0098\5/\27\2\u0097"+
		"\u0099\t\4\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u00a2\3\2\2\2\u009c\u009e\5=\36\2\u009d"+
		"\u009f\t\5\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009c\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\5\63\31\2\u00a5\u00b1\3"+
		"\2\2\2\u00a6\u00a7\5\61\30\2\u00a7\u00a8\5/\27\2\u00a8\u00aa\5=\36\2\u00a9"+
		"\u00ab\t\4\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\5\63\31\2\u00af"+
		"\u00b1\3\2\2\2\u00b0\u0095\3\2\2\2\u00b0\u00a6\3\2\2\2\u00b1\n\3\2\2\2"+
		"\u00b2\u00b3\5\'\23\2\u00b3\u00b4\5\17\7\2\u00b4\u00c6\3\2\2\2\u00b5\u00b6"+
		"\5\'\23\2\u00b6\u00b7\7e\2\2\u00b7\u00b8\5\21\b\2\u00b8\u00c6\3\2\2\2"+
		"\u00b9\u00ba\5\'\23\2\u00ba\u00bb\5I$\2\u00bb\u00c6\3\2\2\2\u00bc\u00bd"+
		"\5\'\23\2\u00bd\u00be\5G#\2\u00be\u00c6\3\2\2\2\u00bf\u00c0\5\'\23\2\u00c0"+
		"\u00c1\5E\"\2\u00c1\u00c6\3\2\2\2\u00c2\u00c3\5\'\23\2\u00c3\u00c4\n\3"+
		"\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00b2\3\2\2\2\u00c5\u00b5\3\2\2\2\u00c5"+
		"\u00b9\3\2\2\2\u00c5\u00bc\3\2\2\2\u00c5\u00bf\3\2\2\2\u00c5\u00c2\3\2"+
		"\2\2\u00c6\f\3\2\2\2\u00c7\u00c9\t\6\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\16\3\2\2\2\u00cc"+
		"\u00cd\t\7\2\2\u00cd\20\3\2\2\2\u00ce\u00cf\t\b\2\2\u00cf\22\3\2\2\2\u00d0"+
		"\u00d1\t\t\2\2\u00d1\24\3\2\2\2\u00d2\u00d3\5\'\23\2\u00d3\u00d4\t\n\2"+
		"\2\u00d4\u00dc\3\2\2\2\u00d5\u00d6\5\'\23\2\u00d6\u00d7\t\13\2\2\u00d7"+
		"\u00d8\5\67\33\2\u00d8\u00d9\5\r\6\2\u00d9\u00da\59\34\2\u00da\u00dc\3"+
		"\2\2\2\u00db\u00d2\3\2\2\2\u00db\u00d5\3\2\2\2\u00dc\26\3\2\2\2\u00dd"+
		"\u00de\5\'\23\2\u00de\u00df\7C\2\2\u00df\30\3\2\2\2\u00e0\u00e1\5\'\23"+
		"\2\u00e1\u00e2\7|\2\2\u00e2\32\3\2\2\2\u00e3\u00e4\5\'\23\2\u00e4\u00e5"+
		"\7d\2\2\u00e5\34\3\2\2\2\u00e6\u00e7\5\'\23\2\u00e7\u00e8\7D\2\2\u00e8"+
		"\36\3\2\2\2\u00e9\u00ea\7?\2\2\u00ea \3\2\2\2\u00eb\u00ec\7>\2\2\u00ec"+
		"\"\3\2\2\2\u00ed\u00ee\7`\2\2\u00ee$\3\2\2\2\u00ef\u00f0\7&\2\2\u00f0"+
		"&\3\2\2\2\u00f1\u00f2\7^\2\2\u00f2(\3\2\2\2\u00f3\u00f4\7\60\2\2\u00f4"+
		"*\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6,\3\2\2\2\u00f7\u00f8\7-\2\2\u00f8."+
		"\3\2\2\2\u00f9\u00fa\7A\2\2\u00fa\60\3\2\2\2\u00fb\u00fc\7*\2\2\u00fc"+
		"\62\3\2\2\2\u00fd\u00fe\7+\2\2\u00fe\64\3\2\2\2\u00ff\u0100\7_\2\2\u0100"+
		"\66\3\2\2\2\u0101\u0102\7}\2\2\u01028\3\2\2\2\u0103\u0104\7\177\2\2\u0104"+
		":\3\2\2\2\u0105\u0106\7~\2\2\u0106<\3\2\2\2\u0107\u0108\7/\2\2\u0108>"+
		"\3\2\2\2\u0109\u010a\7.\2\2\u010a@\3\2\2\2\u010b\u010c\7<\2\2\u010cB\3"+
		"\2\2\2\u010d\u010e\n\f\2\2\u010eD\3\2\2\2\u010f\u0110\7\62\2\2\u0110\u011b"+
		"\5M&\2\u0111\u0112\7\62\2\2\u0112\u0113\5M&\2\u0113\u0114\5M&\2\u0114"+
		"\u011b\3\2\2\2\u0115\u0116\7\62\2\2\u0116\u0117\t\r\2\2\u0117\u0118\5"+
		"M&\2\u0118\u0119\5M&\2\u0119\u011b\3\2\2\2\u011a\u010f\3\2\2\2\u011a\u0111"+
		"\3\2\2\2\u011a\u0115\3\2\2\2\u011bF\3\2\2\2\u011c\u011d\7w\2\2\u011d\u011e"+
		"\5K%\2\u011e\u011f\5K%\2\u011f\u0120\5K%\2\u0120\u0121\5K%\2\u0121H\3"+
		"\2\2\2\u0122\u0123\7z\2\2\u0123\u0124\5K%\2\u0124\u0125\5K%\2\u0125\u0130"+
		"\3\2\2\2\u0126\u0127\7z\2\2\u0127\u0129\5\67\33\2\u0128\u012a\5K%\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012d\3\2\2\2\u012d\u012e\59\34\2\u012e\u0130\3\2\2\2\u012f"+
		"\u0122\3\2\2\2\u012f\u0126\3\2\2\2\u0130J\3\2\2\2\u0131\u0132\t\16\2\2"+
		"\u0132L\3\2\2\2\u0133\u0134\t\17\2\2\u0134N\3\2\2\2\u0135\u0136\5\'\23"+
		"\2\u0136\u013a\t\20\2\2\u0137\u0139\5\23\t\2\u0138\u0137\3\2\2\2\u0139"+
		"\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013bP\3\2\2\2"+
		"\u013c\u013a\3\2\2\2\u013d\u013e\5\'\23\2\u013e\u013f\7m\2\2\u013f\u0140"+
		"\7>\2\2\u0140\u0141\3\2\2\2\u0141\u0145\t\2\2\2\u0142\u0144\t\3\2\2\u0143"+
		"\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\7@\2\2\u0149"+
		"R\3\2\2\2\u014a\u014b\7^\2\2\u014b\u014c\7S\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014e\b)\2\2\u014eT\3\2\2\2\u014f\u0150\7]\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0152\b*\3\2\u0152V\3\2\2\2\u0153\u0154\7^\2\2\u0154\u0155\7G\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\u0157\b+\4\2\u0157X\3\2\2\2\u0158\u0159\7^\2\2\u0159"+
		"\u015c\n\21\2\2\u015a\u015c\n\22\2\2\u015b\u0158\3\2\2\2\u015b\u015a\3"+
		"\2\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"Z\3\2\2\2\u015f\u0160\7_\2\2\u0160\u0161\3\2\2\2\u0161\u0162\b-\5\2\u0162"+
		"\u0163\b-\4\2\u0163\\\3\2\2\2\u0164\u0165\7]\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u0167\b.\6\2\u0167\u0168\b.\3\2\u0168^\3\2\2\2\u0169\u016a\7`\2\2\u016a"+
		"\u016b\3\2\2\2\u016b\u016c\b/\7\2\u016c`\3\2\2\2\u016d\u016e\7/\2\2\u016e"+
		"\u016f\3\2\2\2\u016f\u0170\b\60\b\2\u0170b\3\2\2\2\u0171\u0172\7(\2\2"+
		"\u0172\u0173\7(\2\2\u0173d\3\2\2\2\u0174\u0175\5\25\n\2\u0175\u0176\3"+
		"\2\2\2\u0176\u0177\b\62\t\2\u0177f\3\2\2\2\u0178\u0179\5\13\5\2\u0179"+
		"\u017a\3\2\2\2\u017a\u017b\b\63\n\2\u017bh\3\2\2\2\u017c\u017d\n\23\2"+
		"\2\u017d\u017e\3\2\2\2\u017e\u017f\b\64\13\2\u017fj\3\2\2\2\32\2\3\4s"+
		"}\u0083\u0085\u008f\u0093\u009a\u00a0\u00a2\u00ac\u00b0\u00c5\u00ca\u00db"+
		"\u011a\u012b\u012f\u013a\u0145\u015b\u015d\f\7\3\2\7\4\2\6\2\2\t\30\2"+
		"\t#\2\t\17\2\t\34\2\t\b\2\t\6\2\t\37\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}