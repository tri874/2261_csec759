// Generated from org/evomaster/core/parser/RegexJavaParser.g4 by ANTLR 4.9.2
package org.evomaster.core.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegexJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegexJavaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(RegexJavaParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(RegexJavaParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#alternative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternative(RegexJavaParser.AlternativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(RegexJavaParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(RegexJavaParser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(RegexJavaParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#quantifierPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifierPrefix(RegexJavaParser.QuantifierPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#bracketQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifier(RegexJavaParser.BracketQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#bracketQuantifierSingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierSingle(RegexJavaParser.BracketQuantifierSingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#bracketQuantifierOnlyMin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierOnlyMin(RegexJavaParser.BracketQuantifierOnlyMinContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#bracketQuantifierRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierRange(RegexJavaParser.BracketQuantifierRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(RegexJavaParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#quote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote(RegexJavaParser.QuoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#patternCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternCharacter(RegexJavaParser.PatternCharacterContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#characterClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterClass(RegexJavaParser.CharacterClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#classContents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassContents(RegexJavaParser.ClassContentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#classRanges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassRanges(RegexJavaParser.ClassRangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#nonemptyClassRanges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonemptyClassRanges(RegexJavaParser.NonemptyClassRangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#nonemptyClassRangesNoDash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonemptyClassRangesNoDash(RegexJavaParser.NonemptyClassRangesNoDashContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#classAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassAtom(RegexJavaParser.ClassAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#classAtomNoDash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassAtomNoDash(RegexJavaParser.ClassAtomNoDashContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#decimalDigits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDigits(RegexJavaParser.DecimalDigitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#classEscape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassEscape(RegexJavaParser.ClassEscapeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexJavaParser#atomEscape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomEscape(RegexJavaParser.AtomEscapeContext ctx);
}