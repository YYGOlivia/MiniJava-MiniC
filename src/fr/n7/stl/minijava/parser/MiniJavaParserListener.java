// Generated from MiniJavaParser.g4 by ANTLR 4.13.1

    package fr.n7.stl.minijava.parser;
	import fr.n7.stl.minijava.ast.Block;
	import fr.n7.stl.minijava.ast.type.AtomicType;
	import fr.n7.stl.minijava.ast.type.Type;
	import fr.n7.stl.minijava.ast.clazz.Modifier;
	import fr.n7.stl.minijava.ast.clazz.Class;
	import fr.n7.stl.minijava.ast.clazz.Attribute;
	import fr.n7.stl.minijava.ast.clazz.Constructor;
	import fr.n7.stl.minijava.ast.clazz.Method;

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
	 * Enter a parse tree produced by {@link MiniJavaParser#bloc}.
	 * @param ctx the parse tree
	 */
	void enterBloc(MiniJavaParser.BlocContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#bloc}.
	 * @param ctx the parse tree
	 */
	void exitBloc(MiniJavaParser.BlocContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#membre}.
	 * @param ctx the parse tree
	 */
	void enterMembre(MiniJavaParser.MembreContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#membre}.
	 * @param ctx the parse tree
	 */
	void exitMembre(MiniJavaParser.MembreContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(MiniJavaParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(MiniJavaParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJavaParser.ExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#modificateur}.
	 * @param ctx the parse tree
	 */
	void enterModificateur(MiniJavaParser.ModificateurContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#modificateur}.
	 * @param ctx the parse tree
	 */
	void exitModificateur(MiniJavaParser.ModificateurContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionTrue}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExpressionTrue(MiniJavaParser.ExpressionTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionTrue}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExpressionTrue(MiniJavaParser.ExpressionTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionFalse}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFalse(MiniJavaParser.ExpressionFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionFalse}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFalse(MiniJavaParser.ExpressionFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionInt}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExpressionInt(MiniJavaParser.ExpressionIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionInt}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExpressionInt(MiniJavaParser.ExpressionIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionFloat}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFloat(MiniJavaParser.ExpressionFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionFloat}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFloat(MiniJavaParser.ExpressionFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionCharacter}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExpressionCharacter(MiniJavaParser.ExpressionCharacterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionCharacter}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExpressionCharacter(MiniJavaParser.ExpressionCharacterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionString}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExpressionString(MiniJavaParser.ExpressionStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionString}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExpressionString(MiniJavaParser.ExpressionStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNull}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNull(MiniJavaParser.ExpressionNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNull}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNull(MiniJavaParser.ExpressionNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionAccess}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAccess(MiniJavaParser.ExpressionAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionAccess}
	 * labeled alternative in {@link MiniJavaParser#expressionConstante}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAccess(MiniJavaParser.ExpressionAccessContext ctx);
}