package vn.codegym.com.c0921g1_sprint2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class C0921g1Sprint2Application {

    public static void main(String[] args) {
        SpringApplication.run(C0921g1Sprint2Application.class, args);
        int[] a = {1,2,3,1};
        System.out.println(test(a));
    }

    static boolean  test(int a[]){
        int index = 1;
        for(int i=0;i<a.length;i++){
            if (a[i] == a[index]){
                return false;
            }else{
                index++;
            }

        }
        return true;
    }

}
