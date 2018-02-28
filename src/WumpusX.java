import java.sql.*;
import java.io.IOException;
import ws.*;
import ws.agents.*;

public class WumpusX extends BasicWumpus {
	private WumpusMonster wumpus;
	private Action[] actions = new Action[1];
	private Perceptions perceptions = null;
  WumpusX(String name, String serverHost, int serverPort, int localPort, int rows, int cols) throws IOException, AgentCreationException  {

    

    super(name,serverHost,serverPort,localPort);

    int aleatorio;
    do {
      aleatorio  =    Math.round((float)(Math.random()*10));
    } while(aleatorio>=rows);
    int linha = aleatorio;
    do{
      aleatorio =       Math.round((float)(Math.random()*10));
    } while (aleatorio>=cols);
    int coluna = aleatorio;

    wumpus = new WumpusMonster("Wumpus",linha,coluna,UP,8,8);
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
			new WumpusX("WumpusX " + l, host, serverPort, localPort, 8, 8);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
  }

 /**
   * Este m&eacute;todo &eacute; chamado pelo simulador do Ambiente a cada
   * rodada passando as percep&ccedil;oes e recebendo uma lista de a&ccedil;oes
   * a serem executadas.
   * @param turn contem as percep&ccedil;oes e demais informa&ccedil;oes da rodada.
   * @return array de a&ccedil;oes.
   *
   * @author   Marco Antonio Costa Simoes <a href="mailto:macs3@cin.ufpe.br">macs3@cin.ufpe.br</a>
   * @version  1.0, Julho 2001.
   */
public Action[] messageReceived(TurnNotification turn) {
		//faz as percepções
    perceptions = turn.getPerceptions();

    while(wumpus == null) ;
    		
		//Ações são colocadas aqui
	if (turn.isTurnBeginning()){
			WumpusInfoKB wkb = new WumpusInfoKB(new jeops.conflict.OneShotConflictSet());
//		actions[0]= Action.NOP;

          wkb.tell(wumpus);
          wkb.tell(perceptions);
          wkb.run();

		  		if (wumpus.planIsEmpty()){
			  		actions[0] = Action.NOP;
				  } else {
					  actions[0] = wumpus.nextAction();
				 } 
      }


	if (turn.isTurnEnding()){
       if(turn.getNumberOfActions()>0)   {
          if(actions[0]==Action.WALK)
            wumpus.walk();
          else if(actions[0]==Action.TURN_LEFT)
            wumpus.turnLeft();
          else if(actions[0]==Action.TURN_RIGHT)
            wumpus.turnRight();
      }

    }

//		n_turnos++;
		return actions;

	}

}