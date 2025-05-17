// Generated from MiniJavaParser.g4 by ANTLR 4.13.1

    package fr.n7.stl.minijava.parser;

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
	 * Enter a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniJavaParser.BlockContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#expressionBinaire}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaire(MiniJavaParser.ExpressionBinaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expressionBinaire}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaire(MiniJavaParser.ExpressionBinaireContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#identifiant}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiant(MiniJavaParser.IdentifiantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#identifiant}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiant(MiniJavaParser.IdentifiantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#visibilites}.
	 * @param ctx the parse tree
	 */
	void enterVisibilites(MiniJavaParser.VisibilitesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#visibilites}.
	 * @param ctx the parse tree
	 */
	void exitVisibilites(MiniJavaParser.VisibilitesContext ctx);
}