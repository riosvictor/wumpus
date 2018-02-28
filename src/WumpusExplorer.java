
import ws.*;
import ws.agents.*;
import java.util.Vector;
import java.util.Random;

/**
 * Classe que implementa um agente explorador do mundo do wunpus
 *
 * @author Marco Antonio Costa Simoes
 * <a href="mailto:msimoes@uneb.br">msimoes@uneb.br</a>
 */
public class WumpusExplorer extends Explorer {

    /**
     * plano de acoes montado pelo agente explorador
     */
    private Vector plan;
    /**
     * representa��o interna do mundo
     */
    private Mapa map;

    /////////////////////////	
    private double vetProb[];

    /**
     * Construtor. Inicializa uma agente com os valores passados
     *
     * @param name nome do agente explorador
     * @param row linha inicial
     * @param column coluna inicial
     * @param direction dire��o inicial
     * @param rows n�mero de linhas do mundo
     * @param cols n�mero de colunas do mundo
     */
    WumpusExplorer(String name, int row, int column, int direction, int rows, int cols) {
        super(name, row, column, direction);
        plan = new Vector();
        map = new Mapa(rows, cols);

        // Inicializa vetor de probabilidades
        int n = cols * rows;
        vetProb = new double[n];
        for (int i = 0; i < n; i++) {
            vetProb[i] = -1;
        }
    }

    /**
     * Construtor. Inicializa uma agente com os valores passados
     *
     * @param name nome do agente explorador
     * @param row linha inicial
     * @param column coluna inicial
     * @param direction dire��o inicial
     * @param hasArrow determina se agente possui uma flecha
     * @param rows n�mero de linhas do mundo
     * @param cols n�mero de colunas do mundo
     */
    WumpusExplorer(String name, int row, int column, int direction, boolean hasArrow, int rows, int cols) {
        super(name, row, column, direction, hasArrow);
        plan = new Vector();
        map = new Mapa(rows, cols);

    }

    /**
     * Metodo para marcar a vizinhan�a como insegura em caso de haver brisa na
     * posicao atual.
     *
     */
    public void haBrisa() {
        map.setVizInsegura(getMapPosition());

    }

    /**
     * M�todo auxiliar que retorna o n�mero da sala dada sua posi��o no mapa
     *
     * @return n�mero da sala
     */
    public int getMapPosition() {
        return map.getSalaNum(getColumn(), getRow());
    }

