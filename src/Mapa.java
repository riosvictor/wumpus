import java.util.Vector;

/**
 * Classe que implementa o mapa do mundo utilizado pelo agente explorador do mundo do Wumpus.
 *
 * @author   Aydano Pamponet Machado <a href="mailto:apm@cin.ufpe.br">apm@cin.ufpe.br</a>
 * @author   Giordano Ribeiro Eul�lio Cabral<a href="mailto:grec@cin.ufpe.br">grec@cin.ufpe.br</a>
 * @version  1.0, Mar�o 2001.
 */
public class Mapa {

	private Vector[] mapa;
	
	int rows,cols; //n�mero de linhas e colunas
	
	private int redundancias;

        ///////////////////////////////////
	private int contX[];


	/**
	 * Constutor.
	 *
	 * @param linhas n�mero de linhas.
	 * @param colunas n�mero de colunas.
	 */
	Mapa(int linhas, int colunas){
		int x,y,n; //posi��es x,y e n�mero de elementos do mapa
		
		
		rows = linhas;
		cols = colunas;
		n = rows*cols;
		mapa = new Vector[n];
		redundancias = 0;
		
                /////////////////////////////////////////////////////
                ///VETOR DE SALAS JAH VISITADAS
		contX = new int[n];
                /////

		// inicializa��o do vetor que conta quantas vezes foi visitado e do mapa de probabilidades
		for (int i=0;i<n;i++){
			contX[i]=0;
		}
		
		//inicializando o mapa
		for (int i=0;i<mapa.length;i++){
			mapa[i]=new Vector(4);
		}
		
		//constroi o mapa ou grafo
		for (int i=0;i<n;i++){
			
			x = i % cols;
			y = i / cols;
 //System.out.println("X:"+x+" Y:"+y);
			//n� acima
			if (y+1 < rows){
//System.out.println("Adicionando: "+getSalaNum(x,y+1));
				mapa[i].add(new Sala(getSalaNum(x,y+1)));
			}
			//n� abaixo
			if (y > 0){
//System.out.println("Adicionando: "+getSalaNum(x,y-1)+"a Mapa["+i+"]");
				mapa[i].add(new Sala(getSalaNum(x,y-1)));
			}
			//n� a esquerda
			if (x > 0){
//System.out.println("Adicionando: "+getSalaNum(x-1,y));
				mapa[i].add(new Sala(getSalaNum(x-1,y)));
			}
			//n� a direita
			if (x+1 < cols){
//System.out.println("Adicionando: "+getSalaNum(x+1,y));
				mapa[i].add(new Sala(getSalaNum(x+1,y)));
			}
		}
   
	}

	
	/**
	 * M�todo auxiliar que retorna o n�mero da sala dada sua posi��o
	 *
	 * @return n�mero da sala
	 */
	public int getSalaNum(int x, int y){
		return (y*cols + x);
	}
	
	/**
	 * Retorna o n�mero de redund�ncias
	 */
	public int getRedundancias(){
		return redundancias;
	}
	
	/**
	 * Retorna o n�mero de salas visitadas
	 */
	public int getSalasVisitadas(){
		int visited = 0;
		for(int i=0;i<mapa.length;i++){
			if (isVisited(i))
				visited++;
		}
		return visited;
	}
	
	/**
	 * Retorna a quantidade de salas
	 */
	public int sizeMap(){
		return mapa.length;
	}
	/**
	 * M�todo auxiliar que verifica se o ponto dado esta dentro do mapa.
	 *
	 * @param x posi��o X ou coluna
	 * @param y posi��o Y ou linha
	 */
	public boolean inMap(int x, int y){
		return ((-1<x) && (x<cols) && (-1<y) && (y<rows));
	}
	
	/**
	 * M�todo auxiliar que verifica se o ponto dado esta dentro do mapa.
	 *
	 * @param n n�mero ou r�tulo do ponto
	 */
	public boolean inMap(int n){
		return ((-1<n) && (n<cols*rows));
	}
	
	/**
	 * Retorna o n�mero de linhas do mapa
	 *
	 * @return n�mero de linhas
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Retorna o n�mero de colunas do mapa
	 *
	 * @return n�mero de colunas
	 */
	public int getColumns(){
		return cols;
	}

	/**
	 * Retorna a vizinhan�a do n� dado
	 *
	 * @param n n�mero ou r�tulo do n�
	 */
	public Vector getViz(int n){
		if (inMap(n)){
			return (Vector)mapa[n];
		} else {
			return null;
		}
	}
	
