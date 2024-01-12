package main;

import entity.Chuqing;
import entity.Richangbiaoxian;
import entity.Student;
import entity.Tijian;
import entity.mapper.ChuqingMapper;
import entity.mapper.RichangbiaoxianMapper;
import entity.mapper.StudentMapper;
import entity.mapper.TijianMapper;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Main extends JFrame {
    private JPanel jpanel;
    private JButton 学生信息管理Button;
    private JButton 考勤信息管理Button;
    private JButton 日常表现管理Button;
    private JButton 体检信息管理Button;
    private JPanel studentJPanel;
    private JPanel chuqingJPanel;
    private JPanel richangbiaoxianJPanel;
    private JPanel tijianJPanel;
    private JTable studentTable;
    private JTable chuqingTable;
    private JTable richangbiaoxianTable;
    private JTable tijianTable;
    private JTextField deleteStudentTextField;
    private JButton 删除学生Button;
    private JButton 删除考勤Button;
    private JTextField deleteChuqingTextField;
    private JButton 删除日常表现Button;
    private JTextField deleteRichangbiaoxianTextField;
    private JButton 删除体检Button;
    private JTextField deleteTijianTextField;
    private JTextField addStudentNameTextField;
    private JTextField addStudentSexTextField;
    private JTextField addStudentAgeTextField;
    private JTextField addStudentClassnameTextField;
    private JButton 新增学生Button;
    private JTextField updateStudentNameTextField;
    private JTextField updateStudentSexTextField;
    private JTextField updateStudentAgeTextField;
    private JTextField updateStudentClassnameTextField;
    private JButton 修改学生Button;
    private JTextField updateStudentIdTextField;
    private JComboBox addChuqingSidComboBox;
    private JTextField addChuqingStatueTextField;
    private JButton 新增考勤Button;
    private JTextField updateChuqingIdTextField;
    private JTextField updateChuqingSidTextField;
    private JTextField updateChuqingTimeTextField;
    private JTextField updateChuqingStatueTextField;
    private JButton 修改考勤Button;
    private JComboBox addRichangbiaoxianSidComboBox;
    private JTextField addRichangbiaoxianTimeTextField;
    private JTextField addRichangbiaoxianInfoTextField;
    private JTextField addRichangbiaoxianGradeTextField;
    private JButton 新增日常表现Button;
    private JTextField updateRichangbiaoxianIdTextField;
    private JTextField updateRichangbiaoxianSidTextField;
    private JButton 修改日常表现Button;
    private JTextField updateRichangbiaoxianTimeTextField;
    private JTextField updateRichangbiaoxianInfoTextField;
    private JTextField updateRichangbiaoxianGradeTextField;
    private JComboBox addTijianSidComboBox;
    private JTextField addTijianTimeTextField;
    private JTextField addTijianHeightTextField;
    private JTextField addTijianWidthTextField;
    private JTextField addTijianEEenTextField;
    private JTextField addTijianOtherTextField;
    private JButton 新增体检Button;
    private JTextField updateTijianIdTextField;
    private JTextField updateTijianSidTextField;
    private JTextField updateTijianTimeTextField;
    private JTextField updateTijianHeightTextField;
    private JTextField updateTijianWidthTextField;
    private JTextField updateTijianEEenTextField;
    private JTextField updateTijianOtherTextField;
    private JButton 修改体检Button;

    private StudentMapper studentMapper = new StudentMapper();
    private ChuqingMapper chuqingMapper = new ChuqingMapper();
    private RichangbiaoxianMapper richangbiaoxianMapper = new RichangbiaoxianMapper();
    private TijianMapper tijianMapper = new TijianMapper();

    public Main(){
        setTitle("主页面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        add(jpanel);
        setVisible(true);
        /**
         * 初始化学生表格
         */
        Vector<String> studentHead = new Vector<>();
        studentHead.add("学号");studentHead.add("姓名");
        studentHead.add("性别");studentHead.add("年龄");studentHead.add("班级");
        Vector<Vector<Object>> studentDate = new Vector<>();
        DefaultTableModel studentModel = new DefaultTableModel(studentDate,studentHead){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        studentTable.setModel(studentModel);
        /**
         *
         * 初始化考勤表格
         */
        Vector<String> chuqingHead = new Vector<>();
        chuqingHead.add("编号");chuqingHead.add("学生学号");chuqingHead.add("学生姓名");chuqingHead.add("考勤时间");chuqingHead.add("考勤状态");
        Vector<Vector<Object>> chuqingDate = new Vector<>();
        DefaultTableModel chuqingModel = new DefaultTableModel(chuqingDate,chuqingHead){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        chuqingTable.setModel(chuqingModel);

        /**
         * 初始化日常表现表格
         */
        Vector<String> richangbiaoxianHead = new Vector<>();
        richangbiaoxianHead.add("编号");richangbiaoxianHead.add("学生学号");richangbiaoxianHead.add("学生姓名");richangbiaoxianHead.add("记录时间");
        richangbiaoxianHead.add("日常表现");richangbiaoxianHead.add("评价等级");
        Vector<Vector<Object>> richangbiaoxianDate = new Vector<>();
        DefaultTableModel richangbiaoxianModel = new DefaultTableModel(richangbiaoxianDate,richangbiaoxianHead){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        richangbiaoxianTable.setModel(richangbiaoxianModel);

        /**
         * 初始化体检表格
         */
        Vector<String> tijianHead = new Vector<>();
        tijianHead.add("编号");tijianHead.add("学生学号");tijianHead.add("学生姓名");tijianHead.add("体检时间");
        tijianHead.add("身高");tijianHead.add("体重");tijianHead.add("眼耳鼻喉");tijianHead.add("其他");
        Vector<Vector<Object>> tijianDate = new Vector<>();
        DefaultTableModel tijianModel = new DefaultTableModel(tijianDate,tijianHead){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tijianTable.setModel(tijianModel);

        studentJPanel.setVisible(true);updateStudentTable();
        chuqingJPanel.setVisible(false);
        richangbiaoxianJPanel.setVisible(false);
        tijianJPanel.setVisible(false);
        学生信息管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentJPanel.setVisible(true);updateStudentTable();
                chuqingJPanel.setVisible(false);
                richangbiaoxianJPanel.setVisible(false);
                tijianJPanel.setVisible(false);
            }
        });
        考勤信息管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentJPanel.setVisible(false);
                chuqingJPanel.setVisible(true);updateChuqingTable();
                richangbiaoxianJPanel.setVisible(false);
                tijianJPanel.setVisible(false);
            }
        });
        日常表现管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentJPanel.setVisible(false);
                chuqingJPanel.setVisible(false);
                richangbiaoxianJPanel.setVisible(true);updateRichangbiaoxianTable();
                tijianJPanel.setVisible(false);
            }
        });
        体检信息管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentJPanel.setVisible(false);
                chuqingJPanel.setVisible(false);
                richangbiaoxianJPanel.setVisible(false);
                tijianJPanel.setVisible(true);updateTijianTable();
            }
        });

        删除学生Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer id = Integer.valueOf(deleteStudentTextField.getText().trim());
                    boolean delete = studentMapper.delete(id);
                    if(delete){
                        updateStudentTable();
                        JOptionPane.showMessageDialog(new JOptionPane(),"删除成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"删除失败");
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"编号输入有误");
                }
            }
        });
        删除考勤Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer id = Integer.valueOf(deleteChuqingTextField.getText().trim());
                    boolean delete = chuqingMapper.delete(id);
                    if(delete){
                        updateChuqingTable();
                        JOptionPane.showMessageDialog(new JOptionPane(),"删除成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"删除失败");
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"编号输入有误");
                }
            }
        });
        删除日常表现Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer id = Integer.valueOf(deleteRichangbiaoxianTextField.getText().trim());
                    boolean delete = richangbiaoxianMapper.delete(id);
                    if(delete){
                        updateRichangbiaoxianTable();
                        JOptionPane.showMessageDialog(new JOptionPane(),"删除成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"删除失败");
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"编号输入有误");
                }
            }
        });
        删除体检Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer id = Integer.valueOf(deleteTijianTextField.getText().trim());
                    boolean delete = tijianMapper.delete(id);
                    if(delete){
                        updateTijianTable();
                        JOptionPane.showMessageDialog(new JOptionPane(),"删除成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"删除失败");
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"编号输入有误");
                }
            }
        });

        新增学生Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = addStudentNameTextField.getText().trim();
                    String sex = addStudentSexTextField.getText().trim();
                    Integer age = Integer.valueOf(addStudentAgeTextField.getText().trim());
                    String classname = addStudentClassnameTextField.getText().trim();
                    if(name.isEmpty() || sex.isEmpty() || classname.isEmpty()){
                        JOptionPane.showMessageDialog(new JOptionPane(),"输入项不能有空");
                        return;
                    }
                    boolean add = studentMapper.add(new Student(null, name, sex, age, classname));
                    if(add){
                        updateStudentTable();
                        addStudentNameTextField.setText("");addStudentSexTextField.setText("");
                        addStudentAgeTextField.setText("");addStudentClassnameTextField.setText("");
                        JOptionPane.showMessageDialog(new JOptionPane(),"新增成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"新增失败");
                        return;
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"输入异常");
                }
            }
        });
        新增考勤Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer sid = Integer.valueOf(String.valueOf(addChuqingSidComboBox.getSelectedItem()));
                    String statue = addChuqingStatueTextField.getText().trim();
                    if(statue.isEmpty()){
                        JOptionPane.showMessageDialog(new JOptionPane(),"输入项不能有空");
                        return;
                    }
                    String timeNow = new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date());
                    boolean add = chuqingMapper.add(new Chuqing(null,sid,timeNow,statue));
                    if(add){
                        updateChuqingTable();
                        addChuqingSidComboBox.setSelectedIndex(0);
                        addChuqingStatueTextField.setText("");
                        JOptionPane.showMessageDialog(new JOptionPane(),"新增成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"新增失败");
                        return;
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"输入异常");
                }
            }
        });
        新增日常表现Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer sid = Integer.valueOf(String.valueOf(addRichangbiaoxianSidComboBox.getSelectedItem()));
                    String time = addRichangbiaoxianTimeTextField.getText().trim();
                    String info = addRichangbiaoxianInfoTextField.getText().trim();
                    String grade = addRichangbiaoxianGradeTextField.getText().trim();
                    if(time.isEmpty() || info.isEmpty() || grade.isEmpty()){
                        JOptionPane.showMessageDialog(new JOptionPane(),"输入项不能有空");
                        return;
                    }
                    boolean add = richangbiaoxianMapper.add(new Richangbiaoxian(null,sid,time,info,grade));
                    if(add){
                        updateRichangbiaoxianTable();
                        addRichangbiaoxianSidComboBox.setSelectedIndex(0);addRichangbiaoxianTimeTextField.setText("");
                        addRichangbiaoxianInfoTextField.setText("");addRichangbiaoxianGradeTextField.setText("");
                        JOptionPane.showMessageDialog(new JOptionPane(),"新增成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"新增失败");
                        return;
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"输入异常");
                }
            }
        });
        新增体检Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer sid = Integer.valueOf(String.valueOf(addTijianSidComboBox.getSelectedItem()));
                    String time = addTijianTimeTextField.getText().trim();
                    String height = addTijianHeightTextField.getText().trim();
                    String width = addTijianWidthTextField.getText().trim();
                    String eent = addTijianEEenTextField.getText().trim();
                    String other = addTijianOtherTextField.getText().trim();
                    if(time.isEmpty() || height.isEmpty() || width.isEmpty() || eent.isEmpty() || other.isEmpty()){
                        JOptionPane.showMessageDialog(new JOptionPane(),"输入项不能有空");
                        return;
                    }
                    boolean add = tijianMapper.add(new Tijian(null,sid,time,height,width,eent,other));
                    if(add){
                        updateTijianTable();
                        addTijianSidComboBox.setSelectedIndex(0);addTijianTimeTextField.setText("");
                        addTijianHeightTextField.setText("");addTijianWidthTextField.setText("");
                        addTijianEEenTextField.setText("");addTijianOtherTextField.setText("");
                        JOptionPane.showMessageDialog(new JOptionPane(),"新增成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"新增失败");
                        return;
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"输入异常");
                }
            }
        });

        studentTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    int selectedRow = studentTable.getSelectedRow();
                    if(selectedRow>=0){
                        updateStudentIdTextField.setText(String.valueOf(studentTable.getValueAt(selectedRow,0)));
                        updateStudentNameTextField.setText(String.valueOf(studentTable.getValueAt(selectedRow,1)));
                        updateStudentSexTextField.setText(String.valueOf(studentTable.getValueAt(selectedRow,2)));
                        updateStudentAgeTextField.setText(String.valueOf(studentTable.getValueAt(selectedRow,3)));
                        updateStudentClassnameTextField.setText(String.valueOf(studentTable.getValueAt(selectedRow,4)));
                    }
                }
            }
        });
        chuqingTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    int selectedRow = chuqingTable.getSelectedRow();
                    if(selectedRow>=0){
                        updateChuqingIdTextField.setText(String.valueOf(chuqingTable.getValueAt(selectedRow,0)));
                        updateChuqingSidTextField.setText(String.valueOf(chuqingTable.getValueAt(selectedRow,1)));
                        updateChuqingTimeTextField.setText(String.valueOf(chuqingTable.getValueAt(selectedRow,3)));
                        updateChuqingStatueTextField.setText(String.valueOf(chuqingTable.getValueAt(selectedRow,4)));
                    }
                }
            }
        });
        richangbiaoxianTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    int selectedRow = richangbiaoxianTable.getSelectedRow();
                    if(selectedRow>=0){
                        updateRichangbiaoxianIdTextField.setText(String.valueOf(richangbiaoxianTable.getValueAt(selectedRow,0)));
                        updateRichangbiaoxianSidTextField.setText(String.valueOf(richangbiaoxianTable.getValueAt(selectedRow,1)));
                        updateRichangbiaoxianTimeTextField.setText(String.valueOf(richangbiaoxianTable.getValueAt(selectedRow,3)));
                        updateRichangbiaoxianInfoTextField.setText(String.valueOf(richangbiaoxianTable.getValueAt(selectedRow,4)));
                        updateRichangbiaoxianGradeTextField.setText(String.valueOf(richangbiaoxianTable.getValueAt(selectedRow,5)));
                    }
                }
            }
        });
        tijianTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    int selectedRow = tijianTable.getSelectedRow();
                    if(selectedRow>=0){
                        updateTijianIdTextField.setText(String.valueOf(tijianTable.getValueAt(selectedRow,0)));
                        updateTijianSidTextField.setText(String.valueOf(tijianTable.getValueAt(selectedRow,1)));
                        updateTijianTimeTextField.setText(String.valueOf(tijianTable.getValueAt(selectedRow,3)));
                        updateTijianHeightTextField.setText(String.valueOf(tijianTable.getValueAt(selectedRow,4)));
                        updateTijianWidthTextField.setText(String.valueOf(tijianTable.getValueAt(selectedRow,5)));
                        updateTijianEEenTextField.setText(String.valueOf(tijianTable.getValueAt(selectedRow,6)));
                        updateTijianOtherTextField.setText(String.valueOf(tijianTable.getValueAt(selectedRow,7)));
                    }
                }
            }
        });
        修改学生Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer id = Integer.valueOf(updateStudentIdTextField.getText().trim());
                    String name = updateStudentNameTextField.getText().trim();
                    String sex = updateStudentSexTextField.getText().trim();
                    Integer age = Integer.valueOf(updateStudentAgeTextField.getText().trim());
                    String classname = updateStudentClassnameTextField.getText().trim();
                    if(name.isEmpty() || sex.isEmpty() || classname.isEmpty()){
                        JOptionPane.showMessageDialog(new JOptionPane(),"输入项不能有空");
                        return;
                    }
                    boolean update = studentMapper.update(new Student(id, name, sex, age, classname));
                    if(update){
                        updateStudentTable();
                        updateStudentIdTextField.setText("");
                        updateStudentNameTextField.setText("");updateStudentSexTextField.setText("");
                        updateStudentAgeTextField.setText("");updateStudentClassnameTextField.setText("");
                        JOptionPane.showMessageDialog(new JOptionPane(),"修改成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"修改失败");
                        return;
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"输入异常");
                }
            }
        });
        修改考勤Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer id = Integer.valueOf(updateChuqingIdTextField.getText().trim());
                    Integer sid = Integer.valueOf(updateChuqingSidTextField.getText().trim());
                    String time = updateChuqingTimeTextField.getText().trim();
                    String statue = updateChuqingStatueTextField.getText().trim();
                    if(time.isEmpty() || statue.isEmpty()){
                        JOptionPane.showMessageDialog(new JOptionPane(),"输入项不能有空");
                        return;
                    }
                    boolean add = chuqingMapper.update(new Chuqing(id,sid,time,statue));
                    if(add){
                        updateChuqingTable();
                        updateChuqingIdTextField.setText("");
                        updateChuqingSidTextField.setText("");
                        updateChuqingTimeTextField.setText("");
                        updateChuqingStatueTextField.setText("");
                        JOptionPane.showMessageDialog(new JOptionPane(),"修改成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"修改失败");
                        return;
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"输入异常");
                }
            }
        });
        修改日常表现Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer id = Integer.valueOf(updateRichangbiaoxianIdTextField.getText().trim());
                    Integer sid = Integer.valueOf(updateRichangbiaoxianSidTextField.getText().trim());
                    String time = updateRichangbiaoxianTimeTextField.getText().trim();
                    String info = updateRichangbiaoxianInfoTextField.getText().trim();
                    String grade = updateRichangbiaoxianGradeTextField.getText().trim();
                    if(time.isEmpty() || info.isEmpty() || grade.isEmpty()){
                        JOptionPane.showMessageDialog(new JOptionPane(),"输入项不能有空");
                        return;
                    }
                    boolean update = richangbiaoxianMapper.update(new Richangbiaoxian(id,sid,time,info,grade));
                    if(update){
                        updateRichangbiaoxianTable();
                        updateRichangbiaoxianIdTextField.setText("");
                        updateRichangbiaoxianSidTextField.setText("");addRichangbiaoxianTimeTextField.setText("");
                        addRichangbiaoxianInfoTextField.setText("");addRichangbiaoxianGradeTextField.setText("");
                        JOptionPane.showMessageDialog(new JOptionPane(),"修改成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"修改失败");
                        return;
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"输入异常");
                }
            }
        });
        修改体检Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer id = Integer.valueOf(updateTijianIdTextField.getText().trim());
                    Integer sid = Integer.valueOf(updateTijianSidTextField.getText().trim());
                    String time = updateTijianTimeTextField.getText().trim();
                    String height = updateTijianHeightTextField.getText().trim();
                    String width = updateTijianWidthTextField.getText().trim();
                    String eent = updateTijianEEenTextField.getText().trim();
                    String other = updateTijianOtherTextField.getText().trim();
                    if(time.isEmpty() || height.isEmpty() || width.isEmpty() || eent.isEmpty() || other.isEmpty()){
                        JOptionPane.showMessageDialog(new JOptionPane(),"输入项不能有空");
                        return;
                    }
                    boolean update = tijianMapper.update(new Tijian(id,sid,time,height,width,eent,other));
                    if(update){
                        updateTijianTable();
                        updateTijianIdTextField.setText("");
                        updateTijianSidTextField.setText("");updateTijianTimeTextField.setText("");
                        updateTijianHeightTextField.setText("");updateTijianWidthTextField.setText("");
                        updateTijianEEenTextField.setText("");updateTijianOtherTextField.setText("");
                        JOptionPane.showMessageDialog(new JOptionPane(),"修改成功");
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"修改失败");
                        return;
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(new JOptionPane(),"输入异常");
                }
            }
        });

    }

    //学生表格更新
    public void updateStudentTable(){
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(0);
        addChuqingSidComboBox.removeAllItems();
        addRichangbiaoxianSidComboBox.removeAllItems();
        addTijianSidComboBox.removeAllItems();
        List<Student> select = studentMapper.select();
        for (Student student : select) {
            addChuqingSidComboBox.addItem(student.getId());
            addRichangbiaoxianSidComboBox.addItem(student.getId());
            addTijianSidComboBox.addItem(student.getId());
            Vector<Object> vector = new Vector<>();
            vector.add(student.getId());
            vector.add(student.getName());
            vector.add(student.getSex());
            vector.add(student.getAge());
            vector.add(student.getClassname());
            model.addRow(vector);
        }
    }
    //考勤表格更新
    public void updateChuqingTable(){
        DefaultTableModel model = (DefaultTableModel) chuqingTable.getModel();
        model.setRowCount(0);
        List<Chuqing> select = chuqingMapper.select();
        for (Chuqing chuqing : select) {
            Vector<Object> vector = new Vector<>();
            vector.add(chuqing.getId());
            vector.add(chuqing.getStudent().getId());
            vector.add(chuqing.getStudent().getName());
            vector.add(chuqing.getTime());
            vector.add(chuqing.getStatue());
            model.addRow(vector);
        }
    }
    //日常表现表格更新
    public void updateRichangbiaoxianTable(){
        DefaultTableModel model = (DefaultTableModel) richangbiaoxianTable.getModel();
        model.setRowCount(0);
        List<Richangbiaoxian> select = richangbiaoxianMapper.select();
        for (Richangbiaoxian richangbiaoxian : select) {
            Vector<Object> vector = new Vector<>();
            vector.add(richangbiaoxian.getId());
            vector.add(richangbiaoxian.getStudent().getId());
            vector.add(richangbiaoxian.getStudent().getName());
            vector.add(richangbiaoxian.getTime());
            vector.add(richangbiaoxian.getInfo());
            vector.add(richangbiaoxian.getGrade());
            model.addRow(vector);
        }
    }
    //体检表格更新
    public void updateTijianTable(){
        DefaultTableModel model = (DefaultTableModel) tijianTable.getModel();
        model.setRowCount(0);
        List<Tijian> select = tijianMapper.select();
        for (Tijian tijian : select) {
            Vector<Object> vector = new Vector<>();
            vector.add(tijian.getId());
            vector.add(tijian.getStudent().getId());
            vector.add(tijian.getStudent().getName());
            vector.add(tijian.getTime());
            vector.add(tijian.getHeight());
            vector.add(tijian.getWidth());
            vector.add(tijian.getEent());
            vector.add(tijian.getOther());
            model.addRow(vector);
        }

    }
}
