import ws.Perceptions;

/**
 * Wumpus Agents Knowledge Base.
 *
 * @author   Marco Antonio Costa Simoes <a href="mailto:msimoes@uneb.br">msimoes@uneb.br</a>
 * @version  1.0, 2012.
 *
 * Aqui temos a descri��o das regras da base deconhecimento dos agentes do Mundo do Wumpus.
 */

  class Jeops_RuleBase_WumpusKB extends jeops.AbstractRuleBase {

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    
    /*
   rule NOME REGRA{
	declarations
            Perceptions p;
            WumpusExplorer e;
	conditions
            CONDICOES
	actions
            ACOES
    } */		
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    

  
    /**
     * Identifiers of rule fugir
     */
    private String[] identifiers_fugir = {
        "p",
        "e"
    };

    /**
     * Returns the identifiers declared in rule fugir
     *
     * @return the identifiers declared in rule fugir
     */
    private String[] getDeclaredIdentifiers_fugir() {
         return identifiers_fugir;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule fugir.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_fugir(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusExplorer";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule fugir.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_fugir(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusExplorer.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule fugir.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_fugir(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
        }
    }

    /**
     * Returns an object declared in the rule fugir.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_fugir(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusExplorer_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule fugir
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_fugir() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusExplorer_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule fugir
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_fugir(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusExplorer_1 = (WumpusExplorer) objects[1];
    }

    /**
     * Condition 0 of rule fugir.<p>
     * The original expression was:<br>
     * <code>p.getStench()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean fugir_cond_0() {
        return (ws_Perceptions_1.getStench());
    }

    /**
     * Checks whether some conditions of rule fugir is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean fugir_cond(int index) {
        switch (index) {
            case 0: return fugir_cond_0();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule fugir that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_fugir(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!fugir_cond_0()) return false;
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_fugir(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule fugir
     */
    private void fugir() {
            System.out.println("FUGINDO \n");
            WumpusExplorer_1.run();            
            modified(WumpusExplorer_1);
            System.out.println("\n");
        }

			

    
    /**
     * Identifiers of rule sair
     */
    private String[] identifiers_sair = {
        "e"
    };

    /**
     * Returns the identifiers declared in rule sair
     *
     * @return the identifiers declared in rule sair
     */
    private String[] getDeclaredIdentifiers_sair() {
         return identifiers_sair;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule sair.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_sair(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule sair.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_sair(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule sair.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_sair(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
        }
    }

    /**
     * Returns an object declared in the rule sair.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_sair(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule sair
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_sair() {
        return new Object[] {
                            WumpusExplorer_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule sair
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_sair(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
    }

    /**
     * Condition 0 of rule sair.<p>
     * The original expression was:<br>
     * <code>e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean sair_cond_0() {
        return (WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 1 of rule sair.<p>
     * The original expression was:<br>
     * <code>e.getMapPosition() == 0</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean sair_cond_1() {
        return (WumpusExplorer_1.getMapPosition() == 0);
    }

    /**
     * Checks whether some conditions of rule sair is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean sair_cond(int index) {
        switch (index) {
            case 0: return sair_cond_0();
            case 1: return sair_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule sair that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_sair(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!sair_cond_0()) return false;
                if (!sair_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_sair(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule sair
     */
    private void sair() {            
            System.out.println("SAINDO COM OURO \n");
            WumpusExplorer_1.leave();            
            modified(WumpusExplorer_1);
            System.out.println("\n");
        }



			
    
    /**
     * Identifiers of rule pegarOuro
     */
    private String[] identifiers_pegarOuro = {
        "p",
        "e"
    };

    /**
     * Returns the identifiers declared in rule pegarOuro
     *
     * @return the identifiers declared in rule pegarOuro
     */
    private String[] getDeclaredIdentifiers_pegarOuro() {
         return identifiers_pegarOuro;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule pegarOuro.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_pegarOuro(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusExplorer";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule pegarOuro.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_pegarOuro(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusExplorer.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule pegarOuro.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_pegarOuro(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
        }
    }

    /**
     * Returns an object declared in the rule pegarOuro.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_pegarOuro(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusExplorer_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule pegarOuro
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_pegarOuro() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusExplorer_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule pegarOuro
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_pegarOuro(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusExplorer_1 = (WumpusExplorer) objects[1];
    }

    /**
     * Condition 0 of rule pegarOuro.<p>
     * The original expression was:<br>
     * <code>p.getGlitter()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean pegarOuro_cond_0() {
        return (ws_Perceptions_1.getGlitter());
    }

    /**
     * Checks whether some conditions of rule pegarOuro is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean pegarOuro_cond(int index) {
        switch (index) {
            case 0: return pegarOuro_cond_0();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule pegarOuro that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_pegarOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!pegarOuro_cond_0()) return false;
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_pegarOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule pegarOuro
     */
    private void pegarOuro() {
            System.out.println("PEGANDO OURO \n");
            WumpusExplorer_1.getGold();
            modified(WumpusExplorer_1);
            System.out.println("\n");
        }



    
    /**
     * Identifiers of rule voltar
     */
    private String[] identifiers_voltar = {
        "p",
        "e"
    };

    /**
     * Returns the identifiers declared in rule voltar
     *
     * @return the identifiers declared in rule voltar
     */
    private String[] getDeclaredIdentifiers_voltar() {
         return identifiers_voltar;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule voltar.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_voltar(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusExplorer";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule voltar.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_voltar(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusExplorer.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule voltar.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_voltar(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
        }
    }

    /**
     * Returns an object declared in the rule voltar.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_voltar(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusExplorer_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule voltar
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_voltar() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusExplorer_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule voltar
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_voltar(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusExplorer_1 = (WumpusExplorer) objects[1];
    }

    /**
     * Condition 0 of rule voltar.<p>
     * The original expression was:<br>
     * <code>p.getBreeze()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean voltar_cond_0() {
        return (ws_Perceptions_1.getBreeze());
    }

    /**
     * Condition 1 of rule voltar.<p>
     * The original expression was:<br>
     * <code>e.existeSalaOkNaoVisitada(e.getMap().getMapa())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean voltar_cond_1() {
        return (WumpusExplorer_1.existeSalaOkNaoVisitada(WumpusExplorer_1.getMap().getMapa()));
    }

    /**
     * Condition 2 of rule voltar.<p>
     * The original expression was:<br>
     * <code>!((e.getMapPosition()% e.getColumns()) == 7)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean voltar_cond_2() {
        return (!((WumpusExplorer_1.getMapPosition()% WumpusExplorer_1.getColumns()) == 7));
    }

    /**
     * Condition 3 of rule voltar.<p>
     * The original expression was:<br>
     * <code>!e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean voltar_cond_3() {
        return (!WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 4 of rule voltar.<p>
     * The original expression was:<br>
     * <code>e.existeProbPitZero(e.getMapPosition())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean voltar_cond_4() {
        return (WumpusExplorer_1.existeProbPitZero(WumpusExplorer_1.getMapPosition()));
    }

    /**
     * Condition 5 of rule voltar.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean voltar_cond_5() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule voltar is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean voltar_cond(int index) {
        switch (index) {
            case 0: return voltar_cond_0();
            case 1: return voltar_cond_1();
            case 2: return voltar_cond_2();
            case 3: return voltar_cond_3();
            case 4: return voltar_cond_4();
            case 5: return voltar_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule voltar that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_voltar(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!voltar_cond_0()) return false;
                return true;
            case 1:
                if (!voltar_cond_1()) return false;
                if (!voltar_cond_2()) return false;
                if (!voltar_cond_3()) return false;
                if (!voltar_cond_4()) return false;
                if (!voltar_cond_5()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_voltar(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule voltar
     */
    private void voltar() {
            System.out.println("VOLTANDO DA BRISA \n");
            WumpusExplorer_1.haBrisa();
            WumpusExplorer_1.setVisited(WumpusExplorer_1.getMapPosition());            
            WumpusExplorer_1.irParaPos(WumpusExplorer_1.getMapPosition(), WumpusExplorer_1.probPitZero(WumpusExplorer_1.getMapPosition()));
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }




//////////////////////////////////////////////////////////////////////
///// SE CASA DIREITA JAH FOI VISITADA
/// SE CASA DE CIMA AINDA NAO FOI VISITADA
//  SE CASA DE CIMA ESTIVER DENTRO DO MAPA
////////////////////////////////////////////////////////////////////

    
    /**
     * Identifiers of rule up
     */
    private String[] identifiers_up = {
        "e",
        "p"
    };

    /**
     * Returns the identifiers declared in rule up
     *
     * @return the identifiers declared in rule up
     */
    private String[] getDeclaredIdentifiers_up() {
         return identifiers_up;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule up.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_up(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            case 1: return "ws.Perceptions";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule up.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_up(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            case 1: return ws.Perceptions.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule up.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_up(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
            case 1: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
        }
    }

    /**
     * Returns an object declared in the rule up.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_up(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            case 1: return ws_Perceptions_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule up
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_up() {
        return new Object[] {
                            WumpusExplorer_1,
                            ws_Perceptions_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule up
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_up(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
        ws_Perceptions_1 = (ws.Perceptions) objects[1];
    }

    /**
     * Condition 0 of rule up.<p>
     * The original expression was:<br>
     * <code>!p.getBreeze()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean up_cond_0() {
        return (!ws_Perceptions_1.getBreeze());
    }

    /**
     * Condition 1 of rule up.<p>
     * The original expression was:<br>
     * <code>!e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean up_cond_1() {
        return (!WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 2 of rule up.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean up_cond_2() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Condition 3 of rule up.<p>
     * The original expression was:<br>
     * <code>e.isVisited(e.getMapPosition()+1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean up_cond_3() {
        return (WumpusExplorer_1.isVisited(WumpusExplorer_1.getMapPosition()+1));
    }

    /**
     * Condition 4 of rule up.<p>
     * The original expression was:<br>
     * <code>!e.isVisited(e.getMapPosition()+e.getColumns())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean up_cond_4() {
        return (!WumpusExplorer_1.isVisited(WumpusExplorer_1.getMapPosition()+WumpusExplorer_1.getColumns()));
    }

    /**
     * Condition 5 of rule up.<p>
     * The original expression was:<br>
     * <code>e.inMap(e.getMapPosition()+e.getColumns())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean up_cond_5() {
        return (WumpusExplorer_1.inMap(WumpusExplorer_1.getMapPosition()+WumpusExplorer_1.getColumns()));
    }

    /**
     * Checks whether some conditions of rule up is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean up_cond(int index) {
        switch (index) {
            case 0: return up_cond_0();
            case 1: return up_cond_1();
            case 2: return up_cond_2();
            case 3: return up_cond_3();
            case 4: return up_cond_4();
            case 5: return up_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule up that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_up(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!up_cond_1()) return false;
                if (!up_cond_2()) return false;
                if (!up_cond_3()) return false;
                if (!up_cond_4()) return false;
                if (!up_cond_5()) return false;
                return true;
            case 1:
                if (!up_cond_0()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_up(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule up
     */
    private void up() {            
            System.out.println("SUBINDO SEM OURO - CASA NOVA \n");
            WumpusExplorer_1.moveUp(WumpusExplorer_1.getDirection());
            WumpusExplorer_1.setVizSegura();            
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }



//////////////////////////////////////////////////////////////////////
///// SE CASA DIREITA NAO FOI VISITADA
/// SE EXISTE POSICOES A DIREITA
////////////////////////////////////////////////////////////////////

    
    /**
     * Identifiers of rule right
     */
    private String[] identifiers_right = {
        "p",
        "e"
    };

    /**
     * Returns the identifiers declared in rule right
     *
     * @return the identifiers declared in rule right
     */
    private String[] getDeclaredIdentifiers_right() {
         return identifiers_right;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule right.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_right(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusExplorer";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule right.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_right(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusExplorer.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule right.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_right(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
        }
    }

    /**
     * Returns an object declared in the rule right.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_right(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusExplorer_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule right
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_right() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusExplorer_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule right
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_right(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusExplorer_1 = (WumpusExplorer) objects[1];
    }

    /**
     * Condition 0 of rule right.<p>
     * The original expression was:<br>
     * <code>!e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean right_cond_0() {
        return (!WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 1 of rule right.<p>
     * The original expression was:<br>
     * <code>!p.getBreeze()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean right_cond_1() {
        return (!ws_Perceptions_1.getBreeze());
    }

    /**
     * Condition 2 of rule right.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean right_cond_2() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Condition 3 of rule right.<p>
     * The original expression was:<br>
     * <code>!e.isVisited(e.getMapPosition()+1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean right_cond_3() {
        return (!WumpusExplorer_1.isVisited(WumpusExplorer_1.getMapPosition()+1));
    }

    /**
     * Condition 4 of rule right.<p>
     * The original expression was:<br>
     * <code>e.getColumn() < (e.getColumns()-1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean right_cond_4() {
        return (WumpusExplorer_1.getColumn() < (WumpusExplorer_1.getColumns()-1));
    }

    /**
     * Checks whether some conditions of rule right is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean right_cond(int index) {
        switch (index) {
            case 0: return right_cond_0();
            case 1: return right_cond_1();
            case 2: return right_cond_2();
            case 3: return right_cond_3();
            case 4: return right_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule right that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_right(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!right_cond_1()) return false;
                return true;
            case 1:
                if (!right_cond_0()) return false;
                if (!right_cond_2()) return false;
                if (!right_cond_3()) return false;
                if (!right_cond_4()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_right(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule right
     */
    private void right() {		            
            System.out.println("DIREITA SEM OURO - CASA NOVA \n");
            WumpusExplorer_1.moveRight(WumpusExplorer_1.getDirection());
            WumpusExplorer_1.setVisited(WumpusExplorer_1.getMapPosition());
            WumpusExplorer_1.setVizSegura();            
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }



//////////////////////////////////////////////////////////////////////
///// COMO O AGENTE COMECA DO CANTO ESQUERDO NA PRIMEIRA COLUNA, VERIFICA ESTE CASO
/// SE CASA DE CIMA FOI VISITADA
//  SE CASA DA DIREITA FOI VISITADA
////////////////////////////////////////////////////////////////////

    
    /**
     * Identifiers of rule left
     */
    private String[] identifiers_left = {
        "e"
    };

    /**
     * Returns the identifiers declared in rule left
     *
     * @return the identifiers declared in rule left
     */
    private String[] getDeclaredIdentifiers_left() {
         return identifiers_left;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule left.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_left(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule left.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_left(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule left.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_left(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
        }
    }

    /**
     * Returns an object declared in the rule left.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_left(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule left
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_left() {
        return new Object[] {
                            WumpusExplorer_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule left
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_left(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
    }

    /**
     * Condition 0 of rule left.<p>
     * The original expression was:<br>
     * <code>!e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean left_cond_0() {
        return (!WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 1 of rule left.<p>
     * The original expression was:<br>
     * <code>!((e.getMapPosition()% e.getColumns()) == 0)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean left_cond_1() {
        return (!((WumpusExplorer_1.getMapPosition()% WumpusExplorer_1.getColumns()) == 0));
    }

    /**
     * Condition 2 of rule left.<p>
     * The original expression was:<br>
     * <code>e.isVisited(e.getMapPosition()+e.getRows())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean left_cond_2() {
        return (WumpusExplorer_1.isVisited(WumpusExplorer_1.getMapPosition()+WumpusExplorer_1.getRows()));
    }

    /**
     * Condition 3 of rule left.<p>
     * The original expression was:<br>
     * <code>e.isVisited(e.getMapPosition()+1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean left_cond_3() {
        return (WumpusExplorer_1.isVisited(WumpusExplorer_1.getMapPosition()+1));
    }

    /**
     * Condition 4 of rule left.<p>
     * The original expression was:<br>
     * <code>e.getContX(e.getMapPosition()) < 15</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean left_cond_4() {
        return (WumpusExplorer_1.getContX(WumpusExplorer_1.getMapPosition()) < 15);
    }

    /**
     * Condition 5 of rule left.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean left_cond_5() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule left is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean left_cond(int index) {
        switch (index) {
            case 0: return left_cond_0();
            case 1: return left_cond_1();
            case 2: return left_cond_2();
            case 3: return left_cond_3();
            case 4: return left_cond_4();
            case 5: return left_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule left that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_left(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!left_cond_0()) return false;
                if (!left_cond_1()) return false;
                if (!left_cond_2()) return false;
                if (!left_cond_3()) return false;
                if (!left_cond_4()) return false;
                if (!left_cond_5()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_left(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule left
     */
    private void left() {            
            System.out.println("ESQUERDA SEM OURO - DEPOIS DE DIREITA E SUBIR \n");
            WumpusExplorer_1.moveLeft(WumpusExplorer_1.getDirection());
            System.out.println("Eu tenho o ouro: "+WumpusExplorer_1.getHasGold());
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }



//////////////////////////////////////////////////////////////////////
//  ANDAR APENAS PELAS CASAS VISITADAS E SEGURAS
////////////////////////////////////////////////////////////////////

    
    /**
     * Identifiers of rule descerComOuro
     */
    private String[] identifiers_descerComOuro = {
        "e",
        "p"
    };

    /**
     * Returns the identifiers declared in rule descerComOuro
     *
     * @return the identifiers declared in rule descerComOuro
     */
    private String[] getDeclaredIdentifiers_descerComOuro() {
         return identifiers_descerComOuro;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule descerComOuro.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_descerComOuro(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            case 1: return "ws.Perceptions";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule descerComOuro.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_descerComOuro(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            case 1: return ws.Perceptions.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule descerComOuro.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_descerComOuro(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
            case 1: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
        }
    }

    /**
     * Returns an object declared in the rule descerComOuro.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_descerComOuro(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            case 1: return ws_Perceptions_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule descerComOuro
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_descerComOuro() {
        return new Object[] {
                            WumpusExplorer_1,
                            ws_Perceptions_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule descerComOuro
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_descerComOuro(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
        ws_Perceptions_1 = (ws.Perceptions) objects[1];
    }

    /**
     * Condition 0 of rule descerComOuro.<p>
     * The original expression was:<br>
     * <code>e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerComOuro_cond_0() {
        return (WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 1 of rule descerComOuro.<p>
     * The original expression was:<br>
     * <code>!p.getBreeze()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerComOuro_cond_1() {
        return (!ws_Perceptions_1.getBreeze());
    }

    /**
     * Condition 2 of rule descerComOuro.<p>
     * The original expression was:<br>
     * <code>!(e.getMapPosition() == 0)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerComOuro_cond_2() {
        return (!(WumpusExplorer_1.getMapPosition() == 0));
    }

    /**
     * Condition 3 of rule descerComOuro.<p>
     * The original expression was:<br>
     * <code>e.isVisited(e.getMapPosition()-e.getColumns())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerComOuro_cond_3() {
        return (WumpusExplorer_1.isVisited(WumpusExplorer_1.getMapPosition()-WumpusExplorer_1.getColumns()));
    }

    /**
     * Condition 4 of rule descerComOuro.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerComOuro_cond_4() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule descerComOuro is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerComOuro_cond(int index) {
        switch (index) {
            case 0: return descerComOuro_cond_0();
            case 1: return descerComOuro_cond_1();
            case 2: return descerComOuro_cond_2();
            case 3: return descerComOuro_cond_3();
            case 4: return descerComOuro_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule descerComOuro that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_descerComOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!descerComOuro_cond_0()) return false;
                if (!descerComOuro_cond_2()) return false;
                if (!descerComOuro_cond_3()) return false;
                if (!descerComOuro_cond_4()) return false;
                return true;
            case 1:
                if (!descerComOuro_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_descerComOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule descerComOuro
     */
    private void descerComOuro() {            
            System.out.println("DESCENDO COM OURO - CASAS SEGURAS \n");
            WumpusExplorer_1.moveDown(WumpusExplorer_1.getDirection());
            WumpusExplorer_1.setVizSegura();            
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }



/////////////
//VAI PARA ESQUERDA CASO NECESSARIO

    
    /**
     * Identifiers of rule esquerdaComOuro
     */
    private String[] identifiers_esquerdaComOuro = {
        "e",
        "p"
    };

    /**
     * Returns the identifiers declared in rule esquerdaComOuro
     *
     * @return the identifiers declared in rule esquerdaComOuro
     */
    private String[] getDeclaredIdentifiers_esquerdaComOuro() {
         return identifiers_esquerdaComOuro;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule esquerdaComOuro.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_esquerdaComOuro(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            case 1: return "ws.Perceptions";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule esquerdaComOuro.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_esquerdaComOuro(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            case 1: return ws.Perceptions.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule esquerdaComOuro.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_esquerdaComOuro(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
            case 1: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
        }
    }

    /**
     * Returns an object declared in the rule esquerdaComOuro.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_esquerdaComOuro(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            case 1: return ws_Perceptions_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule esquerdaComOuro
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_esquerdaComOuro() {
        return new Object[] {
                            WumpusExplorer_1,
                            ws_Perceptions_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule esquerdaComOuro
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_esquerdaComOuro(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
        ws_Perceptions_1 = (ws.Perceptions) objects[1];
    }

    /**
     * Condition 0 of rule esquerdaComOuro.<p>
     * The original expression was:<br>
     * <code>e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaComOuro_cond_0() {
        return (WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 1 of rule esquerdaComOuro.<p>
     * The original expression was:<br>
     * <code>!(e.getMapPosition() == 0)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaComOuro_cond_1() {
        return (!(WumpusExplorer_1.getMapPosition() == 0));
    }

    /**
     * Condition 2 of rule esquerdaComOuro.<p>
     * The original expression was:<br>
     * <code>e.isVisited(e.getMapPosition()-1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaComOuro_cond_2() {
        return (WumpusExplorer_1.isVisited(WumpusExplorer_1.getMapPosition()-1));
    }

    /**
     * Condition 3 of rule esquerdaComOuro.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaComOuro_cond_3() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule esquerdaComOuro is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaComOuro_cond(int index) {
        switch (index) {
            case 0: return esquerdaComOuro_cond_0();
            case 1: return esquerdaComOuro_cond_1();
            case 2: return esquerdaComOuro_cond_2();
            case 3: return esquerdaComOuro_cond_3();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule esquerdaComOuro that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_esquerdaComOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!esquerdaComOuro_cond_0()) return false;
                if (!esquerdaComOuro_cond_1()) return false;
                if (!esquerdaComOuro_cond_2()) return false;
                if (!esquerdaComOuro_cond_3()) return false;
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_esquerdaComOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule esquerdaComOuro
     */
    private void esquerdaComOuro() {            
            System.out.println("ESQUERDA COM OURO - CASA SEGURA \n");
            WumpusExplorer_1.moveLeft(WumpusExplorer_1.getDirection());
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }

 

    
    /**
     * Identifiers of rule andar
     */
    private String[] identifiers_andar = {
        "e",
        "p"
    };

    /**
     * Returns the identifiers declared in rule andar
     *
     * @return the identifiers declared in rule andar
     */
    private String[] getDeclaredIdentifiers_andar() {
         return identifiers_andar;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule andar.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_andar(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            case 1: return "ws.Perceptions";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule andar.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_andar(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            case 1: return ws.Perceptions.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule andar.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_andar(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
            case 1: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
        }
    }

    /**
     * Returns an object declared in the rule andar.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_andar(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            case 1: return ws_Perceptions_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule andar
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_andar() {
        return new Object[] {
                            WumpusExplorer_1,
                            ws_Perceptions_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule andar
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_andar(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
        ws_Perceptions_1 = (ws.Perceptions) objects[1];
    }

    /**
     * Condition 0 of rule andar.<p>
     * The original expression was:<br>
     * <code>!p.getBreeze()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean andar_cond_0() {
        return (!ws_Perceptions_1.getBreeze());
    }

    /**
     * Condition 1 of rule andar.<p>
     * The original expression was:<br>
     * <code>!(e.getMapPosition() == 0)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean andar_cond_1() {
        return (!(WumpusExplorer_1.getMapPosition() == 0));
    }

    /**
     * Condition 2 of rule andar.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean andar_cond_2() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Condition 3 of rule andar.<p>
     * The original expression was:<br>
     * <code>(  -1 != e.menorProbPit(e.getMapPosition()) )</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean andar_cond_3() {
        return ((  -1 != WumpusExplorer_1.menorProbPit(WumpusExplorer_1.getMapPosition()) ));
    }

    /**
     * Checks whether some conditions of rule andar is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean andar_cond(int index) {
        switch (index) {
            case 0: return andar_cond_0();
            case 1: return andar_cond_1();
            case 2: return andar_cond_2();
            case 3: return andar_cond_3();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule andar that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_andar(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!andar_cond_1()) return false;
                if (!andar_cond_2()) return false;
                if (!andar_cond_3()) return false;
                return true;
            case 1:
                if (!andar_cond_0()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_andar(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule andar
     */
    private void andar() {            
            System.out.println("ANDANDO - CASAS SEGURAS E DE MENOR PROBABILIDADE \n");
            WumpusExplorer_1.setVizSegura();
            WumpusExplorer_1.irParaPos(WumpusExplorer_1.getMapPosition(), WumpusExplorer_1.menorProbPit(WumpusExplorer_1.getMapPosition()));             
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }



/*
    rule arriscar{
	declarations
            WumpusExplorer e;
            Perceptions p;
	conditions
            !e.existeSalaOkNaoVisitada(e.getMap().getMapa());
            p.getBreeze();
            !e.getHasGold();
            e.planIsEmpty();
            e.getMenorProbPit(e.getMapPosition())  ==  e.getMenorProbGeral(e.getMap().getMapa());
	actions            
            System.out.println("ARRISCANDO - POR TODAS AS CASAS SEGURAS TEREM SIDO VISITADAS \n");
            e.haBrisa();
            e.irParaPos(e.getMapPosition(), e.menorProbPit(e.getMapPosition()));		            
            modified(e);
            e.imprimirProbViz(e.getMapPosition());
            System.out.println("\n");
    }

*/

    
    /**
     * Identifiers of rule descerSemOuro
     */
    private String[] identifiers_descerSemOuro = {
        "e",
        "p"
    };

    /**
     * Returns the identifiers declared in rule descerSemOuro
     *
     * @return the identifiers declared in rule descerSemOuro
     */
    private String[] getDeclaredIdentifiers_descerSemOuro() {
         return identifiers_descerSemOuro;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule descerSemOuro.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_descerSemOuro(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            case 1: return "ws.Perceptions";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule descerSemOuro.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_descerSemOuro(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            case 1: return ws.Perceptions.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule descerSemOuro.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_descerSemOuro(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
            case 1: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
        }
    }

    /**
     * Returns an object declared in the rule descerSemOuro.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_descerSemOuro(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            case 1: return ws_Perceptions_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule descerSemOuro
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_descerSemOuro() {
        return new Object[] {
                            WumpusExplorer_1,
                            ws_Perceptions_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule descerSemOuro
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_descerSemOuro(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
        ws_Perceptions_1 = (ws.Perceptions) objects[1];
    }

    /**
     * Condition 0 of rule descerSemOuro.<p>
     * The original expression was:<br>
     * <code>!e.existeSalaOkNaoVisitada(e.getMap().getMapa())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerSemOuro_cond_0() {
        return (!WumpusExplorer_1.existeSalaOkNaoVisitada(WumpusExplorer_1.getMap().getMapa()));
    }

    /**
     * Condition 1 of rule descerSemOuro.<p>
     * The original expression was:<br>
     * <code>!e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerSemOuro_cond_1() {
        return (!WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 2 of rule descerSemOuro.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerSemOuro_cond_2() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule descerSemOuro is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean descerSemOuro_cond(int index) {
        switch (index) {
            case 0: return descerSemOuro_cond_0();
            case 1: return descerSemOuro_cond_1();
            case 2: return descerSemOuro_cond_2();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule descerSemOuro that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_descerSemOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!descerSemOuro_cond_0()) return false;
                if (!descerSemOuro_cond_1()) return false;
                if (!descerSemOuro_cond_2()) return false;
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_descerSemOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule descerSemOuro
     */
    private void descerSemOuro() {            
            System.out.println("DESCENDO - SEM OURO \n");
            WumpusExplorer_1.moveDown(WumpusExplorer_1.getDirection());
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }



    
    /**
     * Identifiers of rule esquerdaSemOuro
     */
    private String[] identifiers_esquerdaSemOuro = {
        "e",
        "p"
    };

    /**
     * Returns the identifiers declared in rule esquerdaSemOuro
     *
     * @return the identifiers declared in rule esquerdaSemOuro
     */
    private String[] getDeclaredIdentifiers_esquerdaSemOuro() {
         return identifiers_esquerdaSemOuro;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule esquerdaSemOuro.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_esquerdaSemOuro(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            case 1: return "ws.Perceptions";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule esquerdaSemOuro.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_esquerdaSemOuro(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            case 1: return ws.Perceptions.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule esquerdaSemOuro.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_esquerdaSemOuro(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
            case 1: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
        }
    }

    /**
     * Returns an object declared in the rule esquerdaSemOuro.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_esquerdaSemOuro(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            case 1: return ws_Perceptions_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule esquerdaSemOuro
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_esquerdaSemOuro() {
        return new Object[] {
                            WumpusExplorer_1,
                            ws_Perceptions_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule esquerdaSemOuro
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_esquerdaSemOuro(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
        ws_Perceptions_1 = (ws.Perceptions) objects[1];
    }

    /**
     * Condition 0 of rule esquerdaSemOuro.<p>
     * The original expression was:<br>
     * <code>!e.existeSalaOkNaoVisitada(e.getMap().getMapa())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaSemOuro_cond_0() {
        return (!WumpusExplorer_1.existeSalaOkNaoVisitada(WumpusExplorer_1.getMap().getMapa()));
    }

    /**
     * Condition 1 of rule esquerdaSemOuro.<p>
     * The original expression was:<br>
     * <code>!e.getHasGold()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaSemOuro_cond_1() {
        return (!WumpusExplorer_1.getHasGold());
    }

    /**
     * Condition 2 of rule esquerdaSemOuro.<p>
     * The original expression was:<br>
     * <code>!(e.getMapPosition() == 0)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaSemOuro_cond_2() {
        return (!(WumpusExplorer_1.getMapPosition() == 0));
    }

    /**
     * Condition 3 of rule esquerdaSemOuro.<p>
     * The original expression was:<br>
     * <code>e.isVisited(e.getMapPosition()-1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaSemOuro_cond_3() {
        return (WumpusExplorer_1.isVisited(WumpusExplorer_1.getMapPosition()-1));
    }

    /**
     * Condition 4 of rule esquerdaSemOuro.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaSemOuro_cond_4() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule esquerdaSemOuro is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerdaSemOuro_cond(int index) {
        switch (index) {
            case 0: return esquerdaSemOuro_cond_0();
            case 1: return esquerdaSemOuro_cond_1();
            case 2: return esquerdaSemOuro_cond_2();
            case 3: return esquerdaSemOuro_cond_3();
            case 4: return esquerdaSemOuro_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule esquerdaSemOuro that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_esquerdaSemOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!esquerdaSemOuro_cond_0()) return false;
                if (!esquerdaSemOuro_cond_1()) return false;
                if (!esquerdaSemOuro_cond_2()) return false;
                if (!esquerdaSemOuro_cond_3()) return false;
                if (!esquerdaSemOuro_cond_4()) return false;
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_esquerdaSemOuro(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule esquerdaSemOuro
     */
    private void esquerdaSemOuro() {            
            System.out.println("ESQUERDA - SEM OURO \n");
            WumpusExplorer_1.moveDown(WumpusExplorer_1.getDirection());
            modified(WumpusExplorer_1);            
            System.out.println("\n");
        }



////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    
// CASO NÃO ENTRE EM NEHUMA REGRA
////////////////////////////////////////////////////////////////////////////////    

    
    /**
     * Identifiers of rule regraDefaultComBrisa
     */
    private String[] identifiers_regraDefaultComBrisa = {
        "e",
        "p"
    };

    /**
     * Returns the identifiers declared in rule regraDefaultComBrisa
     *
     * @return the identifiers declared in rule regraDefaultComBrisa
     */
    private String[] getDeclaredIdentifiers_regraDefaultComBrisa() {
         return identifiers_regraDefaultComBrisa;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule regraDefaultComBrisa.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_regraDefaultComBrisa(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            case 1: return "ws.Perceptions";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule regraDefaultComBrisa.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_regraDefaultComBrisa(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            case 1: return ws.Perceptions.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule regraDefaultComBrisa.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_regraDefaultComBrisa(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
            case 1: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
        }
    }

    /**
     * Returns an object declared in the rule regraDefaultComBrisa.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_regraDefaultComBrisa(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            case 1: return ws_Perceptions_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule regraDefaultComBrisa
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_regraDefaultComBrisa() {
        return new Object[] {
                            WumpusExplorer_1,
                            ws_Perceptions_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule regraDefaultComBrisa
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_regraDefaultComBrisa(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
        ws_Perceptions_1 = (ws.Perceptions) objects[1];
    }

    /**
     * Condition 0 of rule regraDefaultComBrisa.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean regraDefaultComBrisa_cond_0() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Condition 1 of rule regraDefaultComBrisa.<p>
     * The original expression was:<br>
     * <code>p.getBreeze()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean regraDefaultComBrisa_cond_1() {
        return (ws_Perceptions_1.getBreeze());
    }

    /**
     * Checks whether some conditions of rule regraDefaultComBrisa is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean regraDefaultComBrisa_cond(int index) {
        switch (index) {
            case 0: return regraDefaultComBrisa_cond_0();
            case 1: return regraDefaultComBrisa_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule regraDefaultComBrisa that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_regraDefaultComBrisa(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!regraDefaultComBrisa_cond_0()) return false;
                return true;
            case 1:
                if (!regraDefaultComBrisa_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_regraDefaultComBrisa(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule regraDefaultComBrisa
     */
    private void regraDefaultComBrisa() {            
            System.out.println("REGRA PADRÃO - SALA COM BRISA \n");
            WumpusExplorer_1.haBrisa();
            WumpusExplorer_1.irParaPos(WumpusExplorer_1.getMapPosition(), WumpusExplorer_1.probPitZero(WumpusExplorer_1.getMapPosition()));
            modified(WumpusExplorer_1);
            System.out.println("\n");
        }


	
    
    /**
     * Identifiers of rule regraDefault
     */
    private String[] identifiers_regraDefault = {
        "e",
        "p"
    };

    /**
     * Returns the identifiers declared in rule regraDefault
     *
     * @return the identifiers declared in rule regraDefault
     */
    private String[] getDeclaredIdentifiers_regraDefault() {
         return identifiers_regraDefault;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule regraDefault.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_regraDefault(int index) {
        switch (index) {
            case 0: return "WumpusExplorer";
            case 1: return "ws.Perceptions";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule regraDefault.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_regraDefault(int index) {
        switch (index) {
            case 0: return WumpusExplorer.class;
            case 1: return ws.Perceptions.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule regraDefault.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_regraDefault(int index, Object value) {
        switch (index) {
            case 0: this.WumpusExplorer_1 = (WumpusExplorer) value; break;
            case 1: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
        }
    }

    /**
     * Returns an object declared in the rule regraDefault.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_regraDefault(int index) {
        switch (index) {
            case 0: return WumpusExplorer_1;
            case 1: return ws_Perceptions_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule regraDefault
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_regraDefault() {
        return new Object[] {
                            WumpusExplorer_1,
                            ws_Perceptions_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule regraDefault
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_regraDefault(Object[] objects) {
        WumpusExplorer_1 = (WumpusExplorer) objects[0];
        ws_Perceptions_1 = (ws.Perceptions) objects[1];
    }

    /**
     * Condition 0 of rule regraDefault.<p>
     * The original expression was:<br>
     * <code>!p.getBreeze()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean regraDefault_cond_0() {
        return (!ws_Perceptions_1.getBreeze());
    }

    /**
     * Condition 1 of rule regraDefault.<p>
     * The original expression was:<br>
     * <code>e.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean regraDefault_cond_1() {
        return (WumpusExplorer_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule regraDefault is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean regraDefault_cond(int index) {
        switch (index) {
            case 0: return regraDefault_cond_0();
            case 1: return regraDefault_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule regraDefault that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_regraDefault(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!regraDefault_cond_1()) return false;
                return true;
            case 1:
                if (!regraDefault_cond_0()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_regraDefault(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule regraDefault
     */
    private void regraDefault() {            
            System.out.print("REGRA PADRÃO - SALA SEM BRISA/SEGURA");
            WumpusExplorer_1.irParaPos(WumpusExplorer_1.getMapPosition(), WumpusExplorer_1.probPitZero(WumpusExplorer_1.getMapPosition()));
            WumpusExplorer_1.setVizSegura();
            modified(WumpusExplorer_1);
            System.out.println("\n");
        }

 	

    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "fugir",
        "sair",
        "pegarOuro",
        "voltar",
        "up",
        "right",
        "left",
        "descerComOuro",
        "esquerdaComOuro",
        "andar",
        "descerSemOuro",
        "esquerdaSemOuro",
        "regraDefaultComBrisa",
        "regraDefault"
    };

    /**
     * Returns the name of the rules in this class file.
     *
     * @return the name of the rules in this class file.
     */
    public String[] getRuleNames() {
        return File_ruleNames;
    }

    /**
     * The number of declarations of the rules in this class file.
     */
    private static final int[] File_numberOfDeclarations = {
        2,
        1,
        2,
        2,
        2,
        2,
        1,
        2,
        2,
        2,
        2,
        2,
        2,
        2
    };

    /**
     * Returns the number of declarations of the rules in this class file.
     *
     * @return the number of declarations  of the rules in this class file.
     */
    public int[] getNumberOfDeclarations() {
        return File_numberOfDeclarations;
    }

    /**
     * The number of conditions of the rules in this class file.
     */
    private static final int[] File_numberOfConditions = {
        1,
        2,
        1,
        6,
        6,
        5,
        6,
        5,
        4,
        4,
        3,
        5,
        2,
        2
    };

    /**
     * Returns the number of conditions of the rules in this class file.
     *
     * @return the number of conditions  of the rules in this class file.
     */
    public int[] getNumberOfConditions() {
        return File_numberOfConditions;
    }

    /**
     * Checks whether a condition of some rule is satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param condIndex the index of the condition to be checked
     * @return <code>true</code> if the corresponding condition for the
     *          given rule is satisfied. <code>false</code> otherwise.
     */
    public boolean checkCondition(int ruleIndex, int condIndex) {
        switch (ruleIndex) {
            case 0: return fugir_cond(condIndex);
            case 1: return sair_cond(condIndex);
            case 2: return pegarOuro_cond(condIndex);
            case 3: return voltar_cond(condIndex);
            case 4: return up_cond(condIndex);
            case 5: return right_cond(condIndex);
            case 6: return left_cond(condIndex);
            case 7: return descerComOuro_cond(condIndex);
            case 8: return esquerdaComOuro_cond(condIndex);
            case 9: return andar_cond(condIndex);
            case 10: return descerSemOuro_cond(condIndex);
            case 11: return esquerdaSemOuro_cond(condIndex);
            case 12: return regraDefaultComBrisa_cond(condIndex);
            case 13: return regraDefault_cond(condIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of some rule that depend only on
     * the given object are satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          the given rule are satisfied;
     *           <code>false</code> otherwise.
     */
    public boolean checkConditionsOnlyOf(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkConditionsOnlyOf_fugir(declIndex);
            case 1: return checkConditionsOnlyOf_sair(declIndex);
            case 2: return checkConditionsOnlyOf_pegarOuro(declIndex);
            case 3: return checkConditionsOnlyOf_voltar(declIndex);
            case 4: return checkConditionsOnlyOf_up(declIndex);
            case 5: return checkConditionsOnlyOf_right(declIndex);
            case 6: return checkConditionsOnlyOf_left(declIndex);
            case 7: return checkConditionsOnlyOf_descerComOuro(declIndex);
            case 8: return checkConditionsOnlyOf_esquerdaComOuro(declIndex);
            case 9: return checkConditionsOnlyOf_andar(declIndex);
            case 10: return checkConditionsOnlyOf_descerSemOuro(declIndex);
            case 11: return checkConditionsOnlyOf_esquerdaSemOuro(declIndex);
            case 12: return checkConditionsOnlyOf_regraDefaultComBrisa(declIndex);
            case 13: return checkConditionsOnlyOf_regraDefault(declIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference only the elements declared up to the given index
     * are true.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all the conditions of a rule which
     *          reference only the elements declared up to the given index
     *          are satisfied; <code>false</code> otherwise.
     */
    public boolean checkCondForDeclaration(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkCondForDeclaration_fugir(declIndex);
            case 1: return checkCondForDeclaration_sair(declIndex);
            case 2: return checkCondForDeclaration_pegarOuro(declIndex);
            case 3: return checkCondForDeclaration_voltar(declIndex);
            case 4: return checkCondForDeclaration_up(declIndex);
            case 5: return checkCondForDeclaration_right(declIndex);
            case 6: return checkCondForDeclaration_left(declIndex);
            case 7: return checkCondForDeclaration_descerComOuro(declIndex);
            case 8: return checkCondForDeclaration_esquerdaComOuro(declIndex);
            case 9: return checkCondForDeclaration_andar(declIndex);
            case 10: return checkCondForDeclaration_descerSemOuro(declIndex);
            case 11: return checkCondForDeclaration_esquerdaSemOuro(declIndex);
            case 12: return checkCondForDeclaration_regraDefaultComBrisa(declIndex);
            case 13: return checkCondForDeclaration_regraDefault(declIndex);
            default: return false;
        }
    }

    /**
     * Returns the class name of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class name of the declared object.
     */
    public String getDeclaredClassName(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClassName_fugir(declIndex);
            case 1: return getDeclaredClassName_sair(declIndex);
            case 2: return getDeclaredClassName_pegarOuro(declIndex);
            case 3: return getDeclaredClassName_voltar(declIndex);
            case 4: return getDeclaredClassName_up(declIndex);
            case 5: return getDeclaredClassName_right(declIndex);
            case 6: return getDeclaredClassName_left(declIndex);
            case 7: return getDeclaredClassName_descerComOuro(declIndex);
            case 8: return getDeclaredClassName_esquerdaComOuro(declIndex);
            case 9: return getDeclaredClassName_andar(declIndex);
            case 10: return getDeclaredClassName_descerSemOuro(declIndex);
            case 11: return getDeclaredClassName_esquerdaSemOuro(declIndex);
            case 12: return getDeclaredClassName_regraDefaultComBrisa(declIndex);
            case 13: return getDeclaredClassName_regraDefault(declIndex);
            default: return null;
        }
    }

    /**
     * Returns the class of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class of the declared object.
     */
    public Class getDeclaredClass(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClass_fugir(declIndex);
            case 1: return getDeclaredClass_sair(declIndex);
            case 2: return getDeclaredClass_pegarOuro(declIndex);
            case 3: return getDeclaredClass_voltar(declIndex);
            case 4: return getDeclaredClass_up(declIndex);
            case 5: return getDeclaredClass_right(declIndex);
            case 6: return getDeclaredClass_left(declIndex);
            case 7: return getDeclaredClass_descerComOuro(declIndex);
            case 8: return getDeclaredClass_esquerdaComOuro(declIndex);
            case 9: return getDeclaredClass_andar(declIndex);
            case 10: return getDeclaredClass_descerSemOuro(declIndex);
            case 11: return getDeclaredClass_esquerdaSemOuro(declIndex);
            case 12: return getDeclaredClass_regraDefaultComBrisa(declIndex);
            case 13: return getDeclaredClass_regraDefault(declIndex);
            default: return null;
        }
    }

    /**
     * Fires one of the rules in this rule base.
     *
     * @param ruleIndex the index of the rule to be fired
     */
    protected void internalFireRule(int ruleIndex) {
        switch (ruleIndex) {
            case 0: fugir(); break;
            case 1: sair(); break;
            case 2: pegarOuro(); break;
            case 3: voltar(); break;
            case 4: up(); break;
            case 5: right(); break;
            case 6: left(); break;
            case 7: descerComOuro(); break;
            case 8: esquerdaComOuro(); break;
            case 9: andar(); break;
            case 10: descerSemOuro(); break;
            case 11: esquerdaSemOuro(); break;
            case 12: regraDefaultComBrisa(); break;
            case 13: regraDefault(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 14;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_fugir();
            case 1: return getDeclaredIdentifiers_sair();
            case 2: return getDeclaredIdentifiers_pegarOuro();
            case 3: return getDeclaredIdentifiers_voltar();
            case 4: return getDeclaredIdentifiers_up();
            case 5: return getDeclaredIdentifiers_right();
            case 6: return getDeclaredIdentifiers_left();
            case 7: return getDeclaredIdentifiers_descerComOuro();
            case 8: return getDeclaredIdentifiers_esquerdaComOuro();
            case 9: return getDeclaredIdentifiers_andar();
            case 10: return getDeclaredIdentifiers_descerSemOuro();
            case 11: return getDeclaredIdentifiers_esquerdaSemOuro();
            case 12: return getDeclaredIdentifiers_regraDefaultComBrisa();
            case 13: return getDeclaredIdentifiers_regraDefault();
            default: return new String[0];
        }
    }

    /**
     * Sets an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @param value the value of the object being set.
     */
    public void setObject(int ruleIndex, int declIndex, Object value) {
        switch (ruleIndex) {
            case 0: setObject_fugir(declIndex, value); break;
            case 1: setObject_sair(declIndex, value); break;
            case 2: setObject_pegarOuro(declIndex, value); break;
            case 3: setObject_voltar(declIndex, value); break;
            case 4: setObject_up(declIndex, value); break;
            case 5: setObject_right(declIndex, value); break;
            case 6: setObject_left(declIndex, value); break;
            case 7: setObject_descerComOuro(declIndex, value); break;
            case 8: setObject_esquerdaComOuro(declIndex, value); break;
            case 9: setObject_andar(declIndex, value); break;
            case 10: setObject_descerSemOuro(declIndex, value); break;
            case 11: setObject_esquerdaSemOuro(declIndex, value); break;
            case 12: setObject_regraDefaultComBrisa(declIndex, value); break;
            case 13: setObject_regraDefault(declIndex, value); break;
        }
    }

    /**
     * Returns an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @return the value of the corresponding object.
     */
    public Object getObject(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getObject_fugir(declIndex);
            case 1: return getObject_sair(declIndex);
            case 2: return getObject_pegarOuro(declIndex);
            case 3: return getObject_voltar(declIndex);
            case 4: return getObject_up(declIndex);
            case 5: return getObject_right(declIndex);
            case 6: return getObject_left(declIndex);
            case 7: return getObject_descerComOuro(declIndex);
            case 8: return getObject_esquerdaComOuro(declIndex);
            case 9: return getObject_andar(declIndex);
            case 10: return getObject_descerSemOuro(declIndex);
            case 11: return getObject_esquerdaSemOuro(declIndex);
            case 12: return getObject_regraDefaultComBrisa(declIndex);
            case 13: return getObject_regraDefault(declIndex);
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @return an object array of the variables bound to the
     *          declarations of some rule.
     */
    public Object[] getObjects(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getObjects_fugir();
            case 1: return getObjects_sair();
            case 2: return getObjects_pegarOuro();
            case 3: return getObjects_voltar();
            case 4: return getObjects_up();
            case 5: return getObjects_right();
            case 6: return getObjects_left();
            case 7: return getObjects_descerComOuro();
            case 8: return getObjects_esquerdaComOuro();
            case 9: return getObjects_andar();
            case 10: return getObjects_descerSemOuro();
            case 11: return getObjects_esquerdaSemOuro();
            case 12: return getObjects_regraDefaultComBrisa();
            case 13: return getObjects_regraDefault();
            default: return null;
        }
    }
    /**
     * Defines all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @param objects an object array of the variables bound to the
     *          declarations of some rule.
     */
    public void setObjects(int ruleIndex, Object[] objects) {
        switch (ruleIndex) {
            case 0: setObjects_fugir(objects); break;
            case 1: setObjects_sair(objects); break;
            case 2: setObjects_pegarOuro(objects); break;
            case 3: setObjects_voltar(objects); break;
            case 4: setObjects_up(objects); break;
            case 5: setObjects_right(objects); break;
            case 6: setObjects_left(objects); break;
            case 7: setObjects_descerComOuro(objects); break;
            case 8: setObjects_esquerdaComOuro(objects); break;
            case 9: setObjects_andar(objects); break;
            case 10: setObjects_descerSemOuro(objects); break;
            case 11: setObjects_esquerdaSemOuro(objects); break;
            case 12: setObjects_regraDefaultComBrisa(objects); break;
            case 13: setObjects_regraDefault(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private ws.Perceptions ws_Perceptions_1;
    private WumpusExplorer WumpusExplorer_1;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_WumpusKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file WumpusKB.rules
 *
 * @version 24/12/2014
 */
public class WumpusKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public WumpusKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public WumpusKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_WumpusKB(this);
    }

}