	/**
	 * Calcula a probabilidade de ter buraco no ponto dado.
	 *
	 * @param x posi��o X ou coluna do ponto central da vizinha�a 
	 * @param y posi��o Y ou linha do ponto central da vizinha�a 
	 *
	 * @return probabilidade de ter buraco, <code>-1</code> caso n�o seja poss�vel calcular
	 */
	public double probPit(int n){
		//se n� j� foi visitado probilidade de pit = 0
		if (isVisited(n))
			return 0;
		
		int tam = mapa[n].size();
		//se tiver alguma com 0 retorna 0
		for (int i=0;i<tam;i++){
			Sala s = (Sala)mapa[n].get(i);
			if (s.getProb()==0.0)
				return 0;
		}
		//calculando probabilidade
		double prob = -1.0;
		for (int i=0;i<tam;i++){
			Sala s = (Sala)mapa[n].get(i);
			double p1 = s.getProb();
			if (p1!=-1.0){
				if (prob==-1.0) {
					prob = p1;
				} else {
					prob += p1 * (1 - prob);
				}
			}
		}
  //  System.out.println("No " + n + "prob " + prob);
		return prob;
	}
	
	/**
	 * Calcula a probabilidade de ter buraco no ponto dado.
	 *
	 * @param n n�mero ou r�tulo do ponto
	 *
	 * @return probabilidade de ter buraco, <code>-1</code> caso n�o seja poss�vel calcular
	 */
	public double probPit(int x, int y){
		int n = getSalaNum(x,y);
		return probPit(n);
	}
	

	
	/**
	 * Seta a vizinha�a como segura, dado o ponto central da vizinhan�a.
	 *
	 * @param x posi��o X ou coluna do ponto central da vizinha�a 
	 * @param y posi��o Y ou linha do ponto central da vizinha�a 
	 */
	 public void setVizSegura(int x, int y){
		 if (inMap(x,y)) {
		 	int centro = getSalaNum(x, y);
		 	setVizSegura(centro);
		 }
	 }
	 
	 /**
	 * Seta a vizinha�a como segura, dado o ponto central da vizinhan�a.
	 *
	 * @param n n�mero ou r�tulo do ponto
	 */
	 public void setVizSegura(int n){
     if (inMap(n)) {
		 	int centro = n;
			int size = mapa[centro].size();
			boolean insegura = false;
			//coloca a probabilidade de cada sala como 0
			for (int i=0; i<size; i++){
				Sala s = (Sala)mapa[centro].get(i);
				//verifica se a sala estava marcada como insegura
				if (probPit(s.getLabel())>0.0){
					insegura = true;
				}
				s.setSegura();
				//setando caminho de volta
				int j = 0; int volta = s.getLabel();
				while(j<mapa[volta].size()){
					Sala v = (Sala)mapa[volta].get(j);
					if (v.getLabel()==centro){
						v.setSegura();
						break;
					}
					j++;
				}
				//se insegura recalcula a vizinha�a
				if (insegura){
					setVizInsegura(s.getLabel());
				}
			}
		 }

	 }
	 
	/**
	 * Seta vizinha�a como insegura, dado o ponto central da vizinhan�a.
	 * S�o atribuidas probabilidades a cada sala de modo individual.
	 *
	 * @param x posi��o X ou coluna do ponto central da vizinha�a 
	 * @param y posi��o Y ou linha do ponto central da vizinha�a
	 */ 
	 public void setVizInsegura(int x, int y){
		 if (inMap(x,y)) {
		 	int centro = getSalaNum(x, y);
		 	setVizInsegura(centro);
		 }
	 }
	 
	 /**
	 * Seta vizinha�a como insegura, dado o ponto central da vizinhan�a.
	 * S�o atribuidas probabilidades a cada sala de modo individual.
	 *
	 * @param n n�mero ou r�tulo do n�
	 */ 
	 public void setVizInsegura(int n){
		 if (inMap(n)) {
		 	int centro = n;
			int size = mapa[centro].size();
			int nos_inseguros = 0;
			// Contando os vizinhos considerados inseguros
			for (int i=0; i<size; i++){
				Sala s = (Sala)mapa[centro].get(i);
				if (probPit(s.getLabel())!=0.0){
					nos_inseguros++;
				}
			}
			//coloca a probabilidade de cada sala como 0
			for (int i=0; i<size; i++){
				Sala s = (Sala)mapa[centro].get(i);
				if (probPit(s.getLabel())!=0.0){
					//atualiza os que n�o s�o seguros
					s.setProb(1.0/nos_inseguros);
					//setando caminho de volta
					int j = 0; int volta = s.getLabel();
					while(j<mapa[volta].size()){
						Sala v = (Sala)mapa[volta].get(j);
						if (v.getLabel()==centro){
							v.setProb(1.0/nos_inseguros);
							break;
						}
						j++;
					}
				} else {
					//atualiza os n�s seguros
					s.setSegura();
					//setando caminho de volta
					int j = 0; int volta = s.getLabel();
					while(j<mapa[volta].size()){
						Sala v = (Sala)mapa[volta].get(j);
						if (v.getLabel()==centro){
							v.setSegura();
							break;
						}
						j++;
					}
				}
			}
		 }
	 }
	 
	 
	 /**
	  * Verifica se a sala passada foi visitada.
	  *
	  * @param n r�tulo do n�
	  * @return retorna <code>true</code> se a sala j� foi visitada, <code>false</code> caso contr�rio
	  */
	 public boolean isVisited(int n){
	 	
		Sala s = (Sala)mapa[n].get(0);
		int l = s.getLabel();
		int size2 = mapa[l].size();
		//percorre os n�s achando n e retornando se ele foi visitado
		for (int j=0;j<size2;j++){
			Sala s2 = (Sala)mapa[l].get(j);
			if (s2.getLabel()==n){
				return s2.isVisited();
			}
		}
		System.out.println("ERRO: nunca deveria ter chegado aqui!!!");
		System.out.println("isVisited(n) em Mapa.java - n:"+n);
		System.out.println("Mapa["+n+"]: "+mapa[n]+" Mapa["+l+"]: "+mapa[l]);
		return false;
	 }

