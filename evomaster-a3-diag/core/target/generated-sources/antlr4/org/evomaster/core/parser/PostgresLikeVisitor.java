// Generated from org/evomaster/core/parser/PostgresLike.g4 by ANTLR 4.9.2
package org.evomaster.core.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PostgresLikeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PostgresLikeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PostgresLikeParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(PostgresLikeParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresLikeParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PostgresLikeParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresLikeParser#specialSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialSymbol(PostgresLikeParser.SpecialSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgresLikeParser#baseSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseSymbol(PostgresLikeParser.BaseSymbolContext ctx);
}