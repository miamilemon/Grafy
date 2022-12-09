package com.example.grafy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.ArraySet
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.TreeSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editI : EditText = findViewById(R.id.edit_i)
        val editJ : EditText = findViewById(R.id.edit_j)
        val buttonIPlus : Button = findViewById(R.id.button_i_plus)
        val buttonIMinus : Button = findViewById(R.id.button_i_minus)
        val buttonJPlus : Button = findViewById(R.id.button_j_plus)
        val buttonJMinus : Button = findViewById(R.id.button_j_minus)
        //val buttonWartosc : Button = findViewById(R.id.button_wartosc)
        val buttonZmiana : Button = findViewById(R.id.button_zmien)
        val wynik : EditText = findViewById(R.id.text_wynik)
        val oblicz : Button = findViewById(R.id.button_sciezka)
        val sciezka : TextView = findViewById(R.id.text_sciezka)

        class Edge(val v1: String, val v2: String, var dist: Int)

        /** One vertex of the graph, complete with mappings to neighbouring vertices */
        class Vertex(val name: String) : Comparable<Vertex> {

            var dist = Int.MAX_VALUE  // MAX_VALUE assumed to be infinity
            var previous: Vertex? = null
            val neighbours = HashMap<Vertex, Int>()

            fun printPath() {
                if (this == previous) {
                    sciezka.append(name)
                }
                else if (previous == null) {
                    sciezka.append("$name(nie można znaleźć drogi)")
                }
                else {
                    previous!!.printPath()
                    sciezka.append(" -> $name($dist)")
                }
            }

            override fun compareTo(other: Vertex): Int {
                if (dist == other.dist) return name.compareTo(other.name)
                return dist.compareTo(other.dist)
            }

            override fun toString() = "($name, $dist)"
        }

        class Graph(
            val edges: List<Edge>,
            val directed: Boolean,
            val showAllPaths: Boolean = false
        ) {
            // mapping of vertex names to Vertex objects, built from a set of Edges
            private val graph = HashMap<String, Vertex>(edges.size)

            init {
                // one pass to find all vertices
                for (e in edges) {
                    if (!graph.containsKey(e.v1)) graph.put(e.v1, Vertex(e.v1))
                    if (!graph.containsKey(e.v2)) graph.put(e.v2, Vertex(e.v2))
                }

                // another pass to set neighbouring vertices
                for (e in edges) {
                    graph[e.v1]!!.neighbours.put(graph[e.v2]!!, e.dist)
                    // also do this for an undirected graph if applicable
                    if (!directed) graph[e.v2]!!.neighbours.put(graph[e.v1]!!, e.dist)
                }
            }

            /** Runs dijkstra using a specified source vertex */
            fun dijkstra(startName: String) {
                if (!graph.containsKey(startName)) {
                    println("Graph doesn't contain start vertex '$startName'")
                    return
                }
                val source = graph[startName]
                val q = TreeSet<Vertex>()

                // set-up vertices
                for (v in graph.values) {
                    v.previous = if (v == source) source else null
                    v.dist = if (v == source)  0 else Int.MAX_VALUE
                    q.add(v)
                }

                dijkstra(q)
            }

            /** Implementation of dijkstra's algorithm using a binary heap */
            private fun dijkstra(q: TreeSet<Vertex>) {
                while (!q.isEmpty()) {
                    // vertex with shortest distance (first iteration will return source)
                    val u = q.pollFirst()
                    // if distance is infinite we can ignore 'u' (and any other remaining vertices)
                    // since they are unreachable
                    if (u.dist == Int.MAX_VALUE) break

                    //look at distances to each neighbour
                    for (a in u.neighbours) {
                        val v = a.key // the neighbour in this iteration

                        val alternateDist = u.dist + a.value
                        if (alternateDist < v.dist) { // shorter path to neighbour found
                            q.remove(v)
                            v.dist = alternateDist
                            v.previous = u
                            q.add(v)
                        }
                    }
                }
            }

            /** Prints a path from the source to the specified vertex */
            fun printPath(endName: String) {
                if (!graph.containsKey(endName)) {
                    println("Graph doesn't contain end vertex '$endName'")
                    return
                }
                print(if (directed) "Directed   : " else "Undirected : ")
                graph[endName]!!.printPath()
                println()
                if (showAllPaths) printAllPaths() else println()
            }

            /** Prints the path from the source to every vertex (output order is not guaranteed) */
            private fun printAllPaths() {
                for (v in graph.values) {
                    v.printPath()
                    println()
                }
                println()
            }
        }

        var GRAPH = listOf(
            Edge("0", "1", 7),
            Edge("0", "2", 9),
            Edge("0", "3", 14),
            Edge("1", "2", 10),
            Edge("1", "3", 15),
            Edge("2", "3", 11),
            Edge("2", "5", 2),
            Edge("3", "4", 6),
            Edge("4", "5", 9)
        )

        fun sprawdzWartosc(){
            var test2 = 0
            var test: Any
            wynik.setText("0")
            for((index,value) in GRAPH.withIndex()){
                test2 = 0
                test = GRAPH[index]
                if(test.v1.equals(editI.text.toString())){
                    test2++
                }
                if(test.v2.equals(editJ.text.toString())){
                    test2++
                }
                if(test2==2){
                    wynik.setText(test.dist.toString())
                    break
                }
            }
            if(test2==0){
                wynik.setText("0")
            }
        }

        buttonIPlus.setOnClickListener {
            if(editI.text.isNullOrBlank()){
                editI.setText("0")
            }else{
                if(editI.text.toString().equals("5")){

                }else{
                    var zmienna = editI.text.toString().toInt()
                    editI.setText((zmienna+1).toString())
                }
            }
            sprawdzWartosc()
        }
        buttonIMinus.setOnClickListener {
            if(editI.text.isNullOrBlank()){
                editI.setText("0")
            }else{
                if(editI.text.toString().equals("0")){

                }else{
                    var zmienna = editI.text.toString().toInt()
                    editI.setText((zmienna-1).toString())
                }
            }
            sprawdzWartosc()
        }
        buttonJPlus.setOnClickListener {
            if(editJ.text.isNullOrBlank()){
                editJ.setText("0")
            }else{
                if(editJ.text.toString().equals("5")){

                }else{
                    var zmienna = editJ.text.toString().toInt()
                    editJ.setText((zmienna+1).toString())
                }
            }
            sprawdzWartosc()
        }
        buttonJMinus.setOnClickListener {
            if(editJ.text.isNullOrBlank()){
                editJ.setText("0")
            }else{
                if(editJ.text.toString().equals("0")){

                }else{
                    var zmienna = editJ.text.toString().toInt()
                    editJ.setText((zmienna-1).toString())
                }
            }
            sprawdzWartosc()
        }

        buttonZmiana.setOnClickListener {
            var test2 = 0
            var test3 = -1
            var test: Any
            for((index,value) in GRAPH.withIndex()) {
                test2 = 0
                test = GRAPH[index]
                if ((test as Edge).v1.equals(editI.text.toString())) {
                    test2++
                }
                if ((test as Edge).v2.equals(editJ.text.toString())) {
                    test2++
                }
                if (test2 == 2) {
                    if(wynik.getText().toString().toInt() == 0){
                        GRAPH.drop(index)
                    }else{
                        GRAPH[index].dist = wynik.getText().toString().toInt()
                    }
                    break
                }
            }

            GRAPH += Edge(editI.text.toString(),editJ.text.toString(),wynik.getText().toString().toInt())
            sprawdzWartosc()
        }

        oblicz.setOnClickListener {
            sciezka.setText("")
            with (Graph(GRAPH, true)) {   // directed
                dijkstra(editI.text.toString())
                printPath(editJ.text.toString())
            }
            /*with (Graph(GRAPH, false)) {  //undirected
                dijkstra(editI.text.toString())
                printPath(editJ.text.toString())
            }*/
        }

    }
}