	 /**
	  * Marca a sala como visitada
	  *
	  * @param r�tulo ou n�mero da sala
	  */
	 public void setVisited(int n){
		
		// Atualiza de vetor de salas j� visitadas
		contX[n]++;
		 
	 	if (inMap(n)) {
	 		if (isVisited(n)){
	 			redundancias++;
	 		} else {
			 	int size = mapa[n].size();
			 	//pega cada n� a que n esta ligado
				for (int i=0; i<size; i++){
					Sala s = (Sala)mapa[n].get(i);
					int l = s.getLabel();
					int size2 = mapa[l].size();
					//percorre os n�s marcando n como visitado
					for (int j=0;j<size2;j++){
						Sala s2 = (Sala)mapa[l].get(j);
						if (s2.getLabel()==n){
							s2.setVisited();
							break;
						}
					}
				}
			}
		}
	}
	 
	/**
	 * Retorna uma string que representa um mapa no formato
	 * [<i>nome</i> ; <i>probabilidade</i>]
	 *
	 * @return Reprasenta��o de uma sala
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<mapa.length;i++){
			sb.append("["+i+"]");
			for (int j=0; j<mapa[i].size(); j++){
				sb.append("->");
				sb.append(((Sala)mapa[i].get(j)).toString());
			}
			sb.append("\n");
		}
		return sb.toString();
	}


	/**
	 * M�todo que retorna para o m�todo de busca um vetor com os n�s filhos
	 * que est�o seguros para andar do n� passado como par�metro.
	 * Este m�todo n�o retorna o pai do no em quest�o para evitar loop.
	 * O n� meta ou objetivo � passado para o caso de n�o ser seguro o caminho
	 * para a meta, no caso de arriscar a jogada.
	 *
	 * @param node n� o qual se quer os filhos seguros
	 * @param goal r�tulo do n� objetivo
	 */
	public Vector sonsSave(Node node, int goal){
		int n = node.getLabel();
		Vector nodesReturn = new Vector();
		for (int i=0; i<mapa[n].size() ;i++){
			Sala son = (Sala)mapa[n].get(i);
			//se n� � raiz
			if ((node.getParentNode()==null)){
				//n� � raiz n�o tem pai
				//se seguro
				if ( (probPit(son.getLabel())==0) || (son.getLabel()==goal) ){
					nodesReturn.add(new Node(son.getLabel(),node,node.getDepth()+1,node.getDepth()+1));
				}
			} else {
				//se diferente do pai de node e seguro
				if (((son.getLabel()!=node.getParentNode().getLabel()) && (probPit(son.getLabel())==0)) || (son.getLabel()==goal)){
					nodesReturn.add(new Node(son.getLabel(),node,node.getDepth()+1,node.getDepth()+1));
				}
			}
		}
		return nodesReturn;
		/*  ANTIGO n�o calcula a probabilidade de ter buraco, � baseado em cada probabilidade individual
		int n = node.getLabel();
		Vector nodesReturn = new Vector();
		for (int i=0; i<mapa[n].size() ;i++){
			Sala son = (Sala)mapa[n].get(i);
			//se n� � raiz
			if ((node.getParentNode()==null)){
				//n� � raiz n�o tem pai
				//se seguro
				if ( (son.getProb()==0) || (son.getLabel()==goal) ){
					nodesReturn.add(new Node(son.getLabel(),node,node.getDepth()+1,node.getDepth()+1));
				}
			} else {
				//se diferente do pai de node e seguro
				if (((son.getLabel()!=node.getParentNode().getLabel()) && (son.getProb()==0)) || (son.getLabel()==goal)){
					nodesReturn.add(new Node(son.getLabel(),node,node.getDepth()+1,node.getDepth()+1));
				}
			}
		}
		return nodesReturn;
		*/
	}


	/**
	 * Calcula a dist�ncia entre dois n�s.
	 *
	 * @param n1 n�mero ou r�tulo do primeiro n�
	 * @param n2 n�mero ou r�tulo do segundo n�
	 * @return dist�ncia entre os n�s n1 e n2
	 */
	public double distancia(int n1, int n2) {
		int x1,y1,x2,y2; //coordenadas de n1 e n2
		x1 = n1 % cols;
		y1 = n1 / cols;
		x2 = n2 % cols;
		y2 = n2 / cols;
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
        
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////
        
        public Vector[] getMapa() {
		return mapa;
	}


        ////RETORNA O NUMERO DE SALAS VISITADAS
	public int getContX(int n){
		return contX[n];		
	}
}
