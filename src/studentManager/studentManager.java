package studentManager;

import java.util.ArrayList;
import java.util.Scanner;
public class studentManager {

    public void insertStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        if(list.size()<3){
            System.out.println("输入学号：");
            int id = sc.nextInt();
            System.out.println("输入姓名：");
            String name = sc.next();
            System.out.println("输入生日：");
            String birDate = sc.next();
            System.out.println("输入姓别：");
            String gender = sc.next();
        }
        else{
            System.out.println("已满");
            return;
        }
    }
//输入数据
    public void selectstudent(ArrayList<Student> list){
        Scanner sc =new Scanner(System.in);
        System.out.println("输入姓名：");
        String name=sc.next();
        for(Student stu:list){
            if (stu.getClass ().equals(name)){
                System.out.println((stu.toString()));
            }
            else {
                System.out.println("没有找到此用户");
                return;
            }
        }
//查找学生
    }
    public  void deletestudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        if (list.size()==0){
            System.out.println("错误");
            return;
        }

        System.out.println("要删除的名字：");
        String name = sc.next();
        for (int i=0; i<list.size();i++){
            if(list.get(i).getClass().equals(name)){
                Object String = list.remove(i);
                System.out.println(("删除操作成功"));
            };
        }
    }
//删除学生
    public  void updatestudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        if (list.size() == 0) {
            System.out.println("错误");
            return;

        }
        System.out.println("要修改的名字：");
        String name = sc.next();
        boolean index = true;
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getClass().equals(name)) {
                System.out.println("输入新的学号：");
                int idNew = sc.nextInt();
                System.out.println("输入新的姓名：");
                String nameNew = sc.next();
                System.out.println("输入新的生日：");
                String birDateNew = sc.next();
                System.out.println("输入新的性别：");
                String genderNew = sc.next();
                list.set(k, new Student(idNew, nameNew, birDateNew, genderNew));
                System.out.println("修改成功");
                return;
            }
        }
    }
//修改学生
    public void printAll(ArrayList<Student> list) {
        for (int n=0;n < list.size();n++)
            System.out.println(list.get(n));
    }

//输出
    public void leave() {

    }
//退出
    public void Get_Menu() {
      System.out.println("Please select an operation: ");
      System.out.println("**********************************");
      System.out.println("*            1.插入              *");
      System.out.println("*            2.查找              *");
      System.out.println("*            3.删除              *");
      System.out.println("*            4.修改              *");
      System.out.println("*            5.输出              *");
      System.out.println("*            6.退出              *");
      System.out.println("**********************************");
    }
    public void App() {
        Scanner in = new Scanner(System.in);
        while(true) {
            try {
                Get_Menu(); // 创建菜单
                int op = in.nextInt();
                boolean is_quit = false;
                in.nextLine(); // 输入后同时清空缓冲区
                switch (op) {
                    case 1: // -- Insert：插入学生
                        System.out.println("请输入学生的id, 姓名, 生日");
                        int stu_id = in.nextInt();  // 学生的ID
                        String stu_name = in.next();    //学生的姓名
                        String stu_birDate = in.next(); // 学生的生日
                        boolean stu_gender;
                        String gender = in.next();
                        // 读入学生的性别，如果不为man或者woman则抛异常重新输入
                        if(gender.equals("man")) stu_gender = true;
                        else if(gender.equals("woman")) stu_gender = false;
                        else throw new Exception();
                        // 如果输入合理，则调用学生插入函数，将学生信息记录下来
                        insertStudent(stu_id, stu_name, stu_birDate, stu_gender);
                        break;
                    case 2: // -- Find：按照姓名查询，判断是否存在
                        System.out.println("请输入学生姓名: ");
                        String Find_Name = in.next();
                        selectstudent(Find_Name);
                        break;
                    case 3: // -- Delete：删除制定姓名的学生
                        System.out.println("请输入学生姓名: ");
                        deletestudent(in.next());
                        break;
                    case 4: // -- update：修改制定姓名学生的生日
                        System.out.println("请输入学生姓名, 年, 月, 日 ");
                        String name = in.next();
                        int year = in.nextInt();
                        int month = in.nextInt();
                        int day = in.nextInt();
                        updatestudent(name, year, month, day);
                        break;
                    case 5: // -- Output：输出所有学生的信息
                        printAll();
                        break;
                    case 6: // -- Quit
                        is_quit = true;
                        break;
                    default: // -- 输入有误则抛出异常
                        throw new Exception();
                }
                if(is_quit) {
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect operation input! Please input again!");
                in.nextLine();
            }
        }
        in.close();
    }
}
