import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

/**
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com).
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 *
 * A simple applet that uses the Java 1.0 event handling model.
 * */
public class Scribble extends Applet {
  private int lastX, lastY;
  Button clearButton;
  Graphics graphics;

  /**
   * Initializes the button and the Graphics object.
   */
  @Override
  public void init() {
    clearButton = new Button("Clear");
    this.add(clearButton);
    graphics = this.getGraphics();
  }

  /**
   * Responds to mouse clicks.
   *
   * @param e Event passed to function
   * @param x x position of mouse cursor
   * @param y y position of mouse cursor
   * @return True for all cases
   */
  public boolean mouseDown(Event e, int x, int y) {
    lastX = x;
    lastY = y;
    return true;
  }

  /**
   * Responds to mouse drags.
   *
   * @param e Event passed to the function.
   * @param x x position of the mouse cursor.
   * @param y y position of the mouse cursor.
   * @return True for all cases.
   */
  public boolean mouseDrag(Event e, int x, int y) {
    graphics.setColor(Color.black);
    graphics.drawLine(lastX, lastY, x, y);
    lastX = x;
    lastY = y;
    return true;
  }

  /**
   * Responds to all key presses.
   *
   * @param e Event passed to the function.
   * @param key Key that was pressed.
   * @return Returns True if the keypress is 'c'; otherwise false.
   */
  public boolean keyDown(Event e, int key) {
    if ((e.id == Event.KEY_PRESS) && (key == 'c')) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Responds to Button clicks.
   *
   * @param e Event passed to the function.
   * @param arg Arguments passed with the event; ignored.
   * @return Returns True if the clearButton was clicked; otherwise false.
   */
  public boolean action(Event e, Object arg) {
    if (e.target == clearButton) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Convenience method to erase the scribble.
   * */
  public void clear() {
    graphics.setColor(this.getBackground());
    graphics.fillRect(0, 0, bounds().width, bounds().height);
  }
}