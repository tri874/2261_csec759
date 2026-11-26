// Generated from org/evomaster/client/java/controller/dynamodb/DynamoDbConditionExpression.g4 by ANTLR 4.9.2
package org.evomaster.client.java.controller.dynamodb;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DynamoDbConditionExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DynamoDbConditionExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DynamoDbConditionExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DynamoDbConditionExpressionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DynamoDbConditionExpressionParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(DynamoDbConditionExpressionParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DynamoDbConditionExpressionParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(DynamoDbConditionExpressionParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negatedExpr}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatedExpr(DynamoDbConditionExpressionParser.NegatedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(DynamoDbConditionExpressionParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesizedPrimary}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedPrimary(DynamoDbConditionExpressionParser.ParenthesizedPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code predicatePrimary}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePrimary(DynamoDbConditionExpressionParser.PredicatePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeExistsPredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeExistsPredicate(DynamoDbConditionExpressionParser.AttributeExistsPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeNotExistsPredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeNotExistsPredicate(DynamoDbConditionExpressionParser.AttributeNotExistsPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeTypePredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeTypePredicate(DynamoDbConditionExpressionParser.AttributeTypePredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code beginsWithPredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginsWithPredicate(DynamoDbConditionExpressionParser.BeginsWithPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code containsPredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsPredicate(DynamoDbConditionExpressionParser.ContainsPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sizePredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizePredicate(DynamoDbConditionExpressionParser.SizePredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenPredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenPredicate(DynamoDbConditionExpressionParser.BetweenPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inPredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInPredicate(DynamoDbConditionExpressionParser.InPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonPredicate}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonPredicate(DynamoDbConditionExpressionParser.ComparisonPredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link DynamoDbConditionExpressionParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(DynamoDbConditionExpressionParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DynamoDbConditionExpressionParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(DynamoDbConditionExpressionParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code placeholderValue}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceholderValue(DynamoDbConditionExpressionParser.PlaceholderValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(DynamoDbConditionExpressionParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberValue(DynamoDbConditionExpressionParser.NumberValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanValue}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(DynamoDbConditionExpressionParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullValue}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullValue(DynamoDbConditionExpressionParser.NullValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierValue}
	 * labeled alternative in {@link DynamoDbConditionExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierValue(DynamoDbConditionExpressionParser.IdentifierValueContext ctx);
}