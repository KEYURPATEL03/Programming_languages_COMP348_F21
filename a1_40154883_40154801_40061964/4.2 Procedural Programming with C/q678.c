//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 6,7,8
// Written by- Nirmal Ghinaiya 40154801, Keyur Patel 40154883 and Julien Gilbert 40061964
//--------------------------------------------------------------------------
#include<stdio.h>
#include<stdlib.h>
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
typedef enum { ATOM, LIST } eltype;

typedef char atom;
struct _listnode;

typedef struct {
                eltype type;
            union {
                atom a;
                struct _listnode* l;
                };
} element;

typedef struct _listnode{
                            element el;
                            struct _listnode* next;
                        } * list;


const element NIL = { .type=LIST, .l=NULL };

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

void insertelement(list* root, element item);

element aasel(atom a) {  //1
    element searchatom;
    searchatom.type = ATOM;
    searchatom.a = a;
    return searchatom;
}

element lasel(list l) {   //2
    element searchlist;
    searchlist.type = LIST;
    searchlist.l = l;
    return searchlist;
}

element car(element e) { //3
    if (e.type != LIST) {
        return NIL;
    }
    return e.l->el;
}

list cdr(element e) { //4
    if (e.type != LIST || e.l == NULL) {
        return NULL;
    }

    return e.l->next;
}

list cddr(element e) {  //5
    return cdr(lasel((cdr(e))));
}

list cons(element e, list l) { //6
    list first = (list)malloc(sizeof(struct _listnode));
    first->el = e;
    first->next = l;
    return first;
}

list append(list l1, list l2) {  //7
    list appendedlist = NULL;

    list temp1 = l1;
    while (temp1 != NULL) {
        insertelement(&appendedlist, temp1->el);
        temp1 = temp1->next;
    }

    list temp2 = l2;
    while (temp2 != NULL) {
        insertelement(&appendedlist, temp2->el);
        temp2 = temp2->next;
    }

    return appendedlist;
}


void lfreer(list l) { //8
    list temp = l;

    while (temp != NULL) {
        if (temp->el.type == LIST) {
            lfreer(temp->el.l);
        }

        list temp_ = temp->next;
        free((void*)temp);
        temp = temp_;
    }
}

void print(element e) { //9
    if (e.type == LIST && e.l == NULL) { // This means that this element has list in it and also if the list is empty it prints NIL.
        printf(" NIL ");
        return;
    }

    if (e.type == ATOM) {  //If this element is an atom then it is directly printed.
        printf(" %c ", e.a);

    } else {                  // If this element is pointing to another sub-list then this is printed.
        list present = e.l;
        printf(" (");
        while (present != NULL) {
            print(present->el);
            present = present->next;
        }
        printf(") ");
    }
}
void insertelement(list* root, element tobeinserted) {
    list temp = (list)malloc(sizeof(struct _listnode));
    list ptr1;
    temp->el = tobeinserted;
    temp->next = NULL;

    if (*root == NULL)
        *root = temp;
    else {
        ptr1 = *root;
        while (ptr1->next != NULL)
            ptr1 = ptr1->next;
        ptr1->next = temp;
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//main function Question 7,8
int main(){
    

    element a=aasel('a');
    element b=aasel('b');
    element c=aasel('c');
    element d=aasel('d');
    element e=aasel('e');

    list list_bc=cons(b,cons(c,NULL));

    element element_bc= lasel(list_bc);

    list list_abcde= cons(a,cons(element_bc,cons(d,cons(e,NULL)))); 
   
    print(lasel(append(list_abcde,list_abcde)));                         
    
    element k = lasel(list_abcde);
    printf("\n");

    print(k);

    printf("\n\n");

    element car_1= car(k);
    print(car_1);
    printf("\n\n");

    element cdr_1= lasel(cdr(k));
    print(cdr_1);
    printf("\n\n");

    element car_2= car(car(k));
    print(car_2);
    
    printf("\n\n");

   // freed the list before the program terminates
    lfreer(list_abcde);


   return 0;
}
