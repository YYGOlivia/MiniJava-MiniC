package fr.n7.stl.minijava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleConditional;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleConversion;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.accessible.ArrayAccess;
import fr.n7.stl.minic.ast.expression.accessible.BinaryExpression;
import fr.n7.stl.minic.ast.expression.accessible.BinaryOperator;
import fr.n7.stl.minic.ast.expression.accessible.IdentifierAccess;
import fr.n7.stl.minic.ast.expression.accessible.UnaryExpression;
import fr.n7.stl.minic.ast.expression.accessible.UnaryOperator;
import fr.n7.stl.minic.ast.expression.allocation.ArrayAllocation;
import fr.n7.stl.minic.ast.expression.assignable.ArrayAssignment;
import fr.n7.stl.minic.ast.expression.assignable.AssignableConversion;
import fr.n7.stl.minic.ast.expression.assignable.VariableAssignment;
import fr.n7.stl.minic.ast.expression.value.BooleanValue;
import fr.n7.stl.minic.ast.expression.value.CharacterValue;
import fr.n7.stl.minic.ast.expression.value.FloatingValue;
import fr.n7.stl.minic.ast.expression.value.IntegerValue;
import fr.n7.stl.minic.ast.expression.value.NullValue;
import fr.n7.stl.minic.ast.expression.value.StringValue;
import fr.n7.stl.minic.ast.instruction.Assignment;
import fr.n7.stl.minic.ast.instruction.Conditional;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.Iteration;
import fr.n7.stl.minic.ast.instruction.Printer;
import fr.n7.stl.minic.ast.instruction.Return;
import fr.n7.stl.minic.ast.instruction.declaration.ConstantDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minic.ast.type.ArrayType;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.expression.accessible.AttributeAccess;
import fr.n7.stl.minijava.ast.expression.accessible.MethodCallAccess;
import fr.n7.stl.minijava.ast.expression.accessible.SuperAccess;
import fr.n7.stl.minijava.ast.expression.accessible.ThisAccess;
import fr.n7.stl.minijava.ast.expression.allocation.ObjectAllocation;
import fr.n7.stl.minijava.ast.expression.assignable.AttributeAssignment;
import fr.n7.stl.minijava.ast.expression.assignable.MethodCallAssignment;
import fr.n7.stl.minijava.ast.expression.assignable.SuperAssignment;
import fr.n7.stl.minijava.ast.expression.assignable.ThisAssignment;
import fr.n7.stl.minijava.ast.instruction.MethodCall;
import fr.n7.stl.minijava.ast.instruction.SuperCall;
import fr.n7.stl.minijava.ast.instruction.ThisCall;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.AccessRight;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassElement;
import fr.n7.stl.minijava.ast.type.declaration.ConstructorDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ElementKind;
import fr.n7.stl.minijava.ast.type.declaration.MainDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.MethodDeclaration;
import fr.n7.stl.minijava.parser.MiniJavaParser;
import fr.n7.stl.minijava.parser.MiniJavaParser.AccessRightContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.AttributClasseContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.AttributMainContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.AttributObjetContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ClasseContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ClassesContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ConstructeurContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.DeclarationContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.EcritureAppelMethodeExpliciteContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.EcritureAppelMethodeImpliciteContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.EcritureAttributContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.EcritureConversionContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.EcritureIdentContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.EcritureSuperContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.EcritureTableauContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.EcritureThisContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ElementContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ElementsContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprCondContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExpressionOpposeeContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.InstructionAppelConstructeurAlternatifContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.InstructionAppelConstructeurParentContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.InstructionAppelMethodeExpliciteContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.InstructionAppelMethodeImpliciteContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.InstructionIterationContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.InstructionSiContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.LectureAttributContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.LectureIdentContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.LectureSuperContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.LectureTableauContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.LectureThisContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.MethodeAbstraiteContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.MethodeClasseContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.MethodeMainContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.MethodeObjetContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ParametreContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ParametresContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.PrincipaleContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ProgrammeContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.SignatureContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.TypeTableauContext;
import fr.n7.stl.minijava.parser.MiniJavaParserBaseListener;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.impl.TAMFactoryImpl;
import fr.n7.stl.util.Logger;

