// Generated from org/evomaster/client/java/controller/neo4j/cypher25/Cypher25Parser.g4 by ANTLR 4.9.2
package org.evomaster.client.java.controller.neo4j.cypher25;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Cypher25Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Cypher25ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(Cypher25Parser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Cypher25Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#regularQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularQuery(Cypher25Parser.RegularQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#singleQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleQuery(Cypher25Parser.SingleQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClause(Cypher25Parser.ClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#useClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseClause(Cypher25Parser.UseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#graphReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphReference(Cypher25Parser.GraphReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#finishClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinishClause(Cypher25Parser.FinishClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(Cypher25Parser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#returnBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnBody(Cypher25Parser.ReturnBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#returnItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnItem(Cypher25Parser.ReturnItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#returnItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnItems(Cypher25Parser.ReturnItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#orderItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderItem(Cypher25Parser.OrderItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#ascToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAscToken(Cypher25Parser.AscTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#descToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescToken(Cypher25Parser.DescTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#orderBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderBy(Cypher25Parser.OrderByContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#skip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(Cypher25Parser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#limit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit(Cypher25Parser.LimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(Cypher25Parser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#withClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithClause(Cypher25Parser.WithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateClause(Cypher25Parser.CreateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#insertClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertClause(Cypher25Parser.InsertClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#setClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetClause(Cypher25Parser.SetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetProp}
	 * labeled alternative in {@link Cypher25Parser#setItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetProp(Cypher25Parser.SetPropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetDynamicProp}
	 * labeled alternative in {@link Cypher25Parser#setItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDynamicProp(Cypher25Parser.SetDynamicPropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetProps}
	 * labeled alternative in {@link Cypher25Parser#setItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetProps(Cypher25Parser.SetPropsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddProp}
	 * labeled alternative in {@link Cypher25Parser#setItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddProp(Cypher25Parser.AddPropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetLabels}
	 * labeled alternative in {@link Cypher25Parser#setItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetLabels(Cypher25Parser.SetLabelsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetLabelsIs}
	 * labeled alternative in {@link Cypher25Parser#setItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetLabelsIs(Cypher25Parser.SetLabelsIsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#removeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveClause(Cypher25Parser.RemoveClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RemoveProp}
	 * labeled alternative in {@link Cypher25Parser#removeItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveProp(Cypher25Parser.RemovePropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RemoveDynamicProp}
	 * labeled alternative in {@link Cypher25Parser#removeItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveDynamicProp(Cypher25Parser.RemoveDynamicPropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RemoveLabels}
	 * labeled alternative in {@link Cypher25Parser#removeItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveLabels(Cypher25Parser.RemoveLabelsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RemoveLabelsIs}
	 * labeled alternative in {@link Cypher25Parser#removeItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveLabelsIs(Cypher25Parser.RemoveLabelsIsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#deleteClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteClause(Cypher25Parser.DeleteClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#matchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchClause(Cypher25Parser.MatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#matchMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchMode(Cypher25Parser.MatchModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHint(Cypher25Parser.HintContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#mergeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMergeClause(Cypher25Parser.MergeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#mergeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMergeAction(Cypher25Parser.MergeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#unwindClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnwindClause(Cypher25Parser.UnwindClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#callClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallClause(Cypher25Parser.CallClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#procedureName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureName(Cypher25Parser.ProcedureNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#procedureArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureArgument(Cypher25Parser.ProcedureArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#procedureResultItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureResultItem(Cypher25Parser.ProcedureResultItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#loadCSVClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadCSVClause(Cypher25Parser.LoadCSVClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#foreachClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachClause(Cypher25Parser.ForeachClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#subqueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryClause(Cypher25Parser.SubqueryClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#subqueryScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryScope(Cypher25Parser.SubqueryScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#subqueryInTransactionsParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryInTransactionsParameters(Cypher25Parser.SubqueryInTransactionsParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#subqueryInTransactionsBatchParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryInTransactionsBatchParameters(Cypher25Parser.SubqueryInTransactionsBatchParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#subqueryInTransactionsErrorParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryInTransactionsErrorParameters(Cypher25Parser.SubqueryInTransactionsErrorParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#subqueryInTransactionsReportParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryInTransactionsReportParameters(Cypher25Parser.SubqueryInTransactionsReportParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#orderBySkipLimitClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderBySkipLimitClause(Cypher25Parser.OrderBySkipLimitClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#patternList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternList(Cypher25Parser.PatternListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#insertPatternList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertPatternList(Cypher25Parser.InsertPatternListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(Cypher25Parser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#insertPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertPattern(Cypher25Parser.InsertPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(Cypher25Parser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#anonymousPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousPattern(Cypher25Parser.AnonymousPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#shortestPathPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortestPathPattern(Cypher25Parser.ShortestPathPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#patternElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternElement(Cypher25Parser.PatternElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnyShortestPath}
	 * labeled alternative in {@link Cypher25Parser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyShortestPath(Cypher25Parser.AnyShortestPathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllShortestPath}
	 * labeled alternative in {@link Cypher25Parser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllShortestPath(Cypher25Parser.AllShortestPathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnyPath}
	 * labeled alternative in {@link Cypher25Parser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyPath(Cypher25Parser.AnyPathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllPath}
	 * labeled alternative in {@link Cypher25Parser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllPath(Cypher25Parser.AllPathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShortestGroup}
	 * labeled alternative in {@link Cypher25Parser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortestGroup(Cypher25Parser.ShortestGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#groupToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupToken(Cypher25Parser.GroupTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#pathToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathToken(Cypher25Parser.PathTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#pathPatternNonEmpty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathPatternNonEmpty(Cypher25Parser.PathPatternNonEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#nodePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodePattern(Cypher25Parser.NodePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#insertNodePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertNodePattern(Cypher25Parser.InsertNodePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#parenthesizedPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedPath(Cypher25Parser.ParenthesizedPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#nodeLabels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeLabels(Cypher25Parser.NodeLabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#nodeLabelsIs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeLabelsIs(Cypher25Parser.NodeLabelsIsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dynamicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicExpression(Cypher25Parser.DynamicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dynamicAnyAllExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicAnyAllExpression(Cypher25Parser.DynamicAnyAllExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dynamicLabelType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicLabelType(Cypher25Parser.DynamicLabelTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelType(Cypher25Parser.LabelTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#relType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelType(Cypher25Parser.RelTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelOrRelType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelOrRelType(Cypher25Parser.LabelOrRelTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(Cypher25Parser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#relationshipPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationshipPattern(Cypher25Parser.RelationshipPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#insertRelationshipPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertRelationshipPattern(Cypher25Parser.InsertRelationshipPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#leftArrow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftArrow(Cypher25Parser.LeftArrowContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#arrowLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowLine(Cypher25Parser.ArrowLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#rightArrow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightArrow(Cypher25Parser.RightArrowContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#pathLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathLength(Cypher25Parser.PathLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression(Cypher25Parser.LabelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelExpression4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression4(Cypher25Parser.LabelExpression4Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelExpression4Is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression4Is(Cypher25Parser.LabelExpression4IsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelExpression3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression3(Cypher25Parser.LabelExpression3Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelExpression3Is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression3Is(Cypher25Parser.LabelExpression3IsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelExpression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression2(Cypher25Parser.LabelExpression2Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelExpression2Is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression2Is(Cypher25Parser.LabelExpression2IsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedLabelExpression}
	 * labeled alternative in {@link Cypher25Parser#labelExpression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedLabelExpression(Cypher25Parser.ParenthesizedLabelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnyLabel}
	 * labeled alternative in {@link Cypher25Parser#labelExpression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyLabel(Cypher25Parser.AnyLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DynamicLabel}
	 * labeled alternative in {@link Cypher25Parser#labelExpression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicLabel(Cypher25Parser.DynamicLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LabelName}
	 * labeled alternative in {@link Cypher25Parser#labelExpression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelName(Cypher25Parser.LabelNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedLabelExpressionIs}
	 * labeled alternative in {@link Cypher25Parser#labelExpression1Is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedLabelExpressionIs(Cypher25Parser.ParenthesizedLabelExpressionIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnyLabelIs}
	 * labeled alternative in {@link Cypher25Parser#labelExpression1Is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyLabelIs(Cypher25Parser.AnyLabelIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DynamicLabelIs}
	 * labeled alternative in {@link Cypher25Parser#labelExpression1Is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicLabelIs(Cypher25Parser.DynamicLabelIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LabelNameIs}
	 * labeled alternative in {@link Cypher25Parser#labelExpression1Is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelNameIs(Cypher25Parser.LabelNameIsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#insertNodeLabelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertNodeLabelExpression(Cypher25Parser.InsertNodeLabelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#insertRelationshipLabelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertRelationshipLabelExpression(Cypher25Parser.InsertRelationshipLabelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Cypher25Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression11}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression11(Cypher25Parser.Expression11Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression10}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression10(Cypher25Parser.Expression10Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression9}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression9(Cypher25Parser.Expression9Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression8}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression8(Cypher25Parser.Expression8Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression7}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression7(Cypher25Parser.Expression7Context ctx);
	/**
	 * Visit a parse tree produced by the {@code StringAndListComparison}
	 * labeled alternative in {@link Cypher25Parser#comparisonExpression6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAndListComparison(Cypher25Parser.StringAndListComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullComparison}
	 * labeled alternative in {@link Cypher25Parser#comparisonExpression6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullComparison(Cypher25Parser.NullComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeComparison}
	 * labeled alternative in {@link Cypher25Parser#comparisonExpression6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeComparison(Cypher25Parser.TypeComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalFormComparison}
	 * labeled alternative in {@link Cypher25Parser#comparisonExpression6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFormComparison(Cypher25Parser.NormalFormComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#normalForm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalForm(Cypher25Parser.NormalFormContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression6(Cypher25Parser.Expression6Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression5(Cypher25Parser.Expression5Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression4(Cypher25Parser.Expression4Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression3(Cypher25Parser.Expression3Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression2(Cypher25Parser.Expression2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyPostfix}
	 * labeled alternative in {@link Cypher25Parser#postFix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyPostfix(Cypher25Parser.PropertyPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LabelPostfix}
	 * labeled alternative in {@link Cypher25Parser#postFix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelPostfix(Cypher25Parser.LabelPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexPostfix}
	 * labeled alternative in {@link Cypher25Parser#postFix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexPostfix(Cypher25Parser.IndexPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RangePostfix}
	 * labeled alternative in {@link Cypher25Parser#postFix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangePostfix(Cypher25Parser.RangePostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(Cypher25Parser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dynamicProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicProperty(Cypher25Parser.DynamicPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#propertyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyExpression(Cypher25Parser.PropertyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dynamicPropertyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicPropertyExpression(Cypher25Parser.DynamicPropertyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#expression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression1(Cypher25Parser.Expression1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code NummericLiteral}
	 * labeled alternative in {@link Cypher25Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNummericLiteral(Cypher25Parser.NummericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringsLiteral}
	 * labeled alternative in {@link Cypher25Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringsLiteral(Cypher25Parser.StringsLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OtherLiteral}
	 * labeled alternative in {@link Cypher25Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherLiteral(Cypher25Parser.OtherLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link Cypher25Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(Cypher25Parser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KeywordLiteral}
	 * labeled alternative in {@link Cypher25Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordLiteral(Cypher25Parser.KeywordLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#caseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpression(Cypher25Parser.CaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#caseAlternative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseAlternative(Cypher25Parser.CaseAlternativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#extendedCaseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendedCaseExpression(Cypher25Parser.ExtendedCaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#extendedCaseAlternative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendedCaseAlternative(Cypher25Parser.ExtendedCaseAlternativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhenStringOrList}
	 * labeled alternative in {@link Cypher25Parser#extendedWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenStringOrList(Cypher25Parser.WhenStringOrListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhenNull}
	 * labeled alternative in {@link Cypher25Parser#extendedWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenNull(Cypher25Parser.WhenNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhenType}
	 * labeled alternative in {@link Cypher25Parser#extendedWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenType(Cypher25Parser.WhenTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhenForm}
	 * labeled alternative in {@link Cypher25Parser#extendedWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenForm(Cypher25Parser.WhenFormContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhenComparator}
	 * labeled alternative in {@link Cypher25Parser#extendedWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenComparator(Cypher25Parser.WhenComparatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhenEquals}
	 * labeled alternative in {@link Cypher25Parser#extendedWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenEquals(Cypher25Parser.WhenEqualsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#listComprehension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehension(Cypher25Parser.ListComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#patternComprehension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternComprehension(Cypher25Parser.PatternComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#reduceExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReduceExpression(Cypher25Parser.ReduceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#listItemsPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListItemsPredicate(Cypher25Parser.ListItemsPredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#normalizeFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalizeFunction(Cypher25Parser.NormalizeFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#trimFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunction(Cypher25Parser.TrimFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#patternExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternExpression(Cypher25Parser.PatternExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#shortestPathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortestPathExpression(Cypher25Parser.ShortestPathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(Cypher25Parser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#mapProjection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapProjection(Cypher25Parser.MapProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#mapProjectionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapProjectionElement(Cypher25Parser.MapProjectionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#countStar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountStar(Cypher25Parser.CountStarContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#existsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsExpression(Cypher25Parser.ExistsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#countExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountExpression(Cypher25Parser.CountExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#collectExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectExpression(Cypher25Parser.CollectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(Cypher25Parser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#signedIntegerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedIntegerLiteral(Cypher25Parser.SignedIntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(Cypher25Parser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#propertyKeyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyKeyName(Cypher25Parser.PropertyKeyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(Cypher25Parser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#parameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterName(Cypher25Parser.ParameterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#functionInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(Cypher25Parser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#functionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgument(Cypher25Parser.FunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(Cypher25Parser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespace(Cypher25Parser.NamespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(Cypher25Parser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#nonEmptyNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEmptyNameList(Cypher25Parser.NonEmptyNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(Cypher25Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#typePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePart(Cypher25Parser.TypePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(Cypher25Parser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#typeNullability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNullability(Cypher25Parser.TypeNullabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#typeListSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeListSuffix(Cypher25Parser.TypeListSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(Cypher25Parser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateCommand(Cypher25Parser.CreateCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropCommand(Cypher25Parser.DropCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCommand(Cypher25Parser.ShowCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showCommandYield}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCommandYield(Cypher25Parser.ShowCommandYieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#yieldItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldItem(Cypher25Parser.YieldItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#yieldSkip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldSkip(Cypher25Parser.YieldSkipContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#yieldLimit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldLimit(Cypher25Parser.YieldLimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#yieldClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldClause(Cypher25Parser.YieldClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#commandOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandOptions(Cypher25Parser.CommandOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#terminateCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminateCommand(Cypher25Parser.TerminateCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#composableCommandClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposableCommandClauses(Cypher25Parser.ComposableCommandClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#composableShowCommandClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposableShowCommandClauses(Cypher25Parser.ComposableShowCommandClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showIndexCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowIndexCommand(Cypher25Parser.ShowIndexCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showIndexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowIndexType(Cypher25Parser.ShowIndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showIndexesEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowIndexesEnd(Cypher25Parser.ShowIndexesEndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShowConstraintAll}
	 * labeled alternative in {@link Cypher25Parser#showConstraintCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowConstraintAll(Cypher25Parser.ShowConstraintAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShowConstraintExist}
	 * labeled alternative in {@link Cypher25Parser#showConstraintCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowConstraintExist(Cypher25Parser.ShowConstraintExistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShowConstraintKey}
	 * labeled alternative in {@link Cypher25Parser#showConstraintCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowConstraintKey(Cypher25Parser.ShowConstraintKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShowConstraintPropType}
	 * labeled alternative in {@link Cypher25Parser#showConstraintCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowConstraintPropType(Cypher25Parser.ShowConstraintPropTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShowConstraintUnique}
	 * labeled alternative in {@link Cypher25Parser#showConstraintCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowConstraintUnique(Cypher25Parser.ShowConstraintUniqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nodeEntity}
	 * labeled alternative in {@link Cypher25Parser#showConstraintEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeEntity(Cypher25Parser.NodeEntityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relEntity}
	 * labeled alternative in {@link Cypher25Parser#showConstraintEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelEntity(Cypher25Parser.RelEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#constraintExistType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintExistType(Cypher25Parser.ConstraintExistTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showConstraintsEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowConstraintsEnd(Cypher25Parser.ShowConstraintsEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showProcedures}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProcedures(Cypher25Parser.ShowProceduresContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowFunctions(Cypher25Parser.ShowFunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#functionToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionToken(Cypher25Parser.FunctionTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#executableBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutableBy(Cypher25Parser.ExecutableByContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showFunctionsType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowFunctionsType(Cypher25Parser.ShowFunctionsTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showTransactions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowTransactions(Cypher25Parser.ShowTransactionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#terminateTransactions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminateTransactions(Cypher25Parser.TerminateTransactionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showSettings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSettings(Cypher25Parser.ShowSettingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#settingToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSettingToken(Cypher25Parser.SettingTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#namesAndClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamesAndClauses(Cypher25Parser.NamesAndClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#stringsOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringsOrExpression(Cypher25Parser.StringsOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#commandNodePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandNodePattern(Cypher25Parser.CommandNodePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#commandRelPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandRelPattern(Cypher25Parser.CommandRelPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateConstraint(Cypher25Parser.CreateConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstraintTyped}
	 * labeled alternative in {@link Cypher25Parser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintTyped(Cypher25Parser.ConstraintTypedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstraintIsUnique}
	 * labeled alternative in {@link Cypher25Parser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintIsUnique(Cypher25Parser.ConstraintIsUniqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstraintKey}
	 * labeled alternative in {@link Cypher25Parser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintKey(Cypher25Parser.ConstraintKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstraintIsNotNull}
	 * labeled alternative in {@link Cypher25Parser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintIsNotNull(Cypher25Parser.ConstraintIsNotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropConstraint(Cypher25Parser.DropConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndex(Cypher25Parser.CreateIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createIndex_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndex_(Cypher25Parser.CreateIndex_Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createFulltextIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFulltextIndex(Cypher25Parser.CreateFulltextIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#fulltextNodePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFulltextNodePattern(Cypher25Parser.FulltextNodePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#fulltextRelPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFulltextRelPattern(Cypher25Parser.FulltextRelPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createLookupIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLookupIndex(Cypher25Parser.CreateLookupIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#lookupIndexNodePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupIndexNodePattern(Cypher25Parser.LookupIndexNodePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#lookupIndexRelPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupIndexRelPattern(Cypher25Parser.LookupIndexRelPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndex(Cypher25Parser.DropIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#propertyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyList(Cypher25Parser.PropertyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#enclosedPropertyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosedPropertyList(Cypher25Parser.EnclosedPropertyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterCommand(Cypher25Parser.AlterCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#renameCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameCommand(Cypher25Parser.RenameCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#grantCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantCommand(Cypher25Parser.GrantCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#denyCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDenyCommand(Cypher25Parser.DenyCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#revokeCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevokeCommand(Cypher25Parser.RevokeCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#userNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserNames(Cypher25Parser.UserNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#roleNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleNames(Cypher25Parser.RoleNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#roleToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleToken(Cypher25Parser.RoleTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#enableServerCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableServerCommand(Cypher25Parser.EnableServerCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterServer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterServer(Cypher25Parser.AlterServerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#renameServer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameServer(Cypher25Parser.RenameServerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropServer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropServer(Cypher25Parser.DropServerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showServers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowServers(Cypher25Parser.ShowServersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#allocationCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocationCommand(Cypher25Parser.AllocationCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#deallocateDatabaseFromServers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocateDatabaseFromServers(Cypher25Parser.DeallocateDatabaseFromServersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#reallocateDatabases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReallocateDatabases(Cypher25Parser.ReallocateDatabasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateRole(Cypher25Parser.CreateRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropRole(Cypher25Parser.DropRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#renameRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameRole(Cypher25Parser.RenameRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showRoles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowRoles(Cypher25Parser.ShowRolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#grantRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantRole(Cypher25Parser.GrantRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#revokeRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevokeRole(Cypher25Parser.RevokeRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUser(Cypher25Parser.CreateUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropUser(Cypher25Parser.DropUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#renameUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameUser(Cypher25Parser.RenameUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterCurrentUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterCurrentUser(Cypher25Parser.AlterCurrentUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUser(Cypher25Parser.AlterUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#removeNamedProvider}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveNamedProvider(Cypher25Parser.RemoveNamedProviderContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#password}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassword(Cypher25Parser.PasswordContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#passwordOnly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordOnly(Cypher25Parser.PasswordOnlyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#passwordExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordExpression(Cypher25Parser.PasswordExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#passwordChangeRequired}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordChangeRequired(Cypher25Parser.PasswordChangeRequiredContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#userStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserStatus(Cypher25Parser.UserStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#homeDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHomeDatabase(Cypher25Parser.HomeDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#setAuthClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAuthClause(Cypher25Parser.SetAuthClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#userAuthAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserAuthAttribute(Cypher25Parser.UserAuthAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showUsers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowUsers(Cypher25Parser.ShowUsersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showCurrentUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCurrentUser(Cypher25Parser.ShowCurrentUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showSupportedPrivileges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSupportedPrivileges(Cypher25Parser.ShowSupportedPrivilegesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showPrivileges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowPrivileges(Cypher25Parser.ShowPrivilegesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showRolePrivileges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowRolePrivileges(Cypher25Parser.ShowRolePrivilegesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showUserPrivileges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowUserPrivileges(Cypher25Parser.ShowUserPrivilegesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#privilegeAsCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilegeAsCommand(Cypher25Parser.PrivilegeAsCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#privilegeToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilegeToken(Cypher25Parser.PrivilegeTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#privilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilege(Cypher25Parser.PrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#allPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllPrivilege(Cypher25Parser.AllPrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#allPrivilegeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllPrivilegeType(Cypher25Parser.AllPrivilegeTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefaultTarget}
	 * labeled alternative in {@link Cypher25Parser#allPrivilegeTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTarget(Cypher25Parser.DefaultTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DatabaseVariableTarget}
	 * labeled alternative in {@link Cypher25Parser#allPrivilegeTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseVariableTarget(Cypher25Parser.DatabaseVariableTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GraphVariableTarget}
	 * labeled alternative in {@link Cypher25Parser#allPrivilegeTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphVariableTarget(Cypher25Parser.GraphVariableTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DBMSTarget}
	 * labeled alternative in {@link Cypher25Parser#allPrivilegeTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDBMSTarget(Cypher25Parser.DBMSTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePrivilege(Cypher25Parser.CreatePrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createPrivilegeForDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePrivilegeForDatabase(Cypher25Parser.CreatePrivilegeForDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createNodePrivilegeToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateNodePrivilegeToken(Cypher25Parser.CreateNodePrivilegeTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createRelPrivilegeToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateRelPrivilegeToken(Cypher25Parser.CreateRelPrivilegeTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createPropertyPrivilegeToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePropertyPrivilegeToken(Cypher25Parser.CreatePropertyPrivilegeTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#actionForDBMS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionForDBMS(Cypher25Parser.ActionForDBMSContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPrivilege(Cypher25Parser.DropPrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#loadPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadPrivilege(Cypher25Parser.LoadPrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowPrivilege(Cypher25Parser.ShowPrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#setPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetPrivilege(Cypher25Parser.SetPrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#passwordToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordToken(Cypher25Parser.PasswordTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#removePrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemovePrivilege(Cypher25Parser.RemovePrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#writePrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritePrivilege(Cypher25Parser.WritePrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#databasePrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabasePrivilege(Cypher25Parser.DatabasePrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dbmsPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbmsPrivilege(Cypher25Parser.DbmsPrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dbmsPrivilegeExecute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbmsPrivilegeExecute(Cypher25Parser.DbmsPrivilegeExecuteContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#adminToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdminToken(Cypher25Parser.AdminTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#procedureToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureToken(Cypher25Parser.ProcedureTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#indexToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexToken(Cypher25Parser.IndexTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#constraintToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintToken(Cypher25Parser.ConstraintTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#transactionToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionToken(Cypher25Parser.TransactionTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#userQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserQualifier(Cypher25Parser.UserQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#executeFunctionQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteFunctionQualifier(Cypher25Parser.ExecuteFunctionQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#executeProcedureQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteProcedureQualifier(Cypher25Parser.ExecuteProcedureQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#settingQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSettingQualifier(Cypher25Parser.SettingQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#globs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobs(Cypher25Parser.GlobsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#glob}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlob(Cypher25Parser.GlobContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#globRecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobRecursive(Cypher25Parser.GlobRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#globPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobPart(Cypher25Parser.GlobPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#qualifiedGraphPrivilegesWithProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedGraphPrivilegesWithProperty(Cypher25Parser.QualifiedGraphPrivilegesWithPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#qualifiedGraphPrivileges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedGraphPrivileges(Cypher25Parser.QualifiedGraphPrivilegesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#labelsResource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelsResource(Cypher25Parser.LabelsResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#propertiesResource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertiesResource(Cypher25Parser.PropertiesResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#nonEmptyStringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEmptyStringList(Cypher25Parser.NonEmptyStringListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#graphQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphQualifier(Cypher25Parser.GraphQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#graphQualifierToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphQualifierToken(Cypher25Parser.GraphQualifierTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#relToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelToken(Cypher25Parser.RelTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#elementToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementToken(Cypher25Parser.ElementTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#nodeToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeToken(Cypher25Parser.NodeTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#databaseScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseScope(Cypher25Parser.DatabaseScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#graphScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphScope(Cypher25Parser.GraphScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createCompositeDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateCompositeDatabase(Cypher25Parser.CreateCompositeDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabase(Cypher25Parser.CreateDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#primaryTopology}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryTopology(Cypher25Parser.PrimaryTopologyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#primaryToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryToken(Cypher25Parser.PrimaryTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#secondaryTopology}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondaryTopology(Cypher25Parser.SecondaryTopologyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#secondaryToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondaryToken(Cypher25Parser.SecondaryTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDatabase(Cypher25Parser.DropDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#aliasAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasAction(Cypher25Parser.AliasActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabase(Cypher25Parser.AlterDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterDatabaseAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabaseAccess(Cypher25Parser.AlterDatabaseAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterDatabaseTopology}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabaseTopology(Cypher25Parser.AlterDatabaseTopologyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterDatabaseOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabaseOption(Cypher25Parser.AlterDatabaseOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#startDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartDatabase(Cypher25Parser.StartDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#stopDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopDatabase(Cypher25Parser.StopDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#waitClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitClause(Cypher25Parser.WaitClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#secondsToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondsToken(Cypher25Parser.SecondsTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDatabase(Cypher25Parser.ShowDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#aliasName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasName(Cypher25Parser.AliasNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#databaseName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseName(Cypher25Parser.DatabaseNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#createAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateAlias(Cypher25Parser.CreateAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#dropAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropAlias(Cypher25Parser.DropAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterAlias(Cypher25Parser.AlterAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterAliasTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterAliasTarget(Cypher25Parser.AlterAliasTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterAliasUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterAliasUser(Cypher25Parser.AlterAliasUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterAliasPassword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterAliasPassword(Cypher25Parser.AlterAliasPasswordContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterAliasDriver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterAliasDriver(Cypher25Parser.AlterAliasDriverContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#alterAliasProperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterAliasProperties(Cypher25Parser.AlterAliasPropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#showAliases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowAliases(Cypher25Parser.ShowAliasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#symbolicNameOrStringParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicNameOrStringParameter(Cypher25Parser.SymbolicNameOrStringParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#commandNameExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandNameExpression(Cypher25Parser.CommandNameExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#symbolicNameOrStringParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicNameOrStringParameterList(Cypher25Parser.SymbolicNameOrStringParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#symbolicAliasNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicAliasNameList(Cypher25Parser.SymbolicAliasNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#symbolicAliasNameOrParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicAliasNameOrParameter(Cypher25Parser.SymbolicAliasNameOrParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#symbolicAliasName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicAliasName(Cypher25Parser.SymbolicAliasNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#stringListLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringListLiteral(Cypher25Parser.StringListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#stringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList(Cypher25Parser.StringListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(Cypher25Parser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#stringOrParameterExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOrParameterExpression(Cypher25Parser.StringOrParameterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#stringOrParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOrParameter(Cypher25Parser.StringOrParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#uIntOrIntParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUIntOrIntParameter(Cypher25Parser.UIntOrIntParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#mapOrParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapOrParameter(Cypher25Parser.MapOrParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(Cypher25Parser.MapContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#symbolicNameString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicNameString(Cypher25Parser.SymbolicNameStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#escapedSymbolicNameString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscapedSymbolicNameString(Cypher25Parser.EscapedSymbolicNameStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#unescapedSymbolicNameString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnescapedSymbolicNameString(Cypher25Parser.UnescapedSymbolicNameStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#symbolicLabelNameString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicLabelNameString(Cypher25Parser.SymbolicLabelNameStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#unescapedLabelSymbolicNameString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnescapedLabelSymbolicNameString(Cypher25Parser.UnescapedLabelSymbolicNameStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#unescapedLabelSymbolicNameString_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnescapedLabelSymbolicNameString_(Cypher25Parser.UnescapedLabelSymbolicNameString_Context ctx);
	/**
	 * Visit a parse tree produced by {@link Cypher25Parser#endOfFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndOfFile(Cypher25Parser.EndOfFileContext ctx);
}