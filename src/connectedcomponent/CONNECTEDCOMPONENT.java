/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectedcomponent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Mat Nguyen
 */
public class CONNECTEDCOMPONENT {
    static int n;
    static int m;
    static Set<Integer> V;
    static Map<Integer, Set<Integer>> A;
    static char[] color;
    static int[] p;
    static int count;
    static int[] icc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner in = new Scanner(new File("F:\\Projects\\DevC\\Algorithm\\MAT\\CONNECTEDCOMPONENT\\input.txt"));
        n = in.nextInt();
        m = in.nextInt();
        V = new HashSet<>();
        A = new HashMap<>();
        color = new char[n + 1];
        p = new int[n + 1];
        icc = new int[n + 1];
        count = 0;
        for(int i = 1; i <= n; i++){
            V.add(i);
            A.put(i, new HashSet<>());
            
        }
        for(int i = 1; i <= m; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            A.get(u).add(v);
            A.get(v).add(u);
        }
        // init
        for(int v: V){
            color[v] = 'W';
            p[v] = -1;
        }
        
        for(int v: V){
            if(color[v] == 'W'){
                count++;
                DFS_visit(v);
            }
        }
        System.out.println("Số thành phần liên thông: " + count+ "");
        for(int i = 1; i <= count; i++){
            System.out.print("Thành phần liên thông thứ " + i + ": ");
            for(int j = 1; j <= n; j++){
                if(icc[j] == i)
                    System.out.print(j + " ");
            }
            System.out.println("");
        }
        
    }
    
    public static void DFS_visit(int u){
        color[u] = 'G';
        for(int v : A.get(u)){
            if(color[v] == 'W'){
                p[v] = u;
                DFS_visit(v);
            }
        }
        color[u] = 'B';
        icc[u] = count; 
    }
    
    
    
}
