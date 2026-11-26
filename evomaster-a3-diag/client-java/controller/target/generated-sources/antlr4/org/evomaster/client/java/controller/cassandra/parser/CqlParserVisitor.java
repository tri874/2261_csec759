// Generated from org/evomaster/client/java/controller/cassandra/parser/CqlParser.g4 by ANTLR 4.9.2
package org.evomaster.client.java.controller.cassandra.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CqlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CqlParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(CqlParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#cqls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCqls(CqlParser.CqlsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#statementSeparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSeparator(CqlParser.StatementSeparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#empty_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_(CqlParser.Empty_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#cql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCql(CqlParser.CqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#revoke}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevoke(CqlParser.RevokeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#listRoles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListRoles(CqlParser.ListRolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#listPermissions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListPermissions(CqlParser.ListPermissionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#grant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrant(CqlParser.GrantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#priviledge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriviledge(CqlParser.PriviledgeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(CqlParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUser(CqlParser.CreateUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateRole(CqlParser.CreateRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateType(CqlParser.CreateTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#typeMemberColumnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeMemberColumnList(CqlParser.TypeMemberColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createTrigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTrigger(CqlParser.CreateTriggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createMaterializedView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedView(CqlParser.CreateMaterializedViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#materializedViewWhere}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewWhere(CqlParser.MaterializedViewWhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#columnNotNullList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnNotNullList(CqlParser.ColumnNotNullListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#columnNotNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnNotNull(CqlParser.ColumnNotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#materializedViewOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewOptions(CqlParser.MaterializedViewOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createKeyspace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateKeyspace(CqlParser.CreateKeyspaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFunction(CqlParser.CreateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#codeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(CqlParser.CodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(CqlParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#returnMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnMode(CqlParser.ReturnModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createAggregate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateAggregate(CqlParser.CreateAggregateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#initCondDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitCondDefinition(CqlParser.InitCondDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#initCondHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitCondHash(CqlParser.InitCondHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#initCondHashItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitCondHashItem(CqlParser.InitCondHashItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#initCondListNested}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitCondListNested(CqlParser.InitCondListNestedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#initCondList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitCondList(CqlParser.InitCondListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#orReplace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrReplace(CqlParser.OrReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUser(CqlParser.AlterUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#userPassword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserPassword(CqlParser.UserPasswordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#userSuperUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSuperUser(CqlParser.UserSuperUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterType(CqlParser.AlterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTypeOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeOperation(CqlParser.AlterTypeOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTypeRename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeRename(CqlParser.AlterTypeRenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTypeRenameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeRenameList(CqlParser.AlterTypeRenameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTypeRenameItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeRenameItem(CqlParser.AlterTypeRenameItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTypeAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeAdd(CqlParser.AlterTypeAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTypeAlterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeAlterType(CqlParser.AlterTypeAlterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTable(CqlParser.AlterTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableOperation(CqlParser.AlterTableOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableWith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableWith(CqlParser.AlterTableWithContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableRename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRename(CqlParser.AlterTableRenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableDropCompactStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropCompactStorage(CqlParser.AlterTableDropCompactStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableDropColumns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumns(CqlParser.AlterTableDropColumnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableDropColumnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnList(CqlParser.AlterTableDropColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAdd(CqlParser.AlterTableAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableColumnDefinition(CqlParser.AlterTableColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterTableAlter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlter(CqlParser.AlterTableAlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumnDefinition(CqlParser.AlterColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterRole(CqlParser.AlterRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#roleWith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleWith(CqlParser.RoleWithContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#roleWithOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleWithOptions(CqlParser.RoleWithOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterMaterializedView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMaterializedView(CqlParser.AlterMaterializedViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropUser(CqlParser.DropUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropType(CqlParser.DropTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropMaterializedView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropMaterializedView(CqlParser.DropMaterializedViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropAggregate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropAggregate(CqlParser.DropAggregateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropFunction(CqlParser.DropFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropTrigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTrigger(CqlParser.DropTriggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropRole(CqlParser.DropRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTable(CqlParser.DropTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropKeyspace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropKeyspace(CqlParser.DropKeyspaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dropIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndex(CqlParser.DropIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTable(CqlParser.CreateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#withElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithElement(CqlParser.WithElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#tableOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOptions(CqlParser.TableOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#clusteringOrder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringOrder(CqlParser.ClusteringOrderContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#tableOptionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOptionItem(CqlParser.TableOptionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#tableOptionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOptionName(CqlParser.TableOptionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#tableOptionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOptionValue(CqlParser.TableOptionValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#optionHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionHash(CqlParser.OptionHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#optionHashItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionHashItem(CqlParser.OptionHashItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#optionHashKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionHashKey(CqlParser.OptionHashKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#optionHashValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionHashValue(CqlParser.OptionHashValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#columnDefinitionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinitionList(CqlParser.ColumnDefinitionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(CqlParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#column_mask}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_mask(CqlParser.Column_maskContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(CqlParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#primaryKeyColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyColumn(CqlParser.PrimaryKeyColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#primaryKeyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyElement(CqlParser.PrimaryKeyElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#primaryKeyDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyDefinition(CqlParser.PrimaryKeyDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#singlePrimaryKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinglePrimaryKey(CqlParser.SinglePrimaryKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#compoundKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundKey(CqlParser.CompoundKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#compositeKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeKey(CqlParser.CompositeKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#partitionKeyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionKeyList(CqlParser.PartitionKeyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#clusteringKeyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringKeyList(CqlParser.ClusteringKeyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#partitionKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionKey(CqlParser.PartitionKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#clusteringKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringKey(CqlParser.ClusteringKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#applyBatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBatch(CqlParser.ApplyBatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#beginBatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginBatch(CqlParser.BeginBatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#batchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBatchType(CqlParser.BatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#alterKeyspace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterKeyspace(CqlParser.AlterKeyspaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#replicationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplicationList(CqlParser.ReplicationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#replicationListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplicationListItem(CqlParser.ReplicationListItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#durableWrites}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDurableWrites(CqlParser.DurableWritesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#use_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse_(CqlParser.Use_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#truncate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruncate(CqlParser.TruncateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#createIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndex(CqlParser.CreateIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#indexName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexName(CqlParser.IndexNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#indexColumnSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexColumnSpec(CqlParser.IndexColumnSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#indexKeysSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexKeysSpec(CqlParser.IndexKeysSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#indexEntriesSSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexEntriesSSpec(CqlParser.IndexEntriesSSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#indexFullSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexFullSpec(CqlParser.IndexFullSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#delete_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_(CqlParser.Delete_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#deleteColumnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteColumnList(CqlParser.DeleteColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#deleteColumnItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteColumnItem(CqlParser.DeleteColumnItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(CqlParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#ifSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSpec(CqlParser.IfSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#ifConditionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfConditionList(CqlParser.IfConditionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(CqlParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#assignments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignments(CqlParser.AssignmentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#assignmentElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentElement(CqlParser.AssignmentElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#assignmentSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentSet(CqlParser.AssignmentSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#assignmentMap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentMap(CqlParser.AssignmentMapContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#assignmentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentList(CqlParser.AssignmentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#assignmentTuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentTuple(CqlParser.AssignmentTupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(CqlParser.InsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#usingTtlTimestamp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingTtlTimestamp(CqlParser.UsingTtlTimestampContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#timestamp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestamp(CqlParser.TimestampContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#ttl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTtl(CqlParser.TtlContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#usingTimestampSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingTimestampSpec(CqlParser.UsingTimestampSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#ifNotExist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNotExist(CqlParser.IfNotExistContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#ifExist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExist(CqlParser.IfExistContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#insertValuesSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertValuesSpec(CqlParser.InsertValuesSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#insertColumnSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertColumnSpec(CqlParser.InsertColumnSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnList(CqlParser.ColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(CqlParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CqlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#select_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_(CqlParser.Select_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#allowFilteringSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllowFilteringSpec(CqlParser.AllowFilteringSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#limitSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitSpec(CqlParser.LimitSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#fromSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromSpec(CqlParser.FromSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#fromSpecElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromSpecElement(CqlParser.FromSpecElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#orderSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderSpec(CqlParser.OrderSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#orderSpecElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderSpecElement(CqlParser.OrderSpecElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#whereSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereSpec(CqlParser.WhereSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#distinctSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinctSpec(CqlParser.DistinctSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#selectElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectElements(CqlParser.SelectElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#selectElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectElement(CqlParser.SelectElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#relationElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationElements(CqlParser.RelationElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#relationElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationElement(CqlParser.RelationElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#relalationContains}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelalationContains(CqlParser.RelalationContainsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#relalationContainsKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelalationContainsKey(CqlParser.RelalationContainsKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CqlParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#functionArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgs(CqlParser.FunctionArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(CqlParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#decimalLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(CqlParser.DecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(CqlParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(CqlParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(CqlParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#hexadecimalLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimalLiteral(CqlParser.HexadecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#durationLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDurationLiteral(CqlParser.DurationLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#keyspace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyspace(CqlParser.KeyspaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(CqlParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(CqlParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(CqlParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dataTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeName(CqlParser.DataTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dataTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeDefinition(CqlParser.DataTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#orderDirection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderDirection(CqlParser.OrderDirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRole(CqlParser.RoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrigger(CqlParser.TriggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#triggerClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerClass(CqlParser.TriggerClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#materializedView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedView(CqlParser.MaterializedViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#type_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_(CqlParser.Type_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#aggregate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregate(CqlParser.AggregateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#function_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_(CqlParser.Function_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#language}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguage(CqlParser.LanguageContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUser(CqlParser.UserContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#password}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassword(CqlParser.PasswordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#hashKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashKey(CqlParser.HashKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(CqlParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#paramName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamName(CqlParser.ParamNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAdd(CqlParser.KwAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAggregate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAggregate(CqlParser.KwAggregateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAll}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAll(CqlParser.KwAllContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAllPermissions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAllPermissions(CqlParser.KwAllPermissionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAllow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAllow(CqlParser.KwAllowContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAlter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAlter(CqlParser.KwAlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAnd(CqlParser.KwAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwApply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwApply(CqlParser.KwApplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAs(CqlParser.KwAsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAsc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAsc(CqlParser.KwAscContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwAuthorize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwAuthorize(CqlParser.KwAuthorizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwBatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwBatch(CqlParser.KwBatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwBegin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwBegin(CqlParser.KwBeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwBy(CqlParser.KwByContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwCalled}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwCalled(CqlParser.KwCalledContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwClustering}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwClustering(CqlParser.KwClusteringContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwCompact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwCompact(CqlParser.KwCompactContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwContains}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwContains(CqlParser.KwContainsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwCreate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwCreate(CqlParser.KwCreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwDelete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwDelete(CqlParser.KwDeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwDesc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwDesc(CqlParser.KwDescContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwDescribe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwDescribe(CqlParser.KwDescribeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwDistinct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwDistinct(CqlParser.KwDistinctContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwDrop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwDrop(CqlParser.KwDropContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwDurableWrites}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwDurableWrites(CqlParser.KwDurableWritesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwEntries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwEntries(CqlParser.KwEntriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwExecute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwExecute(CqlParser.KwExecuteContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwExists(CqlParser.KwExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwFiltering}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwFiltering(CqlParser.KwFilteringContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwFinalfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwFinalfunc(CqlParser.KwFinalfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwFrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwFrom(CqlParser.KwFromContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwFull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwFull(CqlParser.KwFullContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwFunction(CqlParser.KwFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwFunctions(CqlParser.KwFunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwGrant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwGrant(CqlParser.KwGrantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwIf(CqlParser.KwIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwIn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwIn(CqlParser.KwInContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwIndex(CqlParser.KwIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwInitcond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwInitcond(CqlParser.KwInitcondContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwInput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwInput(CqlParser.KwInputContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwInsert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwInsert(CqlParser.KwInsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwInto(CqlParser.KwIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwIs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwIs(CqlParser.KwIsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwJson}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwJson(CqlParser.KwJsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwKey(CqlParser.KwKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwKeys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwKeys(CqlParser.KwKeysContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwKeyspace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwKeyspace(CqlParser.KwKeyspaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwKeyspaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwKeyspaces(CqlParser.KwKeyspacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwLanguage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwLanguage(CqlParser.KwLanguageContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwLimit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwLimit(CqlParser.KwLimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwList(CqlParser.KwListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwLogged}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwLogged(CqlParser.KwLoggedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwLogin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwLogin(CqlParser.KwLoginContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwMaterialized}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwMaterialized(CqlParser.KwMaterializedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwModify}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwModify(CqlParser.KwModifyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwNosuperuser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwNosuperuser(CqlParser.KwNosuperuserContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwNorecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwNorecursive(CqlParser.KwNorecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwNot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwNot(CqlParser.KwNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwNull(CqlParser.KwNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwOf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwOf(CqlParser.KwOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwOn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwOn(CqlParser.KwOnContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwOptions(CqlParser.KwOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwOr(CqlParser.KwOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwOrder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwOrder(CqlParser.KwOrderContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwPassword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwPassword(CqlParser.KwPasswordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwPrimary(CqlParser.KwPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwRename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwRename(CqlParser.KwRenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwReplace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwReplace(CqlParser.KwReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwReplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwReplication(CqlParser.KwReplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwReturns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwReturns(CqlParser.KwReturnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwRole(CqlParser.KwRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwRoles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwRoles(CqlParser.KwRolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwSelect(CqlParser.KwSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwSet(CqlParser.KwSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwSfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwSfunc(CqlParser.KwSfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwStorage(CqlParser.KwStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwStype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwStype(CqlParser.KwStypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwSuperuser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwSuperuser(CqlParser.KwSuperuserContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwTable(CqlParser.KwTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwTimestamp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwTimestamp(CqlParser.KwTimestampContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwTo(CqlParser.KwToContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwTrigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwTrigger(CqlParser.KwTriggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwTruncate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwTruncate(CqlParser.KwTruncateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwTtl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwTtl(CqlParser.KwTtlContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwType(CqlParser.KwTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwUnlogged}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwUnlogged(CqlParser.KwUnloggedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwUpdate(CqlParser.KwUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwUse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwUse(CqlParser.KwUseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwUser(CqlParser.KwUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwUsing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwUsing(CqlParser.KwUsingContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwValues(CqlParser.KwValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwView(CqlParser.KwViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwWhere}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwWhere(CqlParser.KwWhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwWith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwWith(CqlParser.KwWithContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#kwRevoke}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKwRevoke(CqlParser.KwRevokeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxBracketLr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxBracketLr(CqlParser.SyntaxBracketLrContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxBracketRr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxBracketRr(CqlParser.SyntaxBracketRrContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxBracketLc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxBracketLc(CqlParser.SyntaxBracketLcContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxBracketRc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxBracketRc(CqlParser.SyntaxBracketRcContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxBracketLa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxBracketLa(CqlParser.SyntaxBracketLaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxBracketRa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxBracketRa(CqlParser.SyntaxBracketRaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxBracketLs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxBracketLs(CqlParser.SyntaxBracketLsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxBracketRs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxBracketRs(CqlParser.SyntaxBracketRsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxComma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxComma(CqlParser.SyntaxCommaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#syntaxColon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxColon(CqlParser.SyntaxColonContext ctx);
}