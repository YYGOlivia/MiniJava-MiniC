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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Egal=1, AccoladeOuvrante=2, AccoladeFermante=3, ParOuv=4, ParFer=5, CrochOuv=6, 
		CrochFer=7, Point=8, PtInterro=9, DeuxPoint=10, Virg=11, PtVirg=12, Afficher=13, 
		Si=14, Sinon=15, TantQue=16, Pour=17, Retour=18, Final=19, DefClasse=20, 
		Nouveau=21, Ceci=22, Asterisque=23, Oblique=24, PourCent=25, Plus=26, 
		Moins=27, Ou=28, Et=29, PointExclamation=30, Inf=31, Sup=32, InfEg=33, 
		SupEg=34, DoubleEgal=35, Different=36, TypeEntier=37, TypeFlottant=38, 
		TypeBooleen=39, TypeCaractere=40, TypeChaine=41, TypeVide=42, Vrai=43, 
		Faux=44, Nul=45, Caractere=46, Chaine=47, Publique=48, Abstrait=49, Prive=50, 
		Statique=51, Protege=52, Etend=53, Identificateur=54, Entier=55, Flottant=56, 
		CommentaireLigne=57, CommentaireBloc=58, WS=59;
	public static final int
		RULE_programme = 0, RULE_classe = 1, RULE_definition = 2, RULE_constructeur = 3, 
		RULE_methode = 4, RULE_attribut = 5, RULE_entete = 6, RULE_corps = 7, 
		RULE_parametres = 8, RULE_instr = 9, RULE_expr = 10, RULE_declLocale = 11, 
		RULE_assignation = 12, RULE_assignable = 13, RULE_expressions = 14, RULE_type = 15, 
		RULE_atomique = 16, RULE_expressionConstante = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"programme", "classe", "definition", "constructeur", "methode", "attribut", 
			"entete", "corps", "parametres", "instr", "expr", "declLocale", "assignation", 
			"assignable", "expressions", "type", "atomique", "expressionConstante"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'{'", "'}'", "'('", "')'", "'['", "']'", "'.'", "'?'", 
			"':'", "','", "';'", "'print'", "'if'", "'else'", "'while'", "'for'", 
			"'return'", "'final'", "'class'", "'new'", "'this'", "'*'", "'/'", "'%'", 
			"'+'", "'-'", "'||'", "'&&'", "'!'", "'<'", "'>'", "'<='", "'>='", "'=='", 
			"'!='", "'int'", "'float'", "'boolean'", "'char'", "'String'", "'void'", 
			"'true'", "'false'", "'null'", null, null, "'public'", "'abstract'", 
			"'private'", "'static'", "'protected'", "'extends'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Egal", "AccoladeOuvrante", "AccoladeFermante", "ParOuv", "ParFer", 
			"CrochOuv", "CrochFer", "Point", "PtInterro", "DeuxPoint", "Virg", "PtVirg", 
			"Afficher", "Si", "Sinon", "TantQue", "Pour", "Retour", "Final", "DefClasse", 
			"Nouveau", "Ceci", "Asterisque", "Oblique", "PourCent", "Plus", "Moins", 
			"Ou", "Et", "PointExclamation", "Inf", "Sup", "InfEg", "SupEg", "DoubleEgal", 
			"Different", "TypeEntier", "TypeFlottant", "TypeBooleen", "TypeCaractere", 
			"TypeChaine", "TypeVide", "Vrai", "Faux", "Nul", "Caractere", "Chaine", 
			"Publique", "Abstrait", "Prive", "Statique", "Protege", "Etend", "Identificateur", 
			"Entier", "Flottant", "CommentaireLigne", "CommentaireBloc", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniJavaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgrammeContext extends ParserRuleContext {
		public List<ClassDeclaration> classes;
		public List<ClasseContext> classe() {
			return getRuleContexts(ClasseContext.class);
		}
		public ClasseContext classe(int i) {
			return getRuleContext(ClasseContext.class,i);
		}
		public ProgrammeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programme; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterProgramme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitProgramme(this);
		}
	}

	public final ProgrammeContext programme() throws RecognitionException {
		ProgrammeContext _localctx = new ProgrammeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 844424931180544L) != 0)) {
				{
				{
				setState(36);
				classe();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClasseContext extends ParserRuleContext {
		public ClassDeclaration c;
		public Token mod;
		public Token name;
		public Token parent;
		public DefinitionContext definition;
		public List<DefinitionContext> defs = new ArrayList<DefinitionContext>();
		public TerminalNode DefClasse() { return getToken(MiniJavaParser.DefClasse, 0); }
		public TerminalNode AccoladeOuvrante() { return getToken(MiniJavaParser.AccoladeOuvrante, 0); }
		public TerminalNode AccoladeFermante() { return getToken(MiniJavaParser.AccoladeFermante, 0); }
		public List<TerminalNode> Identificateur() { return getTokens(MiniJavaParser.Identificateur); }
		public TerminalNode Identificateur(int i) {
			return getToken(MiniJavaParser.Identificateur, i);
		}
		public TerminalNode Etend() { return getToken(MiniJavaParser.Etend, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public TerminalNode Publique() { return getToken(MiniJavaParser.Publique, 0); }
		public TerminalNode Abstrait() { return getToken(MiniJavaParser.Abstrait, 0); }
		public ClasseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterClasse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitClasse(this);
		}
	}

	public final ClasseContext classe() throws RecognitionException {
		ClasseContext _localctx = new ClasseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Publique || _la==Abstrait) {
				{
				setState(42);
				((ClasseContext)_localctx).mod = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Publique || _la==Abstrait) ) {
					((ClasseContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(45);
			match(DefClasse);
			setState(46);
			((ClasseContext)_localctx).name = match(Identificateur);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Etend) {
				{
				setState(47);
				match(Etend);
				setState(48);
				((ClasseContext)_localctx).parent = match(Identificateur);
				}
			}

			setState(51);
			match(AccoladeOuvrante);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5910974510923776L) != 0)) {
				{
				{
				setState(52);
				((ClasseContext)_localctx).definition = definition();
				((ClasseContext)_localctx).defs.add(((ClasseContext)_localctx).definition);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(AccoladeFermante);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public Definition def;
		public TerminalNode Publique() { return getToken(MiniJavaParser.Publique, 0); }
		public TerminalNode Protege() { return getToken(MiniJavaParser.Protege, 0); }
		public TerminalNode Prive() { return getToken(MiniJavaParser.Prive, 0); }
		public ConstructeurContext constructeur() {
			return getRuleContext(ConstructeurContext.class,0);
		}
		public MethodeContext methode() {
			return getRuleContext(MethodeContext.class,0);
		}
		public AttributContext attribut() {
			return getRuleContext(AttributContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitDefinition(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 5910974510923776L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(61);
				constructeur();
				}
				break;
			case 2:
				{
				setState(62);
				methode();
				}
				break;
			case 3:
				{
				setState(63);
				attribut();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructeurContext extends ParserRuleContext {
		public ConstructorDeclaration c;
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public ParametresContext parametres() {
			return getRuleContext(ParametresContext.class,0);
		}
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public CorpsContext corps() {
			return getRuleContext(CorpsContext.class,0);
		}
		public ConstructeurContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructeur; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterConstructeur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitConstructeur(this);
		}
	}

	public final ConstructeurContext constructeur() throws RecognitionException {
		ConstructeurContext _localctx = new ConstructeurContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constructeur);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(Identificateur);
			setState(67);
			match(ParOuv);
			setState(68);
			parametres();
			setState(69);
			match(ParFer);
			setState(70);
			corps();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodeContext extends ParserRuleContext {
		public MethodDeclaration m;
		public EnteteContext entete() {
			return getRuleContext(EnteteContext.class,0);
		}
		public CorpsContext corps() {
			return getRuleContext(CorpsContext.class,0);
		}
		public TerminalNode Statique() { return getToken(MiniJavaParser.Statique, 0); }
		public TerminalNode Abstrait() { return getToken(MiniJavaParser.Abstrait, 0); }
		public TerminalNode PtVirg() { return getToken(MiniJavaParser.PtVirg, 0); }
		public MethodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterMethode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitMethode(this);
		}
	}

	public final MethodeContext methode() throws RecognitionException {
		MethodeContext _localctx = new MethodeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methode);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
			case Statique:
			case Identificateur:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Statique) {
					{
					setState(72);
					match(Statique);
					}
				}

				setState(75);
				entete();
				setState(76);
				corps();
				}
				break;
			case Abstrait:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(Abstrait);
				setState(79);
				entete();
				setState(80);
				match(PtVirg);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributContext extends ParserRuleContext {
		public AttributeDeclaration a;
		public Token isFinal;
		public TerminalNode Statique() { return getToken(MiniJavaParser.Statique, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode Egal() { return getToken(MiniJavaParser.Egal, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PtVirg() { return getToken(MiniJavaParser.PtVirg, 0); }
		public TerminalNode Final() { return getToken(MiniJavaParser.Final, 0); }
		public AttributContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterAttribut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitAttribut(this);
		}
	}

	public final AttributContext attribut() throws RecognitionException {
		AttributContext _localctx = new AttributContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attribut);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Statique:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(Statique);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Final) {
					{
					setState(85);
					((AttributContext)_localctx).isFinal = match(Final);
					}
				}

				setState(88);
				type(0);
				setState(89);
				match(Identificateur);
				setState(90);
				match(Egal);
				setState(91);
				expr(0);
				setState(92);
				match(PtVirg);
				}
				break;
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
			case Identificateur:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				type(0);
				setState(95);
				match(Identificateur);
				setState(96);
				match(PtVirg);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnteteContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public ParametresContext parametres() {
			return getRuleContext(ParametresContext.class,0);
		}
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public EnteteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterEntete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitEntete(this);
		}
	}

	public final EnteteContext entete() throws RecognitionException {
		EnteteContext _localctx = new EnteteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_entete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			type(0);
			setState(101);
			match(Identificateur);
			setState(102);
			match(ParOuv);
			setState(103);
			parametres();
			setState(104);
			match(ParFer);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CorpsContext extends ParserRuleContext {
		public TerminalNode AccoladeOuvrante() { return getToken(MiniJavaParser.AccoladeOuvrante, 0); }
		public TerminalNode AccoladeFermante() { return getToken(MiniJavaParser.AccoladeFermante, 0); }
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public CorpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterCorps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitCorps(this);
		}
	}

	public final CorpsContext corps() throws RecognitionException {
		CorpsContext _localctx = new CorpsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_corps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(AccoladeOuvrante);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18023057164550144L) != 0)) {
				{
				{
				setState(107);
				instr();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(AccoladeFermante);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametresContext extends ParserRuleContext {
		public List<ParameterDeclaration> l;
		public TypeContext type1;
		public Token ident;
		public TypeContext type;
		public List<TypeContext> suiteType = new ArrayList<TypeContext>();
		public Token suiteIdent;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identificateur() { return getTokens(MiniJavaParser.Identificateur); }
		public TerminalNode Identificateur(int i) {
			return getToken(MiniJavaParser.Identificateur, i);
		}
		public List<TerminalNode> Virg() { return getTokens(MiniJavaParser.Virg); }
		public TerminalNode Virg(int i) {
			return getToken(MiniJavaParser.Virg, i);
		}
		public ParametresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametres; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterParametres(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitParametres(this);
		}
	}

	public final ParametresContext parametres() throws RecognitionException {
		ParametresContext _localctx = new ParametresContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parametres);
		int _la;
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ParFer:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
			case Identificateur:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				((ParametresContext)_localctx).type1 = type(0);
				setState(117);
				((ParametresContext)_localctx).ident = match(Identificateur);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Virg) {
					{
					{
					setState(118);
					match(Virg);
					setState(119);
					((ParametresContext)_localctx).type = type(0);
					((ParametresContext)_localctx).suiteType.add(((ParametresContext)_localctx).type);
					setState(120);
					((ParametresContext)_localctx).suiteIdent = match(Identificateur);
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstrContext extends ParserRuleContext {
		public Instruction i;
		public CorpsContext alors;
		public CorpsContext sinon;
		public CorpsContext body;
		public TerminalNode Si() { return getToken(MiniJavaParser.Si, 0); }
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public List<CorpsContext> corps() {
			return getRuleContexts(CorpsContext.class);
		}
		public CorpsContext corps(int i) {
			return getRuleContext(CorpsContext.class,i);
		}
		public TerminalNode Sinon() { return getToken(MiniJavaParser.Sinon, 0); }
		public TerminalNode TantQue() { return getToken(MiniJavaParser.TantQue, 0); }
		public TerminalNode Pour() { return getToken(MiniJavaParser.Pour, 0); }
		public List<TerminalNode> PtVirg() { return getTokens(MiniJavaParser.PtVirg); }
		public TerminalNode PtVirg(int i) {
			return getToken(MiniJavaParser.PtVirg, i);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public DeclLocaleContext declLocale() {
			return getRuleContext(DeclLocaleContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode DeuxPoint() { return getToken(MiniJavaParser.DeuxPoint, 0); }
		public TerminalNode Retour() { return getToken(MiniJavaParser.Retour, 0); }
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitInstr(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instr);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(Si);
				setState(130);
				match(ParOuv);
				setState(131);
				expr(0);
				setState(132);
				match(ParFer);
				setState(133);
				((InstrContext)_localctx).alors = corps();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(Si);
				setState(136);
				match(ParOuv);
				setState(137);
				expr(0);
				setState(138);
				match(ParFer);
				setState(139);
				((InstrContext)_localctx).alors = corps();
				setState(140);
				match(Sinon);
				setState(141);
				((InstrContext)_localctx).sinon = corps();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				match(TantQue);
				setState(144);
				match(ParOuv);
				setState(145);
				expr(0);
				setState(146);
				match(ParFer);
				setState(147);
				((InstrContext)_localctx).body = corps();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(Pour);
				setState(150);
				match(ParOuv);
				setState(153);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(151);
					assignation();
					}
					break;
				case 2:
					{
					setState(152);
					declLocale();
					}
					break;
				}
				setState(155);
				match(PtVirg);
				setState(156);
				expr(0);
				setState(157);
				match(PtVirg);
				setState(158);
				assignation();
				setState(159);
				match(ParFer);
				setState(160);
				((InstrContext)_localctx).body = corps();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				match(Pour);
				setState(163);
				match(ParOuv);
				setState(164);
				type(0);
				setState(165);
				match(Identificateur);
				setState(166);
				match(DeuxPoint);
				setState(167);
				expr(0);
				setState(168);
				match(ParFer);
				setState(169);
				((InstrContext)_localctx).body = corps();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(171);
				match(Retour);
				setState(172);
				expr(0);
				setState(173);
				match(PtVirg);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(175);
				declLocale();
				setState(176);
				match(PtVirg);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(178);
				assignation();
				setState(179);
				match(PtVirg);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Expression e;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.e = ctx.e;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNotContext extends ExprContext {
		public ExprContext droite;
		public TerminalNode PointExclamation() { return getToken(MiniJavaParser.PointExclamation, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprNot(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprConstructorCallContext extends ExprContext {
		public TerminalNode Nouveau() { return getToken(MiniJavaParser.Nouveau, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExprConstructorCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprConstructorCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprConstructorCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprEqContext extends ExprContext {
		public ExprContext gauche;
		public Token op;
		public ExprContext droite;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DoubleEgal() { return getToken(MiniJavaParser.DoubleEgal, 0); }
		public TerminalNode Different() { return getToken(MiniJavaParser.Different, 0); }
		public ExprEqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprEq(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultContext extends ExprContext {
		public ExprContext gauche;
		public Token op;
		public ExprContext droite;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Asterisque() { return getToken(MiniJavaParser.Asterisque, 0); }
		public TerminalNode Oblique() { return getToken(MiniJavaParser.Oblique, 0); }
		public TerminalNode PourCent() { return getToken(MiniJavaParser.PourCent, 0); }
		public ExprMultContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprMult(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprConstanteContext extends ExprContext {
		public ExpressionConstanteContext expressionConstante() {
			return getRuleContext(ExpressionConstanteContext.class,0);
		}
		public ExprConstanteContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprConstante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprConstante(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIneqContext extends ExprContext {
		public ExprContext gauche;
		public Token op;
		public ExprContext droite;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Inf() { return getToken(MiniJavaParser.Inf, 0); }
		public TerminalNode Sup() { return getToken(MiniJavaParser.Sup, 0); }
		public TerminalNode InfEg() { return getToken(MiniJavaParser.InfEg, 0); }
		public TerminalNode SupEg() { return getToken(MiniJavaParser.SupEg, 0); }
		public ExprIneqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprIneq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprIneq(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParentheseeContext extends ExprContext {
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public ExprParentheseeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprParenthesee(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprParenthesee(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprArrayAccessContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CrochOuv() { return getToken(MiniJavaParser.CrochOuv, 0); }
		public TerminalNode CrochFer() { return getToken(MiniJavaParser.CrochFer, 0); }
		public ExprArrayAccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprArrayAccess(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCondContext extends ExprContext {
		public ExprContext cond;
		public ExprContext alors;
		public ExprContext sinon;
		public TerminalNode PtInterro() { return getToken(MiniJavaParser.PtInterro, 0); }
		public TerminalNode DeuxPoint() { return getToken(MiniJavaParser.DeuxPoint, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprCondContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprCond(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOrContext extends ExprContext {
		public ExprContext gauche;
		public Token op;
		public ExprContext droite;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Ou() { return getToken(MiniJavaParser.Ou, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprOr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprThisMethodCallContext extends ExprContext {
		public TerminalNode Ceci() { return getToken(MiniJavaParser.Ceci, 0); }
		public TerminalNode Point() { return getToken(MiniJavaParser.Point, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExprThisMethodCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprThisMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprThisMethodCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAttributeContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Point() { return getToken(MiniJavaParser.Point, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public ExprAttributeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprAttribute(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAddContext extends ExprContext {
		public ExprContext gauche;
		public Token op;
		public ExprContext droite;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Plus() { return getToken(MiniJavaParser.Plus, 0); }
		public TerminalNode Moins() { return getToken(MiniJavaParser.Moins, 0); }
		public ExprAddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprAdd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAndContext extends ExprContext {
		public ExprContext gauche;
		public Token op;
		public ExprContext droite;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Et() { return getToken(MiniJavaParser.Et, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprAnd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprSequenceContext extends ExprContext {
		public TerminalNode AccoladeOuvrante() { return getToken(MiniJavaParser.AccoladeOuvrante, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode AccoladeFermante() { return getToken(MiniJavaParser.AccoladeFermante, 0); }
		public ExprSequenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprSequence(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMethodCallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Point() { return getToken(MiniJavaParser.Point, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExprMethodCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprMethodCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOpositeContext extends ExprContext {
		public ExprContext droite;
		public TerminalNode Moins() { return getToken(MiniJavaParser.Moins, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprOpositeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprOposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprOposite(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprThisContext extends ExprContext {
		public TerminalNode Ceci() { return getToken(MiniJavaParser.Ceci, 0); }
		public TerminalNode Point() { return getToken(MiniJavaParser.Point, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public ExprThisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprThis(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParentheseeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(184);
				match(ParOuv);
				setState(185);
				expr(0);
				setState(186);
				match(ParFer);
				}
				break;
			case 2:
				{
				_localctx = new ExprConstructorCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(Nouveau);
				setState(189);
				match(Identificateur);
				setState(190);
				match(ParOuv);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126373469664313364L) != 0)) {
					{
					setState(191);
					expressions();
					}
				}

				setState(194);
				match(ParFer);
				}
				break;
			case 3:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(PointExclamation);
				setState(196);
				((ExprNotContext)_localctx).droite = expr(13);
				}
				break;
			case 4:
				{
				_localctx = new ExprOpositeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(Moins);
				setState(198);
				((ExprOpositeContext)_localctx).droite = expr(12);
				}
				break;
			case 5:
				{
				_localctx = new ExprSequenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(AccoladeOuvrante);
				setState(200);
				expressions();
				setState(201);
				match(AccoladeFermante);
				}
				break;
			case 6:
				{
				_localctx = new ExprConstanteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				expressionConstante();
				}
				break;
			case 7:
				{
				_localctx = new ExprThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(Ceci);
				setState(205);
				match(Point);
				setState(206);
				match(Identificateur);
				}
				break;
			case 8:
				{
				_localctx = new ExprThisMethodCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(Ceci);
				setState(208);
				match(Point);
				setState(209);
				match(Identificateur);
				setState(210);
				match(ParOuv);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126373469664313364L) != 0)) {
					{
					setState(211);
					expressions();
					}
				}

				setState(214);
				match(ParFer);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(257);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultContext(new ExprContext(_parentctx, _parentState));
						((ExprMultContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(218);
						((ExprMultContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0)) ) {
							((ExprMultContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(219);
						((ExprMultContext)_localctx).droite = expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						((ExprAddContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(221);
						((ExprAddContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Moins) ) {
							((ExprAddContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(222);
						((ExprAddContext)_localctx).droite = expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprIneqContext(new ExprContext(_parentctx, _parentState));
						((ExprIneqContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(224);
						((ExprIneqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32212254720L) != 0)) ) {
							((ExprIneqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(225);
						((ExprIneqContext)_localctx).droite = expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						((ExprEqContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(227);
						((ExprEqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DoubleEgal || _la==Different) ) {
							((ExprEqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						((ExprEqContext)_localctx).droite = expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						((ExprAndContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(230);
						((ExprAndContext)_localctx).op = match(Et);
						setState(231);
						((ExprAndContext)_localctx).droite = expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						((ExprOrContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(232);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(233);
						((ExprOrContext)_localctx).op = match(Ou);
						setState(234);
						((ExprOrContext)_localctx).droite = expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprCondContext(new ExprContext(_parentctx, _parentState));
						((ExprCondContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(236);
						match(PtInterro);
						setState(237);
						((ExprCondContext)_localctx).alors = expr(0);
						setState(238);
						match(DeuxPoint);
						setState(239);
						((ExprCondContext)_localctx).sinon = expr(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprAttributeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(242);
						match(Point);
						setState(243);
						match(Identificateur);
						}
						break;
					case 9:
						{
						_localctx = new ExprMethodCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(245);
						match(Point);
						setState(246);
						match(Identificateur);
						setState(247);
						match(ParOuv);
						setState(249);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126373469664313364L) != 0)) {
							{
							setState(248);
							expressions();
							}
						}

						setState(251);
						match(ParFer);
						}
						break;
					case 10:
						{
						_localctx = new ExprArrayAccessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(253);
						match(CrochOuv);
						setState(254);
						expr(0);
						setState(255);
						match(CrochFer);
						}
						break;
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclLocaleContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode Final() { return getToken(MiniJavaParser.Final, 0); }
		public TerminalNode Egal() { return getToken(MiniJavaParser.Egal, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclLocaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declLocale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterDeclLocale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitDeclLocale(this);
		}
	}

	public final DeclLocaleContext declLocale() throws RecognitionException {
		DeclLocaleContext _localctx = new DeclLocaleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declLocale);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Final) {
				{
				setState(262);
				match(Final);
				}
			}

			setState(265);
			type(0);
			setState(266);
			match(Identificateur);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Egal) {
				{
				setState(267);
				match(Egal);
				setState(268);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignationContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode Egal() { return getToken(MiniJavaParser.Egal, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			assignable(0);
			setState(272);
			match(Egal);
			setState(273);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableContext extends ParserRuleContext {
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode Point() { return getToken(MiniJavaParser.Point, 0); }
		public TerminalNode CrochOuv() { return getToken(MiniJavaParser.CrochOuv, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CrochFer() { return getToken(MiniJavaParser.CrochFer, 0); }
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitAssignable(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		return assignable(0);
	}

	private AssignableContext assignable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AssignableContext _localctx = new AssignableContext(_ctx, _parentState);
		AssignableContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_assignable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(276);
			match(Identificateur);
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(286);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new AssignableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_assignable);
						setState(278);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(279);
						match(Point);
						setState(280);
						match(Identificateur);
						}
						break;
					case 2:
						{
						_localctx = new AssignableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_assignable);
						setState(281);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(282);
						match(CrochOuv);
						setState(283);
						expr(0);
						setState(284);
						match(CrochFer);
						}
						break;
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> l;
		public ExprContext premiere;
		public ExprContext expr;
		public List<ExprContext> suite = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Virg() { return getTokens(MiniJavaParser.Virg); }
		public TerminalNode Virg(int i) {
			return getToken(MiniJavaParser.Virg, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			((ExpressionsContext)_localctx).premiere = expr(0);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Virg) {
				{
				{
				setState(292);
				match(Virg);
				setState(293);
				((ExpressionsContext)_localctx).expr = expr(0);
				((ExpressionsContext)_localctx).suite.add(((ExpressionsContext)_localctx).expr);
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type t;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeArrayContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CrochOuv() { return getToken(MiniJavaParser.CrochOuv, 0); }
		public TerminalNode CrochFer() { return getToken(MiniJavaParser.CrochFer, 0); }
		public TypeArrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterTypeArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitTypeArray(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeNamedContext extends TypeContext {
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TypeNamedContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterTypeNamed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitTypeNamed(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeAtomicContext extends TypeContext {
		public AtomiqueContext atomique() {
			return getRuleContext(AtomiqueContext.class,0);
		}
		public TypeAtomicContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterTypeAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitTypeAtomic(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
				{
				_localctx = new TypeAtomicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(300);
				atomique();
				}
				break;
			case Identificateur:
				{
				_localctx = new TypeNamedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(301);
				match(Identificateur);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeArrayContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(304);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(305);
					match(CrochOuv);
					setState(306);
					match(CrochFer);
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomiqueContext extends ParserRuleContext {
		public AtomicType t;
		public TerminalNode TypeEntier() { return getToken(MiniJavaParser.TypeEntier, 0); }
		public TerminalNode TypeFlottant() { return getToken(MiniJavaParser.TypeFlottant, 0); }
		public TerminalNode TypeBooleen() { return getToken(MiniJavaParser.TypeBooleen, 0); }
		public TerminalNode TypeCaractere() { return getToken(MiniJavaParser.TypeCaractere, 0); }
		public TerminalNode TypeChaine() { return getToken(MiniJavaParser.TypeChaine, 0); }
		public TerminalNode TypeVide() { return getToken(MiniJavaParser.TypeVide, 0); }
		public AtomiqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterAtomique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitAtomique(this);
		}
	}

	public final AtomiqueContext atomique() throws RecognitionException {
		AtomiqueContext _localctx = new AtomiqueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atomique);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8658654068736L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionConstanteContext extends ParserRuleContext {
		public Expression e;
		public ExpressionConstanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionConstante; }
	 
		public ExpressionConstanteContext() { }
		public void copyFrom(ExpressionConstanteContext ctx) {
			super.copyFrom(ctx);
			this.e = ctx.e;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIntContext extends ExpressionConstanteContext {
		public TerminalNode Entier() { return getToken(MiniJavaParser.Entier, 0); }
		public ExprIntContext(ExpressionConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprInt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNullContext extends ExpressionConstanteContext {
		public TerminalNode Nul() { return getToken(MiniJavaParser.Nul, 0); }
		public ExprNullContext(ExpressionConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprNull(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCharacterContext extends ExpressionConstanteContext {
		public TerminalNode Caractere() { return getToken(MiniJavaParser.Caractere, 0); }
		public ExprCharacterContext(ExpressionConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprCharacter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStringContext extends ExpressionConstanteContext {
		public TerminalNode Chaine() { return getToken(MiniJavaParser.Chaine, 0); }
		public ExprStringContext(ExpressionConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFalseContext extends ExpressionConstanteContext {
		public TerminalNode Faux() { return getToken(MiniJavaParser.Faux, 0); }
		public ExprFalseContext(ExpressionConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprFalse(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFloatContext extends ExpressionConstanteContext {
		public TerminalNode Flottant() { return getToken(MiniJavaParser.Flottant, 0); }
		public ExprFloatContext(ExpressionConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprFloat(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprTrueContext extends ExpressionConstanteContext {
		public TerminalNode Vrai() { return getToken(MiniJavaParser.Vrai, 0); }
		public ExprTrueContext(ExpressionConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprTrue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAccessContext extends ExpressionConstanteContext {
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public ExprAccessContext(ExpressionConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExprAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExprAccess(this);
		}
	}

	public final ExpressionConstanteContext expressionConstante() throws RecognitionException {
		ExpressionConstanteContext _localctx = new ExpressionConstanteContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionConstante);
		try {
			setState(322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Vrai:
				_localctx = new ExprTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(Vrai);
				}
				break;
			case Faux:
				_localctx = new ExprFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				match(Faux);
				}
				break;
			case Entier:
				_localctx = new ExprIntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				match(Entier);
				}
				break;
			case Flottant:
				_localctx = new ExprFloatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(317);
				match(Flottant);
				}
				break;
			case Caractere:
				_localctx = new ExprCharacterContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(318);
				match(Caractere);
				}
				break;
			case Chaine:
				_localctx = new ExprStringContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(319);
				match(Chaine);
				}
				break;
			case Nul:
				_localctx = new ExprNullContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(320);
				match(Nul);
				}
				break;
			case Identificateur:
				_localctx = new ExprAccessContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(321);
				match(Identificateur);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 13:
			return assignable_sempred((AssignableContext)_localctx, predIndex);
		case 15:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 17);
		case 8:
			return precpred(_ctx, 16);
		case 9:
			return precpred(_ctx, 14);
		}
		return true;
	}
	private boolean assignable_sempred(AssignableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001;\u0145\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0001\u0003\u0001,\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u00016\b\u0001\n\u0001\f\u00019\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002A\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0003\u0004J\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004S\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005W\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005c\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0005\u0007m\b\u0007\n\u0007\f\u0007p\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b{\b\b\n\b\f\b~\t\b\u0003\b\u0080\b\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u009a\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b6\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c1\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00d5"+
		"\b\n\u0001\n\u0003\n\u00d8\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00fa\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0102\b\n\n\n\f\n\u0105\t\n\u0001\u000b\u0003\u000b\u0108\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u010e\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u011f\b\r\n\r\f\r\u0122"+
		"\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0127\b\u000e\n\u000e"+
		"\f\u000e\u012a\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u012f\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0134\b"+
		"\u000f\n\u000f\f\u000f\u0137\t\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0143\b\u0011\u0001\u0011\u0000\u0003\u0014\u001a"+
		"\u001e\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"\u0000\u0007\u0001\u000001\u0003\u00000022"+
		"44\u0001\u0000\u0017\u0019\u0001\u0000\u001a\u001b\u0001\u0000\u001f\""+
		"\u0001\u0000#$\u0001\u0000%*\u0169\u0000\'\u0001\u0000\u0000\u0000\u0002"+
		"+\u0001\u0000\u0000\u0000\u0004<\u0001\u0000\u0000\u0000\u0006B\u0001"+
		"\u0000\u0000\u0000\bR\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000"+
		"\fd\u0001\u0000\u0000\u0000\u000ej\u0001\u0000\u0000\u0000\u0010\u007f"+
		"\u0001\u0000\u0000\u0000\u0012\u00b5\u0001\u0000\u0000\u0000\u0014\u00d7"+
		"\u0001\u0000\u0000\u0000\u0016\u0107\u0001\u0000\u0000\u0000\u0018\u010f"+
		"\u0001\u0000\u0000\u0000\u001a\u0113\u0001\u0000\u0000\u0000\u001c\u0123"+
		"\u0001\u0000\u0000\u0000\u001e\u012e\u0001\u0000\u0000\u0000 \u0138\u0001"+
		"\u0000\u0000\u0000\"\u0142\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001"+
		"\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000"+
		"\u0000\u0000\'(\u0001\u0000\u0000\u0000(\u0001\u0001\u0000\u0000\u0000"+
		")\'\u0001\u0000\u0000\u0000*,\u0007\u0000\u0000\u0000+*\u0001\u0000\u0000"+
		"\u0000+,\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0005\u0014"+
		"\u0000\u0000.1\u00056\u0000\u0000/0\u00055\u0000\u000002\u00056\u0000"+
		"\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u000037\u0005\u0002\u0000\u000046\u0003\u0004\u0002\u000054\u0001"+
		"\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u0000:;\u0005\u0003\u0000\u0000;\u0003\u0001\u0000\u0000\u0000<@\u0007"+
		"\u0001\u0000\u0000=A\u0003\u0006\u0003\u0000>A\u0003\b\u0004\u0000?A\u0003"+
		"\n\u0005\u0000@=\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@?\u0001"+
		"\u0000\u0000\u0000A\u0005\u0001\u0000\u0000\u0000BC\u00056\u0000\u0000"+
		"CD\u0005\u0004\u0000\u0000DE\u0003\u0010\b\u0000EF\u0005\u0005\u0000\u0000"+
		"FG\u0003\u000e\u0007\u0000G\u0007\u0001\u0000\u0000\u0000HJ\u00053\u0000"+
		"\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KL\u0003\f\u0006\u0000LM\u0003\u000e\u0007\u0000MS\u0001\u0000"+
		"\u0000\u0000NO\u00051\u0000\u0000OP\u0003\f\u0006\u0000PQ\u0005\f\u0000"+
		"\u0000QS\u0001\u0000\u0000\u0000RI\u0001\u0000\u0000\u0000RN\u0001\u0000"+
		"\u0000\u0000S\t\u0001\u0000\u0000\u0000TV\u00053\u0000\u0000UW\u0005\u0013"+
		"\u0000\u0000VU\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XY\u0003\u001e\u000f\u0000YZ\u00056\u0000\u0000Z[\u0005"+
		"\u0001\u0000\u0000[\\\u0003\u0014\n\u0000\\]\u0005\f\u0000\u0000]c\u0001"+
		"\u0000\u0000\u0000^_\u0003\u001e\u000f\u0000_`\u00056\u0000\u0000`a\u0005"+
		"\f\u0000\u0000ac\u0001\u0000\u0000\u0000bT\u0001\u0000\u0000\u0000b^\u0001"+
		"\u0000\u0000\u0000c\u000b\u0001\u0000\u0000\u0000de\u0003\u001e\u000f"+
		"\u0000ef\u00056\u0000\u0000fg\u0005\u0004\u0000\u0000gh\u0003\u0010\b"+
		"\u0000hi\u0005\u0005\u0000\u0000i\r\u0001\u0000\u0000\u0000jn\u0005\u0002"+
		"\u0000\u0000km\u0003\u0012\t\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\u0003\u0000\u0000"+
		"r\u000f\u0001\u0000\u0000\u0000s\u0080\u0001\u0000\u0000\u0000tu\u0003"+
		"\u001e\u000f\u0000u|\u00056\u0000\u0000vw\u0005\u000b\u0000\u0000wx\u0003"+
		"\u001e\u000f\u0000xy\u00056\u0000\u0000y{\u0001\u0000\u0000\u0000zv\u0001"+
		"\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000\u007fs\u0001\u0000\u0000\u0000\u007ft\u0001\u0000\u0000\u0000"+
		"\u0080\u0011\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u000e\u0000\u0000"+
		"\u0082\u0083\u0005\u0004\u0000\u0000\u0083\u0084\u0003\u0014\n\u0000\u0084"+
		"\u0085\u0005\u0005\u0000\u0000\u0085\u0086\u0003\u000e\u0007\u0000\u0086"+
		"\u00b6\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u000e\u0000\u0000\u0088"+
		"\u0089\u0005\u0004\u0000\u0000\u0089\u008a\u0003\u0014\n\u0000\u008a\u008b"+
		"\u0005\u0005\u0000\u0000\u008b\u008c\u0003\u000e\u0007\u0000\u008c\u008d"+
		"\u0005\u000f\u0000\u0000\u008d\u008e\u0003\u000e\u0007\u0000\u008e\u00b6"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0010\u0000\u0000\u0090\u0091"+
		"\u0005\u0004\u0000\u0000\u0091\u0092\u0003\u0014\n\u0000\u0092\u0093\u0005"+
		"\u0005\u0000\u0000\u0093\u0094\u0003\u000e\u0007\u0000\u0094\u00b6\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0005\u0011\u0000\u0000\u0096\u0099\u0005"+
		"\u0004\u0000\u0000\u0097\u009a\u0003\u0018\f\u0000\u0098\u009a\u0003\u0016"+
		"\u000b\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0005\f\u0000"+
		"\u0000\u009c\u009d\u0003\u0014\n\u0000\u009d\u009e\u0005\f\u0000\u0000"+
		"\u009e\u009f\u0003\u0018\f\u0000\u009f\u00a0\u0005\u0005\u0000\u0000\u00a0"+
		"\u00a1\u0003\u000e\u0007\u0000\u00a1\u00b6\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0005\u0011\u0000\u0000\u00a3\u00a4\u0005\u0004\u0000\u0000\u00a4"+
		"\u00a5\u0003\u001e\u000f\u0000\u00a5\u00a6\u00056\u0000\u0000\u00a6\u00a7"+
		"\u0005\n\u0000\u0000\u00a7\u00a8\u0003\u0014\n\u0000\u00a8\u00a9\u0005"+
		"\u0005\u0000\u0000\u00a9\u00aa\u0003\u000e\u0007\u0000\u00aa\u00b6\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0005\u0012\u0000\u0000\u00ac\u00ad\u0003"+
		"\u0014\n\u0000\u00ad\u00ae\u0005\f\u0000\u0000\u00ae\u00b6\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0003\u0016\u000b\u0000\u00b0\u00b1\u0005\f\u0000"+
		"\u0000\u00b1\u00b6\u0001\u0000\u0000\u0000\u00b2\u00b3\u0003\u0018\f\u0000"+
		"\u00b3\u00b4\u0005\f\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5"+
		"\u0081\u0001\u0000\u0000\u0000\u00b5\u0087\u0001\u0000\u0000\u0000\u00b5"+
		"\u008f\u0001\u0000\u0000\u0000\u00b5\u0095\u0001\u0000\u0000\u0000\u00b5"+
		"\u00a2\u0001\u0000\u0000\u0000\u00b5\u00ab\u0001\u0000\u0000\u0000\u00b5"+
		"\u00af\u0001\u0000\u0000\u0000\u00b5\u00b2\u0001\u0000\u0000\u0000\u00b6"+
		"\u0013\u0001\u0000\u0000\u0000\u00b7\u00b8\u0006\n\uffff\uffff\u0000\u00b8"+
		"\u00b9\u0005\u0004\u0000\u0000\u00b9\u00ba\u0003\u0014\n\u0000\u00ba\u00bb"+
		"\u0005\u0005\u0000\u0000\u00bb\u00d8\u0001\u0000\u0000\u0000\u00bc\u00bd"+
		"\u0005\u0015\u0000\u0000\u00bd\u00be\u00056\u0000\u0000\u00be\u00c0\u0005"+
		"\u0004\u0000\u0000\u00bf\u00c1\u0003\u001c\u000e\u0000\u00c0\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c2\u00d8\u0005\u0005\u0000\u0000\u00c3\u00c4\u0005"+
		"\u001e\u0000\u0000\u00c4\u00d8\u0003\u0014\n\r\u00c5\u00c6\u0005\u001b"+
		"\u0000\u0000\u00c6\u00d8\u0003\u0014\n\f\u00c7\u00c8\u0005\u0002\u0000"+
		"\u0000\u00c8\u00c9\u0003\u001c\u000e\u0000\u00c9\u00ca\u0005\u0003\u0000"+
		"\u0000\u00ca\u00d8\u0001\u0000\u0000\u0000\u00cb\u00d8\u0003\"\u0011\u0000"+
		"\u00cc\u00cd\u0005\u0016\u0000\u0000\u00cd\u00ce\u0005\b\u0000\u0000\u00ce"+
		"\u00d8\u00056\u0000\u0000\u00cf\u00d0\u0005\u0016\u0000\u0000\u00d0\u00d1"+
		"\u0005\b\u0000\u0000\u00d1\u00d2\u00056\u0000\u0000\u00d2\u00d4\u0005"+
		"\u0004\u0000\u0000\u00d3\u00d5\u0003\u001c\u000e\u0000\u00d4\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d8\u0005\u0005\u0000\u0000\u00d7\u00b7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00bc\u0001\u0000\u0000\u0000\u00d7\u00c3\u0001"+
		"\u0000\u0000\u0000\u00d7\u00c5\u0001\u0000\u0000\u0000\u00d7\u00c7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00cb\u0001\u0000\u0000\u0000\u00d7\u00cc\u0001"+
		"\u0000\u0000\u0000\u00d7\u00cf\u0001\u0000\u0000\u0000\u00d8\u0103\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\n\u000b\u0000\u0000\u00da\u00db\u0007\u0002"+
		"\u0000\u0000\u00db\u0102\u0003\u0014\n\f\u00dc\u00dd\n\n\u0000\u0000\u00dd"+
		"\u00de\u0007\u0003\u0000\u0000\u00de\u0102\u0003\u0014\n\u000b\u00df\u00e0"+
		"\n\t\u0000\u0000\u00e0\u00e1\u0007\u0004\u0000\u0000\u00e1\u0102\u0003"+
		"\u0014\n\n\u00e2\u00e3\n\b\u0000\u0000\u00e3\u00e4\u0007\u0005\u0000\u0000"+
		"\u00e4\u0102\u0003\u0014\n\t\u00e5\u00e6\n\u0007\u0000\u0000\u00e6\u00e7"+
		"\u0005\u001d\u0000\u0000\u00e7\u0102\u0003\u0014\n\b\u00e8\u00e9\n\u0006"+
		"\u0000\u0000\u00e9\u00ea\u0005\u001c\u0000\u0000\u00ea\u0102\u0003\u0014"+
		"\n\u0007\u00eb\u00ec\n\u0005\u0000\u0000\u00ec\u00ed\u0005\t\u0000\u0000"+
		"\u00ed\u00ee\u0003\u0014\n\u0000\u00ee\u00ef\u0005\n\u0000\u0000\u00ef"+
		"\u00f0\u0003\u0014\n\u0006\u00f0\u0102\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\n\u0011\u0000\u0000\u00f2\u00f3\u0005\b\u0000\u0000\u00f3\u0102\u0005"+
		"6\u0000\u0000\u00f4\u00f5\n\u0010\u0000\u0000\u00f5\u00f6\u0005\b\u0000"+
		"\u0000\u00f6\u00f7\u00056\u0000\u0000\u00f7\u00f9\u0005\u0004\u0000\u0000"+
		"\u00f8\u00fa\u0003\u001c\u000e\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fb\u0102\u0005\u0005\u0000\u0000\u00fc\u00fd\n\u000e\u0000\u0000\u00fd"+
		"\u00fe\u0005\u0006\u0000\u0000\u00fe\u00ff\u0003\u0014\n\u0000\u00ff\u0100"+
		"\u0005\u0007\u0000\u0000\u0100\u0102\u0001\u0000\u0000\u0000\u0101\u00d9"+
		"\u0001\u0000\u0000\u0000\u0101\u00dc\u0001\u0000\u0000\u0000\u0101\u00df"+
		"\u0001\u0000\u0000\u0000\u0101\u00e2\u0001\u0000\u0000\u0000\u0101\u00e5"+
		"\u0001\u0000\u0000\u0000\u0101\u00e8\u0001\u0000\u0000\u0000\u0101\u00eb"+
		"\u0001\u0000\u0000\u0000\u0101\u00f1\u0001\u0000\u0000\u0000\u0101\u00f4"+
		"\u0001\u0000\u0000\u0000\u0101\u00fc\u0001\u0000\u0000\u0000\u0102\u0105"+
		"\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104"+
		"\u0001\u0000\u0000\u0000\u0104\u0015\u0001\u0000\u0000\u0000\u0105\u0103"+
		"\u0001\u0000\u0000\u0000\u0106\u0108\u0005\u0013\u0000\u0000\u0107\u0106"+
		"\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109"+
		"\u0001\u0000\u0000\u0000\u0109\u010a\u0003\u001e\u000f\u0000\u010a\u010d"+
		"\u00056\u0000\u0000\u010b\u010c\u0005\u0001\u0000\u0000\u010c\u010e\u0003"+
		"\u0014\n\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e\u0017\u0001\u0000\u0000\u0000\u010f\u0110\u0003\u001a"+
		"\r\u0000\u0110\u0111\u0005\u0001\u0000\u0000\u0111\u0112\u0003\u0014\n"+
		"\u0000\u0112\u0019\u0001\u0000\u0000\u0000\u0113\u0114\u0006\r\uffff\uffff"+
		"\u0000\u0114\u0115\u00056\u0000\u0000\u0115\u0120\u0001\u0000\u0000\u0000"+
		"\u0116\u0117\n\u0002\u0000\u0000\u0117\u0118\u0005\b\u0000\u0000\u0118"+
		"\u011f\u00056\u0000\u0000\u0119\u011a\n\u0001\u0000\u0000\u011a\u011b"+
		"\u0005\u0006\u0000\u0000\u011b\u011c\u0003\u0014\n\u0000\u011c\u011d\u0005"+
		"\u0007\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e\u0116\u0001"+
		"\u0000\u0000\u0000\u011e\u0119\u0001\u0000\u0000\u0000\u011f\u0122\u0001"+
		"\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001"+
		"\u0000\u0000\u0000\u0121\u001b\u0001\u0000\u0000\u0000\u0122\u0120\u0001"+
		"\u0000\u0000\u0000\u0123\u0128\u0003\u0014\n\u0000\u0124\u0125\u0005\u000b"+
		"\u0000\u0000\u0125\u0127\u0003\u0014\n\u0000\u0126\u0124\u0001\u0000\u0000"+
		"\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u001d\u0001\u0000\u0000"+
		"\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012c\u0006\u000f\uffff"+
		"\uffff\u0000\u012c\u012f\u0003 \u0010\u0000\u012d\u012f\u00056\u0000\u0000"+
		"\u012e\u012b\u0001\u0000\u0000\u0000\u012e\u012d\u0001\u0000\u0000\u0000"+
		"\u012f\u0135\u0001\u0000\u0000\u0000\u0130\u0131\n\u0001\u0000\u0000\u0131"+
		"\u0132\u0005\u0006\u0000\u0000\u0132\u0134\u0005\u0007\u0000\u0000\u0133"+
		"\u0130\u0001\u0000\u0000\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135"+
		"\u0133\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136"+
		"\u001f\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0138"+
		"\u0139\u0007\u0006\u0000\u0000\u0139!\u0001\u0000\u0000\u0000\u013a\u0143"+
		"\u0005+\u0000\u0000\u013b\u0143\u0005,\u0000\u0000\u013c\u0143\u00057"+
		"\u0000\u0000\u013d\u0143\u00058\u0000\u0000\u013e\u0143\u0005.\u0000\u0000"+
		"\u013f\u0143\u0005/\u0000\u0000\u0140\u0143\u0005-\u0000\u0000\u0141\u0143"+
		"\u00056\u0000\u0000\u0142\u013a\u0001\u0000\u0000\u0000\u0142\u013b\u0001"+
		"\u0000\u0000\u0000\u0142\u013c\u0001\u0000\u0000\u0000\u0142\u013d\u0001"+
		"\u0000\u0000\u0000\u0142\u013e\u0001\u0000\u0000\u0000\u0142\u013f\u0001"+
		"\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0141\u0001"+
		"\u0000\u0000\u0000\u0143#\u0001\u0000\u0000\u0000\u001c\'+17@IRVbn|\u007f"+
		"\u0099\u00b5\u00c0\u00d4\u00d7\u00f9\u0101\u0103\u0107\u010d\u011e\u0120"+
		"\u0128\u012e\u0135\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}