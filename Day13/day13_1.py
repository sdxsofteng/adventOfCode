import urllib.request
import re
import numpy as np
import string

req = urllib.request.Request("https://adventofcode.com/2021/day/13/input")
req.add_header('Cookie', 'session=53616c7465645f5f22019c1eec2e8cbe842a8672490a2bc7b81cd64d7503fbe673aec662e0edebc8222eb56c2361dd50')

content = urllib.request.urlopen(req).read()
content = content.decode('utf-8')

#####
conten = open("test.txt")
content = conten.read()

#####
contentsep = content.split("\n\n")
data = contentsep[0]
instruc = contentsep[1]
lines = data.splitlines()
pairs = np.empty((0,2), int)
for line in lines:
    miniarray = line.split(",")
    newArray = [[miniarray[0], miniarray[1]]]
    pairs = np.concatenate((pairs, newArray))
pairs2 = pairs.astype(np.int32)
#print(pairs2)


def foldy(v,y):
    if v > y:
        return v - y + 1
    else:
        return v

instrucLines = instruc.splitlines()
#for instrucLine in instrucLines:

instrucLine = instrucLines[0]
miniarray2 = instrucLine.split(" ")
temp = miniarray2[2].split("=")
miniarray3 = [miniarray2[0], miniarray2[1], temp[0], temp[1]]
if temp[0] == "y":
    for pair in pairs2:
        pair[1] = foldy(pair[1],int(temp[1]))
elif temp[0] == "x":
    for pair in pairs2:
        pair[0] = foldy(pair[0],int(temp[1]))
a = 0
while a < pairs2.shape[0] - 1:
    x = pairs2[a][0]
    y = pairs2[a][1]
    b = 0
    while b < pairs2.shape[0] - 1:
        if (a == b & b != (pairs2.shape[0] - 1)):
            b = b + 1
        elif (x == pairs2[b][0] & y == pairs2[b][1]):
            pairs2 = np.delete(pairs2, b, axis=0)
            pairs2.shape[0] == pairs2.shape[0] - 1
        else:
            b = b + 1
    a = a + 1


print(pairs2.shape[0])