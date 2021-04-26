package everland;

public class Options {
	//user input option
	final static int day = 1;
	final static int night = 2;
	final static int exit = 3;
	
	//ages
	final static int adultMax = 64;
	final static int adultMin = 19;
	final static int youthMax = 18;
	final static int youthMin = 13;
	final static int childMax = 12;
	final static int childMin = 3;
	final static int senior = 65;
	final static int enfant = 2;
	
	//discount rates
	final static double non = 0;
	final static double disabled = 0.4;
	final static double veteran = 0.5;
	final static double multiChild = 0.2;
	final static double preg = 0.15;
	
	//tickets
	final static int[] price_day = {56000, 47000, 44000, 44000, 0};
	/*
	 * final static int adult_d = 56000; final static int youth_d = 47000; final
	 * static int child_d = 44000; final static int senior_d = 44000;
	 */
	
	final static int[] price_night = {46000, 40000, 37000, 37000, 0};
	/*
	 * final static int adult_n = 46000; final static int youth_n = 40000; final
	 * static int child_n = 37000; final static int senior_n = 37000;
	 */
	
	//file name
	final static String filename = "c:\\Users\\J\\Desktop\\source\\everdemo2.csv";
	
	//format (ÇÊ¿ä½Ã)
	final static String minbunForm = "\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4]\\d{6}";
}
