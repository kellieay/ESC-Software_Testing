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

# print(mutate())

ls_rand_str = []
for i in range(range_counter):
    ls_rand_str.append(rand_string_generator(range_counter))

with open('random_string.txt', 'w') as file1:
    for str in ls_rand_str:
        file1.write(str)
        file1.write('\n')
file1.close()


ls_mutate = []
for j in range(range_counter):
    ls_mutate.append(mutate())

with open('mutate.txt', 'w') as file2:
    for str1 in ls_mutate:
        file2.write(str1)
        file2.write('\n')
file2.close()
