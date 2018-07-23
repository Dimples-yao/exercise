package com.PinDuoDuo;

import java.util.ArrayList;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        ArrayList<Integer> cargos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt())
            cargos.add(scanner.nextInt());
        System.out.println(getCars(cargos));
    }

    public static int getCars(ArrayList<Integer> cargos){
        if (cargos.size()==0)
            return 0;
        int carNums = 0;

        ArrayList<Integer> notTH = new ArrayList<>();

        for (int i = 0; i < cargos.size(); i++) {
            if (cargos.get(i)>200){
                carNums++;
            }else
                notTH.add(cargos.get(i));
        }

        ArrayList<Integer> onlyOH = new ArrayList<>();
        ArrayList<Integer> onlyTH = new ArrayList<>();

        for (int i = 0; i < notTH.size(); i++) {
            if (notTH.get(i)==100)
                onlyOH.add(notTH.get(i));
            else onlyTH.add(notTH.get(i));
        }

        if (onlyOH.size()%3==2)
            carNums+=(Math.floor(onlyOH.size()/3)+1);
        else if(onlyOH.size()%3==1){
            carNums+=(Math.floor(onlyOH.size()/3));
            onlyTH.add(100);
        }else carNums+=(Math.floor(onlyOH.size()/3));

        for (int i = 0; i < onlyTH.size(); i++) {
            for (int j=i+1;j<onlyTH.size();j++){
                if
            }
        }

        return carNums;
    }

}
