import java.util.Scanner;

public class SCCS {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DbUtil use = new DbUtil();
        outer:while (true){
            System.out.println("----------------欢迎光临学生管理系统----------------");
            System.out.println("1-添加学生");
            System.out.println("2-删除学生");
            System.out.println("3-修改学生");
            System.out.println("4-按条件查询学生");
            System.out.println("5-查询所有学生");
            System.out.println("6-退出学生管理系统");
            int key = input.nextInt();
            switch (key){//选择需要进行的操作
                case 1:
                    use.addSome();break;
                case 2:
                    use.deleteOne();break;
                case 3:
                    use.updateOne();break;
                case 4:
                    use.querySome();break;
                case 5:
                    use.queryAll();break;
                case 6:
                    break outer;
                default:
                    System.out.println("您的操作有误，请重新选择");break;
            }
        }
    }

}
