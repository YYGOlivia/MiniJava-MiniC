// Generated from MiniJavaParser.g4 by ANTLR 4.13.1

    package fr.n7.stl.minijava.parser;
	import fr.n7.stl.minijava.ast.Block;
	import fr.n7.stl.minijava.ast.type.AtomicType;
	import fr.n7.stl.minijava.ast.type.Type;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.Modifier;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.ClassDeclaration;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.AttributeDeclaration;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.ConstructorDeclaration;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.MethodDeclaration;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.Definition;
	import fr.n7.stl.minijava.ast.instruction.Instruction;
	import fr.n7.stl.minijava.ast.instruction.declaration.ParameterDeclaration;
	import fr.n7.stl.minijava.ast.expression.Expression;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#programme}.
	 * @param ctx the parse tree
	 */
	void enterProgramme(MiniJavaParser.ProgrammeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#programme}.
	 * @param ctx the parse tree
	 */
	void exitProgramme(MiniJavaParser.ProgrammeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#classe}.
	 * @param ctx the parse tree
	 */
	void enterClasse(MiniJavaParser.ClasseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#classe}.
	 * @param ctx the parse tree
	 */
	void exitClasse(MiniJavaParser.ClasseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(MiniJavaParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(MiniJavaParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#constructeur}.
	 * @param ctx the parse tree
	 */
	void enterConstructeur(MiniJavaParser.ConstructeurContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#constructeur}.
	 * @param ctx the parse tree
	 */
	void exitConstructeur(MiniJavaParser.ConstructeurContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methode}.
	 * @param ctx the parse tree
	 */
	void enterMethode(MiniJavaParser.MethodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methode}.
	 * @param ctx the parse tree
	 */
	void exitMethode(MiniJavaParser.MethodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#attribut}.
	 * @param ctx the parse tree
	 */
	void enterAttribut(MiniJavaParser.AttributContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#attribut}.
	 * @param ctx the parse tree
	 */
	void exitAttribut(MiniJavaParser.AttributContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#entete}.
	 * @param ctx the parse tree
	 */
	void enterEntete(MiniJavaParser.EnteteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#entete}.
	 * @param ctx the parse tree
	 */
	void exitEntete(MiniJavaParser.EnteteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#corps}.
	 * @param ctx the parse tree
	 */
	void enterCorps(MiniJavaParser.CorpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#corps}.
	 * @param ctx the parse tree
	 */
	void exitCorps(MiniJavaParser.CorpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parametres}.
	 * @param ctx the parse tree
	 */
	void enterParametres(MiniJavaParser.ParametresContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parametres}.
	 * @param ctx the parse tree
	 */
	void exitParametres(MiniJavaParser.ParametresContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterInstr(MiniJavaParser.InstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitInstr(MiniJavaParser.InstrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(MiniJavaParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(MiniJavaParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprConstructorCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprConstructorCall(MiniJavaParser.ExprConstructorCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprConstructorCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprConstructorCall(MiniJavaParser.ExprConstructorCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprEq}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprEq(MiniJavaParser.ExprEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprEq}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprEq(MiniJavaParser.ExprEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMult(MiniJavaParser.ExprMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMult(MiniJavaParser.ExprMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprConstante}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprConstante(MiniJavaParser.ExprConstanteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprConstante}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprConstante(MiniJavaParser.ExprConstanteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIneq}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIneq(MiniJavaParser.ExprIneqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIneq}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIneq(MiniJavaParser.ExprIneqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParenthesee}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParenthesee(MiniJavaParser.ExprParentheseeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParenthesee}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParenthesee(MiniJavaParser.ExprParentheseeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprArrayAccess}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprArrayAccess(MiniJavaParser.ExprArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprArrayAccess}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprArrayAccess(MiniJavaParser.ExprArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprCond}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCond(MiniJavaParser.ExprCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCond}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCond(MiniJavaParser.ExprCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(MiniJavaParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(MiniJavaParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprThisMethodCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprThisMethodCall(MiniJavaParser.ExprThisMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprThisMethodCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprThisMethodCall(MiniJavaParser.ExprThisMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAttribute}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAttribute(MiniJavaParser.ExprAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAttribute}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAttribute(MiniJavaParser.ExprAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(MiniJavaParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(MiniJavaParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(MiniJavaParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(MiniJavaParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSequence}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSequence(MiniJavaParser.ExprSequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSequence}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSequence(MiniJavaParser.ExprSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMethodCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMethodCall(MiniJavaParser.ExprMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMethodCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMethodCall(MiniJavaParser.ExprMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOposite}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOposite(MiniJavaParser.ExprOpositeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOposite}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOposite(MiniJavaParser.ExprOpositeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprThis}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprThis(MiniJavaParser.ExprThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprThis}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprThis(MiniJavaParser.ExprThisContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#declLocale}.
	 * @param ctx the parse tree
	 */
	void enterDeclLocale(MiniJavaParser.DeclLocaleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#declLocale}.
	 * @param ctx the parse tree
	 */
	void exitDeclLocale(MiniJavaParser.DeclLocaleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(MiniJavaParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(MiniJavaParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(MiniJavaParser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(MiniJavaParser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(MiniJavaParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(MiniJavaParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeArray}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeArray(MiniJavaParser.TypeArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeArray}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeArray(MiniJavaParser.TypeArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeNamed}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeNamed(MiniJavaParser.TypeNamedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeNamed}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeNamed(MiniJavaParser.TypeNamedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeAtomic}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeAtomic(MiniJavaParser.TypeAtomicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeAtomic}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeAtomic(MiniJavaParser.TypeAtomicContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#atomique}.
	 * @param ctx the parse tree
	 */
	void enterAtomique(MiniJavaParser.AtomiqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#atomique}.
	 * @param ctx the parse tree
	 */
	void exitAtomique(MiniJavaParser.AtomiqueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprTrue}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExprTrue(MiniJavaParser.ExprTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprTrue}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExprTrue(MiniJavaParser.ExprTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFalse}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExprFalse(MiniJavaParser.ExprFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFalse}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExprFalse(MiniJavaParser.ExprFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExprInt(MiniJavaParser.ExprIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExprInt(MiniJavaParser.ExprIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFloat}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExprFloat(MiniJavaParser.ExprFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFloat}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExprFloat(MiniJavaParser.ExprFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprCharacter}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExprCharacter(MiniJavaParser.ExprCharacterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCharacter}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExprCharacter(MiniJavaParser.ExprCharacterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprString}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExprString(MiniJavaParser.ExprStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprString}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExprString(MiniJavaParser.ExprStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNull}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExprNull(MiniJavaParser.ExprNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNull}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExprNull(MiniJavaParser.ExprNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAccess}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExprAccess(MiniJavaParser.ExprAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAccess}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExprAccess(MiniJavaParser.ExprAccessContext ctx);
}