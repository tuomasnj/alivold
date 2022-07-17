package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
  @Test
    public void testQueue(){
      Queue<String> queue=new LinkedList();
      Stack<String> stack=new Stack<>();
      queue.poll();
      stack.pop();
  }
}
