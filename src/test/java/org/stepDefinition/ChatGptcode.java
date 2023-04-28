package org.stepDefinition;

public class ChatGptcode {
	    public static int[] numberOfVehicles(int v, int w) {
	        int tw = (w - 4 * v) / 2;
	        int fw = v - tw;
	        int[] result = {tw, fw};
	        return result;
	    }

	    public static void main(String[] args) {
	        int v = 200;
	        int w = 540;
	        int[] result = numberOfVehicles(v, w);
	        System.out.println("Number of two-wheelers: " + result[0]);
	        System.out.println("Number of four-wheelers: " + result[1]);
	    }
	}

