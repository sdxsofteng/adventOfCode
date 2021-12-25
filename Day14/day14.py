import urllib.request
from collections import Counter

req = urllib.request.Request("https://adventofcode.com/2021/day/14/input")
req.add_header('Cookie', 'session=53616c7465645f5f22019c1eec2e8cbe842a8672490a2bc7b81cd64d7503fbe673aec662e0edebc8222eb56c2361dd50')

#content = urllib.request.urlopen(req).read()
#content = content.decode('utf-8')

conten = open("test.txt")
content = conten.read()

start_str, keys = content.split("\n\n")

str_pairs_l = list()

def pairs_To_String(pairs: list[tuple]):
    counter = 0
    string_out = ""
    for pair in pairs:
        if counter == 0:
            string_out = string_out + pair[0][0] + pair[1][0]
        else :
            string_out = string_out + pair[1][0]
        counter = counter + 1
    return string_out


for count, x in enumerate(start_str):
    if count < len(start_str) - 1:
        str_pairs_l.append((start_str[count], start_str[count + 1]))

keys_l = list()

for y in keys.splitlines():
    keypair = list()
    key, value = y.split(" -> ")
    keypair.append((key[0], key[1]))
    keys_l.append((keypair, value))

i = 0
while i < 10:
    new_str_pairs_l = list()
    for str_pair in str_pairs_l:
        for keys in keys_l:
            if (str_pair[0][0] == keys[0][0][0]) & (str_pair[1][0] == keys[0][0][1]):
                to_add = keys[1][0]
                break
        new_str_pairs_l.append((str_pair[0][0], to_add))
        new_str_pairs_l.append((to_add, str_pair[1][0]))
    str_pairs_l = new_str_pairs_l
    i = i + 1

strout = pairs_To_String(str_pairs_l)

count = Counter(strout)
all_values = count.values()
max_value = max(all_values)
min_value = min(all_values)
result = max_value - min_value
print(result)