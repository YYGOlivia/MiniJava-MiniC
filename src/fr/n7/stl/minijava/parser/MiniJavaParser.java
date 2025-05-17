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
		Egal=1, AccoladeOuvrante=2, AccoladeFermante=3, ParentheseOuvrante=4, 
		ParentheseFermante=5, CrochetOuvrant=6, CrochetFermant=7, Point=8, PointInterrogation=9, 
		DeuxPoint=10, Virgule=11, PointVirgule=12, Afficher=13, Si=14, Sinon=15, 
		TantQue=16, Pour=17, Retour=18, DefinitionConstante=19, DefinitionClasse=20, 
		Nouveau=21, Ceci=22, Asterisque=23, Oblique=24, PourCent=25, Plus=26, 
		Moins=27, DoubleBarre=28, DoubleEsperluette=29, PointExclamation=30, Inf=31, 
		Sup=32, InfEg=33, SupEg=34, DoubleEgal=35, ExclamationEgal=36, Esperluette=37, 
		TypeEntier=38, TypeFlottant=39, TypeBooleen=40, TypeCaractere=41, TypeChaine=42, 
		TypeVide=43, Vrai=44, Faux=45, Nul=46, Caractere=47, Chaine=48, Publique=49, 
		Prive=50, Statique=51, Identificateur=52, Entier=53, Flottant=54, CommentaireLigne=55, 
		CommentaireBloc=56, WS=57;
	public static final int
		RULE_programme = 0, RULE_bloc = 1, RULE_classe = 2, RULE_membre = 3, RULE_attribut = 4, 
		RULE_constructeur = 5, RULE_methode = 6, RULE_parametres = 7, RULE_instruction = 8, 
		RULE_expression = 9, RULE_type = 10, RULE_identifiant = 11, RULE_atomique = 12, 
		RULE_modificateur = 13, RULE_expressionConstante = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"programme", "bloc", "classe", "membre", "attribut", "constructeur", 
			"methode", "parametres", "instruction", "expression", "type", "identifiant", 
			"atomique", "modificateur", "expressionConstante"
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
			null, "Egal", "AccoladeOuvrante", "AccoladeFermante", "ParentheseOuvrante", 
			"ParentheseFermante", "CrochetOuvrant", "CrochetFermant", "Point", "PointInterrogation", 
			"DeuxPoint", "Virgule", "PointVirgule", "Afficher", "Si", "Sinon", "TantQue", 
			"Pour", "Retour", "DefinitionConstante", "DefinitionClasse", "Nouveau", 
			"Ceci", "Asterisque", "Oblique", "PourCent", "Plus", "Moins", "DoubleBarre", 
			"DoubleEsperluette", "PointExclamation", "Inf", "Sup", "InfEg", "SupEg", 
			"DoubleEgal", "ExclamationEgal", "Esperluette", "TypeEntier", "TypeFlottant", 
			"TypeBooleen", "TypeCaractere", "TypeChaine", "TypeVide", "Vrai", "Faux", 
			"Nul", "Caractere", "Chaine", "Publique", "Prive", "Statique", "Identificateur", 
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DefinitionClasse) {
				{
				{
				setState(30);
				((ProgrammeContext)_localctx).classe = classe();
				((ProgrammeContext)_localctx).classes.add(((ProgrammeContext)_localctx).classe);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
			setState(38);
			match(AccoladeOuvrante);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 212992L) != 0)) {
				{
				{
				setState(39);
				((BlocContext)_localctx).instruction = instruction();
				((BlocContext)_localctx).instructions.add(((BlocContext)_localctx).instruction);
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
		public TerminalNode DefinitionClasse() { return getToken(MiniJavaParser.DefinitionClasse, 0); }
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
			setState(47);
			match(DefinitionClasse);
			setState(48);
			((ClasseContext)_localctx).nom = match(Identificateur);
			setState(49);
			match(AccoladeOuvrante);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3940649673949184L) != 0)) {
				{
				{
				setState(50);
				((ClasseContext)_localctx).membre = membre();
				((ClasseContext)_localctx).membres.add(((ClasseContext)_localctx).membre);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				attribut();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				constructeur();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
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
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode PointVirgule() { return getToken(MiniJavaParser.PointVirgule, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			modificateur();
			setState(64);
			type(0);
			setState(65);
			identifiant();
			setState(66);
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
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public ParametresContext parametres() {
			return getRuleContext(ParametresContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
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
			setState(68);
			modificateur();
			setState(69);
			((ConstructeurContext)_localctx).nom = match(Identificateur);
			setState(70);
			match(ParentheseOuvrante);
			setState(71);
			parametres();
			setState(72);
			match(ParentheseFermante);
			setState(73);
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
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public ParametresContext parametres() {
			return getRuleContext(ParametresContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
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
			setState(75);
			modificateur();
			setState(76);
			type(0);
			setState(77);
			((MethodeContext)_localctx).nom = match(Identificateur);
			setState(78);
			match(ParentheseOuvrante);
			setState(79);
			parametres();
			setState(80);
			match(ParentheseFermante);
			setState(81);
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
		public IdentifiantContext identifiant;
		public List<IdentifiantContext> suiteIdent = new ArrayList<IdentifiantContext>();
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifiantContext> identifiant() {
			return getRuleContexts(IdentifiantContext.class);
		}
		public IdentifiantContext identifiant(int i) {
			return getRuleContext(IdentifiantContext.class,i);
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
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ParentheseFermante:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ParentheseOuvrante:
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
			case Identificateur:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				type(0);
				setState(85);
				identifiant();
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Virgule) {
					{
					{
					setState(86);
					match(Virgule);
					setState(87);
					((ParametresContext)_localctx).type = type(0);
					((ParametresContext)_localctx).suiteType.add(((ParametresContext)_localctx).type);
					setState(88);
					((ParametresContext)_localctx).identifiant = identifiant();
					((ParametresContext)_localctx).suiteIdent.add(((ParametresContext)_localctx).identifiant);
					}
					}
					setState(94);
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
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
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
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode DeuxPoint() { return getToken(MiniJavaParser.DeuxPoint, 0); }
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
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(Si);
				setState(98);
				match(ParentheseOuvrante);
				setState(99);
				expression(0);
				setState(100);
				match(ParentheseFermante);
				setState(101);
				((InstructionContext)_localctx).alors = bloc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(Si);
				setState(104);
				match(ParentheseOuvrante);
				setState(105);
				expression(0);
				setState(106);
				match(ParentheseFermante);
				setState(107);
				((InstructionContext)_localctx).alors = bloc();
				setState(108);
				match(Sinon);
				setState(109);
				((InstructionContext)_localctx).sinon = bloc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(TantQue);
				setState(112);
				match(ParentheseOuvrante);
				setState(113);
				expression(0);
				setState(114);
				match(ParentheseFermante);
				setState(115);
				((InstructionContext)_localctx).body = bloc();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				match(Pour);
				setState(118);
				match(ParentheseOuvrante);
				setState(119);
				instruction();
				setState(120);
				match(PointVirgule);
				setState(121);
				expression(0);
				setState(122);
				match(PointVirgule);
				setState(123);
				instruction();
				setState(124);
				match(ParentheseFermante);
				setState(125);
				((InstructionContext)_localctx).body = bloc();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				match(Pour);
				setState(128);
				match(ParentheseOuvrante);
				setState(129);
				type(0);
				setState(130);
				identifiant();
				setState(131);
				match(DeuxPoint);
				setState(132);
				expression(0);
				setState(133);
				match(ParentheseFermante);
				setState(134);
				((InstructionContext)_localctx).body = bloc();
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
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
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
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode CrochetOuvrant() { return getToken(MiniJavaParser.CrochetOuvrant, 0); }
		public TerminalNode CrochetFermant() { return getToken(MiniJavaParser.CrochetFermant, 0); }
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
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ParentheseOuvrante:
				{
				setState(139);
				match(ParentheseOuvrante);
				setState(140);
				expression(0);
				setState(141);
				match(ParentheseFermante);
				}
				break;
			case Moins:
				{
				setState(143);
				match(Moins);
				setState(144);
				expression(8);
				}
				break;
			case AccoladeOuvrante:
				{
				setState(145);
				match(AccoladeOuvrante);
				setState(146);
				expression(0);
				setState(147);
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
				setState(149);
				expressionConstante();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(153);
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
						setState(154);
						((ExpressionContext)_localctx).droite = expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(156);
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
						setState(157);
						((ExpressionContext)_localctx).droite = expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(159);
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
						setState(160);
						((ExpressionContext)_localctx).droite = expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(162);
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
						setState(163);
						((ExpressionContext)_localctx).droite = expression(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165);
						match(PointInterrogation);
						setState(166);
						expression(0);
						setState(167);
						match(DeuxPoint);
						setState(168);
						expression(3);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(171);
						match(Point);
						setState(172);
						match(Identificateur);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(174);
						match(CrochetOuvrant);
						setState(175);
						expression(0);
						setState(176);
						match(CrochetFermant);
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
	public static class TypeContext extends ParserRuleContext {
		public AtomiqueContext atomique() {
			return getRuleContext(AtomiqueContext.class,0);
		}
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CrochetOuvrant() { return getToken(MiniJavaParser.CrochetOuvrant, 0); }
		public TerminalNode CrochetFermant() { return getToken(MiniJavaParser.CrochetFermant, 0); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
				{
				setState(184);
				atomique();
				}
				break;
			case ParentheseOuvrante:
			case Identificateur:
				{
				setState(185);
				identifiant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(188);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(189);
					match(CrochetOuvrant);
					setState(190);
					match(CrochetFermant);
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
	public static class IdentifiantContext extends ParserRuleContext {
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
		public IdentifiantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterIdentifiant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitIdentifiant(this);
		}
	}

	public final IdentifiantContext identifiant() throws RecognitionException {
		IdentifiantContext _localctx = new IdentifiantContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_identifiant);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identificateur:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(Identificateur);
				}
				break;
			case ParentheseOuvrante:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(ParentheseOuvrante);
				setState(198);
				identifiant();
				setState(199);
				match(ParentheseFermante);
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
		enterRule(_localctx, 24, RULE_atomique);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
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
		enterRule(_localctx, 26, RULE_modificateur);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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
		enterRule(_localctx, 28, RULE_expressionConstante);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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
		case 10:
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
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u00d2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0005\u0001)\b\u0001\n\u0001\f\u0001,\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"4\b\u0002\n\u0002\f\u00027\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003>\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007[\b\u0007\n\u0007\f\u0007^\t\u0007\u0003\u0007"+
		"`\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0089\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u0097\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u00b3\b\t\n\t\f\t\u00b6\t\t\u0001\n\u0001\n\u0001\n"+
		"\u0003\n\u00bb\b\n\u0001\n\u0001\n\u0001\n\u0005\n\u00c0\b\n\n\n\f\n\u00c3"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00ca\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0000\u0002\u0012\u0014\u000f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0007\u0001"+
		"\u0000\u0017\u0019\u0001\u0000\u001a\u001b\u0001\u0000\u001f\"\u0001\u0000"+
		"#$\u0001\u0000&+\u0001\u000013\u0002\u0000,046\u00da\u0000!\u0001\u0000"+
		"\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000"+
		"\u0006=\u0001\u0000\u0000\u0000\b?\u0001\u0000\u0000\u0000\nD\u0001\u0000"+
		"\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000e_\u0001\u0000\u0000\u0000"+
		"\u0010\u0088\u0001\u0000\u0000\u0000\u0012\u0096\u0001\u0000\u0000\u0000"+
		"\u0014\u00ba\u0001\u0000\u0000\u0000\u0016\u00c9\u0001\u0000\u0000\u0000"+
		"\u0018\u00cb\u0001\u0000\u0000\u0000\u001a\u00cd\u0001\u0000\u0000\u0000"+
		"\u001c\u00cf\u0001\u0000\u0000\u0000\u001e \u0003\u0004\u0002\u0000\u001f"+
		"\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001\u0000%\u0001\u0001\u0000"+
		"\u0000\u0000&*\u0005\u0002\u0000\u0000\')\u0003\u0010\b\u0000(\'\u0001"+
		"\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000-.\u0005\u0003\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0005"+
		"\u0014\u0000\u000001\u00054\u0000\u000015\u0005\u0002\u0000\u000024\u0003"+
		"\u0006\u0003\u000032\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u000089\u0005\u0003\u0000\u00009\u0005\u0001"+
		"\u0000\u0000\u0000:>\u0003\b\u0004\u0000;>\u0003\n\u0005\u0000<>\u0003"+
		"\f\u0006\u0000=:\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=<\u0001"+
		"\u0000\u0000\u0000>\u0007\u0001\u0000\u0000\u0000?@\u0003\u001a\r\u0000"+
		"@A\u0003\u0014\n\u0000AB\u0003\u0016\u000b\u0000BC\u0005\f\u0000\u0000"+
		"C\t\u0001\u0000\u0000\u0000DE\u0003\u001a\r\u0000EF\u00054\u0000\u0000"+
		"FG\u0005\u0004\u0000\u0000GH\u0003\u000e\u0007\u0000HI\u0005\u0005\u0000"+
		"\u0000IJ\u0003\u0002\u0001\u0000J\u000b\u0001\u0000\u0000\u0000KL\u0003"+
		"\u001a\r\u0000LM\u0003\u0014\n\u0000MN\u00054\u0000\u0000NO\u0005\u0004"+
		"\u0000\u0000OP\u0003\u000e\u0007\u0000PQ\u0005\u0005\u0000\u0000QR\u0003"+
		"\u0002\u0001\u0000R\r\u0001\u0000\u0000\u0000S`\u0001\u0000\u0000\u0000"+
		"TU\u0003\u0014\n\u0000U\\\u0003\u0016\u000b\u0000VW\u0005\u000b\u0000"+
		"\u0000WX\u0003\u0014\n\u0000XY\u0003\u0016\u000b\u0000Y[\u0001\u0000\u0000"+
		"\u0000ZV\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000_S\u0001\u0000\u0000\u0000_T\u0001\u0000\u0000\u0000"+
		"`\u000f\u0001\u0000\u0000\u0000ab\u0005\u000e\u0000\u0000bc\u0005\u0004"+
		"\u0000\u0000cd\u0003\u0012\t\u0000de\u0005\u0005\u0000\u0000ef\u0003\u0002"+
		"\u0001\u0000f\u0089\u0001\u0000\u0000\u0000gh\u0005\u000e\u0000\u0000"+
		"hi\u0005\u0004\u0000\u0000ij\u0003\u0012\t\u0000jk\u0005\u0005\u0000\u0000"+
		"kl\u0003\u0002\u0001\u0000lm\u0005\u000f\u0000\u0000mn\u0003\u0002\u0001"+
		"\u0000n\u0089\u0001\u0000\u0000\u0000op\u0005\u0010\u0000\u0000pq\u0005"+
		"\u0004\u0000\u0000qr\u0003\u0012\t\u0000rs\u0005\u0005\u0000\u0000st\u0003"+
		"\u0002\u0001\u0000t\u0089\u0001\u0000\u0000\u0000uv\u0005\u0011\u0000"+
		"\u0000vw\u0005\u0004\u0000\u0000wx\u0003\u0010\b\u0000xy\u0005\f\u0000"+
		"\u0000yz\u0003\u0012\t\u0000z{\u0005\f\u0000\u0000{|\u0003\u0010\b\u0000"+
		"|}\u0005\u0005\u0000\u0000}~\u0003\u0002\u0001\u0000~\u0089\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005\u0011\u0000\u0000\u0080\u0081\u0005\u0004"+
		"\u0000\u0000\u0081\u0082\u0003\u0014\n\u0000\u0082\u0083\u0003\u0016\u000b"+
		"\u0000\u0083\u0084\u0005\n\u0000\u0000\u0084\u0085\u0003\u0012\t\u0000"+
		"\u0085\u0086\u0005\u0005\u0000\u0000\u0086\u0087\u0003\u0002\u0001\u0000"+
		"\u0087\u0089\u0001\u0000\u0000\u0000\u0088a\u0001\u0000\u0000\u0000\u0088"+
		"g\u0001\u0000\u0000\u0000\u0088o\u0001\u0000\u0000\u0000\u0088u\u0001"+
		"\u0000\u0000\u0000\u0088\u007f\u0001\u0000\u0000\u0000\u0089\u0011\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0006\t\uffff\uffff\u0000\u008b\u008c\u0005"+
		"\u0004\u0000\u0000\u008c\u008d\u0003\u0012\t\u0000\u008d\u008e\u0005\u0005"+
		"\u0000\u0000\u008e\u0097\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u001b"+
		"\u0000\u0000\u0090\u0097\u0003\u0012\t\b\u0091\u0092\u0005\u0002\u0000"+
		"\u0000\u0092\u0093\u0003\u0012\t\u0000\u0093\u0094\u0005\u0003\u0000\u0000"+
		"\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0097\u0003\u001c\u000e\u0000"+
		"\u0096\u008a\u0001\u0000\u0000\u0000\u0096\u008f\u0001\u0000\u0000\u0000"+
		"\u0096\u0091\u0001\u0000\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u00b4\u0001\u0000\u0000\u0000\u0098\u0099\n\u0007\u0000\u0000\u0099"+
		"\u009a\u0007\u0000\u0000\u0000\u009a\u00b3\u0003\u0012\t\b\u009b\u009c"+
		"\n\u0006\u0000\u0000\u009c\u009d\u0007\u0001\u0000\u0000\u009d\u00b3\u0003"+
		"\u0012\t\u0007\u009e\u009f\n\u0005\u0000\u0000\u009f\u00a0\u0007\u0002"+
		"\u0000\u0000\u00a0\u00b3\u0003\u0012\t\u0006\u00a1\u00a2\n\u0004\u0000"+
		"\u0000\u00a2\u00a3\u0007\u0003\u0000\u0000\u00a3\u00b3\u0003\u0012\t\u0005"+
		"\u00a4\u00a5\n\u0002\u0000\u0000\u00a5\u00a6\u0005\t\u0000\u0000\u00a6"+
		"\u00a7\u0003\u0012\t\u0000\u00a7\u00a8\u0005\n\u0000\u0000\u00a8\u00a9"+
		"\u0003\u0012\t\u0003\u00a9\u00b3\u0001\u0000\u0000\u0000\u00aa\u00ab\n"+
		"\n\u0000\u0000\u00ab\u00ac\u0005\b\u0000\u0000\u00ac\u00b3\u00054\u0000"+
		"\u0000\u00ad\u00ae\n\t\u0000\u0000\u00ae\u00af\u0005\u0006\u0000\u0000"+
		"\u00af\u00b0\u0003\u0012\t\u0000\u00b0\u00b1\u0005\u0007\u0000\u0000\u00b1"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b2\u0098\u0001\u0000\u0000\u0000\u00b2"+
		"\u009b\u0001\u0000\u0000\u0000\u00b2\u009e\u0001\u0000\u0000\u0000\u00b2"+
		"\u00a1\u0001\u0000\u0000\u0000\u00b2\u00a4\u0001\u0000\u0000\u0000\u00b2"+
		"\u00aa\u0001\u0000\u0000\u0000\u00b2\u00ad\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b5\u0013\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b8\u0006\n\uffff\uffff\u0000\u00b8"+
		"\u00bb\u0003\u0018\f\u0000\u00b9\u00bb\u0003\u0016\u000b\u0000\u00ba\u00b7"+
		"\u0001\u0000\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00c1"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bd\n\u0001\u0000\u0000\u00bd\u00be\u0005"+
		"\u0006\u0000\u0000\u00be\u00c0\u0005\u0007\u0000\u0000\u00bf\u00bc\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u0015\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00ca\u0005"+
		"4\u0000\u0000\u00c5\u00c6\u0005\u0004\u0000\u0000\u00c6\u00c7\u0003\u0016"+
		"\u000b\u0000\u00c7\u00c8\u0005\u0005\u0000\u0000\u00c8\u00ca\u0001\u0000"+
		"\u0000\u0000\u00c9\u00c4\u0001\u0000\u0000\u0000\u00c9\u00c5\u0001\u0000"+
		"\u0000\u0000\u00ca\u0017\u0001\u0000\u0000\u0000\u00cb\u00cc\u0007\u0004"+
		"\u0000\u0000\u00cc\u0019\u0001\u0000\u0000\u0000\u00cd\u00ce\u0007\u0005"+
		"\u0000\u0000\u00ce\u001b\u0001\u0000\u0000\u0000\u00cf\u00d0\u0007\u0006"+
		"\u0000\u0000\u00d0\u001d\u0001\u0000\u0000\u0000\r!*5=\\_\u0088\u0096"+
		"\u00b2\u00b4\u00ba\u00c1\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}