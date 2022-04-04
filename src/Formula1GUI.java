import javax.swing.*;

public class Formula1GUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Formula1 Championship Manager");
        JPanel panel = new JPanel();

        JButton button= new JButton("Sort Table");
        button.setBounds(150,100,100,20);

        //add the button to content pane
        frame.getContentPane().add(button);

        String[] columnName= {"Driver Name", "Driver Location", "Driver Team"};

        String[][] data = {{"Alex", "Colombo", "BMW"}, {"Fred", "Galle", "Ferrari"}, {"Clinton", "Kandy", "Benz"},};
        JTable table= new JTable(data, columnName);

        frame.add(new JScrollPane(table));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
