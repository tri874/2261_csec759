// Generated from org/evomaster/core/parser/PostgresSimilarTo.g4 by ANTLR 4.9.2
package org.evomaster.core.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PostgresSimilarToParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PostgresSimilarToVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(PostgresSimilarToParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(PostgresSimilarToParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#alternative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternative(PostgresSimilarToParser.AlternativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PostgresSimilarToParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(PostgresSimilarToParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#bracketQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifier(PostgresSimilarToParser.BracketQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#bracketQuantifierSingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierSingle(PostgresSimilarToParser.BracketQuantifierSingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#bracketQuantifierOnlyMin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierOnlyMin(PostgresSimilarToParser.BracketQuantifierOnlyMinContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#bracketQuantifierRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketQuantifierRange(PostgresSimilarToParser.BracketQuantifierRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(PostgresSimilarToParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#patternCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternCharacter(PostgresSimilarToParser.PatternCharacterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#characterClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterClass(PostgresSimilarToParser.CharacterClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#classRanges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassRanges(PostgresSimilarToParser.ClassRangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#nonemptyClassRanges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonemptyClassRanges(PostgresSimilarToParser.NonemptyClassRangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#nonemptyClassRangesNoDash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonemptyClassRangesNoDash(PostgresSimilarToParser.NonemptyClassRangesNoDashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#classAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassAtom(PostgresSimilarToParser.ClassAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#classAtomNoDash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassAtomNoDash(PostgresSimilarToParser.ClassAtomNoDashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresSimilarToParser#decimalDigits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDigits(PostgresSimilarToParser.DecimalDigitsContext ctx);
}