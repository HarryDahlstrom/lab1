import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.LinkedHashMap;

public class Buttons extends JPanel{
    private Map<ButtonType, JButton> buttons = new LinkedHashMap<>();

    public Buttons() {
        this.setLayout(new GridLayout(2,6));
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(400, 200));

        // Buttons //
        // Top row
        buttons.put(ButtonType.GAS, new GasButton());
        buttons.put(ButtonType.TURBOON, new TurboOnButton());
        buttons.put(ButtonType.PLATFORMUP, new PlatformUpButton());
        buttons.put(ButtonType.START, new StartButton());
        buttons.put(ButtonType.ADDCAR, new AddCarButton());
        // Bottom row
        buttons.put(ButtonType.BRAKE, new BrakeButton());
        buttons.put(ButtonType.TURBOOFF, new TurboOffButton());
        buttons.put(ButtonType.PLATFORMDOWN, new PlatformDownButton());
        buttons.put(ButtonType.STOP, new StopButton());
        buttons.put(ButtonType.REMOVECAR, new RemoveCarButton()); // TEMP ÄNDRA TILL REMOVE CAR!!!

        // Creates le buttoons
        for (JButton button : buttons.values()) {
            this.add(button);
        }
    }
    public Map<ButtonType, JButton> getAllButtons() {
        return buttons;
    }
}