public class ASTBuilder extends MiniJavaParserBaseListener {

    private String output_path;
    private MainDeclaration main;
    private List<ClassDeclaration> classes;

    public ASTBuilder(String output) {
        this.output_path = output;
    }

    /**
     * Start the compile phase : collect, resolve, memory allocation and
     * code generation.
     */
    public void startCompilation(boolean generateCode) {
        for (ClassDeclaration c : this.classes) {
            System.out.println(c);
        }
        System.out.println(this.main);
        SymbolTable tds = new SymbolTable();

        // Register les classes
        for (ClassDeclaration c : this.classes) {
            if (!tds.accepts(c)) {
                Logger.error("[ASTBuilder] The name " + c.getName() + " is already used");
            }
            tds.register(c);
        }

        boolean okCollect = this.classes.stream().allMatch(c -> c.collectAndPartialResolve(tds));
        okCollect = okCollect && this.main.collectAndPartialResolve(tds);
        if (!okCollect) {
            System.out.println("Collect failed : " + tds);
            return;
        }
        System.out.println("Collect succeeded");

        boolean okResolve = this.classes.stream().allMatch(c -> c.completeResolve(tds));
        okResolve = okResolve && this.main.completeResolve(tds);
        if (!okResolve) {
            System.out.println("Resolve failed." + tds);
            return;
        }
        System.out.println("Resolve succeeded.");

        boolean okCheckType = this.classes.stream().allMatch(c -> c.checkType());
        okCheckType = okCheckType && this.main.checkType();
        if (!okCheckType) {
            System.out.println("Type verification failed.");
            return;
        }
        System.out.println("Type verification succeeded.");

        if (!generateCode) {
            System.out.println("Skipping code generation.");
            return;
        }

        System.out.println("Code generation ...");
        this.classes.stream().forEach(c -> c.allocateMemory(Register.SB, 0));
        this.main.allocateMemory(Register.SB, 0);

        TAMFactory factory = new TAMFactoryImpl();
        Fragment f = factory.createFragment();
        // f.add(factory.createJump("main_body"));
        for (ClassDeclaration c : this.classes) {
        	c.tamAddress = f.getSize();
            f.append(c.getCode(factory));
        }
        f.append(this.main.getCode(factory));
        f.add(factory.createHalt());
        try {
            PrintWriter writer = new PrintWriter(output_path);
            writer.println(f);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Code generation finished");
    }

    @Override
    public void exitProgramme(ProgrammeContext ctx) {
        this.main = ctx.laPrincipale.unPrincipal;
        this.classes = ctx.lesClasses.desClasses;
    }

    @Override
    public void exitClasses(ClassesContext ctx) {
        List<ClassDeclaration> lesClasses = new LinkedList<ClassDeclaration>();
        for (ClasseContext uneClasse : ctx.lesClasses) {
            lesClasses.add(uneClasse.uneClasse);
        }
        ctx.desClasses = lesClasses;

    }

    @Override
    public void exitClasse(ClasseContext ctx) {
        boolean estConcrete = (ctx.estAbstraite == null);
        if (ctx.heriteDe != null) {
            ctx.uneClasse = new ClassDeclaration(estConcrete, ctx.leNom.getText(), ctx.heriteDe.getText(),
                    ctx.lesElements.desElements);
        } else {
            ctx.uneClasse = new ClassDeclaration(estConcrete, ctx.leNom.getText(), ctx.lesElements.desElements);
        }
    }

    @Override
    public void exitPrincipale(PrincipaleContext ctx) {
        List<Declaration> lesDeclarations = new LinkedList<Declaration>();
        for (DeclarationContext uneDeclaration : ctx.lesDeclarations) {
            lesDeclarations.add(uneDeclaration.uneDeclaration);
        }
        ctx.unPrincipal = new MainDeclaration(ctx.leNom.getText(), lesDeclarations, ctx.leCorps.unBloc);
    }

    @Override
    public void exitMethodeMain(MethodeMainContext ctx) {
        String leNom = ctx.laSignature.leNom.getText();
        Type leType = ctx.laSignature.leRetour.unType;
        List<ParameterDeclaration> lesParametres = ctx.laSignature.lesParametres.desParametres;
        Block leCorps = ctx.leCorps.unBloc;
        ctx.uneDeclaration = new MethodDeclaration(leNom, leType, lesParametres, leCorps);
    }

    @Override
    public void exitAttributMain(AttributMainContext ctx) {
        String leNom = ctx.leNom.getText();
        Type leType = ctx.leType.unType;
        AccessibleExpression laValeur = ctx.laValeur.uneExpression;
        if (ctx.estFinal != null) {
            ctx.uneDeclaration = new ConstantDeclaration(leNom, leType, laValeur);
        } else {
            ctx.uneDeclaration = new VariableDeclaration(leNom, leType, laValeur);
        }
    }

    @Override
    public void exitSignature(SignatureContext ctx) {
        // TODO Auto-generated method stub
        super.exitSignature(ctx);
    }

    @Override
    public void exitElements(ElementsContext ctx) {
        List<ClassElement> lesElements = new LinkedList<ClassElement>();
        for (ElementContext unElement : ctx.lesElements) {
            lesElements.add(unElement.unElement);
        }
        ctx.desElements = lesElements;
    }

    @Override
    public void exitElement(ElementContext ctx) {
        ClassElement unElement = null;
        if (ctx.attribut() != null) {
            unElement = ctx.attribut().unAttribut;
        } else {
            if (ctx.methode() != null) {
                unElement = ctx.methode().uneMethode;
            } else {
                if (ctx.constructeur() != null) {
                    unElement = ctx.constructeur().unConstructeur;
                } else {
                    throw new RuntimeException("Missing Element.");
                }
            }
        }
        unElement.setAccessRight(ctx.leDroit.unDroit);
        ctx.unElement = unElement;
    }

    @Override
    public void exitAccessRight(AccessRightContext ctx) {
        if (ctx.Public() != null) {
            ctx.unDroit = AccessRight.PUBLIC;
        } else {
            if (ctx.Protege() != null) {
                ctx.unDroit = AccessRight.PROTECTED;
            } else {
                if (ctx.Prive() != null) {
                    ctx.unDroit = AccessRight.PRIVATE;
                } else {
                    ctx.unDroit = AccessRight.PACKAGE;
                }
            }
        }
    }

    @Override
    public void exitAttributObjet(AttributObjetContext ctx) {
        ctx.unAttribut = new AttributeDeclaration(ctx.leNom.getText(), ctx.leType.unType, false, null);
    }

    @Override
    public void exitAttributClasse(AttributClasseContext ctx) {
        boolean isFinal = ctx.estFinal != null;
        Expression value = ctx.laValeur.uneExpression;
        ctx.unAttribut = new AttributeDeclaration(ctx.leNom.getText(), ctx.leType.unType, isFinal, value);
        ctx.unAttribut.setElementKind(ElementKind.CLASS);
    }

    @Override
    public void exitMethodeObjet(MethodeObjetContext ctx) {
        String leNom = ctx.laSignature.leNom.getText();
        Type leType = ctx.laSignature.leRetour.unType;
        ParametresContext ctxParam = ctx.laSignature.lesParametres;
        List<ParameterDeclaration> lesParametres = ctxParam == null ? List.of() : ctxParam.desParametres;
        Block leCorps = ctx.leCorps.unBloc;
        ctx.uneMethode = new MethodDeclaration(leNom, leType, lesParametres, leCorps);
    }

    @Override
    public void exitMethodeClasse(MethodeClasseContext ctx) {
        String leNom = ctx.laSignature.leNom.getText();
        Type leType = ctx.laSignature.leRetour.unType;
        List<ParameterDeclaration> lesParametres = ctx.laSignature.lesParametres.desParametres;
        Block leCorps = ctx.leCorps.unBloc;
        ctx.uneMethode = new MethodDeclaration(leNom, leType, lesParametres, leCorps);
        ctx.uneMethode.setElementKind(ElementKind.CLASS);
    }

    @Override
    public void exitMethodeAbstraite(MethodeAbstraiteContext ctx) {
        String leNom = ctx.laSignature.leNom.getText();
        Type leType = ctx.laSignature.leRetour.unType;
        List<ParameterDeclaration> lesParametres = ctx.laSignature.lesParametres.desParametres;
        ctx.uneMethode = new MethodDeclaration(leNom, leType, lesParametres);
    }

    @Override
    public void exitConstructeur(ConstructeurContext ctx) {
        ctx.unConstructeur = new ConstructorDeclaration(ctx.leNom.getText(), ctx.lesParametres.desParametres,
                ctx.leCorps.unBloc);
    }

    @Override
    public void exitBloc(MiniJavaParser.BlocContext ctx) {
        List<Instruction> instructionList = new LinkedList<Instruction>();
        for (MiniJavaParser.InstructionContext iCtx : ctx.lesInstructions) {
            instructionList.add(iCtx.uneInstruction);
        }
        ctx.unBloc = new Block(instructionList);
    }

    @Override
    public void exitParametres(MiniJavaParser.ParametresContext ctx) {
        List<ParameterDeclaration> lesParametres = new LinkedList<ParameterDeclaration>();
        for (ParametreContext parametre : ctx.lesParametres) {
            lesParametres.add(parametre.unParametre);
        }
        ctx.desParametres = lesParametres;
    }

    @Override
    public void exitParametre(ParametreContext ctx) {
        ctx.unParametre = new ParameterDeclaration(ctx.leNom.getText(), ctx.leType.unType);
    }

    @Override
    public void exitInstructionDeclaration(MiniJavaParser.InstructionDeclarationContext ctx) {
        String name = ctx.leNom.getText();
        Type type = ctx.leType.unType;
        AccessibleExpression valeur = ctx.laValeur.uneExpression;
        ctx.uneInstruction = new VariableDeclaration(name, type, valeur);
    }

    @Override
    public void exitInstructionAffectation(MiniJavaParser.InstructionAffectationContext ctx) {
        ctx.uneInstruction = new Assignment(ctx.leRecepteur.uneExpressionAffectable, ctx.laValeur.uneExpression);
    }

    @Override
    public void exitInstructionAffichage(MiniJavaParser.InstructionAffichageContext ctx) {
        ctx.uneInstruction = new Printer(ctx.laValeur.uneExpression);
    }

    @Override
    public void exitInstructionSi(InstructionSiContext ctx) {
        ctx.uneInstruction = new Conditional(ctx.cond.uneExpression, ctx.alors.unBloc);
    }

    @Override
    public void exitInstructionSiSinon(MiniJavaParser.InstructionSiSinonContext ctx) {
        ctx.uneInstruction = new Conditional(ctx.cond.uneExpression, ctx.alors.unBloc,
                ctx.sinon.unBloc);
    }

    @Override
    public void exitInstructionIteration(InstructionIterationContext ctx) {
        ctx.uneInstruction = new Iteration(ctx.cond.uneExpression, ctx.leCorps.unBloc);
    }

    @Override
    public void exitInstructionReturn(MiniJavaParser.InstructionReturnContext ctx) {
        ctx.uneInstruction = new Return(ctx.laValeur.uneExpression);
    }

    @Override
    public void exitInstructionAppelMethodeExplicite(InstructionAppelMethodeExpliciteContext ctx) {
        ctx.uneInstruction = new MethodCall(ctx.lObjet.uneExpression, ctx.leNom.getText(),
                ctx.args.desArguments);
    }

    @Override
    public void exitInstructionAppelMethodeImplicite(InstructionAppelMethodeImpliciteContext ctx) {
        ctx.uneInstruction = new MethodCall(ctx.leNom.getText(), ctx.args.desArguments);
    }

    @Override
    public void exitInstructionAppelConstructeurAlternatif(InstructionAppelConstructeurAlternatifContext ctx) {
        ctx.uneInstruction = new ThisCall(ctx.args.desArguments);
    }

    @Override
    public void exitInstructionAppelConstructeurParent(InstructionAppelConstructeurParentContext ctx) {
        ctx.uneInstruction = new SuperCall(ctx.args.desArguments);
    }

    @Override
    public void exitEcritureThis(EcritureThisContext ctx) {
        ctx.uneExpressionAffectable = new ThisAssignment();
    }

    @Override
    public void exitEcritureSuper(EcritureSuperContext ctx) {
        ctx.uneExpressionAffectable = new SuperAssignment();
    }

    @Override
    public void exitLectureThis(LectureThisContext ctx) {
        ctx.uneExpression = new ThisAccess();
    }

    @Override
    public void exitLectureSuper(LectureSuperContext ctx) {
        ctx.uneExpression = new SuperAccess();
    }

    @Override
    public void exitAtomique(MiniJavaParser.AtomiqueContext ctx) {
        if (ctx.TypeEntier() != null) {
            ctx.unTypeAtomique = AtomicType.IntegerType;
        } else if (ctx.TypeFlottant() != null) {
            ctx.unTypeAtomique = AtomicType.FloatingType;
        } else if (ctx.TypeBooleen() != null) {
            ctx.unTypeAtomique = AtomicType.BooleanType;
        } else if (ctx.TypeCaractere() != null) {
            ctx.unTypeAtomique = AtomicType.CharacterType;
        } else if (ctx.TypeChaine() != null) {
            ctx.unTypeAtomique = AtomicType.StringType;
        } else if (ctx.TypeVide() != null) {
            ctx.unTypeAtomique = AtomicType.VoidType;
        }
    }

    @Override
    public void exitTypeAtomique(MiniJavaParser.TypeAtomiqueContext ctx) {
        ctx.unType = ctx.atomique().unTypeAtomique;
    }

    @Override
    public void exitTypeTableau(TypeTableauContext ctx) {
        ctx.unType = new ArrayType(ctx.leTypeValeur.unType);
    }

    @Override
    public void exitTypeClasse(MiniJavaParser.TypeClasseContext ctx) {
        ctx.unType = new ClassType(ctx.leNom.getText());
    }

    @Override
    public void exitEcritureIdent(EcritureIdentContext ctx) {
        ctx.uneExpressionAffectable = new VariableAssignment(ctx.lIdent.getText());
    }

    @Override
    public void exitEcritureConversion(EcritureConversionContext ctx) {
        ctx.uneExpressionAffectable = new AssignableConversion(ctx.lAffectable.uneExpressionAffectable,
                ctx.leType.unType);
    }

    @Override
    public void exitEcritureAttribut(EcritureAttributContext ctx) {
        ctx.uneExpressionAffectable = new AttributeAssignment(ctx.lObjet.uneExpressionAffectable, ctx.leNom.getText());
    }

    @Override
    public void exitEcritureTableau(EcritureTableauContext ctx) {
        ctx.uneExpressionAffectable = new ArrayAssignment(ctx.leTableau.uneExpressionAffectable,
                ctx.lIndice.uneExpression);
    }

    @Override
    public void exitEcritureAppelMethodeExplicite(EcritureAppelMethodeExpliciteContext ctx) {
        ctx.uneExpressionAffectable = new MethodCallAssignment(ctx.lObjet.uneExpressionAffectable, ctx.leNom.getText(),
                ctx.args.desArguments);
    }

    @Override
    public void exitEcritureAppelMethodeImplicite(EcritureAppelMethodeImpliciteContext ctx) {
        ctx.uneExpressionAffectable = new MethodCallAssignment(ctx.leNom.getText(), ctx.args.desArguments);
    }

    @Override
    public void exitExpressions(MiniJavaParser.ExpressionsContext ctx) {
        List<AccessibleExpression> expressions = new LinkedList<AccessibleExpression>();
        for (MiniJavaParser.ExpressionContext expressionCtx : ctx.lesExpressions) {
            expressions.add(expressionCtx.uneExpression);
        }
        ctx.desExpressions = expressions;
    }

    @Override
    public void exitArguments(MiniJavaParser.ArgumentsContext ctx) {
        List<AccessibleExpression> expressions = new LinkedList<AccessibleExpression>();
        if (ctx.lesExpressions != null) {
            for (MiniJavaParser.ExpressionContext expressionCtx : ctx.lesExpressions.lesExpressions) {
                expressions.add(expressionCtx.uneExpression);
            }
        }
        ctx.desArguments = expressions;
    }

    @Override
    public void exitLectureIdent(LectureIdentContext ctx) {
        ctx.uneExpression = new IdentifierAccess(ctx.leNom.getText());
    }

    @Override
    public void exitExprAdd(MiniJavaParser.ExprAddContext ctx) {
        BinaryOperator op;
        switch (ctx.op.getText()) {
            case "+":
                op = BinaryOperator.Add;
                break;
            case "-":
                op = BinaryOperator.Substract;
                break;
            default:
                throw new RuntimeException("Unknown operator");
        }
        ctx.uneExpression = new BinaryExpression(ctx.gauche.uneExpression, op, ctx.droite.uneExpression);
    }

    @Override
    public void exitExprMult(MiniJavaParser.ExprMultContext ctx) {
        BinaryOperator op;
        switch (ctx.op.getText()) {
            case "*":
                op = BinaryOperator.Multiply;
                break;
            case "/":
                op = BinaryOperator.Divide;
                break;
            case "%":
                op = BinaryOperator.Modulo;
                break;
            default:
                throw new RuntimeException("Unkonwn operator");
        }
        ctx.uneExpression = new BinaryExpression(ctx.gauche.uneExpression, op, ctx.droite.uneExpression);
    }

    @Override
    public void exitExpressionConjonction(MiniJavaParser.ExpressionConjonctionContext ctx) {
        ctx.uneExpression = new BinaryExpression(ctx.gauche.uneExpression, BinaryOperator.And,
                ctx.droite.uneExpression);
    }

    @Override
    public void exitExpressionDisjonction(MiniJavaParser.ExpressionDisjonctionContext ctx) {
        ctx.uneExpression = new BinaryExpression(ctx.gauche.uneExpression, BinaryOperator.Or, ctx.droite.uneExpression);
    }

    @Override
    public void exitExprCond(ExprCondContext ctx) {
        ctx.uneExpression = new AccessibleConditional(ctx.cond.uneExpression, ctx.exprAlors.uneExpression,
                ctx.exprSinon.uneExpression);
    }

    @Override
    public void exitExpressionNegation(MiniJavaParser.ExpressionNegationContext ctx) {
        ctx.uneExpression = new UnaryExpression(UnaryOperator.Negate, ctx.leParametre.uneExpression);
    }

    @Override
    public void exitExpressionFalse(MiniJavaParser.ExpressionFalseContext ctx) {
        ctx.uneExpression = BooleanValue.False;
    }

    @Override
    public void exitExpressionTrue(MiniJavaParser.ExpressionTrueContext ctx) {
        ctx.uneExpression = BooleanValue.True;
    }

    @Override
    public void exitExpressionInt(MiniJavaParser.ExpressionIntContext ctx) {
        ctx.uneExpression = new IntegerValue(ctx.Entier().getText());
    }

    @Override
    public void exitExpresionFloat(MiniJavaParser.ExpresionFloatContext ctx) {
        ctx.uneExpression = new FloatingValue(ctx.Flottant().getText());
    }

    @Override
    public void exitExpressionCharacter(MiniJavaParser.ExpressionCharacterContext ctx) {
        ctx.uneExpression = new CharacterValue(ctx.Caractere().getText());
    }

    @Override
    public void exitExpressionString(MiniJavaParser.ExpressionStringContext ctx) {
        ctx.uneExpression = new StringValue(ctx.Chaine().getText());
    }

    @Override
    public void exitExpressionNull(MiniJavaParser.ExpressionNullContext ctx) {
        ctx.uneExpression = NullValue.Null;
    }

    @Override
    public void exitExpressionEgalite(MiniJavaParser.ExpressionEgaliteContext ctx) {
        BinaryOperator op;
        switch (ctx.op.getText()) {
            case "==":
                op = BinaryOperator.Equals;
                break;
            case "!=":
                op = BinaryOperator.Different;
                break;
            default:
                throw new RuntimeException("Unkonwn operator");
        }
        ctx.uneExpression = new BinaryExpression(ctx.gauche.uneExpression, op, ctx.droite.uneExpression);
    }

    @Override
    public void exitExprCompar(MiniJavaParser.ExprComparContext ctx) {
        BinaryOperator op;
        switch (ctx.op.getText()) {
            case "<":
                op = BinaryOperator.Lesser;
                break;
            case "<=":
                op = BinaryOperator.LesserOrEqual;
                break;
            case ">":
                op = BinaryOperator.Greater;
                break;
            case ">=":
                op = BinaryOperator.GreaterOrEqual;
                break;
            default:
                throw new RuntimeException("Unkonwn operator");
        }
        ctx.uneExpression = new BinaryExpression(ctx.gauche.uneExpression, op, ctx.droite.uneExpression);
    }

    @Override
    public void exitExpressionParenthese(MiniJavaParser.ExpressionParentheseContext ctx) {
        ctx.uneExpression = ctx.expression().uneExpression;
    }

    @Override
    public void exitExpressionOpposee(ExpressionOpposeeContext ctx) {
        ctx.uneExpression = new UnaryExpression(UnaryOperator.Opposite, ctx.leParametre.uneExpression);
    }

    @Override
    public void exitExpressionConversion(MiniJavaParser.ExpressionConversionContext ctx) {
        ctx.uneExpression = new AccessibleConversion(ctx.uneExpression, ctx.leType.unType);
    }

    @Override
    public void exitLectureTableau(LectureTableauContext ctx) {
        ctx.uneExpression = new ArrayAccess(ctx.leTableau.uneExpression, ctx.lIndice.uneExpression);
    }

    @Override
    public void exitLectureAttribut(LectureAttributContext ctx) {
        ctx.uneExpression = new AttributeAccess(ctx.lObjet.uneExpression, ctx.leNom.getText());
    }

    @Override
    public void exitLectureAppelMethodeExplicite(MiniJavaParser.LectureAppelMethodeExpliciteContext ctx) {
        ctx.uneExpression = new MethodCallAccess(ctx.lobjet.uneExpression, ctx.leNom.getText(),
                ctx.args.desArguments);
    }

    @Override
    public void exitLectureAppelMethodeImplicite(MiniJavaParser.LectureAppelMethodeImpliciteContext ctx) {
        ctx.uneExpression = new MethodCallAccess(ctx.leNom.getText(), ctx.args.desArguments);
    }

    @Override
    public void exitCreationTableau(MiniJavaParser.CreationTableauContext ctx) {
        ctx.uneExpression = new ArrayAllocation(ctx.leType.unType, ctx.laTaille.uneExpression);
    }

    @Override
    public void exitCreationObjet(MiniJavaParser.CreationObjetContext ctx) {
        ctx.uneExpression = new ObjectAllocation(ctx.leNom.getText(), ctx.args.desArguments);
    }

}
