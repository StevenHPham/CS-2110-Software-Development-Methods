package finals;

import java.util.ArrayList;

public class Sport {
 
      private String name;
      private boolean ball;
      private double ballSize;
     
      public Sport(String name, boolean ball, double ballSize) {
            this.name = name;
            this.ball = ball;
            this.ballSize = ballSize;
      }
     
      public void setName(String name) {this.name = name;}
      public void setBall(boolean ball) {this.ball = ball;}
      public void setBallSize(double size) {this.ballSize = size;}
      public String getName() {return this.name;}
      public boolean getBall() {return this.ball;}
      public double getBallSize() {return this.ballSize;}
     
      public String toString() {
            return name + " played " + (ball ? "with ball size " + ballSize : "without ball");
      }
      
     
}