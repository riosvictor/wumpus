/**
 * Classe que implementa uma sala para o mapa do agente explorador do mundo do Wumpus.
 *
 * @author   Aydano Pamponet Machado <a href="mailto:apm@cin.ufpe.br">apm@cin.ufpe.br</a>
 * @author   Giordano Ribeiro Eulálio Cabral<a href="mailto:grec@cin.ufpe.br">grec@cin.ufpe.br</a>
 * @version  1.0, Março 2001.
 */
public class Sala{
	private double p; //probabilidade de ter buraco na sala
	
	//verificar esses dois
	private int label; //número da sala (inicia em zero)
	private boolean visited;
	
	private int vez;
	
	/**
	 * Construtor.
	 * Seta os valores default para a sala.
	 * 
	 * @param l número da sala
	 */
	Sala(int l){
		label = l;
		vez = 0;
		p = -1;
		visited = false;
	}
	
	/**
	 * Retorna o número da sala
	 * 
	 * @return número da sala
	 */
	public int getLabel(){
		return label;
	}
	
	/**
	 * Retorna a probabilidade
	 * 
	 * @return probabilidade
	 */
	public double getProb(){
		return p;
	}

	/**
	 * Verifica se a sala é segura.
	 *
	 * @return <code>true</code> se a sala foi setada para segura, <code>false</code> caso contrário.
	 */
	public boolean isSegura(){
		if (p==0){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Verifica se a sala foi visitada.
	 *
	 * @return <code>true</code> se a sala foi visitada, <code>false</code> caso contrário.
	 */
	public boolean isVisited(){
		return visited;
	}

	/**
	 * Coloca a sala como segura
	 */
	public void setSegura(){
		p = 0; //probabilidade vai para zero
	}
	
	/**
	 * Coloca a sala como visitada
	 */
	public void setVisited(){
		visited = true;
	}
	
	/**
	 * Atualiza a probabilidade atual (<code>p<sub>a</sub><code>) de acordo com o parametro passado (<code>p<code>).
	 * <pre>
	 * De acordo com a fórmula:
	 *        <b><code> p<sub>a</sub> = p<sub>a</sub> + p * (1 - p<sub>a</sub>) </code></b>
	 * </pre>
	 */
	public void setProb(double p1){
		p = p1;
	}

	/**
	 * Retorna uma string que representa uma sala no formato:
	 * [<i>nome</i>;<i>probabilidade</i>;<i>foi_visitada</i>]
	 *
	 * @return Reprasentação de uma sala
	 */
	public String toString(){
		return new String("["+label+";"+p+";"+visited+"]");
	}
}