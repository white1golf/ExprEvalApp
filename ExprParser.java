// Generated from Expr.g4 by ANTLR 4.5.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NEWLINE=9, 
		INT=10, ID=11, WS=12;
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_assn = 2;
	public static final String[] ruleNames = {
		"prog", "expr", "assn"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "NEWLINE", "INT", 
		"ID", "WS"
	};
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
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<AssnContext> assn() {
			return getRuleContexts(AssnContext.class);
		}
		public AssnContext assn(int i) {
			return getRuleContext(AssnContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExprParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExprParser.NEWLINE, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(16);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(6);
					assn();
					setState(7);
					match(T__0);
					setState(9);
					_la = _input.LA(1);
					if (_la==NEWLINE) {
						{
						setState(8);
						match(NEWLINE);
						}
					}

					}
					break;
				case 2:
					{
					setState(11);
					expr(0);
					setState(12);
					match(T__0);
					setState(14);
					_la = _input.LA(1);
					if (_la==NEWLINE) {
						{
						setState(13);
						match(NEWLINE);
						}
					}

					}
					break;
				}
				}
				setState(20);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpr(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(22);
				match(INT);
				}
				break;
			case ID:
				{
				setState(23);
				match(ID);
				}
				break;
			case T__5:
				{
				setState(24);
				match(T__5);
				setState(25);
				expr(0);
				setState(26);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(36);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(30);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(31);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__2) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(32);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(33);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(34);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(35);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class AssnContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public AssnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterAssn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitAssn(this);
		}
	}

	public final AssnContext assn() throws RecognitionException {
		AssnContext _localctx = new AssnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(ID);
			setState(42);
			match(T__7);
			setState(43);
			match(INT);
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
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16\60\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\5\2\f\n\2\3\2\3\2\3\2\5\2\21\n\2\7\2\23\n\2\f"+
		"\2\16\2\26\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\4\3\4\3\4\3\4\3\4\2\3\4\5\2\4\6\2"+
		"\4\3\2\4\5\3\2\6\7\64\2\24\3\2\2\2\4\36\3\2\2\2\6+\3\2\2\2\b\t\5\6\4\2"+
		"\t\13\7\3\2\2\n\f\7\13\2\2\13\n\3\2\2\2\13\f\3\2\2\2\f\23\3\2\2\2\r\16"+
		"\5\4\3\2\16\20\7\3\2\2\17\21\7\13\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\23"+
		"\3\2\2\2\22\b\3\2\2\2\22\r\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3"+
		"\2\2\2\25\3\3\2\2\2\26\24\3\2\2\2\27\30\b\3\1\2\30\37\7\f\2\2\31\37\7"+
		"\r\2\2\32\33\7\b\2\2\33\34\5\4\3\2\34\35\7\t\2\2\35\37\3\2\2\2\36\27\3"+
		"\2\2\2\36\31\3\2\2\2\36\32\3\2\2\2\37(\3\2\2\2 !\f\7\2\2!\"\t\2\2\2\""+
		"\'\5\4\3\b#$\f\6\2\2$%\t\3\2\2%\'\5\4\3\7& \3\2\2\2&#\3\2\2\2\'*\3\2\2"+
		"\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3\2\2\2+,\7\r\2\2,-\7\n\2\2-.\7\f"+
		"\2\2.\7\3\2\2\2\t\13\20\22\24\36&(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}