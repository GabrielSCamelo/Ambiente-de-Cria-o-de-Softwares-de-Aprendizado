package Exercicio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Gabriel",23,"9876");
		try {
			FileOutputStream arqSer = new FileOutputStream("C:\\Users\\2010478300007\\.eclipse/Pessoa");
			ObjectOutputStream aSer = new ObjectOutputStream(arqSer);
			aSer.writeObject(p1);
			aSer.close();
			arqSer.close();
			
			p1.setTelefone("1234");
			
			System.out.println(p1);
			System.out.println("----------------------");
			
			FileInputStream arqDes = new FileInputStream("C:\\Users\\2010478300007\\.eclipse/Pessoa");
			ObjectInputStream aDes = new ObjectInputStream (arqDes);
			p1 = (Pessoa) aDes.readObject();
			arqDes.close();
			aDes.close();
			
			System.out.println(p1);
			System.out.println("----------------------");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
