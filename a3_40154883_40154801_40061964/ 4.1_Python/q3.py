def convert_list_to_set(lst):
    return{elements for elements in lst}


print(convert_list_to_set(['a', 'b', 'b', 'a', 'b']))

