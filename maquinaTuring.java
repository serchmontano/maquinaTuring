//Librerias necesarias para el funcionamiento del programa
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

class graficoTuring extends JFrame{
	private JPanel contentPane;
	public ArrayList<String> cintaColor = new ArrayList<String>();
	int tamanoFi, secuenciaLen;
	String nomb;
	
	public graficoTuring(ArrayList<String> cintaFinal, String recibe){
		cintaColor = cintaFinal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1320, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbltitulo = new JLabel("Maquina de Turing - Secuencia = " + recibe);
		lbltitulo.setBounds(15, 00, 1320, 30);
		lbltitulo.setFont(new java.awt.Font("Walkway Semibold", 0, 24));
		contentPane.add(lbltitulo);
		nomb = recibe;
	}
	  
	public void paint(Graphics g){
		super.paint(g);
		int posInX = 20;
		int posInY = 65;
		int x0 = 20;
		g.setFont(new Font("Calibri", Font.BOLD, 18));
		
		for(int i = 0; i < cintaColor.size(); i++){
			String secuencia = cintaColor.get(i);
			for(int j = 0; j < secuencia.length(); j++){
				char caracter = secuencia.charAt(j);
				if(caracter == 'X'){
					g.setColor(Color.yellow);
					//g.drawString("X", posInX, posInY);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == '0'){
					g.setColor(Color.orange);
					//g.drawString("0", posInX, posInY);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				/*else if(caracter == '(' || caracter == 'q' || caracter == ')'){
					g.setColor(Color.white);
					g.drawString("", posInX, posInY);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}*/
				else if(caracter == 'O' || (caracter == '1' && secuencia.charAt(j-1) == 'q') || caracter == '2' || caracter == '3' || caracter == '4'){
					g.setColor(Color.black);
					//g.drawString("\u25A0" , posInX, posInY);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == 'Y'){
					g.setColor(Color.cyan);
					//g.drawString("Y" , posInX, posInY);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == '1'){
					g.setColor(Color.blue);
					//g.drawString("1" , posInX, posInY);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == 'B'){
					g.setColor(Color.white);
					//g.drawString("B" , posInX, posInY);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				/*else{
					g.setColor(Color.white);
					g.drawString("" , posInX, posInY);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}*/
			}
			posInX = x0;
			posInY = posInY + 5;
			
			if(posInY > 705){
				int size = secuencia.length() * 5;
				x0 = posInX = posInX + size - 25;
				posInY = 65;
				secuenciaLen = size;
			}
			int size = secuencia.length() * 5;
			secuenciaLen = size;
		}
		int tamImg = x0 + secuenciaLen;
		tamanoFi = tamImg;
		
		try {
			File file = new File(nomb +".png");
            ImageIO.write(crearImagen(), "png", file);
        } catch (IOException ex) {}
	}
	
	public BufferedImage crearImagen(){
		int posInX = 0;
		int posInY = 0;
		int x0 = 0;
		
		BufferedImage bufferedImage = new BufferedImage((tamanoFi), 720, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bufferedImage.createGraphics();
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, tamanoFi, 720);
		
		for(int i = 0; i < cintaColor.size(); i++){
			String secuencia = cintaColor.get(i);
			for(int j = 0; j < secuencia.length(); j++){
				char caracter = secuencia.charAt(j);
				if(caracter == 'X'){
					g.setColor(Color.yellow);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == '0'){
					g.setColor(Color.orange);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == 'O' || (caracter == '1' && secuencia.charAt(j-1) == 'q') || caracter == '2' || caracter == '3' || caracter == '4'){
					g.setColor(Color.black);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == 'Y'){
					g.setColor(Color.cyan);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == '1'){
					g.setColor(Color.blue);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
				else if(caracter == 'B'){
					g.setColor(Color.white);
					g.fillRect(posInX, posInY, 5, 5);
					posInX = posInX + 5;
				}
			}
			posInX = x0;
			posInY = posInY + 5;
			
			if(posInY > 715){
				int size = secuencia.length() * 5;
				x0 = posInX = posInX + size - 25;
				posInY = 0;
			}
		}
		g.dispose();
		return bufferedImage;
	}
}

//Clase maquina de Turing
public class maquinaTuring{
  ArrayList<String> cintaFinal = new ArrayList<String>();
  String cadena, cinta;
  int estadoActual, ind;
//Se inicia el constructor de la Maquina de Turing
  public maquinaTuring(String recibe){
    //Cadena que se va a meter a la Máquina de Turing
    cadena = recibe;
    //Cinta de la Maquina de Turing
    cinta = "|- (qO) " + cadena;
	cintaFinal.add(" (qO) " + cadena);
    //Estado actual de la cadena
    estadoActual = 0;
    //Indice donde se encuentra la MT
    ind = 0;

    if(!metodoTuring()){
      cinta += "\n\n\nNO PERTENECE AL LENGUAJE";
    }
    System.out.println(cinta);
	EventQueue.invokeLater(new Runnable(){
      public void run(){
        try{
          graficoTuring frame = new graficoTuring(cintaFinal, recibe);
          frame.setVisible(true);
        }catch (Exception e){
          e.printStackTrace();
        }
      }
    });
}

