//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 4
// Written by- Keyur Patel 40154883, Julien Gilbert 40061964 and Nirmal Ghinaiya 40154801
//--------------------------------------------------------------------------
#include<stdio.h>
#include<stdlib.h>
#include "AGGREGATE.H"
int main(){
float (*aggregates[5])(float[],int)={&min,&max,&sum,&avg,&pseudo_avg};
    float arr1[]={5.2,10.4,6.5,7.1,30.0};
    float arr2[]={5.2,10.4,6.5,7.1,30.0,1.2,2.0,9.8,21.3,37.8};

    for(int i=0; i<5; i++)
    {
        float result1=aggregates[i](arr1,5);

        if(i==0){
            printf("\nThis values are for the array [5.2,10.4,6.5,7.1,30.0]\n\nThe minimum number in array is %.2lf\n",result1);
        }else if(i==1){
             printf("The maximum number in array is %.2lf\n",result1);
        }else if(i==2){
             printf("The sum of the array is %.2lf\n",result1);
        }else if(i==3){
             printf("The average of the array is %.2lf\n",result1);
        }else{
             printf("The pseudo average of the array is %.2lf\n\n",result1);
        }
    }
    for(int i=0; i<5; i++)
    {
        float result2=aggregates[i](arr2,10);
        if(i==0){
            printf("\nThis values are for the array [5.2,10.4,6.5,7.1,30.0,1.2,2.0,9.8,21.3,37.8]\n\nThe minimum number in array is %.2lf\n",result2);
        }else if(i==1){
             printf("The maximum number in array is %.2lf\n",result2);
        }else if(i==2){
             printf("The sum of the array is %.2lf\n",result2);
        }else if(i==3){
             printf("The average of the array is %.2lf\n",result2);
        }else{
             printf("The pseudo average of the array is %.2lf\n\n",result2);
        }
    }
return 0;
}