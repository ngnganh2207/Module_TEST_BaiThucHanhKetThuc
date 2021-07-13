package quanlydanhba;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    List<DanhBa> list=new ArrayList<>();
    Scanner scanner= new Scanner(System.in);
    File danhBa= new File("data/contacts.csv");
    String tieuDe="Name,Group,Gendor,BirthDay,Phone,Address,Email";
    static BufferedWriter bufferedWriter;
    static BufferedReader bufferedReader;

    public void add(DanhBa danhBa){
        list.add(danhBa);
    }
    public DanhBa creat() throws Exception{
        //Name,Group,Gendor,BirthDay,Phone,Address,Email
        String name= getStringName();
        String group= getStringGroup();
        String gendor= getStringGendor();
        String birthDay= getStringBirthday();
        String phone= getStringPhone();
        String address= getStringAddress();
        String email= getStringEmail();
        return new DanhBa(name,group,gendor,birthDay,phone,address,email);
    }

    private String getStringName() {
        while(true){
            System.out.println("Nhập tên của danh bạ");
            String name= scanner.nextLine();
            if(name!=null){
                return name;
            }else {
                System.out.println("Nhập lại,name không được bỏ trống");
            }
        }

    }
    private String getStringGroup(){
        while(true){
            System.out.println("Nhập Group của danh bạ");
            String group= scanner.nextLine();
            if(group!=null){
                return group;
            }else {
                System.out.println("Nhập lại,group không được bỏ trống");
            }
        }
    }
    private String getStringGendor(){
        while(true){
            System.out.println("Nhập gendor");
            String gendor= scanner.nextLine();
            if(gendor!=null){
                return gendor;
            }else {
                System.out.println("Nhập lại,gendor không được bỏ trống");
            }
        }
    }
    private String getStringBirthday(){
        while(true){
            System.out.println("Nhập birthday");
            String birthDay= scanner.nextLine();
            if(birthDay!=null){
                return birthDay;
            }else {
                System.out.println("Nhập lại, không được bỏ trống");
            }
        }
    }
    private String getStringPhone(){
        while(true){
            System.out.println("Nhập phone của danh bạ");
            String phone= scanner.nextLine();
            Pattern pattern=Pattern.compile("^[8][4]\\d{8,10}$");
            Matcher matcher=pattern.matcher(phone);
            if(matcher.matches()){
                return phone;
            }else {
                System.out.println("Nhập lại, phải đúng định dạng 84***");
            }
        }
    }
    private String getStringAddress(){
        while(true){
            System.out.println("Nhập địa chỉ của danh bạ");
            String address= scanner.nextLine();
            if(address!=null){
                return address;
            }else {
                System.out.println("Nhập lại, không được bỏ trống");
            }
        }
    }
    private String getStringEmail(){
        while(true){
            System.out.println("Nhập email của danh bạ");
            String email= scanner.nextLine();
            Pattern pattern=Pattern.compile(".*[@].*[.]c{1}o{1}m{1}[.]v{1}n$");
            Matcher matcher=pattern.matcher(email);
            if(matcher.matches()){
                return email;
            }else {
                System.out.println("Nhập lại, phải đúng định dạng abc@gmail.com");
            }
        }
    }
    public void delete(String phone){
        for(int i=0; i<list.size();i++){
            if(list.get(i).getPhone().equals(phone)){
                System.out.println("Bạn muốn xóa thông tin danh bạ không");
                System.out.println("Nhập Y- đồng ý?, Enter nếu muốn bỏ qua");
                String choice= scanner.nextLine();
                if(choice.equals("Y")){
                    list.remove(list.get(i));
                    i--;
                }else {
                    break;
                }
            }
        }
    }
    public DanhBa edit(String phone){
        System.out.println("Nhập lại nhóm");
        String group=getStringGroup();
        System.out.println("Nhập lại tên");
        String name= getStringName();
        System.out.println("Nhập lại giới tính");
        String gendor= getStringGendor();
        System.out.println("Nhập lại địa chỉ");
        String address= getStringAddress();
        System.out.println("Nhập lại ngày sinh");
        String birthDay= getStringBirthday();
        System.out.println("Nhập lại email");
        String email=getStringEmail();
        return new DanhBa(name,group,gendor,birthDay,phone,address,email);
        //name,group,gendor,birthDay,phone,address,email
    }
    public void update(String phone){
        for(int i=0; i<list.size();i--){
            if(list.get(i).getPhone().equals(phone)){
            try {
                list.set(i,edit(phone));
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
           }
        }
    }

    public void findPhone(String phone){
        for (int i=0;i<list.size();i++){
            if (list.get(i).getPhone().contains(phone)){
                System.out.println(list.get(i));
            }
        }
        System.out.println("Không tìm thấy sdt này");
    }
    public void findName(String name){
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName().contains(name)){
                System.out.println(list.get(i));
            }
        }
        System.out.println("Không tìm thấy name này");
    }

    public void writeFile(){
        try {
            FileWriter fileWriter=new FileWriter(danhBa);
            bufferedWriter= new BufferedWriter(fileWriter);
            bufferedWriter.write(tieuDe);
            for(DanhBa db: list){
                bufferedWriter.newLine();
                bufferedWriter.write(db.show());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<DanhBa> readFile(){
        if (!danhBa.exists()){
            try {
                danhBa.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<DanhBa> list= new ArrayList<>();
        try {
            FileReader fileReader= new FileReader(danhBa);
            bufferedReader= new BufferedReader(fileReader);
            String line= bufferedReader.readLine();
            while ((line=bufferedReader.readLine())!=null){
                //name,group,gendor,birthDay,phone,address,email
                String[] arrStr=line.split(",");
                list.add(new DanhBa(arrStr[0],arrStr[1],arrStr[2],arrStr[3],arrStr[4],arrStr[5],arrStr[6]));
                //System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

