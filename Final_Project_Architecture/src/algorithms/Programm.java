package algorithms;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Programm {
        
		public static void main(String[] args) {
        	
			 // Variable para seleccionar el algoritmo: 1,2,3,4,5
            int algoritmo =1;
            // Variable donde se almacena el tiempo de ejecucion
            
            long time = 0;
            // Variable para seleccionar el tamano: 500,1000,1500,2000,2500,3000,3500,4000
            
            int tamanio = 500;
            // Ruta en la que se encuentra la imagen a pasar por las versiones de los algoritmos
            
            
            //Muestra
            for(int rep =0;rep<51;rep++) {
 
	            String ruta = ("data/images/image" + tamanio + ".png");
	            File imagen = new File(ruta);
	           
	            switch (algoritmo) {
	                case 1:
					try {
						time = version1(imagen);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    //System.out.println("JAVA " + "1 " + tamanio + " " + time);
						System.out.println(time);
	                    break;
	                case 2:
					try {
						time = version2(imagen);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    System.out.println(time);
	                    break;
	                case 3:
					try {
						time = version3(imagen);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    System.out.println(time);
	                    break;
	                case 4:
					try {
						time = version4(imagen);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    System.out.println(time);
	                    break;
	                case 5:
					try {
						time = version5(imagen);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    System.out.println(time);
	                    break;
	            }
            }
        }
        
        public static long version1(File img) throws IOException {
        	long timeA = System.currentTimeMillis();
        	BufferedImage imagen = ImageIO.read(img);
        	
            int rows = imagen.getWidth();
            int columns = imagen.getHeight();
            
            
            
            for (int x = 0; (x < rows); x++) {
                for (int y = 0; (y < columns); y++) {
                    Color color = new Color(imagen.getRGB(x, y));
                    int r = (255 - color.getRed());
                    int g = (255 - color.getGreen());
                    int b = (255 - color.getBlue());
                    imagen.setRGB(x, y, new Color(r,g,b).getRGB());
                }
                
            }
            
            
            long tiempo = (System.currentTimeMillis() - timeA ) * 1000000; //  nano seconds
            return tiempo;
        }
        
        public static long version2(File img) throws IOException {
        	long timeA = System.currentTimeMillis();
        	
        	BufferedImage imagen = ImageIO.read(img);
        	
            int rows = imagen.getWidth();
            int columns = imagen.getHeight();
            
            for (int x = 0; (x < rows); x++) {
                for (int y = 0; (y < columns); y++) {
                	Color color = new Color(imagen.getRGB(x, y));
                    int r = (255 - color.getRed());
                    imagen.setRGB(x, y, new Color(r,color.getGreen(),color.getBlue()).getRGB());
                }
                
            }
            
            for (int x = 0; (x < rows); x++) {
                for (int y = 0; (y < columns); y++) {
                	Color color = new Color(imagen.getRGB(x, y));
                    int g = (255 - color.getGreen());
                    imagen.setRGB(x, y, new Color(color.getRed(), g, color.getBlue()).getRGB());
                }
                
            }
            
            for (int x = 0; (x < rows); x++) {
                for (int y = 0; (y < columns); y++) {
                	Color color = new Color(imagen.getRGB(x, y));
                    int b = (255 - color.getBlue());
                    imagen.setRGB(x, y, new Color(color.getRed(), color.getGreen(), b).getRGB());
                }
                
            }
            
            long tiempo = (System.currentTimeMillis() - timeA )* 1000000; //  nano seconds
            return tiempo;
        }
        
        public static long version3(File img) throws IOException {
        	long timeA = System.currentTimeMillis();
        	
        	BufferedImage imagen = ImageIO.read(img);
        	
            int rows = imagen.getWidth();
            int columns = imagen.getHeight();
            
            for (int y = 0; (y < columns); y++) {
                for (int x = 0; (x < rows); x++) {
                	Color color = new Color(imagen.getRGB(x, y));
                    int r = (255 - color.getRed());
                    int g = (255 - color.getGreen());
                    int b = (255 - color.getBlue());
                    imagen.setRGB(x, y, new Color(r, g, b).getRGB());
                }
                
            }
            
            long tiempo = (System.currentTimeMillis() - timeA )* 1000000; //  nano seconds
            return tiempo;
        }
        
        public static long version4(File img) throws IOException {
        	long timeA = System.currentTimeMillis();
        	
        	BufferedImage imagen = ImageIO.read(img);
            int rows = imagen.getWidth();
            int columns = imagen.getHeight();
            
            for (int x = 0; (x < rows); x++) {
                for (int y = 0; (y < columns); y++) {
                	Color color = new Color(imagen.getRGB(x, y));
                    int r = (255 - color.getRed());
                    imagen.setRGB(x, y, new Color(r, color.getGreen(), color.getBlue()).getRGB());
                }
                
            }
            
            for (int x = rows; (x < -1); x--) {
                for (int y = columns; (y < -1); y--) {
                	Color color = new Color(imagen.getRGB(x, y));
                    int g = (255 - color.getGreen());
                    int b = (255 - color.getBlue());
                    imagen.setRGB(x, y, new Color(color.getRed(), g, b).getRGB());
                }
                
            }
            
            long tiempo = (System.currentTimeMillis() - timeA )* 1000000;  //  nano seconds
            return tiempo;
        }
        
        public static long version5(File img) throws IOException {
            long timeA = System.currentTimeMillis();
            
            BufferedImage imagen = ImageIO.read(img);
            int rows = imagen.getWidth();
            int columns = imagen.getHeight();
            
            for (int x = 0; (x 
                        < (rows - 1)); x += 2) {
                for (int y = 0; (y 
                            < (columns - 1)); y += 2) {
                	Color color = new Color(imagen.getRGB(x, y));
                    int r = (255 - color.getRed());
                    int g = (255 - color.getGreen());
                    int b = (255 - color.getBlue());
                    imagen.setRGB(x, y, new Color(r, g, b).getRGB());
                    Color color1 = new Color(imagen.getRGB(x, (y+1)));
                    r = (255 - color1.getRed());
                    g = (255 - color1.getGreen());
                    b = (255 - color1.getBlue());
                    imagen.setRGB(x, (y + 1), new Color(r, g, b).getRGB());
                    Color color2 = new Color(imagen.getRGB((x+1), y));
                    r = (255 - color2.getRed());
                    g = (255 - color2.getGreen());
                    b = (255 - color2.getBlue());
                    imagen.setRGB((x + 1), y, new Color(r, g, b).getRGB());
                    Color color3 = new Color(imagen.getRGB((x+1), (y+1)));
                    r = (255 - color3.getRed());
                    g = (255 - color3.getGreen());
                    b = (255 - color3.getBlue());
                    imagen.setRGB((x + 1), (y + 1), new Color(r, g, b).getRGB());
                }
                
            }
            
            long tiempo = (System.currentTimeMillis() - timeA )* 1000000;  //  nano seconds
            return tiempo;
        }
}