    /**
     * � adicionada ao plano uma sequ�ncia de a&ccedil;oes que faz o agente
     * mover-se para cima.
     *
     * @param dir a dire&ccedil;ao atual do agente
     * @return a nova dire&ccedil;ao do agente ap&oacute;s o movimento.
     *
     */
    public int moveUp(int dir) {
        switch (dir) {
            case UP:
                plan.add(Action.WALK);
                break;
            case LEFT:
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.WALK);
                break;
            case DOWN:
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.WALK);
                break;
            case RIGHT:
                plan.add(Action.TURN_LEFT);
                plan.add(Action.WALK);
                break;
        }
        return UP;
    }

    /**
     * � adicionada ao plano uma sequ�ncia de acoes que faz o agente mover-se
     * para baixo.
     *
     * @param dir a direcao atual do agente
     * @return a nova direcao do agente apos o movimento.
     *
     */
    public int moveDown(int dir) {
        switch (dir) {
            case DOWN:
                plan.add(Action.WALK);
                break;
            case RIGHT:
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.WALK);
                break;
            case UP:
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.WALK);
                break;
            case LEFT:
                plan.add(Action.TURN_LEFT);
                plan.add(Action.WALK);
                break;
        }
        return DOWN;
    }

    /**
     * � adicionada ao plano uma sequ�ncia de acoes que faz o agente mover-se
     * para direita.
     *
     * @param dir a direcao atual do agente
     * @return a nova direcao do agente apos o movimento.
     *
     */
    public int moveRight(int dir) {
        switch (dir) {
            case RIGHT:
                plan.add(Action.WALK);
                break;
            case UP:
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.WALK);
                break;
            case LEFT:
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.WALK);
                break;
            case DOWN:
                plan.add(Action.TURN_LEFT);
                plan.add(Action.WALK);
                break;
        }
        return RIGHT;
    }

    /**
     * � adicionada ao plano uma sequ�ncia de a�oes que faz o agente mover-se
     * para esquerda.
     *
     * @param dir a dire�ao atual do agente
     * @return a nova dire�ao do agente ap�s o movimento.
     *
     */
    public int moveLeft(int dir) {
        switch (dir) {
            case LEFT:
                plan.add(Action.WALK);
                break;
            case DOWN:
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.WALK);
                break;
            case RIGHT:
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.TURN_RIGHT);
                plan.add(Action.WALK);
                break;
            case UP:
                plan.add(Action.TURN_LEFT);
                plan.add(Action.WALK);
                break;
        }
        return LEFT;
    }

    /**
     * � adicionada ao plano a a��o de Pegar o Ouro
     */
    public void getGold() {
        plan.add(Action.GRAB);
        setHasGold(true);
    }

    /**
     * Marca posi��o do mapa dada como visitada. Se for a primeira vez que passa
     * nesta sala, inclui seus vizinhos nao visitados nos objetivos a visitar.
     *
     * @param n n�mero ou r�tulo do n�
     */
    public void setVisited(int n) {
        map.setVisited(n);
    }

    /**
     * Marca os vizinhos da posicao atual do agente como seguros
     *
     */
    public void setVizSegura() {
        map.setVizSegura(this.getMapPosition());
    }

    /**
     * Marca posi��o atual como visitada.
     */
    public void setVisited() {
        //pegando posi��o
        int n = getMapPosition();
        setVisited(n);
    }

    /**
     * Retorna a quantidade de salas
     */
    public int sizeMapa() {
        return map.sizeMap();
    }

    /**
     * Retorna <code>true</code> se o plano do agente for vazio.
     *
     * @return valor-verdade indicando se o plano esta vazio
     */
    public boolean planIsEmpty() {
        return plan.isEmpty();
    }

    /**
     * Retorna a pr�xima a��o do plano. Ao retornar a a��o esta � removida do
     * plano
     *
     * @return A&ccedil;ao a ser executada
     */
    public Action nextAction() {
        return (Action) plan.remove(0);
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    
    //FUGINDO DO WUMPUS
    //
    public void run() { 
        int pos = getColumn();
        //
        if (pos < 4) {
            moveRight(getDirection());
            moveRight(getDirection());
        } else if (pos > 4) {
            moveLeft(getDirection());
            moveLeft(getDirection());
        }
    }

    public void leave() {
        plan.add(Action.LEAVE);
    }

    public boolean inMap(int n) {
        return this.map.inMap(n);
    }

    public Mapa getMap() {
        return map;
    }

    public Vector getPlan() {
        return plan;
    }

    public int getColumns() {
        return this.getMap().getColumns();
    }

    public int getRows() {
        return this.getMap().getRows();
    }

    public int getRedundancias() {
        return map.getRedundancias();
    }

    public boolean isVisited(int n) {
        return (this.map.isVisited(n) ? true : false);            
    }

    public boolean existeProbPitZero(int n) {
        return (this.probPitZero(n) == -1 ? false : true);            
    }
    
    public boolean sorte() {        
        return new Random().nextBoolean();
    }

    public double getProbPit(int n) {
        return map.probPit(n);
    }

    public int getContX(int n) {
        return this.map.getContX(n);
    }
    

    public void imprimirProbViz(int n) {

        if (inMap(n)) {
            int centro = n;
            int size = map.getMapa()[centro].size();
            for (int i = 0; i < size; i++) {
                Sala s = (Sala) map.getMapa()[centro].get(i);
                System.out.println("PROBPIT" + s.getLabel() + ": " + map.probPit(s.getLabel()));
            }
        }

    }

    // SEGUE EM DIRECAO DA POSICAO ATUAL, PARA POSICAO DESEJADA	
    public void irParaPos(int posAtual, int posFutura) {

        //POSICAO NAO EXISTE
        if (posFutura == -1) {
            return;
        }

        //SE ATUAL EH MAIOR, A POSICAO DESEJADA ESTA A ESQUERDA ou EM CIMA
        ////ATUAL - 1 = FUTURA -> ESQUERDA
        ////ATUAL -1 != FUTURA -> BAIXO
        //
        ////SE ATUAL EH MENOR, A POSICAO DESEJADA ESTA A DIREITA OU EM BAIXO
        //ATUAL + 1 = FUTURA -> DIREITA
        //ATUAL + 1 != FUTURA -> CIMA
        //
        if (posAtual > posFutura) {
            if ((posAtual - 1) == (posFutura)) { 
                this.moveLeft(this.getDirection());
            } else {
                this.moveDown(this.getDirection());
            }
        } else {
            if ((posAtual + 1) == (posFutura)) {
                this.moveRight(this.getDirection());
            } else {
                this.moveUp(this.getDirection());
            }
        }
    }

    public int probPitZero(int n) {
        /* ESCOLHE UM NO AO ACASO, COM PROBABILIDADE ZERO */
        int x;
        Random gerador = new Random();
        
        // 7  A FIM DE AUMENTAR A PROBABILIDADE DE IR PARA ESQUERDA
        x = gerador.nextInt(6);

        switch (x) {
            //VERIFICA COMECANDO POR BAIXO//
            case 0:
                //EM BAIXO
                if ((map.inMap(n - map.getColumns())) && (map.probPit(n - map.getColumns()) == 0)) {
                    return n - map.getColumns();
                }
                //DIREITA
                if ((map.inMap(n + 1)) && (map.probPit(n + 1) == 0)) {
                    return n + 1;
                }
                //EM CIMA
                if ((map.inMap(n + map.getColumns())) && (map.probPit(n + map.getColumns()) == 0)) {
                    return n + map.getColumns();
                }
                //ESQUERDA
                if ((map.inMap(n - 1)) && (map.probPit(n - 1) == 0)) {
                    return n - 1;
                }
            //VERIFICA COMECANDO POR BAIXO//
            case 4:
                //EM BAIXO
                if ((map.inMap(n - map.getColumns())) && (map.probPit(n - map.getColumns()) == 0)) {
                    return n - map.getColumns();
                }
                //DIREITA
                if ((map.inMap(n + 1)) && (map.probPit(n + 1) == 0)) {
                    return n + 1;
                }
                //EM CIMA
                if ((map.inMap(n + map.getColumns())) && (map.probPit(n + map.getColumns()) == 0)) {
                    return n + map.getColumns();
                }
                //ESQUERDA
                if ((map.inMap(n - 1)) && (map.probPit(n - 1) == 0)) {
                    return n - 1;
                }

            //VERIFICA COMECANDO PELA DIREITA//
            case 1:
                //DIREITA
                if ((map.inMap(n + 1)) && (map.probPit(n + 1) == 0)) {
                    return n + 1;
                }
                //EM BAIXO
                if ((map.inMap(n - map.getColumns())) && (map.probPit(n - map.getColumns()) == 0)) {
                    return n - map.getColumns();
                }
                //EM CIMA
                if ((map.inMap(n + map.getColumns())) && (map.probPit(n + map.getColumns()) == 0)) {
                    return n + map.getColumns();
                }
                //ESQUERDA
                if ((map.inMap(n - 1)) && (map.probPit(n - 1) == 0)) {
                    return n - 1;
                }

            //VERIFICA COMECANDO POR CIMA//
            case 2:
                //EM CIMA
                if ((map.inMap(n + map.getColumns())) && (map.probPit(n + map.getColumns()) == 0)) {
                    return n + map.getColumns();
                }
                //DIREITA
                if ((map.inMap(n + 1)) && (map.probPit(n + 1) == 0)) {
                    return n + 1;
                }
                //EM BAIXO
                if ((map.inMap(n - map.getColumns())) && (map.probPit(n - map.getColumns()) == 0)) {
                    return n - map.getColumns();
                }
                //ESQUERDA
                if ((map.inMap(n - 1)) && (map.probPit(n - 1) == 0)) {
                    return n - 1;
                }

            //VERIFICA COMECANDO PELA ESQUERDA//
            case 3:
                //ESQUERDA
                if ((map.inMap(n - 1)) && (map.probPit(n - 1) == 0)) {
                    return n - 1;
                }
                //EM CIMA
                if ((map.inMap(n + map.getColumns())) && (map.probPit(n + map.getColumns()) == 0)) {
                    return n + map.getColumns();
                }
                //DIREITA
                if ((map.inMap(n + 1)) && (map.probPit(n + 1) == 0)) {
                    return n + 1;
                }
                //EM BAIXO
                if ((map.inMap(n - map.getColumns())) && (map.probPit(n - map.getColumns()) == 0)) {
                    return n - map.getColumns();
                }

            //VERIFICA COMECANDO PELA ESQUERDA//
            case 5:
                //ESQUERDA
                if ((map.inMap(n - 1)) && (map.probPit(n - 1) == 0)) {
                    return n - 1;
                }
                //EM CIMA
                if ((map.inMap(n + map.getColumns())) && (map.probPit(n + map.getColumns()) == 0)) {
                    return n + map.getColumns();
                }
                //DIREITA
                if ((map.inMap(n + 1)) && (map.probPit(n + 1) == 0)) {
                    return n + 1;
                }
                //EM BAIXO
                if ((map.inMap(n - map.getColumns())) && (map.probPit(n - map.getColumns()) == 0)) {
                    return n - map.getColumns();
                }
        }
        return -1;
    }

    public boolean existeSalaOkNaoVisitada(Vector[] mapa) {

        for (int n = 0; n < mapa.length; n++) {

            if (isVisited(n)) {
                int size = mapa[n].size();

                //OBTEM CADA NO A QUE n ESTA LIGADO                
                for (int i = 0; i < size; i++) {
                    Sala s = (Sala) mapa[n].get(i);
                    if ((map.probPit(s.getLabel()) == 0.0) && (!s.isVisited())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void setVetProb(Vector[] mapa) {
        for (int n = 0; n < mapa.length; n++){
            vetProb[n] = this.getProbPit(n);
        }
    }

    public double getMenorProbGeral(Vector[] mapa) {
        int i;
        setVetProb(mapa);
        double menor = 99;
        for (i = 1; i < mapa.length; i++) {
            if ((menor > vetProb[i]) && (vetProb[i] > 0)) {
                menor = vetProb[i];
            }
        }
        return menor;
    }

    /////////////////////////////////////////////////////////////////////////////
    //RETORNA A DIRECAO DA BORDA EM QUE O AGENTE ESTA POSICIONADO, CASO SEJA UMA DAS 
    //QUATRO EXTREMIDADES ELE RETORNA A PROPRIA EXTREMIDADE	
    public int getBorda(int n) {
        if ((n % this.getColumns()) == 7 && (n != 63) && (n != 7)) {// se N estiver no canto direito e n�o for uma das extremidades 
            return this.RIGHT;
        }
        //
        if ((n % this.getColumns()) == 0 && (n != 0) && (n != 56)) {// se N estiver no canto esquerdo e n�o for uma das extremidades
            return this.LEFT;
        }
        //
        if ((n > 55) && (n != 56) && (n != 63)) {// se N estiver no canto superior e n�o for uma das extremidades
            return this.UP;
        }
        //
        if ((n < 8) && (n != 7) && (n != 0)) {// se N estiver no canto inferior e n�o for uma das extremidades
            return this.DOWN;
        }
        //
        return (n == 0 || n == 7 || n == 56 || n == 63) ? n : -1;            
    }

    public boolean isBorda(int n) {

        switch (n) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return true;
            case 8:
                return true;
            case 15:
                return true;
            case 23:
                return true;
            case 24:
                return true;
            case 31:
                return true;
            case 32:
                return true;
            case 39:
                return true;
            case 47:
                return true;
            case 48:
                return true;
            case 55:
                return true;
            case 56:
                return true;
            case 57:
                return true;
            case 58:
                return true;
            case 59:
                return true;
            case 60:
                return true;
            case 61:
                return true;
            case 62:
                return true;
            case 63:
                return true;

            default:
                return false;
        }

    }

    /////////////////////////////////////////////////////////////////////////////
    ////METODO USADO PARA DESCOBRIR QUAL A MENOR PROBABILIDADE DE HAVER BURACO
    //DENTRE OS VIZINHOS QUE NAO FORAM VISITADOS
    public double getMenorProbPit(int n) {

        double menor = 2;

        if (inMap(n)) {
            int centro = n;
            int size = map.getMapa()[centro].size();
            for (int i = 0; i < size; i++) {
                Sala s = (Sala) map.getMapa()[centro].get(i);
                if (!s.isVisited() && s.getProb() > 0) {
                    if (menor > s.getProb()) {
                        menor = s.getProb();
                        System.out.println("getLabel: " + s.getLabel() + "\nProb: " + menor);
                    }
                }
            }
        }
        return menor;
    }

/////////////////////////////////////////////////////////////////////////////
//METODO QUE TEM FUNCIONALIDADE SEMELHANTE A ANTERIOR, POREM ESTE RETORNA O 
//NUMERO DE SALAS
    public int menorProbPit(int n) {

        double menor = 2;
        int label = -1;

        if (inMap(n)) {
            int centro = n;
            int size = map.getMapa()[centro].size();
            for (int i = 0; i < size; i++) {
                Sala s = (Sala) map.getMapa()[centro].get(i);
                if (!s.isVisited() && s.getProb() > 0) {
                    if (menor > s.getProb()) {
                        label = s.getLabel();
                        menor = s.getProb();
                        System.out.println("Label: " + label + "\nProb: " + menor);
                    }
                }
            }
        }
        return label;
    }

}