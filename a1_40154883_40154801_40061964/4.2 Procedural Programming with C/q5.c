//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 5
// Written by- Nirmal Ghinaiya 40154801,Julien Gilbert 40061964 and Keyur Patel 40154883
//--------------------------------------------------------------------------
#include<stdio.h>
#include<stdlib.h>
#include "AGGREGATE.H"
int main(){

    typedef float (*aggregates_alias)(float arr[],int size);

    aggregates_alias Ptrarr[5]={&min,&max,&sum,&avg,&pseudo_avg};

    const char* funcnames[] = { "FMIN", "FMAX","FSUM","FAVG","FPSEUDO_AVG"};
    float arr1[]={1.8,22,3.6,0.003,8};
    float arr2[]={1.1,22,2,3.6,0.1,8,9.3,88,2,-90};

    printf("\n\nThis is for array \n");
    for(int i=0; i<5; i++)
    {
       printf("%-10s:%.2f\n", funcnames[i],(Ptrarr[i])(arr1,5));
    }
    printf("\nThis is for array \n");
    for(int i=0; i<5; i++)
    {
       printf("%-10s:%.2f\n", funcnames[i],(Ptrarr[i])(arr2,10));
    }
    return 0;
}