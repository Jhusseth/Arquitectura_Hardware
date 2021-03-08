using System;
using System.Diagnostics;
using System.Drawing;
using System.IO;

namespace ProyectoFinalArquiHard
{
     class Program
     {
          static void Main(string[] args)
          {


               //Variable para seleccionar el algoritmo: 1,2,3,4,5
               int algoritmo = 1;

               //Variable donde se almacena el tiempo de ejecución
               long time = 0;
                    //Variable para seleccionar el tamaño: 500,1000,1500,2000,2500,3000,3500,4000
               int tamaño = 500;

               //Ruta en la que se encuentra la imagen a pasar por las versiones de los algoritmos
               String ruta = @"D:\2020-2\Arquitectura Hardware\Proyecto_Final\Images\image" + tamaño + ".png";

              
               Bitmap imagen = new Bitmap(ruta, true);

               for (int i = 0; i < 50; i++)
               {

                    switch (algoritmo)
                    {
                         case 1:
                              time = version1(imagen);
                              Console.WriteLine(time);
                         break;
                         case 2:
                              time = version2(imagen);
                              Console.WriteLine(time);
                              break;
                         case 3:
                              time = version3(imagen);
                              Console.WriteLine(time);
                              break;
                         case 4:
                              time = version4(imagen);
                              Console.WriteLine(time);
                              break;
                         case 5:
                              time = version5(imagen);
                              Console.WriteLine(time);
                              break;
                         default:
                              break;
                    }
               }
               Console.ReadKey();
          }
         

          public static long version1(Bitmap imagen)
          {
               Stopwatch timeA = new Stopwatch();
               timeA.Restart();
               timeA.Start();
               int rows = imagen.Width;
               int columns = imagen.Height;
               for (int x = 0; x < rows; x++)
               {
                    for (int y = 0; y < columns; y++)
                    {
                         Color color = imagen.GetPixel(x, y);
                         int r = 255 - color.R;
                         int g = 255 - color.G;
                         int b = 255 - color.B;
                         imagen.SetPixel(x, y, Color.FromArgb(r, g, b));
                    }

               }
               timeA.Stop();

               long tiempo = (long)(timeA.Elapsed.TotalMilliseconds * 1000000); // nano seconds
               return tiempo;
          }
          public static long version2(Bitmap imagen)
          {
               Stopwatch timeA = new Stopwatch();
               int rows = imagen.Width;
               int columns = imagen.Height;
               timeA.Restart();
               timeA.Start();
               for (int x = 0; x < rows; x++)
               {
                    for (int y = 0; y < columns; y++)
                    {
                         Color color = imagen.GetPixel(x, y);
                         int r = 255 - color.R;

                         imagen.SetPixel(x, y, Color.FromArgb(r, color.G, color.B));
                    }

               }
               for (int x = 0; x < rows; x++)
               {
                    for (int y = 0; y < columns; y++)
                    {
                         Color color = imagen.GetPixel(x, y);

                         int g = 255 - color.G;
                         imagen.SetPixel(x, y, Color.FromArgb(color.R, g, color.B));
                    }

               }
               for (int x = 0; x < rows; x++)
               {
                    for (int y = 0; y < columns; y++)
                    {
                         Color color = imagen.GetPixel(x, y);

                         int b = 255 - color.B;
                         imagen.SetPixel(x, y, Color.FromArgb(color.R, color.G, b));
                    }

               }

               timeA.Stop();

               long tiempo = (long)(timeA.Elapsed.TotalMilliseconds * 1000000); // nano seconds
               return tiempo;
          }
          public static long version3(Bitmap imagen)
          {
               Stopwatch timeA = new Stopwatch();
               timeA.Restart();
               timeA.Start();
               int rows = imagen.Width;
               int columns = imagen.Height;
               for (int y = 0; y < columns; y++)
               {
                    for (int x = 0; x < rows; x++)
                    {
                         Color color = imagen.GetPixel(x, y);
                         int r = 255 - color.R;
                         int g = 255 - color.G;
                         int b = 255 - color.B;
                         imagen.SetPixel(x, y, Color.FromArgb(r, g, b));
                    }

               }
               timeA.Stop();

               long tiempo = (long)(timeA.Elapsed.TotalMilliseconds * 1000000); // nano seconds
               return tiempo;
          }
          public static long version4(Bitmap imagen)
          {
               Stopwatch timeA = new Stopwatch();
               timeA.Restart();
               timeA.Start();
               int rows = imagen.Width;
               int columns = imagen.Height;
               
               for (int x = 0; x < rows; x++)
               {
                    for (int y = 0; y < columns; y++)
                    {
                         Color color = imagen.GetPixel(x, y);
                         int r = 255 - color.R;
                         imagen.SetPixel(x, y, Color.FromArgb(r, color.G, color.B));
                    }

               }
               for (int x = rows; x < -1; x--)
               {
                    for (int y = columns; y < -1; y--)
                    {
                         Color color = imagen.GetPixel(x, y);
                         int g = 255 - color.G;
                         int b = 255 - color.B;
                         imagen.SetPixel(x, y, Color.FromArgb(color.R, g, b));
                    }

               }
               timeA.Stop();

               long tiempo = (long)(timeA.Elapsed.TotalMilliseconds * 1000000); // nano seconds
               return tiempo;
          }
          public static long version5(Bitmap imagen)
          {
               Stopwatch timeA = new Stopwatch();
               timeA.Restart();
               timeA.Start();
               int rows = imagen.Width;
               int columns = imagen.Height;
               for (int x = 0; x < rows - 1; x += 2)
               {
                    for (int y = 0; y < columns - 1; y += 2)
                    {
                         Color color = imagen.GetPixel(x, y);
                         int r = 255 - color.R;
                         int g = 255 - color.G;
                         int b = 255 - color.B;
                         imagen.SetPixel(x, y, Color.FromArgb(r, g, b));

                         Color color1 = imagen.GetPixel(x, y + 1);
                         r = 255 - color1.R;
                         g = 255 - color1.G;
                         b = 255 - color1.B;
                         imagen.SetPixel(x, y + 1, Color.FromArgb(r, g, b));

                         Color color2 = imagen.GetPixel(x + 1, y);
                         r = 255 - color2.R;
                         g = 255 - color2.G;
                         b = 255 - color2.B;
                         imagen.SetPixel(x + 1, y, Color.FromArgb(r, g, b));

                         Color color3 = imagen.GetPixel(x + 1, y + 1);
                         r = 255 - color3.R;
                         g = 255 - color3.G;
                         b = 255 - color3.B;
                         imagen.SetPixel(x + 1, y + 1, Color.FromArgb(r, g, b));
                    }

               }

               timeA.Stop();

               long tiempo = (long)(timeA.Elapsed.TotalMilliseconds * 1000000); // nano seconds
               return tiempo;
          }
     }

}

