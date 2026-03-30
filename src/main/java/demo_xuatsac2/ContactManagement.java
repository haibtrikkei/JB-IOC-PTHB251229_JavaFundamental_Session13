package demo_xuatsac2;

import java.util.*;

public class ContactManagement {
    public static void main(String[] args) {
        int choose;
        Scanner sc = new Scanner(System.in);
        Set<Contact> contacts = new HashSet<Contact>();

        List<Contact> contactsList;

        while (true) {
            System.out.println("========= MENU ========");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xoá liên lạc theo số điện thoại");
            System.out.println("3. Tìm kiếm liên lạc");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("0. Thoát");
            System.out.println("========================");
            System.out.println("Lựa chọn của bạn: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    Contact contact = new Contact();
                    contactsList = new ArrayList<>(contacts);
                    int nearestId = 0;
                    if(contactsList.size()>0){
                        nearestId = contactsList.get(contactsList.size()-1).getId();
                    }
                    contact.setId(nearestId+1);
                    System.out.println("Nhập vào tên liên lạc: ");
                    contact.setName(sc.nextLine());
                    System.out.println("Nhập vào số điện thoại liên lạc: ");
                    contact.setPhoneNumber(sc.nextLine());
                    boolean blAdd = contacts.add(contact);
                    if(blAdd){
                        System.out.println("Đã thêm liên lạc mới");
                    }else{
                        System.out.println("Số điện thoại đã tồn tại!");
                    }
                    break;
                case 2:
                    String phoneNumber;
                    System.out.println("Nhập số điện thoại cần xoá: ");
                    phoneNumber = sc.nextLine();
                    Iterator<Contact> iterator = contacts.iterator();
                    int found = 0;
                    while(iterator.hasNext()){
                        Contact c = iterator.next();
                        if(c.getPhoneNumber().equals(phoneNumber)){
                            iterator.remove();
                            found++;
                        }
                    }
                    if(found>0){
                        System.out.println("Đã xoá "+found+" số liên lạc khỏi danh sách");
                    }else{
                        System.out.println("Không có số điện thoại nào được tìm thấy!");
                    }
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại cần tìm: ");
                    phoneNumber = sc.nextLine();
                    found = 0;
                    System.out.println("Kết quả tìm kiếm: ");
                    iterator = contacts.iterator();
                    while(iterator.hasNext()){
                        Contact c = iterator.next();
                        if(c.getPhoneNumber().equals(phoneNumber)){
                            found++;
                            System.out.println("-----------------");
                            System.out.println("Id: "+c.getId());
                            System.out.println("Name: "+c.getName());
                            System.out.println("Phone: "+c.getPhoneNumber());
                        }
                    }
                    System.out.println("Có "+found+" liên lạc được tìm thấy!");
                    break;
                case 4:
                    System.out.println("Danh sách danh bạ: ");
                    for(Contact c : contacts){
                        System.out.println("-----------------");
                        System.out.println("Id: "+c.getId());
                        System.out.println("Name: "+c.getName());
                        System.out.println("Phone: "+c.getPhoneNumber());
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Bạn đã chọn sai!");
            }
        }
    }
}
