// Generated from MiniJavaParser.g4 by ANTLR 4.13.1

    package fr.n7.stl.minijava.parser;

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
		CrochFer=7, Point=8, PointInterrogation=9, DeuxPoint=10, Virgule=11, PointVirgule=12, 
		Afficher=13, Si=14, Sinon=15, TantQue=16, Pour=17, Retour=18, Final=19, 
		DefClasse=20, Nouveau=21, Ceci=22, Asterisque=23, Oblique=24, PourCent=25, 
		Plus=26, Moins=27, DoubleBarre=28, DoubleEsperluette=29, PointExclamation=30, 
		Inf=31, Sup=32, InfEg=33, SupEg=34, DoubleEgal=35, ExclamationEgal=36, 
		Esperluette=37, TypeEntier=38, TypeFlottant=39, TypeBooleen=40, TypeCaractere=41, 
		TypeChaine=42, TypeVide=43, Vrai=44, Faux=45, Nul=46, Caractere=47, Chaine=48, 
		Publique=49, Prive=50, Statique=51, Identificateur=52, Entier=53, Flottant=54, 
		CommentaireLigne=55, CommentaireBloc=56, WS=57;
	public static final int
		RULE_programme = 0, RULE_bloc = 1, RULE_classe = 2, RULE_membre = 3, RULE_attribut = 4, 
		RULE_constructeur = 5, RULE_methode = 6, RULE_parametres = 7, RULE_instruction = 8, 
		RULE_expression = 9, RULE_declarationLocale = 10, RULE_assignation = 11, 
		RULE_assignable = 12, RULE_expressions = 13, RULE_type = 14, RULE_atomique = 15, 
		RULE_modificateur = 16, RULE_expressionConstante = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"programme", "bloc", "classe", "membre", "attribut", "constructeur", 
			"methode", "parametres", "instruction", "expression", "declarationLocale", 
			"assignation", "assignable", "expressions", "type", "atomique", "modificateur", 
			"expressionConstante"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'{'", "'}'", "'('", "')'", "'['", "']'", "'.'", "'?'", 
			"':'", "','", "';'", "'print'", "'if'", "'else'", "'while'", "'for'", 
			"'return'", "'final'", "'class'", "'new'", "'this'", "'*'", "'/'", "'%'", 
			"'+'", "'-'", "'||'", "'&&'", "'!'", "'<'", "'>'", "'<='", "'>='", "'=='", 
			"'!='", "'&'", "'int'", "'float'", "'boolean'", "'char'", "'String'", 
			"'void'", "'true'", "'false'", "'null'", null, null, "'public'", "'private'", 
			"'static'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Egal", "AccoladeOuvrante", "AccoladeFermante", "ParOuv", "ParFer", 
			"CrochOuv", "CrochFer", "Point", "PointInterrogation", "DeuxPoint", "Virgule", 
			"PointVirgule", "Afficher", "Si", "Sinon", "TantQue", "Pour", "Retour", 
			"Final", "DefClasse", "Nouveau", "Ceci", "Asterisque", "Oblique", "PourCent", 
			"Plus", "Moins", "DoubleBarre", "DoubleEsperluette", "PointExclamation", 
			"Inf", "Sup", "InfEg", "SupEg", "DoubleEgal", "ExclamationEgal", "Esperluette", 
			"TypeEntier", "TypeFlottant", "TypeBooleen", "TypeCaractere", "TypeChaine", 
			"TypeVide", "Vrai", "Faux", "Nul", "Caractere", "Chaine", "Publique", 
			"Prive", "Statique", "Identificateur", "Entier", "Flottant", "CommentaireLigne", 
			"CommentaireBloc", "WS"
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
		public ClasseContext classe;
		public List<ClasseContext> classes = new ArrayList<ClasseContext>();
		public BlocContext mainBlock;
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
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
			while (_la==DefClasse) {
				{
				{
				setState(36);
				((ProgrammeContext)_localctx).classe = classe();
				((ProgrammeContext)_localctx).classes.add(((ProgrammeContext)_localctx).classe);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			((ProgrammeContext)_localctx).mainBlock = bloc();
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
	public static class BlocContext extends ParserRuleContext {
		public InstructionContext instruction;
		public List<InstructionContext> instructions = new ArrayList<InstructionContext>();
		public TerminalNode AccoladeOuvrante() { return getToken(MiniJavaParser.AccoladeOuvrante, 0); }
		public TerminalNode AccoladeFermante() { return getToken(MiniJavaParser.AccoladeFermante, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterBloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitBloc(this);
		}
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(AccoladeOuvrante);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4520916936245248L) != 0)) {
				{
				{
				setState(45);
				((BlocContext)_localctx).instruction = instruction();
				((BlocContext)_localctx).instructions.add(((BlocContext)_localctx).instruction);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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
	public static class ClasseContext extends ParserRuleContext {
		public Token nom;
		public MembreContext membre;
		public List<MembreContext> membres = new ArrayList<MembreContext>();
		public TerminalNode DefClasse() { return getToken(MiniJavaParser.DefClasse, 0); }
		public TerminalNode AccoladeOuvrante() { return getToken(MiniJavaParser.AccoladeOuvrante, 0); }
		public TerminalNode AccoladeFermante() { return getToken(MiniJavaParser.AccoladeFermante, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public List<MembreContext> membre() {
			return getRuleContexts(MembreContext.class);
		}
		public MembreContext membre(int i) {
			return getRuleContext(MembreContext.class,i);
		}
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
		enterRule(_localctx, 4, RULE_classe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(DefClasse);
			setState(54);
			((ClasseContext)_localctx).nom = match(Identificateur);
			setState(55);
			match(AccoladeOuvrante);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3940649673949184L) != 0)) {
				{
				{
				setState(56);
				((ClasseContext)_localctx).membre = membre();
				((ClasseContext)_localctx).membres.add(((ClasseContext)_localctx).membre);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
	public static class MembreContext extends ParserRuleContext {
		public AttributContext attribut() {
			return getRuleContext(AttributContext.class,0);
		}
		public ConstructeurContext constructeur() {
			return getRuleContext(ConstructeurContext.class,0);
		}
		public MethodeContext methode() {
			return getRuleContext(MethodeContext.class,0);
		}
		public MembreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_membre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterMembre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitMembre(this);
		}
	}

	public final MembreContext membre() throws RecognitionException {
		MembreContext _localctx = new MembreContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_membre);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				attribut();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				constructeur();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				methode();
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
	public static class AttributContext extends ParserRuleContext {
		public ModificateurContext modificateur() {
			return getRuleContext(ModificateurContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode PointVirgule() { return getToken(MiniJavaParser.PointVirgule, 0); }
		public TerminalNode Final() { return getToken(MiniJavaParser.Final, 0); }
		public TerminalNode Egal() { return getToken(MiniJavaParser.Egal, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_attribut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			modificateur();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Final) {
				{
				setState(70);
				match(Final);
				}
			}

			setState(73);
			type(0);
			setState(74);
			match(Identificateur);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Egal) {
				{
				setState(75);
				match(Egal);
				setState(76);
				expression(0);
				}
			}

			setState(79);
			match(PointVirgule);
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
		public Token nom;
		public BlocContext block;
		public ModificateurContext modificateur() {
			return getRuleContext(ModificateurContext.class,0);
		}
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public ParametresContext parametres() {
			return getRuleContext(ParametresContext.class,0);
		}
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
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
		enterRule(_localctx, 10, RULE_constructeur);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			modificateur();
			setState(82);
			((ConstructeurContext)_localctx).nom = match(Identificateur);
			setState(83);
			match(ParOuv);
			setState(84);
			parametres();
			setState(85);
			match(ParFer);
			setState(86);
			((ConstructeurContext)_localctx).block = bloc();
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
		public Token nom;
		public BlocContext block;
		public ModificateurContext modificateur() {
			return getRuleContext(ModificateurContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public ParametresContext parametres() {
			return getRuleContext(ParametresContext.class,0);
		}
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_methode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			modificateur();
			setState(89);
			type(0);
			setState(90);
			((MethodeContext)_localctx).nom = match(Identificateur);
			setState(91);
			match(ParOuv);
			setState(92);
			parametres();
			setState(93);
			match(ParFer);
			setState(94);
			((MethodeContext)_localctx).block = bloc();
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
		public TypeContext type;
		public List<TypeContext> suiteType = new ArrayList<TypeContext>();
		public Token Identificateur;
		public List<Token> suiteIdent = new ArrayList<Token>();
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
		public List<TerminalNode> Virgule() { return getTokens(MiniJavaParser.Virgule); }
		public TerminalNode Virgule(int i) {
			return getToken(MiniJavaParser.Virgule, i);
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
		enterRule(_localctx, 14, RULE_parametres);
		int _la;
		try {
			setState(108);
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
				setState(97);
				type(0);
				setState(98);
				match(Identificateur);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Virgule) {
					{
					{
					setState(99);
					match(Virgule);
					setState(100);
					((ParametresContext)_localctx).type = type(0);
					((ParametresContext)_localctx).suiteType.add(((ParametresContext)_localctx).type);
					setState(101);
					((ParametresContext)_localctx).Identificateur = match(Identificateur);
					((ParametresContext)_localctx).suiteIdent.add(((ParametresContext)_localctx).Identificateur);
					}
					}
					setState(107);
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
	public static class InstructionContext extends ParserRuleContext {
		public BlocContext alors;
		public BlocContext sinon;
		public BlocContext body;
		public TerminalNode Si() { return getToken(MiniJavaParser.Si, 0); }
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public List<BlocContext> bloc() {
			return getRuleContexts(BlocContext.class);
		}
		public BlocContext bloc(int i) {
			return getRuleContext(BlocContext.class,i);
		}
		public TerminalNode Sinon() { return getToken(MiniJavaParser.Sinon, 0); }
		public TerminalNode TantQue() { return getToken(MiniJavaParser.TantQue, 0); }
		public TerminalNode Pour() { return getToken(MiniJavaParser.Pour, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> PointVirgule() { return getTokens(MiniJavaParser.PointVirgule); }
		public TerminalNode PointVirgule(int i) {
			return getToken(MiniJavaParser.PointVirgule, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode DeuxPoint() { return getToken(MiniJavaParser.DeuxPoint, 0); }
		public DeclarationLocaleContext declarationLocale() {
			return getRuleContext(DeclarationLocaleContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instruction);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(Si);
				setState(111);
				match(ParOuv);
				setState(112);
				expression(0);
				setState(113);
				match(ParFer);
				setState(114);
				((InstructionContext)_localctx).alors = bloc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(Si);
				setState(117);
				match(ParOuv);
				setState(118);
				expression(0);
				setState(119);
				match(ParFer);
				setState(120);
				((InstructionContext)_localctx).alors = bloc();
				setState(121);
				match(Sinon);
				setState(122);
				((InstructionContext)_localctx).sinon = bloc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(TantQue);
				setState(125);
				match(ParOuv);
				setState(126);
				expression(0);
				setState(127);
				match(ParFer);
				setState(128);
				((InstructionContext)_localctx).body = bloc();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(Pour);
				setState(131);
				match(ParOuv);
				setState(132);
				instruction();
				setState(133);
				match(PointVirgule);
				setState(134);
				expression(0);
				setState(135);
				match(PointVirgule);
				setState(136);
				instruction();
				setState(137);
				match(ParFer);
				setState(138);
				((InstructionContext)_localctx).body = bloc();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				match(Pour);
				setState(141);
				match(ParOuv);
				setState(142);
				type(0);
				setState(143);
				match(Identificateur);
				setState(144);
				match(DeuxPoint);
				setState(145);
				expression(0);
				setState(146);
				match(ParFer);
				setState(147);
				((InstructionContext)_localctx).body = bloc();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(149);
				declarationLocale();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(150);
				assignation();
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext gauche;
		public Token op;
		public ExpressionContext droite;
		public TerminalNode ParOuv() { return getToken(MiniJavaParser.ParOuv, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ParFer() { return getToken(MiniJavaParser.ParFer, 0); }
		public TerminalNode Nouveau() { return getToken(MiniJavaParser.Nouveau, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode Moins() { return getToken(MiniJavaParser.Moins, 0); }
		public TerminalNode AccoladeOuvrante() { return getToken(MiniJavaParser.AccoladeOuvrante, 0); }
		public TerminalNode AccoladeFermante() { return getToken(MiniJavaParser.AccoladeFermante, 0); }
		public ExpressionConstanteContext expressionConstante() {
			return getRuleContext(ExpressionConstanteContext.class,0);
		}
		public TerminalNode Asterisque() { return getToken(MiniJavaParser.Asterisque, 0); }
		public TerminalNode Oblique() { return getToken(MiniJavaParser.Oblique, 0); }
		public TerminalNode PourCent() { return getToken(MiniJavaParser.PourCent, 0); }
		public TerminalNode Plus() { return getToken(MiniJavaParser.Plus, 0); }
		public TerminalNode Inf() { return getToken(MiniJavaParser.Inf, 0); }
		public TerminalNode Sup() { return getToken(MiniJavaParser.Sup, 0); }
		public TerminalNode InfEg() { return getToken(MiniJavaParser.InfEg, 0); }
		public TerminalNode SupEg() { return getToken(MiniJavaParser.SupEg, 0); }
		public TerminalNode DoubleEgal() { return getToken(MiniJavaParser.DoubleEgal, 0); }
		public TerminalNode ExclamationEgal() { return getToken(MiniJavaParser.ExclamationEgal, 0); }
		public TerminalNode PointInterrogation() { return getToken(MiniJavaParser.PointInterrogation, 0); }
		public TerminalNode DeuxPoint() { return getToken(MiniJavaParser.DeuxPoint, 0); }
		public TerminalNode Point() { return getToken(MiniJavaParser.Point, 0); }
		public TerminalNode CrochOuv() { return getToken(MiniJavaParser.CrochOuv, 0); }
		public TerminalNode CrochFer() { return getToken(MiniJavaParser.CrochFer, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ParOuv:
				{
				setState(154);
				match(ParOuv);
				setState(155);
				expression(0);
				setState(156);
				match(ParFer);
				}
				break;
			case Nouveau:
				{
				setState(158);
				match(Nouveau);
				setState(159);
				match(Identificateur);
				setState(160);
				match(ParOuv);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32070555295285268L) != 0)) {
					{
					setState(161);
					expressions();
					}
				}

				setState(164);
				match(ParFer);
				}
				break;
			case Moins:
				{
				setState(165);
				match(Moins);
				setState(166);
				expression(8);
				}
				break;
			case AccoladeOuvrante:
				{
				setState(167);
				match(AccoladeOuvrante);
				setState(168);
				expressions();
				setState(169);
				match(AccoladeFermante);
				}
				break;
			case Vrai:
			case Faux:
			case Nul:
			case Caractere:
			case Chaine:
			case Identificateur:
			case Entier:
			case Flottant:
				{
				setState(171);
				expressionConstante();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(208);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(175);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(176);
						((ExpressionContext)_localctx).droite = expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(178);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Moins) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(179);
						((ExpressionContext)_localctx).droite = expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(181);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32212254720L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						((ExpressionContext)_localctx).droite = expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(184);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DoubleEgal || _la==ExclamationEgal) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						((ExpressionContext)_localctx).droite = expression(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(187);
						match(PointInterrogation);
						setState(188);
						expression(0);
						setState(189);
						match(DeuxPoint);
						setState(190);
						expression(3);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(193);
						match(Point);
						setState(194);
						match(Identificateur);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(196);
						match(Point);
						setState(197);
						match(Identificateur);
						setState(198);
						match(ParOuv);
						setState(200);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32070555295285268L) != 0)) {
							{
							setState(199);
							expressions();
							}
						}

						setState(202);
						match(ParFer);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(203);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(204);
						match(CrochOuv);
						setState(205);
						expression(0);
						setState(206);
						match(CrochFer);
						}
						break;
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
	public static class DeclarationLocaleContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode PointVirgule() { return getToken(MiniJavaParser.PointVirgule, 0); }
		public TerminalNode Final() { return getToken(MiniJavaParser.Final, 0); }
		public TerminalNode Egal() { return getToken(MiniJavaParser.Egal, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationLocaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationLocale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterDeclarationLocale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitDeclarationLocale(this);
		}
	}

	public final DeclarationLocaleContext declarationLocale() throws RecognitionException {
		DeclarationLocaleContext _localctx = new DeclarationLocaleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declarationLocale);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Final) {
				{
				setState(213);
				match(Final);
				}
			}

			setState(216);
			type(0);
			setState(217);
			match(Identificateur);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Egal) {
				{
				setState(218);
				match(Egal);
				setState(219);
				expression(0);
				}
			}

			setState(222);
			match(PointVirgule);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PointVirgule() { return getToken(MiniJavaParser.PointVirgule, 0); }
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
		enterRule(_localctx, 22, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			assignable(0);
			setState(225);
			match(Egal);
			setState(226);
			expression(0);
			setState(227);
			match(PointVirgule);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_assignable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(230);
			match(Identificateur);
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(240);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new AssignableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_assignable);
						setState(232);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(233);
						match(Point);
						setState(234);
						match(Identificateur);
						}
						break;
					case 2:
						{
						_localctx = new AssignableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_assignable);
						setState(235);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(236);
						match(CrochOuv);
						setState(237);
						expression(0);
						setState(238);
						match(CrochFer);
						}
						break;
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public ExpressionContext premiere;
		public ExpressionContext expression;
		public List<ExpressionContext> suite = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Virgule() { return getTokens(MiniJavaParser.Virgule); }
		public TerminalNode Virgule(int i) {
			return getToken(MiniJavaParser.Virgule, i);
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
		enterRule(_localctx, 26, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			((ExpressionsContext)_localctx).premiere = expression(0);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Virgule) {
				{
				{
				setState(246);
				match(Virgule);
				setState(247);
				((ExpressionsContext)_localctx).expression = expression(0);
				((ExpressionsContext)_localctx).suite.add(((ExpressionsContext)_localctx).expression);
				}
				}
				setState(252);
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
		public AtomiqueContext atomique() {
			return getRuleContext(AtomiqueContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CrochOuv() { return getToken(MiniJavaParser.CrochOuv, 0); }
		public TerminalNode CrochFer() { return getToken(MiniJavaParser.CrochFer, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitType(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
				{
				setState(254);
				atomique();
				}
				break;
			case Identificateur:
				{
				setState(255);
				match(Identificateur);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(258);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(259);
					match(CrochOuv);
					setState(260);
					match(CrochFer);
					}
					} 
				}
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 30, RULE_atomique);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17317308137472L) != 0)) ) {
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
	public static class ModificateurContext extends ParserRuleContext {
		public TerminalNode Publique() { return getToken(MiniJavaParser.Publique, 0); }
		public TerminalNode Prive() { return getToken(MiniJavaParser.Prive, 0); }
		public TerminalNode Statique() { return getToken(MiniJavaParser.Statique, 0); }
		public ModificateurContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modificateur; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterModificateur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitModificateur(this);
		}
	}

	public final ModificateurContext modificateur() throws RecognitionException {
		ModificateurContext _localctx = new ModificateurContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_modificateur);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3940649673949184L) != 0)) ) {
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
		public TerminalNode Vrai() { return getToken(MiniJavaParser.Vrai, 0); }
		public TerminalNode Faux() { return getToken(MiniJavaParser.Faux, 0); }
		public TerminalNode Nul() { return getToken(MiniJavaParser.Nul, 0); }
		public TerminalNode Entier() { return getToken(MiniJavaParser.Entier, 0); }
		public TerminalNode Flottant() { return getToken(MiniJavaParser.Flottant, 0); }
		public TerminalNode Caractere() { return getToken(MiniJavaParser.Caractere, 0); }
		public TerminalNode Chaine() { return getToken(MiniJavaParser.Chaine, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public ExpressionConstanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionConstante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExpressionConstante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExpressionConstante(this);
		}
	}

	public final ExpressionConstanteContext expressionConstante() throws RecognitionException {
		ExpressionConstanteContext _localctx = new ExpressionConstanteContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionConstante);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32070555158970368L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 12:
			return assignable_sempred((AssignableContext)_localctx, predIndex);
		case 14:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 9);
		}
		return true;
	}
	private boolean assignable_sempred(AssignableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u0111\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0005\u0001/\b\u0001\n\u0001\f\u00012\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		":\b\u0002\n\u0002\f\u0002=\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003D\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0003\u0004H\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004N\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007h\b\u0007\n\u0007\f\u0007k\t\u0007"+
		"\u0003\u0007m\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u0098\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00a3\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00ad\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00c9\b\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u00d1\b\t\n\t\f\t\u00d4\t\t\u0001\n\u0003\n"+
		"\u00d7\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00dd\b\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u00f1\b\f\n\f\f\f\u00f4\t\f\u0001\r\u0001\r\u0001\r"+
		"\u0005\r\u00f9\b\r\n\r\f\r\u00fc\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0101\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u0106\b\u000e\n\u000e\f\u000e\u0109\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0003\u0012"+
		"\u0018\u001c\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"\u0000\u0007\u0001\u0000\u0017\u0019"+
		"\u0001\u0000\u001a\u001b\u0001\u0000\u001f\"\u0001\u0000#$\u0001\u0000"+
		"&+\u0001\u000013\u0002\u0000,046\u0122\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0002,\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u0006C"+
		"\u0001\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000\nQ\u0001\u0000\u0000"+
		"\u0000\fX\u0001\u0000\u0000\u0000\u000el\u0001\u0000\u0000\u0000\u0010"+
		"\u0097\u0001\u0000\u0000\u0000\u0012\u00ac\u0001\u0000\u0000\u0000\u0014"+
		"\u00d6\u0001\u0000\u0000\u0000\u0016\u00e0\u0001\u0000\u0000\u0000\u0018"+
		"\u00e5\u0001\u0000\u0000\u0000\u001a\u00f5\u0001\u0000\u0000\u0000\u001c"+
		"\u0100\u0001\u0000\u0000\u0000\u001e\u010a\u0001\u0000\u0000\u0000 \u010c"+
		"\u0001\u0000\u0000\u0000\"\u010e\u0001\u0000\u0000\u0000$&\u0003\u0004"+
		"\u0002\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(*\u0001\u0000\u0000\u0000"+
		")\'\u0001\u0000\u0000\u0000*+\u0003\u0002\u0001\u0000+\u0001\u0001\u0000"+
		"\u0000\u0000,0\u0005\u0002\u0000\u0000-/\u0003\u0010\b\u0000.-\u0001\u0000"+
		"\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001"+
		"\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"34\u0005\u0003\u0000\u00004\u0003\u0001\u0000\u0000\u000056\u0005\u0014"+
		"\u0000\u000067\u00054\u0000\u00007;\u0005\u0002\u0000\u00008:\u0003\u0006"+
		"\u0003\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000>?\u0005\u0003\u0000\u0000?\u0005\u0001\u0000"+
		"\u0000\u0000@D\u0003\b\u0004\u0000AD\u0003\n\u0005\u0000BD\u0003\f\u0006"+
		"\u0000C@\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CB\u0001\u0000"+
		"\u0000\u0000D\u0007\u0001\u0000\u0000\u0000EG\u0003 \u0010\u0000FH\u0005"+
		"\u0013\u0000\u0000GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000IJ\u0003\u001c\u000e\u0000JM\u00054\u0000\u0000"+
		"KL\u0005\u0001\u0000\u0000LN\u0003\u0012\t\u0000MK\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0005\f\u0000\u0000"+
		"P\t\u0001\u0000\u0000\u0000QR\u0003 \u0010\u0000RS\u00054\u0000\u0000"+
		"ST\u0005\u0004\u0000\u0000TU\u0003\u000e\u0007\u0000UV\u0005\u0005\u0000"+
		"\u0000VW\u0003\u0002\u0001\u0000W\u000b\u0001\u0000\u0000\u0000XY\u0003"+
		" \u0010\u0000YZ\u0003\u001c\u000e\u0000Z[\u00054\u0000\u0000[\\\u0005"+
		"\u0004\u0000\u0000\\]\u0003\u000e\u0007\u0000]^\u0005\u0005\u0000\u0000"+
		"^_\u0003\u0002\u0001\u0000_\r\u0001\u0000\u0000\u0000`m\u0001\u0000\u0000"+
		"\u0000ab\u0003\u001c\u000e\u0000bi\u00054\u0000\u0000cd\u0005\u000b\u0000"+
		"\u0000de\u0003\u001c\u000e\u0000ef\u00054\u0000\u0000fh\u0001\u0000\u0000"+
		"\u0000gc\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001"+
		"\u0000\u0000\u0000l`\u0001\u0000\u0000\u0000la\u0001\u0000\u0000\u0000"+
		"m\u000f\u0001\u0000\u0000\u0000no\u0005\u000e\u0000\u0000op\u0005\u0004"+
		"\u0000\u0000pq\u0003\u0012\t\u0000qr\u0005\u0005\u0000\u0000rs\u0003\u0002"+
		"\u0001\u0000s\u0098\u0001\u0000\u0000\u0000tu\u0005\u000e\u0000\u0000"+
		"uv\u0005\u0004\u0000\u0000vw\u0003\u0012\t\u0000wx\u0005\u0005\u0000\u0000"+
		"xy\u0003\u0002\u0001\u0000yz\u0005\u000f\u0000\u0000z{\u0003\u0002\u0001"+
		"\u0000{\u0098\u0001\u0000\u0000\u0000|}\u0005\u0010\u0000\u0000}~\u0005"+
		"\u0004\u0000\u0000~\u007f\u0003\u0012\t\u0000\u007f\u0080\u0005\u0005"+
		"\u0000\u0000\u0080\u0081\u0003\u0002\u0001\u0000\u0081\u0098\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0005\u0011\u0000\u0000\u0083\u0084\u0005\u0004"+
		"\u0000\u0000\u0084\u0085\u0003\u0010\b\u0000\u0085\u0086\u0005\f\u0000"+
		"\u0000\u0086\u0087\u0003\u0012\t\u0000\u0087\u0088\u0005\f\u0000\u0000"+
		"\u0088\u0089\u0003\u0010\b\u0000\u0089\u008a\u0005\u0005\u0000\u0000\u008a"+
		"\u008b\u0003\u0002\u0001\u0000\u008b\u0098\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0005\u0011\u0000\u0000\u008d\u008e\u0005\u0004\u0000\u0000\u008e"+
		"\u008f\u0003\u001c\u000e\u0000\u008f\u0090\u00054\u0000\u0000\u0090\u0091"+
		"\u0005\n\u0000\u0000\u0091\u0092\u0003\u0012\t\u0000\u0092\u0093\u0005"+
		"\u0005\u0000\u0000\u0093\u0094\u0003\u0002\u0001\u0000\u0094\u0098\u0001"+
		"\u0000\u0000\u0000\u0095\u0098\u0003\u0014\n\u0000\u0096\u0098\u0003\u0016"+
		"\u000b\u0000\u0097n\u0001\u0000\u0000\u0000\u0097t\u0001\u0000\u0000\u0000"+
		"\u0097|\u0001\u0000\u0000\u0000\u0097\u0082\u0001\u0000\u0000\u0000\u0097"+
		"\u008c\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u0011\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0006\t\uffff\uffff\u0000\u009a\u009b\u0005\u0004\u0000\u0000\u009b"+
		"\u009c\u0003\u0012\t\u0000\u009c\u009d\u0005\u0005\u0000\u0000\u009d\u00ad"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0015\u0000\u0000\u009f\u00a0"+
		"\u00054\u0000\u0000\u00a0\u00a2\u0005\u0004\u0000\u0000\u00a1\u00a3\u0003"+
		"\u001a\r\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00ad\u0005\u0005"+
		"\u0000\u0000\u00a5\u00a6\u0005\u001b\u0000\u0000\u00a6\u00ad\u0003\u0012"+
		"\t\b\u00a7\u00a8\u0005\u0002\u0000\u0000\u00a8\u00a9\u0003\u001a\r\u0000"+
		"\u00a9\u00aa\u0005\u0003\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ad\u0003\"\u0011\u0000\u00ac\u0099\u0001\u0000\u0000\u0000\u00ac"+
		"\u009e\u0001\u0000\u0000\u0000\u00ac\u00a5\u0001\u0000\u0000\u0000\u00ac"+
		"\u00a7\u0001\u0000\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad"+
		"\u00d2\u0001\u0000\u0000\u0000\u00ae\u00af\n\u0007\u0000\u0000\u00af\u00b0"+
		"\u0007\u0000\u0000\u0000\u00b0\u00d1\u0003\u0012\t\b\u00b1\u00b2\n\u0006"+
		"\u0000\u0000\u00b2\u00b3\u0007\u0001\u0000\u0000\u00b3\u00d1\u0003\u0012"+
		"\t\u0007\u00b4\u00b5\n\u0005\u0000\u0000\u00b5\u00b6\u0007\u0002\u0000"+
		"\u0000\u00b6\u00d1\u0003\u0012\t\u0006\u00b7\u00b8\n\u0004\u0000\u0000"+
		"\u00b8\u00b9\u0007\u0003\u0000\u0000\u00b9\u00d1\u0003\u0012\t\u0005\u00ba"+
		"\u00bb\n\u0002\u0000\u0000\u00bb\u00bc\u0005\t\u0000\u0000\u00bc\u00bd"+
		"\u0003\u0012\t\u0000\u00bd\u00be\u0005\n\u0000\u0000\u00be\u00bf\u0003"+
		"\u0012\t\u0003\u00bf\u00d1\u0001\u0000\u0000\u0000\u00c0\u00c1\n\f\u0000"+
		"\u0000\u00c1\u00c2\u0005\b\u0000\u0000\u00c2\u00d1\u00054\u0000\u0000"+
		"\u00c3\u00c4\n\u000b\u0000\u0000\u00c4\u00c5\u0005\b\u0000\u0000\u00c5"+
		"\u00c6\u00054\u0000\u0000\u00c6\u00c8\u0005\u0004\u0000\u0000\u00c7\u00c9"+
		"\u0003\u001a\r\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00d1\u0005"+
		"\u0005\u0000\u0000\u00cb\u00cc\n\t\u0000\u0000\u00cc\u00cd\u0005\u0006"+
		"\u0000\u0000\u00cd\u00ce\u0003\u0012\t\u0000\u00ce\u00cf\u0005\u0007\u0000"+
		"\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00ae\u0001\u0000\u0000"+
		"\u0000\u00d0\u00b1\u0001\u0000\u0000\u0000\u00d0\u00b4\u0001\u0000\u0000"+
		"\u0000\u00d0\u00b7\u0001\u0000\u0000\u0000\u00d0\u00ba\u0001\u0000\u0000"+
		"\u0000\u00d0\u00c0\u0001\u0000\u0000\u0000\u00d0\u00c3\u0001\u0000\u0000"+
		"\u0000\u00d0\u00cb\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d3\u0013\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d7\u0005\u0013\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0003\u001c\u000e\u0000\u00d9\u00dc\u00054\u0000\u0000"+
		"\u00da\u00db\u0005\u0001\u0000\u0000\u00db\u00dd\u0003\u0012\t\u0000\u00dc"+
		"\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0005\f\u0000\u0000\u00df\u0015"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0003\u0018\f\u0000\u00e1\u00e2\u0005"+
		"\u0001\u0000\u0000\u00e2\u00e3\u0003\u0012\t\u0000\u00e3\u00e4\u0005\f"+
		"\u0000\u0000\u00e4\u0017\u0001\u0000\u0000\u0000\u00e5\u00e6\u0006\f\uffff"+
		"\uffff\u0000\u00e6\u00e7\u00054\u0000\u0000\u00e7\u00f2\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e9\n\u0002\u0000\u0000\u00e9\u00ea\u0005\b\u0000\u0000"+
		"\u00ea\u00f1\u00054\u0000\u0000\u00eb\u00ec\n\u0001\u0000\u0000\u00ec"+
		"\u00ed\u0005\u0006\u0000\u0000\u00ed\u00ee\u0003\u0012\t\u0000\u00ee\u00ef"+
		"\u0005\u0007\u0000\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u00e8"+
		"\u0001\u0000\u0000\u0000\u00f0\u00eb\u0001\u0000\u0000\u0000\u00f1\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f3\u0019\u0001\u0000\u0000\u0000\u00f4\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f5\u00fa\u0003\u0012\t\u0000\u00f6\u00f7\u0005"+
		"\u000b\u0000\u0000\u00f7\u00f9\u0003\u0012\t\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u001b\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fd\u00fe\u0006\u000e"+
		"\uffff\uffff\u0000\u00fe\u0101\u0003\u001e\u000f\u0000\u00ff\u0101\u0005"+
		"4\u0000\u0000\u0100\u00fd\u0001\u0000\u0000\u0000\u0100\u00ff\u0001\u0000"+
		"\u0000\u0000\u0101\u0107\u0001\u0000\u0000\u0000\u0102\u0103\n\u0001\u0000"+
		"\u0000\u0103\u0104\u0005\u0006\u0000\u0000\u0104\u0106\u0005\u0007\u0000"+
		"\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0106\u0109\u0001\u0000\u0000"+
		"\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000"+
		"\u0000\u0108\u001d\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000"+
		"\u0000\u010a\u010b\u0007\u0004\u0000\u0000\u010b\u001f\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0007\u0005\u0000\u0000\u010d!\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0007\u0006\u0000\u0000\u010f#\u0001\u0000\u0000\u0000\u0015"+
		"\'0;CGMil\u0097\u00a2\u00ac\u00c8\u00d0\u00d2\u00d6\u00dc\u00f0\u00f2"+
		"\u00fa\u0100\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}