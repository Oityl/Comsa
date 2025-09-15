import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterApp extends JFrame {
    private JComboBox<String> typeCombo;
    private JTextField nameField;
    private JButton createButton;
    private JTextArea resultArea;

    private Warrior warriorProto = new Warrior(1, "Warrior", 100, 20, 15);
    private Mage mageProto = new Mage(2, "Mage", 70, 30, 8);

    public CharacterApp() {
        setTitle("Создание персонажа");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        inputPanel.add(new JLabel("Тип персонажа:"));
        typeCombo = new JComboBox<>(new String[]{"Воин", "Маг"});
        inputPanel.add(typeCombo);

        inputPanel.add(new JLabel("Имя:"));
        nameField = new JTextField("Герой");
        inputPanel.add(nameField);

        createButton = new JButton("Создать персонажа");
        inputPanel.add(new JLabel(""));
        inputPanel.add(createButton);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (name.isEmpty()) name = "Безымянный";

                Character character;
                if ("Воин".equals(typeCombo.getSelectedItem())) {
                    character = warriorProto.clone();
                } else {
                    character = mageProto.clone();
                }
                character.setName(name);

                StringBuilder sb = new StringBuilder();
                sb.append("=== Персонаж создан ===\n");
                sb.append("Тип: ").append(character.getClass().getSimpleName()).append("\n");
                sb.append("Имя: ").append(character.getName()).append("\n");
                sb.append("Здоровье: ").append(character.getHealth()).append("\n");
                sb.append("Атака: ").append(character.getAttack()).append("\n");
                sb.append("Защита: ").append(character.getDefense()).append("\n");

                resultArea.setText(sb.toString());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new CharacterApp().setVisible(true);
        });
    }
}