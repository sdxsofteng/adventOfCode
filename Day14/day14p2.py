import urllib.request
from collections import Counter

req = urllib.request.Request("https://adventofcode.com/2021/day/14/input")
req.add_header('Cookie', 'session=53616c7465645f5f22019c1eec2e8cbe842a8672490a2bc7b81cd64d7503fbe673aec662e0edebc8222eb56c2361dd50')

content = urllib.request.urlopen(req).read()
content = content.decode('utf-8')

#conten = open("test.txt")
#content = conten.read()

start_str, keys = content.split("\n\n")

keys_parsed = list()

for key in keys.splitlines():
    result_keys = list()
    key_p, value = key.split(" -> ")
    result_keys.append((key_p[0] + value))
    result_keys.append((value + key_p[1]))
    keys_parsed.append((key_p, result_keys))

counted_keys = list()
for count_key in keys.splitlines():
    key, trash = count_key.split(" -> ")
    counted_keys.append(key)


total_count = Counter(counted_keys)

for count in total_count:
    total_count[count] = 0

x = 0
while( x < len(start_str) - 1):
    total_count[start_str[x] + start_str[x+1]] += 1
    x += 1

y = 0

temp = Counter(counted_keys)
for counted_k in temp:
    temp[counted_k] = 0


while(y < 40):
    for count_key in total_count:
        if total_count[count_key] >= 1:
            #keys_parsed[counted_keys.index(count_key)] // ('CB', ['CH', 'HB'])
            value = keys_parsed[counted_keys.index(count_key)]
            temp_add = total_count[count_key]
            temp[value[1][0]] += temp_add
            temp[value[1][1]] += temp_add
    total_count = temp
    temp = Counter(counted_keys)
    for counted_k in temp:
        temp[counted_k] = 0
    y += 1

new_dict = dict()
#total count dictionnaire de depart
for key_dict1 in total_count:
    if(key_dict1[0] in new_dict):
        new_dict[key_dict1[0]] += total_count[key_dict1]
    else:
        new_dict[key_dict1[0]] = total_count[key_dict1]
    if(key_dict1[1] in new_dict):
        new_dict[key_dict1[1]] += total_count[key_dict1]
    else:
        new_dict[key_dict1[1]] = total_count[key_dict1]

for toto in new_dict:
    if new_dict[toto] % 2 == 1:
        new_dict[toto] = new_dict[toto] // 2 + 1
    else:
        new_dict[toto] //= 2

valuesdict = new_dict.values()
max_value = max(valuesdict)
min_value = min(valuesdict)
result = max_value - min_value
print(result)

