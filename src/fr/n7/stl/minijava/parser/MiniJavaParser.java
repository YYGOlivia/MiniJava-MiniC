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
		Nouveau=21, Asterisque=22, Oblique=23, PourCent=24, Plus=25, Moins=26, 
		DoubleBarre=27, DoubleEsperluette=28, PointExclamation=29, Inferieur=30, 
		Superieur=31, InferieurEgal=32, SuperieurEgal=33, DoubleEgal=34, ExclamationEgal=35, 
		Esperluette=36, TypeEntier=37, TypeFlottant=38, TypeBooleen=39, TypeCaractere=40, 
		TypeChaine=41, TypeVide=42, Vrai=43, Faux=44, Nul=45, Caractere=46, Chaine=47, 
		Publique=48, Prive=49, Statique=50, Identificateur=51, Entier=52, Flottant=53, 
		CommentaireLigne=54, CommentaireBloc=55, WS=56;
	public static final int
		RULE_programme = 0, RULE_block = 1, RULE_classe = 2, RULE_membre = 3, 
		RULE_attribut = 4, RULE_methode = 5, RULE_parametres = 6, RULE_instruction = 7, 
		RULE_expressionBinaire = 8, RULE_expression = 9, RULE_atomique = 10, RULE_type = 11, 
		RULE_identifiant = 12, RULE_visibilites = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"programme", "block", "classe", "membre", "attribut", "methode", "parametres", 
			"instruction", "expressionBinaire", "expression", "atomique", "type", 
			"identifiant", "visibilites"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'{'", "'}'", "'('", "')'", "'['", "']'", "'.'", "'?'", 
			"':'", "','", "';'", "'print'", "'if'", "'else'", "'while'", "'for'", 
			"'return'", "'final'", "'class'", "'new'", "'*'", "'/'", "'%'", "'+'", 
			"'-'", "'||'", "'&&'", "'!'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", 
			"'&'", "'int'", "'float'", "'boolean'", "'char'", "'String'", "'void'", 
			"'true'", "'false'", "'null'", null, null, "'public'", "'private'", "'static'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Egal", "AccoladeOuvrante", "AccoladeFermante", "ParentheseOuvrante", 
			"ParentheseFermante", "CrochetOuvrant", "CrochetFermant", "Point", "PointInterrogation", 
			"DeuxPoint", "Virgule", "PointVirgule", "Afficher", "Si", "Sinon", "TantQue", 
			"Pour", "Retour", "DefinitionConstante", "DefinitionClasse", "Nouveau", 
			"Asterisque", "Oblique", "PourCent", "Plus", "Moins", "DoubleBarre", 
			"DoubleEsperluette", "PointExclamation", "Inferieur", "Superieur", "InferieurEgal", 
			"SuperieurEgal", "DoubleEgal", "ExclamationEgal", "Esperluette", "TypeEntier", 
			"TypeFlottant", "TypeBooleen", "TypeCaractere", "TypeChaine", "TypeVide", 
			"Vrai", "Faux", "Nul", "Caractere", "Chaine", "Publique", "Prive", "Statique", 
			"Identificateur", "Entier", "Flottant", "CommentaireLigne", "CommentaireBloc", 
			"WS"
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DefinitionClasse) {
				{
				{
				setState(28);
				((ProgrammeContext)_localctx).classe = classe();
				((ProgrammeContext)_localctx).classes.add(((ProgrammeContext)_localctx).classe);
				}
				}
				setState(33);
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
	public static class BlockContext extends ParserRuleContext {
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
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(AccoladeOuvrante);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Si || _la==TantQue) {
				{
				{
				setState(35);
				((BlockContext)_localctx).instruction = instruction();
				((BlockContext)_localctx).instructions.add(((BlockContext)_localctx).instruction);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
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
			setState(43);
			match(DefinitionClasse);
			setState(44);
			((ClasseContext)_localctx).nom = match(Identificateur);
			setState(45);
			match(AccoladeOuvrante);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1970324836974592L) != 0)) {
				{
				{
				setState(46);
				((ClasseContext)_localctx).membre = membre();
				((ClasseContext)_localctx).membres.add(((ClasseContext)_localctx).membre);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
		public VisibilitesContext visibilites() {
			return getRuleContext(VisibilitesContext.class,0);
		}
		public MethodeContext methode() {
			return getRuleContext(MethodeContext.class,0);
		}
		public AttributContext attribut() {
			return getRuleContext(AttributContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			visibilites();
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(55);
				methode();
				}
				break;
			case 2:
				{
				setState(56);
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
	public static class AttributContext extends ParserRuleContext {
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
			setState(59);
			type();
			setState(60);
			identifiant(0);
			setState(61);
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
	public static class MethodeContext extends ParserRuleContext {
		public Token nom;
		public BlockContext bloc;
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public ParametresContext parametres() {
			return getRuleContext(ParametresContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 10, RULE_methode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			((MethodeContext)_localctx).nom = match(Identificateur);
			setState(64);
			match(ParentheseOuvrante);
			setState(65);
			parametres();
			setState(66);
			match(ParentheseFermante);
			setState(67);
			((MethodeContext)_localctx).bloc = block();
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
		enterRule(_localctx, 12, RULE_parametres);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			type();
			setState(70);
			identifiant(0);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Virgule) {
				{
				{
				setState(71);
				match(Virgule);
				setState(72);
				((ParametresContext)_localctx).type = type();
				((ParametresContext)_localctx).suiteType.add(((ParametresContext)_localctx).type);
				setState(73);
				((ParametresContext)_localctx).identifiant = identifiant(0);
				((ParametresContext)_localctx).suiteIdent.add(((ParametresContext)_localctx).identifiant);
				}
				}
				setState(79);
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
	public static class InstructionContext extends ParserRuleContext {
		public BlockContext alors;
		public BlockContext sinon;
		public BlockContext body;
		public TerminalNode Si() { return getToken(MiniJavaParser.Si, 0); }
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Sinon() { return getToken(MiniJavaParser.Sinon, 0); }
		public TerminalNode TantQue() { return getToken(MiniJavaParser.TantQue, 0); }
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
		enterRule(_localctx, 14, RULE_instruction);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(Si);
				setState(81);
				match(ParentheseOuvrante);
				setState(82);
				expression();
				setState(83);
				match(ParentheseFermante);
				setState(84);
				((InstructionContext)_localctx).alors = block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(Si);
				setState(87);
				match(ParentheseOuvrante);
				setState(88);
				expression();
				setState(89);
				match(ParentheseFermante);
				setState(90);
				((InstructionContext)_localctx).alors = block();
				setState(91);
				match(Sinon);
				setState(92);
				((InstructionContext)_localctx).sinon = block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(TantQue);
				setState(95);
				match(ParentheseOuvrante);
				setState(96);
				expression();
				setState(97);
				match(ParentheseFermante);
				setState(98);
				((InstructionContext)_localctx).body = block();
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
	public static class ExpressionBinaireContext extends ParserRuleContext {
		public ExpressionContext gauche;
		public Token op;
		public ExpressionContext droite;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Asterisque() { return getToken(MiniJavaParser.Asterisque, 0); }
		public TerminalNode Oblique() { return getToken(MiniJavaParser.Oblique, 0); }
		public TerminalNode PourCent() { return getToken(MiniJavaParser.PourCent, 0); }
		public TerminalNode Plus() { return getToken(MiniJavaParser.Plus, 0); }
		public TerminalNode Moins() { return getToken(MiniJavaParser.Moins, 0); }
		public TerminalNode Inferieur() { return getToken(MiniJavaParser.Inferieur, 0); }
		public TerminalNode Superieur() { return getToken(MiniJavaParser.Superieur, 0); }
		public TerminalNode InferieurEgal() { return getToken(MiniJavaParser.InferieurEgal, 0); }
		public TerminalNode SuperieurEgal() { return getToken(MiniJavaParser.SuperieurEgal, 0); }
		public ExpressionBinaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionBinaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExpressionBinaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExpressionBinaire(this);
		}
	}

	public final ExpressionBinaireContext expressionBinaire() throws RecognitionException {
		ExpressionBinaireContext _localctx = new ExpressionBinaireContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressionBinaire);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((ExpressionBinaireContext)_localctx).gauche = expression();
				setState(103);
				((ExpressionBinaireContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) ) {
					((ExpressionBinaireContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(104);
				((ExpressionBinaireContext)_localctx).droite = expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				((ExpressionBinaireContext)_localctx).gauche = expression();
				setState(107);
				((ExpressionBinaireContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Moins) ) {
					((ExpressionBinaireContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(108);
				((ExpressionBinaireContext)_localctx).droite = expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				((ExpressionBinaireContext)_localctx).gauche = expression();
				setState(111);
				((ExpressionBinaireContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
					((ExpressionBinaireContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(112);
				((ExpressionBinaireContext)_localctx).droite = expression();
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
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
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
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(ParentheseOuvrante);
			setState(117);
			expression();
			setState(118);
			match(ParentheseFermante);
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
		enterRule(_localctx, 20, RULE_atomique);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
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
	public static class TypeContext extends ParserRuleContext {
		public AtomiqueContext atomique() {
			return getRuleContext(AtomiqueContext.class,0);
		}
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
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
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				atomique();
				}
				break;
			case ParentheseOuvrante:
			case Asterisque:
			case Identificateur:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				identifiant(0);
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
	public static class IdentifiantContext extends ParserRuleContext {
		public TerminalNode Identificateur() { return getToken(MiniJavaParser.Identificateur, 0); }
		public TerminalNode Asterisque() { return getToken(MiniJavaParser.Asterisque, 0); }
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode ParentheseOuvrante() { return getToken(MiniJavaParser.ParentheseOuvrante, 0); }
		public TerminalNode ParentheseFermante() { return getToken(MiniJavaParser.ParentheseFermante, 0); }
		public TerminalNode CrochetOuvrant() { return getToken(MiniJavaParser.CrochetOuvrant, 0); }
		public TerminalNode CrochetFermant() { return getToken(MiniJavaParser.CrochetFermant, 0); }
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
		return identifiant(0);
	}

	private IdentifiantContext identifiant(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdentifiantContext _localctx = new IdentifiantContext(_ctx, _parentState);
		IdentifiantContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_identifiant, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identificateur:
				{
				setState(127);
				match(Identificateur);
				}
				break;
			case Asterisque:
				{
				setState(128);
				match(Asterisque);
				setState(129);
				identifiant(2);
				}
				break;
			case ParentheseOuvrante:
				{
				setState(130);
				match(ParentheseOuvrante);
				setState(131);
				identifiant(0);
				setState(132);
				match(ParentheseFermante);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IdentifiantContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_identifiant);
					setState(136);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(137);
					match(CrochetOuvrant);
					setState(138);
					match(CrochetFermant);
					}
					} 
				}
				setState(143);
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
	public static class VisibilitesContext extends ParserRuleContext {
		public TerminalNode Publique() { return getToken(MiniJavaParser.Publique, 0); }
		public TerminalNode Prive() { return getToken(MiniJavaParser.Prive, 0); }
		public TerminalNode Statique() { return getToken(MiniJavaParser.Statique, 0); }
		public VisibilitesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibilites; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterVisibilites(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitVisibilites(this);
		}
	}

	public final VisibilitesContext visibilites() throws RecognitionException {
		VisibilitesContext _localctx = new VisibilitesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_visibilites);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1970324836974592L) != 0)) ) {
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
		case 12:
			return identifiant_sempred((IdentifiantContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean identifiant_sempred(IdentifiantContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u0093\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001e\b\u0000\n\u0000"+
		"\f\u0000!\t\u0000\u0001\u0001\u0001\u0001\u0005\u0001%\b\u0001\n\u0001"+
		"\f\u0001(\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u00020\b\u0002\n\u0002\f\u00023\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003:\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006L\b"+
		"\u0006\n\u0006\f\u0006O\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007e\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bs\b\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003\u000b}\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0087\b\f\u0001\f\u0001\f\u0001\f\u0005\f\u008c\b\f\n\f\f\f\u008f\t"+
		"\f\u0001\r\u0001\r\u0001\r\u0000\u0001\u0018\u000e\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0005\u0001\u0000"+
		"\u0016\u0018\u0001\u0000\u0019\u001a\u0001\u0000\u001e!\u0001\u0000%*"+
		"\u0001\u000002\u0091\u0000\u001f\u0001\u0000\u0000\u0000\u0002\"\u0001"+
		"\u0000\u0000\u0000\u0004+\u0001\u0000\u0000\u0000\u00066\u0001\u0000\u0000"+
		"\u0000\b;\u0001\u0000\u0000\u0000\n?\u0001\u0000\u0000\u0000\fE\u0001"+
		"\u0000\u0000\u0000\u000ed\u0001\u0000\u0000\u0000\u0010r\u0001\u0000\u0000"+
		"\u0000\u0012t\u0001\u0000\u0000\u0000\u0014x\u0001\u0000\u0000\u0000\u0016"+
		"|\u0001\u0000\u0000\u0000\u0018\u0086\u0001\u0000\u0000\u0000\u001a\u0090"+
		"\u0001\u0000\u0000\u0000\u001c\u001e\u0003\u0004\u0002\u0000\u001d\u001c"+
		"\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001"+
		"\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0001\u0001\u0000\u0000"+
		"\u0000!\u001f\u0001\u0000\u0000\u0000\"&\u0005\u0002\u0000\u0000#%\u0003"+
		"\u000e\u0007\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000"+
		"\u0000(&\u0001\u0000\u0000\u0000)*\u0005\u0003\u0000\u0000*\u0003\u0001"+
		"\u0000\u0000\u0000+,\u0005\u0014\u0000\u0000,-\u00053\u0000\u0000-1\u0005"+
		"\u0002\u0000\u0000.0\u0003\u0006\u0003\u0000/.\u0001\u0000\u0000\u0000"+
		"03\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000"+
		"\u000024\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000045\u0005\u0003"+
		"\u0000\u00005\u0005\u0001\u0000\u0000\u000069\u0003\u001a\r\u00007:\u0003"+
		"\n\u0005\u00008:\u0003\b\u0004\u000097\u0001\u0000\u0000\u000098\u0001"+
		"\u0000\u0000\u0000:\u0007\u0001\u0000\u0000\u0000;<\u0003\u0016\u000b"+
		"\u0000<=\u0003\u0018\f\u0000=>\u0005\f\u0000\u0000>\t\u0001\u0000\u0000"+
		"\u0000?@\u00053\u0000\u0000@A\u0005\u0004\u0000\u0000AB\u0003\f\u0006"+
		"\u0000BC\u0005\u0005\u0000\u0000CD\u0003\u0002\u0001\u0000D\u000b\u0001"+
		"\u0000\u0000\u0000EF\u0003\u0016\u000b\u0000FM\u0003\u0018\f\u0000GH\u0005"+
		"\u000b\u0000\u0000HI\u0003\u0016\u000b\u0000IJ\u0003\u0018\f\u0000JL\u0001"+
		"\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\r\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000PQ\u0005\u000e\u0000\u0000QR\u0005\u0004"+
		"\u0000\u0000RS\u0003\u0012\t\u0000ST\u0005\u0005\u0000\u0000TU\u0003\u0002"+
		"\u0001\u0000Ue\u0001\u0000\u0000\u0000VW\u0005\u000e\u0000\u0000WX\u0005"+
		"\u0004\u0000\u0000XY\u0003\u0012\t\u0000YZ\u0005\u0005\u0000\u0000Z[\u0003"+
		"\u0002\u0001\u0000[\\\u0005\u000f\u0000\u0000\\]\u0003\u0002\u0001\u0000"+
		"]e\u0001\u0000\u0000\u0000^_\u0005\u0010\u0000\u0000_`\u0005\u0004\u0000"+
		"\u0000`a\u0003\u0012\t\u0000ab\u0005\u0005\u0000\u0000bc\u0003\u0002\u0001"+
		"\u0000ce\u0001\u0000\u0000\u0000dP\u0001\u0000\u0000\u0000dV\u0001\u0000"+
		"\u0000\u0000d^\u0001\u0000\u0000\u0000e\u000f\u0001\u0000\u0000\u0000"+
		"fg\u0003\u0012\t\u0000gh\u0007\u0000\u0000\u0000hi\u0003\u0012\t\u0000"+
		"is\u0001\u0000\u0000\u0000jk\u0003\u0012\t\u0000kl\u0007\u0001\u0000\u0000"+
		"lm\u0003\u0012\t\u0000ms\u0001\u0000\u0000\u0000no\u0003\u0012\t\u0000"+
		"op\u0007\u0002\u0000\u0000pq\u0003\u0012\t\u0000qs\u0001\u0000\u0000\u0000"+
		"rf\u0001\u0000\u0000\u0000rj\u0001\u0000\u0000\u0000rn\u0001\u0000\u0000"+
		"\u0000s\u0011\u0001\u0000\u0000\u0000tu\u0005\u0004\u0000\u0000uv\u0003"+
		"\u0012\t\u0000vw\u0005\u0005\u0000\u0000w\u0013\u0001\u0000\u0000\u0000"+
		"xy\u0007\u0003\u0000\u0000y\u0015\u0001\u0000\u0000\u0000z}\u0003\u0014"+
		"\n\u0000{}\u0003\u0018\f\u0000|z\u0001\u0000\u0000\u0000|{\u0001\u0000"+
		"\u0000\u0000}\u0017\u0001\u0000\u0000\u0000~\u007f\u0006\f\uffff\uffff"+
		"\u0000\u007f\u0087\u00053\u0000\u0000\u0080\u0081\u0005\u0016\u0000\u0000"+
		"\u0081\u0087\u0003\u0018\f\u0002\u0082\u0083\u0005\u0004\u0000\u0000\u0083"+
		"\u0084\u0003\u0018\f\u0000\u0084\u0085\u0005\u0005\u0000\u0000\u0085\u0087"+
		"\u0001\u0000\u0000\u0000\u0086~\u0001\u0000\u0000\u0000\u0086\u0080\u0001"+
		"\u0000\u0000\u0000\u0086\u0082\u0001\u0000\u0000\u0000\u0087\u008d\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\n\u0003\u0000\u0000\u0089\u008a\u0005\u0006"+
		"\u0000\u0000\u008a\u008c\u0005\u0007\u0000\u0000\u008b\u0088\u0001\u0000"+
		"\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0019\u0001\u0000"+
		"\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0007\u0004"+
		"\u0000\u0000\u0091\u001b\u0001\u0000\u0000\u0000\n\u001f&19Mdr|\u0086"+
		"\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}