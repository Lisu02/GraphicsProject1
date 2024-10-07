import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.File;  // Import the File class
import java.util.Scanner;

public class SaveAndReadFile {


    private static MyPanel panel;

    public static void saveToFile(List<DrawComponent> drawComponentList){
        File myFile = new File("drawing.txt");
        try{
            if(myFile.exists()){
               myFile.delete();
            }
            if(myFile.createNewFile()){
                FileWriter fileWriter = new FileWriter(myFile);
                for(DrawComponent drawComponent : drawComponentList){
                    fileWriter.write(drawComponent.toString() + "\n");
                }
                fileWriter.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void readFromFile(MyPanel myPanel){
        panel = myPanel;
        File myFile = new File("drawing.txt");
        try{
            if(myFile.exists()){
                Scanner myReader = new Scanner(myFile);
                panel.clearDrawable();
                while(myReader.hasNextLine()){
                    createDrawComponentFromFile(myReader.nextLine());
                }
                myReader.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void createDrawComponentFromFile(String s){
        ArrayList<String> stringArrayList = new ArrayList<String>();
        for(int i = 0 ; i < 5 ; i++){
            stringArrayList.add(s.split("\\|")[i]);
        }
        System.out.println(Color.decode(stringArrayList.get(4)));

        DrawComponent drawComponent = new DrawComponent(
                stringArrayList.get(0),
                Integer.parseInt(stringArrayList.get(1)),
                Integer.parseInt(stringArrayList.get(2)),
                Integer.parseInt(stringArrayList.get(3)),
        Integer.parseInt(stringArrayList.get(4)),
                panel
        );
        panel.addDrawable(drawComponent);
    }
}
