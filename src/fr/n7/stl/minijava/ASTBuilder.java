package fr.n7.stl.minijava;

import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleConditional;
import fr.n7.stl.minijava.ast.expression.BinaryExpression;
import fr.n7.stl.minijava.ast.expression.BinaryOperator;
import fr.n7.stl.minijava.ast.expression.ConditionalExpression;
import fr.n7.stl.minijava.ast.expression.UnaryExpression;
import fr.n7.stl.minijava.ast.expression.UnaryOperator;
import fr.n7.stl.minijava.ast.expression.value.BooleanValue;
import fr.n7.stl.minijava.ast.expression.value.CharacterValue;
import fr.n7.stl.minijava.ast.expression.value.IntegerValue;
import fr.n7.stl.minijava.ast.expression.value.NullValue;
import fr.n7.stl.minijava.ast.expression.value.StringValue;
import fr.n7.stl.minijava.ast.instruction.declaration.clazz.ClassDeclaration;
import fr.n7.stl.minijava.ast.instruction.declaration.clazz.Definition;
import fr.n7.stl.minijava.ast.instruction.declaration.clazz.Modifier;
import fr.n7.stl.minijava.ast.scope.SymbolTable;
import fr.n7.stl.minijava.parser.MiniJavaParser;
import fr.n7.stl.minijava.parser.MiniJavaParser.ClasseContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.DefinitionContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprAccessContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprAddContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprAndContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprCharacterContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprCondContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprFalseContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprFloatContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprIntContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprMultContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprNotContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprNullContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprOpositeContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprOrContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprStringContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ExprTrueContext;
import fr.n7.stl.minijava.parser.MiniJavaParser.ProgrammeContext;
import fr.n7.stl.minijava.parser.MiniJavaParserBaseListener;

public class ASTBuilder extends MiniJavaParserBaseListener {

    private String output_path;
    private List<ClassDeclaration> classes;
    private String name;

    public ASTBuilder(String output) {
        this.output_path = output;
    }

    public void startCompilation(boolean generateCode) {
        System.out.println("Classes: " + this.classes);
        SymbolTable tds = new SymbolTable();

        // if (!this.mainBlock.collectAndPartialResolve(tds)) {
        // System.out.println("Collect failed : " + tds);
        // return;
        // }
        // System.out.println("Collect succeeded.");

        // if (!this.mainBlock.completeResolve(tds)) {
        // System.out.println("Resolve failed : " + tds);
        // return;
        // }
        // System.out.println("Resolve Succeeded.");

        // if (!this.mainBlock.checkType()) {
        // System.out.println("Type verification failed.");
        // return;
        // }
        // System.out.println("Type verification succeeded.");

        // if (!generateCode) {
        // System.out.println("Skipping code generation.");
        // return;
        // }

        // System.out.println("Code generation ...");
        // this.mainBlock.allocateMemory(Register.SB, 0);
        // try {
        // PrintWriter writer = new PrintWriter(output_path);
        // TAMFactory factory = new TAMFactoryImpl();
        // Fragment f = this.mainBlock.getCode(factory);
        // f.add(factory.createHalt());
        // f.append(this.mainBlock.getFunctions(factory));
        // writer.println(f);
        // writer.close();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // System.out.println("Code generation finished.");
    }

    @Override
    public void exitProgramme(ProgrammeContext ctx) {
        ctx.classes = new LinkedList<>();
        for (ClasseContext c : ctx.classe()) {
            ctx.classes.add(c.c);
        }
    }

    @Override
    public void exitClasse(ClasseContext ctx) {
        String name = ctx.name.getText();
        String parent = ctx.parent != null ? ctx.parent.getText() : null;
        Modifier mod = null;
        if (ctx.mod != null) {
            mod = ctx.mod.getType() == MiniJavaParser.Publique ? Modifier.Public
                    : Modifier.Abstract;
        }
        List<Definition> defs = new LinkedList<>();
        for (DefinitionContext def : ctx.defs) {
            defs.add(def.def);
        }
        ctx.c = new ClassDeclaration(name, parent, mod, defs);
    }

    @Override
    public void exitExprAdd(ExprAddContext ctx) {
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
        ctx.e = new BinaryExpression(ctx.gauche.e, op, ctx.droite.e);
    }

    @Override
    public void exitExprMult(ExprMultContext ctx) {
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
        ctx.e = new BinaryExpression(ctx.gauche.e, op, ctx.droite.e);
    }

    @Override
    public void exitExprAnd(ExprAndContext ctx) {
        ctx.e = new BinaryExpression(ctx.gauche.e, BinaryOperator.And, ctx.droite.e);
    }

    @Override
    public void exitExprOr(ExprOrContext ctx) {
        ctx.e = new BinaryExpression(ctx.gauche.e, BinaryOperator.Or, ctx.droite.e);
    }

    @Override
    public void exitExprCond(ExprCondContext ctx) {
        ctx.e = new ConditionalExpression(ctx.cond.e, ctx.alors.e, ctx.sinon.e);
    }

    @Override
    public void exitExprNot(ExprNotContext ctx) {
        ctx.e = new UnaryExpression(UnaryOperator.Negate, ctx.droite.e);
    }

    @Override
    public void exitExprOposite(ExprOpositeContext ctx) {
        ctx.e = new UnaryExpression(UnaryOperator.Opposite, ctx.droite.e);
    }

    @Override
    public void exitExprTrue(ExprTrueContext ctx) {
        ctx.e = BooleanValue.True;
    }

    @Override
    public void exitExprFalse(ExprFalseContext ctx) {
        ctx.e = BooleanValue.False;
    }

    @Override
    public void exitExprInt(ExprIntContext ctx) {
        ctx.e = new IntegerValue(ctx.Entier().getText());
    }

    @Override
    public void exitExprFloat(ExprFloatContext ctx) {
        ctx.e = new IntegerValue(ctx.Flottant().getText());
    }

    @Override
    public void exitExprCharacter(ExprCharacterContext ctx) {
        ctx.e = new CharacterValue(ctx.Caractere().getText());
    }

    @Override
    public void exitExprString(ExprStringContext ctx) {
        ctx.e = new StringValue(ctx.Chaine().getText());
    }

    @Override
    public void exitExprNull(ExprNullContext ctx) {
        ctx.e = NullValue.Null;
    }

    @Override
    public void exitExprAccess(ExprAccessContext ctx) {
        // TODO
    }

}
