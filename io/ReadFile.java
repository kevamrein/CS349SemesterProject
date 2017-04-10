package io;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStream;
import io.ResourceFinder;
/**
 * Class responsible for constructing files
 * from the resource finder
 * 
 * @author Affan Sheikh
 *
 */
public class ReadFile
{
  /**
   * Returns the text files from the resource finder
   * @param the name of the file
   * 
   * @return the content of the files
   */
  public String[] readFile(String name)
  {
      ResourceFinder finder = ResourceFinder.createInstance(this);
      String[] array = finder.loadResourceNames(name);
      return array;
  }
  /**
   * Gets the bufferedImage from a given file name
   * @param name the name of the image file
   * @return the bufferedImage
   */
  public BufferedImage getImage(String name)
  {
    BufferedImage image;
    InputStream is;
    ResourceFinder finder;
    // Construct a ResourceFinder
    finder = ResourceFinder.createInstance(this);
    
    // Read the image
    image = null;
    try
    {
      is =  finder.findInputStream(name);
      if (is != null)
      {
        image = ImageIO.read(is);
        is.close();
      }
    }
    catch (IOException io) {}
    return image;
  }
}