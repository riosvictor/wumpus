/**
 * Nó utilizado para a busca
 *
 * @author   Aydano Pamponet Machado <a href="mailto:apm@cin.ufpe.br">apm@cin.ufpe.br</a>
 * @author   Giordano Ribeiro Eulálio Cabral<a href="mailto:grec@cin.ufpe.br">grec@cin.ufpe.br</a>
 * @version  1.0, Março 2001.
 */
class Node {
	/**
	 * Rótulo para o nó do grafo
	 */
	private int label;
	/**
	 * Nó pai
	 */
	private Node parentNode;
	/**
	 * Profundidade do nó
	 */
	private int depth;
	/**
	 * Custo para chegar até este nó
	 */
	private int pathCost;
	
	/**
	 * Construtor.
	 *
	 * @param l rótulo do nó
	 * @param pn nó pai
	 * @param d profundidade do nó
	 * @param pc custo para chegar a este nó
	 */
	Node(int l,Node pn,int d,int pc){
		label = l;
		parentNode = pn;
		depth = d;
		pathCost = pc;
	};
	
	/**
	 * Retorna o rótulo do nó
	 *
	 * @return int rótulo do nó na árvore
	 */
	public int getLabel(){
		return label;
	};
	
	/**
	 * Retorna o nó pai
	 *
	 * @return nó pai
	 */
	public Node getParentNode(){
		return parentNode;
	};
	
	/**
	 * Retorna a profundidade do nó
	 *
	 * @return profundidade do nó
	 */
	public int getDepth(){
		return depth;
	};
	
	/**
	 * Retorna o custo do caminho percorrido para chegar a este nó
	 *
	 * @return custo até este nó
	 */
	public int getPathCost(){
		return pathCost;
	};
	
	/**
	 * Atualiza o valor do rótulo do nó
	 *
	 * @param l novo rótulo para o nó
	 */
	public void setLabel(int l){
		label = l;
	};
	
	/**
	 * Atualiza o nó pai
	 *
	 * @param pn nó pai
	 */
	public void setParentNode(Node pn){
		parentNode = pn;
	};
	
	/**
	 * Atualiza a profundiade do nó
	 *
	 * @param d profundidade
	 */
	public void setDepth(int d){
		depth = d;
	};
	
	/**
	 * Atualiza o custo até este nó
	 *
	 * @param pc custo
	 */
	public void setPathCost(int pc){
		pathCost = pc;
	};
	
	/**
	 * Retorna uma <code>String</code> que representa o nó no formato:
	 * [<i>rótulo</i>,<i>rótulo_pai</i>,<i>profundidade</i>,<i>custo</i>]
	 *
	 * @return representação do nó
	 */
	public String toString(){
		if (parentNode==null){
			return ("["+label+",null,"+depth+","+pathCost+"]");
		
		} else {
			return ("["+label+","+parentNode.getLabel()+","+depth+","+pathCost+"]");
		}
	};
}
