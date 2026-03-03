import java.util.ArrayList;

/*
private void Collision() {

        for (int i = 0; i < cars.size(); i++) {
            ACar car = cars.get(i);

            int carWidth = frame.drawPanel.images.get(i).getWidth();
            int carHeight = frame.drawPanel.images.get(i).getHeight();

            boolean collided = false;

            // Check if collision with left x, right x, upper y, lower y
            if (car.getX() < 0) {
                car.setX(0);
                collided = true;
            } else if ((car.getX() > planeWidth - carWidth) && (car.getX() < 10000)) {
                // car.getX() < 10000 since 10000 is location for cars loaded in workshop.
                car.setX(planeWidth - carWidth);
                collided = true;
            } else if (car.getY() < 0) {
                car.setX(0);
                collided = true;
            } else if (car.getY() > planeHeight - carHeight) {
                car.setY(planeHeight - carHeight);
                collided = true;
            }

            // Turn arounds
            if (collided) {
                car.turnLeft();
                car.turnLeft();
            }
        }
    }*/