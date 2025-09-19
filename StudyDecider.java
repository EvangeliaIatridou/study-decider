import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class StudyDecider{
	
	private int numOfClasses;
	private int[] grades = new int[numOfClasses];
	private String[] classes = new String[numOfClasses];
	
	
	public void updateElements(int[] newGrades){
		this.grades = grades;
		for(int i=0;i<grades.length;i++){
			grades[i] += newGrades[i];
		}
	}
	
	public void setClassesNum(int[] classesNum,int num){
		for(int i =0;i<num;i++){
			classesNum[i] = i;
		}
	}
	
	public int[] rateClasses(int[] arr, int[] classesNum){
		int[] sortedList = new int[arr.length];
		int count = 0;
		int temp;
		int temp2;
		for(int i =0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]<arr[j+1]){
					temp = arr[j];
					temp2 = classesNum[j];
					
					arr[j] = arr[j+1];
					classesNum[j] = classesNum[j+1];
					
					arr[j+1] = temp;
					classesNum[j+1] = temp2;
				}				
			}
		}
		sortedList = arr;
		return sortedList;
	}
	
	public void askQuestions(String question,String[] names, int[] grades){
		System.out.println(question);
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<names.length;i++){
			System.out.print(names[i]+": ");
			int am = sc.nextInt();
			grades[i] += am;
			System.out.println();
		}
	}
	
	public String[] linkLists(int[] nums, String[] list){
		String[] newList = new String[list.length];
		for(int i=0;i<nums.length;i++){
			int index = nums[i];
			newList[index] = list[i];
		}
		return newList;
	}
	
	public void printList(int[] grades){
		for(int i=0;i<grades.length;i++){
			System.out.println(grades[i]+" ");
		}
	}
	
	public void printSList(String[] grades){
		for(int i=0;i<grades.length;i++){
			System.out.println(grades[i]+" ");
		}
	}
	
	public void setNumOfClasses(int numOfClasses){
		this.numOfClasses = numOfClasses;
	}


	public static void main(String[] args){
		
		StudyDecider sd = new StudyDecider();
		Scanner sc = new Scanner(System.in);
		System.out.print("Type how many subjects you have and want to study: ");
		int num = sc.nextInt();
		sc.nextLine().trim();
		if(num==1){
			System.out.println("study this one subject..");
			System.exit(0);
		}
		sd.setNumOfClasses(num);
		
		System.out.println("\n\nType names of subjects: ");
		
		String[] names = new String[num];
		for(int i=0;i<num;i++){
			names[i] = sc.nextLine().trim();
		}
		
		System.out.println("========================================================");
		System.out.println("alright now we you will have to rate some things as carefully as u can but u can always rerun this if you change your mind");
		System.out.println("========================================================\n");
		
		System.out.println("Rate from 1-"+num+" (with 1 being the lowest score):\n\n");
		int[] grades = new int[num];
		for(int i=0;i<num;i++){
			grades[i]=0;
		}
		
		String[] questions = {"How much stuff is there to study for each subject ("+num+":a lot,1:basically nothing)","Which one is closer date-wise ("+num+":really close,1:far far)","How well do you already know each class("+num+": studied all year, 1:havent ever studied it)","How easy is the class overall ("+num+":very hard,1:very easy)","How hard are the exams ("+num+":very hard,1:very easy)"};
		
		for(int i=0;i<questions.length;i++){
			sd.askQuestions(questions[i],names,grades);
		}
	
		
		int[] classesNum = new int[num];		
		sd.setClassesNum(classesNum,num);
		sd.rateClasses(grades,classesNum);
		String[] finalList = sd.linkLists(classesNum,names);
		System.out.println("\n******************** computing.... ****************\n");
		System.out.println("heres what you graded in order from max points to least points:");
		sd.printList(grades);
		System.out.println("========================================================\n");
		System.out.println("Heres the order from MOST to LEAST significant class for u 2 study :)");
		sd.printSList(finalList);		
	
	}
}