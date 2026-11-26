// Generated from org/evomaster/core/parser/RegexEcma262.g4 by ANTLR 4.9.2
package org.evomaster.core.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegexEcma262Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegexEcma262Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(RegexEcma262Parser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(RegexEcma262Parser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#alternative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternative(RegexEcma262Parser.AlternativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(RegexEcma262Parser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(RegexEcma262Parser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(RegexEcma262Parser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#quantifierPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifierPrefix(RegexEcma262Parser.QuantifierPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#bracketQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifier(RegexEcma262Parser.BracketQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#bracketQuantifierSingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierSingle(RegexEcma262Parser.BracketQuantifierSingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#bracketQuantifierOnlyMin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierOnlyMin(RegexEcma262Parser.BracketQuantifierOnlyMinContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#bracketQuantifierRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierRange(RegexEcma262Parser.BracketQuantifierRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(RegexEcma262Parser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#patternCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternCharacter(RegexEcma262Parser.PatternCharacterContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#characterClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterClass(RegexEcma262Parser.CharacterClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#classRanges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassRanges(RegexEcma262Parser.ClassRangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#nonemptyClassRanges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonemptyClassRanges(RegexEcma262Parser.NonemptyClassRangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#nonemptyClassRangesNoDash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonemptyClassRangesNoDash(RegexEcma262Parser.NonemptyClassRangesNoDashContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#classAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassAtom(RegexEcma262Parser.ClassAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#classAtomNoDash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassAtomNoDash(RegexEcma262Parser.ClassAtomNoDashContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#classEscape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassEscape(RegexEcma262Parser.ClassEscapeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#atomEscape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomEscape(RegexEcma262Parser.AtomEscapeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#decimalDigits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDigits(RegexEcma262Parser.DecimalDigitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexEcma262Parser#controlLetterExtendedEscape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlLetterExtendedEscape(RegexEcma262Parser.ControlLetterExtendedEscapeContext ctx);
}