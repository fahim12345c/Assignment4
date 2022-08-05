import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        AllString allString = new AllString() ;
        if (args[0].equals(allString.argumentForPrintingStudentList)) {

            System.out.println(allString.printingDataLoaded);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(allString.fileNameOfStudentNamesList)));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(allString.commaCharacter);
                for (String studentName : splitStudentName) {
                    System.out.println(studentName);
                }
            } catch (Exception e) {
            }
            System.out.println(allString.printingDataLoaded);
        } else if (args[0].equals(allString.argumentForPrintingRandomStudentName)) {
            System.out.println(allString.printingDataLoaded);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(allString.fileNameOfStudentNamesList)));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(allString.commaCharacter);
                Random random = new Random() ;
                System.out.println(splitStudentName[random.nextInt(splitStudentName.length)]);
            } catch (Exception e) {
            }
            System.out.println(allString.printingDataLoaded);
        } else if (args[0].contains(allString.argumentForInsertStudent)) {

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(allString.fileNameOfStudentNamesList, true));
                String studentName = args[0].substring(1);
                Date date = new Date();
                String dateFormat = allString.dateFormat;
                DateFormat convertDateFormat = new SimpleDateFormat(dateFormat);
                String fd = dateFormat.format(dateFormat);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(allString.fileNameOfStudentNamesList)));

                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(allString.commaCharacter);
                ArrayList<String> arrayList = new ArrayList<>() ;
                for(String it : splitStudentName){
                        String name = it ;
                        arrayList.add(name) ;
                }
                arrayList.add(studentName) ;
                for(String name : arrayList){
                    System.out.println(name);
                }

                FileWriter fileWriter = new FileWriter(allString.fileNameOfStudentNamesList, false);
                PrintWriter printWriter = new PrintWriter(fileWriter, false);
                printWriter.flush();
                printWriter.close();
                fileWriter.close();

                for(int i = 0  ; i < arrayList.size() ; i += 1){
                        if(i == 0){
                               bufferedWriter.write(arrayList.get(i));
                        }else{
                              bufferedWriter.write(allString.commaCharacter + arrayList.get(i)) ;
                        }

                }
                bufferedWriter.write(allString.printUpdate + fd);
                bufferedReader.close();
                bufferedWriter.close();

            } catch (Exception e) {

            }
            System.out.println(allString.printingDataLoaded);
        } else if (args[0].contains(allString.argumentForFindingStudentName)) {
            System.out.println(allString.printingDataLoaded);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(allString.fileNameOfStudentNamesList)));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(allString.commaCharacter);
                String findName = args[0].substring(1);
                findName = allString.printSpace + findName ;
                int numberOfStudent = 0 ;
                System.out.println(findName);
                for (int idex = 0; idex < splitStudentName.length ; idex++) {
                    if (splitStudentName[idex].equals(findName)) {
                           numberOfStudent = numberOfStudent + 1 ;
                    }
                }
                System.out.println("The number of name ( " + findName + ") is " + numberOfStudent);
            } catch (Exception e) {

            }
            System.out.println(allString.printingDataLoaded);
        } else if (args[0].contains(allString.argumentForCountingStudentName)) {
            System.out.println(allString.printingDataLoaded);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(allString.fileNameOfStudentNamesList)));
                String lineOfStudentName = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentName.split(allString.commaCharacter);

                System.out.println( splitStudentName.length + allString.printWordsFound);
            } catch (Exception e) {
            }
        }else{
             System.out.println(allString.printWrongArgument);
        }
    }
}