/**
 * N� utilizado para a busca
 *
 * @author   Aydano Pamponet Machado <a href="mailto:apm@cin.ufpe.br">apm@cin.ufpe.br</a>
 * @author   Giordano Ribeiro Eul�lio Cabral<a href="mailto:grec@cin.ufpe.br">grec@cin.ufpe.br</a>
 * @version  1.0, Mar�o 2001.
 */
class Node {
	/**
	 * R�tulo para o n� do grafo
	 */
	private int label;
	/**
	 * N� pai
	 */
	private Node parentNode;
	/**
	 * Profundidade do n�
	 */
	private int depth;
	/**
	 * Custo para chegar at� este n�
	 */
	private int pathCost;
	
	/**
	 * Construtor.
	 *
	 * @param l r�tulo do n�
	 * @param pn n� pai
	 * @param d profundidade do n�
	 * @param pc custo para chegar a este n�
	 */
	Node(int l,Node pn,int d,int pc){
		label = l;
		parentNode = pn;
		depth = d;
		pathCost = pc;
	};
	
	/**
	 * Retorna o r�tulo do n�
	 *
	 * @return int r�tulo do n� na �rvore
	 */
	public int getLabel(){
		return label;
	};
	
	/**
	 * Retorna o n� pai
	 *
	 * @return n� pai
	 */
	public Node getParentNode(){
		return parentNode;
	};
	
	/**
	 * Retorna a profundidade do n�
	 *
	 * @return profundidade do n�
	 */
	public int getDepth(){
		return depth;
	};
	
	/**
	 * Retorna o custo do caminho percorrido para chegar a este n�
	 *
	 * @return custo at� este n�
	 */
	public int getPathCost(){
		return pathCost;
	};
	
	/**
	 * Atualiza o valor do r�tulo do n�
	 *
	 * @param l novo r�tulo para o n�
	 */
	public void setLabel(int l){
		label = l;
	};
	
	/**
	 * Atualiza o n� pai
	 *
	 * @param pn n� pai
	 */
	public void setParentNode(Node pn){
		parentNode = pn;
	};
	
	/**
	 * Atualiza a profundiade do n�
	 *
	 * @param d profundidade
	 */
	public void setDepth(int d){
		depth = d;
	};
	
	/**
	 * Atualiza o custo at� este n�
	 *
	 * @param pc custo
	 */
	public void setPathCost(int pc){
		pathCost = pc;
	};
	
	/**
	 * Retorna uma <code>String</code> que representa o n� no formato:
	 * [<i>r�tulo</i>,<i>r�tulo_pai</i>,<i>profundidade</i>,<i>custo</i>]
	 *
	 * @return representa��o do n�
	 */
	public String toString(){
		if (parentNode==null){
			return ("["+label+",null,"+depth+","+pathCost+"]");
		
		} else {
			return ("["+label+","+parentNode.getLabel()+","+depth+","+pathCost+"]");
		}
	};
}