  public boolean metodoTuring(){
    while(ind < cadena.length() && estadoActual != 4){
      String txt = evaluarCad(cadena.charAt(ind));
      if(txt != null){
        cinta += txt;
      }
      else{
        return false;
      }
    }
    return true;
  }
//Metodo que evalua la cadena para ir formando la cinta
  public String evaluarCad(char caracter){
    switch(estadoActual){
      case 0:
        if(caracter == '0'){
          cadena = modificarCinta("X",ind);
          estadoActual = 1;
          if(ind < cadena.length() - 1){
              ind++;
          }
          else{
            return null;
          }
        }
        else if(caracter == 'Y'){
			estadoActual = 3;
			cadena = agregarPos();
			if(ind < cadena.length() - 1){
				ind++;
			}
			else{
				return null;
			}
        }
        else if(caracter == '1' || caracter == 'B' || caracter == 'X'){
          return null;
        }
      break;
      case 1:
        if(caracter == '0'){
          if(ind < cadena.length() - 1){
            ind++;
          }
          else{
            return null;
          }
        }
        else if(caracter == 'Y'){
          if(ind < cadena.length() - 1){
            ind++;
          }
          else{
            return null;
          }
        }
        else if(caracter == '1'){
          cadena = modificarCinta("Y", ind);
					estadoActual = 2;
          if(ind > 0){
            ind--;
          }
          else{
            return null;
          }
        }
        else if(caracter == 'B' || caracter == 'X'){
          return null;
        }
      break;
      case 2:
        if(caracter == '0'){
          if(ind > 0){
            ind--;
          }
          else return null;
        }
        else if(caracter == 'Y'){
          if(ind > 0){
            ind--;
          }
          else{
            return null;
          }
        }
        else if(caracter == 'X'){
          estadoActual = 0;
          if(ind < cadena.length() - 1){
            ind++;
          }
          else{
            return null;
          }
        }
        else if(caracter == 'B' || caracter == '1'){
          return null;
        }
      break;
      case 3:
        if(caracter == 'Y'){
          if(ind < cadena.length() - 1){
            ind++;
          }
          else{
            return null;
          }
        }
        else if(caracter == 'B'){
          estadoActual = 4;
          cadena = agregarPos();
          if(ind < cadena.length() - 1){
            ind++;
          }
          else{
            return null;
          }
          return generaCinta();
        }
        else if(caracter == 'O' || caracter == '1' || caracter == 'X'){
          return null;
        }
      break;
    }
    return generaCinta();
  }
//Metodo que forma la cinta
  public String generaCinta(){
    String estados[] = {" (qO) ", " (q1) ", " (q2) ", " (q3) ", " (q4) "};
    String primero = cadena.substring(0, ind);
    String ultimo = cadena.substring(ind);
	
	cintaFinal.add(primero+estados[estadoActual]+ultimo);
    return "\n|- " + primero + estados[estadoActual] + ultimo;
  }
//Metodo que ayuda a modificar la cinta
  public String modificarCinta(String nuevo,int ind){
    String primero = cadena.substring(0,ind);
    String ultimo = cadena.substring(ind + 1);
    String cadena = primero + nuevo + ultimo;
	
    return cadena;
  }
//Metodo que agrega la posicion B
  public String agregarPos(){
    cadena += "B";
	
	return cadena;
  }	
}
