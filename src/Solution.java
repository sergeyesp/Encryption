
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	int key = 629514131;
    	List<Integer> password = new ArrayList<>();
    	while (key > 0) {
    		int l = key % 10;
    		password.add(l);
    		key /= 10;
    	}

        FileInputStream fis = new FileInputStream("/home/xxx/temp2.txt");
        FileOutputStream fos = new FileOutputStream("/home/xxx/temp3.txt");
        
        int i = 0;
        
        if (args[0].equals("-e")) {
            while (fis.available() > 0) {
            	if (i == password.size()) i = 0;
            	fos.write(fis.read() + password.get(i));
            	i++;
            }
        } else if (args[0].equals("-d")) {
            while (fis.available() > 0) {
            	if (i == password.size()) i = 0;
            	fos.write(fis.read() - password.get(i));
            	i++;
            }
        } else System.out.println("Неверный ключ, используйте -e или -d");
        
        fis.close();
        fos.close();
    }

}
