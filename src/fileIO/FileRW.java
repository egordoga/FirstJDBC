package fileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRW {

    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }



    public void fileW() {

        try (FileWriter fw = new FileWriter("f:/jdbc.txt", false)) {

            String proba = list.get(0);   ///"Пробный текст для записи";
            fw.write(proba);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void queryList(){
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        String str = "";
        list.clear();

        try {
            br = new BufferedReader(new FileReader("f:\\1.txt"));
            if ((str = br.readLine()) != null){
                list.add(str);
            }
            while ((str = br.readLine()) != null){
                if (str.charAt(str.length() - 1) != ';'){
                    assert sb != null;
                    sb.append(str);
                    sb.append("\n");
                } else {
                    if (sb != null) {
                        sb.append(str.substring(0, str.length() - 1));
                    }
                    list.add(String.valueOf(sb));
                    sb = new StringBuilder("");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
