import random
import string

# size for the rand_string_generator()
range_counter = random.randint(1, 1000)

def rand_string_generator(size):
    chars = string.ascii_letters
    return ''.join(random.choice(chars) for _ in range(size))

# print(rand_string_generator(range_counter))

def mutate():
    ls_of_inputs = ['Customer ID#', 'Account No.', 'Currency', 'Type', 'Balance']
    rand_input = ls_of_inputs[random.randint(0, len(ls_of_inputs) - 1)]
    size_rand_input = len(rand_input)
    mutate_bit = random.randint(0, size_rand_input - 1)
    rand_bit = string.punctuation + string.digits

    temp_ls = list(rand_input)
    temp_ls[mutate_bit] = random.choice(rand_bit)
    new_str = ''.join(temp_ls)
    return new_str

def rand_index_generator():
    # # index_counter = random.randint(0, 3)
    # temp_ls = []
    # for i in range(range_counter):
    #     temp_ls.append(string.digits)
    # new_str = ''.join(temp_ls)
    # final_str = '(' + new_str + ')'
    # print(final_str)
    # return final_str
    rand_idx = random.getrandbits(range_counter)
    print(rand_idx)
    return rand_idx
# print(mutate())

def rand_idx_combi():
    rand_idx = random.randint(0, 3)
    return str(rand_idx)

## GENERATING LONG RANDOM STRINGS
# ls_rand_str = []
# for i in range(range_counter):
#     ls_rand_str.append(rand_string_generator(range_counter))

# with open('random_string.txt', 'w') as file1:
#     for str in ls_rand_str:
#         file1.write(str)
#         file1.write('\n')
# file1.close()
##-----END----

## GENERATING CORRECT STRING HEADERS WITH MUTATED BITS
# ls_mutate = []
# for j in range(range_counter):
#     ls_mutate.append(mutate())

# with open('mutate.txt', 'w') as file2:
#     for str1 in ls_mutate:
#         file2.write(str1)
#         file2.write('\n')
# file2.close()
##-----END-----

## GENERATING LONG INTEGER INDEXES
# ls_rand_idx = []
# for k in range(range_counter):
#     ls_rand_idx.append(str(rand_index_generator()))
# with open('random_index.txt', 'w') as file3:
#     for idx_str in ls_rand_idx:
#         file3.write(idx_str)
#         file3.write('\n')
# file3.close()
# print(file3)
##-----END-----

## GENERATE INDEX COMBINATION
str_idx_combi = ''
for l in range(range_counter):
    if (l == range_counter - 1):
        str_idx_combi += rand_idx_combi()
    else:
        str_idx_combi += (rand_idx_combi() + ',')
str_idx_combi.rstrip(',')
final_str_idx_combi = ('(' + str_idx_combi + ')')
with open('random_index_combination.txt', 'w') as file4:
    file4.write(final_str_idx_combi)
file4.close()