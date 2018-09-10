package org.milan.datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DFS {

	public static void main(String[] args) {
		DFSGraph dfs= new DFSGraph(4);
		dfs.addEdge(0, 1);
		dfs.addEdge(0, 2);
		dfs.addEdge(1, 0);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 0);
		dfs.addEdge(2, 1);
		dfs.addEdge(2, 3);
		dfs.addEdge(3, 2);
		dfs.dfs(2);

	}

}
class DFSGraph{
	
	private int vertices;
	private Map<Integer,List<Integer>> adj;
	
	DFSGraph(int vertices){
		this.vertices=vertices;
		this.adj=new HashMap<>();
		for(int i=0;i<vertices;i++){
			adj.put(i, new LinkedList<>());
		}
	}
	public void addEdge(int u,int v){
		adj.get(u).add(v);
	}
	public void dfs(int v){
		boolean[] visited=new boolean[this.vertices];
		visit(v, visited);
	}
	public void visit(int v,boolean[] visited){
		System.out.println(v);
		visited[v]=true;
		List<Integer> neighbours=adj.get(v);
		for(Integer i:neighbours){
			if(!visited[i]){
				visit(i, visited);
			}
		}
	}
}
