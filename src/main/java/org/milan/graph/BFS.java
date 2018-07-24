package org.milan.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		BFSGraph bfs=new BFSGraph(4);
		/*bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 0);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 1);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 2);*/
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);
		bfs.bfs(2);

	}

}
class BFSGraph{
	private int vertices;
	private Map<Integer,List<Integer>> adj;
	
	public BFSGraph(int vertices) {
		this.vertices=vertices;
		this.adj=new HashMap<>();
		for(int i=0;i<vertices;i++){
			adj.put(i, new LinkedList<>());
		}
	}
	public void addEdge(int u,int v){
		adj.get(u).add(v);
	}
	public void bfs(int v){
		boolean visited[]=new boolean[this.vertices];
		Queue<Integer> queue=new LinkedList<>();
		queue.add(v);
		visited[v]=true;
		while(!queue.isEmpty()){
			v=queue.remove();
			System.out.println(v);
			List<Integer> neighbours=adj.get(v);
			for(Integer i:neighbours){
				if(!visited[i]){
					visited[i]=true;
					queue.add(i);
				}
			}
		}
	}
}
