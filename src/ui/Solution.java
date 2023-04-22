package ui;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY h1
     * 2. INTEGER_ARRAY h2
     * 3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Los siguientes Stacks seran usados para almacenar la suma acumulada de cada
        // una de las alturas guardadas por los Stacks de entrada
        Stack<Integer> h1AcumHeight = new Stack<>();
        Stack<Integer> h2AcumHeight = new Stack<>();
        Stack<Integer> h3AcumHeight = new Stack<>();
        // Variables para llevar la sumatoria de las alturas
        int h1sum = 0, h2sum = 0, h3sum = 0;
        // Ciclos para llenar los stack de altura acumulada (los tres ciclos trabajan de
        // forma independiente para cada uno de los stacks de alturas recibidos por
        // entrada)
        for (int i = h1.size(); i > 0; i--) {
            // La sumatoria aumenta con cada altura almacenada en el stack de entrada
            h1sum += h1.get(i - 1);
            // La sumatoria se guarda en el stack de altura acumulada
            h1AcumHeight.push(h1sum);
        }
        for (int i = h2.size(); i > 0; i--) {
            h2sum += h2.get(i - 1);
            h2AcumHeight.push(h2sum);
        }
        for (int i = h3.size(); i > 0; i--) {
            h3sum += h3.get(i - 1);
            h3AcumHeight.push(h3sum);
        }

        // Ciclo empleado para encontrar la altura maxima posible de las pilas de modo
        // que todas tengan exactamente la misma altura.
        while (true) {
            // Validacion de que alguna de las pilas no se halla quedado vacia
            // Si alguna de las pilas de suma acumulada esta vacia, entonces la altura
            // maxima igual en las 3 pilas es 0 (Tambien tiene la funcion de terminar el
            // metodo)
            if (h1AcumHeight.isEmpty() || h2AcumHeight.isEmpty() || h3AcumHeight.isEmpty()) {
                return 0;
            }
            // Variables empleadas para almacenar las alturas actuales que tienen los Stacks
            // en la iteracion que se esta haciendo
            int h1TH = h1AcumHeight.top();
            int h2TH = h2AcumHeight.top();
            int h3TH = h3AcumHeight.top();
            // Validacion de que las alturas sean iguales
            if (h1TH == h2TH && h2TH == h3TH)
                // Si las alturas son iguales se retorna alguna de ellas (Tambien tiene la
                // funcion de terminar el metodo)
                return h1TH;
            // Validacion para saber si la altura del stack 1 es la mayor
            if (h1TH >= h2TH && h1TH >= h3TH) {
                // Si la altura del stack 1 es la mayor se elimina el top del stack (para
                // reducir la altura de este stack)
                h1AcumHeight.pop();
            } // Validacion para saber si la altura del stack 2 es la mayor
            else if (h2TH >= h1TH && h2TH >= h3TH) {
                // Si la altura del stack 2 es la mayor se elimina el top del stack (para
                // reducir la altura de este stack)
                h2AcumHeight.pop();
            } // Validacion para saber si la altura del stack 3 es la mayor
            else if (h3TH >= h1TH && h3TH >= h2TH) {
                // Si la altura del stack 3 es la mayor se elimina el top del stack (para
                // reducir la altura de este stack)
                h3AcumHeight.pop();
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

interface IStack<T> {

    public boolean isEmpty();

    public void push(T item) throws StackException;

    public T top() throws StackException;

    public T pop() throws StackException;

}

class StackException extends RuntimeException {
    public StackException(String message) {
        super(message);
    }
}

class Node<T> {
    T value;
    Node<T> next;
    // Node<T> previous;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    // public Node<T> getPrevious() {
    // return previous;
    // }

    // public void setPrevious(Node<T> previous) {
    // this.previous = previous;
    // }
}

class Stack<T> implements IStack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T value) {
        Node<T> node = new Node<>(value);
        if (!isEmpty()) {
            node.setNext(top);
        }
        top = node;
        size++;
    }

    @Override
    public T pop() throws StackException {
        if (!isEmpty()) {
            T aux = top.getValue();
            top = top.getNext();
            size--;
            return aux;
        } else {
            throw new StackException("Empty stack");
        }
    }

    @Override
    public T top() throws StackException {
        if (!isEmpty()) {
            return top.getValue();
        } else {
            throw new StackException("Empty stack");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

}