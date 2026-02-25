import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class Buttons extends JPanel{
    private Map<ButtonType, JButton> buttons = new HashMap<>();

    public Buttons() {
        this.setLayout(new GridLayout(2,4));
        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(400, 200));

        // Buttons
        buttons.put(ButtonType.GAS, new GasButton());

        // Creates le buttoons
        for (JButton button : buttons.values()) {
            this.add(button);
        }
    }

    public JButton getButton(ButtonType type) {
        return buttons.get(type);
    }
    public Map<ButtonType, JButton> getAllButtons() {
        return buttons;
    }
}