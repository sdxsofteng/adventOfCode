from __future__ import annotations
import urllib.request
import re
import numpy as np
import string

def print_p(points: set[tuple[int,int]]):
    max_x = max(x for x, _ in points) # Dans le fond ici on dit de trouver le x max dans x,y mais on se fou du y dans le set
    max_y = max(y for _, y in points)

    for y in range(0, max_y + 1):
        for x in range(0, max_x + 1):
            if (x,y) in points:
                print('#', end='') #equiv a print vs pas de end = println
            else:
                print(' ', end='')
        print()

######Page Request#######
req = urllib.request.Request("https://adventofcode.com/2021/day/13/input")
req.add_header('Cookie', 'session=53616c7465645f5f22019c1eec2e8cbe842a8672490a2bc7b81cd64d7503fbe673aec662e0edebc8222eb56c2361dd50')

content = urllib.request.urlopen(req).read()
content = content.decode('utf-8')

#conten = open("test.txt")
#content = conten.read()

######Parsing############
points, instructions = content.split('\n\n')

pset = set()
for line in points.splitlines():
    x, y = line.split(',')
    pset.add((int(x), int(y)))

for line in instructions.splitlines():
    inst_text_s, number_s = line.split("=")
    axis = inst_text_s[-1]
    numb = int(number_s)

    if axis == 'x':
        pset = {
            (
                x if x < numb else numb - (x - numb),
                y,
            )
            for x,y in pset
        }
    elif axis == 'y':
        pset = {
            (
                x,
                y if y < numb else numb - (y - numb),
            )
            for x, y in pset
        }
    else:
        raise AssertionError(f'unexpected axis: {axis}')

print_p(pset)
