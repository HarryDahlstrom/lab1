import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.LinkedHashMap;

public class Buttons extends JPanel{
    private Map<ButtonType, JButton> buttons = new LinkedHashMap<>();

    public Buttons() {
        this.setLayout(new GridLayout(2,4));
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(400, 200));

        // Buttons
        // Top row
        buttons.put(ButtonType.GAS, new GasButton());
        buttons.put(ButtonType.TURBOON, new TurboOnButton());
        buttons.put(ButtonType.PLATFORMUP, new PlatformUpButton());
        buttons.put(ButtonType.START, new StartButton());
        // Bottom row
        buttons.put(ButtonType.BRAKE, new BrakeButton());
        buttons.put(ButtonType.TURBOOFF, new TurboOffButton());
        buttons.put(ButtonType.PLATFORMDOWN, new PlatformDownButton());

        buttons.put(ButtonType.STOP, new StopButton());

        // Creates le buttoons
        for (JButton button : buttons.values()) {
            this.add(button);
        }
    }

    /* public JButton getButton(ButtonType type) {
        return buttons.get(type);
    }*/

    public Map<ButtonType, JButton> getAllButtons() {
        return buttons;
    }
}