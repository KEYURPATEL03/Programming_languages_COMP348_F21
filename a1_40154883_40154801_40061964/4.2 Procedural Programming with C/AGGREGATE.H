//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 3
// Written by- Nirmal Ghinaiya 40154801, Julien Gilbert 40061964 and Keyur Patel 40154883
//--------------------------------------------------------------------------
float min(float arr[], int size)
{
    if(size==0 || size<0)
    {
       printf("FATAL ERROR in the line %d.\n",__LINE__);
       exit(1);
    }
    else
    {
        float minNo=arr[0];
        for(int i=0; i<size ; i++)
        {
              if(arr[i]<minNo)
              {
                  minNo=arr[i];
              }  
        }
        return minNo;
    }
}
float max(float arr[], int size)
{
    if(size==0 || size<0)
    {
       printf("FATAL ERROR in the line %d.\n",__LINE__);
       exit(1);
    }
    else
    {
        float maxNo=arr[0];
        for(int i=0; i<size ; i++)
        {
              if(arr[i]>maxNo)
              {
                  maxNo=arr[i];
              }  

        }
        return maxNo;
    }
}
float sum(float arr[], int size)
{
    if(size==0 || size<0)
    {
       printf("FATAL ERROR in the line %d.\n",__LINE__);
       exit(1);
    }
    else
    {
        float total=0;
        for(int i=0; i<size ; i++)
        {
              total=total+arr[i];
        }
        return total;
    }
}
float avg(float arr[], int size)
{
    if(size==0 || size<0)
    {
       printf("FATAL ERROR in the line %d.\n",__LINE__);
       exit(1);
    }
    else
    {
        float total=0, average;
        for(int i=0; i<size ; i++)
        {
              total=total+arr[i];
        }
        average=(total)/size;
        return average;
    }
}
float pseudo_avg(float arr[], int size)
{
    if(size==0 || size<0)
    {
       printf("FATAL ERROR in the line %d.\n",__LINE__);
       exit(1);
    }
    else
    {
        float a=min(arr, size);
        float b=max(arr, size);
        float c=(a+b)/2;
        return c;
    }
}
