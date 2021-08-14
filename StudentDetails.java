import java.util.Scanner;
public class StudentDetails {
    public int numberOfStudent;
    public String[] name;
    public String[] rollNumber;
    public int[] math;
    public int[] science;
    public int[] english;
    public int[] language;
    public int[] socialStudies;
    public int[] totalMarks;
    public double[] average;
    public char[] grade;

    public void studentDetail(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number of Student : ");
        numberOfStudent = scanner.nextInt();
        name = new String[numberOfStudent];
        rollNumber = new String[numberOfStudent];
        math = new int[numberOfStudent];
        science = new int[numberOfStudent];
        english = new int[numberOfStudent];
        language = new int[numberOfStudent];
        socialStudies = new int[numberOfStudent];
        
        for(int i=0 ; i<numberOfStudent ; i++){
            System.out.println("Enter "+(i+1)+" Student Details");
            System.out.print(" Name        : ");
            name[i] = scanner.next();
            System.out.print(" Roll Number : ");
            rollNumber[i] = scanner.next();
            System.out.println("-- Enter Marks --");
            System.out.println("Subject\t\tTotal Marks\tObtaine Marks");
            System.out.print("Math\t\t100\t\t");
            math[i] = scanner.nextInt();
            System.out.print("Science\t\t100\t\t");
            science[i] = scanner.nextInt();
            System.out.print("English\t\t100\t\t");
            english[i] =scanner.nextInt();
            System.out.print("Language\t100\t\t");
            language[i] = scanner.nextInt();
            System.out.print("Social Studies\t100\t\t");
            socialStudies[i] = scanner.nextInt();
        }
        scanner.close();
    }
    public void TotalMarks(){
        totalMarks = new int[numberOfStudent];
        for(int i=0 ; i<numberOfStudent ; i++){
            totalMarks[i] = math[i]+science[i]+english[i]+language[i]+socialStudies[i];
        }
    }
    public void Avearge(){
        average = new double[numberOfStudent];
        for(int i=0 ; i<numberOfStudent ; i++){
            average[i] = totalMarks[i]/5;
        }
    }
    public double Max(){
        double topper = average[0];
        int avg = average.length;
        for(int i=0 ; i<avg ; i++){
            if(topper<average[i]){
                topper = average[i];
            }
        }return topper;
    }
    public void Topper(){
        System.out.println("--Topper In The Class--");
        for(int i=0 ; i<numberOfStudent ; i++){
            if(Max()==average[i]){
                System.out.println("Name\t\tRoll Number");
                System.out.println(name[i]+"\t\t"+rollNumber[i]);
            }
        }
    }
    public void PassStudent(){
        boolean count = false;
        System.out.println("--Passed Student--");
        for(int i=0 ; i<numberOfStudent ; i++){
            if(math[i]>=35){
                if(science[i]>=35){
                    if(english[i]>=35){
                        if(language[i]>=35){
                            if(socialStudies[i]>=35){
                                System.out.println("Name\t\tRoll Number");
                                System.out.println(name[i]+"\t\t"+rollNumber[i]);
                                count = true;
                            }
                        }
                    }
                }
            }
        }if(count==false){
            System.out.println("No Data");
        }
    }
    public void FailStudent(){
        System.out.println("--Failed Student--");
        System.out.println("Name\t\tRoll Number");
        for(int i=0 ; i<numberOfStudent ; i++){
            if(math[i]<35){
                System.out.println(name[i]+"\t\t"+rollNumber[i]);
            }else if(science[i]<35){
                System.out.println(name[i]+"\t\t"+rollNumber[i]);
            }else if(english[i]<35){
                System.out.println(name[i]+"\t\t"+rollNumber[i]);
            }else if(language[i]<35){
                System.out.println(name[i]+"\t\t"+rollNumber[i]);
            }else if(socialStudies[i]<35){
                System.out.println(name[i]+"\t\t"+rollNumber[i]);
            }else{
                System.out.println("Failed in all Stubject !!");
                System.out.println(name[i]+"\t\t"+rollNumber[i]);
            }
        }
    }
    public void Grade(){
        grade = new char[]{'O','A','B','C','D','E'};
        System.out.println("Name\tRoll Number\tGrabe");
        for(int i=0 ; i<numberOfStudent ; i++){
            if(average[i]>=95){
                System.out.println(""+name[i]+"\t"+rollNumber[i]+"\t\t"+grade[i]);
            }if(average[i]>=80 && average[i]<95){
                System.out.println(""+name[i]+"\t"+rollNumber[i]+"\t\t"+grade[i]);
            }if(average[i]>=70 && average[i]<80){
                System.out.println(""+name[i]+"\t"+rollNumber[i]+"\t\t"+grade[i]);
            }if(average[i]>=60 && average[i]<70){
                System.out.println(""+name[i]+"\t"+rollNumber[i]+"\t\t"+grade[i]);
            }if(average[i]>=50 && average[i]<60){
                System.out.println(""+name[i]+"\t"+rollNumber[i]+"\t\t"+grade[i]);
            }if(average[i]<50){
                System.out.println(""+name[i]+"\t"+rollNumber[i]+"\t\t"+grade[i]);
            }
        }
    }
    public void Histogram(){
        for(int avg=100 ; avg>=10 ; avg =avg-10){
            System.out.print(avg+" ");
            for(int i=0 ; i<numberOfStudent ; i++){
                if(avg<average[i]){
                    System.out.print(" * ");
                }
            }System.out.println();
        }
        System.out.println("-------------------------");
        for(int k=0 ; k<=numberOfStudent ; k++){
            System.out.print(k+"  ");
        }System.out.println();
    }
    public void ScoreCard(){
        Scanner scanner = new Scanner(System.in);
        char ans;
        do{
            System.out.println("--Score Card--");
            System.out.print("Enter the Roll Number :");
            String RollNo = scanner.next();
            for(int i=0 ; i<numberOfStudent ; i++){
                if(RollNo.equals(rollNumber[i])){
                    System.out.println("Name\t\t: "+name[i]);
                    System.out.println("Roll Number\t: "+rollNumber[i]);
                    System.out.println("Obtained Marks\t: "+totalMarks[i]);
                    System.out.println("Grade\t\t: "+grade[i]);
                }else{
                    System.out.println("Roll Number Not Found !");
                }
            }System.out.print("Score Card Again (y/n) :");
            ans = scanner.next().charAt(0);
        }while(ans=='Y' && ans=='y');
    }
}
