import java.awt.*;
import javax.swing.*;

public class FlightModelingSimulation extends JPanel {



        private double airplaneX = 100;  // Initial x-coordinate of the airplane
        private double airplaneY = 100;  // Initial y-coordinate of the airplane
        private double velocityX = 2;    // Initial velocity along the x-axis
        private double velocityY = 0;    // Initial velocity along the y-axis
        private double accelerationY = 0.1; // Gravity-like acceleration

        public void update() {
            airplaneX += velocityX;
            airplaneY += velocityY;

            velocityY += accelerationY;

            // Simulate ground collision
            if (airplaneY >= getHeight()) {
                velocityY = -velocityY * 0.6;
                airplaneY = getHeight();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillRect((int) airplaneX, (int) airplaneY, 20, 20); // Draw the airplane
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Flight Modeling Simulation");
            FlightModelingSimulation simulation = new FlightModelingSimulation();
            frame.add(simulation);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            while (true) {
                simulation.update();
                simulation.repaint();
                try {
                    Thread.sleep(10); // Introduce a small delay to control simulation speed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


