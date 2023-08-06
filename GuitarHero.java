import java.util.*;
public class GuitarHero
{
   public static void main(String[] args) {
   
      
   
      String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
      HashMap<Character, GuitarString> guitar = new HashMap<>();
      for(int i = 0; i < keyboard.length(); i++)
      {
         guitar.put(keyboard.charAt(i), new GuitarString(440 * Math.pow(1.05956, i -24))); 
      }
        
      while (true) {
      double s = 0;
         if (StdDraw.hasNextKeyTyped()) {
            char key = StdDraw.nextKeyTyped();
            if(guitar.containsKey(key)) 
            guitar.get(key).pluck();
         }
      
      
      
         for(int i = 0; i < keyboard.length(); i++) {
            s += guitar.get(keyboard.charAt(i)).sample();
         }
         StdAudio.play(s);
      
            // advance the simulation of each guitar string by one step
         for(int i = 0; i < keyboard.length(); i++) {
            guitar.get(keyboard.charAt(i)).tic();
         }
      }
   }
}
