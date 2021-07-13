package quanlydanhba;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainQLDB {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Manager manager= new Manager();
        while (true){
            System.out.println("-----CHƯƠNg TRÌNH QUẢN LÝ DANH BẠ-----");
            System.out.println("1. Hiện thị danh bạn");
            System.out.println("2. Thêm danh bạ");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm gần đúng sđt hoặc họ tên");
            System.out.println("6. Read from file");
            System.out.println("7. Write to file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");
            int choice= -1;
            try{
                choice= Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa chọn lại");
            }
            switch (choice){
                case 1:
                    for(DanhBa db: manager.list){
                        System.out.println(db);
                    }
                    break;
                case 2:
                    DanhBa danhBa= null;
                    try{
                        danhBa= manager.creat();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    manager.add(danhBa);
                    break;
                case 3:
                    while (true){
                        System.out.println("Nhập phone danh bạ cần sửa");
                        String phone= scanner.nextLine();
                        String choice3=null;
                        if(phone==null){
                            break;
                        }
                        for(DanhBa danhBa1: manager.list){
                            if(danhBa1.getPhone().equals(phone)){
                                manager.update(phone);
                                choice3= "a";
                                break;
                            }else {
                                System.out.println("Không tìm thấy, nhập lại");
                            }
                        }
                        if(choice3.equals("a")){
                            break;
                        }
                    }
                    break;
                case 4:
                    while(true){
                        System.out.println("Nhập phone cần xóa");
                        String phone= scanner.nextLine();
                        if(phone==null){
                            break;
                        }
                        for(DanhBa danhBa1: manager.list){
                            if(danhBa1.getPhone().equals(phone)){
                                manager.delete(phone);
                                break;
                            }else {
                                System.out.println("Không tìm thấy danh bạ");
                            }
                        }
                    }
                case 5:
                    while (true){
                        System.out.println("1. Tìm kiếm theo số điện thoại");
                        System.out.println("2. Tìm kiếm theo họ tên");
                        System.out.println("3. Về menu chính");
                        int choice5= -1;
                        try{
                            choice5= Integer.parseInt(scanner.nextLine());
                        }catch (Exception e){
                            System.out.println("Lựa chọn lại");
                        }
                        if(choice5==3){
                            break;
                        }else if(choice5==1){
                            System.out.println("Nhập số điện thoại cần tìm");
                            String phone= scanner.nextLine();
                            manager.findPhone(phone);
                            break;
                        }else if(choice5==2){
                            System.out.println("Nhập tên cần tìm kiếm");
                            String name= scanner.nextLine();
                            manager.findName(name);
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("CẢNH BÁO: Việc này sẽ xóa danh bạ trong bộ nhớ");
                    System.out.println("1. Tiếp tục");
                    System.out.println("2. Về menu chính");
                    int choice6=-1;
                    try{
                        choice6= Integer.parseInt(scanner.nextLine());
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Lựa chọn không đúng");
                    }
                    switch (choice6){
                        case 1:
                            manager.list=manager.readFile();
                            break;
                        default:
                            break;
                    }
                    break;
                case 7:
                    System.out.println("CẢNH BÁO: Việc này sẽ cập nhật lại file");
                    System.out.println("1. Tiếp tục");
                    System.out.println("2. Về menu chính");
                    int choice7=-1;
                    try{
                        choice7= Integer.parseInt(scanner.nextLine());
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Lựa chọn không đúng");
                    }
                    switch (choice7){
                        case 1:
                            manager.writeFile();
                            break;
                        default:
                            break;
                    }
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
