import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeunGeunApp extends JFrame {

    private JTextField textField;
    private JLabel resultLabel;

    public GeunGeunApp() {
        setTitle("근 근근근");
        setUndecorated(true);
        setSize(400, 200); // 임의의 크기로 설정
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 텍스트 필드 생성 및 추가
        textField = new JTextField();
        textField.setBounds(50, 50, 200, 30); // x, y, width, height
        add(textField);

        // 결과를 표시할 라벨 생성 및 추가
        resultLabel = new JLabel();
        resultLabel.setBounds(50, 80, 300, 30); // x, y, width, height
        add(resultLabel);

        // 입력이 발생하면 변환 메서드 호출
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });

        setVisible(true);
        setLayout(null);
    }

    // 입력된 텍스트를 변환하여 결과 라벨에 표시하고 클립보드에 복사
    private void processInput() {
        String inputText = textField.getText();
        String geunText = convertToGeun(inputText);
        resultLabel.setText(geunText);

        // 클립보드에 텍스트 복사
        StringSelection stringSelection = new StringSelection(geunText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        // 결과 아래쪽에 메시지 표시
        JOptionPane.showMessageDialog(this, "근근근근근 근근근근 근근근(클립보드에 복사되었습니다 라는 뜻)", "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    // 입력된 텍스트의 띄어쓰기를 제거하고 근으로 변환
    private String convertToGeun(String inputText) {
        String[] words = inputText.split(" ");
        StringBuilder geunTextBuilder = new StringBuilder();

        for (String word : words) {
            int length = word.length();
            String geunWord = new String(new char[length]).replace('\0', '근');
            geunTextBuilder.append(geunWord).append(" ");
        }

        return geunTextBuilder.toString().trim();
    }



}
