import ws.Perceptions;

/**
 * Wumpus Agents Knowledge Base.
 *
 * @author   Marco Antonio Costa Simoes <a href="mailto:macs3@cin.ufpe.br">msimoes@uneb.br</a>
 * @version  1.0, Junho 2005.
 *
 * Aqui temos a descrição das regras da base deconhecimento dos agentes do Mundo do Wumpus.
 */
  class Jeops_RuleBase_WumpusInfoKB extends jeops.AbstractRuleBase {
	
    /**
     * Identifiers of rule anda
     */
    private String[] identifiers_anda = {
        "p",
        "m"
    };

    /**
     * Returns the identifiers declared in rule anda
     *
     * @return the identifiers declared in rule anda
     */
    private String[] getDeclaredIdentifiers_anda() {
         return identifiers_anda;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule anda.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_anda(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusMonster";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule anda.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_anda(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusMonster.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule anda.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_anda(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusMonster_1 = (WumpusMonster) value; break;
        }
    }

    /**
     * Returns an object declared in the rule anda.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_anda(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusMonster_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule anda
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_anda() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusMonster_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule anda
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_anda(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusMonster_1 = (WumpusMonster) objects[1];
    }

    /**
     * Condition 0 of rule anda.<p>
     * The original expression was:<br>
     * <code>!p.getWall()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean anda_cond_0() {
        return (!ws_Perceptions_1.getWall());
    }

    /**
     * Condition 1 of rule anda.<p>
     * The original expression was:<br>
     * <code>m.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean anda_cond_1() {
        return (WumpusMonster_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule anda is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean anda_cond(int index) {
        switch (index) {
            case 0: return anda_cond_0();
            case 1: return anda_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule anda that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_anda(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!anda_cond_0()) return false;
                return true;
            case 1:
                if (!anda_cond_1()) return false;
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
    private boolean checkCondForDeclaration_anda(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule anda
     */
    private void anda() {		
			WumpusMonster_1.anda();	
			modified(WumpusMonster_1);
			    }



	
    /**
     * Identifiers of rule verificarMorteExplorador
     */
    private String[] identifiers_verificarMorteExplorador = {
        "p",
        "w"
    };

    /**
     * Returns the identifiers declared in rule verificarMorteExplorador
     *
     * @return the identifiers declared in rule verificarMorteExplorador
     */
    private String[] getDeclaredIdentifiers_verificarMorteExplorador() {
         return identifiers_verificarMorteExplorador;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule verificarMorteExplorador.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_verificarMorteExplorador(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusMonster";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule verificarMorteExplorador.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_verificarMorteExplorador(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusMonster.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule verificarMorteExplorador.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_verificarMorteExplorador(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusMonster_1 = (WumpusMonster) value; break;
        }
    }

    /**
     * Returns an object declared in the rule verificarMorteExplorador.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_verificarMorteExplorador(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusMonster_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule verificarMorteExplorador
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_verificarMorteExplorador() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusMonster_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule verificarMorteExplorador
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_verificarMorteExplorador(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusMonster_1 = (WumpusMonster) objects[1];
    }

    /**
     * Condition 0 of rule verificarMorteExplorador.<p>
     * The original expression was:<br>
     * <code>p.getExplorerScream()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean verificarMorteExplorador_cond_0() {
        return (ws_Perceptions_1.getExplorerScream());
    }

    /**
     * Condition 1 of rule verificarMorteExplorador.<p>
     * The original expression was:<br>
     * <code>w.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean verificarMorteExplorador_cond_1() {
        return (WumpusMonster_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule verificarMorteExplorador is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean verificarMorteExplorador_cond(int index) {
        switch (index) {
            case 0: return verificarMorteExplorador_cond_0();
            case 1: return verificarMorteExplorador_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule verificarMorteExplorador that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_verificarMorteExplorador(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!verificarMorteExplorador_cond_0()) return false;
                return true;
            case 1:
                if (!verificarMorteExplorador_cond_1()) return false;
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
    private boolean checkCondForDeclaration_verificarMorteExplorador(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule verificarMorteExplorador
     */
    private void verificarMorteExplorador() {			
			WumpusMonster_1.doNothing();			
			modified(WumpusMonster_1);
	    }


     
    /**
     * Identifiers of rule cima
     */
    private String[] identifiers_cima = {
        "p",
        "w"
    };

    /**
     * Returns the identifiers declared in rule cima
     *
     * @return the identifiers declared in rule cima
     */
    private String[] getDeclaredIdentifiers_cima() {
         return identifiers_cima;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule cima.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_cima(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusMonster";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule cima.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_cima(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusMonster.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule cima.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_cima(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusMonster_1 = (WumpusMonster) value; break;
        }
    }

    /**
     * Returns an object declared in the rule cima.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_cima(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusMonster_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule cima
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_cima() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusMonster_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule cima
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_cima(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusMonster_1 = (WumpusMonster) objects[1];
    }

    /**
     * Condition 0 of rule cima.<p>
     * The original expression was:<br>
     * <code>w.getRow() == 1</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean cima_cond_0() {
        return (WumpusMonster_1.getRow() == 1);
    }

    /**
     * Condition 1 of rule cima.<p>
     * The original expression was:<br>
     * <code>w.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean cima_cond_1() {
        return (WumpusMonster_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule cima is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean cima_cond(int index) {
        switch (index) {
            case 0: return cima_cond_0();
            case 1: return cima_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule cima that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_cima(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!cima_cond_0()) return false;
                if (!cima_cond_1()) return false;
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
    private boolean checkCondForDeclaration_cima(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule cima
     */
    private void cima() {			
			WumpusMonster_1.moveUp(WumpusMonster_1.getDirection());		
			modified(WumpusMonster_1);
	    }



      
    /**
     * Identifiers of rule baixo
     */
    private String[] identifiers_baixo = {
        "p",
        "w"
    };

    /**
     * Returns the identifiers declared in rule baixo
     *
     * @return the identifiers declared in rule baixo
     */
    private String[] getDeclaredIdentifiers_baixo() {
         return identifiers_baixo;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule baixo.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_baixo(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusMonster";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule baixo.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_baixo(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusMonster.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule baixo.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_baixo(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusMonster_1 = (WumpusMonster) value; break;
        }
    }

    /**
     * Returns an object declared in the rule baixo.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_baixo(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusMonster_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule baixo
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_baixo() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusMonster_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule baixo
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_baixo(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusMonster_1 = (WumpusMonster) objects[1];
    }

    /**
     * Condition 0 of rule baixo.<p>
     * The original expression was:<br>
     * <code>w.getRow() == 7</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean baixo_cond_0() {
        return (WumpusMonster_1.getRow() == 7);
    }

    /**
     * Condition 1 of rule baixo.<p>
     * The original expression was:<br>
     * <code>w.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean baixo_cond_1() {
        return (WumpusMonster_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule baixo is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean baixo_cond(int index) {
        switch (index) {
            case 0: return baixo_cond_0();
            case 1: return baixo_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule baixo that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_baixo(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!baixo_cond_0()) return false;
                if (!baixo_cond_1()) return false;
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
    private boolean checkCondForDeclaration_baixo(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule baixo
     */
    private void baixo() {			
			WumpusMonster_1.moveDown(WumpusMonster_1.getDirection());		
			modified(WumpusMonster_1);
	    }


        
    /**
     * Identifiers of rule esquerda
     */
    private String[] identifiers_esquerda = {
        "p",
        "w"
    };

    /**
     * Returns the identifiers declared in rule esquerda
     *
     * @return the identifiers declared in rule esquerda
     */
    private String[] getDeclaredIdentifiers_esquerda() {
         return identifiers_esquerda;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule esquerda.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_esquerda(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusMonster";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule esquerda.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_esquerda(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusMonster.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule esquerda.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_esquerda(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusMonster_1 = (WumpusMonster) value; break;
        }
    }

    /**
     * Returns an object declared in the rule esquerda.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_esquerda(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusMonster_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule esquerda
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_esquerda() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusMonster_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule esquerda
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_esquerda(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusMonster_1 = (WumpusMonster) objects[1];
    }

    /**
     * Condition 0 of rule esquerda.<p>
     * The original expression was:<br>
     * <code>w.getColumn() == 7</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerda_cond_0() {
        return (WumpusMonster_1.getColumn() == 7);
    }

    /**
     * Condition 1 of rule esquerda.<p>
     * The original expression was:<br>
     * <code>w.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerda_cond_1() {
        return (WumpusMonster_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule esquerda is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean esquerda_cond(int index) {
        switch (index) {
            case 0: return esquerda_cond_0();
            case 1: return esquerda_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule esquerda that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_esquerda(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!esquerda_cond_0()) return false;
                if (!esquerda_cond_1()) return false;
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
    private boolean checkCondForDeclaration_esquerda(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule esquerda
     */
    private void esquerda() {	
			WumpusMonster_1.moveDown(WumpusMonster_1.getDirection());		
			WumpusMonster_1.moveLeft(WumpusMonster_1.getDirection());		
			modified(WumpusMonster_1);
	    }


      
    /**
     * Identifiers of rule direita
     */
    private String[] identifiers_direita = {
        "p",
        "w"
    };

    /**
     * Returns the identifiers declared in rule direita
     *
     * @return the identifiers declared in rule direita
     */
    private String[] getDeclaredIdentifiers_direita() {
         return identifiers_direita;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule direita.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_direita(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusMonster";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule direita.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_direita(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusMonster.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule direita.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_direita(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusMonster_1 = (WumpusMonster) value; break;
        }
    }

    /**
     * Returns an object declared in the rule direita.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_direita(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusMonster_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule direita
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_direita() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusMonster_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule direita
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_direita(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusMonster_1 = (WumpusMonster) objects[1];
    }

    /**
     * Condition 0 of rule direita.<p>
     * The original expression was:<br>
     * <code>w.getColumn() == 0</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean direita_cond_0() {
        return (WumpusMonster_1.getColumn() == 0);
    }

    /**
     * Condition 1 of rule direita.<p>
     * The original expression was:<br>
     * <code>w.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean direita_cond_1() {
        return (WumpusMonster_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule direita is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean direita_cond(int index) {
        switch (index) {
            case 0: return direita_cond_0();
            case 1: return direita_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule direita that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_direita(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!direita_cond_0()) return false;
                if (!direita_cond_1()) return false;
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
    private boolean checkCondForDeclaration_direita(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule direita
     */
    private void direita() {			
			WumpusMonster_1.moveUp(WumpusMonster_1.getDirection());			
			WumpusMonster_1.moveRight(WumpusMonster_1.getDirection());		
			modified(WumpusMonster_1);
	    }


   
    /**
     * Identifiers of rule ataque
     */
    private String[] identifiers_ataque = {
        "p",
        "w"
    };

    /**
     * Returns the identifiers declared in rule ataque
     *
     * @return the identifiers declared in rule ataque
     */
    private String[] getDeclaredIdentifiers_ataque() {
         return identifiers_ataque;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule ataque.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_ataque(int index) {
        switch (index) {
            case 0: return "ws.Perceptions";
            case 1: return "WumpusMonster";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule ataque.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_ataque(int index) {
        switch (index) {
            case 0: return ws.Perceptions.class;
            case 1: return WumpusMonster.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule ataque.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_ataque(int index, Object value) {
        switch (index) {
            case 0: this.ws_Perceptions_1 = (ws.Perceptions) value; break;
            case 1: this.WumpusMonster_1 = (WumpusMonster) value; break;
        }
    }

    /**
     * Returns an object declared in the rule ataque.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_ataque(int index) {
        switch (index) {
            case 0: return ws_Perceptions_1;
            case 1: return WumpusMonster_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule ataque
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_ataque() {
        return new Object[] {
                            ws_Perceptions_1,
                            WumpusMonster_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule ataque
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_ataque(Object[] objects) {
        ws_Perceptions_1 = (ws.Perceptions) objects[0];
        WumpusMonster_1 = (WumpusMonster) objects[1];
    }

    /**
     * Condition 0 of rule ataque.<p>
     * The original expression was:<br>
     * <code>p.getParfum()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ataque_cond_0() {
        return (ws_Perceptions_1.getParfum());
    }

    /**
     * Condition 1 of rule ataque.<p>
     * The original expression was:<br>
     * <code>w.planIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ataque_cond_1() {
        return (WumpusMonster_1.planIsEmpty());
    }

    /**
     * Checks whether some conditions of rule ataque is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ataque_cond(int index) {
        switch (index) {
            case 0: return ataque_cond_0();
            case 1: return ataque_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule ataque that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_ataque(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!ataque_cond_0()) return false;
                return true;
            case 1:
                if (!ataque_cond_1()) return false;
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
    private boolean checkCondForDeclaration_ataque(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule ataque
     */
    private void ataque() {			
			WumpusMonster_1.moveUp(WumpusMonster_1.getDirection());			
			WumpusMonster_1.moveRight(WumpusMonster_1.getDirection());
			WumpusMonster_1.moveDown(WumpusMonster_1.getDirection());
			WumpusMonster_1.moveRight(WumpusMonster_1.getDirection());
			modified(WumpusMonster_1);
	    }




    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "anda",
        "verificarMorteExplorador",
        "cima",
        "baixo",
        "esquerda",
        "direita",
        "ataque"
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
        2,
        2,
        2,
        2,
        2,
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
            case 0: return anda_cond(condIndex);
            case 1: return verificarMorteExplorador_cond(condIndex);
            case 2: return cima_cond(condIndex);
            case 3: return baixo_cond(condIndex);
            case 4: return esquerda_cond(condIndex);
            case 5: return direita_cond(condIndex);
            case 6: return ataque_cond(condIndex);
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
            case 0: return checkConditionsOnlyOf_anda(declIndex);
            case 1: return checkConditionsOnlyOf_verificarMorteExplorador(declIndex);
            case 2: return checkConditionsOnlyOf_cima(declIndex);
            case 3: return checkConditionsOnlyOf_baixo(declIndex);
            case 4: return checkConditionsOnlyOf_esquerda(declIndex);
            case 5: return checkConditionsOnlyOf_direita(declIndex);
            case 6: return checkConditionsOnlyOf_ataque(declIndex);
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
            case 0: return checkCondForDeclaration_anda(declIndex);
            case 1: return checkCondForDeclaration_verificarMorteExplorador(declIndex);
            case 2: return checkCondForDeclaration_cima(declIndex);
            case 3: return checkCondForDeclaration_baixo(declIndex);
            case 4: return checkCondForDeclaration_esquerda(declIndex);
            case 5: return checkCondForDeclaration_direita(declIndex);
            case 6: return checkCondForDeclaration_ataque(declIndex);
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
            case 0: return getDeclaredClassName_anda(declIndex);
            case 1: return getDeclaredClassName_verificarMorteExplorador(declIndex);
            case 2: return getDeclaredClassName_cima(declIndex);
            case 3: return getDeclaredClassName_baixo(declIndex);
            case 4: return getDeclaredClassName_esquerda(declIndex);
            case 5: return getDeclaredClassName_direita(declIndex);
            case 6: return getDeclaredClassName_ataque(declIndex);
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
            case 0: return getDeclaredClass_anda(declIndex);
            case 1: return getDeclaredClass_verificarMorteExplorador(declIndex);
            case 2: return getDeclaredClass_cima(declIndex);
            case 3: return getDeclaredClass_baixo(declIndex);
            case 4: return getDeclaredClass_esquerda(declIndex);
            case 5: return getDeclaredClass_direita(declIndex);
            case 6: return getDeclaredClass_ataque(declIndex);
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
            case 0: anda(); break;
            case 1: verificarMorteExplorador(); break;
            case 2: cima(); break;
            case 3: baixo(); break;
            case 4: esquerda(); break;
            case 5: direita(); break;
            case 6: ataque(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 7;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_anda();
            case 1: return getDeclaredIdentifiers_verificarMorteExplorador();
            case 2: return getDeclaredIdentifiers_cima();
            case 3: return getDeclaredIdentifiers_baixo();
            case 4: return getDeclaredIdentifiers_esquerda();
            case 5: return getDeclaredIdentifiers_direita();
            case 6: return getDeclaredIdentifiers_ataque();
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
            case 0: setObject_anda(declIndex, value); break;
            case 1: setObject_verificarMorteExplorador(declIndex, value); break;
            case 2: setObject_cima(declIndex, value); break;
            case 3: setObject_baixo(declIndex, value); break;
            case 4: setObject_esquerda(declIndex, value); break;
            case 5: setObject_direita(declIndex, value); break;
            case 6: setObject_ataque(declIndex, value); break;
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
            case 0: return getObject_anda(declIndex);
            case 1: return getObject_verificarMorteExplorador(declIndex);
            case 2: return getObject_cima(declIndex);
            case 3: return getObject_baixo(declIndex);
            case 4: return getObject_esquerda(declIndex);
            case 5: return getObject_direita(declIndex);
            case 6: return getObject_ataque(declIndex);
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
            case 0: return getObjects_anda();
            case 1: return getObjects_verificarMorteExplorador();
            case 2: return getObjects_cima();
            case 3: return getObjects_baixo();
            case 4: return getObjects_esquerda();
            case 5: return getObjects_direita();
            case 6: return getObjects_ataque();
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
            case 0: setObjects_anda(objects); break;
            case 1: setObjects_verificarMorteExplorador(objects); break;
            case 2: setObjects_cima(objects); break;
            case 3: setObjects_baixo(objects); break;
            case 4: setObjects_esquerda(objects); break;
            case 5: setObjects_direita(objects); break;
            case 6: setObjects_ataque(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private ws.Perceptions ws_Perceptions_1;
    private WumpusMonster WumpusMonster_1;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_WumpusInfoKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file WumpusInfoKB.rules
 *
 * @version 24/12/2014
 */
public class WumpusInfoKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public WumpusInfoKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public WumpusInfoKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_WumpusInfoKB(this);
    }

}
