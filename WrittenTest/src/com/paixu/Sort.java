package com.paixu;

public class Sort {
    public static void quickSort(int a[],int l, int r){
        if (l>r)
            return;
        int i=l;int j=r;int key = a[l];

        while (i<j){
            while (i<j&&a[j]>=key){
                j--;
            }
            if (i<j){
                a[i]=a[j];
                i++;
            }
            while (i<j&&a[i]<key){
                i++;
            }
            if (i<j){
                a[j]=a[i];
                j--;
            }
        }

        a[i] = key;

        quickSort(a,l,i-1);
        quickSort(a,i+1,r);

    }
}
