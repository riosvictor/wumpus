import ws.*;
import ws.agents.*;
import java.util.Vector;
import java.util.HashMap;

/**
 * Classe que implementa um agente Monstro Wumpus que vaga pelo mapa à procura do agente explorador
 *
 * @author   Marco Antonio Costa Simoes <a href="mailto:macs3@cin.ufpe.br">macs3@cin.ufpe.br</a>
 * @author   Erivan Alves de Andrade<a href="mailto:eaa@cin.ufpe.br">eaa@cin.ufpe.br</a>
 * @author   Aida Araujo Ferreira<a href="mailto:aaf@cin.ufpe.br">aaf@cin.ufpe.br</a>
 * @version  1.0, Julho 2001.
 */
public class WumpusMonster extends Wumpus {

	/**
	 * plano de a&ccedil;oes montado pelo agente explorador
	 */
	private Vector plan;
	/**
	 * representação interna do mundo
	 */
	private Mapa map;

	//Variáveis criadas por Luciana Patricia	
	public boolean plano;

	public String house_BeforeParfum;
	
	public boolean house1_Check;
	public boolean house2_Check;
	public boolean house3_Check;
	public boolean house4_Check;
	
	public int house_Parfum = 0;
					
	/**
	 * Construtor. Inicializa uma agente com os valores passados
	 *
	 * @param name nome do agente explorador
	 * @param row linha inicial
	 * @param column coluna inicial
	 * @param direction direção inicial
	 * @param rows número de linhas do mundo
	 * @param cols número de colunas do mundo
	 */
	WumpusMonster(String name, int row, int column, int direction, int rows, int cols){
		super(name,row,column,direction);
		plan = new Vector();
		map = new Mapa(rows,cols);

		//Variáveis criadas por Luciana Patricia		
		plano = false;
	}
	
	/**
	 * Método auxiliar que retorna o número da sala dada sua posição no mapa
	 *
	 * @return número da sala
	 */
	public int getMapPosition(){
		return map.getSalaNum(getColumn(),getRow());
	}

 /**
   * É adicionada ao plano uma sequência de a&ccedil;oes que faz o agente mover-se para cima.
   *
   * @param dir a dire&ccedil;ao atual do agente
   * @return a nova dire&ccedil;ao do agente ap&oacute;s o movimento.
   *
   */
	public int moveUp(int dir){
		switch (dir){
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
   * É adicionada ao plano uma sequência de a&ccedil;oes que faz o agente mover-se para baixo.
   *
   * @param dir a dire&ccedil;ao atual do agente
   * @return a nova dire&ccedil;ao do agente ap&oacute;s o movimento.
   *
   */
	public int moveDown(int dir){
		switch (dir){
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
   * É adicionada ao plano uma sequência de a&ccedil;oes que faz o agente mover-se para direita.
   *
   * @param dir a dire&ccedil;ao atual do agente
   * @return a nova dire&ccedil;ao do agente ap&oacute;s o movimento.
   *
   */
	public int moveRight(int dir){
		switch (dir){
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
   * É adicionada ao plano uma sequência de a&ccedil;oes que faz o agente mover-se para esquerda.
   *
   * @param dir a dire&ccedil;ao atual do agente
   * @return a nova dire&ccedil;ao do agente ap&oacute;s o movimento.
   *
   */
	public int moveLeft(int dir){
		
		switch (dir){
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
	 * Retorna a quantidade de salas
	 */
	public int sizeMapa(){
		return map.sizeMap();
	}

	/**
	 * Retorna <code>true</code> se o  plano do agente for vazio.
	 *
	 * @return valor-verdade indicando se o plano est&aacute; vazio
	 */
	public boolean planIsEmpty(){
		return plan.isEmpty();
	}

	/**
	 * Retorna a próxima ação do plano. Ao retornar a ação esta é removida do plano
   * @return A&ccedil;ao a ser executada
	 */
	public Action nextAction(){
		return (Action)plan.remove(0);
	}
	/**
	 * Não faz nada
         */
	public void doNothing() {
		plan.clear();
	}

	public int anda2() {
		boolean walkl = false;
		
		System.out.println("TENHO QUE ANDAR");
		//Se eu estou na primeira ou na última linha, mude de direção
		if (getRow() == 7)
		{
			walkl = true;
			System.out.println("GOING DOWN");
			this.moveDown(this.getDirection());			
		}
		else if (getRow() == 0)
		{
			walkl = true;
			System.out.println("GOING UP");
			this.moveUp(this.getDirection());			
		}
		
		//Se eu estou na primeira ou na última coluna, mude de direção
		if (getColumn() == 7)
		{
			walkl = true;
			System.out.println("GOING LEFT");
			this.moveLeft(this.getDirection());			
		}
		else if (getRow() == 0)
		{
			walkl = true;
			System.out.println("GOING RIGHT");
			this.moveRight(this.getDirection());			
		}
		
		//Ande normalmente
		if(walkl == false)
		{
			//Ande normalmente
			System.out.println("WALKING 1");
			plan.add(Action.WALK);			
		}
		
		System.out.println("TO SAINDO");
		return 0;
	}

	public void anda() {
		 int dir;
		 switch(this.getDirection()) {
			case UP: if(map.inMap(getMapPosition()+8))  {
				System.out.println("UP coluna"+ getColumn()+"linha "+getRow());
				System.out.println(map.inMap(getMapPosition()+8));
                                       if (getRow()<=7){
					plan.add(Action.WALK);
	  				dir=UP;
					}
				 }
				 else {
					plan.add(Action.TURN_LEFT);
					System.out.println("ELSE UP coluna"+ getColumn()+"linha "+getRow());
					System.out.println(map.inMap(getMapPosition()));
					dir=RIGHT;
				}
				break;
			case LEFT: if(map.inMap(getMapPosition()-1))  {
					if(getColumn()>0){
					System.out.println(map.inMap(getMapPosition()-1));
					System.out.println("left  coluna"+ getColumn()+"linha "+getRow());
								
					plan.add(Action.WALK);
	  				dir=LEFT;
					}
				 }
				 else {
					plan.add(Action.TURN_LEFT);
					System.out.println("senao do left  coluna"+ getColumn()+"linha "+getRow());
					dir=UP;
					
					
				}
				break;
			case DOWN: if(map.inMap(getMapPosition()-8))  {
					System.out.println("DONW coluna"+ getColumn()+"linha "+getRow());
					System.out.println(map.inMap(getMapPosition()-8));
					 if (getRow()>=0){
					plan.add(Action.WALK);						
					
	  				dir=DOWN;
					}
				 }
				 else {
					System.out.println("else do downcoluna"+ getColumn()+"linha "+getRow());
					plan.add(Action.TURN_LEFT);
					dir=LEFT;
				}
				break;
			case RIGHT: if(map.inMap(getMapPosition()+1))  {
                                        if(getColumn()<=7){
						plan.add(Action.WALK);
	  					dir=RIGHT;
						System.out.println("RIGHT coluna"+ getColumn()+"linha "+getRow());
						System.out.println(map.inMap(getMapPosition()+1));
				 	}else{
					System.out.println("ELSE DO RIGHT coluna"+ getColumn()+"linha "+getRow());
					plan.add(Action.TURN_LEFT);
					
					dir=DOWN;
					
					}

                                 }
				 else {
					System.out.println("ELSE DO RIGHT coluna"+ getColumn()+"linha "+getRow());
					plan.add(Action.TURN_LEFT);
					plan.add(Action.WALK);
					
					dir=UP;
				}
				break;
		}
	}
				
	
}
