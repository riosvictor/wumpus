import java.sql.*;
import java.io.IOException;
import ws.*;
import ws.agents.*;

/**
 * Classe de teste que implementa um agente explorador do mundo do wunpus
 *
 
 */
public class ExplorerX extends BasicExplorer {

	private Action[] actions = new Action[1];
	private Perceptions perceptions;
	private WumpusExplorer explorer;

	private final int ALIVE = 0;
	private final int DEAD  = 1;

	private static int rodada;
	private static int n_agentes;
	private int salas_visitadas = 0;
	private int n_turnos = 0;
	private int redundancias = 0;
	private boolean ouro = false;
	private boolean vida;
	private int n_salas=0;

	public ExplorerX(String name, String serverHost, int serverPort,
				int localPort) throws IOException, AgentCreationException {

		super(name, serverHost, serverPort, localPort);
    explorer = new WumpusExplorer("WumpusExplorer",0,0,RIGHT,8,8);

	}
  /**
   * Este m&eacute;todo &eacute; chamado pelo simulador do Ambiente a cada
   * rodada passando as percep&ccedil;oes e recebendo uma lista de a&ccedil;oes
   * a serem executadas.
   * @param turn contem as percep&ccedil;oes e demais informa&ccedil;oes da rodada.
   * @return array de a&ccedil;oes.
   *
   * @author   Marco Antonio Costa Simoes <a href="mailto:msimoes@uneb.br">msimoes@uneb.br</a>
  
   */
	public Action[] messageReceived(TurnNotification turn) {
		//faz as percepções
		perceptions = turn.getPerceptions();

    while(explorer == null) ;
    explorer.setVisited();

		//Ações são colocadas aqui
		if (turn.isTurnBeginning()){
			if (explorer.planIsEmpty()) {
				//Replaneja
          WumpusKB wkb = new WumpusKB(new jeops.conflict.OneShotConflictSet());

          wkb.tell(explorer);
          wkb.tell(perceptions);
          wkb.run();

		  		if (explorer.planIsEmpty()){
			  		actions[0] = Action.NOP;
				  } else {
					  actions[0] = explorer.nextAction();
				 }
      } else {
				 actions[0] = explorer.nextAction();
      }
    }

		if (turn.isTurnEnding()){
       if(turn.getNumberOfActions()>0)   {
          if(actions[0]==Action.WALK)
            explorer.walk();
          else if(actions[0]==Action.TURN_LEFT)
            explorer.turnLeft();
          else if(actions[0]==Action.TURN_RIGHT)
            explorer.turnRight();
      }
      if (actions[0]==Action.LEAVE || ouro)
   			exit(ALIVE);
    }

		n_turnos++;
		return actions;

	}

	/**
	 * Method called to say that this agent was killed.
	 */
	public void killed() {
		exit(DEAD);
		System.out.println("Goodbye!");
	}
	
	public void exit(int state){
		switch(state){
			case ALIVE:
				vida = true;
				ouro =  true;
				break;
			case DEAD:
				vida = false;
				break;
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		int serverPort, localPort;
		String host;
		if (args.length == 0) {
			host = "localhost";
		} else {
			host = args[0];
		}
		if (args.length < 2) {
			serverPort = 4445;
		} else {
			serverPort = Integer.parseInt(args[1]);
		}
		if (args.length < 3) {
			localPort = 2102;
		} else {
			localPort = Integer.parseInt(args[2]);
		}
		try {
			long l = Math.round(Math.random() * 10000);
			new ExplorerX("ExplorerX " + l, host, serverPort, localPort);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
}