//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 3
// Written by- Nirmal Ghinaiya 40154801, Julien Gilbert 40061964 and Keyur Patel 40154883
//--------------------------------------------------------------------------
#include<stdio.h>
#include<stdlib.h>
#include "AGGREGATE.H"
int main()
{
    float arr[]={1,4,5,6,-1};

    float a = min(arr,5);
    printf("The Minimum number in the array is: %.2lf\n",a);

    a=max(arr,5);
    printf("The Maximum number in the array is: %.2lf\n",a);

    a=sum(arr,5);
    printf("The sum of the array is: %.2lf\n",a);

    a=avg(arr,5);
    printf("The average of the array is: %.2lf\n",a);

    a=pseudo_avg(arr,5);
    printf("The pseudo average of the array is: %.2lf\n",a);
return (0);
}